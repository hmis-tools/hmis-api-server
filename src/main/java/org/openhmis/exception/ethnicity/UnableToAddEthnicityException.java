/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

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
