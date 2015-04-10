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
 * CodeHousingStatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CODE_HOUSING_STATUS", catalog = "OPENHMIS2")
public class CodeHousingStatus implements java.io.Serializable {

	// Fields

	private Integer codeKey;
	private String description;
	private String shortDesc;
	private String notes;
	private Integer recActiveGct;
	private Timestamp logDateTime;
	private Long logUserKey;
	private String otherDescriptiveFieldsAsNeeded;

	// Constructors

	/** default constructor */
	public CodeHousingStatus() {
	}

	/** minimal constructor */
	public CodeHousingStatus(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public CodeHousingStatus(String description, String shortDesc,
			String notes, Integer recActiveGct, Timestamp logDateTime,
			Long logUserKey, String otherDescriptiveFieldsAsNeeded) {
		this.description = description;
		this.shortDesc = shortDesc;
		this.notes = notes;
		this.recActiveGct = recActiveGct;
		this.logDateTime = logDateTime;
		this.logUserKey = logUserKey;
		this.otherDescriptiveFieldsAsNeeded = otherDescriptiveFieldsAsNeeded;
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

	@Column(name = "DESCRIPTION", length = 300)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "SHORT_DESC", length = 300)
	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	@Column(name = "NOTES", length = 600)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	@Column(name = "OTHER_DESCRIPTIVE_FIELDS_AS_NEEDED", length = 600)
	public String getOtherDescriptiveFieldsAsNeeded() {
		return this.otherDescriptiveFieldsAsNeeded;
	}

	public void setOtherDescriptiveFieldsAsNeeded(
			String otherDescriptiveFieldsAsNeeded) {
		this.otherDescriptiveFieldsAsNeeded = otherDescriptiveFieldsAsNeeded;
	}

}