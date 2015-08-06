package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpIncomeSource;

public class TmpIncomeSourceDAO extends BaseDAO {

	public TmpIncomeSourceDAO() {
	}

	public TmpIncomeSource getTmpIncomeSourceById(Integer incomeSourceId)  {
		String queryString = "select incomeSource " + 
			"from TmpIncomeSource as incomeSource " + 
			"where incomeSource.incomeSourceId =:incomeSourceId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("incomeSourceId", incomeSourceId);
		queryObject.setMaxResults(1);
		
		List<TmpIncomeSource> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpIncomeSource)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpIncomeSource> getTmpIncomeSourcesByEnrollmentId(Integer enrollmentId) {
		String queryString = "select incomeSource " + 
				"from TmpIncomeSource as incomeSource " + 
				"where incomeSource.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpIncomeSource> results = queryObject.list();
		session.close();
		return results;
	}
}