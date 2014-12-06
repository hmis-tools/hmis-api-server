package org.openhmis.exception.gender;

import org.openhmis.exception.HMISAPIException;

public class GenderAlreadyExistException extends HMISAPIException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8508920773057853271L;
	
	public GenderAlreadyExistException()
	{
		super();
	}
	public GenderAlreadyExistException(String message)
	{
		super(message);
	}

}
