package org.openhims.oauth2.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @since June 1, 2015
 * @author Ashaar Riaz
 */
@Entity
@Table(name = "groups")
public class Groups implements java.io.Serializable {

	// Fields

	private Integer groupsId;
	private String groupName;
	private Timestamp entryDate;
	private Timestamp logDate;
	private Set<Authorities> authoritieses = new HashSet<Authorities>(0);
	private Set<Users> userses = new HashSet<Users>(0);

	// Constructors

	/** default constructor */
	public Groups() {
	}

	/** full constructor */
	public Groups(String groupName, Timestamp entryDate, Timestamp logDate,
			Set<Authorities> authoritieses, Set<Users> userses) {
		this.groupName = groupName;
		this.entryDate = entryDate;
		this.logDate = logDate;
		this.authoritieses = authoritieses;
		this.userses = userses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "groups_id", unique = true, nullable = false)
	public Integer getGroupsId() {
		return this.groupsId;
	}

	public void setGroupsId(Integer groupsId) {
		this.groupsId = groupsId;
	}

	@Column(name = "group_name")
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "groups_has_authorities", catalog = "mydb", joinColumns = { @JoinColumn(name = "groups_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "authorities_id", nullable = false, updatable = false) })
	public Set<Authorities> getAuthoritieses() {
		return this.authoritieses;
	}

	public void setAuthoritieses(Set<Authorities> authoritieses) {
		this.authoritieses = authoritieses;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "groupses")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}