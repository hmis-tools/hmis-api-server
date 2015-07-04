/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.exception.client;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.openhmis.exception.HMISAPIException;

@Provider
public class ClientNotFoundException extends HMISAPIException implements ExceptionMapper<ClientNotFoundException>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1912682213803490734L;
	
	public ClientNotFoundException(int status,String errorMessage, String developerMessage)
	{
		super(status,errorMessage, developerMessage);
	}

	@Override
	public Response toResponse(ClientNotFoundException clientNotFoundException) 
	{
		return Response.status(Response.Status.NOT_FOUND.getStatusCode()).entity(getErrorResponse()).build();
	}
}
