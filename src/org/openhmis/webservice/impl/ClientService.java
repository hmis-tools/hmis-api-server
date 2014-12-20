package org.openhmis.webservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.openhmis.domain.Client;
import org.openhmis.exception.client.ClientAlreadyExistException;
import org.openhmis.exception.client.ClientNotFoundException;
import org.openhmis.exception.client.InValidClientException;
import org.openhmis.exception.client.UnableToAddClientException;
import org.openhmis.exception.client.UnableToUpdateClientException;
import org.openhmis.service.AuthenticateManager;
import org.openhmis.service.ClientManager;
import org.openhmis.service.impl.AuthenticateManagerImpl;
import org.openhmis.service.impl.ClientManagerImpl;
import org.openhmis.vo.ClientVO;



@Path("/clients")
public class ClientService 
{	
	private static final Logger log = Logger.getLogger(ClientService.class);
	private ClientManager clientManager;
	private AuthenticateManager authenticateManager;
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	public ClientService()
	{
		clientManager = new ClientManagerImpl();
		authenticateManager = new AuthenticateManagerImpl();
		
	}

	@GET
	@Path("/client/{clientKey}/{username}/{password}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@RolesAllowed({"ADMIN","CUSTOMER"})
	public ClientVO getClient(@PathParam("clientKey") Long clientKey, @PathParam("username") String username, @PathParam("password") String password) throws ClientNotFoundException
	{
		log.debug("getClient");
		ClientVO clientVO = new ClientVO();
		try
		{
			boolean isAuthenticate = authenticateManager.authenticateUser(username, password);
			if (isAuthenticate)
			{
				clientVO = clientManager.getClientById(clientKey);
				if (clientVO == null)
				{
					throw new ClientNotFoundException(clientKey + " doesn't exist");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error("Couldn't get the client " + e.getMessage());
			throw new ClientNotFoundException(e.getMessage());
		}
		return clientVO;
	}
	
	@GET
	@Path("lastName/{lastName}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	
	public List<ClientVO> getClientByLastName(
			@PathParam("lastName") String lastName) throws ClientNotFoundException 
	{
		log.debug("getClientByLastName");
		List<ClientVO> clientVOList = null;
		try
		{
			clientVOList = new ArrayList<ClientVO>();			
			List<Client> clientList = clientManager.getClientByLastName(lastName);
			if (( clientList == null) || (clientList.isEmpty()))
			{
				throw new ClientNotFoundException(" No Client exist with last name " + lastName);
			}
			for(Client c: clientList)
			{
				ClientVO clientVO = mapper.map(c, ClientVO.class);
				clientVOList.add(clientVO);
			}
		}
		catch(Exception e)
		{
			log.error("Couldn't get the client By Last Name " + e.getMessage());
			throw new ClientNotFoundException(e.getMessage());
		}
		return clientVOList;
	}

	@POST
	@Path("/addClient")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ClientVO addClient(JAXBElement<ClientVO> client) throws ClientAlreadyExistException, InValidClientException, UnableToAddClientException
	{
		log.debug("addClient");
		ClientVO clientVO = null;
		try
		{
			clientVO = client.getValue();
			Client newClient = mapper.map(clientVO, Client.class);
			// first check if this client already exist in the database
			if (newClient.getSocSecNumber() == null){
				throw new InValidClientException("Client doesn't have all the mandatory data.");
			}
			Client existingClient = clientManager.getClientBySSN(newClient.getSocSecNumber());
			if (existingClient != null)
			{
				throw new ClientAlreadyExistException("Client already exist in the system.");
			}
			clientManager.addClient(newClient);
		}
		catch(Exception e)
		{
			log.error("Couldn't add the client " + e.getMessage());
			throw new UnableToAddClientException(e.getMessage());
		}
		return clientVO;
	}

	@PUT
	@Path("/update/{clientKey}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ClientVO updateClient(@PathParam("clientKey") Long clientKey,JAXBElement<ClientVO> client) throws UnableToUpdateClientException
	{
		log.debug("updateClient");
		ClientVO updatedClientVO = null;
		try
		{
			updatedClientVO = client.getValue();
			Client updatedClient = mapper.map(updatedClientVO, Client.class);
			clientManager.updateClient(updatedClient);
		}
		catch(Exception e)
		{
			log.error("Couldn't update the client " + e.getMessage());
			throw new UnableToUpdateClientException(e.getMessage());
		}		
		return updatedClientVO;
	}
	
	public ClientManager getClientManager() {
		return clientManager;
	}

	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}
}
