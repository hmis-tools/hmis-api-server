package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpIncomeSource;
import org.openhmis.dto.search.IncomeSourceSearchDTO;
import org.openhmis.util.DateParser;

public class TmpIncomeSourceDAO extends BaseDAO {

	public TmpIncomeSourceDAO() {
	}

	public TmpIncomeSource getTmpIncomeSourceById(Integer incomeSourceId)  {
		String queryString = "select incomeSource " + 
			"from TmpIncomeSource as incomeSource " + 
			"where incomeSource.incomeSourceId =:incomeSourceId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("incomeSourceId", incomeSourceId);
		queryObject.setMaxResults(1);
		
		List<TmpIncomeSource> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpIncomeSource)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<TmpIncomeSource> getTmpIncomeSources(IncomeSourceSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpIncomeSource.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("updateDate", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
                if(searchDTO.getEnrollmentId() != null) {
                    query.add(Restrictions.eq("enrollmentId", Integer.parseInt(searchDTO.getEnrollmentId())));
		}
		List<TmpIncomeSource> results = query.list();
		session.close();
		return results;
	}
	
}
