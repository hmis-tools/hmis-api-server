/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.exception.client;

import org.openhmis.exception.HMISAPIException;

public class DeleteClientException extends HMISAPIException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 947672400880821547L;
	
	public DeleteClientException()
	{
		super();
	}
	public DeleteClientException(String message)
	{
		super(message);
	}

}
