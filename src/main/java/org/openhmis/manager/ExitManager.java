package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openhmis.code.ClientAddressDataQuality;
import org.openhmis.code.ClientCountExchangeForSex;
import org.openhmis.code.ClientEmploymentType;
import org.openhmis.code.ClientHealthStatus;
import org.openhmis.code.ClientHousingStatus;
import org.openhmis.code.ClientIncarceratedParentStatus;
import org.openhmis.code.ClientLastGradeCompleted;
import org.openhmis.code.ClientMonthsHomelessPastThreeYears;
import org.openhmis.code.ClientNotEmployedReason;
import org.openhmis.code.ClientPercentAmi;
import org.openhmis.code.ClientReasonNoServices;
import org.openhmis.code.ClientReasonNotEnrolled;
import org.openhmis.code.ClientReferralSource;
import org.openhmis.code.ClientRelationshipToHoH;
import org.openhmis.code.ClientResidencePrior;
import org.openhmis.code.ClientResidencePriorLengthOfStay;
import org.openhmis.code.ClientRhyNumberOfYears;
import org.openhmis.code.ClientSchoolStatus;
import org.openhmis.code.ClientSexualOrientation;
import org.openhmis.code.ClientTimesHomelessPastThreeYears;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.PathClientProgramDAO;
import org.openhmis.domain.PathClientProgram;
import org.openhmis.vo.ClientEnrollmentChronicHealthConditionVO;
import org.openhmis.vo.ClientEnrollmentContactVO;
import org.openhmis.vo.ClientEnrollmentDevelopmentalDisabilityVO;
import org.openhmis.vo.ClientEnrollmentDomesticAbuseVO;
import org.openhmis.vo.ClientEnrollmentFinancialAssistanceVO;
import org.openhmis.vo.ClientEnrollmentHealthInsuranceVO;
import org.openhmis.vo.ClientEnrollmentHivAidsVO;
import org.openhmis.vo.ClientEnrollmentHopwaMedicalAssistanceVO;
import org.openhmis.vo.ClientEnrollmentIncomeSourceVO;
import org.openhmis.vo.ClientEnrollmentMentalHealthProblemVO;
import org.openhmis.vo.ClientEnrollmentNonCashBenefitVO;
import org.openhmis.vo.ClientEnrollmentPhysicalDisabilityVO;
import org.openhmis.vo.ClientEnrollmentReferralVO;
import org.openhmis.vo.ClientEnrollmentServiceVO;
import org.openhmis.vo.ClientEnrollmentSubstanceAbuseVO;
import org.openhmis.vo.ExitVO;
import org.openhmis.vo.EnrollmentVO;

public class ExitManager {

	private static final PathClientProgramDAO pathClientProgramDAO = new PathClientProgramDAO();
	
	public ExitManager() {}

	public ExitVO getExitById(String enrollmentId) {
		ExitVO exitVO = new ExitVO();
		return exitVO;
	}

	public List<ExitVO> getExitsByEnrollmentId(String enrollmentId) {
		List<ExitVO> exitVOs = new ArrayList<ExitVO>();
		return exitVOs;
	}
	
	public ExitVO addExit(ExitVO inputVO) {
		return inputVO;
	}
	
	public ExitVO updateExit(ExitVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteExit(String exitId) {
		return false;
	}
	
	public static ExitVO generateExitVO() {
		ExitVO exitVO = new ExitVO();
		
		return exitVO;
	}
	
}