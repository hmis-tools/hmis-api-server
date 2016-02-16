package org.openhmis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpEnrollment;

public class TmpEnrollmentDAO extends BaseDAO {

	public TmpEnrollmentDAO() {
	}

	public TmpEnrollment getTmpEnrollmentById(Integer enrollmentId)  {
		String queryString = "select enrollment " + 
			"from TmpEnrollment as enrollment " + 
			"where enrollment.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setMaxResults(1);
		
		List<TmpEnrollment> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpEnrollment)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpEnrollment> getTmpEnrollments() {
		String queryString = "select enrollment " + 
				"from TmpEnrollment as enrollment";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		List<TmpEnrollment> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpEnrollment> getTmpEnrollmentsByUpdateDate(Date updateDate) {
		String queryString = "select enrollment " + 
				"from TmpEnrollment as enrollment " + 
				"  and enrollment.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpEnrollment> results = queryObject.list();
		session.close();
		return results;
	}
}