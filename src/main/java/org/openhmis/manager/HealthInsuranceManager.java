package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.HealthInsuranceVO;

public class HealthInsuranceManager {

	public HealthInsuranceManager() {}

	public HealthInsuranceVO getHealthInsuranceById(String enrollmentId) {
		HealthInsuranceVO healthInsuranceVO = new HealthInsuranceVO();
		return healthInsuranceVO;
	}

	public List<HealthInsuranceVO> getHealthInsurancesByEnrollmentId(String enrollmentId) {
		List<HealthInsuranceVO> healthInsuranceVOs = new ArrayList<HealthInsuranceVO>();
		return healthInsuranceVOs;
	}
	
	public HealthInsuranceVO addHealthInsurance(HealthInsuranceVO inputVO) {
		return inputVO;
	}
	
	public HealthInsuranceVO updateHealthInsurance(HealthInsuranceVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteHealthInsurance(String healthInsuranceId) {
		return false;
	}
	
	public static HealthInsuranceVO generateHealthInsuranceVO() {
		HealthInsuranceVO healthInsuranceVO = new HealthInsuranceVO();
		
		return healthInsuranceVO;
	}
	
}