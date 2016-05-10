



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
import org.openhmis.dto.SubstanceAbuseDTO;
import org.openhmis.manager.SubstanceAbuseManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/substance-abuses")
public class SubstanceAbuseService {
	private static final Logger log = Logger.getLogger(SubstanceAbuseService.class);
	public SubstanceAbuseService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<SubstanceAbuseDTO> getSubstanceAbuses(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<SubstanceAbuseDTO> substanceAbuseDTOs = SubstanceAbuseManager.getSubstanceAbuses();
			return substanceAbuseDTOs;
		} else {
			List<SubstanceAbuseDTO> substanceAbuseDTOs = SubstanceAbuseManager.getSubstanceAbuses(DateParser.parseDate(updatedSince));
			return substanceAbuseDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SubstanceAbuseDTO createSubstanceAbuse(@HeaderParam("Authorization") String authorization, SubstanceAbuseDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		SubstanceAbuseDTO outputDTO = SubstanceAbuseManager.addSubstanceAbuse(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{substanceAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SubstanceAbuseDTO getSubstanceAbuse(@HeaderParam("Authorization") String authorization, @PathParam("substanceAbuseId") String substanceAbuseId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		SubstanceAbuseDTO outputDTO = SubstanceAbuseManager.getSubstanceAbuseById(substanceAbuseId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{substanceAbuseId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SubstanceAbuseDTO updateSubstanceAbuse(@HeaderParam("Authorization") String authorization, @PathParam("substanceAbuseId") String substanceAbuseId, SubstanceAbuseDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setSubstanceAbuseId(substanceAbuseId);
		
		SubstanceAbuseDTO outputDTO = SubstanceAbuseManager.updateSubstanceAbuse(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{substanceAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteSubstanceAbuse(@HeaderParam("Authorization") String authorization, @PathParam("substanceAbuseId") String substanceAbuseId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		SubstanceAbuseManager.deleteSubstanceAbuse(substanceAbuseId);
		return "true";
	}
}
