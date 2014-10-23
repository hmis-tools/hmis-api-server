package org.openhmis.exception.ethnicity;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UnableToAddEthnicityException extends InternalServerErrorException implements ExceptionMapper<UnableToAddEthnicityException>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7871183055880685588L;
	public UnableToAddEthnicityException()
	{
		super();
	}
	public UnableToAddEthnicityException(String message)
	{
		super(message);
	}
	@Override
	public Response toResponse(UnableToAddEthnicityException exception) 
	{
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	
}
