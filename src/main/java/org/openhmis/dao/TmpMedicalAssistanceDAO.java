package org.openhmis.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpMedicalAssistance;

public class TmpMedicalAssistanceDAO extends BaseDAO {

	public TmpMedicalAssistanceDAO() {
	}

	public TmpMedicalAssistance getTmpMedicalAssistanceById(Integer medicalAssistanceId)  {
		String queryString = "select medicalAssistance " + 
			"from TmpMedicalAssistance as medicalAssistance " + 
			"where medicalAssistance.medicalAssistanceId =:medicalAssistanceId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("medicalAssistanceId", medicalAssistanceId);
		queryObject.setMaxResults(1);
		
		List<TmpMedicalAssistance> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpMedicalAssistance)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpMedicalAssistance> getTmpMedicalAssistancesByEnrollmentId(Integer enrollmentId) {
		String queryString = "select medicalAssistance " + 
				"from TmpMedicalAssistance as medicalAssistance " + 
				"where medicalAssistance.enrollmentId =:enrollmentId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		List<TmpMedicalAssistance> results = queryObject.list();
		session.close();
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpMedicalAssistance> getTmpMedicalAssistancesByEnrollmentId(Integer enrollmentId, Date updateDate) {
		String queryString = "select medicalAssistance " + 
				"from TmpMedicalAssistance as medicalAssistance " + 
				"where medicalAssistance.enrollmentId =:enrollmentId " + 
				"  and medicalAssistance.updateDate >= :updatedSince";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("enrollmentId", enrollmentId);
		queryObject.setParameter("updatedSince", updateDate);
		List<TmpMedicalAssistance> results = queryObject.list();
		session.close();
		return results;
	}
}