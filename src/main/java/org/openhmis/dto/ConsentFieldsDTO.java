package org.openhmis.dto;


import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.ConsentRequestType;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class ConsentFieldsDTO extends BaseDTO {
	private ConsentRequestType firstName;
	private ConsentRequestType middleName;
	private ConsentRequestType lastName;
	private ConsentRequestType nameSuffix;
	private ConsentRequestType ssn;
	private ConsentRequestType dob;
	private ConsentRequestType race;
	private ConsentRequestType ethnicity;
	private ConsentRequestType gender;
	private ConsentRequestType veteranStatus;

	public ConsentFieldsDTO() {}

	@JsonProperty
	public ConsentRequestType getFirstName() {
		return firstName;
	}

	@JsonProperty 
	public void setFirstName(ConsentRequestType firstName) {
		this.firstName = firstName;
	}

	@JsonProperty
	public ConsentRequestType getMiddleName() {
		return middleName;
	}

	@JsonProperty 
	public void setMiddleName(ConsentRequestType middleName) {
		this.middleName = middleName;
	}

	@JsonProperty
	public ConsentRequestType getLastName() {
		return lastName;
	}

	@JsonProperty 
	public void setLastName(ConsentRequestType lastName) {
		this.lastName = lastName;
	}

	@JsonProperty
	public ConsentRequestType getNameSuffix() {
		return nameSuffix;
	}

	@JsonProperty 
	public void setNameSuffix(ConsentRequestType nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	@JsonProperty
	public ConsentRequestType getSsn() {
		return ssn;
	}

	@JsonProperty 
	public void setSsn(ConsentRequestType ssn) {
		this.ssn = ssn;
	}

	@JsonProperty
	public ConsentRequestType getDob() {
		return dob;
	}

	@JsonProperty 
	public void setDob(ConsentRequestType dob) {
		this.dob = dob;
	}

	@JsonProperty
	public ConsentRequestType getRace() {
		return race;
	}

	@JsonProperty 
	public void setRace(ConsentRequestType race) {
		this.race = race;
	}

	@JsonProperty
	public ConsentRequestType getEthnicity() {
		return ethnicity;
	}

	@JsonProperty 
	public void setEthnicity(ConsentRequestType ethnicity) {
		this.ethnicity = ethnicity;
	}

	@JsonProperty
	public ConsentRequestType getGender() {
		return gender;
	}

	@JsonProperty 
	public void setGender(ConsentRequestType gender) {
		this.gender = gender;
	}

	@JsonProperty
	public ConsentRequestType getVeteranStatus() {
		return veteranStatus;
	}

	@JsonProperty 
	public void setVeteranStatus(ConsentRequestType veteranStatus) {
		this.veteranStatus = veteranStatus;
	}
}

