package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpHealthInsurance;
import org.openhmis.dto.search.HealthInsuranceSearchDTO;
import org.openhmis.util.DateParser;

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
	public List<TmpHealthInsurance> getTmpHealthInsurances(HealthInsuranceSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query = session.createCriteria(TmpHealthInsurance.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("updateDate", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
		List<TmpHealthInsurance> results = query.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpHealthInsurance> getTmpHealthInsurances(Date updateDate) {
		String queryString = "select healthInsurance " + 
				"from TmpHealthInsurance as healthInsurance " + 
				"where healthInsurance.dateUpdated >= :updatedSince";

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
				"  and healthInsurance.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpHealthInsurance> results = queryObject.list();
		session.close();
		return results;
	}
}
