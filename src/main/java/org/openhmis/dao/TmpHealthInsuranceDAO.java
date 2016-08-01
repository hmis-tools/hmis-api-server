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
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
                if (searchDTO.getEnrollmentId() != null) {
                    query.add(Restrictions.eq("enrollmentId", Integer.parseInt(searchDTO.getEnrollmentId())));
                }
		List<TmpHealthInsurance> results = query.list();
		session.close();
		return results;
	}
	
}
