/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.journaldev.spring.model;

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
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "USER_INFO", catalog = "OPENHMIS2")
public class UserInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userKey;
	private Long agencyKey;
	private String userId;
	private String passwordEnc;
	private Date pwExpireDate;
	private String nameFirst;
	private String nameLast;
	private Integer userActiveGct;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public UserInfo(Long agencyKey, String userId, String passwordEnc,
			Date pwExpireDate, String nameFirst, String nameLast,
			Integer userActiveGct, Integer recActiveGct,
			Timestamp entryDateTime, Long entryUserKey, Timestamp logDateTime,
			Long logUserKey) {
		this.agencyKey = agencyKey;
		this.userId = userId;
		this.passwordEnc = passwordEnc;
		this.pwExpireDate = pwExpireDate;
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.userActiveGct = userActiveGct;
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
	@Column(name = "USER_KEY", unique = true, nullable = false)
	public Long getUserKey() {
		return this.userKey;
	}

	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}

	@Column(name = "AGENCY_KEY")
	public Long getAgencyKey() {
		return this.agencyKey;
	}

	public void setAgencyKey(Long agencyKey) {
		this.agencyKey = agencyKey;
	}

	@Column(name = "USER_ID", length = 200)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PASSWORD_ENC", length = 200)
	public String getPasswordEnc() {
		return this.passwordEnc;
	}

	public void setPasswordEnc(String passwordEnc) {
		this.passwordEnc = passwordEnc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PW_EXPIRE_DATE", length = 10)
	public Date getPwExpireDate() {
		return this.pwExpireDate;
	}

	public void setPwExpireDate(Date pwExpireDate) {
		this.pwExpireDate = pwExpireDate;
	}

	@Column(name = "NAME_FIRST", length = 200)
	public String getNameFirst() {
		return this.nameFirst;
	}

	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	@Column(name = "NAME_LAST", length = 200)
	public String getNameLast() {
		return this.nameLast;
	}

	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	@Column(name = "USER_ACTIVE_GCT")
	public Integer getUserActiveGct() {
		return this.userActiveGct;
	}

	public void setUserActiveGct(Integer userActiveGct) {
		this.userActiveGct = userActiveGct;
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