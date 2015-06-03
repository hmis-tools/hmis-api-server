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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @since June 1, 2015
 * @author Ashaar Riaz
 */
@Entity
@Table(name = "oauth_client_details")
public class OauthClientDetails implements java.io.Serializable {

	// Fields

	private Integer clientId;
	private Users usersByLogUsersId;
	private Users usersByEntryUsersId;
	private Users usersByUsersId;
	private String resourcesId;
	private String clientSecret;
	private String scope;
	private String authorizedGrantsTypes;
	private String webServerRedirectUri;
	private String authorities;
	private Integer accesTokenValidity;
	private Integer refreshTokenValidity;
	private String additionalInformation;
	private Timestamp entryDate;
	private Timestamp logDate;
	private Set<UsersHasOauthClientDetails> usersHasOauthClientDetailses = new HashSet<UsersHasOauthClientDetails>(
			0);

	// Constructors

	/** default constructor */
	public OauthClientDetails() {
	}

	/** minimal constructor */
	public OauthClientDetails(Integer clientId, Users usersByLogUsersId,
			Users usersByEntryUsersId, Users usersByUsersId) {
		this.clientId = clientId;
		this.usersByLogUsersId = usersByLogUsersId;
		this.usersByEntryUsersId = usersByEntryUsersId;
		this.usersByUsersId = usersByUsersId;
	}

	/** full constructor */
	public OauthClientDetails(Integer clientId, Users usersByLogUsersId,
			Users usersByEntryUsersId, Users usersByUsersId,
			String resourcesId, String clientSecret, String scope,
			String authorizedGrantsTypes, String webServerRedirectUri,
			String authorities, Integer accesTokenValidity,
			Integer refreshTokenValidity, String additionalInformation,
			Timestamp entryDate, Timestamp logDate,
			Set<UsersHasOauthClientDetails> usersHasOauthClientDetailses) {
		this.clientId = clientId;
		this.usersByLogUsersId = usersByLogUsersId;
		this.usersByEntryUsersId = usersByEntryUsersId;
		this.usersByUsersId = usersByUsersId;
		this.resourcesId = resourcesId;
		this.clientSecret = clientSecret;
		this.scope = scope;
		this.authorizedGrantsTypes = authorizedGrantsTypes;
		this.webServerRedirectUri = webServerRedirectUri;
		this.authorities = authorities;
		this.accesTokenValidity = accesTokenValidity;
		this.refreshTokenValidity = refreshTokenValidity;
		this.additionalInformation = additionalInformation;
		this.entryDate = entryDate;
		this.logDate = logDate;
		this.usersHasOauthClientDetailses = usersHasOauthClientDetailses;
	}

	// Property accessors
	@Id
	@Column(name = "client_id", unique = true, nullable = false)
	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id", nullable = false)
	public Users getUsersByUsersId() {
		return this.usersByUsersId;
	}

	public void setUsersByUsersId(Users usersByUsersId) {
		this.usersByUsersId = usersByUsersId;
	}

	@Column(name = "resources_id", length = 1024)
	public String getResourcesId() {
		return this.resourcesId;
	}

	public void setResourcesId(String resourcesId) {
		this.resourcesId = resourcesId;
	}

	@Column(name = "client_secret")
	public String getClientSecret() {
		return this.clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	@Column(name = "scope", length = 1024)
	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Column(name = "authorized_grants_types")
	public String getAuthorizedGrantsTypes() {
		return this.authorizedGrantsTypes;
	}

	public void setAuthorizedGrantsTypes(String authorizedGrantsTypes) {
		this.authorizedGrantsTypes = authorizedGrantsTypes;
	}

	@Column(name = "web_server_redirect_uri", length = 1024)
	public String getWebServerRedirectUri() {
		return this.webServerRedirectUri;
	}

	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}

	@Column(name = "authorities", length = 1024)
	public String getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	@Column(name = "acces_token_validity")
	public Integer getAccesTokenValidity() {
		return this.accesTokenValidity;
	}

	public void setAccesTokenValidity(Integer accesTokenValidity) {
		this.accesTokenValidity = accesTokenValidity;
	}

	@Column(name = "refresh_token_validity")
	public Integer getRefreshTokenValidity() {
		return this.refreshTokenValidity;
	}

	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	@Column(name = "additional_information", length = 4096)
	public String getAdditionalInformation() {
		return this.additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "oauthClientDetails")
	public Set<UsersHasOauthClientDetails> getUsersHasOauthClientDetailses() {
		return this.usersHasOauthClientDetailses;
	}

	public void setUsersHasOauthClientDetailses(
			Set<UsersHasOauthClientDetails> usersHasOauthClientDetailses) {
		this.usersHasOauthClientDetailses = usersHasOauthClientDetailses;
	}

}