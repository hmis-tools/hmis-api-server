package org.openhmis.exception.client;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ClientNotFoundException extends NotFoundException implements ExceptionMapper<ClientNotFoundException>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1912682213803490734L;

	public ClientNotFoundException() 
	{
		super();
	}
	
	public ClientNotFoundException(String message)
	{
		super(message);
	}

	@Override
	public Response toResponse(ClientNotFoundException clientNotFoundException) 
	{
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
