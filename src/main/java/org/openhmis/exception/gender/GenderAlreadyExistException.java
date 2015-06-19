/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.exception.gender;

import org.openhmis.exception.HMISAPIException;

public class GenderAlreadyExistException extends HMISAPIException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8508920773057853271L;
	
	public GenderAlreadyExistException()
	{
		super();
	}
	public GenderAlreadyExistException(String message)
	{
		super(message);
	}

}
