package org.openhmis.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openhmis.domain.PathClient;
import org.openhmis.dto.search.ClientSearchDTO;
import org.openhmis.util.DateParser;

public class PathClientDAO extends BaseDAO {

	// default constructor
	public PathClientDAO() { }

	public PathClient getPathClientByClientKey(Integer clientKey)  {
		String queryString = "select client " + 
			"from PathClient as client " + 
			"where client.clientKey =:clientKey";

		Session session = getSession();
		Query queryObject = session.createQuery(queryString);
		queryObject.setParameter("clientKey", clientKey);
		queryObject.setMaxResults(1);
		
		List<PathClient> results = queryObject.list();
		session.close();
		
		if(results.size() > 0)
			return (PathClient)results.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<PathClient> getPathClients(ClientSearchDTO searchDTO) {

		Session session = getSession();
		Criteria query = session.createCriteria(PathClient.class);
		if(searchDTO.getFirstName() != null) {
			query.add(Restrictions.like("firstName", searchDTO.getFirstName().replace('*', '%')));
		}
		if(searchDTO.getMiddleName() != null) {
			query.add(Restrictions.like("middleName", searchDTO.getMiddleName().replace('*', '%')));
		}
		if(searchDTO.getLastName() != null) {
			query.add(Restrictions.like("lastName", searchDTO.getLastName().replace('*', '%')));
		}
		if(searchDTO.getSsn() != null) {
			query.add(Restrictions.like("identification", searchDTO.getSsn().replace('*', '%')));
		}
		if(searchDTO.getUpdatedSince() != null) {
			query.add(Restrictions.gt("updateDate", DateParser.parseDate(searchDTO.getUpdatedSince())));
		}
		if(searchDTO.getDobStart() != null) {
			query.add(Restrictions.ge("dateOfBirth", DateParser.parseDate(searchDTO.getDobStart())));
		}
		if(searchDTO.getDobEnd() != null) {
			query.add(Restrictions.le("dateOfBirth", DateParser.parseDate(searchDTO.getDobEnd())));
		}
		
		List<PathClient> results = query.list();
		session.close();
		return results;
	}
}