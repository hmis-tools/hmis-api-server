package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.ChronicHealthConditionVO;

public class ChronicHealthConditionManager {

	public ChronicHealthConditionManager() {}

	public ChronicHealthConditionVO getChronicHealthConditionById(String enrollmentId) {
		ChronicHealthConditionVO chronicHealthConditionVO = new ChronicHealthConditionVO();
		return chronicHealthConditionVO;
	}

	public List<ChronicHealthConditionVO> getChronicHealthConditionsByEnrollmentId(String enrollmentId) {
		List<ChronicHealthConditionVO> chronicHealthConditionVOs = new ArrayList<ChronicHealthConditionVO>();
		return chronicHealthConditionVOs;
	}
	
	public ChronicHealthConditionVO addChronicHealthCondition(ChronicHealthConditionVO inputVO) {
		return inputVO;
	}
	
	public ChronicHealthConditionVO updateChronicHealthCondition(ChronicHealthConditionVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteChronicHealthCondition(String chronicHealthConditionId) {
		return false;
	}
	
	public static ChronicHealthConditionVO generateChronicHealthConditionVO() {
		ChronicHealthConditionVO chronicHealthConditionVO = new ChronicHealthConditionVO();
		
		return chronicHealthConditionVO;
	}
	
}