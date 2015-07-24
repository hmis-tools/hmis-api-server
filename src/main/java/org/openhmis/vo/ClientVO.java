/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.vo;

import java.util.Date;
import java.util.Set;

import org.openhmis.code.ClientEthnicity;
import org.openhmis.code.ClientGender;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.code.ClientSsnDataQuality;
import org.openhmis.code.ClientDateOfBirthType;
import org.openhmis.code.ClientRace;
import org.openhmis.code.YesNo;
import org.openhmis.code.serialization.CodeSerializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ClientVO {
	/**
	 * The client object represents a client record
	 * Fields returned with the client object represent fields marked as "At client record creation" in the HUD standards
	 */

	// Universal Data Standard: Personal ID (2014, 3.13) 
	private String personalId;

	// Universal Data Standard: Name (2014, 3.1)
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private ClientNameDataQuality nameDataQuality;

	// Universal Data Standard: SSN (2014, 3.2)
	private String socialSecurityNumber;
	private ClientSsnDataQuality ssnDataQuality;
	
	// Universal Data Standard: Date of Birth  (2014, 3.3)
	private Date dob;
	private ClientDateOfBirthType dateOfBirthType;

	// Universal Data Standard: Race (2014, 3.4)
	// THIS WILL BE A SET
	private Set<ClientRace> race;

	// Universal Data Standard: Ethnicity (2014, 3.5)
	private ClientEthnicity ethnicity;

	// Universal Data Standard: Gender (2014, 3.6)
	private ClientGender gender;
	private String otherGender;

	// Universal Data Standard: Veteren Status (2014, 3.7)
	private YesNo veteranStatusCode;

	// VA Specific Data Standards: Veteran's Information (2014, 4.41)
	private Integer yearEnteredMilitaryService;
	private Integer yearSeparatedFromMilitaryService;
	private Integer theatreOfOperationsWw2Code;
	private Integer theatreOfOperationsKoreanWarCode;
	private Integer theatreOfOperationsVietnamWarCode;
	private Integer theatreOfOperationsPersianGulfWarCode;
	private Integer theatreOfOperationsAfghanistanWarCode;
	private Integer theatreOfOperationsIraqiFreedomCode;
	private Integer theatreOfOperationsIraqNewDawnCode;
	private Integer theatreOfOperationsOtherPeacekeepingCode;
	private Integer branchOfMilitaryCode;
	private Integer dischargeStatusCode;

	public Set<ClientRace> getRaces() {
		return this.race;
	}
	
	@JsonProperty("nameDataQuality22")
	@JsonSerialize(using = CodeSerializer.class)
	public ClientNameDataQuality getNameDataQuality() {
		return this.nameDataQuality;
	}

	public ClientVO() {
		super();
		//this.race = [ClientRace.HAWAIIAN];
		this.nameDataQuality = ClientNameDataQuality.PARTIAL;
	}
	public ClientVO(String personalId) {
		super();
		this.personalId = personalId;
	}
}
