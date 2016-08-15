package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.dao.TmpProjectContinuumDAO;
import org.openhmis.domain.TmpProjectContinuum;
import org.openhmis.dto.ClientDTO;
import org.openhmis.dto.ProjectCoCDTO;
import org.openhmis.dto.search.CoCSearchDTO;
import org.openhmis.dto.search.InventorySearchDTO;
import org.openhmis.dto.search.ProjectCoCSearchDTO;
import org.openhmis.dto.search.SiteSearchDTO;

public class ProjectCoCManager {
	private static final TmpProjectContinuumDAO tmpProjectContinuumDAO = new TmpProjectContinuumDAO();

	public ProjectCoCManager() {}

	public static ProjectCoCDTO getProjectCoCByProjectCoCId(String projectCoCId) {
		Integer projectCoCIdInt = Integer.parseInt(projectCoCId);
		TmpProjectContinuum tmpProjectContinuum= tmpProjectContinuumDAO.getTmpProjectContinuumById(projectCoCIdInt);		
		ProjectCoCDTO ProjectCoCDTO = ProjectCoCManager.generateProjectCoCDTO(tmpProjectContinuum);
		return ProjectCoCDTO;
	}

	public static List<ProjectCoCDTO> getProjectCoCs(ProjectCoCSearchDTO searchDTO) {
		List<ProjectCoCDTO> projectCoCDTOs = new ArrayList<ProjectCoCDTO>();

		// Collect the projects
		List<TmpProjectContinuum> tmpProjectContinuums = tmpProjectContinuumDAO.getTmpProjectContinuums(searchDTO);

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProjectContinuum> iterator = tmpProjectContinuums.iterator(); iterator.hasNext();) {
			TmpProjectContinuum tmpProjectContinuum = iterator.next();

			ProjectCoCDTO projectCoCDTO = ProjectCoCManager.generateProjectCoCDTO(tmpProjectContinuum);
			projectCoCDTOs.add(projectCoCDTO);
		}
		return projectCoCDTOs;

	}


	
	public static ProjectCoCDTO addProjectCoC(ProjectCoCDTO inputDTO) {

		// Validate the ProjectCoC
		// TODO: this should return a list of errors that get wrapped appropriately
		if(!validateProjectCoC(inputDTO))
			return null;

		// Generate a ProjectCoC from the input
		TmpProjectContinuum tmpProjectContinuum = ProjectCoCManager.generateTmpProjectContinuum(inputDTO);
		
		// Set Export fields
		tmpProjectContinuum.setDateCreated(new Date());
		tmpProjectContinuum.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpProjectContinuumDAO.save(tmpProjectContinuum);
		inputDTO.setProjectCoCId(tmpProjectContinuum.getProjectCocId().toString());
		
		// Return the resulting VO
		return ProjectCoCManager.generateProjectCoCDTO(tmpProjectContinuum);
	}
	
	public static ProjectCoCDTO updateProjectCoC(ProjectCoCDTO inputDTO) {
		// Generate a TmpProject from the input
		TmpProjectContinuum tmpProjectContinuum = ProjectCoCManager.generateTmpProjectContinuum(inputDTO);

		// Validate the ProjectCoC
		// TODO: this should return a list of errors that get wrapped appropriately
		if(!validateProjectCoC(inputDTO))
			return null;
		
		tmpProjectContinuum.setProjectCocId(Integer.parseInt(inputDTO.getProjectCoCId()));
		tmpProjectContinuum.setDateUpdated(new Date());
		
		// Update the client
		tmpProjectContinuumDAO.update(tmpProjectContinuum);
		
		// Return the resulting VO
		return ProjectCoCManager.generateProjectCoCDTO(tmpProjectContinuum);
		
	}
	
	public static boolean deleteProjectCoC(String projectCoCId) {
		TmpProjectContinuum tmpProjectContinuum = tmpProjectContinuumDAO.getTmpProjectContinuumById(Integer.parseInt(projectCoCId));
		tmpProjectContinuumDAO.delete(tmpProjectContinuum);
		
		return true;
	}
	
	public static boolean validateProjectCoC(ProjectCoCDTO inputDTO) {
		// There really aren't fields to validate right now.
		return true;
	}

	
	public static ProjectCoCDTO generateProjectCoCDTO(TmpProjectContinuum tmpProjectContinuum) {
		Integer projectCoCId = tmpProjectContinuum.getProjectCocId();
		
		ProjectCoCDTO projectCoCDTO = new ProjectCoCDTO();
		InventorySearchDTO inventorySearchDTO = new InventorySearchDTO();
                SiteSearchDTO siteSearchDTO = new SiteSearchDTO();
                projectCoCDTO.setProjectCoCId(tmpProjectContinuum.getProjectCocId().toString());
		projectCoCDTO.setProjectId(tmpProjectContinuum.getProjectId().toString());
                inventorySearchDTO.setProjectCocId(projectCoCId.toString());
                siteSearchDTO.setProjectCocId(projectCoCId.toString()); 
		
		// Universal Data Standard: Project Identifiers (2014, 2.2) 
		projectCoCDTO.setCoCCode(tmpProjectContinuum.getCocCode());

		// Universal Data Standard: Inventories (2014, 2.7)
		projectCoCDTO.setInventories(InventoryManager.getInventories(inventorySearchDTO));

		// Universal Data Standard: Sites (2014, 2.8)
		projectCoCDTO.setSites(SiteManager.getSites(siteSearchDTO));

		// Export Standard Fields
		projectCoCDTO.setDateCreated(tmpProjectContinuum.getDateCreated());
		projectCoCDTO.setDateUpdated(tmpProjectContinuum.getDateUpdated());
		
		return projectCoCDTO;
	}

	public static TmpProjectContinuum generateTmpProjectContinuum(ProjectCoCDTO inputDTO) {
		TmpProjectContinuum tmpProjectContinuum = new TmpProjectContinuum();
	
		tmpProjectContinuum.setProjectId(Integer.parseInt(inputDTO.getProjectId()));

		// Universal Data Standard: Project Identifiers (2014, 2.2) 
		tmpProjectContinuum.setCocCode(inputDTO.getCoCCode());

		// Export Standard Fields
		tmpProjectContinuum.setDateCreated(inputDTO.getDateCreated());
		tmpProjectContinuum.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpProjectContinuum;

	}
	
}
