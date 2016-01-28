package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.PathClientRace;

public class PathClientRaceDAO extends BaseDAO {

	// default constructor
	public PathClientRaceDAO() { }

	@SuppressWarnings("unchecked")
	public List<PathClientRace> getPathRacesByClientKey(Integer clientKey)  {
		String queryString = "select clientRace " + 
			"from PathClientRace as clientRace " + 
			"where clientRace.clientKey =:clientKey";
		
		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("clientKey", clientKey);
		List<PathClientRace> results = queryObject.list();
		session.close();
		
		return results;

	}
}