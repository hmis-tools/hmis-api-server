



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
import org.openhmis.dto.DomesticAbuseDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.DomesticAbuseManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/domestic-abuses")
public class DomesticAbuseService {
	private static final Logger log = Logger.getLogger(DomesticAbuseService.class);
	public DomesticAbuseService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<DomesticAbuseDTO> getDomesticAbuses(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<DomesticAbuseDTO> domesticAbuseDTOs = DomesticAbuseManager.getDomesticAbuses();
			return domesticAbuseDTOs;
		} else {
			List<DomesticAbuseDTO> domesticAbuseDTOs = DomesticAbuseManager.getDomesticAbuses(DateParser.parseDate(updatedSince));
			return domesticAbuseDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DomesticAbuseDTO createDomesticAbuse(@HeaderParam("Authorization") String authorization, DomesticAbuseDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		DomesticAbuseDTO outputDTO = DomesticAbuseManager.addDomesticAbuse(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{domesticAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DomesticAbuseDTO getDomesticAbuse(@HeaderParam("Authorization") String authorization, @PathParam("domesticAbuseId") String domesticAbuseId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		DomesticAbuseDTO outputDTO = DomesticAbuseManager.getDomesticAbuseById(domesticAbuseId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{domesticAbuseId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DomesticAbuseDTO updateDomesticAbuse(@HeaderParam("Authorization") String authorization, @PathParam("domesticAbuseId") String domesticAbuseId, DomesticAbuseDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setDomesticAbuseId(domesticAbuseId);
		
		DomesticAbuseDTO outputDTO = DomesticAbuseManager.updateDomesticAbuse(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{domesticAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteDomesticAbuse(@HeaderParam("Authorization") String authorization, @PathParam("domesticAbuseId") String domesticAbuseId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		DomesticAbuseManager.deleteDomesticAbuse(domesticAbuseId);
		return "true";
	}
}
