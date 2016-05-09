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
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.dto.ClientDTO;
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
import org.openhmis.util.DateParser;

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
	public List<ProjectDTO> getProjects(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<ProjectDTO> projectDTOs = ProjectManager.getProjects();
			return projectDTOs;
		} else {
			List<ProjectDTO> projectDTOs = ProjectManager.getProjectsByUpdateDate(DateParser.parseDate(updatedSince));
			return projectDTOs;
		}
	}
	
	@POST
	@Path("/")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ProjectDTO createProject(@HeaderParam("Authorization") String authorization, ProjectDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
			throw new Error("You are not authorized to access this content");
		ProjectDTO outputVO = ProjectManager.addProject(inputVO);
		return outputVO;
	}
	
	@GET
	@Path("/{projectId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ProjectDTO getProject(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
			throw new Error("You are not authorized to access this content");
		ProjectDTO projectDTO = ProjectManager.getProjectById(projectId);
		return projectDTO;
	}
	
	@PUT
	@Path("/{projectId}")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ProjectDTO updateProject(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, ProjectDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
			throw new Error("You are not authorized to access this content");
		inputVO.setProjectId(projectId);
		
		ProjectDTO outputVO = ProjectManager.updateProject(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{projectId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteProject(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.WRITE))
			throw new Error("You are not authorized to access this content");
		ProjectManager.deleteProject(projectId);
		return "true";
	}
	
	/* CoC Endpoints */
	@GET
	@Path("/{projectId}/cocs")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<CoCDTO> getCoCs(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<CoCDTO> coCDTOs = CoCManager.getCoCsByProjectId(projectId);
			return coCDTOs;
		} else {
			List<CoCDTO> coCDTOs = CoCManager.getCoCsByProjectId(projectId, DateParser.parseDate(updatedSince));
			return coCDTOs;
		}
	}
	
	/* Funder Endpoints */
	@GET
	@Path("/{projectId}/funders")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<FunderDTO> getFunders(@HeaderParam("Authorization") String authorization, @PathParam("projectId") String projectId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization, Authentication.READ))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<FunderDTO> funderDTOs = FunderManager.getFundersByProjectId(projectId);
			return funderDTOs;
		} else {
			List<FunderDTO> funderDTOs = FunderManager.getFundersByProjectId(projectId, DateParser.parseDate(updatedSince));
			return funderDTOs;
		}
	}
}
