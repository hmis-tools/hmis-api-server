package org.openhmis.exception.gender;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UnableToAddGenderException extends InternalServerErrorException implements ExceptionMapper<UnableToAddGenderException>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1374255764705155216L;

	public UnableToAddGenderException()
	{
		super();
	}
	
	public UnableToAddGenderException(String message)
	{
		super(message);
	}
	
	@Override
	public Response toResponse(UnableToAddGenderException exception) 
	{
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

}
