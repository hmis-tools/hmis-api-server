



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
import org.openhmis.dto.MedicalAssistanceDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.MedicalAssistanceManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/medical-assistances")
public class MedicalAssistanceService {
	private static final Logger log = Logger.getLogger(MedicalAssistanceService.class);
	public MedicalAssistanceService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<MedicalAssistanceDTO> getMedicalAssistances(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		
                List<MedicalAssistanceDTO> medicalAssistanceDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			medicalAssistanceDTOs = MedicalAssistanceManager.getMedicalAssistances();
		} else {
			medicalAssistanceDTOs = MedicalAssistanceManager.getMedicalAssistances(DateParser.parseDate(updatedSince));
		}
                log.info("GET /medical-assistances (" + medicalAssistanceDTOs.size() + ")");
                return medicalAssistanceDTOs;
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public MedicalAssistanceDTO createMedicalAssistance(@HeaderParam("Authorization") String authorization, MedicalAssistanceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		MedicalAssistanceDTO outputDTO = MedicalAssistanceManager.addMedicalAssistance(inputDTO);
                log.info("POST  /medical-assistances (" + outputDTO.getId() + ")");
                return outputDTO;
	}
	
	@GET
	@Path("/{medicalAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public MedicalAssistanceDTO getMedicalAssistance(@HeaderParam("Authorization") String authorization, @PathParam("medicalAssistanceId") String medicalAssistanceId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		MedicalAssistanceDTO outputDTO = MedicalAssistanceManager.getMedicalAssistanceById(medicalAssistanceId);
                log.info("GET  /medical-assistances/" + medicalAssistanceId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{medicalAssistanceId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public MedicalAssistanceDTO updateMedicalAssistance(@HeaderParam("Authorization") String authorization, @PathParam("medicalAssistanceId") String medicalAssistanceId, MedicalAssistanceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setMedicalAssistanceId(medicalAssistanceId);
		
		MedicalAssistanceDTO outputDTO = MedicalAssistanceManager.updateMedicalAssistance(inputDTO);
                log.info("PUT  /medical-assistances/" + medicalAssistanceId);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{medicalAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteMedicalAssistance(@HeaderParam("Authorization") String authorization, @PathParam("medicalAssistanceId") String medicalAssistanceId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		MedicalAssistanceManager.deleteMedicalAssistance(medicalAssistanceId);
                log.info("DELETE  /medical-assistances/" + medicalAssistanceId);
		return "true";
	}
}
