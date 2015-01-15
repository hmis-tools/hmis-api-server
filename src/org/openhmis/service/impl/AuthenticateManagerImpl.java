/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

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
