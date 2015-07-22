/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ClientVO implements Serializable
{
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
	private Integer nameDataQualityCode;

	// Universal Data Standard: SSN (2014, 3.2)
	private String socialSecurityNumber;
	private Integer ssnDataQualityCode;
	
	// Universal Data Standard: Date of Birth  (2014, 3.3)
	private String dateOfBirth;
	private Integer dateOfBirthTypeCode;

	// Universal Data Standard: Race (2014, 3.4)
	private Integer raceCode;

	// Universal Data Standard: Ethnicity (2014, 3.5)
	private Integer ethnicityCode;

	// Universal Data Standard: Gender (2014, 3.6)
	private Integer genderCode;
	private String otherGender;

	// Universal Data Standard: Veteren Status (2014, 3.7)
	private Integer veteranStatusCode;

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

	
	public ClientVO() {
		super();
	}
	public ClientVO(Long clientKey) {
		super();
		this.clientKey = clientKey;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	@Override
	public String toString() {
		return "";
	}
}
