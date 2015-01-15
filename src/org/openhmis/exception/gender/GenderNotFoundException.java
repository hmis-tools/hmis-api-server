/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.exception.gender;

import org.openhmis.exception.HMISAPIException;

public class GenderNotFoundException extends HMISAPIException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083564827451968739L;

	public GenderNotFoundException()
	{
		super();
	}
	public GenderNotFoundException(String message)
	{
		super(message);
	}
}
