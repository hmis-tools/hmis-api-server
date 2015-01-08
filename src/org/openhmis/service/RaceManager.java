package org.openhmis.service;

import java.util.List;

import org.openhmis.domain.CodeRace;
import org.openhmis.exception.race.RaceAlreadyExistException;
import org.openhmis.exception.race.RaceNotFoundException;
import org.openhmis.exception.race.UnableToUpdateRaceException;


public interface RaceManager 
{
	public Boolean addRace(CodeRace race) throws RaceAlreadyExistException;
	public List<Object[]> getRaceCodes() throws RaceNotFoundException;									// array of all the race codes
	public List<CodeRace> getRaces() throws RaceNotFoundException;											// list of all the race codes
//	public List<CodeRace> getRacesByClientKey(Long clientKey) throws RaceNotFoundException;
	public Boolean updateRace(CodeRace race)throws UnableToUpdateRaceException;
}
