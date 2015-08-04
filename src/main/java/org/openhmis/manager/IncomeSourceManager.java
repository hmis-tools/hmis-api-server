package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.IncomeSourceDTO;

public class IncomeSourceManager {

	public IncomeSourceManager() {}

	public IncomeSourceDTO getIncomeSourceById(String enrollmentId) {
		IncomeSourceDTO incomeSourceDTO = new IncomeSourceDTO();
		return incomeSourceDTO;
	}

	public List<IncomeSourceDTO> getIncomeSourcesByEnrollmentId(String enrollmentId) {
		List<IncomeSourceDTO> incomeSourceDTOs = new ArrayList<IncomeSourceDTO>();
		return incomeSourceDTOs;
	}
	
	public IncomeSourceDTO addIncomeSource(IncomeSourceDTO inputVO) {
		return inputVO;
	}
	
	public IncomeSourceDTO updateIncomeSource(IncomeSourceDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteIncomeSource(String incomeSourceId) {
		return false;
	}
	
	public static IncomeSourceDTO generateIncomeSourceDTO() {
		IncomeSourceDTO incomeSourceDTO = new IncomeSourceDTO();
		
		return incomeSourceDTO;
	}
	
}