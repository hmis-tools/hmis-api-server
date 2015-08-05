package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpProjectSite;

public class TmpProjectSiteDAO extends BaseDAO {

	// default constructor
	public TmpProjectSiteDAO() { }

	public TmpProjectSite getTmpProjectSiteBySiteId(Integer siteId)  {
		String queryString = "select projectSite " + 
			"from TmpProjectSite as projectSite " + 
			"where projectSite.siteId =:siteId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("siteId", siteId);
		queryObject.setMaxResults(1);
		
		List<TmpProjectSite> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpProjectSite)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProjectSite> getTmpProjectSitesByProjectCoCId(Integer projectCoCid) {
		String queryString = "select projectSite " + 
				"from TmpProjectSite as projectSite " + 
				"where projectSite.projectCoCid =:projectCoCid";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectCoCid", projectCoCid);
		List<TmpProjectSite> results = queryObject.list();
		session.close();
		return results;
	}
}