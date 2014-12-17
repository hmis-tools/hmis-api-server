package org.openhmis.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.openhmis.dao.BaseDAO;
import org.openhmis.util.HibernateSessionFactory;


public class BaseDAOImpl implements BaseDAO 
{
	private static final Logger log = Logger.getLogger(BaseDAOImpl.class);
	@Override
	public Boolean save(Object object) 
	{
		log.debug("Saving object");
		try
		{
			Session session = getSession();
			session.save(object);
			session.flush();
		}
		catch (RuntimeException re) 
		{
			log.error("save failed", re);
			throw re;
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean update(Object object) 
	{
		Boolean isUpdate = Boolean.FALSE;
		log.debug("Updating object");
		try
		{
			Object updatedObject = getSession().merge(object);
			getSession().flush();
			if (updatedObject != null)
			{
				isUpdate = Boolean.TRUE;
			}
		}
		catch (RuntimeException re) 
		{
			log.error("update failed", re);
			throw re;
		}
		return isUpdate;
	}

	@Override
	public Boolean delete(Object object) 
	{
		Boolean isDelete = Boolean.FALSE;
		log.debug("Deleting object");
		try
		{
			getSession().delete(object);
			isDelete = Boolean.TRUE;
		}
		catch(RuntimeException re)
		{
			log.error("delete failed",re);
			throw re;
		}
		return isDelete;
	}

	@Override
	public Session getSession() 
	{
		return HibernateSessionFactory.getSession();
	}	
}
