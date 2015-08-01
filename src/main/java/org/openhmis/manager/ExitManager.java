package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.ExitDTO;

public class ExitManager {

	public ExitManager() {}

	public ExitDTO getExitById(String enrollmentId) {
		ExitDTO exitDTO = new ExitDTO();
		return exitDTO;
	}

	public List<ExitDTO> getExitsByEnrollmentId(String enrollmentId) {
		List<ExitDTO> exitDTOs = new ArrayList<ExitDTO>();
		return exitDTOs;
	}
	
	public ExitDTO addExit(ExitDTO inputVO) {
		return inputVO;
	}
	
	public ExitDTO updateExit(ExitDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteExit(String exitId) {
		return false;
	}
	
	public static ExitDTO generateExitVO() {
		ExitDTO exitDTO = new ExitDTO();
		
		return exitDTO;
	}
	
}