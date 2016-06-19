

public class InventoryValidator {

	public InventoryValidator() {
	}
	
	public boolean validateInventory(InventoryDTO inputDTO) {
		// Universal Data Standard: Bed and Unit Inventory Information (2014, 2.7) 
		if(inputDTO.getHouseholdType() == ProjectHouseholdType.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.7.1 householdType", "householdType is set to an unknown code");

		// Bed Type
		// Null unless [Project.csv].[ProjectType] = 1
		// TODO: We need to be able to look up project type behind this inventory...
		if(inputDTO.getBedType() == ProjectBedType.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.7.2 bedType", "bedType is set to an unknown code");

		if(inputDTO.getAvailability() == ProjectAvailability.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.7.3 availability", "availability is set to an unknown code");

//		inventoryDTO.setUnitInventory(tmpProjectInventory.getUnitInventory());
//		inventoryDTO.setBedInventory(tmpProjectInventory.getBedInventory());
//		inventoryDTO.setChBedInventory(tmpProjectInventory.getChBedInventory());
//		inventoryDTO.setVetBedInventory(tmpProjectInventory.getVetBedInventory());
//		inventoryDTO.setYouthBedInventory(tmpProjectInventory.getYouthBedInventory());
		
		if(inputDTO.getYouthAgeGroup() == ProjectYouthAgeGroup.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.7.B youthAgeGroup", "youthAgeGroup is set to an unknown code");

//		inventoryDTO.setHmisParticipatingBeds(tmpProjectInventory.getParticipatingBeds());
		
		return true;
	}
}