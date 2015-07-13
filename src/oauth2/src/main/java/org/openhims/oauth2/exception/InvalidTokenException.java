package org.openhims.oauth2.exception;

public class InvalidTokenException extends ClientAuthenticationException 
{
	public InvalidTokenException()
	{
		super();
	}
	public InvalidTokenException(String message, Throwable cause) 
	{
		super(message, cause);
	}
	
	public InvalidTokenException(String message)
	{
		super(message);
	}

	public InvalidTokenException(Throwable cause)
	{
		super(cause);
	}
	
	@Override
	public int getHttpErrorCode() {
		return 401;
	}
	
	@Override
	public String getOauth2ErrorCode() {
		return "invalid_token";
	}

}
