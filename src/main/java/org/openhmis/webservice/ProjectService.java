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
import org.openhmis.dto.ProjectDTO;
import org.openhmis.manager.ProjectManager;

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
}
