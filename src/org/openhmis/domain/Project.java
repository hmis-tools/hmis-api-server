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
 * Project entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PROJECT", catalog = "OPENHMIS2")
public class Project implements java.io.Serializable {

	// Fields

	private Long projectKey;
	private String projectName;
	private Long agencyKey;
	private Integer cocGroupKey;
	private Long primarySiteKey;
	private Integer maxStayDays;
	private Integer projectTypeCode;
	private Integer targetPopACode;
	private Integer targetPopBCode;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** minimal constructor */
	public Project(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public Project(String projectName, Long agencyKey, Integer cocGroupKey,
			Long primarySiteKey, Integer maxStayDays, Integer projectTypeCode,
			Integer targetPopACode, Integer targetPopBCode,
			Integer recActiveGct, Timestamp entryDateTime, Long entryUserKey,
			Timestamp logDateTime, Long logUserKey) {
		this.projectName = projectName;
		this.agencyKey = agencyKey;
		this.cocGroupKey = cocGroupKey;
		this.primarySiteKey = primarySiteKey;
		this.maxStayDays = maxStayDays;
		this.projectTypeCode = projectTypeCode;
		this.targetPopACode = targetPopACode;
		this.targetPopBCode = targetPopBCode;
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
	@Column(name = "PROJECT_KEY", unique = true, nullable = false)
	public Long getProjectKey() {
		return this.projectKey;
	}

	public void setProjectKey(Long projectKey) {
		this.projectKey = projectKey;
	}

	@Column(name = "PROJECT_NAME", length = 600)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "AGENCY_KEY")
	public Long getAgencyKey() {
		return this.agencyKey;
	}

	public void setAgencyKey(Long agencyKey) {
		this.agencyKey = agencyKey;
	}

	@Column(name = "COC_GROUP_KEY")
	public Integer getCocGroupKey() {
		return this.cocGroupKey;
	}

	public void setCocGroupKey(Integer cocGroupKey) {
		this.cocGroupKey = cocGroupKey;
	}

	@Column(name = "PRIMARY_SITE_KEY")
	public Long getPrimarySiteKey() {
		return this.primarySiteKey;
	}

	public void setPrimarySiteKey(Long primarySiteKey) {
		this.primarySiteKey = primarySiteKey;
	}

	@Column(name = "MAX_STAY_DAYS")
	public Integer getMaxStayDays() {
		return this.maxStayDays;
	}

	public void setMaxStayDays(Integer maxStayDays) {
		this.maxStayDays = maxStayDays;
	}

	@Column(name = "PROJECT_TYPE_CODE")
	public Integer getProjectTypeCode() {
		return this.projectTypeCode;
	}

	public void setProjectTypeCode(Integer projectTypeCode) {
		this.projectTypeCode = projectTypeCode;
	}

	@Column(name = "TARGET_POP_A_CODE")
	public Integer getTargetPopACode() {
		return this.targetPopACode;
	}

	public void setTargetPopACode(Integer targetPopACode) {
		this.targetPopACode = targetPopACode;
	}

	@Column(name = "TARGET_POP_B_CODE")
	public Integer getTargetPopBCode() {
		return this.targetPopBCode;
	}

	public void setTargetPopBCode(Integer targetPopBCode) {
		this.targetPopBCode = targetPopBCode;
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