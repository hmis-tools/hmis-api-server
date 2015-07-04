/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public  class HMISAPIException extends WebApplicationException
{
	private int status;
	private String errorMessage;
	private String developerMessage;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4383743184249577734L;
	
	public HMISAPIException(int status, String errorMessage, String developerMessage)
	{
		this.status = status;
		this.errorMessage = errorMessage;
		this.developerMessage = developerMessage;
	}
	
	@Override
	public Response getResponse() 
	{
		return Response.status(status).type(MediaType.APPLICATION_JSON_TYPE).entity(getErrorResponse()).build();
	}
	
	public ErrorResponse getErrorResponse()
	{
		ErrorResponse response = new ErrorResponse();
		response.setErrorCode(status+"");
        response.setApplicationMessage(developerMessage);
        response.setConsumerMessage(errorMessage);
        return response;
	}
}
