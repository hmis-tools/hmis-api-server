package org.openhmis.exception.client;

import org.openhmis.exception.HMISAPIException;

public class ClientAlreadyExistException extends HMISAPIException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 624522595891222311L;
	
	public ClientAlreadyExistException()
	{
		super();
	}
	public ClientAlreadyExistException(String message)
	{
		super(message);
	}

}
