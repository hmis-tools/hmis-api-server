



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
import org.openhmis.dto.FinancialAssistanceDTO;
import org.openhmis.dto.search.FinancialAssistanceSearchDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.FinancialAssistanceManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/financial-assistances")
public class FinancialAssistanceService {
	private static final Logger log = Logger.getLogger(FinancialAssistanceService.class);
	public FinancialAssistanceService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<FinancialAssistanceDTO> getFinancialAssistances(@HeaderParam("Authorization") String authorization, @BeanParam FinancialAssistanceSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		
		// If the user specified no updatedSince parameter, return everything
                List<FinancialAssistanceDTO> financialAssistanceDTOs = FinancialAssistanceManager.getFinancialAssistances(searchDTO);
                return financialAssistanceDTOs;
				
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FinancialAssistanceDTO createFinancialAssistance(@HeaderParam("Authorization") String authorization, FinancialAssistanceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		FinancialAssistanceDTO outputDTO = FinancialAssistanceManager.addFinancialAssistance(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{financialAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FinancialAssistanceDTO getFinancialAssistance(@HeaderParam("Authorization") String authorization, @PathParam("financialAssistanceId") String financialAssistanceId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		FinancialAssistanceDTO outputDTO = FinancialAssistanceManager.getFinancialAssistanceById(financialAssistanceId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{financialAssistanceId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FinancialAssistanceDTO updateFinancialAssistance(@HeaderParam("Authorization") String authorization, @PathParam("financialAssistanceId") String financialAssistanceId, FinancialAssistanceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setFinancialAssistanceId(financialAssistanceId);
		
		FinancialAssistanceDTO outputDTO = FinancialAssistanceManager.updateFinancialAssistance(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{financialAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteFinancialAssistance(@HeaderParam("Authorization") String authorization, @PathParam("financialAssistanceId") String financialAssistanceId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		FinancialAssistanceManager.deleteFinancialAssistance(financialAssistanceId);
		return "true";
	}
}
