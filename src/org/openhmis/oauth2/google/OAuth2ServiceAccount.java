package org.openhmis.oauth2.google;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.openhmis.exception.oauth2.UnableToAuthorizeException;
import org.openhmis.oauth2.salesforce.OAuth2Utils;
import org.openhmis.util.OAuthConstants;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;


/**
 * 
 * @author Ashaar Riaz
 *<p> Class to authenticate the user using the service account
 *
 */
public class OAuth2ServiceAccount 
{
	private static final Logger log = Logger.getLogger(OAuth2ServiceAccount.class);
	private JsonFactory JSON_FACTORY = null;
	private HttpTransport httpTransport;
	public OAuth2ServiceAccount()
	{
		
	}

	/**
	 * 
	 * @param  		username			email address of the client making the access token request e.g, user@google.com
	 * @param 		emailAddress		service account address of the application
	 * @return  	Google credential object will be returned
	 * @throws UnableToAuthorizeException 
	 */
	public Credential authorize(String path, String username, String emailAddress) throws UnableToAuthorizeException
	{
		log.debug("authorizing the user");
		if (path == null || username == null || emailAddress == null)
			throw new UnableToAuthorizeException("Couldn't authorize with invalid values ");
		GoogleCredential credential = null;
		try
		{
			JSON_FACTORY = JacksonFactory.getDefaultInstance();
			
			httpTransport = GoogleNetHttpTransport.newTrustedTransport();
			credential = new GoogleCredential.Builder()		
			 							.setTransport(httpTransport)
			 							.setJsonFactory(JSON_FACTORY)
			 							.setServiceAccountId(emailAddress)
			 							.setServiceAccountScopes(Collections.singleton("https://mail.google.com/"))				// will change with the actual value once the account is setup
			 							.setServiceAccountPrivateKeyFromP12File(this.readPrivateKeyFile(path))
			 							.setServiceAccountUser(username)
			 							.build();				 
		}
		catch(Exception e)
		{
			throw new UnableToAuthorizeException(e.getMessage());
		}
		return credential;
	}
	
	/**
	 * <p> Read the private key from the resource location
	 * @param path
	 * @return
	 * @throws FileNotFoundException 
	 */
	private File readPrivateKeyFile(String path) throws FileNotFoundException
	{
		log.debug("readPrivateKeyFile");
		File file = null;
		try
		{
			file = new File(OAuth2Utils.class.getClassLoader().getResource(path + OAuthConstants.PRIVATE_KEY_FILE_NAME).getFile());
		}
		catch(Exception e)
		{
			throw new FileNotFoundException("File doesn't exist " +e.getMessage());
		}
		return file;
	}	
}
