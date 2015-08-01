package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.PhysicalDisabilityVO;

public class PhysicalDisabilityManager {

	public PhysicalDisabilityManager() {}

	public PhysicalDisabilityVO getPhysicalDisabilityById(String enrollmentId) {
		PhysicalDisabilityVO physicalDisabilityVO = new PhysicalDisabilityVO();
		return physicalDisabilityVO;
	}

	public List<PhysicalDisabilityVO> getPhysicalDisabilitiesByEnrollmentId(String enrollmentId) {
		List<PhysicalDisabilityVO> physicalDisabilityVOs = new ArrayList<PhysicalDisabilityVO>();
		return physicalDisabilityVOs;
	}
	
	public PhysicalDisabilityVO addPhysicalDisability(PhysicalDisabilityVO inputVO) {
		return inputVO;
	}
	
	public PhysicalDisabilityVO updatePhysicalDisability(PhysicalDisabilityVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deletePhysicalDisability(String physicalDisabilityId) {
		return false;
	}
	
	public static PhysicalDisabilityVO generatePhysicalDisabilityVO() {
		PhysicalDisabilityVO physicalDisabilityVO = new PhysicalDisabilityVO();
		
		return physicalDisabilityVO;
	}
	
}