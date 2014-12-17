package org.openhmis.exception.ethnicity;

import org.openhmis.exception.HMISAPIException;

public class EthnicityNotFoundException extends HMISAPIException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7967448744380043510L;
	
	public EthnicityNotFoundException()
	{
		super();
	}
	public EthnicityNotFoundException(String message)
	{
		super(message);
	}
}
