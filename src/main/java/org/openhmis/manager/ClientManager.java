/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.manager;

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

	public Boolean addClient(ClientVO client) {
		return clientDAO.save(client);
	}

	public Boolean updateClient(ClientVO client) {
		return clientDAO.update(client);
	}

	public Boolean deleteClient(ClientVO client) {
		return clientDAO.delete(client);
	}

	public Boolean validateClient(ClientVO client) throws InValidClientException {
		return Boolean.TRUE;
	}

	public ClientVO getClientByPersonalId(String personalId) throws ClientNotFoundException {
		Integer clientKey = Integer.parseInt(personalId);
		ClientVO clientVO = new ClientVO();
		PathClient client = clientDAO.findClientByClientKey(clientKey);
		if (client != null) {
			
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
			List<PathClientRace> races = clientRaceDAO.findRacesByClientKey(clientKey);
			
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
				}

				None noneCode = None.valueByCode(race.getRaceKey());
				switch (noneCode) {
					case REFUSED:
						clientVO.setRaceNone(None.REFUSED);
						break;
					case UNKNOWN:
						clientVO.setRaceNone(None.UNKNOWN);
						break;
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
			PathClientVeteranInfo veteranInfo = clientVeteranInfoDAO.findVeteranInfoByClientKey(clientKey);
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

		}
		else {
			throw new ClientNotFoundException();
		}
		return clientVO;
	}
}