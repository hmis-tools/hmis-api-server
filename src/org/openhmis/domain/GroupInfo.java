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
 * GroupInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "GROUP_INFO", catalog = "OPENHMIS2")
public class GroupInfo implements java.io.Serializable {

	// Fields

	private Long groupKey;
	private String name;
	private Integer typeCode;
	private String description;
	private String city;
	private String county;
	private Integer stateCode;
	private String hudCocId;
	private String hudCocName;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public GroupInfo() {
	}

	/** minimal constructor */
	public GroupInfo(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public GroupInfo(String name, Integer typeCode, String description,
			String city, String county, Integer stateCode, String hudCocId,
			String hudCocName, Integer recActiveGct, Timestamp entryDateTime,
			Long entryUserKey, Timestamp logDateTime, Long logUserKey) {
		this.name = name;
		this.typeCode = typeCode;
		this.description = description;
		this.city = city;
		this.county = county;
		this.stateCode = stateCode;
		this.hudCocId = hudCocId;
		this.hudCocName = hudCocName;
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
	@Column(name = "GROUP_KEY", unique = true, nullable = false)
	public Long getGroupKey() {
		return this.groupKey;
	}

	public void setGroupKey(Long groupKey) {
		this.groupKey = groupKey;
	}

	@Column(name = "NAME", length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TYPE_CODE")
	public Integer getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(Integer typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name = "DESCRIPTION", length = 400)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "CITY", length = 40)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "COUNTY", length = 40)
	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name = "STATE_CODE")
	public Integer getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	@Column(name = "HUD_COC_ID", length = 40)
	public String getHudCocId() {
		return this.hudCocId;
	}

	public void setHudCocId(String hudCocId) {
		this.hudCocId = hudCocId;
	}

	@Column(name = "HUD_COC_NAME", length = 120)
	public String getHudCocName() {
		return this.hudCocName;
	}

	public void setHudCocName(String hudCocName) {
		this.hudCocName = hudCocName;
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