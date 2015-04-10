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
 * ClientHousehold entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_HOUSEHOLD", catalog = "OPENHMIS2")
public class ClientHousehold implements java.io.Serializable {

	// Fields

	private Long id;
	private Long householdKey;
	private Long clientKey;
	private Integer activeInHouseholdGct;
	private Integer relationshipCode;
	private Timestamp dateEntered;
	private Timestamp dateLeft;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ClientHousehold() {
	}

	/** minimal constructor */
	public ClientHousehold(Long householdKey, Long clientKey,
			Timestamp logDateTime) {
		this.householdKey = householdKey;
		this.clientKey = clientKey;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ClientHousehold(Long householdKey, Long clientKey,
			Integer activeInHouseholdGct, Integer relationshipCode,
			Timestamp dateEntered, Timestamp dateLeft, Integer recActiveGct,
			Timestamp entryDateTime, Long entryUserKey, Timestamp logDateTime,
			Long logUserKey) {
		this.householdKey = householdKey;
		this.clientKey = clientKey;
		this.activeInHouseholdGct = activeInHouseholdGct;
		this.relationshipCode = relationshipCode;
		this.dateEntered = dateEntered;
		this.dateLeft = dateLeft;
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

	@Column(name = "HOUSEHOLD_KEY", nullable = false)
	public Long getHouseholdKey() {
		return this.householdKey;
	}

	public void setHouseholdKey(Long householdKey) {
		this.householdKey = householdKey;
	}

	@Column(name = "CLIENT_KEY", nullable = false)
	public Long getClientKey() {
		return this.clientKey;
	}

	public void setClientKey(Long clientKey) {
		this.clientKey = clientKey;
	}

	@Column(name = "ACTIVE_IN_HOUSEHOLD_GCT")
	public Integer getActiveInHouseholdGct() {
		return this.activeInHouseholdGct;
	}

	public void setActiveInHouseholdGct(Integer activeInHouseholdGct) {
		this.activeInHouseholdGct = activeInHouseholdGct;
	}

	@Column(name = "RELATIONSHIP_CODE")
	public Integer getRelationshipCode() {
		return this.relationshipCode;
	}

	public void setRelationshipCode(Integer relationshipCode) {
		this.relationshipCode = relationshipCode;
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