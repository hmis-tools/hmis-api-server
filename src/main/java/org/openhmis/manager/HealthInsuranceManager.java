package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.HealthInsuranceDTO;

public class HealthInsuranceManager {

	public HealthInsuranceManager() {}

	public HealthInsuranceDTO getHealthInsuranceById(String enrollmentId) {
		HealthInsuranceDTO healthInsuranceDTO = new HealthInsuranceDTO();
		return healthInsuranceDTO;
	}

	public List<HealthInsuranceDTO> getHealthInsurancesByEnrollmentId(String enrollmentId) {
		List<HealthInsuranceDTO> healthInsuranceDTOs = new ArrayList<HealthInsuranceDTO>();
		return healthInsuranceDTOs;
	}
	
	public HealthInsuranceDTO addHealthInsurance(HealthInsuranceDTO inputVO) {
		return inputVO;
	}
	
	public HealthInsuranceDTO updateHealthInsurance(HealthInsuranceDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteHealthInsurance(String healthInsuranceId) {
		return false;
	}
	
	public static HealthInsuranceDTO generateHealthInsuranceVO() {
		HealthInsuranceDTO healthInsuranceDTO = new HealthInsuranceDTO();
		
		return healthInsuranceDTO;
	}
	
}