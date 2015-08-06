package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpSubstanceAbuse;

public class TmpSubstanceAbuseDAO extends BaseDAO {

	public TmpSubstanceAbuseDAO() {
	}

	public TmpSubstanceAbuse getTmpSubstanceAbuseBySubstanceAbuseId(Integer substanceAbuseId)  {
		String queryString = "select substanceAbuse " + 
			"from TmpSubstanceAbuse as substanceAbuse " + 
			"where substanceAbuse.substanceAbuseId =:substanceAbuseId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("substanceAbuseId", substanceAbuseId);
		queryObject.setMaxResults(1);
		
		List<TmpSubstanceAbuse> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpSubstanceAbuse)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpSubstanceAbuse> getTmpSubstanceAbusesByEnrollmentId(Integer enrollmentId) {
		String queryString = "select substanceAbuse " + 
				"from TmpSubstanceAbuse as substanceAbuse " + 
				"where substanceAbuse.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpSubstanceAbuse> results = queryObject.list();
		session.close();
		return results;
	}
}