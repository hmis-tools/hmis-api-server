package org.openhims.oauth2.domain;

import java.sql.Timestamp;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @since June 1, 2015
 * @author Ashaar Riaz
 */
@Entity
@Table(name = "users_has_oauth_client_details")
public class UsersHasOauthClientDetails implements java.io.Serializable {

	// Fields

	private UsersHasOauthClientDetailsId id;
	private OauthClientDetails oauthClientDetails;
	private Users users;
	private String scope;
	private Timestamp expireStat;
	private String status;
	private Timestamp entryDate;
	private Timestamp logDate;

	// Constructors

	/** default constructor */
	public UsersHasOauthClientDetails() {
	}

	/** minimal constructor */
	public UsersHasOauthClientDetails(UsersHasOauthClientDetailsId id,
			OauthClientDetails oauthClientDetails, Users users) {
		this.id = id;
		this.oauthClientDetails = oauthClientDetails;
		this.users = users;
	}

	/** full constructor */
	public UsersHasOauthClientDetails(UsersHasOauthClientDetailsId id,
			OauthClientDetails oauthClientDetails, Users users, String scope,
			Timestamp expireStat, String status, Timestamp entryDate,
			Timestamp logDate) {
		this.id = id;
		this.oauthClientDetails = oauthClientDetails;
		this.users = users;
		this.scope = scope;
		this.expireStat = expireStat;
		this.status = status;
		this.entryDate = entryDate;
		this.logDate = logDate;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "usersId", column = @Column(name = "users_id", nullable = false)),
			@AttributeOverride(name = "clientId", column = @Column(name = "client_id", nullable = false)) })
	public UsersHasOauthClientDetailsId getId() {
		return this.id;
	}

	public void setId(UsersHasOauthClientDetailsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false, insertable = false, updatable = false)
	public OauthClientDetails getOauthClientDetails() {
		return this.oauthClientDetails;
	}

	public void setOauthClientDetails(OauthClientDetails oauthClientDetails) {
		this.oauthClientDetails = oauthClientDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id", nullable = false, insertable = false, updatable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Column(name = "scope", length = 1024)
	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Column(name = "expire_stat", length = 19)
	public Timestamp getExpireStat() {
		return this.expireStat;
	}

	public void setExpireStat(Timestamp expireStat) {
		this.expireStat = expireStat;
	}

	@Column(name = "status", length = 55)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}