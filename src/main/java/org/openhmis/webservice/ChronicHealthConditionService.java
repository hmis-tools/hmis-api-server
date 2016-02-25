



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

import org.apache.log4j.Logger;
import org.openhmis.dto.ChronicHealthConditionDTO;
import org.openhmis.manager.ChronicHealthConditionManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/chronic-health-conditions")
public class ChronicHealthConditionService {
	private static final Logger log = Logger.getLogger(ChronicHealthConditionService.class);
	public ChronicHealthConditionService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ChronicHealthConditionDTO> getChronicHealthConditions(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = ChronicHealthConditionManager.getChronicHealthConditions();
			return chronicHealthConditionDTOs;
		} else {
			List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = ChronicHealthConditionManager.getChronicHealthConditions(DateParser.parseDate(updatedSince));
			return chronicHealthConditionDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ChronicHealthConditionDTO createChronicHealthCondition(@HeaderParam("Authorization") String authorization, ChronicHealthConditionDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ChronicHealthConditionDTO outputDTO = ChronicHealthConditionManager.addChronicHealthCondition(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ChronicHealthConditionDTO getChronicHealthConditiion(@HeaderParam("Authorization") String authorization, @PathParam("chronicHealthConditionId") String chronicHealthConditionId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ChronicHealthConditionDTO outputDTO = ChronicHealthConditionManager.getChronicHealthConditionById(chronicHealthConditionId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{chronicHealthConditionId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ChronicHealthConditionDTO updateChronicHealthCondition(@HeaderParam("Authorization") String authorization, @PathParam("chronicHealthConditionId") String chronicHealthConditionId, ChronicHealthConditionDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputDTO.setChronicHealthConditionId(chronicHealthConditionId);
		
		ChronicHealthConditionDTO outputDTO = ChronicHealthConditionManager.updateChronicHealthCondition(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteChronicHealthCondition(@HeaderParam("Authorization") String authorization, @PathParam("chronicHealthConditionId") String chronicHealthConditionId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ChronicHealthConditionManager.deleteChronicHealthCondition(chronicHealthConditionId);
		return "true";
	}
}