package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.PathClientVeteranInfo;

public class ClientVeteranInfoDAO extends BaseDAO {

	// default constructor
	public ClientVeteranInfoDAO() { }

	public PathClientVeteranInfo getVeteranInfoByClientKey(Integer clientKey)  {
		String queryString = "select clientVeteranInfo " + 
			"from PathClientVeteranInfo as clientVeteranInfo " + 
			"where clientVeteranInfo.clientKey =:clientKey";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("clientKey", clientKey);
		queryObject.setMaxResults(1);
		
		List<PathClientVeteranInfo> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return results.get(0);
		else
			return null;
	}
}