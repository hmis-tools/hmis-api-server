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
 * AgencySite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AGENCY_SITE", catalog = "OPENHMIS2")
public class AgencySite implements java.io.Serializable {

	// Fields

	private Long siteKey;
	private Long agencyKey;
	private Integer agencyPrimarySiteGct;
	private String name;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private Long geocode;
	private Integer configTypeCode;
	private Integer siteTypeCode;
	private Integer housingTypeCode;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public AgencySite() {
	}

	/** minimal constructor */
	public AgencySite(Long agencyKey, Timestamp logDateTime) {
		this.agencyKey = agencyKey;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public AgencySite(Long agencyKey, Integer agencyPrimarySiteGct,
			String name, String address, String city, String state,
			String zipcode, Long geocode, Integer configTypeCode,
			Integer siteTypeCode, Integer housingTypeCode,
			Integer recActiveGct, Timestamp entryDateTime, Long entryUserKey,
			Timestamp logDateTime, Long logUserKey) {
		this.agencyKey = agencyKey;
		this.agencyPrimarySiteGct = agencyPrimarySiteGct;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.geocode = geocode;
		this.configTypeCode = configTypeCode;
		this.siteTypeCode = siteTypeCode;
		this.housingTypeCode = housingTypeCode;
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
	@Column(name = "SITE_KEY", unique = true, nullable = false)
	public Long getSiteKey() {
		return this.siteKey;
	}

	public void setSiteKey(Long siteKey) {
		this.siteKey = siteKey;
	}

	@Column(name = "AGENCY_KEY", nullable = false)
	public Long getAgencyKey() {
		return this.agencyKey;
	}

	public void setAgencyKey(Long agencyKey) {
		this.agencyKey = agencyKey;
	}

	@Column(name = "AGENCY_PRIMARY_SITE_GCT")
	public Integer getAgencyPrimarySiteGct() {
		return this.agencyPrimarySiteGct;
	}

	public void setAgencyPrimarySiteGct(Integer agencyPrimarySiteGct) {
		this.agencyPrimarySiteGct = agencyPrimarySiteGct;
	}

	@Column(name = "NAME", length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ADDRESS", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "CITY", length = 200)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STATE", length = 2)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "ZIPCODE", length = 5)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "GEOCODE")
	public Long getGeocode() {
		return this.geocode;
	}

	public void setGeocode(Long geocode) {
		this.geocode = geocode;
	}

	@Column(name = "CONFIG_TYPE_CODE")
	public Integer getConfigTypeCode() {
		return this.configTypeCode;
	}

	public void setConfigTypeCode(Integer configTypeCode) {
		this.configTypeCode = configTypeCode;
	}

	@Column(name = "SITE_TYPE_CODE")
	public Integer getSiteTypeCode() {
		return this.siteTypeCode;
	}

	public void setSiteTypeCode(Integer siteTypeCode) {
		this.siteTypeCode = siteTypeCode;
	}

	@Column(name = "HOUSING_TYPE_CODE")
	public Integer getHousingTypeCode() {
		return this.housingTypeCode;
	}

	public void setHousingTypeCode(Integer housingTypeCode) {
		this.housingTypeCode = housingTypeCode;
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