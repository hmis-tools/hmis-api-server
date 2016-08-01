package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpChronicHealthCondition;
import org.openhmis.dto.search.ChronicHealthConditionSearchDTO;
import org.openhmis.util.DateParser;

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
        public List<TmpChronicHealthCondition> getTmpChronicHealthConditions(ChronicHealthConditionSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query = session.createCriteria(TmpChronicHealthCondition.class);

                if (searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
                }
                if (searchDTO.getEnrollmentId() != null) {
                    query.add(Restrictions.eq("enrollmentId", Integer.parseInt(searchDTO.getEnrollmentId())));
                }
                List<TmpChronicHealthCondition> results = query.list();
		session.close();
		return results;
	}
	

	
}
