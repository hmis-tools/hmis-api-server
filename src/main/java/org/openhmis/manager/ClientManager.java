package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import org.openhmis.dto.ClientDTO;
import org.openhmis.manager.ClientManager;

public class ClientManager {

	private static final PathClientDAO pathClientDAO = new PathClientDAO();
	private static final PathClientRaceDAO pathClientRaceDAO = new PathClientRaceDAO();
	private static final PathClientVeteranInfoDAO pathClientVeteranInfoDAO = new PathClientVeteranInfoDAO();
	
	public ClientManager() {}

	public ClientDTO getClientByPersonalId(String personalId) {
		Integer clientKey = Integer.parseInt(personalId);
		
		// Collect the data for this client
		PathClient pathClient = pathClientDAO.getPathClientByClientKey(clientKey);
		List<PathClientRace> pathRaces = pathClientRaceDAO.getPathRacesByClientKey(clientKey);
		PathClientVeteranInfo pathVeteranInfo = pathClientVeteranInfoDAO.getPathVeteranInfoByClientKey(clientKey);
		
		ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathRaces, pathVeteranInfo);

		return clientDTO;
	}

	public List<ClientDTO> getClients() {
		List<ClientDTO> clientDTOs = new ArrayList<ClientDTO>();
		
		// Collect the clients
		List<PathClient> pathClients = pathClientDAO.getPathClients();
		
		// For each client, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<PathClient> iterator = pathClients.iterator(); iterator.hasNext();) {
			PathClient pathClient = iterator.next();
			Integer clientKey = pathClient.getClientKey();
			List<PathClientRace> pathRaces = pathClientRaceDAO.getPathRacesByClientKey(clientKey);
			PathClientVeteranInfo pathVeteranInfo = pathClientVeteranInfoDAO.getPathVeteranInfoByClientKey(clientKey);

			ClientDTO clientDTO = ClientManager.generateClientDTO(pathClient, pathRaces, pathVeteranInfo);
			clientDTOs.add(clientDTO);
		}
		
		return clientDTOs;
	}
	
	public ClientDTO addClient(ClientDTO inputDTO) {
		
		// Generate a PathClient from the input
		PathClient pathClient = ClientManager.generatePathClient(inputDTO);
		
		// Set Export fields
		pathClient.setUpdateDate(new Date());
		pathClient.setCreateDate(new Date());
		
		// Set Compass Required Fields
		pathClient.setUpdateTimestamp(new Date());

		// Save the client to allow secondary object generation
		pathClientDAO.save(pathClient);
		inputDTO.setPersonalId(pathClient.getClientKey().toString());
		
		// Save the races
		List<PathClientRace> pathRaces = ClientManager.generatePathClientRaces(inputDTO);
		for (Iterator<PathClientRace> iterator = pathRaces.iterator(); iterator.hasNext();) {
			PathClientRace pathRace = iterator.next();
			pathRace.setUpdateTimestamp(new Date());
			pathClientRaceDAO.save(pathRace);
		}

		// Save Veteran Info
		PathClientVeteranInfo pathVeteranInfo = ClientManager.generatePathVeteranInfo(inputDTO);
		pathVeteranInfo.setUpdateTimestamp(new Date());
		pathVeteranInfo.setClientKey(pathClient.getClientKey());
		pathClientVeteranInfoDAO.save(pathVeteranInfo);
		
		// Return the resulting VO
		return ClientManager.generateClientDTO(pathClient, pathRaces, pathVeteranInfo);
	}
	
	public ClientDTO updateClient(ClientDTO inputDTO) {
		
		// Generate a PathClient from the input
		PathClient pathClient = ClientManager.generatePathClient(inputDTO);
		pathClient.setClientKey(Integer.parseInt(inputDTO.getPersonalId()));
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
		List<PathClientRace> newPathRaces = ClientManager.generatePathClientRaces(inputDTO);
		for (Iterator<PathClientRace> iterator = newPathRaces.iterator(); iterator.hasNext();) {
			PathClientRace newPathRace = iterator.next();
			newPathRace.setUpdateTimestamp(new Date());
			pathClientRaceDAO.save(newPathRace);
		}
		
		// Update Veteran Info
		// NOTE: client key is the primary key, so we don't need to look up any stored values
		PathClientVeteranInfo pathVeteranInfo = ClientManager.generatePathVeteranInfo(inputDTO);
		pathVeteranInfo.setUpdateTimestamp(new Date());
		pathClientVeteranInfoDAO.update(pathVeteranInfo);

		// Return the resulting VO
		return ClientManager.generateClientDTO(pathClient, newPathRaces, pathVeteranInfo);
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
	
	public static ClientDTO generateClientDTO(PathClient pathClient, List<PathClientRace> pathRaces, PathClientVeteranInfo pathVeteranInfo) {
		ClientDTO clientDTO = new ClientDTO();
		// Universal Data Standard: Personal ID (2014, 3.13) 
		clientDTO.setPersonalId(pathClient.getClientKey().toString());

		// Universal Data Standard: Name (2014, 3.1)
		clientDTO.setFirstName(pathClient.getFirstName());
		clientDTO.setMiddleName(pathClient.getMiddleName());
		clientDTO.setLastName(pathClient.getLastName());
		clientDTO.setNameSuffix(pathClient.getSuffix());
		clientDTO.setNameDataQuality(ClientNameDataQuality.valueByCode(pathClient.getNameType()));

		// Universal Data Standard: SSN (2014, 3.2)
		clientDTO.setSsn(pathClient.getIdentification());
		clientDTO.setSsnDataQuality(ClientSsnDataQuality.valueByCode(pathClient.getIdType()));
		
		// Universal Data Standard: Date of Birth  (2014, 3.3)
		clientDTO.setDob(pathClient.getDateOfBirth());
		clientDTO.setDobDataQuality(ClientDobDataQuality.valueByCode(pathClient.getDobType()));

		// Universal Data Standard: Race (2014, 3.4)
		// Pathways stores races as individual records
		// if no records exist, that is "None", otherwise set the fields 
		if(pathRaces.size() == 0) {
			clientDTO.setRaceNone(None.NOT_COLLECTED);
		}
		else {
			clientDTO.setAsian(YesNo.NO);
			clientDTO.setBlackAfAmerican(YesNo.NO);
			clientDTO.setNativeHIOtherPacific(YesNo.NO);
			clientDTO.setAmIndAKNative(YesNo.NO);
			clientDTO.setWhite(YesNo.NO);
		}
		
		for (Iterator<PathClientRace> iterator = pathRaces.iterator(); iterator.hasNext();) {
			PathClientRace race = iterator.next();
			
			// Compass stores races as specialized codes
			// See: https://github.com/PCNI/OpenHMIS/blob/feature-compass_schema/docs/API_to_Schema_Mapping.md
			switch(race.getRaceKey()) {
				case 5:
					clientDTO.setAsian(YesNo.YES);
					break;
				case 6:
					clientDTO.setBlackAfAmerican(YesNo.YES);
					break;
				case 7:
					clientDTO.setAmIndAKNative(YesNo.YES);
					break;
				case 8:
					clientDTO.setWhite(YesNo.YES);
					break;
				case 9:
					clientDTO.setNativeHIOtherPacific(YesNo.YES);
					break;
				default:
					break;
			}

			// Compass stores race none and race in the same table
			None noneCode = None.valueByCode(race.getRaceKey());
			if(noneCode != null) {
				switch (noneCode) {
					case REFUSED:
						clientDTO.setRaceNone(None.REFUSED);
						break;
					case UNKNOWN:
						clientDTO.setRaceNone(None.UNKNOWN);
						break;
					default:
						break;
				}
			}
		}

		// Universal Data Standard: Ethnicity (2014, 3.5)
		clientDTO.setEthnicity(ClientEthnicity.valueByCode(pathClient.getEthnicityKey()));

		// Universal Data Standard: Gender (2014, 3.6)
		clientDTO.setGender(ClientGender.valueByCode(pathClient.getGenderKey()));
		clientDTO.setOtherGender(pathClient.getGenderDesc());

		// Universal Data Standard: Veteran Status (2014, 3.7)
		clientDTO.setVeteranStatus(YesNoReason.valueByCode(pathClient.getVeteran()));

		// VA Specific Data Standards: Veteran's Information (2014, 4.41)
		if(pathVeteranInfo != null) {
			clientDTO.setYearEnteredService(pathVeteranInfo.getYrEnterMilitary());
			clientDTO.setYearSeparated(pathVeteranInfo.getYrSepMilitary());
			clientDTO.setWorldWarII(YesNoReason.valueByCode(pathVeteranInfo.getWorldWarIi()));
			clientDTO.setKoreanWar(YesNoReason.valueByCode(pathVeteranInfo.getKoreanWar()));
			clientDTO.setVietnamWar(YesNoReason.valueByCode(pathVeteranInfo.getVietnamWar()));
			clientDTO.setDesertStorm(YesNoReason.valueByCode(pathVeteranInfo.getPersianWar()));
			clientDTO.setAfghanistanOEF(YesNoReason.valueByCode(pathVeteranInfo.getAfghanistanWar()));
			clientDTO.setIraqOIF(YesNoReason.valueByCode(pathVeteranInfo.getIraqFreedom()));
			clientDTO.setIraqOND(YesNoReason.valueByCode(pathVeteranInfo.getIraqDawn()));
			clientDTO.setOtherTheater(YesNoReason.valueByCode(pathVeteranInfo.getOther()));
			clientDTO.setMilitaryBranch(ClientMilitaryBranch.valueByCode(pathVeteranInfo.getMilitaryBranch()));
			clientDTO.setDischargeStatus(ClientDischargeStatus.valueByCode(pathVeteranInfo.getDischargeStatus()));
		}
		
		// Export Standard Fields
		clientDTO.setDateCreated(pathClient.getCreateDate());
		clientDTO.setDateUpdated(pathClient.getUpdateDate());

		return clientDTO;
	}
	

	public static PathClient generatePathClient(ClientDTO clientDTO) {
		PathClient pathClient = new PathClient();

		// Universal Data Standard: Name (2014, 3.1)
		pathClient.setFirstName(clientDTO.getFirstName());
		pathClient.setMiddleName(clientDTO.getMiddleName());
		pathClient.setLastName(clientDTO.getLastName());
		pathClient.setSuffix(clientDTO.getNameSuffix());
		pathClient.setNameType(clientDTO.getNameDataQuality().getCode());
		
		// Universal Data Standard: SSN (2014, 3.2)
		pathClient.setIdentification(clientDTO.getSsn());
		pathClient.setIdType(clientDTO.getSsnDataQuality().getCode());
		
		// Universal Data Standard: Date of Birth  (2014, 3.3)
		pathClient.setDateOfBirth(clientDTO.getDob());
		pathClient.setDobType(clientDTO.getDobDataQuality().getCode());
		
		// Universal Data Standard: Ethnicity (2014, 3.5)
		pathClient.setEthnicityKey(clientDTO.getEthnicity().getCode());

		// Universal Data Standard: Gender (2014, 3.6)
		pathClient.setGenderKey(clientDTO.getGender().getCode());
		pathClient.setGenderDesc(clientDTO.getOtherGender());

		// Universal Data Standard: Veteran Status (2014, 3.7)
		pathClient.setVeteran(clientDTO.getVeteranStatus().getCode());

		return pathClient;
	}
	

	public static List<PathClientRace> generatePathClientRaces(ClientDTO clientDTO) {

		// Universal Data Standard: Race (2014, 3.4)
		// Convert HUD race storage to Compass Rose race codes
		// (Compass rose race codes currently have no canonical reference)
		List<PathClientRace> pathRaces = new ArrayList<PathClientRace>();
		List<Integer> raceCodes = new ArrayList<Integer>();
		
		if(clientDTO.getAsian() == YesNo.YES)
			raceCodes.add(5);
		if(clientDTO.getBlackAfAmerican() == YesNo.YES)
			raceCodes.add(6);
		if(clientDTO.getNativeHIOtherPacific() == YesNo.YES)
			raceCodes.add(9);
		if(clientDTO.getAmIndAKNative() == YesNo.YES)
			raceCodes.add(7);
		if(clientDTO.getWhite() == YesNo.YES)
			raceCodes.add(8);
		if(clientDTO.getRaceNone() != null)
			raceCodes.add(clientDTO.getRaceNone().getCode());

		// Create race objects for each code
		for (Iterator<Integer> iterator = raceCodes.iterator(); iterator.hasNext();) {
			Integer raceCode = iterator.next();
			PathClientRace race = new PathClientRace();
			race.setClientKey(Integer.parseInt(clientDTO.getPersonalId()));
			race.setRaceKey(raceCode);
			pathRaces.add(race);
		}
		return pathRaces;
	}
	
	
	public static PathClientVeteranInfo generatePathVeteranInfo(ClientDTO clientDTO) {

		// VA Specific Data Standards: Veteran's Information (2014, 4.41)
		PathClientVeteranInfo veteranInfo = new PathClientVeteranInfo();
		veteranInfo.setClientKey(Integer.parseInt(clientDTO.getPersonalId()));
		veteranInfo.setYrEnterMilitary(clientDTO.getYearEnteredService());
		veteranInfo.setYrSepMilitary(clientDTO.getYearSeparated());
		veteranInfo.setWorldWarIi(clientDTO.getWorldWarII().getCode());
		veteranInfo.setKoreanWar(clientDTO.getKoreanWar().getCode());
		veteranInfo.setVietnamWar(clientDTO.getVietnamWar().getCode());
		veteranInfo.setPersianWar(clientDTO.getDesertStorm().getCode());
		veteranInfo.setAfghanistanWar(clientDTO.getAfghanistanOEF().getCode());
		veteranInfo.setIraqFreedom(clientDTO.getIraqOIF().getCode());
		veteranInfo.setIraqDawn(clientDTO.getIraqOND().getCode());
		veteranInfo.setOther(clientDTO.getOtherTheater().getCode());
		veteranInfo.setMilitaryBranch(clientDTO.getMilitaryBranch().getCode());
		veteranInfo.setDischargeStatus(clientDTO.getDischargeStatus().getCode());
		return veteranInfo;
	}
	
}