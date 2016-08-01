package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpMedicalAssistance;
import org.openhmis.dto.search.MedicalAssistanceSearchDTO;
import org.openhmis.util.DateParser;

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
	public List<TmpMedicalAssistance> getTmpMedicalAssistances(MedicalAssistanceSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpMedicalAssistance.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
                if(searchDTO.getEnrollmentId() != null) {
                    query.add(Restrictions.eq("enrollmentId", Integer.parseInt(searchDTO.getEnrollmentId())));
		}
		List<TmpMedicalAssistance> results = query.list();
		session.close();
		return results;
	}
	
}
