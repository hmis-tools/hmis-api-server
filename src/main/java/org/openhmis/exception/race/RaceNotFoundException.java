/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.exception.race;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class RaceNotFoundException extends NotFoundException implements ExceptionMapper<RaceNotFoundException>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4538762665917638757L;

	public RaceNotFoundException()
	{
		super();
	}
	public RaceNotFoundException(String message)
	{
		super(message);
	}
	@Override
	public Response toResponse(RaceNotFoundException raceNotFoundException) 
	{
		return Response.status(Response.Status.NOT_FOUND).build();
	}	
}
