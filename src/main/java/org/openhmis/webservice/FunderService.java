



package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

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
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<FunderDTO> funderDTOs = FunderManager.getFunders();
			return funderDTOs;
		} else {
			List<FunderDTO> funderDTOs = FunderManager.getFunders(DateParser.parseDate(updatedSince));
			return funderDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FunderDTO createFunder(@HeaderParam("Authorization") String authorization, FunderDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		FunderDTO outputDTO = FunderManager.addFunder(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{funderId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FunderDTO getFunder(@HeaderParam("Authorization") String authorization, @PathParam("funderId") String funderId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		FunderDTO outputDTO = FunderManager.getFunderById(funderId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{funderId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FunderDTO updateFunder(@HeaderParam("Authorization") String authorization, @PathParam("funderId") String funderId, FunderDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputDTO.setFunderId(funderId);
		
		FunderDTO outputDTO = FunderManager.updateFunder(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{funderId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteFunder(@HeaderParam("Authorization") String authorization, @PathParam("funderId") String funderId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		FunderManager.deleteFunder(funderId);
		return "true";
	}
}