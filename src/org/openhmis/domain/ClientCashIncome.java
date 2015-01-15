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
 * ClientCashIncome entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_CASH_INCOME", catalog = "OPENHMIS2")
public class ClientCashIncome implements java.io.Serializable {

	// Fields

	private Long cashKey;
	private Long clientKey;
	private Date informationDate;
	private Integer anySourceGct;
	private Double totalMthlyAmt;
	private Integer earnedincomeGct;
	private Double earnedincomeMthlyAmt;
	private Date earnedincomeStartDate;
	private Integer unempinsGct;
	private Double unempinsMthlyAmt;
	private Date unempinsStartDate;
	private Integer ssiGct;
	private Double ssiMthlyAmt;
	private Date ssiStartDate;
	private Integer ssdiGct;
	private Double ssdiMthlyAmt;
	private Date ssdiStartDate;
	private Integer vetdispmtGct;
	private Double vetdispmtMthlyAmt;
	private Date vetdispmtStartDate;
	private Integer privdisinsGct;
	private Double privdisinsMthlyAmt;
	private Date privdisinsStartDate;
	private Integer workerscompGct;
	private Double workerscompMthlyAmt;
	private Date workerscompStartDate;
	private Integer tanfGct;
	private Double tanfMthlyAmt;
	private Date tanfStartDate;
	private Integer genlassistGct;
	private Double genlassistMthlyAmt;
	private Date genlassistStartDate;
	private Integer socsecGct;
	private Double socsecMthlyAmt;
	private Date socsecStartDate;
	private Integer vetpensionGct;
	private Double vetpensionMthlyAmt;
	private Date vetpensionStartDate;
	private Integer jobpensionGct;
	private Double jobpensionMthlyAmt;
	private Date jobpensionStartDate;
	private Integer childsupportGct;
	private Double childsupportMthlyAmt;
	private Date childsupportStartDate;
	private Integer alimonyGct;
	private Double alimonyMthlyAmt;
	private Date alimonyStartDate;
	private Integer othersourceGct;
	private Double othersourceMthlyAmt;
	private Date othersourceDate;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ClientCashIncome() {
	}

	/** minimal constructor */
	public ClientCashIncome(Long clientKey, Timestamp logDateTime) {
		this.clientKey = clientKey;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ClientCashIncome(Long clientKey, Date informationDate,
			Integer anySourceGct, Double totalMthlyAmt,
			Integer earnedincomeGct, Double earnedincomeMthlyAmt,
			Date earnedincomeStartDate, Integer unempinsGct,
			Double unempinsMthlyAmt, Date unempinsStartDate, Integer ssiGct,
			Double ssiMthlyAmt, Date ssiStartDate, Integer ssdiGct,
			Double ssdiMthlyAmt, Date ssdiStartDate, Integer vetdispmtGct,
			Double vetdispmtMthlyAmt, Date vetdispmtStartDate,
			Integer privdisinsGct, Double privdisinsMthlyAmt,
			Date privdisinsStartDate, Integer workerscompGct,
			Double workerscompMthlyAmt, Date workerscompStartDate,
			Integer tanfGct, Double tanfMthlyAmt, Date tanfStartDate,
			Integer genlassistGct, Double genlassistMthlyAmt,
			Date genlassistStartDate, Integer socsecGct, Double socsecMthlyAmt,
			Date socsecStartDate, Integer vetpensionGct,
			Double vetpensionMthlyAmt, Date vetpensionStartDate,
			Integer jobpensionGct, Double jobpensionMthlyAmt,
			Date jobpensionStartDate, Integer childsupportGct,
			Double childsupportMthlyAmt, Date childsupportStartDate,
			Integer alimonyGct, Double alimonyMthlyAmt, Date alimonyStartDate,
			Integer othersourceGct, Double othersourceMthlyAmt,
			Date othersourceDate, Integer recActiveGct,
			Timestamp entryDateTime, Long entryUserKey, Timestamp logDateTime,
			Long logUserKey) {
		this.clientKey = clientKey;
		this.informationDate = informationDate;
		this.anySourceGct = anySourceGct;
		this.totalMthlyAmt = totalMthlyAmt;
		this.earnedincomeGct = earnedincomeGct;
		this.earnedincomeMthlyAmt = earnedincomeMthlyAmt;
		this.earnedincomeStartDate = earnedincomeStartDate;
		this.unempinsGct = unempinsGct;
		this.unempinsMthlyAmt = unempinsMthlyAmt;
		this.unempinsStartDate = unempinsStartDate;
		this.ssiGct = ssiGct;
		this.ssiMthlyAmt = ssiMthlyAmt;
		this.ssiStartDate = ssiStartDate;
		this.ssdiGct = ssdiGct;
		this.ssdiMthlyAmt = ssdiMthlyAmt;
		this.ssdiStartDate = ssdiStartDate;
		this.vetdispmtGct = vetdispmtGct;
		this.vetdispmtMthlyAmt = vetdispmtMthlyAmt;
		this.vetdispmtStartDate = vetdispmtStartDate;
		this.privdisinsGct = privdisinsGct;
		this.privdisinsMthlyAmt = privdisinsMthlyAmt;
		this.privdisinsStartDate = privdisinsStartDate;
		this.workerscompGct = workerscompGct;
		this.workerscompMthlyAmt = workerscompMthlyAmt;
		this.workerscompStartDate = workerscompStartDate;
		this.tanfGct = tanfGct;
		this.tanfMthlyAmt = tanfMthlyAmt;
		this.tanfStartDate = tanfStartDate;
		this.genlassistGct = genlassistGct;
		this.genlassistMthlyAmt = genlassistMthlyAmt;
		this.genlassistStartDate = genlassistStartDate;
		this.socsecGct = socsecGct;
		this.socsecMthlyAmt = socsecMthlyAmt;
		this.socsecStartDate = socsecStartDate;
		this.vetpensionGct = vetpensionGct;
		this.vetpensionMthlyAmt = vetpensionMthlyAmt;
		this.vetpensionStartDate = vetpensionStartDate;
		this.jobpensionGct = jobpensionGct;
		this.jobpensionMthlyAmt = jobpensionMthlyAmt;
		this.jobpensionStartDate = jobpensionStartDate;
		this.childsupportGct = childsupportGct;
		this.childsupportMthlyAmt = childsupportMthlyAmt;
		this.childsupportStartDate = childsupportStartDate;
		this.alimonyGct = alimonyGct;
		this.alimonyMthlyAmt = alimonyMthlyAmt;
		this.alimonyStartDate = alimonyStartDate;
		this.othersourceGct = othersourceGct;
		this.othersourceMthlyAmt = othersourceMthlyAmt;
		this.othersourceDate = othersourceDate;
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
	@Column(name = "CASH_KEY", unique = true, nullable = false)
	public Long getCashKey() {
		return this.cashKey;
	}

	public void setCashKey(Long cashKey) {
		this.cashKey = cashKey;
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

	@Column(name = "TOTAL_MTHLY_AMT", precision = 15)
	public Double getTotalMthlyAmt() {
		return this.totalMthlyAmt;
	}

	public void setTotalMthlyAmt(Double totalMthlyAmt) {
		this.totalMthlyAmt = totalMthlyAmt;
	}

	@Column(name = "EARNEDINCOME_GCT")
	public Integer getEarnedincomeGct() {
		return this.earnedincomeGct;
	}

	public void setEarnedincomeGct(Integer earnedincomeGct) {
		this.earnedincomeGct = earnedincomeGct;
	}

	@Column(name = "EARNEDINCOME_MTHLY_AMT", precision = 15)
	public Double getEarnedincomeMthlyAmt() {
		return this.earnedincomeMthlyAmt;
	}

	public void setEarnedincomeMthlyAmt(Double earnedincomeMthlyAmt) {
		this.earnedincomeMthlyAmt = earnedincomeMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EARNEDINCOME_START_DATE", length = 10)
	public Date getEarnedincomeStartDate() {
		return this.earnedincomeStartDate;
	}

	public void setEarnedincomeStartDate(Date earnedincomeStartDate) {
		this.earnedincomeStartDate = earnedincomeStartDate;
	}

	@Column(name = "UNEMPINS_GCT")
	public Integer getUnempinsGct() {
		return this.unempinsGct;
	}

	public void setUnempinsGct(Integer unempinsGct) {
		this.unempinsGct = unempinsGct;
	}

	@Column(name = "UNEMPINS_MTHLY_AMT", precision = 15)
	public Double getUnempinsMthlyAmt() {
		return this.unempinsMthlyAmt;
	}

	public void setUnempinsMthlyAmt(Double unempinsMthlyAmt) {
		this.unempinsMthlyAmt = unempinsMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UNEMPINS_START_DATE", length = 10)
	public Date getUnempinsStartDate() {
		return this.unempinsStartDate;
	}

	public void setUnempinsStartDate(Date unempinsStartDate) {
		this.unempinsStartDate = unempinsStartDate;
	}

	@Column(name = "SSI_GCT")
	public Integer getSsiGct() {
		return this.ssiGct;
	}

	public void setSsiGct(Integer ssiGct) {
		this.ssiGct = ssiGct;
	}

	@Column(name = "SSI_MTHLY_AMT", precision = 15)
	public Double getSsiMthlyAmt() {
		return this.ssiMthlyAmt;
	}

	public void setSsiMthlyAmt(Double ssiMthlyAmt) {
		this.ssiMthlyAmt = ssiMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SSI_START_DATE", length = 10)
	public Date getSsiStartDate() {
		return this.ssiStartDate;
	}

	public void setSsiStartDate(Date ssiStartDate) {
		this.ssiStartDate = ssiStartDate;
	}

	@Column(name = "SSDI_GCT")
	public Integer getSsdiGct() {
		return this.ssdiGct;
	}

	public void setSsdiGct(Integer ssdiGct) {
		this.ssdiGct = ssdiGct;
	}

	@Column(name = "SSDI_MTHLY_AMT", precision = 15)
	public Double getSsdiMthlyAmt() {
		return this.ssdiMthlyAmt;
	}

	public void setSsdiMthlyAmt(Double ssdiMthlyAmt) {
		this.ssdiMthlyAmt = ssdiMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SSDI_START_DATE", length = 10)
	public Date getSsdiStartDate() {
		return this.ssdiStartDate;
	}

	public void setSsdiStartDate(Date ssdiStartDate) {
		this.ssdiStartDate = ssdiStartDate;
	}

	@Column(name = "VETDISPMT_GCT")
	public Integer getVetdispmtGct() {
		return this.vetdispmtGct;
	}

	public void setVetdispmtGct(Integer vetdispmtGct) {
		this.vetdispmtGct = vetdispmtGct;
	}

	@Column(name = "VETDISPMT_MTHLY_AMT", precision = 15)
	public Double getVetdispmtMthlyAmt() {
		return this.vetdispmtMthlyAmt;
	}

	public void setVetdispmtMthlyAmt(Double vetdispmtMthlyAmt) {
		this.vetdispmtMthlyAmt = vetdispmtMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VETDISPMT_START_DATE", length = 10)
	public Date getVetdispmtStartDate() {
		return this.vetdispmtStartDate;
	}

	public void setVetdispmtStartDate(Date vetdispmtStartDate) {
		this.vetdispmtStartDate = vetdispmtStartDate;
	}

	@Column(name = "PRIVDISINS_GCT")
	public Integer getPrivdisinsGct() {
		return this.privdisinsGct;
	}

	public void setPrivdisinsGct(Integer privdisinsGct) {
		this.privdisinsGct = privdisinsGct;
	}

	@Column(name = "PRIVDISINS_MTHLY_AMT", precision = 15)
	public Double getPrivdisinsMthlyAmt() {
		return this.privdisinsMthlyAmt;
	}

	public void setPrivdisinsMthlyAmt(Double privdisinsMthlyAmt) {
		this.privdisinsMthlyAmt = privdisinsMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PRIVDISINS_START_DATE", length = 10)
	public Date getPrivdisinsStartDate() {
		return this.privdisinsStartDate;
	}

	public void setPrivdisinsStartDate(Date privdisinsStartDate) {
		this.privdisinsStartDate = privdisinsStartDate;
	}

	@Column(name = "WORKERSCOMP_GCT")
	public Integer getWorkerscompGct() {
		return this.workerscompGct;
	}

	public void setWorkerscompGct(Integer workerscompGct) {
		this.workerscompGct = workerscompGct;
	}

	@Column(name = "WORKERSCOMP_MTHLY_AMT", precision = 15)
	public Double getWorkerscompMthlyAmt() {
		return this.workerscompMthlyAmt;
	}

	public void setWorkerscompMthlyAmt(Double workerscompMthlyAmt) {
		this.workerscompMthlyAmt = workerscompMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "WORKERSCOMP_START_DATE", length = 10)
	public Date getWorkerscompStartDate() {
		return this.workerscompStartDate;
	}

	public void setWorkerscompStartDate(Date workerscompStartDate) {
		this.workerscompStartDate = workerscompStartDate;
	}

	@Column(name = "TANF_GCT")
	public Integer getTanfGct() {
		return this.tanfGct;
	}

	public void setTanfGct(Integer tanfGct) {
		this.tanfGct = tanfGct;
	}

	@Column(name = "TANF_MTHLY_AMT", precision = 15)
	public Double getTanfMthlyAmt() {
		return this.tanfMthlyAmt;
	}

	public void setTanfMthlyAmt(Double tanfMthlyAmt) {
		this.tanfMthlyAmt = tanfMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "TANF_START_DATE", length = 10)
	public Date getTanfStartDate() {
		return this.tanfStartDate;
	}

	public void setTanfStartDate(Date tanfStartDate) {
		this.tanfStartDate = tanfStartDate;
	}

	@Column(name = "GENLASSIST_GCT")
	public Integer getGenlassistGct() {
		return this.genlassistGct;
	}

	public void setGenlassistGct(Integer genlassistGct) {
		this.genlassistGct = genlassistGct;
	}

	@Column(name = "GENLASSIST_MTHLY_AMT", precision = 15)
	public Double getGenlassistMthlyAmt() {
		return this.genlassistMthlyAmt;
	}

	public void setGenlassistMthlyAmt(Double genlassistMthlyAmt) {
		this.genlassistMthlyAmt = genlassistMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GENLASSIST_START_DATE", length = 10)
	public Date getGenlassistStartDate() {
		return this.genlassistStartDate;
	}

	public void setGenlassistStartDate(Date genlassistStartDate) {
		this.genlassistStartDate = genlassistStartDate;
	}

	@Column(name = "SOCSEC_GCT")
	public Integer getSocsecGct() {
		return this.socsecGct;
	}

	public void setSocsecGct(Integer socsecGct) {
		this.socsecGct = socsecGct;
	}

	@Column(name = "SOCSEC_MTHLY_AMT", precision = 15)
	public Double getSocsecMthlyAmt() {
		return this.socsecMthlyAmt;
	}

	public void setSocsecMthlyAmt(Double socsecMthlyAmt) {
		this.socsecMthlyAmt = socsecMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SOCSEC_START_DATE", length = 10)
	public Date getSocsecStartDate() {
		return this.socsecStartDate;
	}

	public void setSocsecStartDate(Date socsecStartDate) {
		this.socsecStartDate = socsecStartDate;
	}

	@Column(name = "VETPENSION_GCT")
	public Integer getVetpensionGct() {
		return this.vetpensionGct;
	}

	public void setVetpensionGct(Integer vetpensionGct) {
		this.vetpensionGct = vetpensionGct;
	}

	@Column(name = "VETPENSION_MTHLY_AMT", precision = 15)
	public Double getVetpensionMthlyAmt() {
		return this.vetpensionMthlyAmt;
	}

	public void setVetpensionMthlyAmt(Double vetpensionMthlyAmt) {
		this.vetpensionMthlyAmt = vetpensionMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VETPENSION_START_DATE", length = 10)
	public Date getVetpensionStartDate() {
		return this.vetpensionStartDate;
	}

	public void setVetpensionStartDate(Date vetpensionStartDate) {
		this.vetpensionStartDate = vetpensionStartDate;
	}

	@Column(name = "JOBPENSION_GCT")
	public Integer getJobpensionGct() {
		return this.jobpensionGct;
	}

	public void setJobpensionGct(Integer jobpensionGct) {
		this.jobpensionGct = jobpensionGct;
	}

	@Column(name = "JOBPENSION_MTHLY_AMT", precision = 15)
	public Double getJobpensionMthlyAmt() {
		return this.jobpensionMthlyAmt;
	}

	public void setJobpensionMthlyAmt(Double jobpensionMthlyAmt) {
		this.jobpensionMthlyAmt = jobpensionMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "JOBPENSION_START_DATE", length = 10)
	public Date getJobpensionStartDate() {
		return this.jobpensionStartDate;
	}

	public void setJobpensionStartDate(Date jobpensionStartDate) {
		this.jobpensionStartDate = jobpensionStartDate;
	}

	@Column(name = "CHILDSUPPORT_GCT")
	public Integer getChildsupportGct() {
		return this.childsupportGct;
	}

	public void setChildsupportGct(Integer childsupportGct) {
		this.childsupportGct = childsupportGct;
	}

	@Column(name = "CHILDSUPPORT_MTHLY_AMT", precision = 15)
	public Double getChildsupportMthlyAmt() {
		return this.childsupportMthlyAmt;
	}

	public void setChildsupportMthlyAmt(Double childsupportMthlyAmt) {
		this.childsupportMthlyAmt = childsupportMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CHILDSUPPORT_START_DATE", length = 10)
	public Date getChildsupportStartDate() {
		return this.childsupportStartDate;
	}

	public void setChildsupportStartDate(Date childsupportStartDate) {
		this.childsupportStartDate = childsupportStartDate;
	}

	@Column(name = "ALIMONY_GCT")
	public Integer getAlimonyGct() {
		return this.alimonyGct;
	}

	public void setAlimonyGct(Integer alimonyGct) {
		this.alimonyGct = alimonyGct;
	}

	@Column(name = "ALIMONY_MTHLY_AMT", precision = 15)
	public Double getAlimonyMthlyAmt() {
		return this.alimonyMthlyAmt;
	}

	public void setAlimonyMthlyAmt(Double alimonyMthlyAmt) {
		this.alimonyMthlyAmt = alimonyMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ALIMONY_START_DATE", length = 10)
	public Date getAlimonyStartDate() {
		return this.alimonyStartDate;
	}

	public void setAlimonyStartDate(Date alimonyStartDate) {
		this.alimonyStartDate = alimonyStartDate;
	}

	@Column(name = "OTHERSOURCE_GCT")
	public Integer getOthersourceGct() {
		return this.othersourceGct;
	}

	public void setOthersourceGct(Integer othersourceGct) {
		this.othersourceGct = othersourceGct;
	}

	@Column(name = "OTHERSOURCE_MTHLY_AMT", precision = 15)
	public Double getOthersourceMthlyAmt() {
		return this.othersourceMthlyAmt;
	}

	public void setOthersourceMthlyAmt(Double othersourceMthlyAmt) {
		this.othersourceMthlyAmt = othersourceMthlyAmt;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OTHERSOURCE_DATE", length = 10)
	public Date getOthersourceDate() {
		return this.othersourceDate;
	}

	public void setOthersourceDate(Date othersourceDate) {
		this.othersourceDate = othersourceDate;
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