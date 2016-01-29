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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.InventoryDTO;
import org.openhmis.dto.OrganizationDTO;
import org.openhmis.dto.SiteDTO;
import org.openhmis.manager.CoCManager;
import org.openhmis.manager.FunderManager;
import org.openhmis.manager.InventoryManager;
import org.openhmis.manager.OrganizationManager;
import org.openhmis.manager.SiteManager;
import org.openhmis.util.Authentication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/organizations")
public class OrganizationService {
	private static final ObjectMapper om = new ObjectMapper();

	public OrganizationService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String getOrganizations(@HeaderParam("Authorization") String authorization) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<OrganizationDTO> organizationDTOs = OrganizationManager.getOrganizations();
		return om.writeValueAsString(organizationDTOs);
	}
	
	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String createOrganization(@HeaderParam("Authorization") String authorization, String data) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		// This endpoint takes in a raw json STRING as input.
		// TODO: support the serialization of individual POST parameters
		OrganizationDTO inputVO = om.readValue(data, OrganizationDTO.class);
		OrganizationDTO outputVO = OrganizationManager.addOrganization(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@GET
	@Path("/{organizationId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String getOrganization(@HeaderParam("Authorization") String authorization, @PathParam("organizationId") String organizationId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		OrganizationDTO organizationDTO = OrganizationManager.getOrganizationByOrganizationId(organizationId);
		return om.writeValueAsString(organizationDTO);
	}
	
	@PUT
	@Path("/{organizationId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String updateOrganization(@HeaderParam("Authorization") String authorization, @PathParam("organizationId") String organizationId, String data) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		OrganizationDTO inputVO = om.readValue(data, OrganizationDTO.class);
		inputVO.setOrganizationId(organizationId);
		
		OrganizationDTO outputVO = OrganizationManager.updateOrganization(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{organizationId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteOrganization(@HeaderParam("Authorization") String authorization, @PathParam("organizationId") String organizationId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		OrganizationManager.deleteOrganization(organizationId);
		return "true";
	}
}
