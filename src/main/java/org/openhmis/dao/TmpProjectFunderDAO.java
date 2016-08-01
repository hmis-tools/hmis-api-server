package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpProjectFunder;
import org.openhmis.dto.search.FunderSearchDTO;
import org.openhmis.util.DateParser;

public class TmpProjectFunderDAO extends BaseDAO {

	// default constructor
	public TmpProjectFunderDAO() { }

	public TmpProjectFunder getTmpProjectFunderById(Integer funderId)  {
		String queryString = "select projectFunder " + 
			"from TmpProjectFunder as projectFunder " + 
			"where projectFunder.funderId =:funderId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("funderId", funderId);
		queryObject.setMaxResults(1);
		
		List<TmpProjectFunder> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpProjectFunder)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProjectFunder> getTmpProjectFunders(FunderSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpProjectFunder.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
                if(searchDTO.getProjectId() != null) {
                    query.add(Restrictions.eq("projectId", Integer.parseInt(searchDTO.getProjectId())));
		}
		List<TmpProjectFunder> results = query.list();
		session.close();
		return results;
	}

}
