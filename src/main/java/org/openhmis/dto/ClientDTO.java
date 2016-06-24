

package org.openhmis.dto;


import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@XmlRootElement
public class ClientDTO extends BaseDTO {
	
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
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
	private Date dateCreated;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
	private Date dateUpdated;

	public ClientDTO() {}

	// Getters / Setters
	@JsonProperty
	public String getId() {
		return this.personalId;
	}
	@JsonProperty
	public void setId(String personalId) {
		this.personalId = personalId;
	}
	
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
                return (nameDataQuality == null) ? ClientNameDataQuality.NOT_COLLECTED : nameDataQuality;
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
                return (ssnDataQuality == null) ? ClientSsnDataQuality.NOT_COLLECTED : ssnDataQuality;
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
                return (dobDataQuality == null) ? ClientDobDataQuality.NOT_COLLECTED : dobDataQuality;
	}

	@JsonProperty
	public void setDobDataQuality(ClientDobDataQuality dobDataQuality) {
		this.dobDataQuality = dobDataQuality;
	}

	@JsonProperty
	public YesNo getAmIndAKNative() {
		return amIndAKNative;
	}

	@JsonProperty
	public void setAmIndAKNative(YesNo amIndAKNative) {
		this.amIndAKNative = amIndAKNative;
	}

	@JsonProperty
	public YesNo getAsian() {
		return asian;
	}

	@JsonProperty
	public void setAsian(YesNo asian) {
		this.asian = asian;
	}

	@JsonProperty
	public YesNo getBlackAfAmerican() {
		return blackAfAmerican;
	}

	@JsonProperty
	public void setBlackAfAmerican(YesNo blackAfAmerican) {
		this.blackAfAmerican = blackAfAmerican;
	}

	@JsonProperty
	public YesNo getNativeHIOtherPacific() {
		return nativeHIOtherPacific;
	}

	@JsonProperty
	public void setNativeHIOtherPacific(YesNo nativeHIOtherPacific) {
		this.nativeHIOtherPacific = nativeHIOtherPacific;
	}

	@JsonProperty
	public YesNo getWhite() {
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
                return (ethnicity == null) ? ClientEthnicity.NOT_COLLECTED : ethnicity;
	}

	@JsonProperty
	public void setEthnicity(ClientEthnicity ethnicity) {
		this.ethnicity = ethnicity;
	}

	@JsonProperty
	public ClientGender getGender() {
                return (gender == null) ? ClientGender.NOT_COLLECTED : gender;
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
                return (veteranStatus == null) ? YesNoReason.NOT_COLLECTED : veteranStatus;
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
                return (worldWarII == null) ? YesNoReason.NOT_COLLECTED: worldWarII;
	}

	@JsonProperty
	public void setWorldWarII(YesNoReason worldWarII) {
		this.worldWarII = worldWarII;
	}

	@JsonProperty
	public YesNoReason getKoreanWar() {
                return (koreanWar == null) ? YesNoReason.NOT_COLLECTED: koreanWar;
	}

	@JsonProperty
	public void setKoreanWar(YesNoReason koreanWar) {
		this.koreanWar = koreanWar;
	}

	@JsonProperty
	public YesNoReason getVietnamWar() {
                return (vietnamWar == null) ? YesNoReason.NOT_COLLECTED : vietnamWar;
	}

	@JsonProperty
	public void setVietnamWar(YesNoReason vietnamWar) {
		this.vietnamWar = vietnamWar;
	}

	@JsonProperty
	public YesNoReason getDesertStorm() {
                return (desertStorm == null) ? YesNoReason.NOT_COLLECTED : desertStorm;
	}

	@JsonProperty
	public void setDesertStorm(YesNoReason desertStorm) {
		this.desertStorm = desertStorm;
	}

	@JsonProperty
	public YesNoReason getAfghanistanOEF() {
                return (afghanistanOEF == null) ? YesNoReason.NOT_COLLECTED : afghanistanOEF;
	}

	@JsonProperty
	public void setAfghanistanOEF(YesNoReason afghanistanOEF) {
		this.afghanistanOEF = afghanistanOEF;
	}

	@JsonProperty
	public YesNoReason getIraqOIF() {
                return (iraqOIF == null) ? YesNoReason.NOT_COLLECTED : iraqOIF;
	}

	@JsonProperty
	public void setIraqOIF(YesNoReason iraqOIF) {
		this.iraqOIF = iraqOIF;
	}

	@JsonProperty
	public YesNoReason getIraqOND() {
                return (iraqOND == null) ? YesNoReason.NOT_COLLECTED : iraqOND;
	}

	@JsonProperty
	public void setIraqOND(YesNoReason iraqOND) {
		this.iraqOND = iraqOND;
	}

	@JsonProperty
	public YesNoReason getOtherTheater() {
                return (otherTheater == null) ? YesNoReason.NOT_COLLECTED : otherTheater;
	}

	@JsonProperty
	public void setOtherTheater(YesNoReason otherTheater) {
		this.otherTheater = otherTheater;
	}

	@JsonProperty
	public ClientMilitaryBranch getMilitaryBranch() {
                return (militaryBranch == null) ? ClientMilitaryBranch.NOT_COLLECTED : militaryBranch;
	}

	@JsonProperty
	public void setMilitaryBranch(ClientMilitaryBranch militaryBranch) {
		this.militaryBranch = militaryBranch;
	}

	@JsonProperty
	public ClientDischargeStatus getDischargeStatus() {
                return (dischargeStatus == null) ? ClientDischargeStatus.NOT_COLLECTED : dischargeStatus;
	}

	@JsonProperty
	public void setDischargeStatus(ClientDischargeStatus dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
	}

	@JsonProperty
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
	public Date getDateCreated() {
		return dateCreated;
	}

	@JsonProperty
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@JsonProperty
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
	public Date getDateUpdated() {
		return dateUpdated;
	}

	@JsonProperty
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
}
