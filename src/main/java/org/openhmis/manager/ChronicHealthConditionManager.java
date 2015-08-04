package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.ChronicHealthConditionDTO;

public class ChronicHealthConditionManager {

	public ChronicHealthConditionManager() {}

	public ChronicHealthConditionDTO getChronicHealthConditionById(String enrollmentId) {
		ChronicHealthConditionDTO chronicHealthConditionDTO = new ChronicHealthConditionDTO();
		return chronicHealthConditionDTO;
	}

	public List<ChronicHealthConditionDTO> getChronicHealthConditionsByEnrollmentId(String enrollmentId) {
		List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = new ArrayList<ChronicHealthConditionDTO>();
		return chronicHealthConditionDTOs;
	}
	
	public ChronicHealthConditionDTO addChronicHealthCondition(ChronicHealthConditionDTO inputVO) {
		return inputVO;
	}
	
	public ChronicHealthConditionDTO updateChronicHealthCondition(ChronicHealthConditionDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteChronicHealthCondition(String chronicHealthConditionId) {
		return false;
	}
	
	public static ChronicHealthConditionDTO generateChronicHealthConditionDTO() {
		ChronicHealthConditionDTO chronicHealthConditionDTO = new ChronicHealthConditionDTO();
		
		return chronicHealthConditionDTO;
	}
	
}