package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.PhysicalDisabilityDTO;

public class PhysicalDisabilityManager {

	public PhysicalDisabilityManager() {}

	public PhysicalDisabilityDTO getPhysicalDisabilityById(String enrollmentId) {
		PhysicalDisabilityDTO physicalDisabilityDTO = new PhysicalDisabilityDTO();
		return physicalDisabilityDTO;
	}

	public List<PhysicalDisabilityDTO> getPhysicalDisabilitiesByEnrollmentId(String enrollmentId) {
		List<PhysicalDisabilityDTO> physicalDisabilityDTOs = new ArrayList<PhysicalDisabilityDTO>();
		return physicalDisabilityDTOs;
	}
	
	public PhysicalDisabilityDTO addPhysicalDisability(PhysicalDisabilityDTO inputVO) {
		return inputVO;
	}
	
	public PhysicalDisabilityDTO updatePhysicalDisability(PhysicalDisabilityDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deletePhysicalDisability(String physicalDisabilityId) {
		return false;
	}
	
	public static PhysicalDisabilityDTO generatePhysicalDisabilityVO() {
		PhysicalDisabilityDTO physicalDisabilityDTO = new PhysicalDisabilityDTO();
		
		return physicalDisabilityDTO;
	}
	
}