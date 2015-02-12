/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.openhmis.dao.RaceDAO;
import org.openhmis.dao.impl.RaceDAOImpl;
import org.openhmis.domain.CodeRace;
import org.openhmis.exception.race.RaceAlreadyExistException;
import org.openhmis.exception.race.RaceNotFoundException;
import org.openhmis.exception.race.UnableToUpdateRaceException;
import org.openhmis.service.RaceManager;


/**
 * 
 * @author Ashaar Riaz
 * @since  August 23, 2014
 * 
 * to do add the exception handling
 *
 */
public class RaceManagerImpl implements RaceManager 
{
	private static final Logger log = Logger.getLogger(RaceManagerImpl.class);
	private RaceDAO raceDAO = null;
	
	// default constructor
	public RaceManagerImpl()
	{
		this.raceDAO = new RaceDAOImpl();
	}
		
	@Override
	public Boolean addRace(CodeRace race) throws RaceAlreadyExistException 
	{
		log.debug("addRace");
		return raceDAO.save(race);
	}

	@Override
	public List<Object[]> getRaceCodes() throws RaceNotFoundException
	{
		log.debug("getRaceCodes");
		return raceDAO.findRaceCodes();
	}
	@Override
	public List<CodeRace> getRaces() throws RaceNotFoundException
	{
		log.debug("getRaces");
		return raceDAO.findRaces();
	}

	@Override
	public Boolean updateRace(CodeRace race) throws UnableToUpdateRaceException 
	{
		log.debug("updateRace");
		return raceDAO.update(race);
	}
}
