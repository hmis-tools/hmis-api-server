package org.openhmis.dao;

import java.util.List;

import org.openhmis.domain.Race;

public interface RaceDAO extends BaseDAO
{
        public List<Object[]> findRaceCodes();                                                                          // array of race codes
        public List<Race> findRaces();                                                                                  // list of race codes
}