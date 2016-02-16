package org.openhmis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpMentalHealthProblem;

public class TmpMentalHealthProblemDAO extends BaseDAO {

	public TmpMentalHealthProblemDAO() {
	}

	public TmpMentalHealthProblem getTmpMentalHealthProblemById(Integer mentalHealthProblemId)  {
		String queryString = "select mentalHealthProblem " + 
			"from TmpMentalHealthProblem as mentalHealthProblem " + 
			"where mentalHealthProblem.mentalHealthProblemId =:mentalHealthProblemId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("mentalHealthProblemId", mentalHealthProblemId);
		queryObject.setMaxResults(1);
		
		List<TmpMentalHealthProblem> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpMentalHealthProblem)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpMentalHealthProblem> getTmpMentalHealthProblemsByEnrollmentId(Integer enrollmentId) {
		String queryString = "select mentalHealthProblem " + 
				"from TmpMentalHealthProblem as mentalHealthProblem " + 
				"where mentalHealthProblem.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpMentalHealthProblem> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpMentalHealthProblem> getTmpMentalHealthProblemsByEnrollmentId(Integer enrollmentId, Date updateDate) {
		String queryString = "select mentalHealthProblem " + 
				"from TmpMentalHealthProblem as mentalHealthProblem " + 
				"where mentalHealthProblem.enrollmentId =:enrollmentId " + 
				"  and mentalHealthProblem.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpMentalHealthProblem> results = queryObject.list();
		session.close();
		return results;
	}
}