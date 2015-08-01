package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.MentalHealthProblemDTO;

public class MentalHealthProblemManager {

	public MentalHealthProblemManager() {}

	public MentalHealthProblemDTO getMentalHealthProblemById(String enrollmentId) {
		MentalHealthProblemDTO mentalHealthProblemDTO = new MentalHealthProblemDTO();
		return mentalHealthProblemDTO;
	}

	public List<MentalHealthProblemDTO> getMentalHealthProblemsByEnrollmentId(String enrollmentId) {
		List<MentalHealthProblemDTO> mentalHealthProblemDTOs = new ArrayList<MentalHealthProblemDTO>();
		return mentalHealthProblemDTOs;
	}
	
	public MentalHealthProblemDTO addMentalHealthProblem(MentalHealthProblemDTO inputVO) {
		return inputVO;
	}
	
	public MentalHealthProblemDTO updateMentalHealthProblem(MentalHealthProblemDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteMentalHealthProblem(String mentalHealthProblemId) {
		return false;
	}
	
	public static MentalHealthProblemDTO generateMentalHealthProblemVO() {
		MentalHealthProblemDTO mentalHealthProblemDTO = new MentalHealthProblemDTO();
		
		return mentalHealthProblemDTO;
	}
	
}