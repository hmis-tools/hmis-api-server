package org.openhmis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpHealthInsurance;

public class TmpHealthInsuranceDAO extends BaseDAO {

	public TmpHealthInsuranceDAO() {
	}

	public TmpHealthInsurance getTmpHealthInsuranceById(Integer healthInsuranceId)  {
		String queryString = "select healthInsurance " + 
			"from TmpHealthInsurance as healthInsurance " + 
			"where healthInsurance.healthInsuranceId =:healthInsuranceId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("healthInsuranceId", healthInsuranceId);
		queryObject.setMaxResults(1);
		
		List<TmpHealthInsurance> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpHealthInsurance)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpHealthInsurance> getTmpHealthInsurances() {
		String queryString = "select healthInsurance " + 
				"from TmpHealthInsurance as healthInsurance";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		List<TmpHealthInsurance> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpHealthInsurance> getTmpHealthInsurances(Date updateDate) {
		String queryString = "select healthInsurance " + 
				"from TmpHealthInsurance as healthInsurance " + 
				"where healthInsurance.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpHealthInsurance> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpHealthInsurance> getTmpHealthInsurancesByEnrollmentId(Integer enrollmentId) {
		String queryString = "select healthInsurance " + 
				"from TmpHealthInsurance as healthInsurance " + 
				"where healthInsurance.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpHealthInsurance> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpHealthInsurance> getTmpHealthInsurancesByEnrollmentId(Integer enrollmentId, Date updateDate) {
		String queryString = "select healthInsurance " + 
				"from TmpHealthInsurance as healthInsurance " + 
				"where healthInsurance.enrollmentId =:enrollmentId " + 
				"  and healthInsurance.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpHealthInsurance> results = queryObject.list();
		session.close();
		return results;
	}
}