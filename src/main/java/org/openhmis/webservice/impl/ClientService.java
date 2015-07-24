/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.webservice.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.vo.ClientVO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/clients")
public class ClientService {	
	private static final Logger log = Logger.getLogger(ClientService.class);
	private static final ObjectMapper om = new ObjectMapper();

//	private ClientManager clientManager;
//	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	public ClientService() {
	}
//
//
	@GET
	@Path("/clientTest")
	@Produces({MediaType.APPLICATION_JSON})
	public String getClient() throws JsonProcessingException {
		ClientVO clientVO = new ClientVO();
		return om.writeValueAsString(clientVO);//Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON_TYPE).entity(om.writeValueAsString(clientVO)).build();
	}
//
//	@POST
//	@Path("/clients")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient() throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//
//	@PUT
//	@Path("/clients")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient() throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//
//	@DELETE
//	@Path("/clients")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient() throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//
//
//	@GET
//	@Path("/clients/{clientId}")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient(@PathParam("clientId") Long clientKey) throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//
//	@POST
//	@Path("/clients/{clientId}")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient(@PathParam("clientId") Long clientKey) throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//	
//	@PUT
//	@Path("/clients/{clientId}")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient(@PathParam("clientId") Long clientKey) throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
//	
//	@DELETE
//	@Path("/clients/{clientId}")
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public ClientVO getClient(@PathParam("clientId") Long clientKey) throws ClientNotFoundException {
//		ClientVO clientVO = new ClientVO();
//		return clientVO;
//	}
}
