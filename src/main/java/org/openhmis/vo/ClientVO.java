

package org.openhmis.vo;

import java.util.Date;
import java.util.Set;

import org.openhmis.code.ClientDischargeStatus;
import org.openhmis.code.ClientEthnicity;
import org.openhmis.code.ClientGender;
import org.openhmis.code.ClientMilitaryBranch;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.code.ClientSsnDataQuality;
import org.openhmis.code.ClientDobDataQuality;
import org.openhmis.code.None;
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
	private String yearEnteredService;
	private String yearSeparated;
	private YesNoReason worldWarII;
	private YesNoReason koreanWar;
	private YesNoReason vietnamWar;
	private YesNoReason desertStorm;
	private YesNoReason afghanistanOEF;
	private YesNoReason iraqOIF;
	private YesNoReason iraqOND;
	private YesNoReason otherTheater;
	private ClientMilitaryBranch militaryBranch;
	private ClientDischargeStatus dischargeStatus;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public ClientVO() {
		super();
		this.nameDataQuality = ClientNameDataQuality.PARTIAL;
	}

	// Getters / Setters
	@JsonProperty
	public String getPersonalId() {
		return this.personalId;
	}
	@JsonProperty
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
	
	@JsonProperty
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty
	public String getMiddleName() {
		return middleName;
	}

	@JsonProperty
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@JsonProperty
	public String getLastName() {
		return lastName;
	}

	@JsonProperty
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty
	public String getNameSuffix() {
		return nameSuffix;
	}

	@JsonProperty
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	@JsonProperty
	public ClientNameDataQuality getNameDataQuality() {
		if(nameDataQuality == null)
			return ClientNameDataQuality.NOT_COLLECTED;
		return nameDataQuality;
	}
	@JsonProperty
	public void setNameDataQuality(ClientNameDataQuality nameDataQuality) {
		this.nameDataQuality = nameDataQuality;
	}
	
	@JsonProperty
	public String getSsn() {
		return ssn;
	}

	@JsonProperty
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@JsonProperty
	public ClientSsnDataQuality getSsnDataQuality() {
		if(ssnDataQuality == null)
			return ClientSsnDataQuality.NOT_COLLECTED;
		return ssnDataQuality;
	}

	@JsonProperty
	public void setSsnDataQuality(ClientSsnDataQuality ssnDataQuality) {
		this.ssnDataQuality = ssnDataQuality;
	}

	@JsonProperty
	public Date getDob() {
		return dob;
	}

	@JsonProperty
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@JsonProperty
	public ClientDobDataQuality getDobDataQuality() {
		if(dobDataQuality == null)
			return ClientDobDataQuality.NOT_COLLECTED;
		return dobDataQuality;
	}

	@JsonProperty
	public void setDobDataQuality(ClientDobDataQuality dobDataQuality) {
		this.dobDataQuality = dobDataQuality;
	}

	@JsonProperty
	public YesNo getAmIndAKNative() {
		if(amIndAKNative == null)
			return YesNo.NOT_COLLECTED;
		return amIndAKNative;
	}

	@JsonProperty
	public void setAmIndAKNative(YesNo amIndAKNative) {
		this.amIndAKNative = amIndAKNative;
	}

	@JsonProperty
	public YesNo getAsian() {
		if(asian == null)
			return YesNo.NOT_COLLECTED;
		return asian;
	}

	@JsonProperty
	public void setAsian(YesNo asian) {
		this.asian = asian;
	}

	@JsonProperty
	public YesNo getBlackAfAmerican() {
		if(blackAfAmerican == null)
			return YesNo.NOT_COLLECTED;
		return blackAfAmerican;
	}

	@JsonProperty
	public void setBlackAfAmerican(YesNo blackAfAmerican) {
		this.blackAfAmerican = blackAfAmerican;
	}

	@JsonProperty
	public YesNo getNativeHIOtherPacific() {
		if(nativeHIOtherPacific == null)
			return YesNo.NOT_COLLECTED;
		return nativeHIOtherPacific;
	}

	@JsonProperty
	public void setNativeHIOtherPacific(YesNo nativeHIOtherPacific) {
		this.nativeHIOtherPacific = nativeHIOtherPacific;
	}

	@JsonProperty
	public YesNo getWhite() {
		if(white == null)
			return YesNo.NOT_COLLECTED;
		return white;
	}

	@JsonProperty
	public void setWhite(YesNo white) {
		this.white = white;
	}

	@JsonProperty
	public None getRaceNone() {
		return raceNone;
	}

	@JsonProperty
	public void setRaceNone(None raceNone) {
		this.raceNone = raceNone;
	}

	@JsonProperty
	public ClientEthnicity getEthnicity() {
		if(ethnicity == null)
			return ClientEthnicity.NOT_COLLECTED;
		return ethnicity;
	}

	@JsonProperty
	public void setEthnicity(ClientEthnicity ethnicity) {
		this.ethnicity = ethnicity;
	}

	@JsonProperty
	public ClientGender getGender() {
		if(gender == null)
			return ClientGender.NOT_COLLECTED;
		return gender;
	}

	@JsonProperty
	public void setGender(ClientGender gender) {
		this.gender = gender;
	}

	@JsonProperty
	public String getOtherGender() {
		return otherGender;
	}

	@JsonProperty
	public void setOtherGender(String otherGender) {
		this.otherGender = otherGender;
	}

	@JsonProperty
	public YesNoReason getVeteranStatus() {
		if(veteranStatus == null)
			return YesNoReason.NOT_COLLECTED;
		return veteranStatus;
	}

	@JsonProperty
	public void setVeteranStatus(YesNoReason veteranStatus) {
		this.veteranStatus = veteranStatus;
	}

	@JsonProperty
	public String getYearEnteredService() {
		return yearEnteredService;
	}

	@JsonProperty
	public void setYearEnteredService(String yearEnteredService) {
		this.yearEnteredService = yearEnteredService;
	}

	@JsonProperty
	public String getYearSeparated() {
		return yearSeparated;
	}

	@JsonProperty
	public void setYearSeparated(String yearSeparated) {
		this.yearSeparated = yearSeparated;
	}

	@JsonProperty
	public YesNoReason getWorldWarII() {
		if(worldWarII == null)
			return YesNoReason.NOT_COLLECTED;
		return worldWarII;
	}

	@JsonProperty
	public void setWorldWarII(YesNoReason worldWarII) {
		this.worldWarII = worldWarII;
	}

	@JsonProperty
	public YesNoReason getKoreanWar() {
		if(koreanWar == null)
			return YesNoReason.NOT_COLLECTED;
		return koreanWar;
	}

	@JsonProperty
	public void setKoreanWar(YesNoReason koreanWar) {
		this.koreanWar = koreanWar;
	}

	@JsonProperty
	public YesNoReason getVietnamWar() {
		if(vietnamWar == null)
			return YesNoReason.NOT_COLLECTED;
		return vietnamWar;
	}

	@JsonProperty
	public void setVietnamWar(YesNoReason vietnamWar) {
		this.vietnamWar = vietnamWar;
	}

	@JsonProperty
	public YesNoReason getDesertStorm() {
		if(desertStorm == null)
			return YesNoReason.NOT_COLLECTED;
		return desertStorm;
	}

	@JsonProperty
	public void setDesertStorm(YesNoReason desertStorm) {
		this.desertStorm = desertStorm;
	}

	@JsonProperty
	public YesNoReason getAfghanistanOEF() {
		if(afghanistanOEF == null)
			return YesNoReason.NOT_COLLECTED;
		return afghanistanOEF;
	}

	@JsonProperty
	public void setAfghanistanOEF(YesNoReason afghanistanOEF) {
		this.afghanistanOEF = afghanistanOEF;
	}

	@JsonProperty
	public YesNoReason getIraqOIF() {
		if(iraqOIF == null)
			return YesNoReason.NOT_COLLECTED;
		return iraqOIF;
	}

	@JsonProperty
	public void setIraqOIF(YesNoReason iraqOIF) {
		this.iraqOIF = iraqOIF;
	}

	@JsonProperty
	public YesNoReason getIraqOND() {
		if(iraqOND == null)
			return YesNoReason.NOT_COLLECTED;
		return iraqOND;
	}

	@JsonProperty
	public void setIraqOND(YesNoReason iraqOND) {
		this.iraqOND = iraqOND;
	}

	@JsonProperty
	public YesNoReason getOtherTheater() {
		if(otherTheater == null)
			return YesNoReason.NOT_COLLECTED;
		return otherTheater;
	}

	@JsonProperty
	public void setOtherTheater(YesNoReason otherTheater) {
		this.otherTheater = otherTheater;
	}

	@JsonProperty
	public ClientMilitaryBranch getMilitaryBranch() {
		if(militaryBranch == null)
			return ClientMilitaryBranch.NOT_COLLECTED;
		else
			return militaryBranch;
	}

	@JsonProperty
	public void setMilitaryBranch(ClientMilitaryBranch militaryBranch) {
		this.militaryBranch = militaryBranch;
	}

	@JsonProperty
	public ClientDischargeStatus getDischargeStatus() {
		if(dischargeStatus == null)
			return ClientDischargeStatus.NOT_COLLECTED;
		else
			return dischargeStatus;
	}

	@JsonProperty
	public void setDischargeStatus(ClientDischargeStatus dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
	}

	@JsonProperty
	public Date getDateCreated() {
		return dateCreated;
	}

	@JsonProperty
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@JsonProperty
	public Date getDateUpdated() {
		return dateUpdated;
	}

	@JsonProperty
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
}
