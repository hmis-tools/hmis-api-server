



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
import org.openhmis.dto.NonCashBenefitDTO;
import org.openhmis.manager.NonCashBenefitManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/non-cash-benefits")
public class NonCashBenefitService {
	private static final Logger log = Logger.getLogger(NonCashBenefitService.class);
	public NonCashBenefitService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<NonCashBenefitDTO> getNonCashBenefits(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
			throw new Error("You are not authorized to access this content");
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<NonCashBenefitDTO> nonCashBenefitDTOs = NonCashBenefitManager.getNonCashBenefits();
			return nonCashBenefitDTOs;
		} else {
			List<NonCashBenefitDTO> nonCashBenefitDTOs = NonCashBenefitManager.getNonCashBenefits(DateParser.parseDate(updatedSince));
			return nonCashBenefitDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public NonCashBenefitDTO createNonCashBenefit(@HeaderParam("Authorization") String authorization, NonCashBenefitDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
			throw new Error("You are not authorized to access this content");
		NonCashBenefitDTO outputDTO = NonCashBenefitManager.addNonCashBenefit(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{nonCashBenefitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public NonCashBenefitDTO getNonCashBenefit(@HeaderParam("Authorization") String authorization, @PathParam("nonCashBenefitId") String nonCashBenefitId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
			throw new Error("You are not authorized to access this content");
		NonCashBenefitDTO outputDTO = NonCashBenefitManager.getNonCashBenefitById(nonCashBenefitId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{nonCashBenefitId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public NonCashBenefitDTO updateNonCashBenefit(@HeaderParam("Authorization") String authorization, @PathParam("nonCashBenefitId") String nonCashBenefitId, NonCashBenefitDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
			throw new Error("You are not authorized to access this content");
		inputDTO.setNonCashBenefitId(nonCashBenefitId);
		
		NonCashBenefitDTO outputDTO = NonCashBenefitManager.updateNonCashBenefit(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{nonCashBenefitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteNonCashBenefit(@HeaderParam("Authorization") String authorization, @PathParam("nonCashBenefitId") String nonCashBenefitId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
			throw new Error("You are not authorized to access this content");
		NonCashBenefitManager.deleteNonCashBenefit(nonCashBenefitId);
		return "true";
	}
}