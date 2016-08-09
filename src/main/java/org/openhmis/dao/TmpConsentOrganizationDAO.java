package org.openhmis.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.PathClient;
import org.openhmis.domain.TmpConsentOrganization;
import org.openhmis.dto.search.ClientSearchDTO;
import org.openhmis.dto.search.ConsentOrganizationSearchDTO;
import org.openhmis.util.DateParser;

public class TmpConsentOrganizationDAO extends BaseDAO {

	// default constructor
	public TmpConsentOrganizationDAO() { }

	public TmpConsentOrganization getTmpConsentOrganizationById(Integer consentOrganizationId)  {
		String queryString = "select consentOrganization " + 
			"from TmpConsentOrganization as consentOrganization " + 
			"where consentOrganization.consentOrganizationId =:consentOrganizationId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("consentOrganizationId", consentOrganizationId);
		queryObject.setMaxResults(1);
		
		List<TmpConsentOrganization> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpConsentOrganization)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpConsentOrganization> getTmpConsentOrganizations(ConsentOrganizationSearchDTO searchDTO) {

		Session session = getSession();
		Criteria query = session.createCriteria(TmpConsentOrganization.class);

		if(searchDTO.getConsentId() != null) {
			query.add(Restrictions.like("consentId", searchDTO.getConsentId()));
		}

		List<TmpConsentOrganization> results = query.list();
		session.close();
		return results;
	}
}