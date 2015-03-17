/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.service.impl;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openhmis.exception.oauth2.UnableToAuthorizeException;
import org.openhmis.oauth2.google.OAuth2ServiceAccount;
import org.openhmis.oauth2.salesforce.OAuth2Details;
import org.openhmis.oauth2.salesforce.OAuth2Utils;
import org.openhmis.service.AuthenticateManager;
import org.openhmis.util.OAuthConstants;

/**
 * 
 * @author Ashaar Riaz
 * @since December 24, 2014
 * <p> This class perform all the authorization
 */

public class AuthenticateManagerImpl implements AuthenticateManager 
{
	private static Logger log = Logger.getLogger(AuthenticateManagerImpl.class);
	OAuth2Utils auth2Utils = null;
	public AuthenticateManagerImpl()
	{
		auth2Utils=  new OAuth2Utils();
	}
	@Override
	public boolean authenticateUser(String username, String password) throws UnableToAuthorizeException
	{
		log.debug("authenticateUser");
		if( (username == null) || (password == null) || (username.length() ==0) || (password.length() ==0))
			throw new UnableToAuthorizeException("Unable to authorize, invalid username or password");
		boolean isUserAuthenticate = false;
		try
		{
			if (password.contains("@developer.gserviceaccount.com"))
			{
				isUserAuthenticate = this.authenticateGoogleUser(username, password);
			}
			else
			{
				isUserAuthenticate = this.authenticateSaleForceUser(username, password);
			}
		}
		catch(Exception e)
		{
			throw new UnableToAuthorizeException("Unable to authorize user " + e.getMessage());
		}
		return isUserAuthenticate;
	}
	
	private boolean authenticateSaleForceUser(String username, String password) throws UnableToAuthorizeException
	{
		log.debug("authenticate Sales Force user");
		boolean isUserAuthenticate = false;
		try
		{
			log.debug("Reading the properties file");
			Properties config = auth2Utils.getClientConfigProps(OAuthConstants.CONFIG_FILE_PATH);
			auth2Utils.createOAuthDetails(config, username, password);
			OAuth2Details oauthDetails = auth2Utils.createOAuthDetails(config, username, password);
			log.debug("getting access token ");
			String accessToken = auth2Utils.getAccessToken(oauthDetails);
			if(auth2Utils.isValid(accessToken))
			{
				isUserAuthenticate = true;
			}
		}
		catch(Exception e)
		{
			throw new UnableToAuthorizeException("Unable to authorize user " + username + " "  + e.getMessage());
		}
		return isUserAuthenticate;
	}
	
	private boolean authenticateGoogleUser(String username,
			String emailAddress) throws UnableToAuthorizeException
	{
		boolean isUserAuthenticate = false;
		try
		{
			log.debug("authenticate the user from the google service account");
			String path = OAuthConstants.PRIVATE_KEY_FILE_PATH;
			OAuth2ServiceAccount oAuth2ServiceAccount = new OAuth2ServiceAccount();
			oAuth2ServiceAccount.authorize(path, username, emailAddress);
			isUserAuthenticate = true;
		}
		catch(Exception e)
		{
			throw new UnableToAuthorizeException("Unable to authorize user " + username + " " + e.getMessage());
		}
		return isUserAuthenticate;
	}
	
	
}
