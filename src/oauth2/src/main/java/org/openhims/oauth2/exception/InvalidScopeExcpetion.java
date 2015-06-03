package org.openhims.oauth2.exception;

public class InvalidScopeExcpetion extends ClientAuthenticationException 
{
	public InvalidScopeExcpetion()
	{
		super();
	}
	public InvalidScopeExcpetion(String message, Throwable cause) 
	{
		super(message, cause);
	}
	public InvalidScopeExcpetion(String message)
	{
		super(message);
	}
	public InvalidScopeExcpetion(Throwable cause)
	{
		super(cause);
	}
	
	@Override
	public String getOauth2ErrorCode() {
		return "invalid scope";
	}
}
