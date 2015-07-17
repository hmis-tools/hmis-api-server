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
 * Agency entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PATH_AGENCY")
public class Agency implements java.io.Serializable {


	// Universal Fields
	private Long agencyKey;
	private String agencyName;
	private String agencyShortName;

	// Compass Fields
	private String email;
	private String address1;
	private String address2;
	private String city;
	private Integer stateKey;
	private String zip;
	private String isPathAgency;
	private String referralEmail;
	private Integer authDuration;
	private String agencyInformation;
	private Integer regionKey;
	private String isActive;
	private String phone;
	private String fax;
	private String isEricaAgency;
	private String isMedAccess;
	private String isReferralAccess;
	private String isProtected;
	private String isShelter;
	private String county;
	private Integer shelterTypeKey;
	private String description;
	private Integer privacyLevel; 
	private String websiteUrl;
	private String isShortIntake;
	private String mailingAddress1;
	private String mailingAddress2;
	private String mailingCity;
	private Integer mailingStateKey;
	private String mailingZip;
	private String hours;
	private String eligibility;
	private String fees;
	private String intakeProcess;
	private String serviceArea;
	private String handicapAccess;
	private String isDoctorAppointmentAccess;
	private String isShortDischarge ;
	private Integer amountUserDevice;
	private String hasXmlImportAccess;
	private Integer uploadMaxSize;
	private Integer documentMaxSize;
	private String isDirectService;
	private Integer timeZoneAdjustment;
	private String agencyLegalName;
	private String execDirectorFirstName;
	private String execDirectorLastName;
	private String execDirectorPhone;
	private String execDirectorEmail;
	private Timestamp updateTimestamp;
	private String migrationFlag;


	// Constructors

	/** default constructor */
	public Agency() {
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "AGENCY_KEY", unique = true, nullable = false)
	public Long getAgencyKey() {
		return this.agencyKey;
	}
	public void setAgencyKey(Long agencyKey) {
		this.agencyKey = agencyKey;
	}

	@Column(name = "AGENCY_NAME", length = 300)
	public String getAgencyName() {
		return this.agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	@Column(name = "AGENCY_SHORT", length = 30)
	public String getAgencyShortName() {
		return this.agencyShortName;
	}
	public void setAgencyShortName(String agencyShortName) {
		this.agencyShortName = agencyShortName;
	}

  	@Column(name = "EMAIL")  //` VARCHAR(100),
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

  	@Column(name = "ADDRESS1")  //` VARCHAR(100),
	public String getAddress1() {
		return this.address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

  	@Column(name = "ADDRESS2")  //` VARCHAR(100),
	public String getAddress2() {
		return this.address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

  	@Column(name = "CITY")  //` VARCHAR(100),
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}

  	@Column(name = "STATE_KEY")  //` BIGINT(20),
	public Integer getStateKey() {
		return this.stateKey;
	}
	public void setStateKey(Integer stateKey) {
		this.stateKey = stateKey;
	}

  	@Column(name = "ZIP")  //` VARCHAR(20),
	public String getZip() {
		return this.zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

  	@Column(name = "PATH_AGENCY")  //` CHAR(1),
	public String getIsPathAgency() {
		return this.isPathAgency;
	}
	public void setIsPathAgency(String isPathAgency) {
		this.isPathAgency = isPathAgency;
	}

  	@Column(name = "REFERRAL_EMAIL")  //` VARCHAR(100),
	public String getReferralEmail() {
		return this.referralEmail;
	}
	public void setReferralEmail(String referralEmail) {
		this.referralEmail = referralEmail;
	}

  	@Column(name = "AUTH_DURATION")  //` BIGINT(20),
	public Integer getAuthDuration() {
		return this.authDuration;
	}
	public void setAuthDuration(Integer authDuration) {
		this.authDuration = authDuration;
	}

  	@Column(name = "AGENCY_INFORMATION")  //` TEXT,
	public String getAgencyInformation() {
		return this.agencyInformation;
	}
	public void setAgencyInformation(String agencyInformation) {
		this.agencyInformation = agencyInformation;
	}

  	@Column(name = "REGION_KEY")  //` BIGINT(20),
	public Integer getRegionKey() {
		return this.regionKey;
	}
	public void setRegionKey(Integer regionKey) {
		this.regionKey = regionKey;
	}

  	@Column(name = "ACTIVE")  //` CHAR(1),
	public String getIsActive() {
		return this.isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

  	@Column(name = "PHONE")  //` VARCHAR(30),
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

  	@Column(name = "FAX")  //` VARCHAR(30),
	public String getFax() {
		return this.fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}

  	@Column(name = "ERICA_AGENCY")  //` CHAR(1),
	public String getIsEricaAgency() {
		return this.isEricaAgency;
	}
	public void setIsEricaAgency(String isEricaAgency) {
		this.isEricaAgency = isEricaAgency;
	}

  	@Column(name = "MED_ACCESS")  //` CHAR(1),
	public String getIsMedAccess() {
		return this.isMedAccess;
	}
	public void setIsMedAccess(String isMedAccess) {
		this.isMedAccess = isMedAccess;
	}

  	@Column(name = "REFERRAL_ACCESS")  //` CHAR(1),
	public String getIsReferralAccess() {
		return this.isReferralAccess;
	}
	public void setIsReferralAccess(String isReferralAccess) {
		this.isReferralAccess = isReferralAccess;
	}

  	@Column(name = "PROTECTED")  //` CHAR(1) DEFAULT 'N',
	public String getIsProtected() {
		return this.isProtected;
	}
	public void setIsProtected(String isProtected) {
		this.isProtected = isProtected;
	}

  	@Column(name = "SHELTER")  //` CHAR(1) DEFAULT 'N',
	public String getIsShelter() {
		return this.isShelter;
	}
	public void setIsShelter(String isShelter) {
		this.isShelter = isShelter;
	}

  	@Column(name = "COUNTY")  //` VARCHAR(25),
	public String getCounty() {
		return this.county;
	}
	public void setCounty(String county) {
		this.county = county;
	}

  	@Column(name = "SHELTER_TYPE_KEY")  //` BIGINT(20),
	public Integer getShelterTypeKey() {
		return this.shelterTypeKey;
	}
	public void setShelterTypeKey(Integer shelterTypeKey) {
		this.shelterTypeKey = shelterTypeKey;
	}

  	@Column(name = "DESCRIPTION")  //` TEXT,
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

  	@Column(name = "PRIVACY_LEVEL")  //` BIGINT(20) DEFAULT 0,
	public Integer getPrivacyLevel() {
		return this.privacyLevel;
	}
	public void setPrivacyLevel(Integer privacyLevel) {
		this.privacyLevel = privacyLevel;
	}

  	@Column(name = "WEBSITE_URL")  //` VARCHAR(255),
	public String getWebsiteUrl() {
		return this.websiteUrl;
	}
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

  	@Column(name = "SHORT_INTAKE")  //` CHAR(1) DEFAULT 'N',
	public String getIsShortIntake() {
		return this.isShortIntake;
	}
	public void setIsShortIntake(String isShortIntake) {
		this.isShortIntake = isShortIntake;
	}

  	@Column(name = "MAILING_ADDRESS1")  //` VARCHAR(100),
	public String getMailingAddress1() {
		return this.mailingAddress1;
	}
	public void setMailingAddress1(String mailingAddress1) {
		this.mailingAddress1 = mailingAddress1;
	}

  	@Column(name = "MAILING_ADDRESS2")  //` VARCHAR(100),
	public String getMailingAddress2() {
		return this.mailingAddress2;
	}
	public void setMailingAddress2(String mailingAddress2) {
		this.mailingAddress2 = mailingAddress2;
	}

  	@Column(name = "MAILING_CITY")  //` VARCHAR(100),
	public String getMailingCity() {
		return this.mailingCity;
	}
	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}

  	@Column(name = "MAILING_STATE_KEY")  //` BIGINT(20),
	public Integer getMailingStateKey() {
		return this.mailingStateKey;
	}
	public void set(Integer mailingStateKey) {
		this.mailingStateKey = mailingStateKey;
	}

  	@Column(name = "MAILING_ZIP")  //` VARCHAR(20),
	public String getMailingZip() {
		return this.mailingZip;
	}
	public void setMailingZip(String mailingZip) {
		this.mailingZip = mailingZip;
	}

  	@Column(name = "HOURS")  //` VARCHAR(20),
	public String getHours() {
		return this.hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}

  	@Column(name = "ELIGIBILITY")  //` VARCHAR(100),
	public String getEligibility() {
		return this.eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

  	@Column(name = "FEES")  //` VARCHAR(100),
	public String getFees() {
		return this.fees;
	}
	public void setFees(String fees) {
		this.fees = fees;
	}

  	@Column(name = "INTAKE_PROCESS")  //` VARCHAR(100),
	public String getIntakeProcess() {
		return this.intakeProcess;
	}
	public void setIntakeProcess(String intakeProcess) {
		this.intakeProcess = intakeProcess;
	}

  	@Column(name = "SERVICE_AREA")  //` VARCHAR(100),
	public String getServiceArea() {
		return this.serviceArea;
	}
	public void setServiceArea(String serviceArea) {
		this.serviceArea = serviceArea;
	}

  	@Column(name = "HANDICAP_ACCESS")  //` VARCHAR(100),
	public String getHandicapAccess() {
		return this.handicapAccess;
	}
	public void setHandicapAccess(String handicapAccess) {
		this.handicapAccess = handicapAccess;
	}

  	@Column(name = "DOCTOR_APPOINTMENT_ACCESS")  //` CHAR(1) DEFAULT 'N',
	public String getIsDoctorAppointmentAccess() {
		return this.isDoctorAppointmentAccess;
	}
	public void setIsDoctorAppointmentAccess(String isDoctorAppointmentAccess) {
		this.isDoctorAppointmentAccess = isDoctorAppointmentAccess;
	}

  	@Column(name = "SHORT_DISCHARGE")  //` CHAR(1) DEFAULT 'N',
	public String getIsShortDischarge() {
		return this.isShortDischarge;
	}
	public void setIsShortDischarge(String isShortDischarge) {
		this.isShortDischarge = isShortDischarge;
	}

  	@Column(name = "AMOUNT_USER_DEVICE")  //` BIGINT(20) DEFAULT 1,
	public Integer getAmountUserDevice() {
		return this.amountUserDevice;
	}
	public void setAmountUserDevice(Integer amountUserDevice) {
		this.amountUserDevice = amountUserDevice;
	}

  	@Column(name = "XML_IMPORT_ACCESS")  //` CHAR(1) DEFAULT  'N',
	public String getXmlImportAccess() {
		return this.hasXmlImportAccess;
	}
	public void setXmlImportAcess(String hasXmlImportAccess) {
		this.hasXmlImportAccess = hasXmlImportAccess;
	}

  	@Column(name = "UPLOAD_MAX_SIZE")  //` BIGINT(20) DEFAULT 524150574,
	public Integer getUploadMaxSize() {
		return this.uploadMaxSize;
	}
	public void setUploadMaxSize(Integer uploadMaxSize) {
		this.uploadMaxSize = uploadMaxSize;
	}

  	@Column(name = "DOCUMENT_MAX_SIZE")  //` BIGINT(20) DEFAULT 1048576, 
	public Integer getDocumentMaxSize() {
		return this.documentMaxSize;
	}
	public void setDocumentMaxSize(Integer documentMaxSize) {
		this.documentMaxSize = documentMaxSize;
	}

  	@Column(name = "DIRECT_SERVICE")  //` CHAR(1),
	public String getDirectService() {
		return this.isDirectService;
	}
	public void setDirectService(String isDirectService) {
		this.isDirectService = isDirectService;
	}

  	@Column(name = "TIME_ZONE_ADJUSTMENT")  //` BIGINT(20),
	public Integer getTimeZoneAdjustment() {
		return this.timeZoneAdjustment;
	}
	public void setTimeZoneAdjustment(Integer timeZoneAdjustment) {
		this.timeZoneAdjustment = timeZoneAdjustment;
	}

  	@Column(name = "AGENCY_LEGAL_NAME")  //` VARCHAR(100),
	public String getAgencyLegalName() {
		return this.agencyLegalName;
	}
	public void setAgencyLegalName(String agencyLegalName) {
		this.agencyLegalName = agencyLegalName;
	}

  	@Column(name = "EXEC_DIRECTOR_FIRST_NAME")  //` VARCHAR(100), 
	public String getExecDirectorFirstName() {
		return this.execDirectorFirstName;
	}
	public void setExecDirectorFirstName(String execDirectorFirstName) {
		this.execDirectorFirstName = execDirectorFirstName;
	}

  	@Column(name = "EXEC_DIRECTOR_LAST_NAME")  //` VARCHAR(100), 
	public String getExecDirectorLastName() {
		return this.execDirectorLastName;
	}
	public void setExecDirectorLastName(String execDirectorLastName) {
		this.execDirectorLastName = execDirectorLastName;
	}

  	@Column(name = "EXEC_DIRECTOR_PHONE")  //` VARCHAR(30), 
	public String getExecDirectorPhone() {
		return this.execDirectorPhone;
	}
	public void setExecDirectorPhone(String execDirectorPhone) {
		this.execDirectorPhone = execDirectorPhone;
	}

  	@Column(name = "EXEC_DIRECTOR_EMAIL")  //` VARCHAR(100), 
	public String getExecDirectorEmail() {
		return this.execDirectorEmail;
	}
	public void setExecDirectorEmail(String execDirectorEmail) {
		this.execDirectorEmail = execDirectorEmail;
	}

  	@Column(name = "UPDATE_TIMESTAMP")  //` TIMESTAMP, 
	public Timestamp getUpdateTimestamp() {
		return this.updateTimestamp;
	}
	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

  	@Column(name = "MIGRATION_FLAG")  //` CHAR(2),
	public String getMigrationFlag() {
		return this.migrationFlag;
	}
	public void setMigrationFlag(String migrationFlag) {
		this.migrationFlag = migrationFlag;
	}

}