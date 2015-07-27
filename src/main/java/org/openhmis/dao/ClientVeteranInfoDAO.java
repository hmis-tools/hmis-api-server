package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.openhmis.domain.PathClientVeteranInfo;

public class ClientVeteranInfoDAO extends BaseDAO {

	// default constructor
	public ClientVeteranInfoDAO() { }

	public PathClientVeteranInfo getVeteranInfoByClientKey(Integer clientKey)  {
		try {
			String queryString = "select clientVeteranInfo " + 
				"from PathClientVeteranInfo as clientVeteranInfo " + 
				"where clientVeteranInfo.clientKey =:clientKey";

			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter("clientKey", clientKey);
			queryObject.setMaxResults(1);
			
			List<PathClientVeteranInfo> results = queryObject.list();
			if(results.size() > 0)
				return results.get(0);
			else
				return null;
		}
		catch (RuntimeException re) {
			throw re;
		}
	}
}