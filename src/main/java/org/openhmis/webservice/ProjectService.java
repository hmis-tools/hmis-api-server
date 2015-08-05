package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
	@Produces({MediaType.APPLICATION_JSON})
	public String getProjects() throws JsonProcessingException {
		List<ProjectDTO> projectDTOs = ProjectManager.getProjects();
		return om.writeValueAsString(projectDTOs);
	}
	
	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public String createProject(String data) throws JsonParseException, JsonMappingException, IOException {
		// This endpoint takes in a raw json STRING as input.
		// TODO: support the serialization of individual POST parameters
		ProjectDTO inputVO = om.readValue(data, ProjectDTO.class);
		ProjectDTO outputVO = ProjectManager.addProject(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@GET
	@Path("/{projectId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getProject(@PathParam("projectId") String projectId) throws JsonProcessingException {
		ProjectDTO projectDTO = ProjectManager.getProjectById(projectId);
		return om.writeValueAsString(projectDTO);
	}
	
	@PUT
	@Path("/{projectId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateProject(@PathParam("projectId") String projectId, String data) throws JsonParseException, JsonMappingException, IOException {
		ProjectDTO inputVO = om.readValue(data, ProjectDTO.class);
		inputVO.setProjectId(projectId);
		
		ProjectDTO outputVO = ProjectManager.updateProject(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{projectId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteProject(@PathParam("projectId") String projectId) throws JsonParseException, JsonMappingException, IOException {
		ProjectManager.deleteProject(projectId);
		return "true";
	}
	
	/* CoC Endpoints */
	@GET
	@Path("/{projectId}/cocs")
	@Produces({MediaType.APPLICATION_JSON})
	public String getCoCs(@PathParam("projectId") String projectId) throws JsonProcessingException {
		List<CoCDTO> coCDTOs = CoCManager.getCoCsByProjectId(projectId);
		return om.writeValueAsString(coCDTOs);
	}
	
	@GET
	@Path("/{projectId}/cocs/{coCId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getCoC(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId) throws JsonProcessingException {
		CoCDTO coCDTO = CoCManager.getCoCByProjectCoCId(coCId);
		return om.writeValueAsString(coCDTO);
	}
	
	@POST
	@Path("/{projectId}/cocs")
	@Produces({MediaType.APPLICATION_JSON})
	public String createCoC(@PathParam("projectId") String projectId, String data) throws IOException {
		CoCDTO inputVO = om.readValue(data, CoCDTO.class);
		inputVO.setProjectId(projectId);
		CoCDTO outputVO = CoCManager.addCoC(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{projectId}/cocs/{coCId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateCoC(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId, String data) throws IOException {
		CoCDTO inputVO = om.readValue(data, CoCDTO.class);
		inputVO.setProjectId(projectId);
		inputVO.setProjectCoCId(coCId);

		CoCDTO outputVO = CoCManager.updateCoC(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{projectId}/cocs/{coCId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteCoC(@PathParam("projectId") String projectId,  @PathParam("coCId") String coCId) throws JsonParseException, JsonMappingException, IOException {
		CoCManager.deleteCoC(coCId);
		return "true";
	}
	
	/* Funder Endpoints */
	@GET
	@Path("/{projectId}/funders")
	@Produces({MediaType.APPLICATION_JSON})
	public String getFunders(@PathParam("projectId") String projectId) throws JsonProcessingException {
		List<FunderDTO> funderDTOs = FunderManager.getFundersByProjectId(projectId);
		return om.writeValueAsString(funderDTOs);
	}
	
	@GET
	@Path("/{projectId}/funders/{funderId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getFunder(@PathParam("projectId") String projectId, @PathParam("funderId") String funderId) throws JsonProcessingException {
		FunderDTO funderDTO = FunderManager.getFunderByProjectFunderId(funderId);
		return om.writeValueAsString(funderDTO);
	}
	
	@POST
	@Path("/{projectId}/funders")
	@Produces({MediaType.APPLICATION_JSON})
	public String createFunder(@PathParam("projectId") String projectId, String data) throws IOException {
		FunderDTO inputVO = om.readValue(data, FunderDTO.class);
		inputVO.setProjectId(projectId);
		FunderDTO outputVO = FunderManager.addFunder(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{projectId}/funders/{funderId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateFunder(@PathParam("projectId") String projectId, @PathParam("funderId") String funderId, String data) throws IOException {
		FunderDTO inputVO = om.readValue(data, FunderDTO.class);
		inputVO.setProjectId(projectId);
		inputVO.setFunderId(funderId);

		FunderDTO outputVO = FunderManager.updateFunder(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{projectId}/funders/{funderId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteFunder(@PathParam("projectId") String projectId,  @PathParam("funderId") String funderId) throws JsonParseException, JsonMappingException, IOException {
		FunderManager.deleteFunder(funderId);
		return "true";
	}
	
	/* Inventory Endpoints */
	@GET
	@Path("/{projectId}/cocs/{coCId}/inventories")
	@Produces({MediaType.APPLICATION_JSON})
	public String getInventorys(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId) throws JsonProcessingException {
		List<InventoryDTO> inventoryDTOs = InventoryManager.getInventoriesByProjectCoCId(coCId);
		return om.writeValueAsString(inventoryDTOs);
	}
	
	@GET
	@Path("/{projectId}/cocs/{coCId}/inventories/{inventoryId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getInventory(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("inventoryId") String inventoryId) throws JsonProcessingException {
		InventoryDTO inventoryDTO = InventoryManager.getInventoryByInventoryId(inventoryId);
		return om.writeValueAsString(inventoryDTO);
	}
	
	@POST
	@Path("/{projectId}/cocs/{coCId}/inventories")
	@Produces({MediaType.APPLICATION_JSON})
	public String createInventory(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId, String data) throws IOException {
		InventoryDTO inputVO = om.readValue(data, InventoryDTO.class);
		inputVO.setProjectCoCId(coCId);
		InventoryDTO outputVO = InventoryManager.addInventory(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{projectId}/cocs/{coCId}/inventories/{inventoryId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateInventory(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("inventoryId") String inventoryId, String data) throws IOException {
		InventoryDTO inputVO = om.readValue(data, InventoryDTO.class);
		inputVO.setProjectCoCId(coCId);
		inputVO.setInventoryId(inventoryId);

		InventoryDTO outputVO = InventoryManager.updateInventory(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{projectId}/cocs/{coCId}/inventories/{inventoryId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteInventory(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("inventoryId") String inventoryId) throws JsonParseException, JsonMappingException, IOException {
		InventoryManager.deleteInventory(inventoryId);
		return "true";
	}
	
	/* Site Endpoints */
	@GET
	@Path("/{projectId}/cocs/{coCId}/sites")
	@Produces({MediaType.APPLICATION_JSON})
	public String getSites(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId) throws JsonProcessingException {
		List<SiteDTO> siteDTOs = SiteManager.getSitesByProjectCoCId(coCId);
		return om.writeValueAsString(siteDTOs);
	}
	
	@GET
	@Path("/{projectId}/cocs/{coCId}/sites/{siteId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getSite(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("siteId") String siteId) throws JsonProcessingException {
		SiteDTO siteDTO = SiteManager.getSiteBySiteId(siteId);
		return om.writeValueAsString(siteDTO);
	}
	
	@POST
	@Path("/{projectId}/cocs/{coCId}/sites")
	@Produces({MediaType.APPLICATION_JSON})
	public String createSite(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId, String data) throws IOException {
		SiteDTO inputVO = om.readValue(data, SiteDTO.class);
		inputVO.setProjectCoCId(coCId);
		SiteDTO outputVO = SiteManager.addSite(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{projectId}/cocs/{coCId}/sites/{siteId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateSite(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("siteId") String siteId, String data) throws IOException {
		SiteDTO inputVO = om.readValue(data, SiteDTO.class);
		inputVO.setProjectCoCId(coCId);
		inputVO.setSiteId(siteId);

		SiteDTO outputVO = SiteManager.updateSite(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{projectId}/cocs/{coCId}/sites/{siteId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteSite(@PathParam("projectId") String projectId, @PathParam("coCId") String coCId, @PathParam("siteId") String siteId) throws JsonParseException, JsonMappingException, IOException {
		SiteManager.deleteSite(siteId);
		return "true";
	}
}
