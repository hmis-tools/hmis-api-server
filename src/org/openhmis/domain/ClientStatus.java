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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * ClientStatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_STATUS", catalog = "OPENHMIS2")
public class ClientStatus implements java.io.Serializable {

	// Fields

	private Long statusKey;
	private Long clientKey;
	private Date informationDate;
	private Long householdKey;
	private Integer headOfHouseholdGct;
	private Integer disablingConditionGct;
	private Integer priorResidenceCode;
	private Integer lengthOfStayCode;
	private Integer priorResFundSrcCode;
	private Integer zipcodeTypeCode;
	private String lastPermZipcode;
	private Integer housingStatusCode;
	private Integer generalHealthCode;
	private Integer pregnancyGct;
	private Date dueDate;
	private Integer lastGradeCompletedCode;
	private Integer schoolStatusCode;
	private Integer employmentStatusCode;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ClientStatus() {
	}

	/** minimal constructor */
	public ClientStatus(Long clientKey, Timestamp logDateTime) {
		this.clientKey = clientKey;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ClientStatus(Long clientKey, Date informationDate,
			Long householdKey, Integer headOfHouseholdGct,
			Integer disablingConditionGct, Integer priorResidenceCode,
			Integer lengthOfStayCode, Integer priorResFundSrcCode,
			Integer zipcodeTypeCode, String lastPermZipcode,
			Integer housingStatusCode, Integer generalHealthCode,
			Integer pregnancyGct, Date dueDate, Integer lastGradeCompletedCode,
			Integer schoolStatusCode, Integer employmentStatusCode,
			Integer recActiveGct, Timestamp entryDateTime, Long entryUserKey,
			Timestamp logDateTime, Long logUserKey) {
		this.clientKey = clientKey;
		this.informationDate = informationDate;
		this.householdKey = householdKey;
		this.headOfHouseholdGct = headOfHouseholdGct;
		this.disablingConditionGct = disablingConditionGct;
		this.priorResidenceCode = priorResidenceCode;
		this.lengthOfStayCode = lengthOfStayCode;
		this.priorResFundSrcCode = priorResFundSrcCode;
		this.zipcodeTypeCode = zipcodeTypeCode;
		this.lastPermZipcode = lastPermZipcode;
		this.housingStatusCode = housingStatusCode;
		this.generalHealthCode = generalHealthCode;
		this.pregnancyGct = pregnancyGct;
		this.dueDate = dueDate;
		this.lastGradeCompletedCode = lastGradeCompletedCode;
		this.schoolStatusCode = schoolStatusCode;
		this.employmentStatusCode = employmentStatusCode;
		this.recActiveGct = recActiveGct;
		this.entryDateTime = entryDateTime;
		this.entryUserKey = entryUserKey;
		this.logDateTime = logDateTime;
		this.logUserKey = logUserKey;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "STATUS_KEY", unique = true, nullable = false)
	public Long getStatusKey() {
		return this.statusKey;
	}

	public void setStatusKey(Long statusKey) {
		this.statusKey = statusKey;
	}

	@Column(name = "CLIENT_KEY", nullable = false)
	public Long getClientKey() {
		return this.clientKey;
	}

	public void setClientKey(Long clientKey) {
		this.clientKey = clientKey;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "INFORMATION_DATE", length = 10)
	public Date getInformationDate() {
		return this.informationDate;
	}

	public void setInformationDate(Date informationDate) {
		this.informationDate = informationDate;
	}

	@Column(name = "HOUSEHOLD_KEY")
	public Long getHouseholdKey() {
		return this.householdKey;
	}

	public void setHouseholdKey(Long householdKey) {
		this.householdKey = householdKey;
	}

	@Column(name = "HEAD_OF_HOUSEHOLD_GCT")
	public Integer getHeadOfHouseholdGct() {
		return this.headOfHouseholdGct;
	}

	public void setHeadOfHouseholdGct(Integer headOfHouseholdGct) {
		this.headOfHouseholdGct = headOfHouseholdGct;
	}

	@Column(name = "DISABLING_CONDITION_GCT")
	public Integer getDisablingConditionGct() {
		return this.disablingConditionGct;
	}

	public void setDisablingConditionGct(Integer disablingConditionGct) {
		this.disablingConditionGct = disablingConditionGct;
	}

	@Column(name = "PRIOR_RESIDENCE_CODE")
	public Integer getPriorResidenceCode() {
		return this.priorResidenceCode;
	}

	public void setPriorResidenceCode(Integer priorResidenceCode) {
		this.priorResidenceCode = priorResidenceCode;
	}

	@Column(name = "LENGTH_OF_STAY_CODE")
	public Integer getLengthOfStayCode() {
		return this.lengthOfStayCode;
	}

	public void setLengthOfStayCode(Integer lengthOfStayCode) {
		this.lengthOfStayCode = lengthOfStayCode;
	}

	@Column(name = "PRIOR_RES_FUND_SRC_CODE")
	public Integer getPriorResFundSrcCode() {
		return this.priorResFundSrcCode;
	}

	public void setPriorResFundSrcCode(Integer priorResFundSrcCode) {
		this.priorResFundSrcCode = priorResFundSrcCode;
	}

	@Column(name = "ZIPCODE_TYPE_CODE")
	public Integer getZipcodeTypeCode() {
		return this.zipcodeTypeCode;
	}

	public void setZipcodeTypeCode(Integer zipcodeTypeCode) {
		this.zipcodeTypeCode = zipcodeTypeCode;
	}

	@Column(name = "LAST_PERM_ZIPCODE", length = 5)
	public String getLastPermZipcode() {
		return this.lastPermZipcode;
	}

	public void setLastPermZipcode(String lastPermZipcode) {
		this.lastPermZipcode = lastPermZipcode;
	}

	@Column(name = "HOUSING_STATUS_CODE")
	public Integer getHousingStatusCode() {
		return this.housingStatusCode;
	}

	public void setHousingStatusCode(Integer housingStatusCode) {
		this.housingStatusCode = housingStatusCode;
	}

	@Column(name = "GENERAL_HEALTH_CODE")
	public Integer getGeneralHealthCode() {
		return this.generalHealthCode;
	}

	public void setGeneralHealthCode(Integer generalHealthCode) {
		this.generalHealthCode = generalHealthCode;
	}

	@Column(name = "PREGNANCY_GCT")
	public Integer getPregnancyGct() {
		return this.pregnancyGct;
	}

	public void setPregnancyGct(Integer pregnancyGct) {
		this.pregnancyGct = pregnancyGct;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DUE_DATE", length = 10)
	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "LAST_GRADE_COMPLETED_CODE")
	public Integer getLastGradeCompletedCode() {
		return this.lastGradeCompletedCode;
	}

	public void setLastGradeCompletedCode(Integer lastGradeCompletedCode) {
		this.lastGradeCompletedCode = lastGradeCompletedCode;
	}

	@Column(name = "SCHOOL_STATUS_CODE")
	public Integer getSchoolStatusCode() {
		return this.schoolStatusCode;
	}

	public void setSchoolStatusCode(Integer schoolStatusCode) {
		this.schoolStatusCode = schoolStatusCode;
	}

	@Column(name = "EMPLOYMENT_STATUS_CODE")
	public Integer getEmploymentStatusCode() {
		return this.employmentStatusCode;
	}

	public void setEmploymentStatusCode(Integer employmentStatusCode) {
		this.employmentStatusCode = employmentStatusCode;
	}

	@Column(name = "REC_ACTIVE_GCT")
	public Integer getRecActiveGct() {
		return this.recActiveGct;
	}

	public void setRecActiveGct(Integer recActiveGct) {
		this.recActiveGct = recActiveGct;
	}

	@Column(name = "ENTRY_DATE_TIME", length = 19)
	public Timestamp getEntryDateTime() {
		return this.entryDateTime;
	}

	public void setEntryDateTime(Timestamp entryDateTime) {
		this.entryDateTime = entryDateTime;
	}

	@Column(name = "ENTRY_USER_KEY")
	public Long getEntryUserKey() {
		return this.entryUserKey;
	}

	public void setEntryUserKey(Long entryUserKey) {
		this.entryUserKey = entryUserKey;
	}

	@Column(name = "LOG_DATE_TIME", nullable = false, length = 19)
	public Timestamp getLogDateTime() {
		return this.logDateTime;
	}

	public void setLogDateTime(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	@Column(name = "LOG_USER_KEY")
	public Long getLogUserKey() {
		return this.logUserKey;
	}

	public void setLogUserKey(Long logUserKey) {
		this.logUserKey = logUserKey;
	}

}