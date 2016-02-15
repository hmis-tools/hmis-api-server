package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.dto.ClientDTO;
import org.openhmis.manager.ClientManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

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
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ClientDTO> getClients(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		
		// If the user specified no updatedSince parameter, return all clients
		if(updatedSince == null) {
			List<ClientDTO> clientDTOs = clientManager.getClients();
			return clientDTOs;			
		} else {
			List<ClientDTO> clientDTOs = clientManager.getClientsByUpdateDate(DateParser.parseDate(updatedSince));
			return clientDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ClientDTO createClient(@HeaderParam("Authorization") String authorization, ClientDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ClientDTO outputVO = clientManager.addClient(inputVO);
		return outputVO;
	}
	
	@GET
	@Path("/{personalId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ClientDTO getClient(@HeaderParam("Authorization") String authorization, @PathParam("personalId") String personalId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ClientDTO clientDTO = clientManager.getClientByPersonalId(personalId);
		return clientDTO;
	}
	
	@PUT
	@Path("/{personalId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ClientDTO updateClient(@HeaderParam("Authorization") String authorization, @PathParam("personalId") String personalId, ClientDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setPersonalId(personalId);
		
		ClientDTO outputVO = clientManager.updateClient(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{personalId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteClient(@HeaderParam("Authorization") String authorization, @PathParam("personalId") String personalId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		clientManager.deleteClient(personalId);
		return "true";
	}
}
