/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

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
			Object updatedObject = getSession().merge(object);
			getSession().flush();
			if (updatedObject != null) {
				return Boolean.TRUE;
			}
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