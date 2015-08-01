package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.FinancialAssistanceVO;

public class FinancialAssistanceManager {

	public FinancialAssistanceManager() {}

	public FinancialAssistanceVO getFinancialAssistanceById(String enrollmentId) {
		FinancialAssistanceVO financialAssistanceVO = new FinancialAssistanceVO();
		return financialAssistanceVO;
	}

	public List<FinancialAssistanceVO> getFinancialAssistancesByEnrollmentId(String enrollmentId) {
		List<FinancialAssistanceVO> financialAssistanceVOs = new ArrayList<FinancialAssistanceVO>();
		return financialAssistanceVOs;
	}
	
	public FinancialAssistanceVO addFinancialAssistance(FinancialAssistanceVO inputVO) {
		return inputVO;
	}
	
	public FinancialAssistanceVO updateFinancialAssistance(FinancialAssistanceVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteFinancialAssistance(String financialAssistanceId) {
		return false;
	}
	
	public static FinancialAssistanceVO generateFinancialAssistanceVO() {
		FinancialAssistanceVO financialAssistanceVO = new FinancialAssistanceVO();
		
		return financialAssistanceVO;
	}
	
}