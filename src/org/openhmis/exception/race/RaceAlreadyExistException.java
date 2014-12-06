package org.openhmis.exception.race;

import org.openhmis.exception.HMISAPIException;

public class RaceAlreadyExistException extends HMISAPIException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6295165531199520558L;
	
	public RaceAlreadyExistException()
	{
		super();
	}
	public RaceAlreadyExistException(String message)
	{
		super(message);
	}

}
