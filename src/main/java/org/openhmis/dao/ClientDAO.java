package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.openhmis.domain.PathClient;

public class ClientDAO extends BaseDAO {

	// default constructor
	public ClientDAO() { }

	public PathClient findClientByClientKey(Integer clientKey)  {
		try {
			String queryString = "select client " + 
				"from PathClient as client " + 
				"where client.clientKey =:clientKey";

			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter("clientKey", clientKey);
			queryObject.setMaxResults(1);
			return (PathClient)queryObject.list().get(0);
		}
		catch (RuntimeException re) {
			throw re;
		}
	}
}