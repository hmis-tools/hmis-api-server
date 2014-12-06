package org.openhmis.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.openhmis.dao.GenderDAO;
import org.openhmis.domain.Gender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenderDAOImpl extends BaseDAOImpl implements GenderDAO 
{
	private static final Logger log = LoggerFactory.getLogger(GenderDAOImpl.class);
	
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
	public List<Gender> findGenders()
	{
		log.debug("finding all Gender instances");
		try 
		{
			String queryString = "from Gender";
			Query queryObject = getSession().createQuery(queryString);
			return (List<Gender>)queryObject.list();
		}
		catch (RuntimeException re)
		{
			log.error("find Genders failed", re);
			throw re;
		}
	}
	

}
