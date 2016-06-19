package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ProjectTargetPopulation;
import org.openhmis.code.ProjectTrackingMethod;
import org.openhmis.code.ProjectType;
import org.openhmis.code.YesNo;
import org.openhmis.dao.TmpProjectDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.dto.ProjectDTO;
import org.openhmis.dto.search.ProjectSearchDTO;
import org.openhmis.dto.search.CoCSearchDTO;
import org.openhmis.dto.search.FunderSearchDTO;
import org.openhmis.exception.InvalidParameterException;

public class ProjectManager {
	private TmpProjectDAO tmpProjectDAO;

	public ProjectManager() {
		this.tmpProjectDAO = new TmpProjectDAO();
	}
	
	public ProjectManager(TmpProjectDAO tmpProjectDAO) {
		this.tmpProjectDAO = tmpProjectDAO;
	}

	public ProjectDTO getProjectById(String projectId) {
		ProjectDTO projectDTO = ProjectManager.generateProjectDTO(tmpProjectDAO.getTmpProjectById(Integer.parseInt(projectId)));
		return projectDTO;
	}

	public List<ProjectDTO> getProjects(ProjectSearchDTO searchDTO) {
		List<ProjectDTO> projectDTOs = new ArrayList<ProjectDTO>();

		// Collect the projects
		List<TmpProject> tmpProjects = tmpProjectDAO.getTmpProjects(searchDTO);

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProject> iterator = tmpProjects.iterator(); iterator.hasNext();) {
			TmpProject tmpProject = iterator.next();
			ProjectDTO projectDTO = ProjectManager.generateProjectDTO(tmpProject);
			projectDTOs.add(projectDTO);
		}
		return projectDTOs;
	}

	public ProjectDTO addProject(ProjectDTO inputDTO) {
		validateProject(inputDTO);
		
		// Generate a PathClient from the input
		TmpProject tmpProject = ProjectManager.generateTmpProject(inputDTO);
		
		// Set Export fields
		tmpProject.setDateCreated(new Date());
		tmpProject.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpProjectDAO.save(tmpProject);
		inputDTO.setProjectId(tmpProject.getProjectId().toString());
				
		// Return the resulting VO
		return ProjectManager.generateProjectDTO(tmpProject);
	}
	
	public ProjectDTO updateProject(ProjectDTO inputDTO) {
		validateProject(inputDTO);

		// Generate a TmpProject from the input
		TmpProject tmpProject = ProjectManager.generateTmpProject(inputDTO);
		tmpProject.setProjectId(Integer.parseInt(inputDTO.getProjectId()));
		tmpProject.setDateUpdated(new Date());
		
		// Update the client
		tmpProjectDAO.update(tmpProject);
		
		// Return the resulting VO
		return ProjectManager.generateProjectDTO(tmpProject);
		
	}
	
	public boolean deleteProject(String projectId) {
		TmpProject tmpProject = tmpProjectDAO.getTmpProjectById(Integer.parseInt(projectId));
		tmpProjectDAO.delete(tmpProject);
		
		return true;
	}
	
}
