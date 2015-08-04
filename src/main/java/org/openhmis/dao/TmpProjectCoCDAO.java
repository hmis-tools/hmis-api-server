package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpProjectCoC;

public class TmpProjectCoCDAO extends BaseDAO {

	// default constructor
	public TmpProjectCoCDAO() { }

	public TmpProjectCoC getTmpProjectCoCByProjectCoCId(Integer projectCoCId)  {
		String queryString = "select projectCoC " + 
			"from TmpProjectCoC as projectCoC " + 
			"where projectCoC.projectCoCId =:projectCoCId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectCoCId", projectCoCId);
		queryObject.setMaxResults(1);
		
		List<TmpProjectCoC> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpProjectCoC)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProjectCoC> getTmpProjectCoCsByProjectId(Integer projectId) {
		String queryString = "select projectCoC " + 
				"from TmpProjectCoC as projectCoC" + 
				"where projectCoC.projectId =:projectId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectId", projectId);
		List<TmpProjectCoC> results = queryObject.list();
		session.close();
		return results;
	}
}