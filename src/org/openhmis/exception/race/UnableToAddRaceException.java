package org.openhmis.exception.race;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UnableToAddRaceException extends InternalServerErrorException implements ExceptionMapper<UnableToAddRaceException>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8825001452732277237L;
	
	public UnableToAddRaceException()
	{
		super();
	}
	
	public UnableToAddRaceException(String message)
	{
		super(message);
	}

	@Override
	public Response toResponse(UnableToAddRaceException exception) 
	{
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

}
