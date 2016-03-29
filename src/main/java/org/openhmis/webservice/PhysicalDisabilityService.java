



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
import org.openhmis.dto.PhysicalDisabilityDTO;
import org.openhmis.manager.PhysicalDisabilityManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/physical-disabilities")
public class PhysicalDisabilityService {
	private static final Logger log = Logger.getLogger(PhysicalDisabilityService.class);
	public PhysicalDisabilityService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<PhysicalDisabilityDTO> getPhysicalDisabilities(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<PhysicalDisabilityDTO> physicalDisabilityDTOs = PhysicalDisabilityManager.getPhysicalDisabilities();
			return physicalDisabilityDTOs;
		} else {
			List<PhysicalDisabilityDTO> physicalDisabilityDTOs = PhysicalDisabilityManager.getPhysicalDisabilities(DateParser.parseDate(updatedSince));
			return physicalDisabilityDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PhysicalDisabilityDTO createPhysicalDisability(@HeaderParam("Authorization") String authorization, PhysicalDisabilityDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		PhysicalDisabilityDTO outputDTO = PhysicalDisabilityManager.addPhysicalDisability(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{physicalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PhysicalDisabilityDTO getPhysicalDisability(@HeaderParam("Authorization") String authorization, @PathParam("physicalDisabilityId") String physicalDisabilityId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		PhysicalDisabilityDTO outputDTO = PhysicalDisabilityManager.getPhysicalDisabilityById(physicalDisabilityId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{physicalDisabilityId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PhysicalDisabilityDTO updatePhysicalDisability(@HeaderParam("Authorization") String authorization, @PathParam("physicalDisabilityId") String physicalDisabilityId, PhysicalDisabilityDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputDTO.setPhysicalDisabilityId(physicalDisabilityId);
		
		PhysicalDisabilityDTO outputDTO = PhysicalDisabilityManager.updatePhysicalDisability(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{physicalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deletePhysicalDisability(@HeaderParam("Authorization") String authorization, @PathParam("physicalDisabilityId") String physicalDisabilityId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		PhysicalDisabilityManager.deletePhysicalDisability(physicalDisabilityId);
		return "true";
	}
}