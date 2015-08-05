package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.DevelopmentalDisabilityDTO;

public class DevelopmentalDisabilityManager {

	public DevelopmentalDisabilityManager() {}

	public DevelopmentalDisabilityDTO getDevelopmentalDisabilityById(String enrollmentId) {
		DevelopmentalDisabilityDTO developmentalDisabilityDTO = new DevelopmentalDisabilityDTO();
		return developmentalDisabilityDTO;
	}

	public List<DevelopmentalDisabilityDTO> getDevelopmentalDisabilitiesByEnrollmentId(String enrollmentId) {
		List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = new ArrayList<DevelopmentalDisabilityDTO>();
		return developmentalDisabilityDTOs;
	}
	
	public DevelopmentalDisabilityDTO addDevelopmentalDisability(DevelopmentalDisabilityDTO inputVO) {
		return inputVO;
	}
	
	public DevelopmentalDisabilityDTO updateDevelopmentalDisability(DevelopmentalDisabilityDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteDevelopmentalDisability(String developmentalDisabilityId) {
		return false;
	}
	
	public static DevelopmentalDisabilityDTO generateDevelopmentalDisabilityDTO() {
		DevelopmentalDisabilityDTO developmentalDisabilityDTO = new DevelopmentalDisabilityDTO();
		
		return developmentalDisabilityDTO;
	}
	
}