package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpSubstanceAbuse;
import org.openhmis.dto.search.SubstanceAbuseSearchDTO;
import org.openhmis.util.DateParser;

public class TmpSubstanceAbuseDAO extends BaseDAO {

	public TmpSubstanceAbuseDAO() {
	}

	public TmpSubstanceAbuse getTmpSubstanceAbuseById(Integer substanceAbuseId)  {
		String queryString = "select substanceAbuse " + 
			"from TmpSubstanceAbuse as substanceAbuse " + 
			"where substanceAbuse.substanceAbuseId =:substanceAbuseId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("substanceAbuseId", substanceAbuseId);
		queryObject.setMaxResults(1);
		
		List<TmpSubstanceAbuse> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpSubstanceAbuse)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpSubstanceAbuse> getTmpSubstanceAbuses(SubstanceAbuseSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpSubstanceAbuse.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
                if(searchDTO.getEnrollmentId() != null) {
                    query.add(Restrictions.eq("enrollmentId", Integer.parseInt(searchDTO.getEnrollmentId())));
		}
		List<TmpSubstanceAbuse> results = query.list();
		session.close();
		return results;
	}

}
