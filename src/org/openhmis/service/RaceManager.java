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
