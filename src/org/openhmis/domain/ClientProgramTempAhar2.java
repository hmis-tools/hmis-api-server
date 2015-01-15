/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ClientProgramTempAhar2 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_PROGRAM_TEMP_AHAR_2", catalog = "OPENHMIS2")
public class ClientProgramTempAhar2 implements java.io.Serializable {

	// Fields

	private Integer rowId;
	private Double programKey;
	private Double clientKey;
	private Double age;
	private Double genderKey;
	private Double raceKey;
	private Double ethnicityKey;
	private Double veteran;
	private Double disablingCondition;
	private Double programNameKey;
	private Double programTypeKey;
	private Double agencyKey;
	private Timestamp entryDate1;
	private Timestamp exitDate1;
	private String servedFlag;
	private Timestamp entryDate;
	private Timestamp exitDate;
	private Double householdKey;
	private String noHousehold;
	private Double householdSize;
	private String familyFlag;
	private Double numOfAdult;
	private Double numOfChild;
	private Double numOfUnknown;
	private Double priorNightsResidenceKey;
	private String zipcodeLastPermAddress;
	private Double lengthOfStayKey;
	private Double zipQualityCode;
	private Double recordId;
	private Double groupKey;
	private Timestamp dateEntered;
	private Timestamp dateLeft;
	private String firstEntry;
	private Timestamp dateOfBirth;
	private Timestamp housingStatusEntryDate;
	private Double destinationKey;
	private String lastEntry;
	private String lastExit;
	private String newClientStatus;

	// Constructors

	/** default constructor */
	public ClientProgramTempAhar2() {
	}

	/** full constructor */
	public ClientProgramTempAhar2(Double programKey, Double clientKey,
			Double age, Double genderKey, Double raceKey, Double ethnicityKey,
			Double veteran, Double disablingCondition, Double programNameKey,
			Double programTypeKey, Double agencyKey, Timestamp entryDate1,
			Timestamp exitDate1, String servedFlag, Timestamp entryDate,
			Timestamp exitDate, Double householdKey, String noHousehold,
			Double householdSize, String familyFlag, Double numOfAdult,
			Double numOfChild, Double numOfUnknown,
			Double priorNightsResidenceKey, String zipcodeLastPermAddress,
			Double lengthOfStayKey, Double zipQualityCode, Double recordId,
			Double groupKey, Timestamp dateEntered, Timestamp dateLeft,
			String firstEntry, Timestamp dateOfBirth,
			Timestamp housingStatusEntryDate, Double destinationKey,
			String lastEntry, String lastExit, String newClientStatus) {
		this.programKey = programKey;
		this.clientKey = clientKey;
		this.age = age;
		this.genderKey = genderKey;
		this.raceKey = raceKey;
		this.ethnicityKey = ethnicityKey;
		this.veteran = veteran;
		this.disablingCondition = disablingCondition;
		this.programNameKey = programNameKey;
		this.programTypeKey = programTypeKey;
		this.agencyKey = agencyKey;
		this.entryDate1 = entryDate1;
		this.exitDate1 = exitDate1;
		this.servedFlag = servedFlag;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.householdKey = householdKey;
		this.noHousehold = noHousehold;
		this.householdSize = householdSize;
		this.familyFlag = familyFlag;
		this.numOfAdult = numOfAdult;
		this.numOfChild = numOfChild;
		this.numOfUnknown = numOfUnknown;
		this.priorNightsResidenceKey = priorNightsResidenceKey;
		this.zipcodeLastPermAddress = zipcodeLastPermAddress;
		this.lengthOfStayKey = lengthOfStayKey;
		this.zipQualityCode = zipQualityCode;
		this.recordId = recordId;
		this.groupKey = groupKey;
		this.dateEntered = dateEntered;
		this.dateLeft = dateLeft;
		this.firstEntry = firstEntry;
		this.dateOfBirth = dateOfBirth;
		this.housingStatusEntryDate = housingStatusEntryDate;
		this.destinationKey = destinationKey;
		this.lastEntry = lastEntry;
		this.lastExit = lastExit;
		this.newClientStatus = newClientStatus;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ROW_ID", unique = true, nullable = false)
	public Integer getRowId() {
		return this.rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	@Column(name = "PROGRAM_KEY", precision = 22, scale = 0)
	public Double getProgramKey() {
		return this.programKey;
	}

	public void setProgramKey(Double programKey) {
		this.programKey = programKey;
	}

	@Column(name = "CLIENT_KEY", precision = 22, scale = 0)
	public Double getClientKey() {
		return this.clientKey;
	}

	public void setClientKey(Double clientKey) {
		this.clientKey = clientKey;
	}

	@Column(name = "AGE", precision = 22, scale = 0)
	public Double getAge() {
		return this.age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	@Column(name = "GENDER_KEY", precision = 22, scale = 0)
	public Double getGenderKey() {
		return this.genderKey;
	}

	public void setGenderKey(Double genderKey) {
		this.genderKey = genderKey;
	}

	@Column(name = "RACE_KEY", precision = 22, scale = 0)
	public Double getRaceKey() {
		return this.raceKey;
	}

	public void setRaceKey(Double raceKey) {
		this.raceKey = raceKey;
	}

	@Column(name = "ETHNICITY_KEY", precision = 22, scale = 0)
	public Double getEthnicityKey() {
		return this.ethnicityKey;
	}

	public void setEthnicityKey(Double ethnicityKey) {
		this.ethnicityKey = ethnicityKey;
	}

	@Column(name = "VETERAN", precision = 22, scale = 0)
	public Double getVeteran() {
		return this.veteran;
	}

	public void setVeteran(Double veteran) {
		this.veteran = veteran;
	}

	@Column(name = "DISABLING_CONDITION", precision = 22, scale = 0)
	public Double getDisablingCondition() {
		return this.disablingCondition;
	}

	public void setDisablingCondition(Double disablingCondition) {
		this.disablingCondition = disablingCondition;
	}

	@Column(name = "PROGRAM_NAME_KEY", precision = 22, scale = 0)
	public Double getProgramNameKey() {
		return this.programNameKey;
	}

	public void setProgramNameKey(Double programNameKey) {
		this.programNameKey = programNameKey;
	}

	@Column(name = "PROGRAM_TYPE_KEY", precision = 22, scale = 0)
	public Double getProgramTypeKey() {
		return this.programTypeKey;
	}

	public void setProgramTypeKey(Double programTypeKey) {
		this.programTypeKey = programTypeKey;
	}

	@Column(name = "AGENCY_KEY", precision = 22, scale = 0)
	public Double getAgencyKey() {
		return this.agencyKey;
	}

	public void setAgencyKey(Double agencyKey) {
		this.agencyKey = agencyKey;
	}

	@Column(name = "ENTRY_DATE_1", length = 19)
	public Timestamp getEntryDate1() {
		return this.entryDate1;
	}

	public void setEntryDate1(Timestamp entryDate1) {
		this.entryDate1 = entryDate1;
	}

	@Column(name = "EXIT_DATE_1", length = 19)
	public Timestamp getExitDate1() {
		return this.exitDate1;
	}

	public void setExitDate1(Timestamp exitDate1) {
		this.exitDate1 = exitDate1;
	}

	@Column(name = "SERVED_FLAG", length = 2)
	public String getServedFlag() {
		return this.servedFlag;
	}

	public void setServedFlag(String servedFlag) {
		this.servedFlag = servedFlag;
	}

	@Column(name = "ENTRY_DATE", length = 19)
	public Timestamp getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Timestamp entryDate) {
		this.entryDate = entryDate;
	}

	@Column(name = "EXIT_DATE", length = 19)
	public Timestamp getExitDate() {
		return this.exitDate;
	}

	public void setExitDate(Timestamp exitDate) {
		this.exitDate = exitDate;
	}

	@Column(name = "HOUSEHOLD_KEY", precision = 22, scale = 0)
	public Double getHouseholdKey() {
		return this.householdKey;
	}

	public void setHouseholdKey(Double householdKey) {
		this.householdKey = householdKey;
	}

	@Column(name = "NO_HOUSEHOLD", length = 2)
	public String getNoHousehold() {
		return this.noHousehold;
	}

	public void setNoHousehold(String noHousehold) {
		this.noHousehold = noHousehold;
	}

	@Column(name = "HOUSEHOLD_SIZE", precision = 22, scale = 0)
	public Double getHouseholdSize() {
		return this.householdSize;
	}

	public void setHouseholdSize(Double householdSize) {
		this.householdSize = householdSize;
	}

	@Column(name = "FAMILY_FLAG", length = 2)
	public String getFamilyFlag() {
		return this.familyFlag;
	}

	public void setFamilyFlag(String familyFlag) {
		this.familyFlag = familyFlag;
	}

	@Column(name = "NUM_OF_ADULT", precision = 22, scale = 0)
	public Double getNumOfAdult() {
		return this.numOfAdult;
	}

	public void setNumOfAdult(Double numOfAdult) {
		this.numOfAdult = numOfAdult;
	}

	@Column(name = "NUM_OF_CHILD", precision = 22, scale = 0)
	public Double getNumOfChild() {
		return this.numOfChild;
	}

	public void setNumOfChild(Double numOfChild) {
		this.numOfChild = numOfChild;
	}

	@Column(name = "NUM_OF_UNKNOWN", precision = 22, scale = 0)
	public Double getNumOfUnknown() {
		return this.numOfUnknown;
	}

	public void setNumOfUnknown(Double numOfUnknown) {
		this.numOfUnknown = numOfUnknown;
	}

	@Column(name = "PRIOR_NIGHTS_RESIDENCE_KEY", precision = 22, scale = 0)
	public Double getPriorNightsResidenceKey() {
		return this.priorNightsResidenceKey;
	}

	public void setPriorNightsResidenceKey(Double priorNightsResidenceKey) {
		this.priorNightsResidenceKey = priorNightsResidenceKey;
	}

	@Column(name = "ZIPCODE_LAST_PERM_ADDRESS", length = 50)
	public String getZipcodeLastPermAddress() {
		return this.zipcodeLastPermAddress;
	}

	public void setZipcodeLastPermAddress(String zipcodeLastPermAddress) {
		this.zipcodeLastPermAddress = zipcodeLastPermAddress;
	}

	@Column(name = "LENGTH_OF_STAY_KEY", precision = 22, scale = 0)
	public Double getLengthOfStayKey() {
		return this.lengthOfStayKey;
	}

	public void setLengthOfStayKey(Double lengthOfStayKey) {
		this.lengthOfStayKey = lengthOfStayKey;
	}

	@Column(name = "ZIP_QUALITY_CODE", precision = 22, scale = 0)
	public Double getZipQualityCode() {
		return this.zipQualityCode;
	}

	public void setZipQualityCode(Double zipQualityCode) {
		this.zipQualityCode = zipQualityCode;
	}

	@Column(name = "RECORD_ID", precision = 22, scale = 0)
	public Double getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Double recordId) {
		this.recordId = recordId;
	}

	@Column(name = "GROUP_KEY", precision = 22, scale = 0)
	public Double getGroupKey() {
		return this.groupKey;
	}

	public void setGroupKey(Double groupKey) {
		this.groupKey = groupKey;
	}

	@Column(name = "DATE_ENTERED", length = 19)
	public Timestamp getDateEntered() {
		return this.dateEntered;
	}

	public void setDateEntered(Timestamp dateEntered) {
		this.dateEntered = dateEntered;
	}

	@Column(name = "DATE_LEFT", length = 19)
	public Timestamp getDateLeft() {
		return this.dateLeft;
	}

	public void setDateLeft(Timestamp dateLeft) {
		this.dateLeft = dateLeft;
	}

	@Column(name = "FIRST_ENTRY", length = 2)
	public String getFirstEntry() {
		return this.firstEntry;
	}

	public void setFirstEntry(String firstEntry) {
		this.firstEntry = firstEntry;
	}

	@Column(name = "DATE_OF_BIRTH", length = 19)
	public Timestamp getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Timestamp dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "HOUSING_STATUS_ENTRY_DATE", length = 19)
	public Timestamp getHousingStatusEntryDate() {
		return this.housingStatusEntryDate;
	}

	public void setHousingStatusEntryDate(Timestamp housingStatusEntryDate) {
		this.housingStatusEntryDate = housingStatusEntryDate;
	}

	@Column(name = "DESTINATION_KEY", precision = 22, scale = 0)
	public Double getDestinationKey() {
		return this.destinationKey;
	}

	public void setDestinationKey(Double destinationKey) {
		this.destinationKey = destinationKey;
	}

	@Column(name = "LAST_ENTRY", length = 2)
	public String getLastEntry() {
		return this.lastEntry;
	}

	public void setLastEntry(String lastEntry) {
		this.lastEntry = lastEntry;
	}

	@Column(name = "LAST_EXIT", length = 2)
	public String getLastExit() {
		return this.lastExit;
	}

	public void setLastExit(String lastExit) {
		this.lastExit = lastExit;
	}

	@Column(name = "NEW_CLIENT_STATUS", length = 2)
	public String getNewClientStatus() {
		return this.newClientStatus;
	}

	public void setNewClientStatus(String newClientStatus) {
		this.newClientStatus = newClientStatus;
	}

}