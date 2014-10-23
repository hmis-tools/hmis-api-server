package org.openhmis.exception.client;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class UnableToUpdateClientException extends InternalServerErrorException implements ExceptionMapper<UnableToUpdateClientException>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8578926361726767461L;
	public UnableToUpdateClientException()
	{
		super();
	}
	public UnableToUpdateClientException(String message)
	{
		super(message);
	}
	@Override
	public Response toResponse(UnableToUpdateClientException unableToUpdateClientException) 
	{
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	}
	
}
