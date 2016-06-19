package org.openhmis.generator;


public class ClientGenerator {

	public ClientGenerator() {
	}

	public ClientDTO generateClientDTO(PathClient pathClient, List<PathClientRace> pathRaces, PathClientVeteranInfo pathVeteranInfo) {
		ClientDTO clientDTO = new ClientDTO();

		if(pathClient != null) {
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

			// Universal Data Standard: Gender (2014, 3.6)
			clientDTO.setGender(ClientGender.valueByCode(pathClient.getGenderKey()));
			clientDTO.setOtherGender(pathClient.getGenderDesc());

			// Universal Data Standard: Veteran Status (2014, 3.7)
			clientDTO.setVeteranStatus(YesNoReason.valueByCode(pathClient.getVeteran()));

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
			
			// Export Standard Fields
			clientDTO.setDateCreated(pathClient.getCreateDate());
			clientDTO.setDateUpdated(pathClient.getUpdateDate());
		}

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

		return clientDTO;
	}

	public PathClient generatePathClient(ClientDTO clientDTO) {
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

	public List<PathClientRace> generatePathClientRaces(ClientDTO clientDTO) {

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
	
	public PathClientVeteranInfo generatePathVeteranInfo(ClientDTO clientDTO) {

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