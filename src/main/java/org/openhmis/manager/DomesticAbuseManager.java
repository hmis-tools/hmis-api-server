package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.DomesticAbuseVO;

public class DomesticAbuseManager {

	public DomesticAbuseManager() {}

	public DomesticAbuseVO getDomesticAbuseById(String enrollmentId) {
		DomesticAbuseVO domesticAbuseVO = new DomesticAbuseVO();
		return domesticAbuseVO;
	}

	public List<DomesticAbuseVO> getDomesticAbusesByEnrollmentId(String enrollmentId) {
		List<DomesticAbuseVO> domesticAbuseVOs = new ArrayList<DomesticAbuseVO>();
		return domesticAbuseVOs;
	}
	
	public DomesticAbuseVO addDomesticAbuse(DomesticAbuseVO inputVO) {
		return inputVO;
	}
	
	public DomesticAbuseVO updateDomesticAbuse(DomesticAbuseVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteDomesticAbuse(String domesticAbuseId) {
		return false;
	}
	
	public static DomesticAbuseVO generateDomesticAbuseVO() {
		DomesticAbuseVO domesticAbuseVO = new DomesticAbuseVO();
		
		return domesticAbuseVO;
	}
	
}