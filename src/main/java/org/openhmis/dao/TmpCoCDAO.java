package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpCoC;
import org.openhmis.domain.TmpOrganization;
import org.openhmis.dto.search.CoCSearchDTO;
import org.openhmis.dto.search.OrganizationSearchDTO;
import org.openhmis.util.DateParser;

public class TmpCoCDAO extends BaseDAO {

	// default constructor
	public TmpCoCDAO() { }

	public TmpCoC getTmpCoCById(Integer coCId)  {
		String queryString = "select coC " + 
			"from TmpCoC as coC " + 
			"where coC.coCId =:coCId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("coCId", coCId);
		queryObject.setMaxResults(1);
		
		List<TmpCoC> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpCoC)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpOrganization> getTmpCoCs(CoCSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpOrganization.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
		List<TmpOrganization> results = query.list();
		session.close();
		return results;
	}
	
	public TmpCoC getReference(Integer coCId) {
		Session session = getSession();
		return (TmpCoC)session.load(TmpCoC.class, coCId);
	}
}