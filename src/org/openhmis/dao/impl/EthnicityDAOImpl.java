package org.openhmis.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.openhmis.dao.EthnicityDAO;
import org.openhmis.domain.CodeEthnicity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EthnicityDAOImpl extends BaseDAOImpl implements EthnicityDAO 
{
	private static final Logger log = LoggerFactory.getLogger(EthnicityDAOImpl.class);
	
	// default constructor
	public EthnicityDAOImpl()
	{
		
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> findEthnicityCodes()
	{
		log.debug("finding all Ethnicity codes");
		try
		{
			String queryString = "select e.ethnicityKey from Ethnicity e";
			Query queryObject = getSession().createQuery(queryString);
			return (List<Object[]>)queryObject.list();
		}
		catch (RuntimeException re)
		{
			log.error("find Ethnicity codes failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<CodeEthnicity> findEthnicities()
	{
		log.debug("finding all Ethnicities instances");
		try 
		{
			String queryString = "from CodeEthnicity";
			Query queryObject = getSession().createQuery(queryString);
			return (List<CodeEthnicity>)queryObject.list();
		}
		catch (RuntimeException re)
		{
			log.error("find Ethnicities failed", re);
			throw re;
		}
	}
}
