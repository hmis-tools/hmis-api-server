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
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.dto.ClientDTO;
import org.openhmis.dto.search.OrganizationSearchDTO;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.InventoryDTO;
import org.openhmis.dto.OrganizationDTO;
import org.openhmis.dto.SiteDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.CoCManager;
import org.openhmis.manager.FunderManager;
import org.openhmis.manager.InventoryManager;
import org.openhmis.manager.OrganizationManager;
import org.openhmis.manager.SiteManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/organizations")
public class OrganizationService {
	private static final ObjectMapper om = new ObjectMapper();
	private static final Logger log = Logger.getLogger(ClientService.class);

	public OrganizationService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<OrganizationDTO> getOrganizations(@HeaderParam("Authorization") String authorization, @BeanParam OrganizationSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                List<OrganizationDTO> organizationDTOs = OrganizationManager.getOrganizations(searchDTO);
                log.info("GET /organizations (" + organizationDTOs.size() + " results)");
                return organizationDTOs;
        }
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public OrganizationDTO createOrganization(@HeaderParam("Authorization") String authorization, OrganizationDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		OrganizationDTO outputVO = OrganizationManager.addOrganization(inputVO);
                log.info("POST /organizations (new id: " + outputVO.getId() + ")");
                return outputVO;
	}
	
	@GET
	@Path("/{organizationId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public OrganizationDTO getOrganization(@HeaderParam("Authorization") String authorization, @PathParam("organizationId") String organizationId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		OrganizationDTO organizationDTO = OrganizationManager.getOrganizationByOrganizationId(organizationId);
                log.info("GET /organizations/" + organizationId);
		return organizationDTO;
	}
	
	@PUT
	@Path("/{organizationId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public OrganizationDTO updateOrganization(@HeaderParam("Authorization") String authorization, @PathParam("organizationId") String organizationId, OrganizationDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputVO.setOrganizationId(organizationId);
		
		OrganizationDTO outputVO = OrganizationManager.updateOrganization(inputVO);
                log.info("PUT /organizations/" + organizationId);
		return outputVO;
	}
	
	@DELETE
	@Path("/{organizationId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteOrganization(@HeaderParam("Authorization") String authorization, @PathParam("organizationId") String organizationId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		OrganizationManager.deleteOrganization(organizationId);
                log.info("DELETE /organizations/" + organizationId);
		return "true";
	}
}
