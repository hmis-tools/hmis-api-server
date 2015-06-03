package org.openhims.oauth2.domain;

import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;



public class OAuth2AuthenticationRefreshToken 
{
	 private String tokenId;
	 private OAuth2RefreshToken oAuth2RefreshToken;
	 private OAuth2Authentication authentication;
	public OAuth2AuthenticationRefreshToken() {
		super();
	}
	public OAuth2AuthenticationRefreshToken(String tokenId,
			OAuth2RefreshToken oAuth2RefreshToken,
			OAuth2Authentication authentication) {
		super();
		this.tokenId = tokenId;
		this.oAuth2RefreshToken = oAuth2RefreshToken;
		this.authentication = authentication;
	}
	
	public OAuth2AuthenticationRefreshToken(
			OAuth2RefreshToken oAuth2RefreshToken,
			OAuth2Authentication authentication) {
		super();
		this.oAuth2RefreshToken = oAuth2RefreshToken;
		this.authentication = authentication;
	}
	public String getTokenId() {
		return this.tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public OAuth2RefreshToken getoAuth2RefreshToken() {
		return this.oAuth2RefreshToken;
	}
	public void setoAuth2RefreshToken(OAuth2RefreshToken oAuth2RefreshToken) {
		this.oAuth2RefreshToken = oAuth2RefreshToken;
	}
	public OAuth2Authentication getAuthentication() {
		return this.authentication;
	}
	public void setAuthentication(OAuth2Authentication authentication) {
		this.authentication = authentication;
	}
	 
	 
}
