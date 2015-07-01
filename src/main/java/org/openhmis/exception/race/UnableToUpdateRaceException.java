package org.openhmis.exception.race;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UnableToUpdateRaceException extends InternalServerErrorException implements ExceptionMapper<UnableToUpdateRaceException>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3349425789573067700L;
	public UnableToUpdateRaceException()
	{
		super();
	}
	public UnableToUpdateRaceException(String message)
	{
		super(message);
	}
	@Override
	public Response toResponse(UnableToUpdateRaceException exception) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	
}
