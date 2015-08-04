package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.ProjectDTO;

public class ProjectManager {

	public ProjectManager() {}

	public ProjectDTO getProjectById(String projectId) {
		ProjectDTO projectDTO = new ProjectDTO();
		return projectDTO;
	}

	public List<ProjectDTO> getProjects() {
		List<ProjectDTO> projectDTOs = new ArrayList<ProjectDTO>();
		return projectDTOs;
	}
	
	public ProjectDTO addProject(ProjectDTO inputVO) {
		return inputVO;
	}
	
	public ProjectDTO updateProject(ProjectDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteProject(String projectId) {
		return false;
	}
	
	public static ProjectDTO generateProjectVO() {
		ProjectDTO projectDTO = new ProjectDTO();
		
		return projectDTO;
	}
	
}