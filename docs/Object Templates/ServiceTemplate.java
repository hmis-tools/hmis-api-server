



package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

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

import org.apache.log4j.Logger;
import org.openhmis.dto.CapNameDTO;
import org.openhmis.manager.CapNameManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/dash-names")
public class CapNameService {
	private static final Logger log = Logger.getLogger(CapNameService.class);
	public CapNameService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<CapNameDTO> getCapNames(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<CapNameDTO> camelNameDTOs = CapNameManager.getCapNames();
			return camelNameDTOs;
		} else {
			List<CapNameDTO> camelNameDTOs = CapNameManager.getCapNames(DateParser.parseDate(updatedSince));
			return camelNameDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public CapNameDTO createCapName(@HeaderParam("Authorization") String authorization, CapNameDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		CapNameDTO outputDTO = CapNameManager.addCapName(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{camelNameId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public CapNameDTO getCapName(@HeaderParam("Authorization") String authorization, @PathParam("camelNameId") String camelNameId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		CapNameDTO outputDTO = CapNameManager.getCapNameById(camelNameId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{camelNameId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public CapNameDTO updateCapName(@HeaderParam("Authorization") String authorization, @PathParam("camelNameId") String camelNameId, CapNameDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputDTO.setCapNameId(camelNameId);
		
		CapNameDTO outputDTO = CapNameManager.updateCapName(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{camelNameId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteCapName(@HeaderParam("Authorization") String authorization, @PathParam("camelNameId") String camelNameId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		CapNameManager.deleteCapName(camelNameId);
		return "true";
	}
}