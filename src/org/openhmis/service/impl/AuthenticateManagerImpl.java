package org.openhmis.service.impl;

import java.util.Properties;

import org.openhmis.oauth2.OAuth2Details;
import org.openhmis.oauth2.OAuth2Utils;
import org.openhmis.service.AuthenticateManager;
import org.openhmis.util.OAuthConstants;


public class AuthenticateManagerImpl implements AuthenticateManager 
{
	OAuth2Utils auth2Utils = null;
	public AuthenticateManagerImpl()
	{
		auth2Utils=  new OAuth2Utils();
	}
	@Override
	public boolean authenticateUser(String username, String password) 
	{
		boolean isUserAuthenticate = false;
		Properties config = auth2Utils.getClientConfigProps(OAuthConstants.CONFIG_FILE_PATH);
		auth2Utils.createOAuthDetails(config, username, password);
		OAuth2Details oauthDetails = auth2Utils.createOAuthDetails(config, username, password);
		String accessToken = auth2Utils.getAccessToken(oauthDetails);
		if(auth2Utils.isValid(accessToken))
		{
			isUserAuthenticate = true;
		}
		return isUserAuthenticate;
	}
}
