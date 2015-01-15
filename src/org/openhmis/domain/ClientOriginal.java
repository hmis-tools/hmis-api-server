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
 * ClientOriginal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_ORIGINAL", catalog = "OPENHMIS2")
public class ClientOriginal implements java.io.Serializable {

	// Fields

	private Long clientKey;
	private String nameMiddle;
	private String nameLast;
	private String nameFirst;
	private String nameSuffix;
	private Integer socSecTypeCode;
	private String socSecNumber;
	private Integer dobTypeCode;
	private Date dateOfBirth;
	private Integer ethnicityCode;
	private Integer genderCode;
	private Integer veteranStatusGct;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ClientOriginal() {
	}

	/** minimal constructor */
	public ClientOriginal(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ClientOriginal(String nameMiddle, String nameLast, String nameFirst,
			String nameSuffix, Integer socSecTypeCode, String socSecNumber,
			Integer dobTypeCode, Date dateOfBirth, Integer ethnicityCode,
			Integer genderCode, Integer veteranStatusGct, Integer recActiveGct,
			Timestamp entryDateTime, Long entryUserKey, Timestamp logDateTime,
			Long logUserKey) {
		this.nameMiddle = nameMiddle;
		this.nameLast = nameLast;
		this.nameFirst = nameFirst;
		this.nameSuffix = nameSuffix;
		this.socSecTypeCode = socSecTypeCode;
		this.socSecNumber = socSecNumber;
		this.dobTypeCode = dobTypeCode;
		this.dateOfBirth = dateOfBirth;
		this.ethnicityCode = ethnicityCode;
		this.genderCode = genderCode;
		this.veteranStatusGct = veteranStatusGct;
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
	@Column(name = "CLIENT_KEY", unique = true, nullable = false)
	public Long getClientKey() {
		return this.clientKey;
	}

	public void setClientKey(Long clientKey) {
		this.clientKey = clientKey;
	}

	@Column(name = "NAME_MIDDLE", length = 200)
	public String getNameMiddle() {
		return this.nameMiddle;
	}

	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}

	@Column(name = "NAME_LAST", length = 200)
	public String getNameLast() {
		return this.nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	@Column(name = "NAME_FIRST", length = 200)
	public String getNameFirst() {
		return this.nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	@Column(name = "NAME_SUFFIX", length = 200)
	public String getNameSuffix() {
		return this.nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	@Column(name = "SOC_SEC_TYPE_CODE")
	public Integer getSocSecTypeCode() {
		return this.socSecTypeCode;
	}

	public void setSocSecTypeCode(Integer socSecTypeCode) {
		this.socSecTypeCode = socSecTypeCode;
	}

	@Column(name = "SOC_SEC_NUMBER", length = 40)
	public String getSocSecNumber() {
		return this.socSecNumber;
	}

	public void setSocSecNumber(String socSecNumber) {
		this.socSecNumber = socSecNumber;
	}

	@Column(name = "DOB_TYPE_CODE")
	public Integer getDobTypeCode() {
		return this.dobTypeCode;
	}

	public void setDobTypeCode(Integer dobTypeCode) {
		this.dobTypeCode = dobTypeCode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_OF_BIRTH", length = 10)
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "ETHNICITY_CODE")
	public Integer getEthnicityCode() {
		return this.ethnicityCode;
	}

	public void setEthnicityCode(Integer ethnicityCode) {
		this.ethnicityCode = ethnicityCode;
	}

	@Column(name = "GENDER_CODE")
	public Integer getGenderCode() {
		return this.genderCode;
	}

	public void setGenderCode(Integer genderCode) {
		this.genderCode = genderCode;
	}

	@Column(name = "VETERAN_STATUS_GCT")
	public Integer getVeteranStatusGct() {
		return this.veteranStatusGct;
	}

	public void setVeteranStatusGct(Integer veteranStatusGct) {
		this.veteranStatusGct = veteranStatusGct;
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