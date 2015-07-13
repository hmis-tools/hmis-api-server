package org.openhims.oauth2.exception;


public class BadClientCredentialException extends ClientAuthenticationException
{

	public BadClientCredentialException(String message, Throwable cause)
	{
		super(message, cause);
	}
	public BadClientCredentialException(String message)
	{
		super(message);
	}
	public BadClientCredentialException(Throwable cause)
	{
		super(cause);
	}
	
	@Override
	public String getOauth2ErrorCode() {
		return "invalid_client";
	}

}
