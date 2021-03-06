package org.openhmis.domain;



// Generated Aug 5, 2015 10:00:15 PM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TmpDomesticAbuse generated by hbm2java
 */
@Entity
@Table(name = "TMP_DOMESTIC_ABUSE")
public class TmpDomesticAbuse implements java.io.Serializable {

	private Integer domesticAbuseId;
	private Integer enrollmentId;
	private Date informationDate;
	private Integer domesticViolenceVictim;
	private Integer whenOccurred;
	private Date dateCreated;
	private Date dateUpdated;

	public TmpDomesticAbuse() {
	}

	public TmpDomesticAbuse(Integer enrollmentId, Date informationDate,
			Integer domesticViolenceVictim, Integer whenOccurred,
			Date dateCreated, Date dateUpdated) {
		this.enrollmentId = enrollmentId;
		this.informationDate = informationDate;
		this.domesticViolenceVictim = domesticViolenceVictim;
		this.whenOccurred = whenOccurred;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "domesticAbuseId", unique = true, nullable = false)
	public Integer getDomesticAbuseId() {
		return this.domesticAbuseId;
	}

	public void setDomesticAbuseId(Integer domesticAbuseId) {
		this.domesticAbuseId = domesticAbuseId;
	}

	@Column(name = "enrollmentId")
	public Integer getEnrollmentId() {
		return this.enrollmentId;
	}

	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "informationDate", length = 10)
	public Date getInformationDate() {
		return this.informationDate;
	}

	public void setInformationDate(Date informationDate) {
		this.informationDate = informationDate;
	}

	@Column(name = "domesticViolenceVictim")
	public Integer getDomesticViolenceVictim() {
		return this.domesticViolenceVictim;
	}

	public void setDomesticViolenceVictim(Integer domesticViolenceVictim) {
		this.domesticViolenceVictim = domesticViolenceVictim;
	}

	@Column(name = "whenOccurred")
	public Integer getWhenOccurred() {
		return this.whenOccurred;
	}

	public void setWhenOccurred(Integer whenOccurred) {
		this.whenOccurred = whenOccurred;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateCreated", length = 10)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateUpdated", length = 10)
	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}
