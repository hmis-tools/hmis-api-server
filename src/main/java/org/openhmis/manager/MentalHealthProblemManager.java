package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.MentalHealthProblemVO;

public class MentalHealthProblemManager {

	public MentalHealthProblemManager() {}

	public MentalHealthProblemVO getMentalHealthProblemById(String enrollmentId) {
		MentalHealthProblemVO mentalHealthProblemVO = new MentalHealthProblemVO();
		return mentalHealthProblemVO;
	}

	public List<MentalHealthProblemVO> getMentalHealthProblemsByEnrollmentId(String enrollmentId) {
		List<MentalHealthProblemVO> mentalHealthProblemVOs = new ArrayList<MentalHealthProblemVO>();
		return mentalHealthProblemVOs;
	}
	
	public MentalHealthProblemVO addMentalHealthProblem(MentalHealthProblemVO inputVO) {
		return inputVO;
	}
	
	public MentalHealthProblemVO updateMentalHealthProblem(MentalHealthProblemVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteMentalHealthProblem(String mentalHealthProblemId) {
		return false;
	}
	
	public static MentalHealthProblemVO generateMentalHealthProblemVO() {
		MentalHealthProblemVO mentalHealthProblemVO = new MentalHealthProblemVO();
		
		return mentalHealthProblemVO;
	}
	
}