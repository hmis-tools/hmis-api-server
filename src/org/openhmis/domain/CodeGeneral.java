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
 * CodeGeneral entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CODE_GENERAL", catalog = "OPENHMIS2")
public class CodeGeneral implements java.io.Serializable {

	// Fields

	private Integer codeKey;
	private String description;
	private String shortDescription;
	private Integer recActive;
	private String notes;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public CodeGeneral() {
	}

	/** minimal constructor */
	public CodeGeneral(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public CodeGeneral(String description, String shortDescription,
			Integer recActive, String notes, Timestamp logDateTime,
			Long logUserKey) {
		this.description = description;
		this.shortDescription = shortDescription;
		this.recActive = recActive;
		this.notes = notes;
		this.logDateTime = logDateTime;
		this.logUserKey = logUserKey;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CODE_KEY", unique = true, nullable = false)
	public Integer getCodeKey() {
		return this.codeKey;
	}

	public void setCodeKey(Integer codeKey) {
		this.codeKey = codeKey;
	}

	@Column(name = "DESCRIPTION", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "SHORT_DESCRIPTION", length = 200)
	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Column(name = "REC_ACTIVE")
	public Integer getRecActive() {
		return this.recActive;
	}

	public void setRecActive(Integer recActive) {
		this.recActive = recActive;
	}

	@Column(name = "NOTES", length = 400)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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