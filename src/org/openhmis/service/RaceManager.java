/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.service;

import java.util.List;

import org.openhmis.domain.Race;
import org.openhmis.exception.race.RaceAlreadyExistException;
import org.openhmis.exception.race.RaceNotFoundException;


public interface RaceManager 
{
	public Boolean addRace(Race race) throws RaceAlreadyExistException;
	public List<Object[]> getRaceCodes() throws RaceNotFoundException;									// array of all the race codes
	public List<Race> getRaces() throws RaceNotFoundException;											// list of all the race codes
}
