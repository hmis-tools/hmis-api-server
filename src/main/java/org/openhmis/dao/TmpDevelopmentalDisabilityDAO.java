package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpDevelopmentalDisability;
import org.openhmis.dto.search.DevelopmentalDisabilitySearchDTO;
import org.openhmis.util.DateParser;

public class TmpDevelopmentalDisabilityDAO extends BaseDAO {

	public TmpDevelopmentalDisabilityDAO() {
	}

	public TmpDevelopmentalDisability getTmpDevelopmentalDisabilityById(Integer developmentalDisabilityId)  {
		String queryString = "select developmentalDisability " + 
			"from TmpDevelopmentalDisability as developmentalDisability " + 
			"where developmentalDisability.developmentalDisabilityId =:developmentalDisabilityId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("developmentalDisabilityId", developmentalDisabilityId);
		queryObject.setMaxResults(1);
		
		List<TmpDevelopmentalDisability> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpDevelopmentalDisability)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpDevelopmentalDisability> getTmpDevelopmentalDisabilities(DevelopmentalDisabilitySearchDTO searchDTO) {

		Session session = getSession();
                Criteria query = session.createCriteria(TmpDevelopmentalDisability.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
                if(searchDTO.getEnrollmentId() != null) {
                    query.add(Restrictions.eq("enrollmentId", Integer.parseInt(searchDTO.getEnrollmentId())));
		}
		List<TmpDevelopmentalDisability> results = query.list();
		session.close();
		return results;
	}
	

}
