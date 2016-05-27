package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpHivAidsStatus;
import org.openhmis.dto.search.HivAidsStatusSearchDTO;
import org.openhmis.util.DateParser;

public class TmpHivAidsStatusDAO extends BaseDAO {

	public TmpHivAidsStatusDAO() {
	}

	public TmpHivAidsStatus getTmpHivAidsStatusById(Integer hivAidsStatusId)  {
		String queryString = "select hivAidsStatus " + 
			"from TmpHivAidsStatus as hivAidsStatus " + 
			"where hivAidsStatus.hivAidsStatusId =:hivAidsStatusId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("hivAidsStatusId", hivAidsStatusId);
		queryObject.setMaxResults(1);
		
		List<TmpHivAidsStatus> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpHivAidsStatus)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpHivAidsStatus> getTmpHivAidsStatuses(HivAidsStatusSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpHivAidsStatus.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
                if(searchDTO.getEnrollmentId() != null) {
                    query.add(Restrictions.eq("enrollmentId", Integer.parseInt(searchDTO.getEnrollmentId())));
		}
		List<TmpHivAidsStatus> results = query.list();
		session.close();
		return results;
	}
	
}
