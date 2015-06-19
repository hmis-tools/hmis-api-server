/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.dao;

import java.util.List;

import org.openhmis.domain.CodeRace;
import org.openhmis.exception.race.RaceNotFoundException;

public interface RaceDAO extends BaseDAO
{
	public List<Object[]> findRaceCodes() throws RaceNotFoundException;										// array of race codes
	public List<CodeRace> findRaces() throws RaceNotFoundException;											// list of race codes
//	public List<CodeRace> findRacesByClientKey(Long clientKey) throws RaceNotFoundException;
}
