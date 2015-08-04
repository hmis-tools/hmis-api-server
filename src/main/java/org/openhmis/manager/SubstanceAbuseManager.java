package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.SubstanceAbuseDTO;

public class SubstanceAbuseManager {

	public SubstanceAbuseManager() {}

	public SubstanceAbuseDTO getSubstanceAbuseById(String enrollmentId) {
		SubstanceAbuseDTO substanceAbuseDTO = new SubstanceAbuseDTO();
		return substanceAbuseDTO;
	}

	public List<SubstanceAbuseDTO> getSubstanceAbusesByEnrollmentId(String enrollmentId) {
		List<SubstanceAbuseDTO> substanceAbuseDTOs = new ArrayList<SubstanceAbuseDTO>();
		return substanceAbuseDTOs;
	}
	
	public SubstanceAbuseDTO addSubstanceAbuse(SubstanceAbuseDTO inputVO) {
		return inputVO;
	}
	
	public SubstanceAbuseDTO updateSubstanceAbuse(SubstanceAbuseDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteSubstanceAbuse(String substanceAbuseId) {
		return false;
	}
	
	public static SubstanceAbuseDTO generateSubstanceAbuseDTO() {
		SubstanceAbuseDTO substanceAbuseDTO = new SubstanceAbuseDTO();
		
		return substanceAbuseDTO;
	}
	
}