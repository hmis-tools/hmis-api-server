package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpProject;
import org.openhmis.dto.search.ProjectSearchDTO;
import org.openhmis.util.DateParser;

public class TmpProjectDAO extends BaseDAO {

	// default constructor
	public TmpProjectDAO() { }

	public TmpProject getTmpProjectById(Integer projectId)  {
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
	public List<TmpProject> getTmpProjects(ProjectSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpProject.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
		List<TmpProject> results = query.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProject> getTmpProjectsByUpdateDate(Date updateDate) {
		String queryString = "select project " + 
				"from TmpProject as project " + 
				"where project.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpProject> results = queryObject.list();
		session.close();
		return results;
	}
}
