package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.PathClient;

public class ClientDAO extends BaseDAO {

	// default constructor
	public ClientDAO() { }

	public PathClient getClientByClientKey(Integer clientKey)  {
		String queryString = "select client " + 
			"from PathClient as client " + 
			"where client.clientKey =:clientKey";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("clientKey", clientKey);
		queryObject.setMaxResults(1);
		
		List<PathClient> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (PathClient)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<PathClient> getClients() {
		String queryString = "select client " + 
				"from PathClient as client";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		List<PathClient> results = queryObject.list();
		session.close();
		return results;
	}
}