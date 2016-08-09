package org.openhmis.dto;


import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class ConsentFieldDTO extends BaseDTO {
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

	public ConsentFieldDTO() {}

	@JsonProperty
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty
	public String getMiddleName() {
		return middleName;
	}

	@JsonProperty setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@JsonProperty
	public String getLastName() {
		return lastName;
	}

	@JsonProperty setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty
	public String getNameSuffix() {
		return nameSuffix;
	}

	@JsonProperty setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	@JsonProperty
	public String getSsn() {
		return ssn;
	}

	@JsonProperty setSsn(String ssn) {
		this.ssn = ssn;
	}

	@JsonProperty
	public String getDob() {
		return dob;
	}

	@JsonProperty setDob(String dob) {
		this.dob = dob;
	}

	@JsonProperty
	public String getRace() {
		return race;
	}

	@JsonProperty setRace(String race) {
		this.race = race;
	}

	@JsonProperty
	public String getEthnicity() {
		return ethnicity;
	}

	@JsonProperty setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	@JsonProperty
	public String getGender() {
		return gender;
	}

	@JsonProperty setGender(String gender) {
		this.gender = gender;
	}

	@JsonProperty
	public String getVeteranStatus() {
		return veteranStatus;
	}

	@JsonProperty setVeteranStatus(String veteranStatus) {
		this.veteranStatus = veteranStatus;
	}
}

