package org.openhmis.exception.client;

import org.openhmis.exception.HMISAPIException;

public class ClientNotFoundException extends HMISAPIException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1912682213803490734L;

	public ClientNotFoundException() 
	{
		super();
	}
	
	public ClientNotFoundException(String message)
	{
		super(message);
	}

}
