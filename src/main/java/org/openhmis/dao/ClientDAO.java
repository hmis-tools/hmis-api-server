package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.openhmis.domain.PathClient;
import org.openhmis.domain.PathClientVeteranInfo;

public class ClientDAO extends BaseDAO {

	// default constructor
	public ClientDAO() { }

	public PathClient findClientByClientKey(Integer clientKey)  {
		String queryString = "select client " + 
			"from PathClient as client " + 
			"where client.clientKey =:clientKey";

		Query queryObject = getSession().createQuery(queryString);
		queryObject.setParameter("clientKey", clientKey);
		queryObject.setMaxResults(1);
		
		List<PathClient> results = queryObject.list();
		if(results.size() > 0)
			return (PathClient)queryObject.list().get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<PathClient> getClients() {
		String queryString = "select client " + 
				"from PathClient as client";

		Query queryObject = getSession().createQuery(queryString);
		return (List<PathClient>)queryObject.list();
	}
}