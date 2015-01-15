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
 * ClientVeteranInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_VETERAN_INFO", catalog = "OPENHMIS2")
public class ClientVeteranInfo implements java.io.Serializable {

	// Fields

	private Long veteranInfoKey;
	private Long clientKey;
	private Long previousVetInfoKey;
	private Date informationDate;
	private Integer yearEnteredMilitary;
	private Integer yearLeftMilitary;
	private Integer servedInTheatreGct;
	private Integer militaryBranchCode;
	private Integer militaryDischargeCode;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ClientVeteranInfo() {
	}

	/** minimal constructor */
	public ClientVeteranInfo(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ClientVeteranInfo(Long clientKey, Long previousVetInfoKey,
			Date informationDate, Integer yearEnteredMilitary,
			Integer yearLeftMilitary, Integer servedInTheatreGct,
			Integer militaryBranchCode, Integer militaryDischargeCode,
			Integer recActiveGct, Timestamp entryDateTime, Long entryUserKey,
			Timestamp logDateTime, Long logUserKey) {
		this.clientKey = clientKey;
		this.previousVetInfoKey = previousVetInfoKey;
		this.informationDate = informationDate;
		this.yearEnteredMilitary = yearEnteredMilitary;
		this.yearLeftMilitary = yearLeftMilitary;
		this.servedInTheatreGct = servedInTheatreGct;
		this.militaryBranchCode = militaryBranchCode;
		this.militaryDischargeCode = militaryDischargeCode;
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
	@Column(name = "VETERAN_INFO_KEY", unique = true, nullable = false)
	public Long getVeteranInfoKey() {
		return this.veteranInfoKey;
	}

	public void setVeteranInfoKey(Long veteranInfoKey) {
		this.veteranInfoKey = veteranInfoKey;
	}

	@Column(name = "CLIENT_KEY")
	public Long getClientKey() {
		return this.clientKey;
	}

	public void setClientKey(Long clientKey) {
		this.clientKey = clientKey;
	}

	@Column(name = "PREVIOUS_VET_INFO_KEY")
	public Long getPreviousVetInfoKey() {
		return this.previousVetInfoKey;
	}

	public void setPreviousVetInfoKey(Long previousVetInfoKey) {
		this.previousVetInfoKey = previousVetInfoKey;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "INFORMATION_DATE", length = 10)
	public Date getInformationDate() {
		return this.informationDate;
	}

	public void setInformationDate(Date informationDate) {
		this.informationDate = informationDate;
	}

	@Column(name = "YEAR_ENTERED_MILITARY")
	public Integer getYearEnteredMilitary() {
		return this.yearEnteredMilitary;
	}

	public void setYearEnteredMilitary(Integer yearEnteredMilitary) {
		this.yearEnteredMilitary = yearEnteredMilitary;
	}

	@Column(name = "YEAR_LEFT_MILITARY")
	public Integer getYearLeftMilitary() {
		return this.yearLeftMilitary;
	}

	public void setYearLeftMilitary(Integer yearLeftMilitary) {
		this.yearLeftMilitary = yearLeftMilitary;
	}

	@Column(name = "SERVED_IN_THEATRE_GCT")
	public Integer getServedInTheatreGct() {
		return this.servedInTheatreGct;
	}

	public void setServedInTheatreGct(Integer servedInTheatreGct) {
		this.servedInTheatreGct = servedInTheatreGct;
	}

	@Column(name = "MILITARY_BRANCH_CODE")
	public Integer getMilitaryBranchCode() {
		return this.militaryBranchCode;
	}

	public void setMilitaryBranchCode(Integer militaryBranchCode) {
		this.militaryBranchCode = militaryBranchCode;
	}

	@Column(name = "MILITARY_DISCHARGE_CODE")
	public Integer getMilitaryDischargeCode() {
		return this.militaryDischargeCode;
	}

	public void setMilitaryDischargeCode(Integer militaryDischargeCode) {
		this.militaryDischargeCode = militaryDischargeCode;
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