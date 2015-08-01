package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.NonCashBenefitDTO;

public class NonCashBenefitManager {

	public NonCashBenefitManager() {}

	public NonCashBenefitDTO getNonCashBenefitById(String enrollmentId) {
		NonCashBenefitDTO nonCashBenefitDTO = new NonCashBenefitDTO();
		return nonCashBenefitDTO;
	}

	public List<NonCashBenefitDTO> getNonCashBenefitsByEnrollmentId(String enrollmentId) {
		List<NonCashBenefitDTO> nonCashBenefitDTOs = new ArrayList<NonCashBenefitDTO>();
		return nonCashBenefitDTOs;
	}
	
	public NonCashBenefitDTO addNonCashBenefit(NonCashBenefitDTO inputVO) {
		return inputVO;
	}
	
	public NonCashBenefitDTO updateNonCashBenefit(NonCashBenefitDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteNonCashBenefit(String nonCashBenefitId) {
		return false;
	}
	
	public static NonCashBenefitDTO generateNonCashBenefitVO() {
		NonCashBenefitDTO nonCashBenefitDTO = new NonCashBenefitDTO();
		
		return nonCashBenefitDTO;
	}
	
}