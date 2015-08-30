/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;


public class Authentication {

	private static final HttpTransport TRANSPORT = new NetHttpTransport();
	private static final JacksonFactory JSON_FACTORY = new JacksonFactory();

	private Authentication() {}

	public static void googleAuthenticate(String code) {
 		Properties properties = new Properties();
 		String propertyFileLocation = null;
 		try {
 			InitialContext context;
			context = new InitialContext();
	 		propertyFileLocation = (String) context.lookup("java:comp/src/config");
		} catch (NamingException e1) {}
 		if (propertyFileLocation!= null) {
			File propertyFile = new File(propertyFileLocation  + "/authentication.properties");
			InputStream is;
			try {
				is = new FileInputStream(propertyFile);
				properties.load(is);
			} catch (FileNotFoundException e1) {
				// Couldn't load the property file
			} catch (IOException e) {
				// Property file wasn't of the proper format
			}

			try {
				// Upgrade the authorization code into an access and refresh token.
				GoogleTokenResponse tokenResponse =
					new GoogleAuthorizationCodeTokenRequest(TRANSPORT, JSON_FACTORY,
						properties.getProperty("google.clientid"), properties.getProperty("google.clientsecret"), code, "postmessage").execute();

				// You can read the Google user ID in the ID token.
				// This sample does not use the user ID.
				GoogleIdToken idToken = tokenResponse.parseIdToken();
				String gplusId = idToken.getPayload().getSubject();

				// Store the token in the session for later use.
				//request.getSession().setAttribute("token", tokenResponse.toString());

				// Store the auth type for later use
				//request.getSession().setAttribute("isGoogle", true);
			} catch (TokenResponseException e) {
				// Failed to upgrade the authorization code.
			} catch (IOException e) {
				// Failed to read token data from Google.
			}
		}
	}

}