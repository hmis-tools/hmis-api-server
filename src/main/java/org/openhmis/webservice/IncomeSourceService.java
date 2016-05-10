



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
import org.openhmis.dto.IncomeSourceDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.IncomeSourceManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/income-sources")
public class IncomeSourceService {
	private static final Logger log = Logger.getLogger(IncomeSourceService.class);
	public IncomeSourceService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<IncomeSourceDTO> getIncomeSources(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<IncomeSourceDTO> incomeSourceDTOs = IncomeSourceManager.getIncomeSources();
			return incomeSourceDTOs;
		} else {
			List<IncomeSourceDTO> incomeSourceDTOs = IncomeSourceManager.getIncomeSources(DateParser.parseDate(updatedSince));
			return incomeSourceDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public IncomeSourceDTO createIncomeSource(@HeaderParam("Authorization") String authorization, IncomeSourceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		IncomeSourceDTO outputDTO = IncomeSourceManager.addIncomeSource(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{incomeSourceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public IncomeSourceDTO getIncomeSource(@HeaderParam("Authorization") String authorization, @PathParam("incomeSourceId") String incomeSourceId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		IncomeSourceDTO outputDTO = IncomeSourceManager.getIncomeSourceById(incomeSourceId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{incomeSourceId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public IncomeSourceDTO updateIncomeSource(@HeaderParam("Authorization") String authorization, @PathParam("incomeSourceId") String incomeSourceId, IncomeSourceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setIncomeSourceId(incomeSourceId);
		
		IncomeSourceDTO outputDTO = IncomeSourceManager.updateIncomeSource(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{incomeSourceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteIncomeSource(@HeaderParam("Authorization") String authorization, @PathParam("incomeSourceId") String incomeSourceId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		IncomeSourceManager.deleteIncomeSource(incomeSourceId);
		return "true";
	}
}
