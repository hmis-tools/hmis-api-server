package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.TmpUser;
import org.openhmis.dto.search.UserSearchDTO;
import org.openhmis.util.DateParser;

public class TmpUserDAO extends BaseDAO {

	public TmpUserDAO() {
	}

	public TmpUser getTmpUserById(Integer userId)  {
		String queryString = "select user " + 
			"from TmpUser as user " + 
			"where user.userId =:userId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("userId", userId);
		queryObject.setMaxResults(1);
		
		List<TmpUser> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpUser)results.get(0);
		else
			return null;
	}

	public TmpUser getTmpUserByExternalId(String externalId)  {
		String queryString = "select user " + 
			"from TmpUser as user " + 
			"where user.externalId =:externalId";
		
		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("externalId", externalId);
		queryObject.setMaxResults(1);
		
		List<TmpUser> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpUser)results.get(0);
		else
			return null;
	}


	@SuppressWarnings("unchecked")
	public List<TmpUser> getTmpUsers(UserSearchDTO searchDTO) {

		Session session = getSession();
                Criteria query =  session.createCriteria(TmpUser.class);
                if(searchDTO.getUpdatedSince() != null) {
                    query.add(Restrictions.gt("dateUpdated", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
		List<TmpUser> results = query.list();
		session.close();
		return results;
	}
}
