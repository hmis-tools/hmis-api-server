package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpProject;

public class TmpProjectDAO extends BaseDAO {

	// default constructor
	public TmpProjectDAO() { }

	public TmpProject getTmpProjectByProjectId(Integer projectId)  {
		String queryString = "select project " + 
			"from TmpProject as project " + 
			"where project.projectId =:projectId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectId", projectId);
		queryObject.setMaxResults(1);
		
		List<TmpProject> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpProject)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProject> getTmpProjects() {
		String queryString = "select project " + 
				"from TmpProject as project";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		List<TmpProject> results = queryObject.list();
		session.close();
		return results;
	}
}