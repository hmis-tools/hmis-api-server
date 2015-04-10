package org.openhmis.exception.gender;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UnableToUpdateGenderException extends InternalServerErrorException implements ExceptionMapper<UnableToUpdateGenderException>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8969345848610611019L;
	
	public UnableToUpdateGenderException()
	{
		super();
	}
	public UnableToUpdateGenderException(String message)
	{
		super(message);
	}

	@Override
	public Response toResponse(UnableToUpdateGenderException exception) 
	{
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

}
