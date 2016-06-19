package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.TmpPhysicalDisabilityDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpPhysicalDisability;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.PhysicalDisabilityDTO;
import org.openhmis.dto.search.PhysicalDisabilitySearchDTO;

public class PhysicalDisabilityManager {
	private TmpPhysicalDisabilityDAO tmpPhysicalDisabilityDAO;

	public PhysicalDisabilityManager() {
		this.tmpPhysicalDisabilityDAO = new TmpPhysicalDisabilityDAO();
	}

	public PhysicalDisabilityManager(TmpPhysicalDisabilityDAO tmpPhysicalDisabilityDAO) {
		this.tmpPhysicalDisabilityDAO = tmpPhysicalDisabilityDAO;
	}

	public PhysicalDisabilityDTO getPhysicalDisabilityById(String physicalDisabilityId) {
		PhysicalDisabilityDTO physicalDisabilityDTO = PhysicalDisabilityManager.generatePhysicalDisabilityDTO(tmpPhysicalDisabilityDAO.getTmpPhysicalDisabilityById(Integer.parseInt(physicalDisabilityId)));
		return physicalDisabilityDTO;
	}

	public List<PhysicalDisabilityDTO> getPhysicalDisabilities(PhysicalDisabilitySearchDTO searchDTO) {
		List<PhysicalDisabilityDTO> physicalDisabilityDTOs = new ArrayList<PhysicalDisabilityDTO>();

		// Collect the physicalDisabilities
		List<TmpPhysicalDisability> tmpPhysicalDisabilities = tmpPhysicalDisabilityDAO.getTmpPhysicalDisabilities(searchDTO);

		// For each physicalDisability, collect and map the data
		for (Iterator<TmpPhysicalDisability> iterator = tmpPhysicalDisabilities.iterator(); iterator.hasNext();) {
			TmpPhysicalDisability tmpPhysicalDisability = iterator.next();
			PhysicalDisabilityDTO physicalDisabilityDTO = PhysicalDisabilityManager.generatePhysicalDisabilityDTO(tmpPhysicalDisability);
			physicalDisabilityDTOs.add(physicalDisabilityDTO);
		}
		return physicalDisabilityDTOs;

	}
	
	public PhysicalDisabilityDTO addPhysicalDisability(PhysicalDisabilityDTO inputDTO) {
		// Generate a PathClient from the input
		TmpPhysicalDisability tmpPhysicalDisability = PhysicalDisabilityManager.generateTmpPhysicalDisability(inputDTO);
		
		// Set Export fields
		tmpPhysicalDisability.setDateCreated(new Date());
		tmpPhysicalDisability.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpPhysicalDisabilityDAO.save(tmpPhysicalDisability);
		inputDTO.setPhysicalDisabilityId(tmpPhysicalDisability.getPhysicalDisabilityId().toString());
		
		// Return the resulting VO
		return PhysicalDisabilityManager.generatePhysicalDisabilityDTO(tmpPhysicalDisability);
	}
	
	public PhysicalDisabilityDTO updatePhysicalDisability(PhysicalDisabilityDTO inputDTO) {
		// Generate a PhysicalDisability from the input
		TmpPhysicalDisability tmpPhysicalDisability = PhysicalDisabilityManager.generateTmpPhysicalDisability(inputDTO);
		tmpPhysicalDisability.setPhysicalDisabilityId(Integer.parseInt(inputDTO.getPhysicalDisabilityId()));
		tmpPhysicalDisability.setDateUpdated(new Date());
		
		// Update the object
		tmpPhysicalDisabilityDAO.update(tmpPhysicalDisability);
		
		// Return the resulting VO
		return PhysicalDisabilityManager.generatePhysicalDisabilityDTO(tmpPhysicalDisability);

	}
	
	public boolean deletePhysicalDisability(String physicalDisabilityId) {
		TmpPhysicalDisability tmpPhysicalDisability = tmpPhysicalDisabilityDAO.getTmpPhysicalDisabilityById(Integer.parseInt(physicalDisabilityId));
		tmpPhysicalDisabilityDAO.delete(tmpPhysicalDisability);
		return true;
	}
	
}
