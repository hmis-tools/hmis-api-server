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
 * AgencyProjGroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AGENCY_PROJ_GROUP", catalog = "OPENHMIS2")
public class AgencyProjGroup implements java.io.Serializable {

	// Fields

	private Long id;
	private Long groupKey;
	private Long agencyKey;
	private Long projectKey;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public AgencyProjGroup() {
	}

	/** minimal constructor */
	public AgencyProjGroup(Long groupKey, Long agencyKey, Timestamp logDateTime) {
		this.groupKey = groupKey;
		this.agencyKey = agencyKey;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public AgencyProjGroup(Long groupKey, Long agencyKey, Long projectKey,
			Integer recActiveGct, Timestamp entryDateTime, Long entryUserKey,
			Timestamp logDateTime, Long logUserKey) {
		this.groupKey = groupKey;
		this.agencyKey = agencyKey;
		this.projectKey = projectKey;
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
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "GROUP_KEY", nullable = false)
	public Long getGroupKey() {
		return this.groupKey;
	}

	public void setGroupKey(Long groupKey) {
		this.groupKey = groupKey;
	}

	@Column(name = "AGENCY_KEY", nullable = false)
	public Long getAgencyKey() {
		return this.agencyKey;
	}

	public void setAgencyKey(Long agencyKey) {
		this.agencyKey = agencyKey;
	}

	@Column(name = "PROJECT_KEY")
	public Long getProjectKey() {
		return this.projectKey;
	}

	public void setProjectKey(Long projectKey) {
		this.projectKey = projectKey;
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