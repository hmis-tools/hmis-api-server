package org.openhims.oauth2.rest.impl;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class PathwayToken extends DefaultOAuth2AccessToken
{
	public static String ID_TOKEN = "id_token";
	
	public PathwayToken(OAuth2AccessToken accessToken) 
	{
		super(accessToken);
	}

	public PathwayToken(String accessTokenValue)
	{
		super(accessTokenValue);
	}
	
	private String idTokenValue;

	public String getIdTokenValue() {
		return this.idTokenValue;
	}

	public void setIdTokenValue(String idTokenValue) {
		this.idTokenValue = idTokenValue;
	}
	
	
}
