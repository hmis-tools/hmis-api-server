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
 * CodeRace entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CODE_RACE", catalog = "OPENHMIS2")
public class CodeRace implements java.io.Serializable {

	// Fields

	private Integer codeKey;
	private String description;
	private String shortDesc;
	private String notes;
	private Integer recActiveGct;
	private Timestamp logDateTime;
	private Long logUserKey;
	private Set<ClientRace> clientRaces = new HashSet<ClientRace>(0);

	// Constructors

	/** default constructor */
	public CodeRace() {
	}

	/** minimal constructor */
	public CodeRace(Timestamp logDateTime) {
		this.logDateTime = logDateTime;
	}

	/** full constructor */
	public CodeRace(String description, String shortDesc, String notes,
			Integer recActiveGct, Timestamp logDateTime, Long logUserKey,
			Set<ClientRace> clientRaces) {
		this.description = description;
		this.shortDesc = shortDesc;
		this.notes = notes;
		this.recActiveGct = recActiveGct;
		this.logDateTime = logDateTime;
		this.logUserKey = logUserKey;
		this.clientRaces = clientRaces;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "codeRace")
	public Set<ClientRace> getClientRaces() {
		return this.clientRaces;
	}

	public void setClientRaces(Set<ClientRace> clientRaces) {
		this.clientRaces = clientRaces;
	}

}