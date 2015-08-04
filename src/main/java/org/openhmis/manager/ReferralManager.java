package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.ReferralDTO;

public class ReferralManager {

	public ReferralManager() {}

	public ReferralDTO getReferralById(String enrollmentId) {
		ReferralDTO referralDTO = new ReferralDTO();
		return referralDTO;
	}

	public List<ReferralDTO> getReferralsByEnrollmentId(String enrollmentId) {
		List<ReferralDTO> referralDTOs = new ArrayList<ReferralDTO>();
		return referralDTOs;
	}
	
	public ReferralDTO addReferral(ReferralDTO inputVO) {
		return inputVO;
	}
	
	public ReferralDTO updateReferral(ReferralDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteReferral(String referralId) {
		return false;
	}
	
	public static ReferralDTO generateReferralDTO() {
		ReferralDTO referralDTO = new ReferralDTO();
		
		return referralDTO;
	}
	
}