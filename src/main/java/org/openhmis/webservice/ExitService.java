



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
import org.openhmis.dto.ExitDTO;
import org.openhmis.dto.search.ExitSearchDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.ExitManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/exits")
public class ExitService {
	private static final Logger log = Logger.getLogger(ExitService.class);
	public ExitService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ExitDTO> getExits(@HeaderParam("Authorization") String authorization, @BeanParam ExitSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                List<ExitDTO> exitDTOs = ExitManager.getExits(searchDTO);
                log.info("GET /exits (" + exitDTOs.size() + " results)");
                return exitDTOs;
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ExitDTO createExit(@HeaderParam("Authorization") String authorization, ExitDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ExitDTO outputDTO = ExitManager.addExit(inputDTO);
                log.info("POST /exits (new id: " + outputDTO.getId() + ")");
		return outputDTO;
	}
	
	@GET
	@Path("/{exitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ExitDTO getExit(@HeaderParam("Authorization") String authorization, @PathParam("exitId") String exitId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		ExitDTO outputDTO = ExitManager.getExitById(exitId);
                log.info("GET /exits/" + exitId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{exitId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ExitDTO updateExit(@HeaderParam("Authorization") String authorization, @PathParam("exitId") String exitId, ExitDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setExitId(exitId);
		
		ExitDTO outputDTO = ExitManager.updateExit(inputDTO);
                log.info("PUT /exits/" + exitId);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{exitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteExit(@HeaderParam("Authorization") String authorization, @PathParam("exitId") String exitId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ExitManager.deleteExit(exitId);
                log.info("DELETE /exits/" + exitId);
		return "true";
	}
}
