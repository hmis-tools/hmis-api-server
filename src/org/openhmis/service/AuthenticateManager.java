package org.openhmis.service;

import org.openhmis.exception.oauth2.UnableToAuthorizeException;

public interface AuthenticateManager 
{
	public boolean authenticateUser(String username, String password) throws UnableToAuthorizeException;
}
