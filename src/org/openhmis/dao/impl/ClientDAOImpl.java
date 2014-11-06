package org.openhmis.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.openhmis.dao.ClientDAO;
import org.openhmis.domain.Client;
import org.openhmis.util.HmisConstants;


public class ClientDAOImpl extends BaseDAOImpl implements ClientDAO 
{
private static final Logger log = Logger.getLogger(ClientDAOImpl.class);
	
	// default constructor
	public ClientDAOImpl()
	{
		
	}
	@Override
	public Boolean validateClient(Client client) 
	{
		log.debug("validate Client");
		return null;
	}

	@Override
	public Client findClient(Client client) 
	{
		log.debug("find Client");
		return null;
	}
	@Override
	public List<Object[]> findClientById(Long clientKey) 
	{
		log.debug("find Client By Id");
		try
		{
//			Client client = (Client)getSession().get("org.openhmis.domain.Client", clientKey);
//			return client;
			String queryString = "select c.clientKey as clientKey, c.socSecNumber as SSN, c.nameFirst as FirstName, c.nameLast as LastName,c.nameMiddle as MiddleName,c.dateOfBirth as DOB," +
					"ce.description as Ethnicity, cg.description as Gender " +
					"from Client c " +
					"join c.codeEthnicity ce " +
					"join c.codeGender cg where c.clientKey =:cclientKey";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter("cclientKey", clientKey);
			queryObject.setMaxResults(HmisConstants.MAX_RESULT);
			return (List<Object[]>)queryObject.list();
		}
		catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("find Client By Id failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findClientByName(String firstName, String lastName) 
	{
		log.debug("find Client By Id");
		try
		{
			String queryString = "select c from Client c " +
								"where c.fistName like '?1" +
								"and c.lastName like '?2";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(1, firstName);
			queryObject.setParameter(2, lastName);
			return queryObject.list();
		}
		catch (RuntimeException re)
		{
			log.error("fine Client By First Name and Last Name failed" , re);
			throw re;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findClientByLastName(String lastName) 
	{
		try
		{
			String queryString = "select c from Client c where c.nameLast like :llastName";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter("llastName", lastName);
			return (List<Client>)queryObject.list();
		}
		catch(RuntimeException re)
		{
			log.error("find Client By Last Name failed", re);
			throw re;
		}
	}
	@Override
	public Client findClientBySSN(String ssn) 
	{
		log.debug("find Client By ssn");
		try
		{
			String queryString = "select c from Client c where c.socSecNumber = :sssn";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter("sssn", ssn);
			return (Client)queryObject.uniqueResult();
		}
		catch (RuntimeException re)
		{
			log.error("find Client By ssn failed", re);
			throw re;
		}
	}	
}
