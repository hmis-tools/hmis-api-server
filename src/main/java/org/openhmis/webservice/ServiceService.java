



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
import org.openhmis.dto.ServiceDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.ServiceManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/services")
public class ServiceService {
	private static final Logger log = Logger.getLogger(ServiceService.class);
	public ServiceService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ServiceDTO> getServices(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		
                List<ServiceDTO> serviceDTOs;
                // If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			serviceDTOs = ServiceManager.getServices();
		} else {
			serviceDTOs = ServiceManager.getServices(DateParser.parseDate(updatedSince));
		}
                log.info("GET /services (" + serviceDTOs.size() + ")");
                return serviceDTOs;
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ServiceDTO createService(@HeaderParam("Authorization") String authorization, ServiceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ServiceDTO outputDTO = ServiceManager.addService(inputDTO);
                log.info("POST  /services (" + outputDTO.getId() + ")");
                return outputDTO;
	}
	
	@GET
	@Path("/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ServiceDTO getService(@HeaderParam("Authorization") String authorization, @PathParam("serviceId") String serviceId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		ServiceDTO outputDTO = ServiceManager.getServiceById(serviceId);
                log.info("GET  /services/" + serviceId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{serviceId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ServiceDTO updateService(@HeaderParam("Authorization") String authorization, @PathParam("serviceId") String serviceId, ServiceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setServiceId(serviceId);
		
		ServiceDTO outputDTO = ServiceManager.updateService(inputDTO);
                log.info("PUT  /services/" + serviceId);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteService(@HeaderParam("Authorization") String authorization, @PathParam("serviceId") String serviceId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ServiceManager.deleteService(serviceId);
                log.info("DELETE  /services/" + serviceId);
		return "true";
	}
}
