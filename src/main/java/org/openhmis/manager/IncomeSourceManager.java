package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.IncomeSourceVO;

public class IncomeSourceManager {

	public IncomeSourceManager() {}

	public IncomeSourceVO getIncomeSourceById(String enrollmentId) {
		IncomeSourceVO incomeSourceVO = new IncomeSourceVO();
		return incomeSourceVO;
	}

	public List<IncomeSourceVO> getIncomeSourcesByEnrollmentId(String enrollmentId) {
		List<IncomeSourceVO> incomeSourceVOs = new ArrayList<IncomeSourceVO>();
		return incomeSourceVOs;
	}
	
	public IncomeSourceVO addIncomeSource(IncomeSourceVO inputVO) {
		return inputVO;
	}
	
	public IncomeSourceVO updateIncomeSource(IncomeSourceVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteIncomeSource(String incomeSourceId) {
		return false;
	}
	
	public static IncomeSourceVO generateIncomeSourceVO() {
		IncomeSourceVO incomeSourceVO = new IncomeSourceVO();
		
		return incomeSourceVO;
	}
	
}