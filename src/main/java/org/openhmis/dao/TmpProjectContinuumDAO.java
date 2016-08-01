package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpProjectContinuum;
import org.openhmis.dto.search.CoCSearchDTO;
import org.openhmis.util.DateParser;

public class TmpProjectContinuumDAO extends BaseDAO {

	// default constructor
	public TmpProjectContinuumDAO() { }

	public TmpProjectContinuum getTmpProjectContinuumById(Integer projectCocId)  {
		String queryString = "select projectContinuum " + 
			"from TmpProjectContinuum as projectContinuum " + 
			"where projectContinuum.projectCocId =:projectCocId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectCocId", projectCocId);
		queryObject.setMaxResults(1);
		
		List<TmpProjectContinuum> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpProjectContinuum)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProjectContinuum> getTmpProjectContinuums(CoCSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpProjectContinuum.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
                if(searchDTO.getProjectId() != null) {
                    query.add(Restrictions.eq("projectId", Integer.parseInt(searchDTO.getProjectId())));
		}

		List<TmpProjectContinuum> results = query.list();
		session.close();
		return results;
	}
	
}
