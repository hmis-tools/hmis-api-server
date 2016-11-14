



package org.openhmis.webservice;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.BeanParam;
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
import org.openhmis.code.ConsentApprovalStatus;
import org.openhmis.dto.ConsentDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.dto.search.ConsentSearchDTO;
import org.openhmis.manager.ConsentManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/consents")
public class ConsentService {
	private static final Logger log = Logger.getLogger(ConsentService.class);
	public ConsentService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ConsentDTO> getConsents(@HeaderParam("Authorization") String authorization,  @BeanParam ConsentSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                List<ConsentDTO> consentDTOs = ConsentManager.getConsents(searchDTO);
                log.info("GET /consents (" + consentDTOs.size() + " results)");
                return consentDTOs;			
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ConsentDTO createConsent(@HeaderParam("Authorization") String authorization, ConsentDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		
		// TODO: For now we approve all requests
		inputDTO.setDateProcessed(new Date());
		inputDTO.setApprovalStatus(ConsentApprovalStatus.APPROVED);
		
		ConsentDTO outputDTO = ConsentManager.addConsent(inputDTO);
                log.info("POST /consents (new id: " + outputDTO.getId() + ")");
		return outputDTO;
	}
	
	@GET
	@Path("/{consentId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ConsentDTO getConsent(@HeaderParam("Authorization") String authorization, @PathParam("consentId") String consentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		ConsentDTO outputDTO = ConsentManager.getConsentById(consentId);
                log.info("GET /consents/" + consentId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{consentId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ConsentDTO updateConsent(@HeaderParam("Authorization") String authorization, @PathParam("consentId") String consentId, ConsentDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setConsentId(consentId);
		
		ConsentDTO outputDTO = ConsentManager.updateConsent(inputDTO);
                log.info("PUT /consents/" + consentId);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{consentId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteConsent(@HeaderParam("Authorization") String authorization, @PathParam("consentId") String consentId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ConsentManager.deleteConsent(consentId);
                log.info("DELETE /consents/" + consentId);
		return "true";
	}
}
