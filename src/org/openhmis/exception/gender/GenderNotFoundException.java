package org.openhmis.exception.gender;

import org.openhmis.exception.HMISAPIException;

public class GenderNotFoundException extends HMISAPIException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083564827451968739L;

	public GenderNotFoundException()
	{
		super();
	}
	public GenderNotFoundException(String message)
	{
		super(message);
	}
}
