package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.DomesticAbuseDTO;

public class DomesticAbuseManager {

	public DomesticAbuseManager() {}

	public DomesticAbuseDTO getDomesticAbuseById(String enrollmentId) {
		DomesticAbuseDTO domesticAbuseDTO = new DomesticAbuseDTO();
		return domesticAbuseDTO;
	}

	public List<DomesticAbuseDTO> getDomesticAbusesByEnrollmentId(String enrollmentId) {
		List<DomesticAbuseDTO> domesticAbuseDTOs = new ArrayList<DomesticAbuseDTO>();
		return domesticAbuseDTOs;
	}
	
	public DomesticAbuseDTO addDomesticAbuse(DomesticAbuseDTO inputVO) {
		return inputVO;
	}
	
	public DomesticAbuseDTO updateDomesticAbuse(DomesticAbuseDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteDomesticAbuse(String domesticAbuseId) {
		return false;
	}
	
	public static DomesticAbuseDTO generateDomesticAbuseDTO() {
		DomesticAbuseDTO domesticAbuseDTO = new DomesticAbuseDTO();
		
		return domesticAbuseDTO;
	}
	
}