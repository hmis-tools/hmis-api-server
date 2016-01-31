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
import org.openhmis.dto.ProjectDTO;
import org.openhmis.dto.SiteDTO;
import org.openhmis.manager.CoCManager;
import org.openhmis.manager.FunderManager;
import org.openhmis.manager.InventoryManager;
import org.openhmis.manager.ProjectManager;
import org.openhmis.manager.SiteManager;
import org.openhmis.util.Authentication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/projects")
public class ProjectService {
	private static final ObjectMapper om = new ObjectMapper();

	public ProjectService() {}

	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ProjectDTO> getProjects(@HeaderParam("Authorization") String authorization) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<ProjectDTO> projectDTOs = ProjectManager.getProjects();
		return projectDTOs;
	}
	
	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ProjectDTO createProject(@HeaderParam("Authorization") String authorization, String data) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		// This endpoint takes in a raw json STRING as input.
		// TODO: support the serialization of individual POST parameters
		ProjectDTO inputVO = om.readValue(data, ProjectDTO.class);
		ProjectDTO outputVO = ProjectManager.addProject(inputVO);
		return outputVO;
	}
	
	@GET
	@Path("/{projectId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ProjectDTO getProject(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ProjectDTO projectDTO = ProjectManager.getProjectById(projectId);
		return projectDTO;
	}
	
	@PUT
	@Path("/{projectId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ProjectDTO updateProject(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, String data) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ProjectDTO inputVO = om.readValue(data, ProjectDTO.class);
		inputVO.setProjectId(projectId);
		
		ProjectDTO outputVO = ProjectManager.updateProject(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{projectId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteProject(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ProjectManager.deleteProject(projectId);
		return "true";
	}
	
	/* CoC Endpoints */
	@GET
	@Path("/{projectId}/cocs")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<CoCDTO> getCoCs(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<CoCDTO> coCDTOs = CoCManager.getCoCsByProjectId(projectId);
		return coCDTOs;
	}
	
	@GET
	@Path("/{projectId}/cocs/{coCId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public CoCDTO getCoC(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		CoCDTO coCDTO = CoCManager.getCoCByProjectCoCId(coCId);
		return coCDTO;
	}
	
	@POST
	@Path("/{projectId}/cocs")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public CoCDTO createCoC(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		CoCDTO inputVO = om.readValue(data, CoCDTO.class);
		inputVO.setProjectId(projectId);
		CoCDTO outputVO = CoCManager.addCoC(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{projectId}/cocs/{coCId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public CoCDTO updateCoC(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		CoCDTO inputVO = om.readValue(data, CoCDTO.class);
		inputVO.setProjectId(projectId);
		inputVO.setProjectCoCId(coCId);

		CoCDTO outputVO = CoCManager.updateCoC(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{projectId}/cocs/{coCId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteCoC(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId,  @PathParam("coCId") String coCId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		CoCManager.deleteCoC(coCId);
		return "true";
	}
	
	/* Funder Endpoints */
	@GET
	@Path("/{projectId}/funders")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<FunderDTO> getFunders(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<FunderDTO> funderDTOs = FunderManager.getFundersByProjectId(projectId);
		return funderDTOs;
	}
	
	@GET
	@Path("/{projectId}/funders/{funderId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FunderDTO getFunder(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("funderId") String funderId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		FunderDTO funderDTO = FunderManager.getFunderByProjectFunderId(funderId);
		return funderDTO;
	}
	
	@POST
	@Path("/{projectId}/funders")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FunderDTO createFunder(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		FunderDTO inputVO = om.readValue(data, FunderDTO.class);
		inputVO.setProjectId(projectId);
		FunderDTO outputVO = FunderManager.addFunder(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{projectId}/funders/{funderId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FunderDTO updateFunder(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("funderId") String funderId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		FunderDTO inputVO = om.readValue(data, FunderDTO.class);
		inputVO.setProjectId(projectId);
		inputVO.setFunderId(funderId);

		FunderDTO outputVO = FunderManager.updateFunder(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{projectId}/funders/{funderId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteFunder(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId,  @PathParam("funderId") String funderId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		FunderManager.deleteFunder(funderId);
		return "true";
	}
	
	/* Inventory Endpoints */
	@GET
	@Path("/{projectId}/cocs/{coCId}/inventories")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<InventoryDTO> getInventorys(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<InventoryDTO> inventoryDTOs = InventoryManager.getInventoriesByProjectCoCId(coCId);
		return inventoryDTOs;
	}
	
	@GET
	@Path("/{projectId}/cocs/{coCId}/inventories/{inventoryId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public InventoryDTO getInventory(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("inventoryId") String inventoryId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		InventoryDTO inventoryDTO = InventoryManager.getInventoryByInventoryId(inventoryId);
		return inventoryDTO;
	}
	
	@POST
	@Path("/{projectId}/cocs/{coCId}/inventories")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public InventoryDTO createInventory(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		InventoryDTO inputVO = om.readValue(data, InventoryDTO.class);
		inputVO.setProjectCoCId(coCId);
		InventoryDTO outputVO = InventoryManager.addInventory(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{projectId}/cocs/{coCId}/inventories/{inventoryId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public InventoryDTO updateInventory(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("inventoryId") String inventoryId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		InventoryDTO inputVO = om.readValue(data, InventoryDTO.class);
		inputVO.setProjectCoCId(coCId);
		inputVO.setInventoryId(inventoryId);

		InventoryDTO outputVO = InventoryManager.updateInventory(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{projectId}/cocs/{coCId}/inventories/{inventoryId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteInventory(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("inventoryId") String inventoryId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		InventoryManager.deleteInventory(inventoryId);
		return "true";
	}
	
	/* Site Endpoints */
	@GET
	@Path("/{projectId}/cocs/{coCId}/sites")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<SiteDTO> getSites(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<SiteDTO> siteDTOs = SiteManager.getSitesByProjectCoCId(coCId);
		return siteDTOs;
	}
	
	@GET
	@Path("/{projectId}/cocs/{coCId}/sites/{siteId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SiteDTO getSite(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("siteId") String siteId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		SiteDTO siteDTO = SiteManager.getSiteBySiteId(siteId);
		return siteDTO;
	}
	
	@POST
	@Path("/{projectId}/cocs/{coCId}/sites")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SiteDTO createSite(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		SiteDTO inputVO = om.readValue(data, SiteDTO.class);
		inputVO.setProjectCoCId(coCId);
		SiteDTO outputVO = SiteManager.addSite(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{projectId}/cocs/{coCId}/sites/{siteId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SiteDTO updateSite(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("siteId") String siteId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		SiteDTO inputVO = om.readValue(data, SiteDTO.class);
		inputVO.setProjectCoCId(coCId);
		inputVO.setSiteId(siteId);

		SiteDTO outputVO = SiteManager.updateSite(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{projectId}/cocs/{coCId}/sites/{siteId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteSite(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("siteId") String siteId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		SiteManager.deleteSite(siteId);
		return "true";
	}
}
