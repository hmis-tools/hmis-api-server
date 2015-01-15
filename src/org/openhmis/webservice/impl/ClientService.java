/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.webservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.openhmis.domain.Client;
//import org.openhmis.domain.Ethnicity;
import org.openhmis.service.ClientManager;
import org.openhmis.service.impl.ClientManagerImpl;
import org.openhmis.vo.ClientVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// GG mod
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openhmis.util.*;

@Path("/clients")
public class ClientService 
{	
	private static final Logger log = LoggerFactory.getLogger(GenderService.class);
	private ClientManager clientManager;
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	Session session = null;
	Transaction tx = null;
	
	public ClientService()
	{
		clientManager = new ClientManagerImpl();
	}

	@GET
	@Path("/client/{clientKey}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ClientVO getClient(@PathParam("clientKey") Integer clientKey)
	{
				
		log.debug("getClient");
		ClientVO clientVO = new ClientVO();
		try
		{
			
			Client client = clientManager.getClientById(clientKey);
			clientVO = mapper.map(client, ClientVO.class);
					}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return clientVO;
	}
	
	@GET
	@Path("/lastName/{lastName}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<ClientVO> getClientByLastName(
			@PathParam("lastName") String lastName) 
	{
		log.debug("getClientByLastName");
		List<ClientVO> clientVOList = null;
		try
		{
			clientVOList = new ArrayList<ClientVO>();			
			List<Client> clientList = clientManager.getClientByLastName(lastName);
			for(Client c: clientList)
			{
				ClientVO clientVO = mapper.map(c, ClientVO.class);
				clientVOList.add(clientVO);
			}
		}
		catch(Exception e)
		{
			// in case exception is thrown 
			e.printStackTrace();								// Stack Trace will be remove with the actual message
		}
		return clientVOList;
	}

	@POST
	@Path("/addClient")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ClientVO addClient(JAXBElement<ClientVO> client)
	{
		log.debug("addClient");
		ClientVO clientVO = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			
			clientVO = client.getValue();
			Client newClient = mapper.map(clientVO, Client.class);
			clientManager.addClient(newClient);
					 
			session.save(newClient);
			session.getTransaction().commit();
			HibernateSessionFactory.closeSession();
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
			if( tx != null ) tx.rollback();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return clientVO;
	}

	@PUT
	@Path("/update/{clientKey}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ClientVO updateClient(@PathParam("clientKey") Integer clientKey,JAXBElement<ClientVO> client)
	{
		log.debug("updateClient");
		ClientVO updatedClientVO = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			
			updatedClientVO = client.getValue();
			Client updatedClient = mapper.map(updatedClientVO, Client.class);
			clientManager.updateClient(updatedClient);
		
			session.save(updatedClient);
			session.getTransaction().commit();
			HibernateSessionFactory.closeSession();
		
		}
		catch(Exception e)
		{
			// in case exception is thrown 
			e.printStackTrace();
			// Stack Trace will be remove with the actual message
			if( tx != null ) tx.rollback();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
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
