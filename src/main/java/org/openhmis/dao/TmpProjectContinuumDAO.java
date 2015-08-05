package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpProjectContinuum;

public class TmpProjectContinuumDAO extends BaseDAO {

	// default constructor
	public TmpProjectContinuumDAO() { }

	public TmpProjectContinuum getTmpProjectContinuumByProjectCoCId(Integer projectCoCId)  {
		String queryString = "select projectCoC " + 
			"from TmpProjectContinuum as projectCoC " + 
			"where projectCoC.projectCoCId =:projectCoCId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectCoCId", projectCoCId);
		queryObject.setMaxResults(1);
		
		List<TmpProjectContinuum> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpProjectContinuum)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProjectContinuum> getTmpProjectContinuumsByProjectId(Integer projectId) {
		String queryString = "select projectCoC " + 
				"from TmpProjectContinuum as projectCoC" + 
				"where projectCoC.projectId =:projectId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectId", projectId);
		List<TmpProjectContinuum> results = queryObject.list();
		session.close();
		return results;
	}
}