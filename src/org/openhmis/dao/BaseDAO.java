package org.openhmis.dao;

import org.hibernate.Session;

public interface BaseDAO 
{
	public Boolean save(Object object);
	public Boolean update(Object object);
	public Boolean delete(Object object);
	
	public Session getSession();
}
