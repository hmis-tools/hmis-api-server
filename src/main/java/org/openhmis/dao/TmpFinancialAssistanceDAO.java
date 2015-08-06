package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpFinancialAssistance;

public class TmpFinancialAssistanceDAO extends BaseDAO {

	public TmpFinancialAssistanceDAO() {
	}

	public TmpFinancialAssistance getTmpFinancialAssistanceById(Integer financialAssistanceId)  {
		String queryString = "select financialAssistance " + 
			"from TmpFinancialAssistance as financialAssistance " + 
			"where financialAssistance.financialAssistanceId =:financialAssistanceId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("financialAssistanceId", financialAssistanceId);
		queryObject.setMaxResults(1);
		
		List<TmpFinancialAssistance> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpFinancialAssistance)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpFinancialAssistance> getTmpFinancialAssistancesByEnrollmentId(Integer enrollmentId) {
		String queryString = "select financialAssistance " + 
				"from TmpFinancialAssistance as financialAssistance " + 
				"where financialAssistance.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpFinancialAssistance> results = queryObject.list();
		session.close();
		return results;
	}
}