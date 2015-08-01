package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.HivAidsStatusVO;

public class HivAidsStatusManager {

	public HivAidsStatusManager() {}

	public HivAidsStatusVO getHivAidsStatusById(String enrollmentId) {
		HivAidsStatusVO hivAidsStatusVO = new HivAidsStatusVO();
		return hivAidsStatusVO;
	}

	public List<HivAidsStatusVO> getHivAidsStatusesByEnrollmentId(String enrollmentId) {
		List<HivAidsStatusVO> hivAidsStatusVOs = new ArrayList<HivAidsStatusVO>();
		return hivAidsStatusVOs;
	}
	
	public HivAidsStatusVO addHivAidsStatus(HivAidsStatusVO inputVO) {
		return inputVO;
	}
	
	public HivAidsStatusVO updateHivAidsStatus(HivAidsStatusVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteHivAidsStatus(String hivAidsStatusId) {
		return false;
	}
	
	public static HivAidsStatusVO generateHivAidsStatusVO() {
		HivAidsStatusVO hivAidsStatusVO = new HivAidsStatusVO();
		
		return hivAidsStatusVO;
	}
	
}