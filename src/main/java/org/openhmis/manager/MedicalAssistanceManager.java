package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.MedicalAssistanceVO;

public class MedicalAssistanceManager {

	public MedicalAssistanceManager() {}

	public MedicalAssistanceVO getMedicalAssistanceById(String enrollmentId) {
		MedicalAssistanceVO medicalAssistanceVO = new MedicalAssistanceVO();
		return medicalAssistanceVO;
	}

	public List<MedicalAssistanceVO> getMedicalAssistancesByEnrollmentId(String enrollmentId) {
		List<MedicalAssistanceVO> medicalAssistanceVOs = new ArrayList<MedicalAssistanceVO>();
		return medicalAssistanceVOs;
	}
	
	public MedicalAssistanceVO addMedicalAssistance(MedicalAssistanceVO inputVO) {
		return inputVO;
	}
	
	public MedicalAssistanceVO updateMedicalAssistance(MedicalAssistanceVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteMedicalAssistance(String medicalAssistanceId) {
		return false;
	}
	
	public static MedicalAssistanceVO generateMedicalAssistanceVO() {
		MedicalAssistanceVO medicalAssistanceVO = new MedicalAssistanceVO();
		
		return medicalAssistanceVO;
	}
	
}