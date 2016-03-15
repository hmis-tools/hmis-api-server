package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpOrganization;

public class TmpOrganizationDAO extends BaseDAO {

	// default constructor
	public TmpOrganizationDAO() { }

	public TmpOrganization getTmpOrganizationById(Integer organizationId)  {
		String queryString = "select organization " + 
			"from TmpOrganization as organization " + 
			"where organization.organizationId =:organizationId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("organizationId", organizationId);
		queryObject.setMaxResults(1);
		
		List<TmpOrganization> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpOrganization)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpOrganization> getTmpOrganizations() {
		String queryString = "select organization " + 
				"from TmpOrganization as organization";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		List<TmpOrganization> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpOrganization> getTmpOrganizationsByUpdateDate(Date updateDate) {
		String queryString = "select organization " + 
				"from TmpOrganization as organization " + 
				"where organization.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpOrganization> results = queryObject.list();
		session.close();
		return results;
	}
}