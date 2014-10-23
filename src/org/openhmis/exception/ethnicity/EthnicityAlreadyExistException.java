package org.openhmis.exception.ethnicity;

import org.openhmis.exception.HMISAPIException;

public class EthnicityAlreadyExistException extends HMISAPIException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2157647914095089402L;
	
	public EthnicityAlreadyExistException()
	{
		super();
	}
	public EthnicityAlreadyExistException(String message)
	{
		super(message);
	}
}
