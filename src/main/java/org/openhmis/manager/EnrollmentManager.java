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
import org.openhmis.vo.ClientExitVO;
import org.openhmis.vo.EnrollmentVO;

public class EnrollmentManager {

	private static final PathClientProgramDAO pathClientProgramDAO = new PathClientProgramDAO();
	
	public EnrollmentManager() {}

	public EnrollmentVO getEnrollmentById(String enrollmentId) {
		Integer programKey = Integer.parseInt(enrollmentId);
		
		// Collect the data for this client
		PathClientProgram pathClientProgram = pathClientProgramDAO.getPathClientProgramByProgramKey(programKey);
		
		EnrollmentVO enrollmentVO = EnrollmentManager.generateEnrollmentVO(pathClientProgram);

		return enrollmentVO;
	}

	public List<EnrollmentVO> getEnrollments() {
		List<EnrollmentVO> enrollmentVOs = new ArrayList<EnrollmentVO>();
		
		// Collect the enrollments
		List<PathClientProgram> pathClientPrograms = pathClientProgramDAO.getPathClientPrograms();
		
		// For each enrollment, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<PathClientProgram> iterator = pathClientPrograms.iterator(); iterator.hasNext();) {
		 	PathClientProgram pathClientProgram = iterator.next();
		 	EnrollmentVO enrollmentVO = EnrollmentManager.generateEnrollmentVO(pathClientProgram);
		 	enrollmentVOs.add(enrollmentVO);
		 }
		
		return enrollmentVOs;
	}
	
	public EnrollmentVO addEnrollment(EnrollmentVO inputVO) {
		
		// Generate a PathClient from the input
		PathClientProgram pathClientProgram = EnrollmentManager.generatePathClientProgram(inputVO);
		pathClientProgramDAO.save(pathClientProgram);
		
		// Return the resulting VO
		return EnrollmentManager.generateEnrollmentVO(pathClientProgram);
	}
	
	public EnrollmentVO updateEnrollment(EnrollmentVO inputVO) {
		
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteEnrollment(String enrollmentId) {
		PathClientProgram pathClientProgram = pathClientProgramDAO.getPathClientProgramByProgramKey(Integer.parseInt(enrollmentId));
		pathClientProgramDAO.delete(pathClientProgram);
		
		return true;
	}
	
	public static EnrollmentVO generateEnrollmentVO(PathClientProgram pathClientProgram) {
		EnrollmentVO enrollmentVO = new EnrollmentVO();
		
		enrollmentVO.setEnrollmentId(pathClientProgram.getProgramKey().toString());

		// The client object associated with this enrollment
		enrollmentVO.setPersonalId(pathClientProgram.getClientKey().toString());

		// Project Exit Object
		enrollmentVO.setProjectExit(new ClientExitVO());

		// Universal Data Standard: Disabling Condition (2014, 3.8)
		enrollmentVO.setDisablingCondition(YesNoReason.NOT_COLLECTED);

		// Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)
		enrollmentVO.setResidencePrior(ClientResidencePrior.NOT_COLLECTED);
		enrollmentVO.setOtherResidence("");
		enrollmentVO.setResidencePriorLengthOfStay(ClientResidencePriorLengthOfStay.NOT_COLLECTED);

		// Universal Data Standard: Project Entry Date (2014, 3.10)
		enrollmentVO.setEntryDate(pathClientProgram.getEntryDate());

		// Universal Data Standard: Household ID (2014, 3.14)
		enrollmentVO.setHouseholdId("");

		// Universal Data Standard: Relationship to Head of Household (2014, 3.15)
		enrollmentVO.setRelationshipToHoH(ClientRelationshipToHoH.NOT_COLLECTED);

		// Universal Data Standard: Client Location (2014, 3.16)
		enrollmentVO.setClientLocationInformationDate(new Date());
		enrollmentVO.setCocCode("");

		// Universal Data Standard: Length of Time on Street, in an Emergency Shelter, or Safe Haven (2014, 3.17)
		enrollmentVO.setContinuouslyHomelessOneYear(YesNoReason.NOT_COLLECTED);
		enrollmentVO.setTimesHomelessInPastThreeYears(ClientTimesHomelessPastThreeYears.NOT_COLLECTED);
		enrollmentVO.setMonthsHomelessPastThreeYears(ClientMonthsHomelessPastThreeYears.NOT_COLLECTED);
		enrollmentVO.setMonthsHomelessThisTime(0);
		enrollmentVO.setStatusDocumentedCode(YesNo.NOT_COLLECTED);

		// Program Specific Data Standards: Housing Status (2014, 4.1)
		// Collection: Project Entry
		enrollmentVO.setHousingStatus(ClientHousingStatus.NOT_COLLECTED);

		// Program Specific Data Standards: Income Sources (2014, 4.2)
		enrollmentVO.setIncomeSources(new ArrayList<ClientEnrollmentIncomeSourceVO>());

		// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
		enrollmentVO.setNonCashBenefits(new ArrayList<ClientEnrollmentNonCashBenefitVO>());

		// Program Specific Data Standards: Health Insurance (2014, 4.4)
		enrollmentVO.setHealthInsurances(new ArrayList<ClientEnrollmentHealthInsuranceVO>());

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		enrollmentVO.setPhysicalDisabilities(new ArrayList<ClientEnrollmentPhysicalDisabilityVO>());

		// Program Specific Data Standards: Developmental Disability (2014, 4.6)
		enrollmentVO.setDevelopmentalDisabilities(new ArrayList<ClientEnrollmentDevelopmentalDisabilityVO>());
		
		// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
		enrollmentVO.setChronicHealthConditions(new ArrayList<ClientEnrollmentChronicHealthConditionVO>());

		// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
		enrollmentVO.setHivAidsStatuses(new ArrayList<ClientEnrollmentHivAidsVO>());

		// Program Specific Data Standards: Mental Health Problem (2014, 4.9)
		enrollmentVO.setMentalHealthProblems(new ArrayList<ClientEnrollmentMentalHealthProblemVO>());

		// Program Specific Data Standards: Substance Abuse (2014, 4.10)
		enrollmentVO.setSubstanceAbuses(new ArrayList<ClientEnrollmentSubstanceAbuseVO>());

		// Program Specific Data Standards: Domestic Abuse (2014, 4.11)
		enrollmentVO.setDomesticAbuses(new ArrayList<ClientEnrollmentDomesticAbuseVO>());

		// Program Specific Data Standards: Contact (2014, 4.12)
		enrollmentVO.setContacts(new ArrayList<ClientEnrollmentContactVO>());

		// Program Specific Data Standards: Date of Engagement (2014, 4.13)
		enrollmentVO.setDateOfEngagement(pathClientProgram.getEngagementDate());

		// Program Specific Data Standards: Services Provided (2014, 4.14)
		enrollmentVO.setServices(new ArrayList<ClientEnrollmentServiceVO>());

		// Program Specific Data Standards: Financial Assets Provided (2014, 4.15)
		enrollmentVO.setFinancialAssistances(new ArrayList<ClientEnrollmentFinancialAssistanceVO>());

		// Program Specific Data Standards: References Provided (2014, 4.16)
		enrollmentVO.setReferrals(new ArrayList<ClientEnrollmentReferralVO>());

		// Program Specific Data Standards: Residential Move-in Date (2014, 4.17)
		enrollmentVO.setResidentialMoveInDate(new Date());
		enrollmentVO.setInPermanentHousing(YesNo.NOT_COLLECTED);
		enrollmentVO.setPermanentHousingMoveDate(new Date());

		// PATH Specific Data Standards: PATH Status (2014, 4.20)
		enrollmentVO.setDateOfPathStatus(new Date());
		enrollmentVO.setClientEnrolledInPath(YesNo.NOT_COLLECTED);
		enrollmentVO.setReasonNotEnrolled(ClientReasonNotEnrolled.NOT_COLLECTED);

		// RHY Specific Data Standards: RHY-BCP Status (2014, 4.22)
		enrollmentVO.setDateOfBcpStatus(new Date());
		enrollmentVO.setFysbYouth(YesNo.NOT_COLLECTED);
		enrollmentVO.setReasonNoServices(ClientReasonNoServices.NOT_COLLECTED);

		// RHY Specific Data Standards: Sexual Orientation (2014, 4.23)
		enrollmentVO.setSexualOrientation(ClientSexualOrientation.NOT_COLLECTED);

		// RHY Specific Data Standards: Last Grade Completed (2014, 4.24)
		enrollmentVO.setLastGradeCompleted(ClientLastGradeCompleted.NOT_COLLECTED);
		
		// RHY Specific Data Standards: School Status (2014, 4.25)
		enrollmentVO.setSchoolStatus(ClientSchoolStatus.NOT_COLLECTED);

		// RHY Specific Data Standards: Employment Status (2014, 4.26)
		enrollmentVO.setEmployedInformationDate(new Date());
		enrollmentVO.setEmployed(YesNoReason.NOT_COLLECTED);
		enrollmentVO.setEmploymentType(ClientEmploymentType.NOT_COLLECTED);
		enrollmentVO.setNotEmployedReason(ClientNotEmployedReason.NOT_COLLECTED);

		// RHY Specific Data Standards: General Health Status (2014, 4.27)
		enrollmentVO.setGeneralHealthStatus(ClientHealthStatus.NOT_COLLECTED);

		// RHY Specific Data Standards: Dental Health Status (2014, 4.28)
		enrollmentVO.setDentalHealthStatus(ClientHealthStatus.NOT_COLLECTED);

		// RHY Specific Data Standards: Mental Health Status (2014, 4.29)
		enrollmentVO.setMentalHealthStatus(ClientHealthStatus.NOT_COLLECTED);

		// RHY Specific Data Standards: Pregnancy Status (2014, 4.30)
		enrollmentVO.setPregnancyStatusCode(YesNoReason.NOT_COLLECTED);
		enrollmentVO.setPregnancyDueDate(new Date());

		// RHY Specific Data Standards: Formerly Child Welfare (2014, 4.31)
		enrollmentVO.setFormerlyChildWelfare(YesNoReason.NOT_COLLECTED);
		enrollmentVO.setChildWelfareYears(ClientRhyNumberOfYears.NOT_COLLECTED);
		enrollmentVO.setChildWelfareMonths(0);

		// RHY Specific Data Standards: Formerly Juvenile Justice (2014, 4.32)
		enrollmentVO.setFormerWardJuvenileJustice(YesNoReason.NOT_COLLECTED);
		enrollmentVO.setJuvenileJusticeYears(ClientRhyNumberOfYears.NOT_COLLECTED);
		enrollmentVO.setJuvenileJusticeMonths(0);

		// RHY Specific Data Standards: Young Person's Critical Issues (2014, 4.33)
		enrollmentVO.setHouseholdDynamics(YesNo.NOT_COLLECTED);
		enrollmentVO.setSexualOrientationGenderIdYouth(YesNo.NOT_COLLECTED);
		enrollmentVO.setSexualOrientationGenderIdFam(YesNo.NOT_COLLECTED);
		enrollmentVO.setHousingIssuesYouth(YesNo.NOT_COLLECTED);
		enrollmentVO.setHousingIssuesFam(YesNo.NOT_COLLECTED);
		enrollmentVO.setSchoolEducationalIssuesYouth(YesNo.NOT_COLLECTED);
		enrollmentVO.setSchoolEducationalIssuesFam(YesNo.NOT_COLLECTED);
		enrollmentVO.setUnemploymentYouth(YesNo.NOT_COLLECTED);
		enrollmentVO.setUnemploymentFam(YesNo.NOT_COLLECTED);
		enrollmentVO.setMentalHealthIssuesYouth(YesNo.NOT_COLLECTED);
		enrollmentVO.setMentalHealthIssuesFam(YesNo.NOT_COLLECTED);
		enrollmentVO.setHealthIssuesYouth(YesNo.NOT_COLLECTED);
		enrollmentVO.setHealthIssuesFam(YesNo.NOT_COLLECTED);
		enrollmentVO.setPhysicalDisabilityYouth(YesNo.NOT_COLLECTED);
		enrollmentVO.setPhysicalDisabilityFam(YesNo.NOT_COLLECTED);
		enrollmentVO.setMentalDisabilityYouth(YesNo.NOT_COLLECTED);
		enrollmentVO.setMentalDisabilityFam(YesNo.NOT_COLLECTED);
		enrollmentVO.setAbuseAndNeglectYouth(YesNo.NOT_COLLECTED);
		enrollmentVO.setAbuseAndNeglectFam(YesNo.NOT_COLLECTED);
		enrollmentVO.setAlcoholDrugAbuseYouth(YesNo.NOT_COLLECTED);
		enrollmentVO.setAlcoholDrugAbuseFam(YesNo.NOT_COLLECTED);
		enrollmentVO.setInsufficientIncome(YesNo.NOT_COLLECTED);
		enrollmentVO.setActiveMilitaryParent(YesNo.NOT_COLLECTED);
		enrollmentVO.setIncarceratedParent(YesNo.NOT_COLLECTED);
		enrollmentVO.setIncarceratedParentStatus(ClientIncarceratedParentStatus.NOT_COLLECTED);

		// RHY Specific Data Standards: Referral Source (2014, 4.34)
		enrollmentVO.setReferralSource(ClientReferralSource.NOT_COLLECTED);
		enrollmentVO.setCountOUtreachReferralApproaches(0);

		// RHY Specific Data Standards: Commercial Sexual Exploitation (2014, 4.35)
		enrollmentVO.setExchangeForSexPastThreeMonths(YesNoReason.NOT_COLLECTED);
		enrollmentVO.setCountOfExchangeForSex(ClientCountExchangeForSex.NOT_COLLECTED);
		enrollmentVO.setAskedOrForcedToExchangeForSex(YesNoReason.NOT_COLLECTED);

		// HOPWA Specific Data Standards: Medical Assistance (2014, 4.39)
		enrollmentVO.setMedicalAssistances(new ArrayList<ClientEnrollmentHopwaMedicalAssistanceVO>());

		// RHSP Specific Data Standards: Worst Housing Situation (2014, 4.40)
		enrollmentVO.setWorstHousingSituation(YesNoReason.NOT_COLLECTED);

		// VA Specific Data Standards: Percent of AMI (2014, 4.42)
		enrollmentVO.setPercentAmi(ClientPercentAmi.NOT_COLLECTED);

		// VA Specific Data Standards: Last Permanent Address (2014, 4.43)
		enrollmentVO.setLastPermanentStreet("");
		enrollmentVO.setLastPermanentCity("");
		enrollmentVO.setLastPermanentState("");
		enrollmentVO.setLastPermanentZip("");
		enrollmentVO.setAddressDataQuality(ClientAddressDataQuality.NOT_COLLECTED);

		// Export Standard Fields
		enrollmentVO.setDateCreated(pathClientProgram.getCreateDate());
		enrollmentVO.setDateUpdated(pathClientProgram.getUpdateDate());
		
		return enrollmentVO;
	}
	
	public static PathClientProgram generatePathClientProgram(EnrollmentVO enrollmentVO) {
		PathClientProgram pathClientProgram = new PathClientProgram();
		pathClientProgram.setProgramKey(Integer.parseInt(enrollmentVO.getEnrollmentId()));
		pathClientProgram.setClientKey(Integer.parseInt(enrollmentVO.getPersonalId()));
		pathClientProgram.setUpdateDate(new Date());
		pathClientProgram.setUpdateTimestamp(new Date());
		
		return new PathClientProgram();
	}	
	
}