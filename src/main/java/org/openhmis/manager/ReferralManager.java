package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.ReferralVO;

public class ReferralManager {

	public ReferralManager() {}

	public ReferralVO getReferralById(String enrollmentId) {
		ReferralVO referralVO = new ReferralVO();
		return referralVO;
	}

	public List<ReferralVO> getReferralsByEnrollmentId(String enrollmentId) {
		List<ReferralVO> referralVOs = new ArrayList<ReferralVO>();
		return referralVOs;
	}
	
	public ReferralVO addReferral(ReferralVO inputVO) {
		return inputVO;
	}
	
	public ReferralVO updateReferral(ReferralVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteReferral(String referralId) {
		return false;
	}
	
	public static ReferralVO generateReferralVO() {
		ReferralVO referralVO = new ReferralVO();
		
		return referralVO;
	}
	
}