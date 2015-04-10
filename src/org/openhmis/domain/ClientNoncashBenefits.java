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
 * ClientNoncashBenefits entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_NONCASH_BENEFITS", catalog = "OPENHMIS2")
public class ClientNoncashBenefits implements java.io.Serializable {

	// Fields

	private Long noncashKey;
	private Long clientKey;
	private Date informationDate;
	private Integer anySourceGct;
	private Integer snapGct;
	private Integer wicGct;
	private Integer tanfCcGct;
	private Integer tanfTranGct;
	private Integer tanfOtherGct;
	private Integer ongoingRentAssistGct;
	private Integer rentTempGct;
	private Integer medicaidGct;
	private Integer medicareGct;
	private Integer otherSourceGct;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ClientNoncashBenefits() {
	}

	/** minimal constructor */
	public ClientNoncashBenefits(Long clientKey, Timestamp logDateTime) {
		this.clientKey = clientKey;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ClientNoncashBenefits(Long clientKey, Date informationDate,
			Integer anySourceGct, Integer snapGct, Integer wicGct,
			Integer tanfCcGct, Integer tanfTranGct, Integer tanfOtherGct,
			Integer ongoingRentAssistGct, Integer rentTempGct,
			Integer medicaidGct, Integer medicareGct, Integer otherSourceGct,
			Integer recActiveGct, Timestamp entryDateTime, Long entryUserKey,
			Timestamp logDateTime, Long logUserKey) {
		this.clientKey = clientKey;
		this.informationDate = informationDate;
		this.anySourceGct = anySourceGct;
		this.snapGct = snapGct;
		this.wicGct = wicGct;
		this.tanfCcGct = tanfCcGct;
		this.tanfTranGct = tanfTranGct;
		this.tanfOtherGct = tanfOtherGct;
		this.ongoingRentAssistGct = ongoingRentAssistGct;
		this.rentTempGct = rentTempGct;
		this.medicaidGct = medicaidGct;
		this.medicareGct = medicareGct;
		this.otherSourceGct = otherSourceGct;
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
	@Column(name = "NONCASH_KEY", unique = true, nullable = false)
	public Long getNoncashKey() {
		return this.noncashKey;
	}

	public void setNoncashKey(Long noncashKey) {
		this.noncashKey = noncashKey;
	}

	@Column(name = "CLIENT_KEY", nullable = false)
	public Long getClientKey() {
		return this.clientKey;
	}

	public void setClientKey(Long clientKey) {
		this.clientKey = clientKey;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "INFORMATION_DATE", length = 10)
	public Date getInformationDate() {
		return this.informationDate;
	}

	public void setInformationDate(Date informationDate) {
		this.informationDate = informationDate;
	}

	@Column(name = "ANY_SOURCE_GCT")
	public Integer getAnySourceGct() {
		return this.anySourceGct;
	}

	public void setAnySourceGct(Integer anySourceGct) {
		this.anySourceGct = anySourceGct;
	}

	@Column(name = "SNAP_GCT")
	public Integer getSnapGct() {
		return this.snapGct;
	}

	public void setSnapGct(Integer snapGct) {
		this.snapGct = snapGct;
	}

	@Column(name = "WIC_GCT")
	public Integer getWicGct() {
		return this.wicGct;
	}

	public void setWicGct(Integer wicGct) {
		this.wicGct = wicGct;
	}

	@Column(name = "TANF_CC_GCT")
	public Integer getTanfCcGct() {
		return this.tanfCcGct;
	}

	public void setTanfCcGct(Integer tanfCcGct) {
		this.tanfCcGct = tanfCcGct;
	}

	@Column(name = "TANF_TRAN_GCT")
	public Integer getTanfTranGct() {
		return this.tanfTranGct;
	}

	public void setTanfTranGct(Integer tanfTranGct) {
		this.tanfTranGct = tanfTranGct;
	}

	@Column(name = "TANF_OTHER_GCT")
	public Integer getTanfOtherGct() {
		return this.tanfOtherGct;
	}

	public void setTanfOtherGct(Integer tanfOtherGct) {
		this.tanfOtherGct = tanfOtherGct;
	}

	@Column(name = "ONGOING_RENT_ASSIST_GCT")
	public Integer getOngoingRentAssistGct() {
		return this.ongoingRentAssistGct;
	}

	public void setOngoingRentAssistGct(Integer ongoingRentAssistGct) {
		this.ongoingRentAssistGct = ongoingRentAssistGct;
	}

	@Column(name = "RENT_TEMP_GCT")
	public Integer getRentTempGct() {
		return this.rentTempGct;
	}

	public void setRentTempGct(Integer rentTempGct) {
		this.rentTempGct = rentTempGct;
	}

	@Column(name = "MEDICAID_GCT")
	public Integer getMedicaidGct() {
		return this.medicaidGct;
	}

	public void setMedicaidGct(Integer medicaidGct) {
		this.medicaidGct = medicaidGct;
	}

	@Column(name = "MEDICARE_GCT")
	public Integer getMedicareGct() {
		return this.medicareGct;
	}

	public void setMedicareGct(Integer medicareGct) {
		this.medicareGct = medicareGct;
	}

	@Column(name = "OTHER_SOURCE_GCT")
	public Integer getOtherSourceGct() {
		return this.otherSourceGct;
	}

	public void setOtherSourceGct(Integer otherSourceGct) {
		this.otherSourceGct = otherSourceGct;
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