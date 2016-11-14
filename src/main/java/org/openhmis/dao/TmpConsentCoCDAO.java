package org.openhmis.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpConsentCoC;
import org.openhmis.dto.search.ConsentCoCSearchDTO;

public class TmpConsentCoCDAO extends BaseDAO {

	// default constructor
	public TmpConsentCoCDAO() { }

	public TmpConsentCoC getTmpConsentCoCById(Integer consentCoCId)  {
		String queryString = "select consentCoC " + 
			"from TmpConsentCoC as consentCoC " + 
			"where consentcoC.consentCoCId =:consentCoCId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("consentCoCId", consentCoCId);
		queryObject.setMaxResults(1);
		
		List<TmpConsentCoC> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpConsentCoC)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpConsentCoC> getTmpConsentCoCs(ConsentCoCSearchDTO searchDTO) {

		Session session = getSession();
		Criteria query = session.createCriteria(TmpConsentCoC.class);

		List<TmpConsentCoC> results = query.list();
		session.close();
		return results;
	}
}
