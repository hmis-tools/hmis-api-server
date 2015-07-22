/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhims.oauth2.exception;

public class Oauth2Exception extends RuntimeException {
	private String message;

	public Oauth2Exception() {
		super();
	}

	public Oauth2Exception(String message, Throwable cause) {
		super(message, cause);
	}

	public Oauth2Exception(String message) {
		super(message);
	}
	
	public Oauth2Exception(Throwable cause)
	{
		super(cause);
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
	
	public int getHttpErrorCode()
	{
		return 400;
	}
	
	public String getOauth2ErrorCode() 
	{
		return "invalid_request";
	}
}
