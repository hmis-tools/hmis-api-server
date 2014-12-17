package org.openhmis.exception.race;

import org.openhmis.exception.HMISAPIException;

public class RaceNotFoundException extends HMISAPIException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4538762665917638757L;

	public RaceNotFoundException()
	{
		super();
	}
	public RaceNotFoundException(String message)
	{
		super(message);
	}
}
