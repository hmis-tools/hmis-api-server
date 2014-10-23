package org.openhmis.exception.race;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class RaceNotFoundException extends NotFoundException implements ExceptionMapper<RaceNotFoundException>
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
	@Override
	public Response toResponse(RaceNotFoundException raceNotFoundException) 
	{
		return Response.status(Response.Status.NOT_FOUND).build();
	}	
}
