



package org.openhmis.webservice;

import java.io.IOException;
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
import org.openhmis.dto.HealthInsuranceDTO;
import org.openhmis.dto.search.HealthInsuranceSearchDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.HealthInsuranceManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/health-insurances")
public class HealthInsuranceService {
	private static final Logger log = Logger.getLogger(HealthInsuranceService.class);
	public HealthInsuranceService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<HealthInsuranceDTO> getHealthInsurances(@HeaderParam("Authorization") String authorization, @BeanParam HealthInsuranceSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		
		// If the user specified no updatedSince parameter, return everything
                List<HealthInsuranceDTO> healthInsuranceDTOs = HealthInsuranceManager.getHealthInsurances(searchDTO);
                return healthInsuranceDTOs;
				
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HealthInsuranceDTO createHealthInsurance(@HeaderParam("Authorization") String authorization, HealthInsuranceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		HealthInsuranceDTO outputDTO = HealthInsuranceManager.addHealthInsurance(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{healthInsuranceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HealthInsuranceDTO getHealthInsurance(@HeaderParam("Authorization") String authorization, @PathParam("healthInsuranceId") String healthInsuranceId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		HealthInsuranceDTO outputDTO = HealthInsuranceManager.getHealthInsuranceById(healthInsuranceId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{healthInsuranceId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HealthInsuranceDTO updateHealthInsurance(@HeaderParam("Authorization") String authorization, @PathParam("healthInsuranceId") String healthInsuranceId, HealthInsuranceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setHealthInsuranceId(healthInsuranceId);
		
		HealthInsuranceDTO outputDTO = HealthInsuranceManager.updateHealthInsurance(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{healthInsuranceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteHealthInsurance(@HeaderParam("Authorization") String authorization, @PathParam("healthInsuranceId") String healthInsuranceId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		HealthInsuranceManager.deleteHealthInsurance(healthInsuranceId);
		return "true";
	}
}
