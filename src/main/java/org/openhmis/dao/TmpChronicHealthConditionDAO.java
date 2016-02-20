package org.openhmis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpChronicHealthCondition;

public class TmpChronicHealthConditionDAO extends BaseDAO {

	public TmpChronicHealthConditionDAO() {
	}

	public TmpChronicHealthCondition getTmpChronicHealthConditionById(Integer chronicHealthConditionId)  {
		String queryString = "select chronicHealthCondition " + 
			"from TmpChronicHealthCondition as chronicHealthCondition " + 
			"where chronicHealthCondition.chronicHealthConditionId =:chronicHealthConditionId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("chronicHealthConditionId", chronicHealthConditionId);
		queryObject.setMaxResults(1);
		
		List<TmpChronicHealthCondition> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpChronicHealthCondition)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpChronicHealthCondition> getTmpChronicHealthConditions() {
		String queryString = "select chronicHealthCondition " + 
				"from TmpChronicHealthCondition as chronicHealthCondition";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		List<TmpChronicHealthCondition> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpChronicHealthCondition> getTmpChronicHealthConditions(Date updateDate) {
		String queryString = "select chronicHealthCondition " + 
				"from TmpChronicHealthCondition as chronicHealthCondition " + 
				"where chronicHealthCondition.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpChronicHealthCondition> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpChronicHealthCondition> getTmpChronicHealthConditionsByEnrollmentId(Integer enrollmentId) {
		String queryString = "select chronicHealthCondition " + 
				"from TmpChronicHealthCondition as chronicHealthCondition " + 
				"where chronicHealthCondition.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpChronicHealthCondition> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpChronicHealthCondition> getTmpChronicHealthConditionsByEnrollmentId(Integer enrollmentId, Date updateDate) {
		String queryString = "select chronicHealthCondition " + 
				"from TmpChronicHealthCondition as chronicHealthCondition " + 
				"where chronicHealthCondition.enrollmentId =:enrollmentId " +
				"  and chronicHealthCondition.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpChronicHealthCondition> results = queryObject.list();
		session.close();
		return results;
	}
}