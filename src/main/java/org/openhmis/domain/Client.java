/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.domain;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Client entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT")
public class Client implements java.io.Serializable {

	// Universal Fields
	private Long clientKey;
	private String identification;
	private Integer identificationType;
	private String lastName;
	private String firstName;
	private String middleName;
	private String suffix;
	private Integer genderKey;
	private Integer ethnicityKey;
	private Date createDate;
	private Integer createUserKey;
	private Integer dobType;
	private Integer nameType;

	// Compass Fields
	private Integer maritalStatusKey;
	private Integer ambulatoryKey;
	private String clientNotes;
	private String isHomeless;
	private Integer regionKey;
	private String isAnonymous;
	private Date updateDate;
	private Integer updateUserKey;
	private Integer disablingCondition;
	private String previousFirstName;
	private String previousMiddleName;
	private String previousLastName;
	private String previousSuffix;
	private Integer hoursWorkedLastWeek;
	private Integer lookingForWork;
	private Integer veteran;
	private Integer healthStatusKey;
	private Integer pregnancyStatus;
	private Date pregnancyDueDate;
	private Integer transgenderType;
	private Integer primaryLanguageKey;
	private Integer secondaryLanguageKey;
	private String isInterpreterNeeded;
	private Integer primaryLanguage;
	private Integer secondaryLanguage;
	private String picture; // How are we going to handle pictures...
	private String pictureName;
	private Integer pictureUploadUser;
	private Date pictureUploadDate;
	private Integer pictureDeleteUser;
	private Date pictureDeleteDate;
	private String pictureType;
	private Integer raceKey;
	private Integer homelessStatusKey;
	private Integer incomeQuestion;
	private Date incomeDate;
	private Integer nonCashQuestion;
	private Integer nonCashDate;
	private Integer isEmployed;
	private Integer tenure;
	private String isVolunteer;
	private String isBasic;
	private Timestamp updateTimestamp;
	private String migrationFlag;
	private String isCoord;
	private String genderDescription;
	private Integer healthInsuranceQuestion;
	private Date healthInsuranceDate;
	private String otherIdentification;
	private String otherIdentificationNumber;


	// Constructors

	/** default constructor */
	public Client() {
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CLIENT_KEY", unique = true, nullable = false)
	public Long getClientKey() {
		return this.clientKey;
	}
	public void setClientKey(Long clientKey) {
		this.clientKey = clientKey;
	}

	@Column(name= "MARITAL_STATUS_KEY") // BIGINT(20)
	public Integer getMaritalStatusKey() {
		return this.maritalStatusKey;
	}
	public void setMaritalStatusKey(Integer maritalStatusKey) {
		this.maritalStatusKey = maritalStatusKey;
	}

	@Column(name= "AMBULATORY_KEY") // BIGINT(20)
	public Integer getAmbulatoryKey() {
		return this.ambulatoryKey;
	}
	public void setAmbulatoryKey(Integer ambulatoryKey) {
		this.ambulatoryKey = ambulatoryKey;
	}

	@Column(name= "CLIENT_NOTES") // TEXT
	public String getClientNotes() {
		return this.clientNotes;
	}
	public void setClientNotes(String clientNotes) {
		this.clientNotes = clientNotes;
	}

	@Column(name= "HOMELESS") // CHAR(1),
	public String getIsHomeless() {
		return this.isHomeless;
	}
	public void setIsHomeless(String isHomeless) {
		this.isHomeless = isHomeless;
	}

	@Column(name= "REGION_KEY") // BIGINT(20)
	public Integer getRegionKey() {
		return this.regionKey;
	}
	public void setRegionKey(Integer regionKey) {
		this.regionKey = regionKey;
	}

	@Column(name= "ANONYMOUS") // CHAR(1) DEFAULT 'N'
	public String getIsAnonymous() {
		return this.isAnonymous;
	}
	public void setIsAnonymous(String isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	@Column(name= "UPDATE_DATE") // DATE
	public Date getUpdateDate() {
		return this.updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name= "UPDATE_USER_KEY") // BIGINT(20)
	public Integer getUpdateUserKey() {
		return this.updateUserKey;
	}
	public void setUserKey(Integer updateUserKey) {
		this.updateUserKey = updateUserKey;
	}

	@Column(name= "DISABLING_CONDITION") // BIGINT(20) DEFAULT 8
	public Integer getDisablingCondition() {
		return this.disablingCondition;
	}
	public void setDisablingcondition(Integer disablingCondition) {
		this.disablingCondition = disablingCondition;
	}

	@Column(name= "PREVIOUS_FIRST_NAME") // VARCHAR(50)
	public String getPreviousFirstName() {
		return this.previousFirstName;
	}
	public void setPreviousFirstName(String previousFirstName) {
		this.previousFirstName = previousFirstName;
	}

	@Column(name= "PREVIOUS_MIDDLE_NAME") // VARCHAR(50)
	public String getPreviousMiddleName() {
		return this.previousMiddleName;
	}
	public void setPreviousMiddleName(String previousMiddleName) {
		this.previousMiddleName = previousMiddleName;
	}

	@Column(name= "PREVIOUS_LAST_NAME") // VARCHAR(50)
	public String getPreviousLastName() {
		return this.previousLastName;
	}
	public void setPreviousLastName(String previousLastName) {
		this.previousLastName = previousLastName;
	}

	@Column(name= "PREVIOUS_SUFFIX") // VARCHAR(50)
	public String getPreviousSuffix() {
		return this.previousSuffix;
	}
	public void setPreviousSuffix(String previousSuffix) {
		this.previousSuffix = previousSuffix;
	}

	@Column(name= "HOURS_WORKED_LAST_WEEK") // BIGINT(20)
	public Integer getHoursWorkedLastWeek() {
		return this.hoursWorkedLastWeek;
	}
	public void setHoursWorkedLastWeek(Integer hoursWorkedLastWeek) {
		this.hoursWorkedLastWeek = hoursWorkedLastWeek;
	}

	@Column(name= "LOOKING_FOR_WORK") // BIGINT(20) DEFAULT 0
	public Integer getLookingForWork() {
		return this.lookingForWork;
	}
	public void setLookingForWork(Integer lookingForWork) {
		this.lookingForWork = lookingForWork;
	}

	@Column(name= "VETERAN") // BIGINT(20) DEFAULT 8
	public Integer getVeteran() {
		return this.veteran;
	}
	public void setVeteran(Integer veteran) {
		this.veteran = veteran;
	}

	@Column(name= "HEALTH_STATUS_KEY") // BIGINT(20)
	public Integer getHealthStatusKey() {
		return this.healthStatusKey;
	}
	public void setHealthStatusKey(Integer healthStatusKey) {
		this.healthStatusKey = healthStatusKey;
	}

	@Column(name= "PREGNANCY_STATUS") // BIGINT(20)
	public Integer getPregnancyStatus() {
		return this.pregnancyStatus;
	}
	public void setPregnancyStatus(Integer pregnancyStatus) {
		this.pregnancyStatus = pregnancyStatus;
	}

	@Column(name= "PREGNANCY_DUE_DATE") // DATE
	public Date getPregnancyDueDate() {
		return this.pregnancyDueDate;
	}
	public void setPregnancyDueDate(Date pregnancyDueDate) {
		this.pregnancyDueDate = pregnancyDueDate;
	}

	@Column(name= "TRANSGENDER_TYPE") // BIGINT(20) DEFAULT 0
	public Integer getTransgenderType() {
		return this.transgenderType;
	}
	public void setTransgenderType(Integer transgenderType) {
		this.transgenderType = transgenderType;
	}

	@Column(name= "PRIMARY_LANGUAGE_KEY") // BIGINT(20)
	public Integer getPrimaryLanguageKey() {
		return this.primaryLanguageKey;
	}
	public void setPrimaryLanguageKey(Integer primaryLanguageKey) {
		this.primaryLanguageKey = primaryLanguageKey;
	}

	@Column(name= "SECONDARY_LANGUAGE_KEY") // BIGINT(20)
	public Integer getSecondaryLanguageKey() {
		return this.secondaryLanguageKey;
	}
	public void setSecondaryLanguageKey(Integer secondaryLanguageKey) {
		this.secondaryLanguageKey = secondaryLanguageKey;
	}

	@Column(name= "INTERPRETER_NEEDED") // CHAR(1) DEFAULT NULL
	public String getIsInterpreterNeeded() {
		return this.isInterpreterNeeded;
	}
	public void setIsInterpreterNeeded(String isInterpreterNeeded) {
		this.isInterpreterNeeded = isInterpreterNeeded;
	}

	@Column(name= "PRIMARY_LANGUAGE") // BIGINT(20)
	public Integer getPrimaryLanguage() {
		return this.primaryLanguage;
	}
	public void setPrimaryLanguage(Integer primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}

	@Column(name= "SECONDARY_LANGUAGE") // BIGINT(20)
	public Integer getSecondaryLanguage() {
		return this.secondaryLanguage;
	}
	public void setSecondaryLanguage(Integer secondaryLanguage) {
		this.secondaryLanguage = secondaryLanguage;
	}

	@Column(name= "PICTURE") // BLOB
	public String getPicture() {
		return this.picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name= "PICTURE_NAME") // VARCHAR(75)
	public String getPictureName() {
		return this.pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	@Column(name= "PICITURE_UP_USER") // BIGINT(20)
	public Integer getPictureUploadUser() {
		return this.pictureUploadUser;
	}
	public void setPictureUploadUser(Integer pictureUploadUser) {
		this.pictureUploadUser = pictureUploadUser;
	}

	@Column(name= "PICTURE_UP_DT") // DATE
	public Date getPictureUploadDate() {
		return this.pictureUploadDate;
	}
	public void setPictureUploadDate(Date pictureUploadDate) {
		this.pictureUploadDate = pictureUploadDate;
	}

	@Column(name= "PICTURE_DEL_USER") // BIGINT(20)
	public Integer getPictureDeleteUser() {
		return this.pictureDeleteUser;
	}
	public void setPictureDeleteUser(Integer pictureDeleteUser) {
		this.pictureDeleteUser = pictureDeleteUser;
	}

	@Column(name= "PICTURE_DEL_DT") // DATE
	public Date getPictureDelteDate() {
		return this.pictureDeleteDate;
	}
	public void setPictureDeleteDate(Date pictureDeleteDate) {
		this.pictureDeleteDate = pictureDeleteDate;
	}

	@Column(name= "PICTURE_TYPE") // VARCHAR(5)
	public String getPictureType() {
		return this.pictureType;
	}
	public void setPictureType(String pictureType) {
		this.pictureType = pictureType;
	}

	@Column(name= "RACE_KEY") // BIGINT(20)
	public Integer getRaceKey() {
		return this.raceKey;
	}
	public void setRaceKey(Integer raceKey) {
		this.raceKey = raceKey;
	}

	@Column(name= "HOMELESS_STATUS_KEY") // BIGINT(20),
	public Integer getHomelessStatusKey() {
		return this.homelessStatusKey;
	}
	public void setHomelessStatusKey(Integer homelessStatusKey) {
		this.homelessStatusKey = homelessStatusKey;
	}

	@Column(name= "INCOME_QUESTION") // BIGINT(20)
	public Integer getIncomeQuestion() {
		return this.incomeQuestion;
	}
	public void setIncomeQuestion(Integer incomeQuestion) {
		this.incomeQuestion = incomeQuestion;
	}

	@Column(name= "INCOME_DATE") // DATE
	public Date getIncomeDate() {
		return this.incomeDate;
	}
	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}

	@Column(name= "NON_CASH_QUESTION") // BIGINT(20)
	public Integer getNonCashQuestion() {
		return this.nonCashQuestion;
	}
	public void setNonCashQuestion(Integer nonCashQuestion) {
		this.nonCashQuestion = nonCashQuestion;
	}

	@Column(name= "NON_CASH_DATE") // BIGINT(20)
	public Integer getNonCashDate() {
		return this.nonCashDate;
	}
	public void setNonCashDate(Integer nonCashDate) {
		this.nonCashDate = nonCashDate;
	}

	@Column(name= "IS_EMPLOYED") // BIGINT(20)
	public Integer getIsEmployed() {
		return this.isEmployed;
	}
	public void setIsEmployed(Integer isEmployed) {
		this.isEmployed = isEmployed;
	}

	@Column(name= "TENURE") // BIGINT(20)
	public Integer getTenure() {
		return this.tenure;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	@Column(name= "VOLUNTEER") // CHAR(1)
	public String getIsVolunteer() {
		return this.isVolunteer;
	}
	public void setIsVolunteer(String isVolunteer) {
		this.isVolunteer = isVolunteer;
	}

	@Column(name= "IS_BASIC") // CHAR(1) DEFAULT 'N'
	public String getIsBasic() {
		return this.isBasic;
	}
	public void setIsBasic(String isBasic) {
		this.isBasic = isBasic;
	}

	@Column(name= "UPDATE_TIMESTAMP") // TIMESTAMP
	public Timestamp getUpdateTimestamp() {
		return this.updateTimestamp;
	}
	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	@Column(name= "MIGRATION_FLAG") // CHAR(2)
	public String getMigrationFlag() {
		return this.migrationFlag;
	}
	public void setMigrationFlag(String migrationFlag) {
		this.migrationFlag = migrationFlag;
	}

	@Column(name= "IS_COORD") // CHAR(1)
	public String getIsCoord() {
		return this.isCoord;
	}
	public void setIsCoord(String isCoord) {
		this.isCoord = isCoord;
	}

	@Column(name= "GENDER_DESC") // VARCHAR(60)
	public String getGenderDescription() {
		return this.genderDescription;
	}
	public void setGenderDescription(String genderDescription) {
		this.genderDescription = genderDescription;
	}

	@Column(name= "HEALTH_INS_QUESTION") // BIGINT(20)
	public Integer getHealthInsuranceQuestion() {
		return this.healthInsuranceQuestion;
	}
	public void setHealthInsuranceQuestion(Integer healthInsuranceQuestion) {
		this.healthInsuranceQuestion = healthInsuranceQuestion;
	}

	@Column(name= "HEALTH_INS_DATE") // DATE
	public Date getHealthInsuranceDate() {
		return this.healthInsuranceDate;
	}
	public void setHealthInsuranceDate(Date healthInsuranceDate) {
		this.healthInsuranceDate = healthInsuranceDate;
	}

	@Column(name= "OTHER_IDENTIFICATION") // VARCHAR(30)
	public String getOtherIdentification() {
		return this.otherIdentification;
	}
	public void setOtherIdentification(String otherIdentification) {
		this.otherIdentification = otherIdentification;
	}

	@Column(name= "OTHER_IDENTIFICATION_NUM") // VARCHAR(20)
	public String getOtherIdentificationNumber() {
		return this.otherIdentificationNumber;
	}
	public void setOtherIdentificationNumber(String otherIdentificationNumber) {
		this.otherIdentificationNumber = otherIdentificationNumber;
	}

	@Column(name= "IDENTIFICATION") // VARCHAR(20)
	public String getIdentification() {
		return this.identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}

	@Column(name= "ID_TYPE") // BIGINT(20)
	public Integer getIdentificationType() {
		return this.identificationType;
	}
	public void setIdentificationType(Integer identificationType) {
		this.identificationType = identificationType;
	}

	@Column(name= "LAST_NAME") // VARCHAR(50)
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name= "FIRST_NAME") // VARCHAR(50)
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name= "MIDDLE_NAME") // VARCHAR(50)
	public String getMiddleName() {
		return this.middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name= "GENDER_KEY") // BIGINT(20)
	public Integer getGenderKey() {
		return this.genderKey;
	}
	public void setGenderKey(Integer genderKey) {
		this.genderKey = genderKey;
	}

	@Column(name= "ETHNICITY_KEY") // BIGINT(20)
	public Integer getEthnicityKey() {
		return this.ethnicityKey;
	}
	public void setEthnicityKey(Integer ethnicityKey) {
		this.ethnicityKey = ethnicityKey;
	}

	@Column(name= "CREATE_DATE") // DATE
	public Date getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name= "CREATE_USER_KEY") // BIGINT(20)
	public Integer getCreateUserKey() {
		return this.createUserKey;
	}
	public void setCreateUserKey(Integer createUserKey) {
		this.createUserKey = createUserKey;
	}

	@Column(name= "SUFFIX") // VARCHAR(20)
	public String getSuffix() {
		return this.suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Column(name= "DOB_TYPE") // BIGINT(20)
	public Integer getDobType() {
		return this.dobType;
	}
	public void setDobType(Integer dobType) {
		this.dobType = dobType;
	}

	@Column(name= "NAME_TYPE") // BIGINT(20)
	public Integer getNameType() {
		return this.nameType;
	}
	public void setNameType(Integer nameType){
		this.nameType = nameType;
	}
}