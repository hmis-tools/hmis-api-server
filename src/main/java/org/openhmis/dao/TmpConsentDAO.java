package org.openhmis.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpConsent;
import org.openhmis.dto.search.ConsentSearchDTO;

public class TmpConsentDAO extends BaseDAO {

	// default constructor
	public TmpConsentDAO() { }

	@SuppressWarnings("unchecked")
	public TmpConsent getTmpConsentById(Integer consentId)  {
		String queryString = "select consent " + 
			"from TmpConsent as consent " + 
			"where consent.consentId =:consentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("consentId", consentId);
		queryObject.setMaxResults(1);
		
		List<TmpConsent> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpConsent)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpConsent> getTmpConsents(ConsentSearchDTO searchDTO) {

		Session session = getSession();
		Criteria query = session.createCriteria(TmpConsent.class);

		if(searchDTO.getSubmitterId() != null) {
			query.add(Restrictions.like("submitterId", searchDTO.getSubmitterId()));
		}

		List<TmpConsent> results = query.list();
		session.close();
		return results;
	}
}