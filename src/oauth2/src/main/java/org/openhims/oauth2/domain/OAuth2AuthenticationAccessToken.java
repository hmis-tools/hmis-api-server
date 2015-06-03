package org.openhims.oauth2.domain;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;



public class OAuth2AuthenticationAccessToken 
{
	private String tokenId;
    private OAuth2AccessToken oAuth2AccessToken;
    private String authenticationId;
    private String userName;
    private String clientId;
    private OAuth2Authentication authentication;
    private String refreshToken;
    
	public OAuth2AuthenticationAccessToken() {
		super();
	}
	public OAuth2AuthenticationAccessToken(String tokenId,
			OAuth2AccessToken oAuth2AccessToken, String authenticationId,
			String userName, String clientId,
			OAuth2Authentication authentication, String refreshToken) {
		super();
		this.tokenId = tokenId;
		this.oAuth2AccessToken = oAuth2AccessToken;
		this.authenticationId = authenticationId;
		this.userName = userName;
		this.clientId = clientId;
		this.authentication = authentication;
		this.refreshToken = refreshToken;
	}
	public OAuth2AuthenticationAccessToken(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication authentication, String authenticationId)
	{
		this.oAuth2AccessToken = oAuth2AccessToken;
		this.authentication = authentication;
		this.authenticationId = authenticationId;
	}
	public String getTokenId() {
		return this.tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public OAuth2AccessToken getoAuth2AccessToken() {
		return this.oAuth2AccessToken;
	}
	public void setoAuth2AccessToken(OAuth2AccessToken oAuth2AccessToken) {
		this.oAuth2AccessToken = oAuth2AccessToken;
	}
	public String getAuthenticationId() {
		return this.authenticationId;
	}
	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getClientId() {
		return this.clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public OAuth2Authentication getAuthentication() {
		return this.authentication;
	}
	public void setAuthentication(OAuth2Authentication authentication) {
		this.authentication = authentication;
	}
	public String getRefreshToken() {
		return this.refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
    
    
}
