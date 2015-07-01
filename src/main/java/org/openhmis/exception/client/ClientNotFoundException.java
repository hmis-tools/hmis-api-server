/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

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
