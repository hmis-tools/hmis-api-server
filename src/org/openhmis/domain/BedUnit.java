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
 * BedUnit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BED_UNIT", catalog = "OPENHMIS2")
public class BedUnit implements java.io.Serializable {

	// Fields

	private Long id;
	private Long projectKey;
	private Integer householdTypeCode;
	private Integer bedTypeCode;
	private Integer availabilityCode;
	private Integer bedInventory;
	private Integer chBedInventory;
	private Integer unitInventory;
	private Date inventoryStartDate;
	private Date inventoryEndDate;
	private Integer hmisParticipatingBeds;
	private Date hmisStartDate;
	private Date hmisEndDate;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public BedUnit() {
	}

	/** minimal constructor */
	public BedUnit(Long projectKey, Timestamp logDateTime) {
		this.projectKey = projectKey;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public BedUnit(Long projectKey, Integer householdTypeCode,
			Integer bedTypeCode, Integer availabilityCode,
			Integer bedInventory, Integer chBedInventory,
			Integer unitInventory, Date inventoryStartDate,
			Date inventoryEndDate, Integer hmisParticipatingBeds,
			Date hmisStartDate, Date hmisEndDate, Integer recActiveGct,
			Timestamp entryDateTime, Long entryUserKey, Timestamp logDateTime,
			Long logUserKey) {
		this.projectKey = projectKey;
		this.householdTypeCode = householdTypeCode;
		this.bedTypeCode = bedTypeCode;
		this.availabilityCode = availabilityCode;
		this.bedInventory = bedInventory;
		this.chBedInventory = chBedInventory;
		this.unitInventory = unitInventory;
		this.inventoryStartDate = inventoryStartDate;
		this.inventoryEndDate = inventoryEndDate;
		this.hmisParticipatingBeds = hmisParticipatingBeds;
		this.hmisStartDate = hmisStartDate;
		this.hmisEndDate = hmisEndDate;
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

	@Column(name = "PROJECT_KEY", nullable = false)
	public Long getProjectKey() {
		return this.projectKey;
	}

	public void setProjectKey(Long projectKey) {
		this.projectKey = projectKey;
	}

	@Column(name = "HOUSEHOLD_TYPE_CODE")
	public Integer getHouseholdTypeCode() {
		return this.householdTypeCode;
	}

	public void setHouseholdTypeCode(Integer householdTypeCode) {
		this.householdTypeCode = householdTypeCode;
	}

	@Column(name = "BED_TYPE_CODE")
	public Integer getBedTypeCode() {
		return this.bedTypeCode;
	}

	public void setBedTypeCode(Integer bedTypeCode) {
		this.bedTypeCode = bedTypeCode;
	}

	@Column(name = "AVAILABILITY_CODE")
	public Integer getAvailabilityCode() {
		return this.availabilityCode;
	}

	public void setAvailabilityCode(Integer availabilityCode) {
		this.availabilityCode = availabilityCode;
	}

	@Column(name = "BED_INVENTORY")
	public Integer getBedInventory() {
		return this.bedInventory;
	}

	public void setBedInventory(Integer bedInventory) {
		this.bedInventory = bedInventory;
	}

	@Column(name = "CH_BED_INVENTORY")
	public Integer getChBedInventory() {
		return this.chBedInventory;
	}

	public void setChBedInventory(Integer chBedInventory) {
		this.chBedInventory = chBedInventory;
	}

	@Column(name = "UNIT_INVENTORY")
	public Integer getUnitInventory() {
		return this.unitInventory;
	}

	public void setUnitInventory(Integer unitInventory) {
		this.unitInventory = unitInventory;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "INVENTORY_START_DATE", length = 10)
	public Date getInventoryStartDate() {
		return this.inventoryStartDate;
	}

	public void setInventoryStartDate(Date inventoryStartDate) {
		this.inventoryStartDate = inventoryStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "INVENTORY_END_DATE", length = 10)
	public Date getInventoryEndDate() {
		return this.inventoryEndDate;
	}

	public void setInventoryEndDate(Date inventoryEndDate) {
		this.inventoryEndDate = inventoryEndDate;
	}

	@Column(name = "HMIS_PARTICIPATING_BEDS")
	public Integer getHmisParticipatingBeds() {
		return this.hmisParticipatingBeds;
	}

	public void setHmisParticipatingBeds(Integer hmisParticipatingBeds) {
		this.hmisParticipatingBeds = hmisParticipatingBeds;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HMIS_START_DATE", length = 10)
	public Date getHmisStartDate() {
		return this.hmisStartDate;
	}

	public void setHmisStartDate(Date hmisStartDate) {
		this.hmisStartDate = hmisStartDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HMIS_END_DATE", length = 10)
	public Date getHmisEndDate() {
		return this.hmisEndDate;
	}

	public void setHmisEndDate(Date hmisEndDate) {
		this.hmisEndDate = hmisEndDate;
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