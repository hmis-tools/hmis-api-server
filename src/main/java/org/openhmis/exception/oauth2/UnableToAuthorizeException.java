package org.openhmis.exception.oauth2;

import org.openhmis.exception.HMISAPIException;

public class UnableToAuthorizeException extends HMISAPIException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnableToAuthorizeException()
	{
		super();
	}
	
	public UnableToAuthorizeException(String message)
	{
		super(message);
	}
}
