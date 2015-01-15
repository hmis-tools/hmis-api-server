/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ClientProgramTempAhar1Id entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ClientProgramTempAhar1Id implements java.io.Serializable {

	// Fields

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
	public ClientProgramTempAhar1Id() {
	}

	/** full constructor */
	public ClientProgramTempAhar1Id(Double programKey, Double clientKey,
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ClientProgramTempAhar1Id))
			return false;
		ClientProgramTempAhar1Id castOther = (ClientProgramTempAhar1Id) other;

		return ((this.getProgramKey() == castOther.getProgramKey()) || (this
				.getProgramKey() != null && castOther.getProgramKey() != null && this
				.getProgramKey().equals(castOther.getProgramKey())))
				&& ((this.getClientKey() == castOther.getClientKey()) || (this
						.getClientKey() != null
						&& castOther.getClientKey() != null && this
						.getClientKey().equals(castOther.getClientKey())))
				&& ((this.getAge() == castOther.getAge()) || (this.getAge() != null
						&& castOther.getAge() != null && this.getAge().equals(
						castOther.getAge())))
				&& ((this.getGenderKey() == castOther.getGenderKey()) || (this
						.getGenderKey() != null
						&& castOther.getGenderKey() != null && this
						.getGenderKey().equals(castOther.getGenderKey())))
				&& ((this.getRaceKey() == castOther.getRaceKey()) || (this
						.getRaceKey() != null && castOther.getRaceKey() != null && this
						.getRaceKey().equals(castOther.getRaceKey())))
				&& ((this.getEthnicityKey() == castOther.getEthnicityKey()) || (this
						.getEthnicityKey() != null
						&& castOther.getEthnicityKey() != null && this
						.getEthnicityKey().equals(castOther.getEthnicityKey())))
				&& ((this.getVeteran() == castOther.getVeteran()) || (this
						.getVeteran() != null && castOther.getVeteran() != null && this
						.getVeteran().equals(castOther.getVeteran())))
				&& ((this.getDisablingCondition() == castOther
						.getDisablingCondition()) || (this
						.getDisablingCondition() != null
						&& castOther.getDisablingCondition() != null && this
						.getDisablingCondition().equals(
								castOther.getDisablingCondition())))
				&& ((this.getProgramNameKey() == castOther.getProgramNameKey()) || (this
						.getProgramNameKey() != null
						&& castOther.getProgramNameKey() != null && this
						.getProgramNameKey().equals(
								castOther.getProgramNameKey())))
				&& ((this.getProgramTypeKey() == castOther.getProgramTypeKey()) || (this
						.getProgramTypeKey() != null
						&& castOther.getProgramTypeKey() != null && this
						.getProgramTypeKey().equals(
								castOther.getProgramTypeKey())))
				&& ((this.getAgencyKey() == castOther.getAgencyKey()) || (this
						.getAgencyKey() != null
						&& castOther.getAgencyKey() != null && this
						.getAgencyKey().equals(castOther.getAgencyKey())))
				&& ((this.getEntryDate1() == castOther.getEntryDate1()) || (this
						.getEntryDate1() != null
						&& castOther.getEntryDate1() != null && this
						.getEntryDate1().equals(castOther.getEntryDate1())))
				&& ((this.getExitDate1() == castOther.getExitDate1()) || (this
						.getExitDate1() != null
						&& castOther.getExitDate1() != null && this
						.getExitDate1().equals(castOther.getExitDate1())))
				&& ((this.getServedFlag() == castOther.getServedFlag()) || (this
						.getServedFlag() != null
						&& castOther.getServedFlag() != null && this
						.getServedFlag().equals(castOther.getServedFlag())))
				&& ((this.getEntryDate() == castOther.getEntryDate()) || (this
						.getEntryDate() != null
						&& castOther.getEntryDate() != null && this
						.getEntryDate().equals(castOther.getEntryDate())))
				&& ((this.getExitDate() == castOther.getExitDate()) || (this
						.getExitDate() != null
						&& castOther.getExitDate() != null && this
						.getExitDate().equals(castOther.getExitDate())))
				&& ((this.getHouseholdKey() == castOther.getHouseholdKey()) || (this
						.getHouseholdKey() != null
						&& castOther.getHouseholdKey() != null && this
						.getHouseholdKey().equals(castOther.getHouseholdKey())))
				&& ((this.getNoHousehold() == castOther.getNoHousehold()) || (this
						.getNoHousehold() != null
						&& castOther.getNoHousehold() != null && this
						.getNoHousehold().equals(castOther.getNoHousehold())))
				&& ((this.getHouseholdSize() == castOther.getHouseholdSize()) || (this
						.getHouseholdSize() != null
						&& castOther.getHouseholdSize() != null && this
						.getHouseholdSize()
						.equals(castOther.getHouseholdSize())))
				&& ((this.getFamilyFlag() == castOther.getFamilyFlag()) || (this
						.getFamilyFlag() != null
						&& castOther.getFamilyFlag() != null && this
						.getFamilyFlag().equals(castOther.getFamilyFlag())))
				&& ((this.getNumOfAdult() == castOther.getNumOfAdult()) || (this
						.getNumOfAdult() != null
						&& castOther.getNumOfAdult() != null && this
						.getNumOfAdult().equals(castOther.getNumOfAdult())))
				&& ((this.getNumOfChild() == castOther.getNumOfChild()) || (this
						.getNumOfChild() != null
						&& castOther.getNumOfChild() != null && this
						.getNumOfChild().equals(castOther.getNumOfChild())))
				&& ((this.getNumOfUnknown() == castOther.getNumOfUnknown()) || (this
						.getNumOfUnknown() != null
						&& castOther.getNumOfUnknown() != null && this
						.getNumOfUnknown().equals(castOther.getNumOfUnknown())))
				&& ((this.getPriorNightsResidenceKey() == castOther
						.getPriorNightsResidenceKey()) || (this
						.getPriorNightsResidenceKey() != null
						&& castOther.getPriorNightsResidenceKey() != null && this
						.getPriorNightsResidenceKey().equals(
								castOther.getPriorNightsResidenceKey())))
				&& ((this.getZipcodeLastPermAddress() == castOther
						.getZipcodeLastPermAddress()) || (this
						.getZipcodeLastPermAddress() != null
						&& castOther.getZipcodeLastPermAddress() != null && this
						.getZipcodeLastPermAddress().equals(
								castOther.getZipcodeLastPermAddress())))
				&& ((this.getLengthOfStayKey() == castOther
						.getLengthOfStayKey()) || (this.getLengthOfStayKey() != null
						&& castOther.getLengthOfStayKey() != null && this
						.getLengthOfStayKey().equals(
								castOther.getLengthOfStayKey())))
				&& ((this.getZipQualityCode() == castOther.getZipQualityCode()) || (this
						.getZipQualityCode() != null
						&& castOther.getZipQualityCode() != null && this
						.getZipQualityCode().equals(
								castOther.getZipQualityCode())))
				&& ((this.getRecordId() == castOther.getRecordId()) || (this
						.getRecordId() != null
						&& castOther.getRecordId() != null && this
						.getRecordId().equals(castOther.getRecordId())))
				&& ((this.getGroupKey() == castOther.getGroupKey()) || (this
						.getGroupKey() != null
						&& castOther.getGroupKey() != null && this
						.getGroupKey().equals(castOther.getGroupKey())))
				&& ((this.getDateEntered() == castOther.getDateEntered()) || (this
						.getDateEntered() != null
						&& castOther.getDateEntered() != null && this
						.getDateEntered().equals(castOther.getDateEntered())))
				&& ((this.getDateLeft() == castOther.getDateLeft()) || (this
						.getDateLeft() != null
						&& castOther.getDateLeft() != null && this
						.getDateLeft().equals(castOther.getDateLeft())))
				&& ((this.getFirstEntry() == castOther.getFirstEntry()) || (this
						.getFirstEntry() != null
						&& castOther.getFirstEntry() != null && this
						.getFirstEntry().equals(castOther.getFirstEntry())))
				&& ((this.getDateOfBirth() == castOther.getDateOfBirth()) || (this
						.getDateOfBirth() != null
						&& castOther.getDateOfBirth() != null && this
						.getDateOfBirth().equals(castOther.getDateOfBirth())))
				&& ((this.getHousingStatusEntryDate() == castOther
						.getHousingStatusEntryDate()) || (this
						.getHousingStatusEntryDate() != null
						&& castOther.getHousingStatusEntryDate() != null && this
						.getHousingStatusEntryDate().equals(
								castOther.getHousingStatusEntryDate())))
				&& ((this.getDestinationKey() == castOther.getDestinationKey()) || (this
						.getDestinationKey() != null
						&& castOther.getDestinationKey() != null && this
						.getDestinationKey().equals(
								castOther.getDestinationKey())))
				&& ((this.getLastEntry() == castOther.getLastEntry()) || (this
						.getLastEntry() != null
						&& castOther.getLastEntry() != null && this
						.getLastEntry().equals(castOther.getLastEntry())))
				&& ((this.getLastExit() == castOther.getLastExit()) || (this
						.getLastExit() != null
						&& castOther.getLastExit() != null && this
						.getLastExit().equals(castOther.getLastExit())))
				&& ((this.getNewClientStatus() == castOther
						.getNewClientStatus()) || (this.getNewClientStatus() != null
						&& castOther.getNewClientStatus() != null && this
						.getNewClientStatus().equals(
								castOther.getNewClientStatus())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getProgramKey() == null ? 0 : this.getProgramKey()
						.hashCode());
		result = 37 * result
				+ (getClientKey() == null ? 0 : this.getClientKey().hashCode());
		result = 37 * result
				+ (getAge() == null ? 0 : this.getAge().hashCode());
		result = 37 * result
				+ (getGenderKey() == null ? 0 : this.getGenderKey().hashCode());
		result = 37 * result
				+ (getRaceKey() == null ? 0 : this.getRaceKey().hashCode());
		result = 37
				* result
				+ (getEthnicityKey() == null ? 0 : this.getEthnicityKey()
						.hashCode());
		result = 37 * result
				+ (getVeteran() == null ? 0 : this.getVeteran().hashCode());
		result = 37
				* result
				+ (getDisablingCondition() == null ? 0 : this
						.getDisablingCondition().hashCode());
		result = 37
				* result
				+ (getProgramNameKey() == null ? 0 : this.getProgramNameKey()
						.hashCode());
		result = 37
				* result
				+ (getProgramTypeKey() == null ? 0 : this.getProgramTypeKey()
						.hashCode());
		result = 37 * result
				+ (getAgencyKey() == null ? 0 : this.getAgencyKey().hashCode());
		result = 37
				* result
				+ (getEntryDate1() == null ? 0 : this.getEntryDate1()
						.hashCode());
		result = 37 * result
				+ (getExitDate1() == null ? 0 : this.getExitDate1().hashCode());
		result = 37
				* result
				+ (getServedFlag() == null ? 0 : this.getServedFlag()
						.hashCode());
		result = 37 * result
				+ (getEntryDate() == null ? 0 : this.getEntryDate().hashCode());
		result = 37 * result
				+ (getExitDate() == null ? 0 : this.getExitDate().hashCode());
		result = 37
				* result
				+ (getHouseholdKey() == null ? 0 : this.getHouseholdKey()
						.hashCode());
		result = 37
				* result
				+ (getNoHousehold() == null ? 0 : this.getNoHousehold()
						.hashCode());
		result = 37
				* result
				+ (getHouseholdSize() == null ? 0 : this.getHouseholdSize()
						.hashCode());
		result = 37
				* result
				+ (getFamilyFlag() == null ? 0 : this.getFamilyFlag()
						.hashCode());
		result = 37
				* result
				+ (getNumOfAdult() == null ? 0 : this.getNumOfAdult()
						.hashCode());
		result = 37
				* result
				+ (getNumOfChild() == null ? 0 : this.getNumOfChild()
						.hashCode());
		result = 37
				* result
				+ (getNumOfUnknown() == null ? 0 : this.getNumOfUnknown()
						.hashCode());
		result = 37
				* result
				+ (getPriorNightsResidenceKey() == null ? 0 : this
						.getPriorNightsResidenceKey().hashCode());
		result = 37
				* result
				+ (getZipcodeLastPermAddress() == null ? 0 : this
						.getZipcodeLastPermAddress().hashCode());
		result = 37
				* result
				+ (getLengthOfStayKey() == null ? 0 : this.getLengthOfStayKey()
						.hashCode());
		result = 37
				* result
				+ (getZipQualityCode() == null ? 0 : this.getZipQualityCode()
						.hashCode());
		result = 37 * result
				+ (getRecordId() == null ? 0 : this.getRecordId().hashCode());
		result = 37 * result
				+ (getGroupKey() == null ? 0 : this.getGroupKey().hashCode());
		result = 37
				* result
				+ (getDateEntered() == null ? 0 : this.getDateEntered()
						.hashCode());
		result = 37 * result
				+ (getDateLeft() == null ? 0 : this.getDateLeft().hashCode());
		result = 37
				* result
				+ (getFirstEntry() == null ? 0 : this.getFirstEntry()
						.hashCode());
		result = 37
				* result
				+ (getDateOfBirth() == null ? 0 : this.getDateOfBirth()
						.hashCode());
		result = 37
				* result
				+ (getHousingStatusEntryDate() == null ? 0 : this
						.getHousingStatusEntryDate().hashCode());
		result = 37
				* result
				+ (getDestinationKey() == null ? 0 : this.getDestinationKey()
						.hashCode());
		result = 37 * result
				+ (getLastEntry() == null ? 0 : this.getLastEntry().hashCode());
		result = 37 * result
				+ (getLastExit() == null ? 0 : this.getLastExit().hashCode());
		result = 37
				* result
				+ (getNewClientStatus() == null ? 0 : this.getNewClientStatus()
						.hashCode());
		return result;
	}

}