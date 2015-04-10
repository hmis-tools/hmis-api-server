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
 * CodeTaxonomy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CODE_TAXONOMY", catalog = "OPENHMIS2")
public class CodeTaxonomy implements java.io.Serializable {

	// Fields

	private Long codeKey;
	private Long parentKey;
	private String taxonomyId;
	private String taxonomyDescription;
	private String keywords;
	private Integer recActiveGct;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public CodeTaxonomy() {
	}

	/** minimal constructor */
	public CodeTaxonomy(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public CodeTaxonomy(Long parentKey, String taxonomyId,
			String taxonomyDescription, String keywords, Integer recActiveGct,
			Timestamp logDateTime, Long logUserKey) {
		this.parentKey = parentKey;
		this.taxonomyId = taxonomyId;
		this.taxonomyDescription = taxonomyDescription;
		this.keywords = keywords;
		this.recActiveGct = recActiveGct;
		this.logDateTime = logDateTime;
		this.logUserKey = logUserKey;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CODE_KEY", unique = true, nullable = false)
	public Long getCodeKey() {
		return this.codeKey;
	}

	public void setCodeKey(Long codeKey) {
		this.codeKey = codeKey;
	}

	@Column(name = "PARENT_KEY")
	public Long getParentKey() {
		return this.parentKey;
	}

	public void setParentKey(Long parentKey) {
		this.parentKey = parentKey;
	}

	@Column(name = "TAXONOMY_ID", length = 200)
	public String getTaxonomyId() {
		return this.taxonomyId;
	}

	public void setTaxonomyId(String taxonomyId) {
		this.taxonomyId = taxonomyId;
	}

	@Column(name = "TAXONOMY_DESCRIPTION", length = 200)
	public String getTaxonomyDescription() {
		return this.taxonomyDescription;
	}

	public void setTaxonomyDescription(String taxonomyDescription) {
		this.taxonomyDescription = taxonomyDescription;
	}

	@Column(name = "KEYWORDS", length = 100)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
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

}