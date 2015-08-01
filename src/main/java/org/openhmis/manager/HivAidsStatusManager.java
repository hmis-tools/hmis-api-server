package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.HivAidsStatusDTO;

public class HivAidsStatusManager {

	public HivAidsStatusManager() {}

	public HivAidsStatusDTO getHivAidsStatusById(String enrollmentId) {
		HivAidsStatusDTO hivAidsStatusDTO = new HivAidsStatusDTO();
		return hivAidsStatusDTO;
	}

	public List<HivAidsStatusDTO> getHivAidsStatusesByEnrollmentId(String enrollmentId) {
		List<HivAidsStatusDTO> hivAidsStatusDTOs = new ArrayList<HivAidsStatusDTO>();
		return hivAidsStatusDTOs;
	}
	
	public HivAidsStatusDTO addHivAidsStatus(HivAidsStatusDTO inputVO) {
		return inputVO;
	}
	
	public HivAidsStatusDTO updateHivAidsStatus(HivAidsStatusDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteHivAidsStatus(String hivAidsStatusId) {
		return false;
	}
	
	public static HivAidsStatusDTO generateHivAidsStatusVO() {
		HivAidsStatusDTO hivAidsStatusDTO = new HivAidsStatusDTO();
		
		return hivAidsStatusDTO;
	}
	
}