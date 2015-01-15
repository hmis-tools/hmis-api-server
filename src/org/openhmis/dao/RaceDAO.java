/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.dao;

import java.util.List;

import org.openhmis.domain.Race;

public interface RaceDAO extends BaseDAO
{
        public List<Object[]> findRaceCodes();                                                                          // array of race codes
        public List<Race> findRaces();                                                                                  // list of race codes
}