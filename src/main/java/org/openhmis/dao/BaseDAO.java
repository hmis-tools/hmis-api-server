package org.openhmis.dao;

import org.hibernate.Session;
import org.openhmis.util.HibernateSessionFactory;


public class BaseDAO {
	
	public Boolean save(Object object) {
		try {
			Session session = getSession();
			session.save(object);
			session.flush();
		}
		catch (RuntimeException re) {
			throw re;
		}
		return Boolean.TRUE;
	}

	public Boolean update(Object object) {
		try {
			Session session = getSession();
			session.saveOrUpdate(object);
			session.flush();
		}
		catch (RuntimeException re) 
		{
			throw re;
		}
		return Boolean.FALSE;
	}

	public Boolean delete(Object object) {
		try {
			getSession().delete(object);
			return Boolean.TRUE;
		}
		catch(RuntimeException re) {
			throw re;
		}
	}

	public Session getSession() 
	{
		return HibernateSessionFactory.getSession();
	}	
}