package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.SubstanceAbuseVO;

public class SubstanceAbuseManager {

	public SubstanceAbuseManager() {}

	public SubstanceAbuseVO getSubstanceAbuseById(String enrollmentId) {
		SubstanceAbuseVO substanceAbuseVO = new SubstanceAbuseVO();
		return substanceAbuseVO;
	}

	public List<SubstanceAbuseVO> getSubstanceAbusesByEnrollmentId(String enrollmentId) {
		List<SubstanceAbuseVO> substanceAbuseVOs = new ArrayList<SubstanceAbuseVO>();
		return substanceAbuseVOs;
	}
	
	public SubstanceAbuseVO addSubstanceAbuse(SubstanceAbuseVO inputVO) {
		return inputVO;
	}
	
	public SubstanceAbuseVO updateSubstanceAbuse(SubstanceAbuseVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteSubstanceAbuse(String substanceAbuseId) {
		return false;
	}
	
	public static SubstanceAbuseVO generateSubstanceAbuseVO() {
		SubstanceAbuseVO substanceAbuseVO = new SubstanceAbuseVO();
		
		return substanceAbuseVO;
	}
	
}