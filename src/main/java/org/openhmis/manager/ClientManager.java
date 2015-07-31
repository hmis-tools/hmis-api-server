package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openhmis.code.ClientDischargeStatus;
import org.openhmis.code.ClientDobDataQuality;
import org.openhmis.code.ClientEthnicity;
import org.openhmis.code.ClientGender;
import org.openhmis.code.ClientMilitaryBranch;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.code.ClientSsnDataQuality;
import org.openhmis.code.None;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.PathClientDAO;
import org.openhmis.dao.PathClientRaceDAO;
import org.openhmis.dao.PathClientVeteranInfoDAO;
import org.openhmis.domain.PathClient;
import org.openhmis.domain.PathClientRace;
import org.openhmis.domain.PathClientVeteranInfo;
import org.openhmis.exception.client.ClientNotFoundException;
import org.openhmis.manager.ClientManager;
import org.openhmis.vo.ClientVO;

public class ClientManager {

	private static final PathClientDAO pathClientDAO = new PathClientDAO();
	private static final PathClientRaceDAO pathClientRaceDAO = new PathClientRaceDAO();
	private static final PathClientVeteranInfoDAO pathClientVeteranInfoDAO = new PathClientVeteranInfoDAO();
	
	public ClientManager() {}

	public ClientVO getClientByPersonalId(String personalId) throws ClientNotFoundException {
		Integer clientKey = Integer.parseInt(personalId);
		
		// Collect the data for this client
		PathClient pathClient = pathClientDAO.getPathClientByClientKey(clientKey);
		List<PathClientRace> pathRaces = pathClientRaceDAO.getPathRacesByClientKey(clientKey);
		PathClientVeteranInfo pathVeteranInfo = pathClientVeteranInfoDAO.getPathVeteranInfoByClientKey(clientKey);
		
		ClientVO clientVO = ClientManager.generateClientVO(pathClient, pathRaces, pathVeteranInfo);

		return clientVO;
	}

	public List<ClientVO> getClients() {
		List<ClientVO> clientVOs = new ArrayList<ClientVO>();
		
		// Collect the clients
		List<PathClient> pathClients = pathClientDAO.getPathClients();
		
		// For each client, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<PathClient> iterator = pathClients.iterator(); iterator.hasNext();) {
			PathClient pathClient = iterator.next();
			Integer clientKey = pathClient.getClientKey();
			List<PathClientRace> pathRaces = pathClientRaceDAO.getPathRacesByClientKey(clientKey);
			PathClientVeteranInfo pathVeteranInfo = pathClientVeteranInfoDAO.getPathVeteranInfoByClientKey(clientKey);

			ClientVO clientVO = ClientManager.generateClientVO(pathClient, pathRaces, pathVeteranInfo);
			clientVOs.add(clientVO);
		}
		
		return clientVOs;
	}
	
	public ClientVO addClient(ClientVO inputVO) {
		
		// Generate a PathClient from the input
		PathClient pathClient = ClientManager.generatePathClient(inputVO);
		
		// Set Export fields
		pathClient.setUpdateDate(new Date());
		pathClient.setCreateDate(new Date());
		
		// Set Compass Required Fields
		pathClient.setUpdateTimestamp(new Date());

		// Save the client to allow secondary object generation
		pathClientDAO.save(pathClient);
		inputVO.setPersonalId(pathClient.getClientKey().toString());
		
		// Save the races
		List<PathClientRace> pathRaces = ClientManager.generatePathClientRaces(inputVO);
		for (Iterator<PathClientRace> iterator = pathRaces.iterator(); iterator.hasNext();) {
			PathClientRace pathRace = iterator.next();
			pathRace.setUpdateTimestamp(new Date());
			pathClientRaceDAO.save(pathRace);
		}

		// Save Veteran Info
		PathClientVeteranInfo pathVeteranInfo = ClientManager.generatePathVeteranInfo(inputVO);
		pathVeteranInfo.setUpdateTimestamp(new Date());
		pathVeteranInfo.setClientKey(pathClient.getClientKey());
		pathClientVeteranInfoDAO.save(pathVeteranInfo);
		
		// Return the resulting VO
		return ClientManager.generateClientVO(pathClient, pathRaces, pathVeteranInfo);
	}
	
	public ClientVO updateClient(ClientVO inputVO) {
		
		// Generate a PathClient from the input
		PathClient pathClient = ClientManager.generatePathClient(inputVO);
		pathClient.setClientKey(Integer.parseInt(inputVO.getPersonalId()));
		pathClient.setUpdateDate(new Date());
		pathClient.setUpdateTimestamp(new Date());
		
		// Update the client
		pathClientDAO.update(pathClient);

		// Delete old races
		List<PathClientRace> oldPathRaces = pathClientRaceDAO.getPathRacesByClientKey(pathClient.getClientKey());
		for (Iterator<PathClientRace> iterator = oldPathRaces.iterator(); iterator.hasNext();) {
			PathClientRace oldPathRace = iterator.next();
			pathClientRaceDAO.delete(oldPathRace);
		}
		
		// Save new races
		List<PathClientRace> newPathRaces = ClientManager.generatePathClientRaces(inputVO);
		for (Iterator<PathClientRace> iterator = newPathRaces.iterator(); iterator.hasNext();) {
			PathClientRace newPathRace = iterator.next();
			newPathRace.setUpdateTimestamp(new Date());
			pathClientRaceDAO.save(newPathRace);
		}
		
		// Update Veteran Info
		// NOTE: client key is the primary key, so we don't need to look up any stored values
		PathClientVeteranInfo pathVeteranInfo = ClientManager.generatePathVeteranInfo(inputVO);
		pathVeteranInfo.setUpdateTimestamp(new Date());
		pathClientVeteranInfoDAO.update(pathVeteranInfo);

		// Return the resulting VO
		return ClientManager.generateClientVO(pathClient, newPathRaces, pathVeteranInfo);
	}
	
	public boolean deleteClient(String personalId) {
		PathClient pathClient = pathClientDAO.getPathClientByClientKey(Integer.parseInt(personalId));
		pathClientDAO.delete(pathClient);

		// Delete associated races
		List<PathClientRace> pathRaces = pathClientRaceDAO.getPathRacesByClientKey(pathClient.getClientKey());
		for (Iterator<PathClientRace> iterator = pathRaces.iterator(); iterator.hasNext();) {
			PathClientRace pathRace = iterator.next();
			pathClientRaceDAO.delete(pathRace);
		}
		
		// Delete associated veteran info
		PathClientVeteranInfo pathClientVeteranInfo = pathClientVeteranInfoDAO.getPathVeteranInfoByClientKey(pathClient.getClientKey());
		pathClientVeteranInfoDAO.delete(pathClientVeteranInfo);
		
		return true;
	}
	
	public static ClientVO generateClientVO(PathClient pathClient, List<PathClientRace> pathRaces, PathClientVeteranInfo pathVeteranInfo) {
		ClientVO clientVO = new ClientVO();
		// Universal Data Standard: Personal ID (2014, 3.13) 
		clientVO.setPersonalId(pathClient.getClientKey().toString());

		// Universal Data Standard: Name (2014, 3.1)
		clientVO.setFirstName(pathClient.getFirstName());
		clientVO.setMiddleName(pathClient.getMiddleName());
		clientVO.setLastName(pathClient.getLastName());
		clientVO.setNameSuffix(pathClient.getSuffix());
		clientVO.setNameDataQuality(ClientNameDataQuality.valueByCode(pathClient.getNameType()));

		// Universal Data Standard: SSN (2014, 3.2)
		clientVO.setSsn(pathClient.getIdentification());
		clientVO.setSsnDataQuality(ClientSsnDataQuality.valueByCode(pathClient.getIdType()));
		
		// Universal Data Standard: Date of Birth  (2014, 3.3)
		clientVO.setDob(pathClient.getDateOfBirth());
		clientVO.setDobDataQuality(ClientDobDataQuality.valueByCode(pathClient.getDobType()));

		// Universal Data Standard: Race (2014, 3.4)
		// Pathways stores races as individual records
		// if no records exist, that is "None", otherwise set the fields 
		if(pathRaces.size() == 0) {
			clientVO.setRaceNone(None.NOT_COLLECTED);
		}
		else {
			clientVO.setAsian(YesNo.NO);
			clientVO.setBlackAfAmerican(YesNo.NO);
			clientVO.setNativeHIOtherPacific(YesNo.NO);
			clientVO.setAmIndAKNative(YesNo.NO);
			clientVO.setWhite(YesNo.NO);
		}
		
		for (Iterator<PathClientRace> iterator = pathRaces.iterator(); iterator.hasNext();) {
			PathClientRace race = iterator.next();
			
			// Compass stores races as specialized codes
			// See: https://github.com/PCNI/OpenHMIS/blob/feature-compass_schema/docs/API_to_Schema_Mapping.md
			switch(race.getRaceKey()) {
				case 5:
					clientVO.setAsian(YesNo.YES);
					break;
				case 6:
					clientVO.setBlackAfAmerican(YesNo.YES);
					break;
				case 7:
					clientVO.setAmIndAKNative(YesNo.YES);
					break;
				case 8:
					clientVO.setWhite(YesNo.YES);
					break;
				case 9:
					clientVO.setNativeHIOtherPacific(YesNo.YES);
					break;
				default:
					break;
			}

			// Compass stores race none and race in the same table
			None noneCode = None.valueByCode(race.getRaceKey());
			if(noneCode != null) {
				switch (noneCode) {
					case REFUSED:
						clientVO.setRaceNone(None.REFUSED);
						break;
					case UNKNOWN:
						clientVO.setRaceNone(None.UNKNOWN);
						break;
					default:
						break;
				}
			}
		}

		// Universal Data Standard: Ethnicity (2014, 3.5)
		clientVO.setEthnicity(ClientEthnicity.valueByCode(pathClient.getEthnicityKey()));

		// Universal Data Standard: Gender (2014, 3.6)
		clientVO.setGender(ClientGender.valueByCode(pathClient.getGenderKey()));
		clientVO.setOtherGender(pathClient.getGenderDesc());

		// Universal Data Standard: Veteran Status (2014, 3.7)
		clientVO.setVeteranStatus(YesNoReason.valueByCode(pathClient.getVeteran()));

		// VA Specific Data Standards: Veteran's Information (2014, 4.41)
		if(pathVeteranInfo != null) {
			clientVO.setYearEnteredService(pathVeteranInfo.getYrEnterMilitary());
			clientVO.setYearSeparated(pathVeteranInfo.getYrSepMilitary());
			clientVO.setWorldWarII(YesNoReason.valueByCode(pathVeteranInfo.getWorldWarIi()));
			clientVO.setKoreanWar(YesNoReason.valueByCode(pathVeteranInfo.getKoreanWar()));
			clientVO.setVietnamWar(YesNoReason.valueByCode(pathVeteranInfo.getVietnamWar()));
			clientVO.setDesertStorm(YesNoReason.valueByCode(pathVeteranInfo.getPersianWar()));
			clientVO.setAfghanistanOEF(YesNoReason.valueByCode(pathVeteranInfo.getAfghanistanWar()));
			clientVO.setIraqOIF(YesNoReason.valueByCode(pathVeteranInfo.getIraqFreedom()));
			clientVO.setIraqOND(YesNoReason.valueByCode(pathVeteranInfo.getIraqDawn()));
			clientVO.setOtherTheater(YesNoReason.valueByCode(pathVeteranInfo.getOther()));
			clientVO.setMilitaryBranch(ClientMilitaryBranch.valueByCode(pathVeteranInfo.getMilitaryBranch()));
			clientVO.setDischargeStatus(ClientDischargeStatus.valueByCode(pathVeteranInfo.getDischargeStatus()));
		}
		
		// Export Standard Fields
		clientVO.setDateCreated(pathClient.getCreateDate());
		clientVO.setDateUpdated(pathClient.getUpdateDate());

		return clientVO;
	}
	

	public static PathClient generatePathClient(ClientVO clientVO) {
		PathClient pathClient = new PathClient();

		// Universal Data Standard: Name (2014, 3.1)
		pathClient.setFirstName(clientVO.getFirstName());
		pathClient.setMiddleName(clientVO.getMiddleName());
		pathClient.setLastName(clientVO.getLastName());
		pathClient.setSuffix(clientVO.getNameSuffix());
		pathClient.setNameType(clientVO.getNameDataQuality().getCode());
		
		// Universal Data Standard: SSN (2014, 3.2)
		pathClient.setIdentification(clientVO.getSsn());
		pathClient.setIdType(clientVO.getSsnDataQuality().getCode());
		
		// Universal Data Standard: Date of Birth  (2014, 3.3)
		pathClient.setDateOfBirth(clientVO.getDob());
		pathClient.setDobType(clientVO.getDobDataQuality().getCode());
		
		// Universal Data Standard: Ethnicity (2014, 3.5)
		pathClient.setEthnicityKey(clientVO.getEthnicity().getCode());

		// Universal Data Standard: Gender (2014, 3.6)
		pathClient.setGenderKey(clientVO.getGender().getCode());
		pathClient.setGenderDesc(clientVO.getOtherGender());

		// Universal Data Standard: Veteran Status (2014, 3.7)
		pathClient.setVeteran(clientVO.getVeteranStatus().getCode());

		return pathClient;
	}
	

	public static List<PathClientRace> generatePathClientRaces(ClientVO clientVO) {

		// Universal Data Standard: Race (2014, 3.4)
		// Convert HUD race storage to Compass Rose race codes
		// (Compass rose race codes currently have no canonical reference)
		List<PathClientRace> pathRaces = new ArrayList<PathClientRace>();
		List<Integer> raceCodes = new ArrayList<Integer>();
		
		if(clientVO.getAsian() == YesNo.YES)
			raceCodes.add(5);
		if(clientVO.getBlackAfAmerican() == YesNo.YES)
			raceCodes.add(6);
		if(clientVO.getNativeHIOtherPacific() == YesNo.YES)
			raceCodes.add(9);
		if(clientVO.getAmIndAKNative() == YesNo.YES)
			raceCodes.add(7);
		if(clientVO.getWhite() == YesNo.YES)
			raceCodes.add(8);
		if(clientVO.getRaceNone() != null)
			raceCodes.add(clientVO.getRaceNone().getCode());

		// Create race objects for each code
		for (Iterator<Integer> iterator = raceCodes.iterator(); iterator.hasNext();) {
			Integer raceCode = iterator.next();
			PathClientRace race = new PathClientRace();
			race.setClientKey(Integer.parseInt(clientVO.getPersonalId()));
			race.setRaceKey(raceCode);
			pathRaces.add(race);
		}
		return pathRaces;
	}
	
	
	public static PathClientVeteranInfo generatePathVeteranInfo(ClientVO clientVO) {

		// VA Specific Data Standards: Veteran's Information (2014, 4.41)
		PathClientVeteranInfo veteranInfo = new PathClientVeteranInfo();
		veteranInfo.setClientKey(Integer.parseInt(clientVO.getPersonalId()));
		veteranInfo.setYrEnterMilitary(clientVO.getYearEnteredService());
		veteranInfo.setYrSepMilitary(clientVO.getYearSeparated());
		veteranInfo.setWorldWarIi(clientVO.getWorldWarII().getCode());
		veteranInfo.setKoreanWar(clientVO.getKoreanWar().getCode());
		veteranInfo.setVietnamWar(clientVO.getVietnamWar().getCode());
		veteranInfo.setPersianWar(clientVO.getDesertStorm().getCode());
		veteranInfo.setAfghanistanWar(clientVO.getAfghanistanOEF().getCode());
		veteranInfo.setIraqFreedom(clientVO.getIraqOIF().getCode());
		veteranInfo.setIraqDawn(clientVO.getIraqOND().getCode());
		veteranInfo.setOther(clientVO.getOtherTheater().getCode());
		veteranInfo.setMilitaryBranch(clientVO.getMilitaryBranch().getCode());
		veteranInfo.setDischargeStatus(clientVO.getDischargeStatus().getCode());
		return veteranInfo;
	}
	
}