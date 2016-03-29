package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.dao.TmpProjectContinuumDAO;
import org.openhmis.domain.TmpProjectContinuum;
import org.openhmis.dto.CoCDTO;

public class CoCManager {
	private static final TmpProjectContinuumDAO tmpProjectContinuumDAO = new TmpProjectContinuumDAO();

	public CoCManager() {}

	public static CoCDTO getCoCByProjectCoCId(String projectCoCId) {
		Integer projectCoCIdInt = Integer.parseInt(projectCoCId);
		TmpProjectContinuum tmpProjectContinuum= tmpProjectContinuumDAO.getTmpProjectContinuumById(projectCoCIdInt);		
		CoCDTO CoCDTO = CoCManager.generateCoCDTO(tmpProjectContinuum);
		return CoCDTO;
	}

	public static List<CoCDTO> getCoCs() {
		List<CoCDTO> coCDTOs = new ArrayList<CoCDTO>();

		// Collect the projects
		List<TmpProjectContinuum> tmpProjectContinuums = tmpProjectContinuumDAO.getTmpProjectContinuums();

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProjectContinuum> iterator = tmpProjectContinuums.iterator(); iterator.hasNext();) {
			TmpProjectContinuum tmpProjectContinuum = iterator.next();

			CoCDTO coCDTO = CoCManager.generateCoCDTO(tmpProjectContinuum);
			coCDTOs.add(coCDTO);
		}
		return coCDTOs;

	}

	public static List<CoCDTO> getCoCs(Date updateDate) {
		List<CoCDTO> coCDTOs = new ArrayList<CoCDTO>();

		// Collect the projects
		List<TmpProjectContinuum> tmpProjectContinuums = tmpProjectContinuumDAO.getTmpProjectContinuums(updateDate);

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProjectContinuum> iterator = tmpProjectContinuums.iterator(); iterator.hasNext();) {
			TmpProjectContinuum tmpProjectContinuum = iterator.next();

			CoCDTO coCDTO = CoCManager.generateCoCDTO(tmpProjectContinuum);
			coCDTOs.add(coCDTO);
		}
		return coCDTOs;

	}

	public static List<CoCDTO> getCoCsByProjectId(String projectId) {
		List<CoCDTO> coCDTOs = new ArrayList<CoCDTO>();

		// Collect the projects
		List<TmpProjectContinuum> tmpProjectContinuums = tmpProjectContinuumDAO.getTmpProjectContinuumsByProjectId(Integer.parseInt(projectId));

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProjectContinuum> iterator = tmpProjectContinuums.iterator(); iterator.hasNext();) {
			TmpProjectContinuum tmpProjectContinuum = iterator.next();

			CoCDTO coCDTO = CoCManager.generateCoCDTO(tmpProjectContinuum);
			coCDTOs.add(coCDTO);
		}
		return coCDTOs;

	}

	public static List<CoCDTO> getCoCsByProjectId(String projectId, Date updateDate) {
		List<CoCDTO> coCDTOs = new ArrayList<CoCDTO>();

		// Collect the projects
		List<TmpProjectContinuum> tmpProjectContinuums = tmpProjectContinuumDAO.getTmpProjectContinuumsByProjectId(Integer.parseInt(projectId), updateDate);

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProjectContinuum> iterator = tmpProjectContinuums.iterator(); iterator.hasNext();) {
			TmpProjectContinuum tmpProjectContinuum = iterator.next();

			CoCDTO coCDTO = CoCManager.generateCoCDTO(tmpProjectContinuum);
			coCDTOs.add(coCDTO);
		}
		return coCDTOs;

	}
	
	public static CoCDTO addCoC(CoCDTO inputDTO) {

		// Generate a PathClient from the input
		TmpProjectContinuum tmpProjectContinuum = CoCManager.generateTmpProjectContinuum(inputDTO);
		
		// Set Export fields
		tmpProjectContinuum.setDateCreated(new Date());
		tmpProjectContinuum.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpProjectContinuumDAO.save(tmpProjectContinuum);
		inputDTO.setProjectCoCId(tmpProjectContinuum.getProjectCocId().toString());
		
		// Return the resulting VO
		return CoCManager.generateCoCDTO(tmpProjectContinuum);
	}
	
	public static CoCDTO updateCoC(CoCDTO inputDTO) {
		// Generate a TmpProject from the input
		TmpProjectContinuum tmpProjectContinuum = CoCManager.generateTmpProjectContinuum(inputDTO);
		tmpProjectContinuum.setProjectCocId(Integer.parseInt(inputDTO.getProjectCoCId()));
		tmpProjectContinuum.setDateUpdated(new Date());
		
		// Update the client
		tmpProjectContinuumDAO.update(tmpProjectContinuum);
		
		// Return the resulting VO
		return CoCManager.generateCoCDTO(tmpProjectContinuum);
		
	}
	
	public static boolean deleteCoC(String projectCoCId) {
		TmpProjectContinuum tmpProjectContinuum = tmpProjectContinuumDAO.getTmpProjectContinuumById(Integer.parseInt(projectCoCId));
		tmpProjectContinuumDAO.delete(tmpProjectContinuum);
		
		return true;
	}
	
	public static CoCDTO generateCoCDTO(TmpProjectContinuum tmpProjectContinuum) {
		Integer projectCoCId = tmpProjectContinuum.getProjectCocId();
		
		CoCDTO coCDTO = new CoCDTO();
		coCDTO.setProjectCoCId(tmpProjectContinuum.getProjectCocId().toString());
		coCDTO.setProjectId(tmpProjectContinuum.getProjectId().toString());
		
		// Universal Data Standard: Project Identifiers (2014, 2.2) 
		coCDTO.setCoCCode(tmpProjectContinuum.getCocCode());

		// Universal Data Standard: Inventories (2014, 2.7)
		coCDTO.setInventories(InventoryManager.getInventoriesByProjectCoCId(projectCoCId.toString()));

		// Universal Data Standard: Sites (2014, 2.8)
		coCDTO.setSites(SiteManager.getSitesByProjectCoCId(projectCoCId.toString()));

		// Export Standard Fields
		coCDTO.setDateCreated(tmpProjectContinuum.getDateCreated());
		coCDTO.setDateUpdated(tmpProjectContinuum.getDateUpdated());
		
		return coCDTO;
	}

	public static TmpProjectContinuum generateTmpProjectContinuum(CoCDTO inputDTO) {
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