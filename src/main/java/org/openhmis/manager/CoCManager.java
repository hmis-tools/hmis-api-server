package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.dao.TmpProjectCoCDAO;
import org.openhmis.domain.TmpProjectCoC;
import org.openhmis.dto.CoCDTO;

public class CoCManager {
	private static final TmpProjectCoCDAO tmpProjectCoCDAO = new TmpProjectCoCDAO();

	public CoCManager() {}

	public static CoCDTO getCoCByProjectCoCId(String projectCoCId) {
		Integer projectCoCIdInt = Integer.parseInt(projectCoCId);
		TmpProjectCoC tmpProjectCoC= tmpProjectCoCDAO.getTmpProjectCoCByProjectCoCId(projectCoCIdInt);		
		CoCDTO CoCDTO = CoCManager.generateCoCDTO(tmpProjectCoC);
		return CoCDTO;
	}

	public static List<CoCDTO> getCoCsByProjectId(String projectId) {
		List<CoCDTO> coCDTOs = new ArrayList<CoCDTO>();

		// Collect the projects
		List<TmpProjectCoC> tmpProjectCoCs = tmpProjectCoCDAO.getTmpProjectCoCsByProjectId(Integer.parseInt(projectId));

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProjectCoC> iterator = tmpProjectCoCs.iterator(); iterator.hasNext();) {
			TmpProjectCoC tmpProjectCoC = iterator.next();

			CoCDTO coCDTO = CoCManager.generateCoCDTO(tmpProjectCoC);
			coCDTOs.add(coCDTO);
		}
		return coCDTOs;

	}
	
	public static CoCDTO addCoC(CoCDTO inputDTO) {

		// Generate a PathClient from the input
		TmpProjectCoC tmpProjectCoC = CoCManager.generateTmpProjectCoC(inputDTO);
		
		// Set Export fields
		tmpProjectCoC.setDateCreated(new Date());
		tmpProjectCoC.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpProjectCoCDAO.save(tmpProjectCoC);
		inputDTO.setProjectCoCId(tmpProjectCoC.getProjectCoCId().toString());
		
		// Return the resulting VO
		return CoCManager.generateCoCDTO(tmpProjectCoC);
	}
	
	public static CoCDTO updateCoC(CoCDTO inputDTO) {
		// Generate a TmpProject from the input
		TmpProjectCoC tmpProjectCoC = CoCManager.generateTmpProjectCoC(inputDTO);
		tmpProjectCoC.setProjectCoCId(Integer.parseInt(inputDTO.getProjectCoCId()));
		tmpProjectCoC.setDateUpdated(new Date());
		
		// Update the client
		tmpProjectCoCDAO.update(tmpProjectCoC);
		
		// Return the resulting VO
		return CoCManager.generateCoCDTO(tmpProjectCoC);
		
	}
	
	public static boolean deleteCoC(String projectCoCId) {
		TmpProjectCoC tmpProjectCoC = tmpProjectCoCDAO.getTmpProjectCoCByProjectCoCId(Integer.parseInt(projectCoCId));
		tmpProjectCoCDAO.delete(tmpProjectCoC);
		
		return true;
	}
	
	public static CoCDTO generateCoCDTO(TmpProjectCoC tmpProjectCoC) {
		Integer projectCoCId = tmpProjectCoC.getProjectCoCId();
		
		CoCDTO coCDTO = new CoCDTO();
		coCDTO.setProjectCoCId(tmpProjectCoC.getProjectCoCId().toString());
		coCDTO.setProjectId(tmpProjectCoC.getProjectId().toString());
		
		// Universal Data Standard: Project Identifiers (2014, 2.2) 
		coCDTO.setCoCCode(tmpProjectCoC.getCoCcode());

		// Universal Data Standard: Inventories (2014, 2.7)
		coCDTO.setInventories(InventoryManager.getInventoriesByProjectCoCId(projectCoCId.toString()));

		// Universal Data Standard: Sites (2014, 2.8)
		coCDTO.setSites(SiteManager.getSitesByProjectCoCId(projectCoCId.toString()));

		// Export Standard Fields
		coCDTO.setDateCreated(tmpProjectCoC.getDateCreated());
		coCDTO.setDateUpdated(tmpProjectCoC.getDateUpdated());
		
		return coCDTO;
	}

	public static TmpProjectCoC generateTmpProjectCoC(CoCDTO inputDTO) {
		TmpProjectCoC tmpProjectCoC = new TmpProjectCoC();
	
		tmpProjectCoC.setProjectId(Integer.parseInt(inputDTO.getProjectId()));

		// Universal Data Standard: Project Identifiers (2014, 2.2) 
		tmpProjectCoC.setCoCcode(inputDTO.getCoCCode());

		// Export Standard Fields
		tmpProjectCoC.setDateCreated(inputDTO.getDateCreated());
		tmpProjectCoC.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpProjectCoC;

	}
	
}