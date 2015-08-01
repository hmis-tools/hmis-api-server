package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import org.openhmis.dto.ChronicHealthConditionDTO;
import org.openhmis.dto.ContactDTO;
import org.openhmis.dto.DevelopmentalDisabilityDTO;
import org.openhmis.dto.DomesticAbuseDTO;
import org.openhmis.dto.EnrollmentDTO;
import org.openhmis.dto.ExitDTO;
import org.openhmis.dto.FinancialAssistanceDTO;
import org.openhmis.dto.HealthInsuranceDTO;
import org.openhmis.dto.HivAidsStatusDTO;
import org.openhmis.dto.IncomeSourceDTO;
import org.openhmis.dto.MedicalAssistanceDTO;
import org.openhmis.dto.MentalHealthProblemDTO;
import org.openhmis.dto.NonCashBenefitDTO;
import org.openhmis.dto.PhysicalDisabilityDTO;
import org.openhmis.dto.ReferralDTO;
import org.openhmis.dto.ServiceDTO;
import org.openhmis.dto.SubstanceAbuseDTO;

public class EnrollmentManager {

	private static final PathClientProgramDAO pathClientProgramDAO = new PathClientProgramDAO();
	
	public EnrollmentManager() {}

	public EnrollmentDTO getEnrollmentById(String enrollmentId) {
		Integer programKey = Integer.parseInt(enrollmentId);
		
		// Collect the data for this client
		PathClientProgram pathClientProgram = pathClientProgramDAO.getPathClientProgramByProgramKey(programKey);
		
		EnrollmentDTO enrollmentDTO = EnrollmentManager.generateEnrollmentVO(pathClientProgram);

		return enrollmentDTO;
	}

	public List<EnrollmentDTO> getEnrollments() {
		List<EnrollmentDTO> enrollmentDTOs = new ArrayList<EnrollmentDTO>();
		
		// Collect the enrollments
		List<PathClientProgram> pathClientPrograms = pathClientProgramDAO.getPathClientPrograms();
		
		// For each enrollment, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<PathClientProgram> iterator = pathClientPrograms.iterator(); iterator.hasNext();) {
		 	PathClientProgram pathClientProgram = iterator.next();
		 	EnrollmentDTO enrollmentDTO = EnrollmentManager.generateEnrollmentVO(pathClientProgram);
		 	enrollmentDTOs.add(enrollmentDTO);
		 }
		
		return enrollmentDTOs;
	}
	
	public EnrollmentDTO addEnrollment(EnrollmentDTO inputVO) {
		
		// Generate a PathClient from the input
		PathClientProgram pathClientProgram = EnrollmentManager.generatePathClientProgram(inputVO);
		pathClientProgram.setCreateDate(new Date());
		pathClientProgram.setUpdateDate(new Date());
		pathClientProgram.setUpdateTimestamp(new Date());
		pathClientProgramDAO.save(pathClientProgram);
		
		// Return the resulting VO
		return EnrollmentManager.generateEnrollmentVO(pathClientProgram);
	}
	
	public EnrollmentDTO updateEnrollment(EnrollmentDTO inputVO) {
		PathClientProgram pathClientProgram = EnrollmentManager.generatePathClientProgram(inputVO);
		pathClientProgram.setProgramKey(Integer.parseInt(inputVO.getEnrollmentId()));

		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteEnrollment(String enrollmentId) {
		PathClientProgram pathClientProgram = pathClientProgramDAO.getPathClientProgramByProgramKey(Integer.parseInt(enrollmentId));
		pathClientProgramDAO.delete(pathClientProgram);
		
		return true;
	}
	
	public static EnrollmentDTO generateEnrollmentVO(PathClientProgram pathClientProgram) {
		EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
		
		enrollmentDTO.setEnrollmentId(pathClientProgram.getProgramKey().toString());

		// The client object associated with this enrollment
		enrollmentDTO.setPersonalId(pathClientProgram.getClientKey().toString());

		// Project Exit Object
		enrollmentDTO.setProjectExit(new ExitDTO());

		// Universal Data Standard: Disabling Condition (2014, 3.8)
		enrollmentDTO.setDisablingCondition(YesNoReason.NOT_COLLECTED);

		// Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)
		enrollmentDTO.setResidencePrior(ClientResidencePrior.NOT_COLLECTED);
		enrollmentDTO.setOtherResidence("");
		enrollmentDTO.setResidencePriorLengthOfStay(ClientResidencePriorLengthOfStay.NOT_COLLECTED);

		// Universal Data Standard: Project Entry Date (2014, 3.10)
		enrollmentDTO.setEntryDate(pathClientProgram.getEntryDate());

		// Universal Data Standard: Household ID (2014, 3.14)
		enrollmentDTO.setHouseholdId("");

		// Universal Data Standard: Relationship to Head of Household (2014, 3.15)
		enrollmentDTO.setRelationshipToHoH(ClientRelationshipToHoH.NOT_COLLECTED);

		// Universal Data Standard: Client Location (2014, 3.16)
		enrollmentDTO.setClientLocationInformationDate(new Date());
		enrollmentDTO.setCocCode("");

		// Universal Data Standard: Length of Time on Street, in an Emergency Shelter, or Safe Haven (2014, 3.17)
		enrollmentDTO.setContinuouslyHomelessOneYear(YesNoReason.NOT_COLLECTED);
		enrollmentDTO.setTimesHomelessInPastThreeYears(ClientTimesHomelessPastThreeYears.NOT_COLLECTED);
		enrollmentDTO.setMonthsHomelessPastThreeYears(ClientMonthsHomelessPastThreeYears.NOT_COLLECTED);
		enrollmentDTO.setMonthsHomelessThisTime(0);
		enrollmentDTO.setStatusDocumentedCode(YesNo.NOT_COLLECTED);

		// Program Specific Data Standards: Housing Status (2014, 4.1)
		// Collection: Project Entry
		enrollmentDTO.setHousingStatus(ClientHousingStatus.NOT_COLLECTED);

		// Program Specific Data Standards: Income Sources (2014, 4.2)
		enrollmentDTO.setIncomeSources(new ArrayList<IncomeSourceDTO>());

		// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
		enrollmentDTO.setNonCashBenefits(new ArrayList<NonCashBenefitDTO>());

		// Program Specific Data Standards: Health Insurance (2014, 4.4)
		enrollmentDTO.setHealthInsurances(new ArrayList<HealthInsuranceDTO>());

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		enrollmentDTO.setPhysicalDisabilities(new ArrayList<PhysicalDisabilityDTO>());

		// Program Specific Data Standards: Developmental Disability (2014, 4.6)
		enrollmentDTO.setDevelopmentalDisabilities(new ArrayList<DevelopmentalDisabilityDTO>());
		
		// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
		enrollmentDTO.setChronicHealthConditions(new ArrayList<ChronicHealthConditionDTO>());

		// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
		enrollmentDTO.setHivAidsStatuses(new ArrayList<HivAidsStatusDTO>());

		// Program Specific Data Standards: Mental Health Problem (2014, 4.9)
		enrollmentDTO.setMentalHealthProblems(new ArrayList<MentalHealthProblemDTO>());

		// Program Specific Data Standards: Substance Abuse (2014, 4.10)
		enrollmentDTO.setSubstanceAbuses(new ArrayList<SubstanceAbuseDTO>());

		// Program Specific Data Standards: Domestic Abuse (2014, 4.11)
		enrollmentDTO.setDomesticAbuses(new ArrayList<DomesticAbuseDTO>());

		// Program Specific Data Standards: Contact (2014, 4.12)
		enrollmentDTO.setContacts(new ArrayList<ContactDTO>());

		// Program Specific Data Standards: Date of Engagement (2014, 4.13)
		enrollmentDTO.setDateOfEngagement(pathClientProgram.getEngagementDate());

		// Program Specific Data Standards: Services Provided (2014, 4.14)
		enrollmentDTO.setServices(new ArrayList<ServiceDTO>());

		// Program Specific Data Standards: Financial Assets Provided (2014, 4.15)
		enrollmentDTO.setFinancialAssistances(new ArrayList<FinancialAssistanceDTO>());

		// Program Specific Data Standards: References Provided (2014, 4.16)
		enrollmentDTO.setReferrals(new ArrayList<ReferralDTO>());

		// Program Specific Data Standards: Residential Move-in Date (2014, 4.17)
		enrollmentDTO.setResidentialMoveInDate(new Date());
		enrollmentDTO.setInPermanentHousing(YesNo.NOT_COLLECTED);
		enrollmentDTO.setPermanentHousingMoveDate(new Date());

		// PATH Specific Data Standards: PATH Status (2014, 4.20)
		enrollmentDTO.setDateOfPathStatus(new Date());
		enrollmentDTO.setClientEnrolledInPath(YesNo.NOT_COLLECTED);
		enrollmentDTO.setReasonNotEnrolled(ClientReasonNotEnrolled.NOT_COLLECTED);

		// RHY Specific Data Standards: RHY-BCP Status (2014, 4.22)
		enrollmentDTO.setDateOfBcpStatus(new Date());
		enrollmentDTO.setFysbYouth(YesNo.NOT_COLLECTED);
		enrollmentDTO.setReasonNoServices(ClientReasonNoServices.NOT_COLLECTED);

		// RHY Specific Data Standards: Sexual Orientation (2014, 4.23)
		enrollmentDTO.setSexualOrientation(ClientSexualOrientation.NOT_COLLECTED);

		// RHY Specific Data Standards: Last Grade Completed (2014, 4.24)
		enrollmentDTO.setLastGradeCompleted(ClientLastGradeCompleted.NOT_COLLECTED);
		
		// RHY Specific Data Standards: School Status (2014, 4.25)
		enrollmentDTO.setSchoolStatus(ClientSchoolStatus.NOT_COLLECTED);

		// RHY Specific Data Standards: Employment Status (2014, 4.26)
		enrollmentDTO.setEmployedInformationDate(new Date());
		enrollmentDTO.setEmployed(YesNoReason.NOT_COLLECTED);
		enrollmentDTO.setEmploymentType(ClientEmploymentType.NOT_COLLECTED);
		enrollmentDTO.setNotEmployedReason(ClientNotEmployedReason.NOT_COLLECTED);

		// RHY Specific Data Standards: General Health Status (2014, 4.27)
		enrollmentDTO.setGeneralHealthStatus(ClientHealthStatus.NOT_COLLECTED);

		// RHY Specific Data Standards: Dental Health Status (2014, 4.28)
		enrollmentDTO.setDentalHealthStatus(ClientHealthStatus.NOT_COLLECTED);

		// RHY Specific Data Standards: Mental Health Status (2014, 4.29)
		enrollmentDTO.setMentalHealthStatus(ClientHealthStatus.NOT_COLLECTED);

		// RHY Specific Data Standards: Pregnancy Status (2014, 4.30)
		enrollmentDTO.setPregnancyStatusCode(YesNoReason.NOT_COLLECTED);
		enrollmentDTO.setPregnancyDueDate(new Date());

		// RHY Specific Data Standards: Formerly Child Welfare (2014, 4.31)
		enrollmentDTO.setFormerlyChildWelfare(YesNoReason.NOT_COLLECTED);
		enrollmentDTO.setChildWelfareYears(ClientRhyNumberOfYears.NOT_COLLECTED);
		enrollmentDTO.setChildWelfareMonths(0);

		// RHY Specific Data Standards: Formerly Juvenile Justice (2014, 4.32)
		enrollmentDTO.setFormerWardJuvenileJustice(YesNoReason.NOT_COLLECTED);
		enrollmentDTO.setJuvenileJusticeYears(ClientRhyNumberOfYears.NOT_COLLECTED);
		enrollmentDTO.setJuvenileJusticeMonths(0);

		// RHY Specific Data Standards: Young Person's Critical Issues (2014, 4.33)
		enrollmentDTO.setHouseholdDynamics(YesNo.NOT_COLLECTED);
		enrollmentDTO.setSexualOrientationGenderIdYouth(YesNo.NOT_COLLECTED);
		enrollmentDTO.setSexualOrientationGenderIdFam(YesNo.NOT_COLLECTED);
		enrollmentDTO.setHousingIssuesYouth(YesNo.NOT_COLLECTED);
		enrollmentDTO.setHousingIssuesFam(YesNo.NOT_COLLECTED);
		enrollmentDTO.setSchoolEducationalIssuesYouth(YesNo.NOT_COLLECTED);
		enrollmentDTO.setSchoolEducationalIssuesFam(YesNo.NOT_COLLECTED);
		enrollmentDTO.setUnemploymentYouth(YesNo.NOT_COLLECTED);
		enrollmentDTO.setUnemploymentFam(YesNo.NOT_COLLECTED);
		enrollmentDTO.setMentalHealthIssuesYouth(YesNo.NOT_COLLECTED);
		enrollmentDTO.setMentalHealthIssuesFam(YesNo.NOT_COLLECTED);
		enrollmentDTO.setHealthIssuesYouth(YesNo.NOT_COLLECTED);
		enrollmentDTO.setHealthIssuesFam(YesNo.NOT_COLLECTED);
		enrollmentDTO.setPhysicalDisabilityYouth(YesNo.NOT_COLLECTED);
		enrollmentDTO.setPhysicalDisabilityFam(YesNo.NOT_COLLECTED);
		enrollmentDTO.setMentalDisabilityYouth(YesNo.NOT_COLLECTED);
		enrollmentDTO.setMentalDisabilityFam(YesNo.NOT_COLLECTED);
		enrollmentDTO.setAbuseAndNeglectYouth(YesNo.NOT_COLLECTED);
		enrollmentDTO.setAbuseAndNeglectFam(YesNo.NOT_COLLECTED);
		enrollmentDTO.setAlcoholDrugAbuseYouth(YesNo.NOT_COLLECTED);
		enrollmentDTO.setAlcoholDrugAbuseFam(YesNo.NOT_COLLECTED);
		enrollmentDTO.setInsufficientIncome(YesNo.NOT_COLLECTED);
		enrollmentDTO.setActiveMilitaryParent(YesNo.NOT_COLLECTED);
		enrollmentDTO.setIncarceratedParent(YesNo.NOT_COLLECTED);
		enrollmentDTO.setIncarceratedParentStatus(ClientIncarceratedParentStatus.NOT_COLLECTED);

		// RHY Specific Data Standards: Referral Source (2014, 4.34)
		enrollmentDTO.setReferralSource(ClientReferralSource.NOT_COLLECTED);
		enrollmentDTO.setCountOUtreachReferralApproaches(0);

		// RHY Specific Data Standards: Commercial Sexual Exploitation (2014, 4.35)
		enrollmentDTO.setExchangeForSexPastThreeMonths(YesNoReason.NOT_COLLECTED);
		enrollmentDTO.setCountOfExchangeForSex(ClientCountExchangeForSex.NOT_COLLECTED);
		enrollmentDTO.setAskedOrForcedToExchangeForSex(YesNoReason.NOT_COLLECTED);

		// HOPWA Specific Data Standards: Medical Assistance (2014, 4.39)
		enrollmentDTO.setMedicalAssistances(new ArrayList<MedicalAssistanceDTO>());

		// RHSP Specific Data Standards: Worst Housing Situation (2014, 4.40)
		enrollmentDTO.setWorstHousingSituation(YesNoReason.NOT_COLLECTED);

		// VA Specific Data Standards: Percent of AMI (2014, 4.42)
		enrollmentDTO.setPercentAmi(ClientPercentAmi.NOT_COLLECTED);

		// VA Specific Data Standards: Last Permanent Address (2014, 4.43)
		enrollmentDTO.setLastPermanentStreet("");
		enrollmentDTO.setLastPermanentCity("");
		enrollmentDTO.setLastPermanentState("");
		enrollmentDTO.setLastPermanentZip("");
		enrollmentDTO.setAddressDataQuality(ClientAddressDataQuality.NOT_COLLECTED);

		// Export Standard Fields
		enrollmentDTO.setDateCreated(pathClientProgram.getCreateDate());
		enrollmentDTO.setDateUpdated(pathClientProgram.getUpdateDate());
		
		return enrollmentDTO;
	}
	
	public static PathClientProgram generatePathClientProgram(EnrollmentDTO enrollmentDTO) {
		PathClientProgram pathClientProgram = new PathClientProgram();
		pathClientProgram.setClientKey(Integer.parseInt(enrollmentDTO.getPersonalId()));
		pathClientProgram.setUpdateDate(new Date());
		pathClientProgram.setUpdateTimestamp(new Date());
		
		return pathClientProgram;
	}	
	
}