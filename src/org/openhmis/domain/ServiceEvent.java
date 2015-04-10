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
 * ServiceEvent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SERVICE_EVENT", catalog = "OPENHMIS2")
public class ServiceEvent implements java.io.Serializable {

	// Fields

	private Long id;
	private Long clientKey;
	private Long taxonomyCode;
	private Date serviceDate;
	private Integer outcomeCode;
	private String note;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ServiceEvent() {
	}

	/** minimal constructor */
	public ServiceEvent(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ServiceEvent(Long clientKey, Long taxonomyCode, Date serviceDate,
			Integer outcomeCode, String note, Integer recActiveGct,
			Timestamp entryDateTime, Long entryUserKey, Timestamp logDateTime,
			Long logUserKey) {
		this.clientKey = clientKey;
		this.taxonomyCode = taxonomyCode;
		this.serviceDate = serviceDate;
		this.outcomeCode = outcomeCode;
		this.note = note;
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

	@Column(name = "CLIENT_KEY")
	public Long getClientKey() {
		return this.clientKey;
	}

	public void setClientKey(Long clientKey) {
		this.clientKey = clientKey;
	}

	@Column(name = "TAXONOMY_CODE")
	public Long getTaxonomyCode() {
		return this.taxonomyCode;
	}

	public void setTaxonomyCode(Long taxonomyCode) {
		this.taxonomyCode = taxonomyCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SERVICE_DATE", length = 10)
	public Date getServiceDate() {
		return this.serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	@Column(name = "OUTCOME_CODE")
	public Integer getOutcomeCode() {
		return this.outcomeCode;
	}

	public void setOutcomeCode(Integer outcomeCode) {
		this.outcomeCode = outcomeCode;
	}

	@Column(name = "NOTE", length = 4000)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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