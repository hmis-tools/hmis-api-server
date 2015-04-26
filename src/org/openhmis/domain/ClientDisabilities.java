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
 * ClientDisabilities entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_DISABILITIES", catalog = "OPENHMIS2")
public class ClientDisabilities implements java.io.Serializable {

	// Fields

	private Long disabilitiesKey;
	private Long clientKey;
	private Date informationDate;
	private Integer physicalGct;
	private Integer physicalRecvTreatGct;
	private Integer developmentalGct;
	private Integer developmentalRecvTreatGct;
	private Integer chronicHealthCondGct;
	private Integer chronicRecvTreatGct;
	private Integer hivaidsGct;
	private Integer hivaidsRecvTreatGct;
	private Integer mentalHealthGct;
	private Integer mentalHealthLongGct;
	private Integer mentalHlthRecvTreatGct;
	private Integer substanceAbuseCode;
	private Integer substanceAbuseLongGct;
	private Integer substAbuseRecvTreatGct;
	private Integer domesViolenceGct;
	private Integer domesViolWhenCode;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ClientDisabilities() {
	}

	/** minimal constructor */
	public ClientDisabilities(Long clientKey, Timestamp logDateTime) {
		this.clientKey = clientKey;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ClientDisabilities(Long clientKey, Date informationDate,
			Integer physicalGct, Integer physicalRecvTreatGct,
			Integer developmentalGct, Integer developmentalRecvTreatGct,
			Integer chronicHealthCondGct, Integer chronicRecvTreatGct,
			Integer hivaidsGct, Integer hivaidsRecvTreatGct,
			Integer mentalHealthGct, Integer mentalHealthLongGct,
			Integer mentalHlthRecvTreatGct, Integer substanceAbuseCode,
			Integer substanceAbuseLongGct, Integer substAbuseRecvTreatGct,
			Integer domesViolenceGct, Integer domesViolWhenCode,
			Integer recActiveGct, Timestamp entryDateTime, Long entryUserKey,
			Timestamp logDateTime, Long logUserKey) {
		this.clientKey = clientKey;
		this.informationDate = informationDate;
		this.physicalGct = physicalGct;
		this.physicalRecvTreatGct = physicalRecvTreatGct;
		this.developmentalGct = developmentalGct;
		this.developmentalRecvTreatGct = developmentalRecvTreatGct;
		this.chronicHealthCondGct = chronicHealthCondGct;
		this.chronicRecvTreatGct = chronicRecvTreatGct;
		this.hivaidsGct = hivaidsGct;
		this.hivaidsRecvTreatGct = hivaidsRecvTreatGct;
		this.mentalHealthGct = mentalHealthGct;
		this.mentalHealthLongGct = mentalHealthLongGct;
		this.mentalHlthRecvTreatGct = mentalHlthRecvTreatGct;
		this.substanceAbuseCode = substanceAbuseCode;
		this.substanceAbuseLongGct = substanceAbuseLongGct;
		this.substAbuseRecvTreatGct = substAbuseRecvTreatGct;
		this.domesViolenceGct = domesViolenceGct;
		this.domesViolWhenCode = domesViolWhenCode;
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
	@Column(name = "DISABILITIES_KEY", unique = true, nullable = false)
	public Long getDisabilitiesKey() {
		return this.disabilitiesKey;
	}

	public void setDisabilitiesKey(Long disabilitiesKey) {
		this.disabilitiesKey = disabilitiesKey;
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

	@Column(name = "PHYSICAL_GCT")
	public Integer getPhysicalGct() {
		return this.physicalGct;
	}

	public void setPhysicalGct(Integer physicalGct) {
		this.physicalGct = physicalGct;
	}

	@Column(name = "PHYSICAL_RECV_TREAT_GCT")
	public Integer getPhysicalRecvTreatGct() {
		return this.physicalRecvTreatGct;
	}

	public void setPhysicalRecvTreatGct(Integer physicalRecvTreatGct) {
		this.physicalRecvTreatGct = physicalRecvTreatGct;
	}

	@Column(name = "DEVELOPMENTAL_GCT")
	public Integer getDevelopmentalGct() {
		return this.developmentalGct;
	}

	public void setDevelopmentalGct(Integer developmentalGct) {
		this.developmentalGct = developmentalGct;
	}

	@Column(name = "DEVELOPMENTAL_RECV_TREAT_GCT")
	public Integer getDevelopmentalRecvTreatGct() {
		return this.developmentalRecvTreatGct;
	}

	public void setDevelopmentalRecvTreatGct(Integer developmentalRecvTreatGct) {
		this.developmentalRecvTreatGct = developmentalRecvTreatGct;
	}

	@Column(name = "CHRONIC_HEALTH_COND_GCT")
	public Integer getChronicHealthCondGct() {
		return this.chronicHealthCondGct;
	}

	public void setChronicHealthCondGct(Integer chronicHealthCondGct) {
		this.chronicHealthCondGct = chronicHealthCondGct;
	}

	@Column(name = "CHRONIC_RECV_TREAT_GCT")
	public Integer getChronicRecvTreatGct() {
		return this.chronicRecvTreatGct;
	}

	public void setChronicRecvTreatGct(Integer chronicRecvTreatGct) {
		this.chronicRecvTreatGct = chronicRecvTreatGct;
	}

	@Column(name = "HIVAIDS_GCT")
	public Integer getHivaidsGct() {
		return this.hivaidsGct;
	}

	public void setHivaidsGct(Integer hivaidsGct) {
		this.hivaidsGct = hivaidsGct;
	}

	@Column(name = "HIVAIDS_RECV_TREAT_GCT")
	public Integer getHivaidsRecvTreatGct() {
		return this.hivaidsRecvTreatGct;
	}

	public void setHivaidsRecvTreatGct(Integer hivaidsRecvTreatGct) {
		this.hivaidsRecvTreatGct = hivaidsRecvTreatGct;
	}

	@Column(name = "MENTAL_HEALTH_GCT")
	public Integer getMentalHealthGct() {
		return this.mentalHealthGct;
	}

	public void setMentalHealthGct(Integer mentalHealthGct) {
		this.mentalHealthGct = mentalHealthGct;
	}

	@Column(name = "MENTAL_HEALTH_LONG_GCT")
	public Integer getMentalHealthLongGct() {
		return this.mentalHealthLongGct;
	}

	public void setMentalHealthLongGct(Integer mentalHealthLongGct) {
		this.mentalHealthLongGct = mentalHealthLongGct;
	}

	@Column(name = "MENTAL_HLTH_RECV_TREAT_GCT")
	public Integer getMentalHlthRecvTreatGct() {
		return this.mentalHlthRecvTreatGct;
	}

	public void setMentalHlthRecvTreatGct(Integer mentalHlthRecvTreatGct) {
		this.mentalHlthRecvTreatGct = mentalHlthRecvTreatGct;
	}

	@Column(name = "SUBSTANCE_ABUSE_CODE")
	public Integer getSubstanceAbuseCode() {
		return this.substanceAbuseCode;
	}

	public void setSubstanceAbuseCode(Integer substanceAbuseCode) {
		this.substanceAbuseCode = substanceAbuseCode;
	}

	@Column(name = "SUBSTANCE_ABUSE_LONG_GCT")
	public Integer getSubstanceAbuseLongGct() {
		return this.substanceAbuseLongGct;
	}

	public void setSubstanceAbuseLongGct(Integer substanceAbuseLongGct) {
		this.substanceAbuseLongGct = substanceAbuseLongGct;
	}

	@Column(name = "SUBST_ABUSE_RECV_TREAT_GCT")
	public Integer getSubstAbuseRecvTreatGct() {
		return this.substAbuseRecvTreatGct;
	}

	public void setSubstAbuseRecvTreatGct(Integer substAbuseRecvTreatGct) {
		this.substAbuseRecvTreatGct = substAbuseRecvTreatGct;
	}

	@Column(name = "DOMES_VIOLENCE_GCT")
	public Integer getDomesViolenceGct() {
		return this.domesViolenceGct;
	}

	public void setDomesViolenceGct(Integer domesViolenceGct) {
		this.domesViolenceGct = domesViolenceGct;
	}

	@Column(name = "DOMES_VIOL_WHEN_CODE")
	public Integer getDomesViolWhenCode() {
		return this.domesViolWhenCode;
	}

	public void setDomesViolWhenCode(Integer domesViolWhenCode) {
		this.domesViolWhenCode = domesViolWhenCode;
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