/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

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
import org.openhmis.code.ClientRace;
import org.openhmis.code.ClientSsnDataQuality;
import org.openhmis.code.None;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.ClientDAO;
import org.openhmis.dao.ClientRaceDAO;
import org.openhmis.dao.ClientVeteranInfoDAO;
import org.openhmis.domain.PathClient;
import org.openhmis.domain.PathClientRace;
import org.openhmis.domain.PathClientVeteranInfo;
import org.openhmis.exception.client.ClientNotFoundException;
import org.openhmis.exception.client.InValidClientException;
import org.openhmis.manager.ClientManager;
import org.openhmis.vo.ClientVO;

public class ClientManager {

	private static final ClientDAO clientDAO = new ClientDAO();
	private static final ClientRaceDAO clientRaceDAO = new ClientRaceDAO();
	private static final ClientVeteranInfoDAO clientVeteranInfoDAO = new ClientVeteranInfoDAO();
	
	public ClientManager() {}

	public ClientVO getClientByPersonalId(String personalId) throws ClientNotFoundException {
		Integer clientKey = Integer.parseInt(personalId);
		
		// Collect the data for this client
		PathClient client = clientDAO.getClientByClientKey(clientKey);
		List<PathClientRace> races = clientRaceDAO.getRacesByClientKey(clientKey);
		PathClientVeteranInfo veteranInfo = clientVeteranInfoDAO.getVeteranInfoByClientKey(clientKey);
		
		ClientVO clientVO = ClientManager.mapClient(client, races, veteranInfo);

		return clientVO;
	}

	public List<ClientVO> getClients() {
		List<ClientVO> clientVOs = new ArrayList<ClientVO>();
		
		// Collect the clients
		List<PathClient> clients = clientDAO.getClients();
		
		// For each client, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<PathClient> iterator = clients.iterator(); iterator.hasNext();) {
			PathClient client = iterator.next();
			Integer clientKey = client.getClientKey();
			List<PathClientRace> races = clientRaceDAO.getRacesByClientKey(clientKey);
			PathClientVeteranInfo veteranInfo = clientVeteranInfoDAO.getVeteranInfoByClientKey(clientKey);

			ClientVO clientVO = ClientManager.mapClient(client, races, veteranInfo);
			clientVOs.add(clientVO);
		}
		
		return clientVOs;
	}
	
	public ClientVO createClient(ClientVO inputVO) {
		PathClient client = new PathClient();

		// Universal Data Standard: Name (2014, 3.1)
		client.setFirstName(inputVO.getFirstName());
		client.setMiddleName(inputVO.getMiddleName());
		client.setLastName(inputVO.getLastName());
		client.setSuffix(inputVO.getNameSuffix());
		client.setNameType(inputVO.getNameDataQuality().getCode());
		
		// Universal Data Standard: SSN (2014, 3.2)
		client.setIdentification(inputVO.getSsn());
		client.setIdType(inputVO.getSsnDataQuality().getCode());
		
		// Universal Data Standard: Date of Birth  (2014, 3.3)
		client.setDateOfBirth(inputVO.getDob());
		client.setDobType(inputVO.getDobDataQuality().getCode());
		
		// Universal Data Standard: Ethnicity (2014, 3.5)
		client.setEthnicityKey(inputVO.getEthnicity().getCode());

		// Universal Data Standard: Gender (2014, 3.6)
		client.setGenderKey(inputVO.getGender().getCode());
		client.setGenderDesc(inputVO.getOtherGender());

		// Universal Data Standard: Veteran Status (2014, 3.7)
		client.setVeteran(inputVO.getVeteranStatus().getCode());

		// Export fields
		client.setUpdateDate(new Date());
		client.setCreateDate(new Date());
		
		// Compass Required Fields
		client.setUpdateTimestamp(new Date());
		
		// At this point, all the Compass Rose client fields are now set.
		clientDAO.save(client);
		
		
		// Universal Data Standard: Race (2014, 3.4)
		// Convert HUD race storage to Compass Rose race codes
		// (Compass rose race codes currently have no canonical reference)
		List<PathClientRace> races = new ArrayList<PathClientRace>();
		List<Integer> raceCodes = new ArrayList<Integer>();
		
		if(inputVO.getAsian() == YesNo.YES)
			raceCodes.add(5);
		if(inputVO.getBlackAfAmerican() == YesNo.YES)
			raceCodes.add(6);
		if(inputVO.getNativeHIOtherPacific() == YesNo.YES)
			raceCodes.add(9);
		if(inputVO.getAmIndAKNative() == YesNo.YES)
			raceCodes.add(7);
		if(inputVO.getWhite() == YesNo.YES)
			raceCodes.add(8);
		if(inputVO.getRaceNone() != null)
			raceCodes.add(inputVO.getRaceNone().getCode());

		// Create race objects for each code
		for (Iterator<Integer> iterator = raceCodes.iterator(); iterator.hasNext();) {
			Integer raceCode = iterator.next();
			PathClientRace race = new PathClientRace();
			race.setClientKey(client.getClientKey());
			race.setRaceKey(raceCode);
			race.setUpdateTimestamp(new Date());
			clientRaceDAO.save(race);
			races.add(race);
		}

		
		// VA Specific Data Standards: Veteran's Information (2014, 4.41)
		PathClientVeteranInfo veteranInfo = new PathClientVeteranInfo();
		veteranInfo.setYrEnterMilitary(inputVO.getYearEnteredService());
		veteranInfo.setYrSepMilitary(inputVO.getYearSeparated());
		veteranInfo.setWorldWarIi(inputVO.getWorldWarII().getCode());
		veteranInfo.setKoreanWar(inputVO.getKoreanWar().getCode());
		veteranInfo.setVietnamWar(inputVO.getVietnamWar().getCode());
		veteranInfo.setPersianWar(inputVO.getDesertStorm().getCode());
		veteranInfo.setAfghanistanWar(inputVO.getAfghanistanOEF().getCode());
		veteranInfo.setIraqFreedom(inputVO.getIraqOIF().getCode());
		veteranInfo.setIraqDawn(inputVO.getIraqOND().getCode());
		veteranInfo.setOther(inputVO.getOtherTheater().getCode());
		veteranInfo.setMilitaryBranch(inputVO.getMilitaryBranch().getCode());
		veteranInfo.setDischargeStatus(inputVO.getDischargeStatus().getCode());
		veteranInfo.setUpdateTimestamp(new Date());
		clientVeteranInfoDAO.save(veteranInfo);
		
		return ClientManager.mapClient(client, races, veteranInfo);
	}
	
	public static ClientVO mapClient(PathClient client, List<PathClientRace> races, PathClientVeteranInfo veteranInfo) {
		ClientVO clientVO = new ClientVO();
		// Universal Data Standard: Personal ID (2014, 3.13) 
		clientVO.setPersonalId(client.getClientKey().toString());

		// Universal Data Standard: Name (2014, 3.1)
		clientVO.setFirstName(client.getFirstName());
		clientVO.setMiddleName(client.getMiddleName());
		clientVO.setLastName(client.getLastName());
		clientVO.setNameSuffix(client.getSuffix());
		clientVO.setNameDataQuality(ClientNameDataQuality.valueByCode(client.getNameType()));

		// Universal Data Standard: SSN (2014, 3.2)
		clientVO.setSsn(client.getIdentification());
		clientVO.setSsnDataQuality(ClientSsnDataQuality.valueByCode(client.getIdType()));
		
		// Universal Data Standard: Date of Birth  (2014, 3.3)
		clientVO.setDob(client.getDateOfBirth());
		clientVO.setDobDataQuality(ClientDobDataQuality.valueByCode(client.getDobType()));

		// Universal Data Standard: Race (2014, 3.4)
		// Pathways stores races as individual records
		// if no records exist, that is "None", otherwise set the fields 
		if(races.size() == 0) {
			clientVO.setRaceNone(None.NOT_COLLECTED);
		}
		else {
			clientVO.setAsian(YesNo.NO);
			clientVO.setBlackAfAmerican(YesNo.NO);
			clientVO.setNativeHIOtherPacific(YesNo.NO);
			clientVO.setAmIndAKNative(YesNo.NO);
			clientVO.setWhite(YesNo.NO);
		}
		
		for (Iterator<PathClientRace> iterator = races.iterator(); iterator.hasNext();) {
			PathClientRace race = iterator.next();
			ClientRace raceCode = ClientRace.valueByCode(race.getRaceKey());
			if(raceCode != null) {
				switch(raceCode) {
					case ASIAN:
						clientVO.setAsian(YesNo.YES);
						break;
					case BLACK:
						clientVO.setBlackAfAmerican(YesNo.YES);
						break;
					case HAWAIIAN:
						clientVO.setNativeHIOtherPacific(YesNo.YES);
						break;
					case INDIAN:
						clientVO.setAmIndAKNative(YesNo.YES);
						break;
					case WHITE:
						clientVO.setWhite(YesNo.YES);
						break;
					default:
						break;
				}
			}

			// Compass stores none and race in the same table
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
		clientVO.setEthnicity(ClientEthnicity.valueByCode(client.getEthnicityKey()));

		// Universal Data Standard: Gender (2014, 3.6)
		clientVO.setGender(ClientGender.valueByCode(client.getGenderKey()));
		clientVO.setOtherGender(client.getGenderDesc());

		// Universal Data Standard: Veteran Status (2014, 3.7)
		clientVO.setVeteranStatus(YesNoReason.valueByCode(client.getVeteran()));

		// VA Specific Data Standards: Veteran's Information (2014, 4.41)
		if(veteranInfo != null) {
			clientVO.setYearEnteredService(veteranInfo.getYrEnterMilitary());
			clientVO.setYearSeparated(veteranInfo.getYrSepMilitary());
			clientVO.setWorldWarII(YesNoReason.valueByCode(veteranInfo.getWorldWarIi()));
			clientVO.setKoreanWar(YesNoReason.valueByCode(veteranInfo.getKoreanWar()));
			clientVO.setVietnamWar(YesNoReason.valueByCode(veteranInfo.getVietnamWar()));
			clientVO.setDesertStorm(YesNoReason.valueByCode(veteranInfo.getPersianWar()));
			clientVO.setAfghanistanOEF(YesNoReason.valueByCode(veteranInfo.getAfghanistanWar()));
			clientVO.setIraqOIF(YesNoReason.valueByCode(veteranInfo.getIraqFreedom()));
			clientVO.setIraqOND(YesNoReason.valueByCode(veteranInfo.getIraqDawn()));
			clientVO.setOtherTheater(YesNoReason.valueByCode(veteranInfo.getOther()));
			clientVO.setMilitaryBranch(ClientMilitaryBranch.valueByCode(veteranInfo.getMilitaryBranch()));
			clientVO.setDischargeStatus(ClientDischargeStatus.valueByCode(veteranInfo.getDischargeStatus()));
		}
		
		// Export Standard Fields
		clientVO.setDateCreated(client.getCreateDate());
		clientVO.setDateUpdated(client.getUpdateDate());

		return clientVO;
	}

}