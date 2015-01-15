/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

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
