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
import org.openhmis.dao.GenderDAO;
import org.openhmis.domain.CodeGender;


public class GenderDAOImpl extends BaseDAOImpl implements GenderDAO 
{
	private static final Logger log = Logger.getLogger(GenderDAOImpl.class);
	
	// default constructor
	public GenderDAOImpl()
	{
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findGenderCodes() 
	{
		log.debug("finding all gender codes");
		try
		{
			String queryString = "select g.genderKey from Gender g";
			Query queryObject = getSession().createQuery(queryString);
			return (List<Object[]>)queryObject.list();
		}
		catch (RuntimeException re)
		{
			log.error("find Gender codes failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeGender> findGenders()
	{
		log.debug("finding all Gender instances");
		try 
		{
			String queryString = "from CodeGender";
			Query queryObject = getSession().createQuery(queryString);
			return (List<CodeGender>)queryObject.list();
		}
		catch (RuntimeException re)
		{
			log.error("find Genders failed", re);
			throw re;
		}
	}
}
