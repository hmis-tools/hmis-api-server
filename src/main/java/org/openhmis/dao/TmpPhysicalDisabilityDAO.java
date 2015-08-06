package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpPhysicalDisability;

public class TmpPhysicalDisabilityDAO extends BaseDAO {

	public TmpPhysicalDisabilityDAO() {
	}

	public TmpPhysicalDisability getTmpPhysicalDisabilityByPhyiscalDisabilityId(Integer phyiscalDisabilityId)  {
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
	public List<TmpPhysicalDisability> getTmpPhysicalDisabilitysByEnrollmentId(Integer enrollmentId) {
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
}