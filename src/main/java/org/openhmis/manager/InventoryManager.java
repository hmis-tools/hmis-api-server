package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.dao.TmpProjectInventoryDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpProjectInventory;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.InventoryDTO;
import org.openhmis.exception.InvalidParameterException;

public class InventoryManager {
	private static final TmpProjectInventoryDAO tmpProjectInventoryDAO = new TmpProjectInventoryDAO();

	public InventoryManager() {}

	public static InventoryDTO getInventoryById(String inventoryId) {
		InventoryDTO inventoryDTO = InventoryManager.generateInventoryDTO(tmpProjectInventoryDAO.getTmpProjectInventoryById(Integer.parseInt(inventoryId)));
		return inventoryDTO;
	}

	public static List<InventoryDTO> getInventories() {
		List<InventoryDTO> inventoryDTOs = new ArrayList<InventoryDTO>();

		// Collect the inventories
		List<TmpProjectInventory> tmpProjectInventories = tmpProjectInventoryDAO.getTmpProjectInventories();

		// For each inventory, collect and map the data
		for (Iterator<TmpProjectInventory> iterator = tmpProjectInventories.iterator(); iterator.hasNext();) {
			TmpProjectInventory tmpProjectInventory = iterator.next();
			InventoryDTO inventoryDTO = InventoryManager.generateInventoryDTO(tmpProjectInventory);
			inventoryDTOs.add(inventoryDTO);
		}
		return inventoryDTOs;

	}

	public static List<InventoryDTO> getInventories(Date updateDate) {
		List<InventoryDTO> inventoryDTOs = new ArrayList<InventoryDTO>();

		// Collect the inventories
		List<TmpProjectInventory> tmpProjectInventories = tmpProjectInventoryDAO.getTmpProjectInventories(updateDate);

		// For each inventory, collect and map the data
		for (Iterator<TmpProjectInventory> iterator = tmpProjectInventories.iterator(); iterator.hasNext();) {
			TmpProjectInventory tmpProjectInventory = iterator.next();
			InventoryDTO inventoryDTO = InventoryManager.generateInventoryDTO(tmpProjectInventory);
			inventoryDTOs.add(inventoryDTO);
		}
		return inventoryDTOs;

	}

	public static List<InventoryDTO> getInventoriesByProjectCoCId(String projectCoCId) {
		List<InventoryDTO> inventoryDTOs = new ArrayList<InventoryDTO>();

		// Collect the inventories
		List<TmpProjectInventory> tmpProjectInventories = tmpProjectInventoryDAO.getTmpProjectInventoriesByProjectCoCId(Integer.parseInt(projectCoCId));

		// For each inventory, collect and map the data
		for (Iterator<TmpProjectInventory> iterator = tmpProjectInventories.iterator(); iterator.hasNext();) {
			TmpProjectInventory tmpProjectInventory = iterator.next();
			InventoryDTO inventoryDTO = InventoryManager.generateInventoryDTO(tmpProjectInventory);
			inventoryDTOs.add(inventoryDTO);
		}
		return inventoryDTOs;

	}

	public static List<InventoryDTO> getInventoriesByProjectCoCId(String projectCoCId, Date updateDate) {
		List<InventoryDTO> inventoryDTOs = new ArrayList<InventoryDTO>();

		// Collect the inventories
		List<TmpProjectInventory> tmpProjectInventories = tmpProjectInventoryDAO.getTmpProjectInventoriesByProjectCoCId(Integer.parseInt(projectCoCId), updateDate);

		// For each inventory, collect and map the data
		for (Iterator<TmpProjectInventory> iterator = tmpProjectInventories.iterator(); iterator.hasNext();) {
			TmpProjectInventory tmpProjectInventory = iterator.next();
			InventoryDTO inventoryDTO = InventoryManager.generateInventoryDTO(tmpProjectInventory);
			inventoryDTOs.add(inventoryDTO);
		}
		return inventoryDTOs;

	}
	
	public static InventoryDTO addInventory(InventoryDTO inputDTO) {
		
		// Check the fields
		validateInventory(inputDTO);
		
		// Generate a PathClient from the input
		TmpProjectInventory tmpProjectInventory = InventoryManager.generateTmpProjectInventory(inputDTO);
		
		// Set Export fields
		tmpProjectInventory.setDateCreated(new Date());
		tmpProjectInventory.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpProjectInventoryDAO.save(tmpProjectInventory);
		inputDTO.setInventoryId(tmpProjectInventory.getInventoryId().toString());
		
		// Return the resulting VO
		return InventoryManager.generateInventoryDTO(tmpProjectInventory);
	}
	
	public static InventoryDTO updateInventory(InventoryDTO inputDTO) {
		
		// Check the fields
		validateInventory(inputDTO);
		
		// Generate a TmpProject from the input
		TmpProjectInventory tmpProjectInventory = InventoryManager.generateTmpProjectInventory(inputDTO);
		tmpProjectInventory.setInventoryId(Integer.parseInt(inputDTO.getInventoryId()));
		tmpProjectInventory.setDateUpdated(new Date());
		
		// Update the client
		tmpProjectInventoryDAO.update(tmpProjectInventory);
		
		// Return the resulting VO
		return InventoryManager.generateInventoryDTO(tmpProjectInventory);

	}
	
	public static boolean deleteInventory(String inventoryId) {
		TmpProjectInventory tmpProjectInventory = tmpProjectInventoryDAO.getTmpProjectInventoryById(Integer.parseInt(inventoryId));
		tmpProjectInventoryDAO.delete(tmpProjectInventory);
		
		return true;
	}
	
	public static boolean validateInventory(InventoryDTO inputDTO) {
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
	
	public static InventoryDTO generateInventoryDTO(TmpProjectInventory tmpProjectInventory) {
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
	
	public static TmpProjectInventory generateTmpProjectInventory(InventoryDTO inputDTO) {
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