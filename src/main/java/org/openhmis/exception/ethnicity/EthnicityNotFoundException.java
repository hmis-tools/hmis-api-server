/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.exception.ethnicity;

import org.openhmis.exception.HMISAPIException;

public class EthnicityNotFoundException extends HMISAPIException 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7967448744380043510L;
	
	public EthnicityNotFoundException()
	{
		super();
	}
	public EthnicityNotFoundException(String message)
	{
		super(message);
	}
}
