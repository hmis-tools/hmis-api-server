package org.openhmis.exception.client;

import org.openhmis.exception.HMISAPIException;

public class DeleteClientException extends HMISAPIException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 947672400880821547L;
	
	public DeleteClientException()
	{
		super();
	}
	public DeleteClientException(String message)
	{
		super(message);
	}

}
