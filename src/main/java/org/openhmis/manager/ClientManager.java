package org.openhmis.manager;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.openhmis.dto.search.ClientSearchDTO;
import org.openhmis.exception.InvalidParameterException;
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

	public List<ClientDTO> getClients(ClientSearchDTO searchDTO) {
		List<ClientDTO> clientDTOs = new ArrayList<ClientDTO>();
		
		// Collect the clients
		List<PathClient> pathClients = pathClientDAO.getPathClients(searchDTO);
		
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
		// Validate the client
		if(!validateClient(inputDTO))
			return null;
		
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
		// Validate the client
		if(!validateClient(inputDTO))
			return null;

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
	
	public boolean validateClient(ClientDTO inputDTO) {
		// Universal Data Standard: Name (2014, 3.1)
		// 3.1.5 Name Data Quality
		if(inputDTO.getNameDataQuality() == ClientNameDataQuality.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.1.5 nameDataQuality", "nameDataQuality is set to an unknown code");

		// Universal Data Standard: SSN (2014, 3.2)
		// 3.2.1 SSN
		// The letter x is the only permissible nonnumeric character and should be used to indicate the position of omitted digits
		// ^[0-9xX]{9}$
		Pattern validSsn = Pattern.compile("^[0-9xX]{9}$");
                // need to check whether SSN is in input first
                String ssn = inputDTO.getSsn();
                if (ssn != null) {
                    Matcher ssnMatcher = validSsn.matcher(ssn);
                    if(ssn != null
                       && !ssnMatcher.find())
			throw new InvalidParameterException("HUD 3.2.1 (SSN)", "SSN must match the pattern ^[0-9xX]{9}$");
                }
		// 3.2.2 SSN Data Quality
		if(inputDTO.getSsnDataQuality() == ClientSsnDataQuality.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.2.2 ssnDataQuality", "ssnDataQuality is set to an unknown code");
		
		// Universal Data Standard: Date of Birth  (2014, 3.3)
		
		// 3.3.1 DOB
		// Must be before today
		Date now = new Date();
		if(inputDTO.getDob() != null
		&& now.compareTo(inputDTO.getDob()) < 0)
			throw new InvalidParameterException("HUD 3.3.1 (DOB)", "Date of birth must be in the past");

		// 3.3.2 DOB Data Quality
		if(inputDTO.getDobDataQuality() == ClientDobDataQuality.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.3.2 dobDataQuality", "dobDataQuality is set to an unknown code");

		// Universal Data Standard: Race (2014, 3.4)
		// 3.4.1 Asian
		if(inputDTO.getAsian() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 Asian", "Asian is set to an unknown code");

		// 3.4.1 BlackAfAmerican
		if(inputDTO.getBlackAfAmerican() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 BlackAfAmerican", "BlackAfAmerican is set to an unknown code");

		// 3.4.1 NativeHIOtherPacific
		if(inputDTO.getNativeHIOtherPacific() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 NativeHIOtherPacific", "NativeHIOtherPacific is set to an unknown code");

		// 3.4.1 AmIndAKNative
		if(inputDTO.getAmIndAKNative() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 AmIndAKNative", "AmIndAKNative is set to an unknown code");

		// 3.4.1 AmIndAKNative
		if(inputDTO.getWhite() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 White", "White is set to an unknown code");

		// 3.4.1 RaceNone
		// Non-null only if all other Race fields = 0 or 99
		if((inputDTO.getAsian() == YesNo.YES
		 || inputDTO.getBlackAfAmerican() == YesNo.YES
		 || inputDTO.getNativeHIOtherPacific() == YesNo.YES
		 || inputDTO.getAmIndAKNative() == YesNo.YES
		 || inputDTO.getWhite() == YesNo.YES)
		&& inputDTO.getRaceNone() != null)
			throw new InvalidParameterException("HUD 3.4.1 RaceNone", "RaceNone can be non-null only if all other Race fields = 0 or 99");

		if(inputDTO.getRaceNone() == None.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 RaceNone", "RaceNone is set to an unknown code");
		
		// Universal Data Standard: Ethnicity (2014, 3.5)
		if(inputDTO.getEthnicity() == ClientEthnicity.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.5 Ethnicity", "Ethnicity is set to an unknown code");
		
		// Universal Data Standard: Gender (2014, 3.6)
		if(inputDTO.getGender() == ClientGender.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.6 Ethnicity", "Gender is set to an unknown code");

		// Universal Data Standard: Veteran Status (2014, 3.7)
		if(inputDTO.getVeteranStatus() == YesNoReason.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.7 Veteran Status", "Veteran Status is set to an unknown code");
		
		// VA Specific Data Standards: Veteran's Information (2014, 4.41)
		// TODO: validate 4.41 fields
		
		return true;
	}
	
	public static ClientDTO generateClientDTO(PathClient pathClient, List<PathClientRace> pathRaces, PathClientVeteranInfo pathVeteranInfo) {
		ClientDTO clientDTO = new ClientDTO();

		// Universal Data Standard: Personal ID (2014, 3.13) 
		if(pathClient.getClientKey() != null)
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
		if(pathRaces == null) {
			pathRaces = new ArrayList<PathClientRace>();
		}

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
		if(pathClient.getEthnicityKey() != null) {
			switch(pathClient.getEthnicityKey()) {
				case 104: 
					clientDTO.setEthnicity(ClientEthnicity.NON_HISPANIC);
					break;
				case 105:
					clientDTO.setEthnicity(ClientEthnicity.HISPANIC);
					break;
				default:
					clientDTO.setEthnicity(ClientEthnicity.valueByCode(pathClient.getEthnicityKey()));
					break;
			}
		}
		
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
		switch(clientDTO.getEthnicity()) {
			case NON_HISPANIC: 
				pathClient.setEthnicityKey(104);
				break;
			case HISPANIC:
				pathClient.setEthnicityKey(105);
				break;
			default:
				pathClient.setEthnicityKey(clientDTO.getEthnicity().getCode());
				break;
		}

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
