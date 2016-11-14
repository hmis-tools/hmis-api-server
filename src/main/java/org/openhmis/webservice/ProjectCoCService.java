



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
import org.openhmis.dto.ProjectCoCDTO;
import org.openhmis.dto.search.ProjectCoCSearchDTO;
import org.openhmis.dto.InventoryDTO;
import org.openhmis.dto.search.InventorySearchDTO;
import org.openhmis.dto.SiteDTO;
import org.openhmis.dto.search.SiteSearchDTO;
import org.openhmis.exception.AccessDeniedException;
import org.openhmis.manager.ProjectCoCManager;
import org.openhmis.manager.InventoryManager;
import org.openhmis.manager.SiteManager;
import org.openhmis.util.Authentication;
import org.openhmis.util.DateParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Path("/project-cocs")
public class ProjectCoCService {
	private static final Logger log = Logger.getLogger(ProjectCoCService.class);
	public ProjectCoCService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ProjectCoCDTO> getProjectCoCs(@HeaderParam("Authorization") String authorization, @BeanParam ProjectCoCSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                List<ProjectCoCDTO> projectCoCDTOs = ProjectCoCManager.getProjectCoCs(searchDTO);
                log.info("GET /project-cocs (" + projectCoCDTOs.size() + " results)");
                return projectCoCDTOs;
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ProjectCoCDTO createProjectCoC(@HeaderParam("Authorization") String authorization, ProjectCoCDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ProjectCoCDTO outputDTO = ProjectCoCManager.addProjectCoC(inputDTO);
                log.info("POST /project-cocs (new id: " + outputDTO.getId() + ")");
		return outputDTO;
	}
	
	@GET
	@Path("/{projectCoCId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ProjectCoCDTO getProjectCoC(@HeaderParam("Authorization") String authorization, @PathParam("projectCoCId") String projectCoCId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
		ProjectCoCDTO outputDTO = ProjectCoCManager.getProjectCoCByProjectCoCId(projectCoCId);
                log.info("GET /cocs/" + projectCoCId);
		return outputDTO;
	}
	
	@PUT
	@Path("/{projectCoCId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ProjectCoCDTO updateCoC(@HeaderParam("Authorization") String authorization, @PathParam("projectCoCId") String projectCoCId, ProjectCoCDTO inputDTO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		inputDTO.setProjectCoCId(projectCoCId);
		
		ProjectCoCDTO outputDTO = ProjectCoCManager.updateProjectCoC(inputDTO);
                log.info("PUT /cocs/" + projectCoCId);
		return outputDTO;
	}
	
	@DELETE
	@Path("/{projectCoCId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteCoC(@HeaderParam("Authorization") String authorization, @PathParam("projectCoCId") String projectCoCId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
                        throw new AccessDeniedException();
		ProjectCoCManager.deleteProjectCoC(projectCoCId);
                log.info("DELETE /cocs/" + projectCoCId);
		return "true";
	}

	/* Inventory Endpoints */
	@GET
	@Path("/{projectCoCId}/inventories")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<InventoryDTO> getInventories(@HeaderParam("Authorization") String authorization, @PathParam("projectCoCId") String projectCoCId, @BeanParam InventorySearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setProjectCocId(projectCoCId);
                List<InventoryDTO> inventoryDTOs = InventoryManager.getInventories(searchDTO);
                log.info("GET /cocs/" + projectCoCId + "/inventories (" + inventoryDTOs.size() + " results)");
                return inventoryDTOs;
	}

	/* Site Endpoints */
	@GET
	@Path("/{projectCoCId}/sites")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<SiteDTO> getSites(@HeaderParam("Authorization") String authorization, @PathParam("projectCoCId") String projectCoCId, @BeanParam SiteSearchDTO searchDTO) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
                        throw new AccessDeniedException();
                searchDTO.setProjectCocId(projectCoCId);
                List<SiteDTO> siteDTOs = SiteManager.getSites(searchDTO);
                log.info("GET /cocs/" + projectCoCId + "/sites (" + siteDTOs.size() + " results)");
                return siteDTOs;
	}

}
