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
 * ClientTheatre entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_THEATRE", catalog = "OPENHMIS2")
public class ClientTheatre implements java.io.Serializable {

	// Fields

	private Long id;
	private Long veteranInfoKey;
	private Integer theatreCode;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ClientTheatre() {
	}

	/** minimal constructor */
	public ClientTheatre(Long veteranInfoKey, Integer theatreCode,
			Timestamp logDateTime) {
		this.veteranInfoKey = veteranInfoKey;
		this.theatreCode = theatreCode;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ClientTheatre(Long veteranInfoKey, Integer theatreCode,
			Integer recActiveGct, Timestamp entryDateTime, Long entryUserKey,
			Timestamp logDateTime, Long logUserKey) {
		this.veteranInfoKey = veteranInfoKey;
		this.theatreCode = theatreCode;
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

	@Column(name = "VETERAN_INFO_KEY", nullable = false)
	public Long getVeteranInfoKey() {
		return this.veteranInfoKey;
	}

	public void setVeteranInfoKey(Long veteranInfoKey) {
		this.veteranInfoKey = veteranInfoKey;
	}

	@Column(name = "THEATRE_CODE", nullable = false)
	public Integer getTheatreCode() {
		return this.theatreCode;
	}

	public void setTheatreCode(Integer theatreCode) {
		this.theatreCode = theatreCode;
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