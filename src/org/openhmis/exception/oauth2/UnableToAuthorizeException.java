package org.openhmis.exception.oauth2;

import org.openhmis.exception.HMISAPIException;

public class UnableToAuthorizeException extends HMISAPIException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnableToAuthorizeException(int status,String errorMessage, String developerMessage)
	{
		super(status,errorMessage, developerMessage);
	}
}
