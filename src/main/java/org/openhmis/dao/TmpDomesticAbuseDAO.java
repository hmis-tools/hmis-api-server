package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpDomesticAbuse;

public class TmpDomesticAbuseDAO extends BaseDAO {

	public TmpDomesticAbuseDAO() {
	}

	public TmpDomesticAbuse getTmpDomesticAbuseById(Integer domesticAbuseId)  {
		String queryString = "select domesticAbuse " + 
			"from TmpDomesticAbuse as domesticAbuse " + 
			"where domesticAbuse.domesticAbuseId =:domesticAbuseId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("domesticAbuseId", domesticAbuseId);
		queryObject.setMaxResults(1);
		
		List<TmpDomesticAbuse> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpDomesticAbuse)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpDomesticAbuse> getTmpDomesticAbuses() {
		String queryString = "select domesticAbuse " + 
				"from TmpDomesticAbuse as domesticAbuse";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		List<TmpDomesticAbuse> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpDomesticAbuse> getTmpDomesticAbuses(Date updateDate) {
		String queryString = "select domesticAbuse " + 
				"from TmpDomesticAbuse as domesticAbuse " + 
				"where domesticAbuse.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpDomesticAbuse> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpDomesticAbuse> getTmpDomesticAbusesByEnrollmentId(Integer enrollmentId) {
		String queryString = "select domesticAbuse " + 
				"from TmpDomesticAbuse as domesticAbuse " + 
				"where domesticAbuse.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpDomesticAbuse> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpDomesticAbuse> getTmpDomesticAbusesByEnrollmentId(Integer enrollmentId, Date updateDate) {
		String queryString = "select domesticAbuse " + 
				"from TmpDomesticAbuse as domesticAbuse " + 
				"where domesticAbuse.enrollmentId =:enrollmentId " + 
				"  and domesticAbuse.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpDomesticAbuse> results = queryObject.list();
		session.close();
		return results;
	}
}