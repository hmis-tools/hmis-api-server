package org.openhmis.exception.ethnicity;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UnableToUpdateEthnicityException extends InternalServerErrorException implements ExceptionMapper<UnableToUpdateEthnicityException>
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5946643148673023213L;
	
	public UnableToUpdateEthnicityException()
	{
		super();
	}

	public UnableToUpdateEthnicityException(String message)
	{
		super(message);
	}
	
	@Override
	public Response toResponse(UnableToUpdateEthnicityException exception) 
	{
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	
}
