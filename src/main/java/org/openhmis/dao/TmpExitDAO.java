package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpEnrollment;
import org.openhmis.domain.TmpExit;
import org.openhmis.dto.search.ExitSearchDTO;
import org.openhmis.util.DateParser;

public class TmpExitDAO extends BaseDAO {

	public TmpExitDAO() {
	}

	public TmpExit getTmpExitById(Integer exitId)  {
		String queryString = "select exit " + 
			"from TmpExit as exit " + 
			"where exit.exitId =:exitId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("exitId", exitId);
		queryObject.setMaxResults(1);
		
		List<TmpExit> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpExit)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public TmpExit getTmpExitByEnrollmentId(Integer enrollmentId) {
		String queryString = "select exit " + 
				"from TmpExit as exit " + 
				"where exit.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setMaxResults(1);
		
		List<TmpExit> results = queryObject.list();
		session.close();

		if(results.size() > 0)
			return (TmpExit)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpExit> getTmpExits(ExitSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query = session.createCriteria(TmpExit.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
		List<TmpExit> results = query.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpExit> getTmpExits(Date updateDate) {
		String queryString = "select exit " + 
				"from TmpExit as exit " + 
				"where exit.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpExit> results = queryObject.list();
		session.close();
		return results;
	}
}
