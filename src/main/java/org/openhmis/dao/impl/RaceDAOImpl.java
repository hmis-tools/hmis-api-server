/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.openhmis.dao.RaceDAO;
import org.openhmis.domain.CodeRace;


public class RaceDAOImpl extends BaseDAOImpl implements RaceDAO
{
	private static final Logger log = Logger.getLogger(RaceDAOImpl.class);
	
	// default constructor
	public RaceDAOImpl()
	{
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findRaceCodes() 
	{
		log.debug("finding all Race codes");
		try
		{
			String queryString = "select r.raceKey from Race r";
			Query queryObject = getSession().createQuery(queryString);
			return (List<Object[]>)queryObject.list();
		}
		catch (RuntimeException re)
		{
			log.error("find Races codes failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeRace> findRaces() 
	{
		log.debug("finding all Race instances");
		try 
		{
			String queryString = "from CodeRace";
			Query queryObject = getSession().createQuery(queryString);
			return (List<CodeRace>)queryObject.list();
		}
		catch (RuntimeException re)
		{
			log.error("find Races failed", re);
			throw re;
		}
	}	
}
