package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpContact;
import org.openhmis.dto.search.ContactSearchDTO;
import org.openhmis.util.DateParser;

public class TmpContactDAO extends BaseDAO {

	public TmpContactDAO() {
	}

	public TmpContact getTmpContactById(Integer contactId)  {
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
	public List<TmpContact> getTmpContacts(ContactSearchDTO searchDTO) {

		Session session = getSession();
		Criteria query = session.createCriteria(TmpContact.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
                if(searchDTO.getEnrollmentId() != null) {
                    query.add(Restrictions.eq("enrollmentId", Integer.parseInt(searchDTO.getEnrollmentId())));
		}
		List<TmpContact> results = query.list();
		session.close();
		return results;
	}

}
