package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.DevelopmentalDisabilityVO;

public class DevelopmentalDisabilityManager {

	public DevelopmentalDisabilityManager() {}

	public DevelopmentalDisabilityVO getDevelopmentalDisabilityById(String enrollmentId) {
		DevelopmentalDisabilityVO developmentalDisabilityVO = new DevelopmentalDisabilityVO();
		return developmentalDisabilityVO;
	}

	public List<DevelopmentalDisabilityVO> getDevelopmentalDisabilitysByEnrollmentId(String enrollmentId) {
		List<DevelopmentalDisabilityVO> developmentalDisabilityVOs = new ArrayList<DevelopmentalDisabilityVO>();
		return developmentalDisabilityVOs;
	}
	
	public DevelopmentalDisabilityVO addDevelopmentalDisability(DevelopmentalDisabilityVO inputVO) {
		return inputVO;
	}
	
	public DevelopmentalDisabilityVO updateDevelopmentalDisability(DevelopmentalDisabilityVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteDevelopmentalDisability(String developmentalDisabilityId) {
		return false;
	}
	
	public static DevelopmentalDisabilityVO generateDevelopmentalDisabilityVO() {
		DevelopmentalDisabilityVO developmentalDisabilityVO = new DevelopmentalDisabilityVO();
		
		return developmentalDisabilityVO;
	}
	
}