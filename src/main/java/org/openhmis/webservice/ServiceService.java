



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
import org.openhmis.dto.ServiceDTO;
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
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<ServiceDTO> serviceDTOs = ServiceManager.getServices();
			return serviceDTOs;
		} else {
			List<ServiceDTO> serviceDTOs = ServiceManager.getServices(DateParser.parseDate(updatedSince));
			return serviceDTOs;			
		}
		
	}
	
	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ServiceDTO createService(@HeaderParam("Authorization") String authorization, ServiceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ServiceDTO outputDTO = ServiceManager.addService(inputDTO);
		return outputDTO;
	}
	
	@GET
	@Path("/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ServiceDTO getService(@HeaderParam("Authorization") String authorization, @PathParam("serviceId") String serviceId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ServiceDTO outputDTO = ServiceManager.getServiceById(serviceId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ServiceDTO updateService(@HeaderParam("Authorization") String authorization, @PathParam("serviceId") String serviceId, ServiceDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputDTO.setServiceId(serviceId);
		
		ServiceDTO outputDTO = ServiceManager.updateService(inputDTO);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteService(@HeaderParam("Authorization") String authorization, @PathParam("serviceId") String serviceId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ServiceManager.deleteService(serviceId);
		return "true";
	}
}