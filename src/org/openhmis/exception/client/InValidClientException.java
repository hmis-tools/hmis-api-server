package org.openhmis.exception.client;

import org.openhmis.exception.HMISAPIException;


public class InValidClientException extends HMISAPIException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4318994377490989737L;
	
	public InValidClientException()
	{
		super();
	}
	
	public InValidClientException(String message)
	{
		super(message);
	}

}
