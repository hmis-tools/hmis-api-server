



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
import org.openhmis.dto.DevelopmentalDisabilityDTO;
import org.openhmis.manager.DevelopmentalDisabilityManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/developmental-disabilities")
public class DevelopmentalDisabilityService {
	private static final Logger log = Logger.getLogger(DevelopmentalDisabilityService.class);
	public DevelopmentalDisabilityService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<DevelopmentalDisabilityDTO> getDevelopmentalDisabilities(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = DevelopmentalDisabilityManager.getDevelopmentalDisabilities();
			return developmentalDisabilityDTOs;
		} else {
			List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = DevelopmentalDisabilityManager.getDevelopmentalDisabilities(DateParser.parseDate(updatedSince));
			return developmentalDisabilityDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DevelopmentalDisabilityDTO createDevelopmentalDisability(@HeaderParam("Authorization") String authorization, DevelopmentalDisabilityDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		DevelopmentalDisabilityDTO outputDTO = DevelopmentalDisabilityManager.addDevelopmentalDisability(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{developmentalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DevelopmentalDisabilityDTO getDevelopmentalDisability(@HeaderParam("Authorization") String authorization, @PathParam("developmentalDisabilityId") String developmentalDisabilityId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		DevelopmentalDisabilityDTO outputDTO = DevelopmentalDisabilityManager.getDevelopmentalDisabilityById(developmentalDisabilityId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{developmentalDisabilityId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DevelopmentalDisabilityDTO updateDevelopmentalDisability(@HeaderParam("Authorization") String authorization, @PathParam("developmentalDisabilityId") String developmentalDisabilityId, DevelopmentalDisabilityDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputDTO.setDevelopmentalDisabilityId(developmentalDisabilityId);
		
		DevelopmentalDisabilityDTO outputDTO = DevelopmentalDisabilityManager.updateDevelopmentalDisability(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{developmentalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteDevelopmentalDisability(@HeaderParam("Authorization") String authorization, @PathParam("developmentalDisabilityId") String developmentalDisabilityId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		DevelopmentalDisabilityManager.deleteDevelopmentalDisability(developmentalDisabilityId);
		return "true";
	}
}