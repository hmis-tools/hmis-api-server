package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.MedicalAssistanceDTO;

public class MedicalAssistanceManager {

	public MedicalAssistanceManager() {}

	public MedicalAssistanceDTO getMedicalAssistanceById(String enrollmentId) {
		MedicalAssistanceDTO medicalAssistanceDTO = new MedicalAssistanceDTO();
		return medicalAssistanceDTO;
	}

	public List<MedicalAssistanceDTO> getMedicalAssistancesByEnrollmentId(String enrollmentId) {
		List<MedicalAssistanceDTO> medicalAssistanceDTOs = new ArrayList<MedicalAssistanceDTO>();
		return medicalAssistanceDTOs;
	}
	
	public MedicalAssistanceDTO addMedicalAssistance(MedicalAssistanceDTO inputVO) {
		return inputVO;
	}
	
	public MedicalAssistanceDTO updateMedicalAssistance(MedicalAssistanceDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteMedicalAssistance(String medicalAssistanceId) {
		return false;
	}
	
	public static MedicalAssistanceDTO generateMedicalAssistanceVO() {
		MedicalAssistanceDTO medicalAssistanceDTO = new MedicalAssistanceDTO();
		
		return medicalAssistanceDTO;
	}
	
}