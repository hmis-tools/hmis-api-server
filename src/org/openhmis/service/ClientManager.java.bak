package org.openhmis.service;

import java.util.List;

import org.openhmis.domain.Client;
import org.openhmis.exception.client.ClientAlreadyExistException;
import org.openhmis.exception.client.ClientNotFoundException;
import org.openhmis.exception.client.DeleteClientException;
import org.openhmis.exception.client.InValidClientException;
import org.openhmis.exception.client.UnableToAddClientException;
import org.openhmis.exception.client.UnableToUpdateClientException;


public interface ClientManager 
{
	public Boolean addClient(Client client) throws ClientAlreadyExistException, InValidClientException, UnableToAddClientException;																											// add a new client in the database
	public Boolean updateClient(Client client) throws UnableToUpdateClientException;																									// update an existing client in the database
	public Boolean deleteClient(Client client)throws DeleteClientException;																										// delete an existing client
	public Boolean validateClient(Client client) throws InValidClientException;																		// check that a client exist in the database and a valid client
	public Client searchClient(Client client) throws ClientNotFoundException;																		// search that a client exist in the database
	public Client getClientById(Long clientKey) throws ClientNotFoundException;																	// search a client by Id
	public List<Client> getClientByName(String firstName, String lastName) throws ClientNotFoundException;											// search a client by first name and last name
	public List<Client> getClientByLastName(String lastName) throws ClientNotFoundException;
	public Client getClientBySSN(String ssn) throws ClientNotFoundException;																		// search a client by ssn
}
