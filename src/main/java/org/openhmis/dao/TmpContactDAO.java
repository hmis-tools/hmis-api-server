package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpContact;

public class TmpContactDAO extends BaseDAO {

	public TmpContactDAO() {
	}

	public TmpContact getTmpContactByContactId(Integer contactId)  {
		String queryString = "select contact " + 
			"from Contact as contact " + 
			"where contact.contactId =:contactId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("contactId", contactId);
		queryObject.setMaxResults(1);
		
		List<TmpContact> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpContact)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpContact> getTmpContactsByEnrollmentId(Integer enrollmentId) {
		String queryString = "select contact " + 
				"from TmpContact as contact " + 
				"where contact.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpContact> results = queryObject.list();
		session.close();
		return results;
	}
}