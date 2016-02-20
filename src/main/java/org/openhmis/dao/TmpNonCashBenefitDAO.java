package org.openhmis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpNonCashBenefit;

public class TmpNonCashBenefitDAO extends BaseDAO {

	public TmpNonCashBenefitDAO() {
	}

	public TmpNonCashBenefit getTmpNonCashBenefitById(Integer nonCashBenefitId)  {
		String queryString = "select nonCashBenefit " + 
			"from TmpNonCashBenefit as nonCashBenefit " + 
			"where nonCashBenefit.nonCashBenefitId =:nonCashBenefitId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("nonCashBenefitId", nonCashBenefitId);
		queryObject.setMaxResults(1);
		
		List<TmpNonCashBenefit> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpNonCashBenefit)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpNonCashBenefit> getTmpNonCashBenefits() {
		String queryString = "select nonCashBenefit " + 
				"from TmpNonCashBenefit as nonCashBenefit";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		List<TmpNonCashBenefit> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpNonCashBenefit> getTmpNonCashBenefits(Date updateDate) {
		String queryString = "select nonCashBenefit " + 
				"from TmpNonCashBenefit as nonCashBenefit " + 
				"where nonCashBenefit.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpNonCashBenefit> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpNonCashBenefit> getTmpNonCashBenefitsByEnrollmentId(Integer enrollmentId) {
		String queryString = "select nonCashBenefit " + 
				"from TmpNonCashBenefit as nonCashBenefit " + 
				"where nonCashBenefit.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpNonCashBenefit> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpNonCashBenefit> getTmpNonCashBenefitsByEnrollmentId(Integer enrollmentId, Date updateDate) {
		String queryString = "select nonCashBenefit " + 
				"from TmpNonCashBenefit as nonCashBenefit " + 
				"where nonCashBenefit.enrollmentId =:enrollmentId " + 
				"  and nonCashBenefit.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpNonCashBenefit> results = queryObject.list();
		session.close();
		return results;
	}
}