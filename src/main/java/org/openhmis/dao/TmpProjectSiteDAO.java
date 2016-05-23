package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpProjectSite;
import org.openhmis.dto.search.SiteSearchDTO;
import org.openhmis.util.DateParser;

public class TmpProjectSiteDAO extends BaseDAO {

	// default constructor
	public TmpProjectSiteDAO() { }

	public TmpProjectSite getTmpProjectSiteById(Integer siteId)  {
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
	public List<TmpProjectSite> getTmpProjectSites(SiteSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpProjectSite.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
		List<TmpProjectSite> results = query.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpProjectSite> getTmpProjectSites(Date updateDate) {
		String queryString = "select projectSite " + 
				"from TmpProjectSite as projectSite " + 
				"where projectSite.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpProjectSite> results = queryObject.list();
		session.close();
		return results;
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
	
	@SuppressWarnings("unchecked")
	public List<TmpProjectSite> getTmpProjectSitesByProjectCoCId(Integer projectCoCid, Date updateDate) {
		String queryString = "select projectSite " + 
				"from TmpProjectSite as projectSite " + 
				"where projectSite.projectCoCid =:projectCoCid " + 
				"  and projectSite.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("projectCoCid", projectCoCid);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpProjectSite> results = queryObject.list();
		session.close();
		return results;
	}
}
