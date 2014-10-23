package org.openhmis.exception.gender;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class GenderNotFoundException extends NotFoundException implements ExceptionMapper<GenderNotFoundException>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083564827451968739L;

	public GenderNotFoundException()
	{
		super();
	}
	public GenderNotFoundException(String message)
	{
		super(message);
	}
	@Override
	public Response toResponse(GenderNotFoundException genderNotFoundException) 
	{
		return Response.status(Response.Status.NOT_FOUND).build();
	}	
}
