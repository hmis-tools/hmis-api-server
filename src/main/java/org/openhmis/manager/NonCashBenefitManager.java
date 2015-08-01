package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.NonCashBenefitVO;

public class NonCashBenefitManager {

	public NonCashBenefitManager() {}

	public NonCashBenefitVO getNonCashBenefitById(String enrollmentId) {
		NonCashBenefitVO nonCashBenefitVO = new NonCashBenefitVO();
		return nonCashBenefitVO;
	}

	public List<NonCashBenefitVO> getNonCashBenefitsByEnrollmentId(String enrollmentId) {
		List<NonCashBenefitVO> nonCashBenefitVOs = new ArrayList<NonCashBenefitVO>();
		return nonCashBenefitVOs;
	}
	
	public NonCashBenefitVO addNonCashBenefit(NonCashBenefitVO inputVO) {
		return inputVO;
	}
	
	public NonCashBenefitVO updateNonCashBenefit(NonCashBenefitVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteNonCashBenefit(String nonCashBenefitId) {
		return false;
	}
	
	public static NonCashBenefitVO generateNonCashBenefitVO() {
		NonCashBenefitVO nonCashBenefitVO = new NonCashBenefitVO();
		
		return nonCashBenefitVO;
	}
	
}