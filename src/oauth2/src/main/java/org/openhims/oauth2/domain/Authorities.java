package org.openhims.oauth2.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @since June 1, 2015
 * @author Ashaar Riaz
 */
@Entity
@Table(name = "authorities")
public class Authorities implements java.io.Serializable {

	// Fields

	private Integer authoritiesId;
	private Users usersByLogUsersId;
	private Users usersByEntryUsersId;
	private String authorityName;
	private Timestamp entryDate;
	private Timestamp logDate;
	private Set<Groups> groupses = new HashSet<Groups>(0);

	// Constructors

	/** default constructor */
	public Authorities() {
	}

	/** minimal constructor */
	public Authorities(Integer authoritiesId, Users usersByLogUsersId,
			Users usersByEntryUsersId) {
		this.authoritiesId = authoritiesId;
		this.usersByLogUsersId = usersByLogUsersId;
		this.usersByEntryUsersId = usersByEntryUsersId;
	}

	/** full constructor */
	public Authorities(Integer authoritiesId, Users usersByLogUsersId,
			Users usersByEntryUsersId, String authorityName,
			Timestamp entryDate, Timestamp logDate, Set<Groups> groupses) {
		this.authoritiesId = authoritiesId;
		this.usersByLogUsersId = usersByLogUsersId;
		this.usersByEntryUsersId = usersByEntryUsersId;
		this.authorityName = authorityName;
		this.entryDate = entryDate;
		this.logDate = logDate;
		this.groupses = groupses;
	}

	// Property accessors
	@Id
	@Column(name = "authorities_id", unique = true, nullable = false)
	public Integer getAuthoritiesId() {
		return this.authoritiesId;
	}

	public void setAuthoritiesId(Integer authoritiesId) {
		this.authoritiesId = authoritiesId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "log_users_id", nullable = false)
	public Users getUsersByLogUsersId() {
		return this.usersByLogUsersId;
	}

	public void setUsersByLogUsersId(Users usersByLogUsersId) {
		this.usersByLogUsersId = usersByLogUsersId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entry_users_id", nullable = false)
	public Users getUsersByEntryUsersId() {
		return this.usersByEntryUsersId;
	}

	public void setUsersByEntryUsersId(Users usersByEntryUsersId) {
		this.usersByEntryUsersId = usersByEntryUsersId;
	}

	@Column(name = "authority_name", length = 45)
	public String getAuthorityName() {
		return this.authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	@Column(name = "entry_date", length = 19)
	public Timestamp getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Timestamp entryDate) {
		this.entryDate = entryDate;
	}

	@Column(name = "log_date", length = 19)
	public Timestamp getLogDate() {
		return this.logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authoritieses")
	public Set<Groups> getGroupses() {
		return this.groupses;
	}

	public void setGroupses(Set<Groups> groupses) {
		this.groupses = groupses;
	}

}