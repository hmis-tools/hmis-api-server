package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.dao.TmpProjectContinuumDAO;
import org.openhmis.domain.TmpProjectContinuum;
import org.openhmis.dto.ClientDTO;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.search.CoCSearchDTO;
import org.openhmis.dto.search.InventorySearchDTO;
import org.openhmis.dto.search.SiteSearchDTO;

public class CoCManager {
	private TmpProjectContinuumDAO tmpProjectContinuumDAO;

	public CoCManager() {
		this.tmpProjectContinuumDAO = new TmpProjectContinuumDAO();
	}

	public CoCManager(TmpProjectContinuumDAO tmpProjectContinuumDAO) {
		this.tmpProjectContinuumDAO = tmpProjectContinuumDAO;
	}

	public CoCDTO getCoCByProjectCoCId(String projectCoCId) {
		Integer projectCoCIdInt = Integer.parseInt(projectCoCId);
		TmpProjectContinuum tmpProjectContinuum= tmpProjectContinuumDAO.getTmpProjectContinuumById(projectCoCIdInt);		
		CoCDTO CoCDTO = CoCManager.generateCoCDTO(tmpProjectContinuum);
		return CoCDTO;
	}

	public List<CoCDTO> getCoCs(CoCSearchDTO searchDTO) {
		List<CoCDTO> coCDTOs = new ArrayList<CoCDTO>();

		// Collect the projects
		List<TmpProjectContinuum> tmpProjectContinuums = tmpProjectContinuumDAO.getTmpProjectContinuums(searchDTO);

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProjectContinuum> iterator = tmpProjectContinuums.iterator(); iterator.hasNext();) {
			TmpProjectContinuum tmpProjectContinuum = iterator.next();

			CoCDTO coCDTO = CoCManager.generateCoCDTO(tmpProjectContinuum);
			coCDTOs.add(coCDTO);
		}
		return coCDTOs;

	}
	
	public CoCDTO addCoC(CoCDTO inputDTO) {

		// Validate the CoC
		// TODO: this should return a list of errors that get wrapped appropriately
		if(!validateCoC(inputDTO))
			return null;

		// Generate a CoC from the input
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
	
	public CoCDTO updateCoC(CoCDTO inputDTO) {
		// Generate a TmpProject from the input
		TmpProjectContinuum tmpProjectContinuum = CoCManager.generateTmpProjectContinuum(inputDTO);

		// Validate the CoC
		// TODO: this should return a list of errors that get wrapped appropriately
		if(!validateCoC(inputDTO))
			return null;
		
		tmpProjectContinuum.setProjectCocId(Integer.parseInt(inputDTO.getProjectCoCId()));
		tmpProjectContinuum.setDateUpdated(new Date());
		
		// Update the client
		tmpProjectContinuumDAO.update(tmpProjectContinuum);
		
		// Return the resulting VO
		return CoCManager.generateCoCDTO(tmpProjectContinuum);
		
	}
	
	public boolean deleteCoC(String projectCoCId) {
		TmpProjectContinuum tmpProjectContinuum = tmpProjectContinuumDAO.getTmpProjectContinuumById(Integer.parseInt(projectCoCId));
		tmpProjectContinuumDAO.delete(tmpProjectContinuum);
		
		return true;
	}
	
	public static boolean validateCoC(CoCDTO inputDTO) {
		// There really aren't fields to validate right now.
		return true;
	}

	
	public static CoCDTO generateCoCDTO(TmpProjectContinuum tmpProjectContinuum) {
		Integer projectCoCId = tmpProjectContinuum.getProjectCocId();
		
		CoCDTO coCDTO = new CoCDTO();
		InventorySearchDTO inventorySearchDTO = new InventorySearchDTO();
                SiteSearchDTO siteSearchDTO = new SiteSearchDTO();
                coCDTO.setProjectCoCId(tmpProjectContinuum.getProjectCocId().toString());
		coCDTO.setProjectId(tmpProjectContinuum.getProjectId().toString());
                inventorySearchDTO.setProjectCocId(projectCoCId.toString());
                siteSearchDTO.setProjectCocId(projectCoCId.toString()); 
		
		// Universal Data Standard: Project Identifiers (2014, 2.2) 
		coCDTO.setCoCCode(tmpProjectContinuum.getCocCode());

		// Universal Data Standard: Inventories (2014, 2.7)
		coCDTO.setInventories(InventoryManager.getInventories(inventorySearchDTO));

		// Universal Data Standard: Sites (2014, 2.8)
		coCDTO.setSites(SiteManager.getSites(siteSearchDTO));

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
