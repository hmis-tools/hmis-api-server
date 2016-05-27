package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpNonCashBenefit;
import org.openhmis.dto.search.NonCashBenefitSearchDTO;
import org.openhmis.util.DateParser;

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
	public List<TmpNonCashBenefit> getTmpNonCashBenefits(NonCashBenefitSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query = session.createCriteria(TmpNonCashBenefit.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
                if(searchDTO.getEnrollmentId() != null) {
                    query.add(Restrictions.eq("enrollmentId", Integer.parseInt(searchDTO.getEnrollmentId())));
		}
		List<TmpNonCashBenefit> results = query.list();
		session.close();
		return results;
	}

}
