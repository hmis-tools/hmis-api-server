package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.FinancialAssistanceDTO;

public class FinancialAssistanceManager {

	public FinancialAssistanceManager() {}

	public FinancialAssistanceDTO getFinancialAssistanceById(String enrollmentId) {
		FinancialAssistanceDTO financialAssistanceDTO = new FinancialAssistanceDTO();
		return financialAssistanceDTO;
	}

	public List<FinancialAssistanceDTO> getFinancialAssistancesByEnrollmentId(String enrollmentId) {
		List<FinancialAssistanceDTO> financialAssistanceDTOs = new ArrayList<FinancialAssistanceDTO>();
		return financialAssistanceDTOs;
	}
	
	public FinancialAssistanceDTO addFinancialAssistance(FinancialAssistanceDTO inputVO) {
		return inputVO;
	}
	
	public FinancialAssistanceDTO updateFinancialAssistance(FinancialAssistanceDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteFinancialAssistance(String financialAssistanceId) {
		return false;
	}
	
	public static FinancialAssistanceDTO generateFinancialAssistanceVO() {
		FinancialAssistanceDTO financialAssistanceDTO = new FinancialAssistanceDTO();
		
		return financialAssistanceDTO;
	}
	
}