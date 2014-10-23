package org.openhmis.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.openhmis.dao.ClientDAO;
import org.openhmis.domain.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientDAOImpl extends BaseDAOImpl implements ClientDAO 
{
private static final Logger log = LoggerFactory.getLogger(ClientDAOImpl.class);
	
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
	public Client findClientById(Long clientKey) 
	{
		log.debug("find Client By Id");
		try
		{
			Client client = (Client)getSession().get("org.openhmis.domain.Client", clientKey);
			return client;
		}
		catch (RuntimeException re)
		{
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
