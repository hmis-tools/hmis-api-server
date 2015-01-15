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
 * ReportToParms entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "REPORT_TO_PARMS", catalog = "OPENHMIS2")
public class ReportToParms implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer reportKey;
	private Integer parmKey;
	private Integer orderNumber;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ReportToParms() {
	}

	/** minimal constructor */
	public ReportToParms(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ReportToParms(Integer reportKey, Integer parmKey,
			Integer orderNumber, Integer recActiveGct, Timestamp entryDateTime,
			Long entryUserKey, Timestamp logDateTime, Long logUserKey) {
		this.reportKey = reportKey;
		this.parmKey = parmKey;
		this.orderNumber = orderNumber;
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
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "REPORT_KEY")
	public Integer getReportKey() {
		return this.reportKey;
	}

	public void setReportKey(Integer reportKey) {
		this.reportKey = reportKey;
	}

	@Column(name = "PARM_KEY")
	public Integer getParmKey() {
		return this.parmKey;
	}

	public void setParmKey(Integer parmKey) {
		this.parmKey = parmKey;
	}

	@Column(name = "ORDER_NUMBER")
	public Integer getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
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