package org.openhmis.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.PathClient;
import org.openhmis.dto.search.ClientSearchDTO;
import org.openhmis.util.DateParser;

public class TmpConsentFieldDAO extends BaseDAO {

	// default constructor
	public TmpConsentFieldDAO() { }

	public TmpConsentField getTmpConsentFieldById(Integer consentFieldId)  {
		String queryString = "select consentField " + 
			"from TmpConsentField as consentField " + 
			"where consentField.consentFieldId =:consentFieldId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("consentFieldId", consentFieldId);
		queryObject.setMaxResults(1);
		
		List<TmpConsentField> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpConsentField)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpConsentField> getTmpConsentFields(ConsentFieldSearchDTO searchDTO) {

		Session session = getSession();
		Criteria query = session.createCriteria(TmpConsentField.class);

		if(searchDTO.getConsentId() != null) {
			query.add(Restrictions.like("consentId", searchDTO.getConsentId()));
		}

		List<TmpConsentField> results = query.list();
		session.close();
		return results;
	}
}