/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhims.oauth2.exception;

public class InvalidClientException extends ClientAuthenticationException 
{
	public InvalidClientException()
	{
		super();
	}
	
	public InvalidClientException(String message, Throwable cause) 
	{
		super(message, cause);
	}
	public InvalidClientException(Throwable cause)
	{
		super(cause);
	}
	@Override
	public int getHttpErrorCode() 
	{
		return 401;
	}

	@Override
	public String getOauth2ErrorCode() {
		return "invalid_client";
	}
}
