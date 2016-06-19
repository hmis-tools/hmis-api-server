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
import org.openhmis.dto.search.InventorySearchDTO;
import org.openhmis.exception.InvalidParameterException;

public class InventoryManager {
	private TmpProjectInventoryDAO tmpProjectInventoryDAO;

	public InventoryManager() {
		this.tmpProjectInventoryDAO = new TmpProjectInventoryDAO();
	}

	public InventoryManager(TmpProjectInventoryDAO tmpProjectInventoryDAO) {
		this.tmpProjectInventoryDAO = tmpProjectInventoryDAO;
	}

	public InventoryDTO getInventoryById(String inventoryId) {
		InventoryDTO inventoryDTO = InventoryManager.generateInventoryDTO(tmpProjectInventoryDAO.getTmpProjectInventoryById(Integer.parseInt(inventoryId)));
		return inventoryDTO;
	}

	public List<InventoryDTO> getInventories(InventorySearchDTO searchDTO) {
		List<InventoryDTO> inventoryDTOs = new ArrayList<InventoryDTO>();

		// Collect the inventories
		List<TmpProjectInventory> tmpProjectInventories = tmpProjectInventoryDAO.getTmpProjectInventories(searchDTO);

		// For each inventory, collect and map the data
		for (Iterator<TmpProjectInventory> iterator = tmpProjectInventories.iterator(); iterator.hasNext();) {
			TmpProjectInventory tmpProjectInventory = iterator.next();
			InventoryDTO inventoryDTO = InventoryManager.generateInventoryDTO(tmpProjectInventory);
			inventoryDTOs.add(inventoryDTO);
		}
		return inventoryDTOs;

	}

	public InventoryDTO addInventory(InventoryDTO inputDTO) {
		
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
	
	public InventoryDTO updateInventory(InventoryDTO inputDTO) {
		
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
	
	public boolean deleteInventory(String inventoryId) {
		TmpProjectInventory tmpProjectInventory = tmpProjectInventoryDAO.getTmpProjectInventoryById(Integer.parseInt(inventoryId));
		tmpProjectInventoryDAO.delete(tmpProjectInventory);
		
		return true;
	}
	
}
