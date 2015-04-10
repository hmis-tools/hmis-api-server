/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.service.impl;

import java.util.Date;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.openhmis.dao.ClientDAO;
import org.openhmis.dao.impl.ClientDAOImpl;
import org.openhmis.domain.Client;
import org.openhmis.exception.client.ClientNotFoundException;
import org.openhmis.exception.client.InValidClientException;
import org.openhmis.service.ClientManager;
import org.openhmis.util.HmisConstants;
import org.openhmis.vo.ClientDetailVO;
import org.openhmis.vo.ClientVO;


public class ClientManagerImpl implements ClientManager 
{
	
	private static final Logger log = Logger.getLogger(ClientManagerImpl.class);
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	private ClientDAO clientDAO;
	
	public ClientManagerImpl()
	{
		this.clientDAO = new ClientDAOImpl();
	}

	@Override
	public Boolean addClient(Client client) 
	{
		return clientDAO.save(client);
	}

	@Override
	public Boolean updateClient(Client client) 
	{
		return clientDAO.update(client);
	}

	@Override
	public Boolean deleteClient(Client client) 
	{
		return clientDAO.delete(client);
	}

	@Override
	/**
	 *<p> A client is a valid client if we have the same ssn in the database 
	 */
	public Boolean validateClient(Client client) throws InValidClientException
	{
		Boolean isValid = Boolean.FALSE;															// we assume we didn't find anything in the database
		if ((client.getSocSecNumber() != null) && (client.getSocSecNumber().length()== HmisConstants.SSN_LENGTH))
		{
			Client existingClient = clientDAO.findClientBySSN(client.getSocSecNumber());	
			if (existingClient != null)																// if we have the ssn in the database then it exist
			{
				isValid = Boolean.TRUE;
			}
		}
		return isValid; 
	}

	@Override
	public Client searchClient(Client client) throws ClientNotFoundException
	{
		return clientDAO.findClient(client);
	}

	@Override
	public ClientVO getClientById(Long clientKey) throws ClientNotFoundException
	{
		ClientVO clientVO = new ClientVO();
		try
		{
			List<Object[]> clientObject = clientDAO.findClientById(clientKey);
			if ((clientObject != null) && ( clientObject.size()>0))
			{
				Object[] clientArray = clientObject.get(0);
				
				clientVO.setClientKey((Long)clientArray[0]);
				clientVO.setSocSecNumber((String)clientArray[1]);
				clientVO.setNameFirst((String)clientArray[2]);
				clientVO.setNameLast((String)clientArray[3]);
				clientVO.setNameMiddle((String)clientArray[4]);
				clientVO.setDateOfBirth(((Date)clientArray[5]).toString());
				clientVO.setEthnicityDescription((String)clientArray[6]);
				clientVO.setGenderDescription((String)clientArray[7]);
			}
			else
			{
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			}
		}
		catch(Exception e)
		{
			throw new ClientNotFoundException(e.getMessage());
		}
		return clientVO;
	}

	@Override
	public ClientDetailVO getClientDetailById(Long clientKey)
			throws ClientNotFoundException 
	{
		ClientDetailVO clientDetailVO = new ClientDetailVO();
		try
		{
			Client client = clientDAO.findClientDetailById(clientKey);
			clientDetailVO = mapper.map(client,ClientDetailVO.class);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ClientNotFoundException(e.getMessage());
		}
		return clientDetailVO;
	}

	@Override
	public List<Client> getClientByName(String firstName, String lastName) throws ClientNotFoundException
	{
		return clientDAO.findClientByName(firstName, lastName);
	}

	public List<Client> getClientByLastName(String lastName) throws ClientNotFoundException
	{
		return clientDAO.findClientByLastName(lastName);
	}
	
	@Override
	public Client getClientBySSN(String ssn) throws ClientNotFoundException
	{
		return clientDAO.findClientBySSN(ssn);
	}

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	
	
}
