package org.openhmis.oauth2.salesforce;

public class OAuth2Details
{
	private String scope;
	private String grantType;
	private String clientId;
	private String clientSecret;
	private String accessToken;
	private String refreshToken;
	private String username;
	private String password;
	private String authenticationServerUrl;
	
	
	public OAuth2Details() {
		super();
	}


	public OAuth2Details(String scope, String grantType, String clientId,
			String clientSecret, String accessToken, String refreshToken,
			String username, String password, String authenticationServerUrl) {
		super();
		this.scope = scope;
		this.grantType = grantType;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.username = username;
		this.password = password;
		this.authenticationServerUrl = authenticationServerUrl;
	}


	public String getScope() {
		return scope;
	}


	public void setScope(String scope) {
		this.scope = scope;
	}


	public String getGrantType() {
		return grantType;
	}


	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public String getClientSecret() {
		return clientSecret;
	}


	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getRefreshToken() {
		return refreshToken;
	}


	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAuthenticationServerUrl() {
		return authenticationServerUrl;
	}


	public void setAuthenticationServerUrl(String authenticationServerUrl) {
		this.authenticationServerUrl = authenticationServerUrl;
	}
	
}
