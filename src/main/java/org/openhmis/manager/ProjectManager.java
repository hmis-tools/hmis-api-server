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
import org.openhmis.exception.InvalidParameterException;

public class ProjectManager {
	private static final TmpProjectDAO tmpProjectDAO = new TmpProjectDAO();

	public ProjectManager() {}

	public static ProjectDTO getProjectById(String projectId) {
		ProjectDTO projectDTO = ProjectManager.generateProjectDTO(tmpProjectDAO.getTmpProjectById(Integer.parseInt(projectId)));
		return projectDTO;
	}

	public static List<ProjectDTO> getProjects(ProjectSearchDTO searchDTO) {
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

	public static List<ProjectDTO> getProjectsByUpdateDate(Date updateDate) {
		List<ProjectDTO> projectDTOs = new ArrayList<ProjectDTO>();

		// Collect the projects
		List<TmpProject> tmpProjects = tmpProjectDAO.getTmpProjectsByUpdateDate(updateDate);

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProject> iterator = tmpProjects.iterator(); iterator.hasNext();) {
			TmpProject tmpProject = iterator.next();
			ProjectDTO projectDTO = ProjectManager.generateProjectDTO(tmpProject);
			projectDTOs.add(projectDTO);
		}
		return projectDTOs;
	}
	
	public static ProjectDTO addProject(ProjectDTO inputDTO) {
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
	
	public static ProjectDTO updateProject(ProjectDTO inputDTO) {
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
	
	public static boolean deleteProject(String projectId) {
		TmpProject tmpProject = tmpProjectDAO.getTmpProjectById(Integer.parseInt(projectId));
		tmpProjectDAO.delete(tmpProject);
		
		return true;
	}
	
	public static boolean validateProject(ProjectDTO inputDTO) {
		
		// Universal Data Standard: Project Type (2014, 2.4)
		if(inputDTO.getContinuumProject() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.4.1 continuumProject", "continuumProject is set to an unknown code");
		if(inputDTO.getProjectType() == ProjectType.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.4.2 projectType", "projectType is set to an unknown code");
		if(inputDTO.getResidentialAffiliation() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.4.3 residentialAffiliation", "residentialAffiliation is set to an unknown code");

		if(inputDTO.getContinuumProject() != YesNo.YES
		&& inputDTO.getProjectType() == null)
			throw new InvalidParameterException("HUD 2.4.2 projectType", "projectType may only be null if continuumProject is 1");
		
		if(inputDTO.getProjectType() != ProjectType.SERVICES_ONLY
		&& inputDTO.getResidentialAffiliation() != null)
			throw new InvalidParameterException("HUD 2.4.3 residentialAffiliation", "residentialAffiliation must be null if projectType is not 6");
		
		// Universal Data Standard: Project Type (2014, 2.5)
		if(inputDTO.getTrackingMethod() == ProjectTrackingMethod.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.5.1 trackingMethod", "trackingMethod is set to an unknown code");
			
		if(inputDTO.getProjectType() != ProjectType.EMERGENCY_SHELTER
		&& inputDTO.getTrackingMethod() != null)
			throw new InvalidParameterException("HUD 2.5.1 trackingMethod", "trackingMethod must be null if projectType is not 1");

		// Universal Data Standard: Target Population (2014 2.9)
		if(inputDTO.getTargetPopulation() == ProjectTargetPopulation.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.9.1 targetPopulation", "targetPopulation is set to an unknown code");
		
		return true;
	}
	
	public static ProjectDTO generateProjectDTO(TmpProject tmpProject) {
		Integer projectId = tmpProject.getProjectId();

		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectId(tmpProject.getProjectId().toString());
	
		// Universal Data Standard: Project Identifiers (2014, 2.2) 
		projectDTO.setProjectName(tmpProject.getProjectName());
		
		// Universal Data Standard: Project CoC (2014, 2.3)
		projectDTO.setProjectCoCs(CoCManager.getCoCsByProjectId(projectId.toString()));

		// Universal Data Standard: Project Type (2014, 2.4)
		projectDTO.setContinuumProject(YesNo.valueByCode(tmpProject.getContinuumProject()));
		projectDTO.setProjectType(ProjectType.valueByCode(tmpProject.getProjectType()));
		projectDTO.setResidentialAffiliation(YesNo.valueByCode(tmpProject.getResidentialAffiliation()));
		projectDTO.setResProjectId(tmpProject.getResProjectId().toString());

		// Universal Data Standard: Project Type (2014, 2.5)
		projectDTO.setTrackingMethod(ProjectTrackingMethod.valueByCode(tmpProject.getTrackingMethod()));

		// Universal Data Standard: Funders (2014, 2.6)
		projectDTO.setFunders(FunderManager.getFundersByProjectId(projectId.toString()));

		// Universal Data Standard: Target Population (2014 2.9)
		projectDTO.setTargetPopulation(ProjectTargetPopulation.valueByCode(tmpProject.getTargetPopulation()));

		// Export Standard Fields
		projectDTO.setDateCreated(tmpProject.getDateCreated());
		projectDTO.setDateUpdated(tmpProject.getDateUpdated());
		
		return projectDTO;
	}
	
	public static TmpProject generateTmpProject(ProjectDTO inputDTO) {
		TmpProject tmpProject = new TmpProject();
		
		tmpProject.setProjectName(inputDTO.getProjectName());

		// Universal Data Standard: Project Type (2014, 2.4)
		tmpProject.setContinuumProject(inputDTO.getContinuumProject().getCode());
		tmpProject.setProjectType(inputDTO.getProjectType().getCode());
		tmpProject.setResidentialAffiliation(inputDTO.getResidentialAffiliation().getCode());
		tmpProject.setResProjectId(Integer.parseInt(inputDTO.getResProjectId()));

		// Universal Data Standard: Project Type (2014, 2.5)
		tmpProject.setTrackingMethod(inputDTO.getTrackingMethod().getCode());

		// Universal Data Standard: Target Population (2014 2.9)
		tmpProject.setTargetPopulation(inputDTO.getTargetPopulation().getCode());

		// Export Standard Fields
		tmpProject.setDateCreated(inputDTO.getDateCreated());
		tmpProject.setDateUpdated(inputDTO.getDateUpdated());
		
		
		return tmpProject;
	}
	
}
