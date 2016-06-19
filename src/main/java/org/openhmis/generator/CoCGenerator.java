package org.openhmis.generator;

public class CoCGenerator {

	public CoCGenerator() {
	}

	public CoCDTO generateCoCDTO(TmpProjectContinuum tmpProjectContinuum) {
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

	public TmpProjectContinuum generateTmpProjectContinuum(CoCDTO inputDTO) {
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