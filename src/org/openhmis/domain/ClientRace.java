package org.openhmis.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ClientRace entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_RACE", catalog = "OPENHMIS2")
public class ClientRace implements java.io.Serializable {

	// Fields

	private Long id;
	private Long clientKey;
	private Integer raceCode;
	private Integer recActiveGct;
	private Timestamp entryDateTime;
	private Long entryUserKey;
	private Timestamp logDateTime;
	private Long logUserKey;

	// Constructors

	/** default constructor */
	public ClientRace() {
	}

	/** minimal constructor */
	public ClientRace(Long clientKey, Integer raceCode, Timestamp logDateTime) {
		this.clientKey = clientKey;
		this.raceCode = raceCode;
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public ClientRace(Long clientKey, Integer raceCode, Integer recActiveGct,
			Timestamp entryDateTime, Long entryUserKey, Timestamp logDateTime,
			Long logUserKey) {
		this.clientKey = clientKey;
		this.raceCode = raceCode;
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

	@Column(name = "RACE_CODE", nullable = false)
	public Integer getRaceCode() {
		return this.raceCode;
	}

	public void setRaceCode(Integer raceCode) {
		this.raceCode = raceCode;
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