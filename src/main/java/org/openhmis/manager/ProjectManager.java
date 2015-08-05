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

public class ProjectManager {
	private static final TmpProjectDAO tmpProjectDAO = new TmpProjectDAO();

	public ProjectManager() {}

	public static ProjectDTO getProjectById(String projectId) {
		ProjectDTO projectDTO = ProjectManager.generateProjectDTO(tmpProjectDAO.getTmpProjectByProjectId(Integer.parseInt(projectId)));
		return projectDTO;
	}

	public static List<ProjectDTO> getProjects() {
		List<ProjectDTO> projectDTOs = new ArrayList<ProjectDTO>();

		// Collect the projects
		List<TmpProject> tmpProjects = tmpProjectDAO.getTmpProjects();

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProject> iterator = tmpProjects.iterator(); iterator.hasNext();) {
			TmpProject tmpProject = iterator.next();
//			Integer projectId = tmpProject.getProjectId();
//			List<PathClientRace> pathRaces = pathClientRaceDAO.getPathRacesByClientKey(clientKey);
//			PathClientVeteranInfo pathVeteranInfo = pathClientVeteranInfoDAO.getPathVeteranInfoByClientKey(clientKey);

			ProjectDTO projectDTO = ProjectManager.generateProjectDTO(tmpProject);
			projectDTOs.add(projectDTO);
		}
		return projectDTOs;
	}
	
	public static ProjectDTO addProject(ProjectDTO inputDTO) {
		
		// Generate a PathClient from the input
		TmpProject tmpProject = ProjectManager.generateTmpProject(inputDTO);
		
		// Set Export fields
		tmpProject.setDateCreated(new Date());
		tmpProject.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpProjectDAO.save(tmpProject);
		inputDTO.setProjectId(tmpProject.getProjectId().toString());
		
		// Save the races
//		List<PathClientRace> pathRaces = ClientManager.generatePathClientRaces(inputDTO);
//		for (Iterator<PathClientRace> iterator = pathRaces.iterator(); iterator.hasNext();) {
//			PathClientRace pathRace = iterator.next();
//			pathRace.setUpdateTimestamp(new Date());
//			pathClientRaceDAO.save(pathRace);
//		}
//
//		// Save Veteran Info
//		PathClientVeteranInfo pathVeteranInfo = ClientManager.generatePathVeteranInfo(inputDTO);
//		pathVeteranInfo.setUpdateTimestamp(new Date());
//		pathVeteranInfo.setClientKey(pathClient.getClientKey());
//		pathClientVeteranInfoDAO.save(pathVeteranInfo);
		
		// Return the resulting VO
		return ProjectManager.generateProjectDTO(tmpProject);
	}
	
	public static ProjectDTO updateProject(ProjectDTO inputDTO) {

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
		TmpProject tmpProject = tmpProjectDAO.getTmpProjectByProjectId(Integer.parseInt(projectId));
		tmpProjectDAO.delete(tmpProject);
		
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