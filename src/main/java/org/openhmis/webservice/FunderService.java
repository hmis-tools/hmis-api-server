



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
import org.openhmis.dto.FunderDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.FunderManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/funders")
public class FunderService {
	private static final Logger log = Logger.getLogger(FunderService.class);
	public FunderService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<FunderDTO> getFunders(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		
                List<FunderDTO> funderDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			funderDTOs = FunderManager.getFunders();
		} else {
			funderDTOs = FunderManager.getFunders(DateParser.parseDate(updatedSince));
		}
                log.info("GET /funders (" + funderDTOs.size() + " results)");
                return funderDTOs;
		
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FunderDTO createFunder(@HeaderParam("Authorization") String authorization, FunderDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		FunderDTO outputDTO = FunderManager.addFunder(inputDTO);
                log.info("POST /funders (new id: " + outputDTO.getId() + ")");
		return outputDTO;
	}
	
	@GET
	@Path("/{funderId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FunderDTO getFunder(@HeaderParam("Authorization") String authorization, @PathParam("funderId") String funderId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		FunderDTO outputDTO = FunderManager.getFunderById(funderId);
                log.info("GET /funders/" + funderId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{funderId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FunderDTO updateFunder(@HeaderParam("Authorization") String authorization, @PathParam("funderId") String funderId, FunderDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setFunderId(funderId);
		
		FunderDTO outputDTO = FunderManager.updateFunder(inputDTO);
                log.info("PUT /funders/" + funderId);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{funderId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteFunder(@HeaderParam("Authorization") String authorization, @PathParam("funderId") String funderId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		FunderManager.deleteFunder(funderId);
                log.info("DELETE /funders/" + funderId);
		return "true";
	}
}
