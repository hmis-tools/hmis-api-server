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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @since June 1, 2015
 * @author Ashaar Riaz
 */
@Entity
@Table(name = "users")
public class Users implements java.io.Serializable {

	// Fields

	private Integer usersId;
	private Users usersByLogUsersId;
	private Users usersByEntryUsersId;
	private String username;
	private String password;
	private String email;
	private String givenName;
	private String familyName;
	private String phone;
	private String fax;
	private Timestamp entryDate;
	private Timestamp logDate;
	private Set<VendorIdentityProvider> vendorIdentityProvidersForEntryUsersId = new HashSet<VendorIdentityProvider>(
			0);
	private Set<Groups> groupses = new HashSet<Groups>(0);
	private Set<VendorIdentityProvider> vendorIdentityProvidersForLogUsersId = new HashSet<VendorIdentityProvider>(
			0);
	private Set<OauthClientDetails> oauthClientDetailsesForEntryUsersId = new HashSet<OauthClientDetails>(
			0);
	private Set<VendorZone> vendorZonesForEntryUsersId = new HashSet<VendorZone>(
			0);
	private Set<OauthClientDetails> oauthClientDetailsesForUsersId = new HashSet<OauthClientDetails>(
			0);
	private Set<OauthClientDetails> oauthClientDetailsesForLogUsersId = new HashSet<OauthClientDetails>(
			0);
	private Set<Authorities> authoritiesesForEntryUsersId = new HashSet<Authorities>(
			0);
	private Set<UsersHistory> usersHistoriesForLogUsersId = new HashSet<UsersHistory>(
			0);
	private Set<VendorZone> vendorZonesForLogUsersId = new HashSet<VendorZone>(
			0);
	private Set<UsersHasOauthClientDetails> usersHasOauthClientDetailses = new HashSet<UsersHasOauthClientDetails>(
			0);
	private Set<UsersHistory> usersHistoriesForEntryUsersId = new HashSet<UsersHistory>(
			0);
	private Set<Authorities> authoritiesesForLogUsersId = new HashSet<Authorities>(
			0);
	private Set<UsersHistory> usersHistoriesForUsersId = new HashSet<UsersHistory>(
			0);
	private Set<Users> usersesForEntryUsersId = new HashSet<Users>(0);
	private Set<Users> usersesForLogUsersId = new HashSet<Users>(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Users usersByLogUsersId, Users usersByEntryUsersId) {
		this.usersByLogUsersId = usersByLogUsersId;
		this.usersByEntryUsersId = usersByEntryUsersId;
	}

	/** full constructor */
	public Users(Users usersByLogUsersId, Users usersByEntryUsersId,
			String username, String password, String email, String givenName,
			String familyName, String phone, String fax, Timestamp entryDate,
			Timestamp logDate,
			Set<VendorIdentityProvider> vendorIdentityProvidersForEntryUsersId,
			Set<Groups> groupses,
			Set<VendorIdentityProvider> vendorIdentityProvidersForLogUsersId,
			Set<OauthClientDetails> oauthClientDetailsesForEntryUsersId,
			Set<VendorZone> vendorZonesForEntryUsersId,
			Set<OauthClientDetails> oauthClientDetailsesForUsersId,
			Set<OauthClientDetails> oauthClientDetailsesForLogUsersId,
			Set<Authorities> authoritiesesForEntryUsersId,
			Set<UsersHistory> usersHistoriesForLogUsersId,
			Set<VendorZone> vendorZonesForLogUsersId,
			Set<UsersHasOauthClientDetails> usersHasOauthClientDetailses,
			Set<UsersHistory> usersHistoriesForEntryUsersId,
			Set<Authorities> authoritiesesForLogUsersId,
			Set<UsersHistory> usersHistoriesForUsersId,
			Set<Users> usersesForEntryUsersId, Set<Users> usersesForLogUsersId) {
		this.usersByLogUsersId = usersByLogUsersId;
		this.usersByEntryUsersId = usersByEntryUsersId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.givenName = givenName;
		this.familyName = familyName;
		this.phone = phone;
		this.fax = fax;
		this.entryDate = entryDate;
		this.logDate = logDate;
		this.vendorIdentityProvidersForEntryUsersId = vendorIdentityProvidersForEntryUsersId;
		this.groupses = groupses;
		this.vendorIdentityProvidersForLogUsersId = vendorIdentityProvidersForLogUsersId;
		this.oauthClientDetailsesForEntryUsersId = oauthClientDetailsesForEntryUsersId;
		this.vendorZonesForEntryUsersId = vendorZonesForEntryUsersId;
		this.oauthClientDetailsesForUsersId = oauthClientDetailsesForUsersId;
		this.oauthClientDetailsesForLogUsersId = oauthClientDetailsesForLogUsersId;
		this.authoritiesesForEntryUsersId = authoritiesesForEntryUsersId;
		this.usersHistoriesForLogUsersId = usersHistoriesForLogUsersId;
		this.vendorZonesForLogUsersId = vendorZonesForLogUsersId;
		this.usersHasOauthClientDetailses = usersHasOauthClientDetailses;
		this.usersHistoriesForEntryUsersId = usersHistoriesForEntryUsersId;
		this.authoritiesesForLogUsersId = authoritiesesForLogUsersId;
		this.usersHistoriesForUsersId = usersHistoriesForUsersId;
		this.usersesForEntryUsersId = usersesForEntryUsersId;
		this.usersesForLogUsersId = usersesForLogUsersId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "users_id", unique = true, nullable = false)
	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
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

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "given_name")
	public String getGivenName() {
		return this.givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	@Column(name = "family_name")
	public String getFamilyName() {
		return this.familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	@Column(name = "phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "fax")
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByEntryUsersId")
	public Set<VendorIdentityProvider> getVendorIdentityProvidersForEntryUsersId() {
		return this.vendorIdentityProvidersForEntryUsersId;
	}

	public void setVendorIdentityProvidersForEntryUsersId(
			Set<VendorIdentityProvider> vendorIdentityProvidersForEntryUsersId) {
		this.vendorIdentityProvidersForEntryUsersId = vendorIdentityProvidersForEntryUsersId;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "users_has_groups", catalog = "mydb", joinColumns = { @JoinColumn(name = "users_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "groups_id", nullable = false, updatable = false) })
	public Set<Groups> getGroupses() {
		return this.groupses;
	}

	public void setGroupses(Set<Groups> groupses) {
		this.groupses = groupses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByLogUsersId")
	public Set<VendorIdentityProvider> getVendorIdentityProvidersForLogUsersId() {
		return this.vendorIdentityProvidersForLogUsersId;
	}

	public void setVendorIdentityProvidersForLogUsersId(
			Set<VendorIdentityProvider> vendorIdentityProvidersForLogUsersId) {
		this.vendorIdentityProvidersForLogUsersId = vendorIdentityProvidersForLogUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByEntryUsersId")
	public Set<OauthClientDetails> getOauthClientDetailsesForEntryUsersId() {
		return this.oauthClientDetailsesForEntryUsersId;
	}

	public void setOauthClientDetailsesForEntryUsersId(
			Set<OauthClientDetails> oauthClientDetailsesForEntryUsersId) {
		this.oauthClientDetailsesForEntryUsersId = oauthClientDetailsesForEntryUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByEntryUsersId")
	public Set<VendorZone> getVendorZonesForEntryUsersId() {
		return this.vendorZonesForEntryUsersId;
	}

	public void setVendorZonesForEntryUsersId(
			Set<VendorZone> vendorZonesForEntryUsersId) {
		this.vendorZonesForEntryUsersId = vendorZonesForEntryUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByUsersId")
	public Set<OauthClientDetails> getOauthClientDetailsesForUsersId() {
		return this.oauthClientDetailsesForUsersId;
	}

	public void setOauthClientDetailsesForUsersId(
			Set<OauthClientDetails> oauthClientDetailsesForUsersId) {
		this.oauthClientDetailsesForUsersId = oauthClientDetailsesForUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByLogUsersId")
	public Set<OauthClientDetails> getOauthClientDetailsesForLogUsersId() {
		return this.oauthClientDetailsesForLogUsersId;
	}

	public void setOauthClientDetailsesForLogUsersId(
			Set<OauthClientDetails> oauthClientDetailsesForLogUsersId) {
		this.oauthClientDetailsesForLogUsersId = oauthClientDetailsesForLogUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByEntryUsersId")
	public Set<Authorities> getAuthoritiesesForEntryUsersId() {
		return this.authoritiesesForEntryUsersId;
	}

	public void setAuthoritiesesForEntryUsersId(
			Set<Authorities> authoritiesesForEntryUsersId) {
		this.authoritiesesForEntryUsersId = authoritiesesForEntryUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByLogUsersId")
	public Set<UsersHistory> getUsersHistoriesForLogUsersId() {
		return this.usersHistoriesForLogUsersId;
	}

	public void setUsersHistoriesForLogUsersId(
			Set<UsersHistory> usersHistoriesForLogUsersId) {
		this.usersHistoriesForLogUsersId = usersHistoriesForLogUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByLogUsersId")
	public Set<VendorZone> getVendorZonesForLogUsersId() {
		return this.vendorZonesForLogUsersId;
	}

	public void setVendorZonesForLogUsersId(
			Set<VendorZone> vendorZonesForLogUsersId) {
		this.vendorZonesForLogUsersId = vendorZonesForLogUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
	public Set<UsersHasOauthClientDetails> getUsersHasOauthClientDetailses() {
		return this.usersHasOauthClientDetailses;
	}

	public void setUsersHasOauthClientDetailses(
			Set<UsersHasOauthClientDetails> usersHasOauthClientDetailses) {
		this.usersHasOauthClientDetailses = usersHasOauthClientDetailses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByEntryUsersId")
	public Set<UsersHistory> getUsersHistoriesForEntryUsersId() {
		return this.usersHistoriesForEntryUsersId;
	}

	public void setUsersHistoriesForEntryUsersId(
			Set<UsersHistory> usersHistoriesForEntryUsersId) {
		this.usersHistoriesForEntryUsersId = usersHistoriesForEntryUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByLogUsersId")
	public Set<Authorities> getAuthoritiesesForLogUsersId() {
		return this.authoritiesesForLogUsersId;
	}

	public void setAuthoritiesesForLogUsersId(
			Set<Authorities> authoritiesesForLogUsersId) {
		this.authoritiesesForLogUsersId = authoritiesesForLogUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByUsersId")
	public Set<UsersHistory> getUsersHistoriesForUsersId() {
		return this.usersHistoriesForUsersId;
	}

	public void setUsersHistoriesForUsersId(
			Set<UsersHistory> usersHistoriesForUsersId) {
		this.usersHistoriesForUsersId = usersHistoriesForUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByEntryUsersId")
	public Set<Users> getUsersesForEntryUsersId() {
		return this.usersesForEntryUsersId;
	}

	public void setUsersesForEntryUsersId(Set<Users> usersesForEntryUsersId) {
		this.usersesForEntryUsersId = usersesForEntryUsersId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersByLogUsersId")
	public Set<Users> getUsersesForLogUsersId() {
		return this.usersesForLogUsersId;
	}

	public void setUsersesForLogUsersId(Set<Users> usersesForLogUsersId) {
		this.usersesForLogUsersId = usersesForLogUsersId;
	}

}