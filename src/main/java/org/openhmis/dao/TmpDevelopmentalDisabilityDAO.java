package org.openhmis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpDevelopmentalDisability;

public class TmpDevelopmentalDisabilityDAO extends BaseDAO {

	public TmpDevelopmentalDisabilityDAO() {
	}

	public TmpDevelopmentalDisability getTmpDevelopmentalDisabilityById(Integer developmentalDisabilityId)  {
		String queryString = "select developmentalDisability " + 
			"from TmpDevelopmentalDisability as developmentalDisability " + 
			"where developmentalDisability.developmentalDisabilityId =:developmentalDisabilityId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("developmentalDisabilityId", developmentalDisabilityId);
		queryObject.setMaxResults(1);
		
		List<TmpDevelopmentalDisability> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpDevelopmentalDisability)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpDevelopmentalDisability> getTmpDevelopmentalDisabilitiesByEnrollmentId(Integer enrollmentId) {
		String queryString = "select developmentalDisability " + 
				"from TmpDevelopmentalDisability as developmentalDisability " + 
				"where developmentalDisability.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpDevelopmentalDisability> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpDevelopmentalDisability> getTmpDevelopmentalDisabilitiesByEnrollmentId(Integer enrollmentId, Date updateDate) {
		String queryString = "select developmentalDisability " + 
				"from TmpDevelopmentalDisability as developmentalDisability " + 
				"where developmentalDisability.enrollmentId =:enrollmentId " + 
				"  and developmentalDisability.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpDevelopmentalDisability> results = queryObject.list();
		session.close();
		return results;
	}
}