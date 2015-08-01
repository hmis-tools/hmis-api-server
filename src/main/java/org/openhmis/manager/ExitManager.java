package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.ExitVO;

public class ExitManager {

	public ExitManager() {}

	public ExitVO getExitById(String enrollmentId) {
		ExitVO exitVO = new ExitVO();
		return exitVO;
	}

	public List<ExitVO> getExitsByEnrollmentId(String enrollmentId) {
		List<ExitVO> exitVOs = new ArrayList<ExitVO>();
		return exitVOs;
	}
	
	public ExitVO addExit(ExitVO inputVO) {
		return inputVO;
	}
	
	public ExitVO updateExit(ExitVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteExit(String exitId) {
		return false;
	}
	
	public static ExitVO generateExitVO() {
		ExitVO exitVO = new ExitVO();
		
		return exitVO;
	}
	
}