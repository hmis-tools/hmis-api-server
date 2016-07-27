package org.openhmis.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.openhmis.domain.TmpTokenCache;

public class TmpTokenCacheDAO extends BaseDAO {

	public TmpTokenCacheDAO() {
	}
    
	public TmpTokenCache getTmpTokenCacheById(Integer tokenCacheId)  {
		String queryString = "select tokenCache " + 
			"from TmpTokenCache as tokenCache " + 
			"where tokenCache.tokenCacheId =:tokenCacheId";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("tokenCacheId", tokenCacheId);
		queryObject.setMaxResults(1);
		
		List<TmpTokenCache> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpTokenCache)results.get(0);
		else
			return null;
	}

	public TmpTokenCache getTmpTokenCacheByUserId(String userId)  {
		String queryString = "select tokenCache " + 
			"from TmpTokenCache as tokenCache " + 
			"where tokenCache.userId =:userId";
		
		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("userId", userId);
		queryObject.setMaxResults(1);
		
		List<TmpTokenCache> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpTokenCache)results.get(0);
		else
			return null;
	}

	public TmpTokenCache getTmpTokenCacheByIdToken(String idToken)  {
		String queryString = "select tokenCache " + 
			"from TmpTokenCache as tokenCache " + 
			"where tokenCache.id_token =:idToken";
		
		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("idToken", idToken);
		queryObject.setMaxResults(1);
		
		List<TmpTokenCache> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (TmpTokenCache)results.get(0);
		else
			return null;
	}
    
	@SuppressWarnings("unchecked")
	public List<TmpTokenCache> getTmpTokenCaches() {
		String queryString = "select tokenCache " + 
				"from TmpTokenCache as tokenCache";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		List<TmpTokenCache> results = queryObject.list();
		session.close();
		return results;
	}
}
