



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
import org.openhmis.dto.ChronicHealthConditionDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.ChronicHealthConditionManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/chronic-health-conditions")
public class ChronicHealthConditionService {
	private static final Logger log = Logger.getLogger(ChronicHealthConditionService.class);
	public ChronicHealthConditionService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ChronicHealthConditionDTO> getChronicHealthConditions(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();

                List<ChronicHealthConditionDTO> chronicHealthConditionDTOs;
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			chronicHealthConditionDTOs = ChronicHealthConditionManager.getChronicHealthConditions();
		} else {
			chronicHealthConditionDTOs = ChronicHealthConditionManager.getChronicHealthConditions(DateParser.parseDate(updatedSince));
		}
                
                log.info("GET /chronic-health-conditions (" + chronicHealthConditionDTOs.size() + " results)");
                return chronicHealthConditionDTOs;
		
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ChronicHealthConditionDTO createChronicHealthCondition(@HeaderParam("Authorization") String authorization, ChronicHealthConditionDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ChronicHealthConditionDTO outputDTO = ChronicHealthConditionManager.addChronicHealthCondition(inputDTO);
                log.info("POST /chronic-health-conditions (new id: " + outputDTO.getChronicHealthConditionId() + ")");
		return outputDTO;
	}
	
	@GET
	@Path("/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ChronicHealthConditionDTO getChronicHealthConditiion(@HeaderParam("Authorization") String authorization, @PathParam("chronicHealthConditionId") String chronicHealthConditionId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		ChronicHealthConditionDTO outputDTO = ChronicHealthConditionManager.getChronicHealthConditionById(chronicHealthConditionId);
                /* TODO: In most similar logging lines, we use the
                   original variable (e.g., chronicHealthConditionId)
                   instead of calling a getID() method on the
                   resultant object.  Why is this case different? */
                log.info("GET /chronic-health-conditions/" + outputDTO.getChronicHealthConditionId());
		return outputDTO;
	}
	
	@PUT
	@Path("/{chronicHealthConditionId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ChronicHealthConditionDTO updateChronicHealthCondition(@HeaderParam("Authorization") String authorization, @PathParam("chronicHealthConditionId") String chronicHealthConditionId, ChronicHealthConditionDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setChronicHealthConditionId(chronicHealthConditionId);
		
		ChronicHealthConditionDTO outputDTO = ChronicHealthConditionManager.updateChronicHealthCondition(inputDTO);
                log.info("PUT /chronic-health-conditions/" + outputDTO.getChronicHealthConditionId());
		return outputDTO;
	}
	
	@DELETE
	@Path("/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteChronicHealthCondition(@HeaderParam("Authorization") String authorization, @PathParam("chronicHealthConditionId") String chronicHealthConditionId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ChronicHealthConditionManager.deleteChronicHealthCondition(chronicHealthConditionId);
                log.info("DELETE /chronic-health-conditions/" + chronicHealthConditionId);
		return "true";
	}
}
