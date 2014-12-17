package org.openhmis.service.impl;

import java.util.List;

import org.openhmis.dao.ClientDAO;
import org.openhmis.dao.impl.ClientDAOImpl;
import org.openhmis.domain.Client;
import org.openhmis.exception.client.ClientNotFoundException;
import org.openhmis.exception.client.InValidClientException;
import org.openhmis.service.ClientManager;
import org.openhmis.util.HmisConstants;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class ClientManagerImpl implements ClientManager 
{
	
	//private static final Logger log = LoggerFactory.getLogger(ClientManagerImpl.class);

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
		if ((client.getSsn() != null) && (client.getSsn().length()== HmisConstants.SSN_LENGTH))
		{
			Client existingClient = clientDAO.findClientBySSN(client.getSsn());	
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
	public Client getClientById(Integer clientKey) throws ClientNotFoundException
	{
		return clientDAO.findClientById(clientKey);
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
