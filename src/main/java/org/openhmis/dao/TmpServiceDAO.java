package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpService;

public class TmpServiceDAO extends BaseDAO {

	public TmpServiceDAO() {
	}

	public TmpService getTmpServiceById(Integer serviceId)  {
		String queryString = "select service " + 
			"from TmpService as service " + 
			"where service.serviceId =:serviceId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("serviceId", serviceId);
		queryObject.setMaxResults(1);
		
		List<TmpService> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpService)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpService> getTmpServicesByEnrollmentId(Integer enrollmentId) {
		String queryString = "select service " + 
				"from TmpService as service " + 
				"where service.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpService> results = queryObject.list();
		session.close();
		return results;
	}
}