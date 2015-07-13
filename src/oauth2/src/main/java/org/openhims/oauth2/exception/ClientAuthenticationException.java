/* Copyright (c) 2015 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhims.oauth2.exception;

public abstract class ClientAuthenticationException extends Oauth2Exception
{
	public ClientAuthenticationException()
	{
		super();
	}
	public ClientAuthenticationException(String message, Throwable cause)
	{
		super(message, cause);
	}
	public ClientAuthenticationException(String message)
	{
		super(message);
	}
	public ClientAuthenticationException(Throwable cause)
	{
		super(cause);
	}
	
	@Override
	public int getHttpErrorCode() 
	{
		return 400;
	}
	@Override
	public abstract String getOauth2ErrorCode(); 
}
