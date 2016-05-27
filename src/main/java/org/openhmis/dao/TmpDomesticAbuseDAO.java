package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpDomesticAbuse;
import org.openhmis.dto.search.DomesticAbuseSearchDTO;
import org.openhmis.util.DateParser;

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
	public List<TmpDomesticAbuse> getTmpDomesticAbuses(DomesticAbuseSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpDomesticAbuse.class);
                if (searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
                }
                if(searchDTO.getEnrollmentId() != null) {
                    query.add(Restrictions.eq("enrollmentId", Integer.parseInt(searchDTO.getEnrollmentId())));
		}
		List<TmpDomesticAbuse> results = query.list();
		session.close();
		return results;
	}

	

}
