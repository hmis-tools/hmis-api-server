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
