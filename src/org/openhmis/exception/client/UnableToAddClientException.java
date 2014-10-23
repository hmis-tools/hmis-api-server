package org.openhmis.exception.client;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UnableToAddClientException extends InternalServerErrorException implements ExceptionMapper<UnableToAddClientException>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3512783487770095873L;
	
	
	public UnableToAddClientException()
	{
		super();
	}

	public UnableToAddClientException(String message)
	{
		super(message);
	}
	@Override
	public Response toResponse(UnableToAddClientException exception) 
	{
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}

}
