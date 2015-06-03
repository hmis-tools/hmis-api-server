package org.openhims.oauth2.exception;

public class InvalidRequestException extends ClientAuthenticationException 
{
	public InvalidRequestException()
	{
		super();
	}
	
	public InvalidRequestException(String message, Throwable cause) 
	{
		super(message, cause);
	}

	public InvalidRequestException(String message)
	{
		super(message);
	}
	
	public InvalidRequestException(Throwable cause)
	{
		super(cause);
	}
	
	@Override
	public String getOauth2ErrorCode() {
		return "invalid_request";
	}

}
