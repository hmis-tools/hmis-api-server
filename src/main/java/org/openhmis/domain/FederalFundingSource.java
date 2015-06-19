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
 * FederalFundingSource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "FEDERAL_FUNDING_SOURCE", catalog = "OPENHMIS2")
public class FederalFundingSource implements java.io.Serializable {

	// Fields

	private Long id;
	private Long projectKey;
	private Integer fedFundSrcCode;
	private String otherDescription;
	private String grantId;
	private Integer recActiveGct;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public FederalFundingSource() {
	}

	/** minimal constructor */
	public FederalFundingSource(Long projectKey, Timestamp logDateTime) {
		this.projectKey = projectKey;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public FederalFundingSource(Long projectKey, Integer fedFundSrcCode,
			String otherDescription, String grantId, Integer recActiveGct,
			Timestamp logDateTime, Long logUserKey) {
		this.projectKey = projectKey;
		this.fedFundSrcCode = fedFundSrcCode;
		this.otherDescription = otherDescription;
		this.grantId = grantId;
		this.recActiveGct = recActiveGct;
		this.logDateTime = logDateTime;
		this.logUserKey = logUserKey;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PROJECT_KEY", nullable = false)
	public Long getProjectKey() {
		return this.projectKey;
	}

	public void setProjectKey(Long projectKey) {
		this.projectKey = projectKey;
	}

	@Column(name = "FED_FUND_SRC_CODE")
	public Integer getFedFundSrcCode() {
		return this.fedFundSrcCode;
	}

	public void setFedFundSrcCode(Integer fedFundSrcCode) {
		this.fedFundSrcCode = fedFundSrcCode;
	}

	@Column(name = "OTHER_DESCRIPTION", length = 100)
	public String getOtherDescription() {
		return this.otherDescription;
	}

	public void setOtherDescription(String otherDescription) {
		this.otherDescription = otherDescription;
	}

	@Column(name = "GRANT_ID", length = 200)
	public String getGrantId() {
		return this.grantId;
	}

	public void setGrantId(String grantId) {
		this.grantId = grantId;
	}

	@Column(name = "REC_ACTIVE_GCT")
	public Integer getRecActiveGct() {
		return this.recActiveGct;
	}

	public void setRecActiveGct(Integer recActiveGct) {
		this.recActiveGct = recActiveGct;
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