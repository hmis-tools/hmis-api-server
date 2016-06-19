package org.openhmis.generator;

public class InventoryGenerator {

	public InventoryGenerator() {
	}

	public InventoryDTO generateInventoryDTO(TmpProjectInventory tmpProjectInventory) {
		InventoryDTO inventoryDTO = new InventoryDTO();

		inventoryDTO.setInventoryId(tmpProjectInventory.getInventoryId().toString());
		inventoryDTO.setProjectCoCId(tmpProjectInventory.getProjectCoCid().toString());

		// Universal Data Standard: Bed and Unit Inventory Information (2014, 2.7) 
		inventoryDTO.setInformationDate(tmpProjectInventory.getInformationDate());
		inventoryDTO.setHouseholdType(ProjectHouseholdType.valueByCode(tmpProjectInventory.getHouseholdType()));
		inventoryDTO.setBedType(ProjectBedType.valueByCode(tmpProjectInventory.getBedType()));
		inventoryDTO.setAvailability(ProjectAvailability.valueByCode(tmpProjectInventory.getAvailability()));
		inventoryDTO.setUnitInventory(tmpProjectInventory.getUnitInventory());
		inventoryDTO.setBedInventory(tmpProjectInventory.getBedInventory());
		inventoryDTO.setChBedInventory(tmpProjectInventory.getChBedInventory());
		inventoryDTO.setVetBedInventory(tmpProjectInventory.getVetBedInventory());
		inventoryDTO.setYouthBedInventory(tmpProjectInventory.getYouthBedInventory());
		inventoryDTO.setYouthAgeGroup(ProjectYouthAgeGroup.valueByCode(tmpProjectInventory.getYouthAgeGroup()));
		inventoryDTO.setInventoryStartDate(tmpProjectInventory.getInventoryStartDate());
		inventoryDTO.setInventoryEndDate(tmpProjectInventory.getInventoryEndDate());
		inventoryDTO.setHmisParticipatingBeds(tmpProjectInventory.getParticipatingBeds());

		// Export Standard Fields
		inventoryDTO.setDateCreated(tmpProjectInventory.getDateCreated());
		inventoryDTO.setDateUpdated(tmpProjectInventory.getDateUpdated());
		
		return inventoryDTO;
	}
	
	public TmpProjectInventory generateTmpProjectInventory(InventoryDTO inputDTO) {
		TmpProjectInventory tmpProjectInventory = new TmpProjectInventory();
		
		tmpProjectInventory.setProjectCoCid(Integer.parseInt(inputDTO.getProjectCoCId()));

		// Universal Data Standard: Bed and Unit Inventory Information (2014, 2.7) 
		tmpProjectInventory.setInformationDate(inputDTO.getInformationDate());
		tmpProjectInventory.setHouseholdType(inputDTO.getHouseholdType().getCode());
		tmpProjectInventory.setBedType(inputDTO.getBedType().getCode());
		tmpProjectInventory.setAvailability(inputDTO.getAvailability().getCode());
		tmpProjectInventory.setUnitInventory(inputDTO.getUnitInventory());
		tmpProjectInventory.setBedInventory(inputDTO.getBedInventory());
		tmpProjectInventory.setChBedInventory(inputDTO.getChBedInventory());
		tmpProjectInventory.setVetBedInventory(inputDTO.getVetBedInventory());
		tmpProjectInventory.setYouthBedInventory(inputDTO.getYouthBedInventory());
		tmpProjectInventory.setYouthAgeGroup(inputDTO.getYouthAgeGroup().getCode());
		tmpProjectInventory.setInventoryStartDate(inputDTO.getInventoryStartDate());
		tmpProjectInventory.setInventoryEndDate(inputDTO.getInventoryEndDate());
		tmpProjectInventory.setParticipatingBeds(inputDTO.getHmisParticipatingBeds());
		
		// Export Standard Fields
		tmpProjectInventory.setDateCreated(inputDTO.getDateCreated());
		tmpProjectInventory.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpProjectInventory;
	}
}