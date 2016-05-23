package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpPhysicalDisability;
import org.openhmis.dto.search.PhysicalDisabilitySearchDTO;
import org.openhmis.util.DateParser;

public class TmpPhysicalDisabilityDAO extends BaseDAO {

	public TmpPhysicalDisabilityDAO() {
	}

	public TmpPhysicalDisability getTmpPhysicalDisabilityById(Integer phyiscalDisabilityId)  {
		String queryString = "select phyiscalDisability " + 
			"from TmpPhysicalDisability as phyiscalDisability " + 
			"where phyiscalDisability.phyiscalDisabilityId =:phyiscalDisabilityId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("phyiscalDisabilityId", phyiscalDisabilityId);
		queryObject.setMaxResults(1);
		
		List<TmpPhysicalDisability> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpPhysicalDisability)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpPhysicalDisability> getTmpPhysicalDisabilities(PhysicalDisabilitySearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpPhysicalDisability.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
		List<TmpPhysicalDisability> results = query.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpPhysicalDisability> getTmpPhysicalDisabilities(Date updateDate) {
		String queryString = "select phyiscalDisability " + 
				"from TmpPhysicalDisability as phyiscalDisability " + 
				"where phyiscalDisability.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpPhysicalDisability> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpPhysicalDisability> getTmpPhysicalDisabilitiesByEnrollmentId(Integer enrollmentId) {
		String queryString = "select phyiscalDisability " + 
				"from TmpPhysicalDisability as phyiscalDisability " + 
				"where phyiscalDisability.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpPhysicalDisability> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpPhysicalDisability> getTmpPhysicalDisabilitiesByEnrollmentId(Integer enrollmentId, Date updateDate) {
		String queryString = "select phyiscalDisability " + 
				"from TmpPhysicalDisability as phyiscalDisability " + 
				"where phyiscalDisability.enrollmentId =:enrollmentId " + 
				"  and phyiscalDisability.dateUpdated >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpPhysicalDisability> results = queryObject.list();
		session.close();
		return results;
	}
}
