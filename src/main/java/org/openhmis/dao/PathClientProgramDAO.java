package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.PathClientProgram;

public class PathClientProgramDAO extends BaseDAO {

	// default constructor
	public PathClientProgramDAO() { }

	public PathClientProgram getPathClientProgramByProgramKey(Integer programKey)  {
		String queryString = "select program " + 
			"from PathClientProgram as program " + 
			"where program.programKey =:programKey";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("programKey", programKey);
		queryObject.setMaxResults(1);
		
		List<PathClientProgram> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (PathClientProgram)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<PathClientProgram> getPathClientPrograms() {
		String queryString = "select program " + 
				"from PathClientProgram as program";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		List<PathClientProgram> results = queryObject.list();
		session.close();
		return results;
	}
}