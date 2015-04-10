/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * CodeEthnicity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CODE_ETHNICITY", catalog = "OPENHMIS2")
public class CodeEthnicity implements java.io.Serializable {

	// Fields

	private Integer codeKey;
	private String description;
	private String shortDesc;
	private String notes;
	private Integer recActiveGct;
	private Timestamp logDateTime;
	private Long logUserKey;
	private Set<Client> clients = new HashSet<Client>(0);

	// Constructors

	/** default constructor */
	public CodeEthnicity() {
	}

	/** minimal constructor */
	public CodeEthnicity(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public CodeEthnicity(String description, String shortDesc, String notes,
			Integer recActiveGct, Timestamp logDateTime, Long logUserKey,
			Set<Client> clients) {
		this.description = description;
		this.shortDesc = shortDesc;
		this.notes = notes;
		this.recActiveGct = recActiveGct;
		this.logDateTime = logDateTime;
		this.logUserKey = logUserKey;
		this.clients = clients;
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

	@Column(name = "SHORT_DESC", length = 200)
	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	@Column(name = "NOTES")
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "codeEthnicity")
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}