package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.manager.ClientManager;
import org.openhmis.vo.ClientVO;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/clients")
public class ClientService {
	private static final Logger log = Logger.getLogger(ClientService.class);
	private static final ObjectMapper om = new ObjectMapper();
	private static final ClientManager clientManager = new ClientManager();

	public ClientService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public String getClients() throws JsonProcessingException {
		List<ClientVO> clientVOs = clientManager.getClients();
		return om.writeValueAsString(clientVOs);
	}
	
	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public String createClient(String data) throws JsonParseException, JsonMappingException, IOException {
		// This endpoint takes in a raw json STRING as input.
		// TODO: support the serialization of individual POST parameters
		ClientVO inputVO = om.readValue(data, ClientVO.class);
		ClientVO outputVO = clientManager.addClient(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@GET
	@Path("/{personalId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getClient(@PathParam("personalId") String personalId) throws JsonProcessingException {
		ClientVO clientVO = clientManager.getClientByPersonalId(personalId);
		return om.writeValueAsString(clientVO);
	}
	
	@PUT
	@Path("/{personalId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateClient(@PathParam("personalId") String personalId, String data) throws JsonParseException, JsonMappingException, IOException {
		ClientVO inputVO = om.readValue(data, ClientVO.class);
		inputVO.setPersonalId(personalId);
		
		ClientVO outputVO = clientManager.updateClient(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{personalId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateClient(@PathParam("personalId") String personalId) throws JsonParseException, JsonMappingException, IOException {
		clientManager.deleteClient(personalId);
		return "true";
	}
}
