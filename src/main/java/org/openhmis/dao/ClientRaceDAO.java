package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.openhmis.domain.PathClientRace;

public class ClientRaceDAO extends BaseDAO {

	// default constructor
	public ClientRaceDAO() { }

	@SuppressWarnings("unchecked")
	public List<PathClientRace> getRacesByClientKey(Integer clientKey)  {
		try {
			String queryString = "select clientRace " + 
				"from PathClientRace as clientRace " + 
				"where clientRace.clientKey =:clientKey";

			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter("clientKey", clientKey);
			
			return queryObject.list();
		}
		catch (RuntimeException re) {
			throw re;
		}
	}
}