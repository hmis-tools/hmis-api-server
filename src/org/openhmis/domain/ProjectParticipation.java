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
 * ProjectParticipation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PROJECT_PARTICIPATION", catalog = "OPENHMIS2")
public class ProjectParticipation implements java.io.Serializable {

	// Fields

	private Long id;
	private Long clientKey;
	private Long projectKey;
	private Date entryDate;
	private Date exitDate;
	private Integer reasonLeavingCode;
	private Integer destinationCode;
	private Integer destFundSrcCode;
	private Integer transitionCode;
	private Long veteranInfoKey;
	private Long s1CashKey;
	private Long s2CashKey;
	private Long s3CashKey;
	private Long s4CashKey;
	private Long s1BenefitsKey;
	private Long s2BenefitsKey;
	private Long s3BenefitsKey;
	private Long s4BenefitsKey;
	private Long s1DisabilitiesKey;
	private Long s2DisabilitiesKey;
	private Long s3DisabilitiesKey;
	private Long s4DisabilitiesKey;
	private Long s1StatusKey;
	private Long s2StatusKey;
	private Long s3StatusKey;
	private Long s4StatusKey;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ProjectParticipation() {
	}

	/** minimal constructor */
	public ProjectParticipation(Long clientKey, Long projectKey,
			Long veteranInfoKey, Timestamp logDateTime) {
		this.clientKey = clientKey;
		this.projectKey = projectKey;
		this.veteranInfoKey = veteranInfoKey;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ProjectParticipation(Long clientKey, Long projectKey,
			Date entryDate, Date exitDate, Integer reasonLeavingCode,
			Integer destinationCode, Integer destFundSrcCode,
			Integer transitionCode, Long veteranInfoKey, Long s1CashKey,
			Long s2CashKey, Long s3CashKey, Long s4CashKey, Long s1BenefitsKey,
			Long s2BenefitsKey, Long s3BenefitsKey, Long s4BenefitsKey,
			Long s1DisabilitiesKey, Long s2DisabilitiesKey,
			Long s3DisabilitiesKey, Long s4DisabilitiesKey, Long s1StatusKey,
			Long s2StatusKey, Long s3StatusKey, Long s4StatusKey,
			Integer recActiveGct, Timestamp entryDateTime, Long entryUserKey,
			Timestamp logDateTime, Long logUserKey) {
		this.clientKey = clientKey;
		this.projectKey = projectKey;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.reasonLeavingCode = reasonLeavingCode;
		this.destinationCode = destinationCode;
		this.destFundSrcCode = destFundSrcCode;
		this.transitionCode = transitionCode;
		this.veteranInfoKey = veteranInfoKey;
		this.s1CashKey = s1CashKey;
		this.s2CashKey = s2CashKey;
		this.s3CashKey = s3CashKey;
		this.s4CashKey = s4CashKey;
		this.s1BenefitsKey = s1BenefitsKey;
		this.s2BenefitsKey = s2BenefitsKey;
		this.s3BenefitsKey = s3BenefitsKey;
		this.s4BenefitsKey = s4BenefitsKey;
		this.s1DisabilitiesKey = s1DisabilitiesKey;
		this.s2DisabilitiesKey = s2DisabilitiesKey;
		this.s3DisabilitiesKey = s3DisabilitiesKey;
		this.s4DisabilitiesKey = s4DisabilitiesKey;
		this.s1StatusKey = s1StatusKey;
		this.s2StatusKey = s2StatusKey;
		this.s3StatusKey = s3StatusKey;
		this.s4StatusKey = s4StatusKey;
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

	@Column(name = "CLIENT_KEY", nullable = false)
	public Long getClientKey() {
		return this.clientKey;
	}

	public void setClientKey(Long clientKey) {
		this.clientKey = clientKey;
	}

	@Column(name = "PROJECT_KEY", nullable = false)
	public Long getProjectKey() {
		return this.projectKey;
	}

	public void setProjectKey(Long projectKey) {
		this.projectKey = projectKey;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ENTRY_DATE", length = 10)
	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EXIT_DATE", length = 10)
	public Date getExitDate() {
		return this.exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	@Column(name = "REASON_LEAVING_CODE")
	public Integer getReasonLeavingCode() {
		return this.reasonLeavingCode;
	}

	public void setReasonLeavingCode(Integer reasonLeavingCode) {
		this.reasonLeavingCode = reasonLeavingCode;
	}

	@Column(name = "DESTINATION_CODE")
	public Integer getDestinationCode() {
		return this.destinationCode;
	}

	public void setDestinationCode(Integer destinationCode) {
		this.destinationCode = destinationCode;
	}

	@Column(name = "DEST_FUND_SRC_CODE")
	public Integer getDestFundSrcCode() {
		return this.destFundSrcCode;
	}

	public void setDestFundSrcCode(Integer destFundSrcCode) {
		this.destFundSrcCode = destFundSrcCode;
	}

	@Column(name = "TRANSITION_CODE")
	public Integer getTransitionCode() {
		return this.transitionCode;
	}

	public void setTransitionCode(Integer transitionCode) {
		this.transitionCode = transitionCode;
	}

	@Column(name = "VETERAN_INFO_KEY", nullable = false)
	public Long getVeteranInfoKey() {
		return this.veteranInfoKey;
	}

	public void setVeteranInfoKey(Long veteranInfoKey) {
		this.veteranInfoKey = veteranInfoKey;
	}

	@Column(name = "S1_CASH_KEY")
	public Long getS1CashKey() {
		return this.s1CashKey;
	}

	public void setS1CashKey(Long s1CashKey) {
		this.s1CashKey = s1CashKey;
	}

	@Column(name = "S2_CASH_KEY")
	public Long getS2CashKey() {
		return this.s2CashKey;
	}

	public void setS2CashKey(Long s2CashKey) {
		this.s2CashKey = s2CashKey;
	}

	@Column(name = "S3_CASH_KEY")
	public Long getS3CashKey() {
		return this.s3CashKey;
	}

	public void setS3CashKey(Long s3CashKey) {
		this.s3CashKey = s3CashKey;
	}

	@Column(name = "S4_CASH_KEY")
	public Long getS4CashKey() {
		return this.s4CashKey;
	}

	public void setS4CashKey(Long s4CashKey) {
		this.s4CashKey = s4CashKey;
	}

	@Column(name = "S1_BENEFITS_KEY")
	public Long getS1BenefitsKey() {
		return this.s1BenefitsKey;
	}

	public void setS1BenefitsKey(Long s1BenefitsKey) {
		this.s1BenefitsKey = s1BenefitsKey;
	}

	@Column(name = "S2_BENEFITS_KEY")
	public Long getS2BenefitsKey() {
		return this.s2BenefitsKey;
	}

	public void setS2BenefitsKey(Long s2BenefitsKey) {
		this.s2BenefitsKey = s2BenefitsKey;
	}

	@Column(name = "S3_BENEFITS_KEY")
	public Long getS3BenefitsKey() {
		return this.s3BenefitsKey;
	}

	public void setS3BenefitsKey(Long s3BenefitsKey) {
		this.s3BenefitsKey = s3BenefitsKey;
	}

	@Column(name = "S4_BENEFITS_KEY")
	public Long getS4BenefitsKey() {
		return this.s4BenefitsKey;
	}

	public void setS4BenefitsKey(Long s4BenefitsKey) {
		this.s4BenefitsKey = s4BenefitsKey;
	}

	@Column(name = "S1_DISABILITIES_KEY")
	public Long getS1DisabilitiesKey() {
		return this.s1DisabilitiesKey;
	}

	public void setS1DisabilitiesKey(Long s1DisabilitiesKey) {
		this.s1DisabilitiesKey = s1DisabilitiesKey;
	}

	@Column(name = "S2_DISABILITIES_KEY")
	public Long getS2DisabilitiesKey() {
		return this.s2DisabilitiesKey;
	}

	public void setS2DisabilitiesKey(Long s2DisabilitiesKey) {
		this.s2DisabilitiesKey = s2DisabilitiesKey;
	}

	@Column(name = "S3_DISABILITIES_KEY")
	public Long getS3DisabilitiesKey() {
		return this.s3DisabilitiesKey;
	}

	public void setS3DisabilitiesKey(Long s3DisabilitiesKey) {
		this.s3DisabilitiesKey = s3DisabilitiesKey;
	}

	@Column(name = "S4_DISABILITIES_KEY")
	public Long getS4DisabilitiesKey() {
		return this.s4DisabilitiesKey;
	}

	public void setS4DisabilitiesKey(Long s4DisabilitiesKey) {
		this.s4DisabilitiesKey = s4DisabilitiesKey;
	}

	@Column(name = "S1_STATUS_KEY")
	public Long getS1StatusKey() {
		return this.s1StatusKey;
	}

	public void setS1StatusKey(Long s1StatusKey) {
		this.s1StatusKey = s1StatusKey;
	}

	@Column(name = "S2_STATUS_KEY")
	public Long getS2StatusKey() {
		return this.s2StatusKey;
	}

	public void setS2StatusKey(Long s2StatusKey) {
		this.s2StatusKey = s2StatusKey;
	}

	@Column(name = "S3_STATUS_KEY")
	public Long getS3StatusKey() {
		return this.s3StatusKey;
	}

	public void setS3StatusKey(Long s3StatusKey) {
		this.s3StatusKey = s3StatusKey;
	}

	@Column(name = "S4_STATUS_KEY")
	public Long getS4StatusKey() {
		return this.s4StatusKey;
	}

	public void setS4StatusKey(Long s4StatusKey) {
		this.s4StatusKey = s4StatusKey;
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