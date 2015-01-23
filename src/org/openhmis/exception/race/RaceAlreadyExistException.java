/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.exception.race;

import org.openhmis.exception.HMISAPIException;

public class RaceAlreadyExistException extends HMISAPIException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6295165531199520558L;
	
	public RaceAlreadyExistException()
	{
		super();
	}
	public RaceAlreadyExistException(String message)
	{
		super(message);
	}

}
