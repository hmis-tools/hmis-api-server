package org.openhmis.service.impl;

import java.util.List;

import org.openhmis.dao.RaceDAO;
import org.openhmis.dao.impl.RaceDAOImpl;
import org.openhmis.domain.Race;
import org.openhmis.exception.race.RaceAlreadyExistException;
import org.openhmis.exception.race.RaceNotFoundException;
import org.openhmis.service.RaceManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static final Logger log = LoggerFactory.getLogger(RaceManagerImpl.class);
	private RaceDAO raceDAO = null;
	
	// default constructor
	public RaceManagerImpl()
	{
		this.raceDAO = new RaceDAOImpl();
	}
		
	@Override
	public Boolean addRace(Race race) throws RaceAlreadyExistException 
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
	public List<Race> getRaces() throws RaceNotFoundException
	{
		log.debug("getRaces");
		return raceDAO.findRaces();
	}	
}
