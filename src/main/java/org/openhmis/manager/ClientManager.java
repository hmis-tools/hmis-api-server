/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.manager;

import java.util.Date;

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
import org.openhmis.dao.ClientDAO;
import org.openhmis.domain.PathClient;
import org.openhmis.exception.client.ClientNotFoundException;
import org.openhmis.exception.client.InValidClientException;
import org.openhmis.manager.ClientManager;
import org.openhmis.vo.ClientVO;


public class ClientManager {
	
	private ClientDAO clientDAO;
	
	public ClientManager() {
		this.clientDAO = new ClientDAO();
	}

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
		ClientVO clientVO = new ClientVO();
		PathClient client = clientDAO.findClientByClientKey(Integer.parseInt(personalId));
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
//				private YesNo amIndAKNative;
//				private YesNo asian;
//				private YesNo blackAfAmerican;
//				private YesNo nativeHIOtherPacific;
//				private YesNo white;
//				private None raceNone;

			// Universal Data Standard: Ethnicity (2014, 3.5)
			clientVO.setEthnicity(ClientEthnicity.valueByCode(client.getEthnicityKey()));

			// Universal Data Standard: Gender (2014, 3.6)
			clientVO.setGender(ClientGender.valueByCode(client.getGenderKey()));
			clientVO.setOtherGender(client.getGenderDesc());

			// Universal Data Standard: Veteren Status (2014, 3.7)
			clientVO.setVeteranStatus(YesNoReason.valueByCode(client.getVeteran()));

			// VA Specific Data Standards: Veteran's Information (2014, 4.41)
//				private Date yearEnteredService;
//				private Date yearSeparated;
//				private YesNoReason worldWarII;
//				private YesNoReason koreanWar;
//				private YesNoReason vietnamWar;
//				private YesNoReason desertStorm;
//				private YesNoReason afghanistanOEF;
//				private YesNoReason iraqOIF;
//				private YesNoReason iraqOND;
//				private YesNoReason otherTheater;
//				private ClientMilitaryBranch militaryBranch;
//				private ClientDischargeStatus dischargeStatus;

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