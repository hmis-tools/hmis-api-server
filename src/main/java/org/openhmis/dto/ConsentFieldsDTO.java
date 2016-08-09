package org.openhmis.dto;


import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class ConsentFieldsDTO extends BaseDTO {
	private String firstName;
	private String middleName;
	private String lastName;
	private String nameSuffix;
	private String ssn;
	private String dob;
	private String race;
	private String ethnicity;
	private String gender;
	private String veteranStatus;

	public ConsentFieldsDTO() {}

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
	public String getSsn() {
		return ssn;
	}

	@JsonProperty 
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@JsonProperty
	public String getDob() {
		return dob;
	}

	@JsonProperty 
	public void setDob(String dob) {
		this.dob = dob;
	}

	@JsonProperty
	public String getRace() {
		return race;
	}

	@JsonProperty 
	public void setRace(String race) {
		this.race = race;
	}

	@JsonProperty
	public String getEthnicity() {
		return ethnicity;
	}

	@JsonProperty 
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	@JsonProperty
	public String getGender() {
		return gender;
	}

	@JsonProperty 
	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonProperty
	public String getVeteranStatus() {
		return veteranStatus;
	}

	@JsonProperty 
	public void setVeteranStatus(String veteranStatus) {
		this.veteranStatus = veteranStatus;
	}
}

