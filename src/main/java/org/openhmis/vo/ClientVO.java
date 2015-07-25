

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
import org.openhmis.code.YesNoReason;
import org.openhmis.code.serialization.CodeSerializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ClientVO {
	
	/**
	 * The client object represents a client record
	 * Fields returned with the client object represent fields marked as "At client record creation" in the HUD standards
	 *
	 * References:
	 * - Fields dictated by: https://www.hudexchange.info/resources/documents/HMIS-Data-Standards-Manual.pdf
	 * - Field names dictated by: http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf
	 */

	// Universal Data Standard: Personal ID (2014, 3.13) 
	private String personalId;

	// Universal Data Standard: Name (2014, 3.1)
	private String firstName;
	private String middleName;
	private String lastName;
	private String nameSuffix;
	private ClientNameDataQuality nameDataQuality;

	// Universal Data Standard: SSN (2014, 3.2)
	private String ssn;
	private ClientSsnDataQuality ssnDataQuality;
	
	// Universal Data Standard: Date of Birth  (2014, 3.3)
	private Date dob;
	private ClientDobDataQuality dobDataQuality;

	// Universal Data Standard: Race (2014, 3.4)
	private YesNo amIndAKNative;
	private YesNo asian;
	private YesNo blackAfAmerican;
	private YesNo nativeHIOtherPacific;
	private YesNo white;
	private None raceNone;

	// Universal Data Standard: Ethnicity (2014, 3.5)
	private ClientEthnicity ethnicity;

	// Universal Data Standard: Gender (2014, 3.6)
	private ClientGender gender;
	private String otherGender;

	// Universal Data Standard: Veteren Status (2014, 3.7)
	private YesNoReason veteranStatus;

	// VA Specific Data Standards: Veteran's Information (2014, 4.41)
	private Date yearEnteredService;
	private Date yearSeparated;
	private YesNoReason worldWarII;
	private YesNoReason koreanWar;
	private YesNoReason vietnamWar;
	private YesNoReason desertStorm;
	private YesNoReason afghanistanOEF;
	private YesNoReason iraqOIF;
	private YesNoReason iraqOND;
	private YesNoReason otherTheater;
	private ClientMilitaryBranch militaryBranch;
	private ClientDischargeStaus dischargeStatus;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated

	public ClientVO() {
		super();
		this.nameDataQuality = ClientNameDataQuality.PARTIAL;
	}

	@JsonProperty("personalId")
	public String getPersonalId() {
		return this.personalId;
	}
	@JsonProperty("personalId")
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
	
	@JsonProperty("nameDataQuality")
	public ClientNameDataQuality getNameDataQuality() {
		return this.nameDataQuality;
	}
	@JsonProperty("nameDataQuality")
	public void setNameDataQuality(ClientNameDataQuality nameDataQuality) {
		this.nameDataQuality = nameDataQuality;
	}
}
