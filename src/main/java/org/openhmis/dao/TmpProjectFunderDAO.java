package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpProjectFunder;

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
	public List<TmpProjectFunder> getTmpProjectFundersByProjectId(Integer projectId) {
		String queryString = "select projectFunder " + 
				"from TmpProjectFunder as projectFunder " + 
				"where projectFunder.projectId =:projectId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectId", projectId);
		List<TmpProjectFunder> results = queryObject.list();
		session.close();
		return results;
	}
}