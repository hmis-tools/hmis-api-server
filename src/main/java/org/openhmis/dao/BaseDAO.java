package org.openhmis.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openhmis.util.HibernateSessionFactory;


public class BaseDAO {
	
	public Boolean save(Object object) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(object);
		tx.commit();
		session.close();
		return Boolean.TRUE;
	}

	public Boolean update(Object object) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.merge(object);
		tx.commit();
		session.close();
		return Boolean.TRUE;
	}

	public Boolean delete(Object object) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.delete(object);
		tx.commit();
		session.close();
		return Boolean.TRUE;
	}

	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}
}