package org.openhmis.dao;

import org.hibernate.Query;
import org.openhmis.domain.PathClientVeteranInfo;

public class ClientVeteranInfoDAO extends BaseDAO {

	// default constructor
	public ClientVeteranInfoDAO() { }

	public PathClientVeteranInfo findVeteranInfoByClientKey(Integer clientKey)  {
		try {
			String queryString = "select clientVeteranInfo " + 
				"from PathClientVeteranInfo as clientVeteranInfo " + 
				"where clientVeteranInfo.clientKey =:clientKey";

			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter("clientKey", clientKey);
			queryObject.setMaxResults(1);
			
			return (PathClientVeteranInfo)queryObject.list().get(0);
		}
		catch (RuntimeException re) {
			throw re;
		}
	}
}