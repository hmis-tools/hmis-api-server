package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpFinancialAssistance;
import org.openhmis.dto.search.FinancialAssistanceSearchDTO;
import org.openhmis.util.DateParser;

public class TmpFinancialAssistanceDAO extends BaseDAO {

	public TmpFinancialAssistanceDAO() {
	}

	public TmpFinancialAssistance getTmpFinancialAssistanceById(Integer financialAssistanceId)  {
		String queryString = "select financialAssistance " + 
			"from TmpFinancialAssistance as financialAssistance " + 
			"where financialAssistance.financialAssistanceId =:financialAssistanceId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("financialAssistanceId", financialAssistanceId);
		queryObject.setMaxResults(1);
		
		List<TmpFinancialAssistance> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpFinancialAssistance)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpFinancialAssistance> getTmpFinancialAssistances(FinancialAssistanceSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query = session.createCriteria(TmpFinancialAssistance.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
                if(searchDTO.getEnrollmentId() != null) {
                    query.add(Restrictions.eq("enrollmentId", Integer.parseInt(searchDTO.getEnrollmentId())));
		}
		List<TmpFinancialAssistance> results = query.list();
		session.close();
		return results;
	}
	

}
