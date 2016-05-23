package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openhmis.code.ClientAddressDataQuality;
import org.openhmis.code.ClientCountExchangeForSex;
import org.openhmis.code.ClientDobDataQuality;
import org.openhmis.code.ClientEmploymentType;
import org.openhmis.code.ClientEthnicity;
import org.openhmis.code.ClientGender;
import org.openhmis.code.ClientHealthStatus;
import org.openhmis.code.ClientHousingStatus;
import org.openhmis.code.ClientIncarceratedParentStatus;
import org.openhmis.code.ClientLastGradeCompleted;
import org.openhmis.code.ClientMonthsHomelessPastThreeYears;
import org.openhmis.code.ClientNameDataQuality;
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
import org.openhmis.code.ClientSsnDataQuality;
import org.openhmis.code.ClientTimesHomelessPastThreeYears;
import org.openhmis.code.None;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.PathClientProgramDAO;
import org.openhmis.dao.TmpEnrollmentDAO;
import org.openhmis.domain.PathClientProgram;
import org.openhmis.domain.TmpEnrollment;
import org.openhmis.domain.TmpProjectInventory;
import org.openhmis.dto.ChronicHealthConditionDTO;
import org.openhmis.dto.ClientDTO;
import org.openhmis.dto.ContactDTO;
import org.openhmis.dto.DevelopmentalDisabilityDTO;
import org.openhmis.dto.DomesticAbuseDTO;
import org.openhmis.dto.EnrollmentDTO;
import org.openhmis.dto.ExitDTO;
import org.openhmis.dto.FinancialAssistanceDTO;
import org.openhmis.dto.HealthInsuranceDTO;
import org.openhmis.dto.HivAidsStatusDTO;
import org.openhmis.dto.IncomeSourceDTO;
import org.openhmis.dto.InventoryDTO;
import org.openhmis.dto.MedicalAssistanceDTO;
import org.openhmis.dto.MentalHealthProblemDTO;
import org.openhmis.dto.NonCashBenefitDTO;
import org.openhmis.dto.PhysicalDisabilityDTO;
import org.openhmis.dto.ReferralDTO;
import org.openhmis.dto.ServiceDTO;
import org.openhmis.dto.SubstanceAbuseDTO;
import org.openhmis.dto.search.EnrollmentSearchDTO;
import org.openhmis.exception.InvalidParameterException;

public class EnrollmentManager {

	private static final TmpEnrollmentDAO tmpEnrollmentDAO = new TmpEnrollmentDAO();
	
	public EnrollmentManager() {}

	public EnrollmentDTO getEnrollmentById(String enrollmentId) {
		EnrollmentDTO enrollmentDTO = EnrollmentManager.generateEnrollmentDTO(tmpEnrollmentDAO.getTmpEnrollmentById(Integer.parseInt(enrollmentId)));
		return enrollmentDTO;
	}

	public List<EnrollmentDTO> getEnrollments(EnrollmentSearchDTO searchDTO) {
		List<EnrollmentDTO> enrollmentDTOs = new ArrayList<EnrollmentDTO>();

		// Collect the inventories
		List<TmpEnrollment> tempEnrollments = tmpEnrollmentDAO.getTmpEnrollments(searchDTO);

		// For each inventory, collect and map the data
		for (Iterator<TmpEnrollment> iterator = tempEnrollments.iterator(); iterator.hasNext();) {
			TmpEnrollment tempEnrollment = iterator.next();
			EnrollmentDTO enrollmentDTO = EnrollmentManager.generateEnrollmentDTO(tempEnrollment);
			enrollmentDTOs.add(enrollmentDTO);
		}
		return enrollmentDTOs;
	}


	public List<EnrollmentDTO> getEnrollmentsByUpdateDate(Date updateDate) {
		List<EnrollmentDTO> enrollmentDTOs = new ArrayList<EnrollmentDTO>();

		// Collect the inventories
		List<TmpEnrollment> tempEnrollments = tmpEnrollmentDAO.getTmpEnrollmentsByUpdateDate(updateDate);

		// For each inventory, collect and map the data
		for (Iterator<TmpEnrollment> iterator = tempEnrollments.iterator(); iterator.hasNext();) {
			TmpEnrollment tempEnrollment = iterator.next();
			EnrollmentDTO enrollmentDTO = EnrollmentManager.generateEnrollmentDTO(tempEnrollment);
			enrollmentDTOs.add(enrollmentDTO);
		}
		return enrollmentDTOs;
	}
	
	public EnrollmentDTO addEnrollment(EnrollmentDTO inputDTO) {
		// Validate the enrollment
		// TODO: this should return a list of errors that get wrapped appropriately
		if(!validateEnrollment(inputDTO))
			return null;
		
		// Generate a PathClient from the input
		TmpEnrollment tmpEnrollment = EnrollmentManager.generateTmpEnrollment(inputDTO);
		
		// Set Export fields
		tmpEnrollment.setDateCreated(new Date());
		tmpEnrollment.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpEnrollmentDAO.save(tmpEnrollment);
		inputDTO.setEnrollmentId(tmpEnrollment.getEnrollmentId().toString());
		
		// Return the resulting VO
		return EnrollmentManager.generateEnrollmentDTO(tmpEnrollment);

	}
	
	public EnrollmentDTO updateEnrollment(EnrollmentDTO inputDTO) {
		// Generate a TmpProject from the input
		TmpEnrollment tmpEnrollment = EnrollmentManager.generateTmpEnrollment(inputDTO);
		
		// Validate the enrollment
		// TODO: this should return a list of errors that get wrapped appropriately
		if(!validateEnrollment(inputDTO))
			return null;
		
		tmpEnrollment.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));
		tmpEnrollment.setDateUpdated(new Date());
		
		// Update the client
		tmpEnrollmentDAO.update(tmpEnrollment);
		
		// Return the resulting VO
		return EnrollmentManager.generateEnrollmentDTO(tmpEnrollment);
		
	}
	
	public boolean deleteEnrollment(String enrollmentId) {
		TmpEnrollment tmpEnrollment = tmpEnrollmentDAO.getTmpEnrollmentById(Integer.parseInt(enrollmentId));
		tmpEnrollmentDAO.delete(tmpEnrollment);
		return true;
	}
	
	public boolean validateEnrollment(EnrollmentDTO inputDTO) {
		// Universal Data Standard: Name (2014, 3.1)

		// Universal Data Standard: Disabling Condition (2014, 3.8)
		if(inputDTO.getDisablingCondition() == YesNoReason.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.8.1 disablingCondition", "disablingCondition is set to an unknown code");

		// Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)
		if(inputDTO.getResidencePrior() == ClientResidencePrior.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.9.1 residencePrior", "residencePrior is set to an unknown code");

		if(inputDTO.getResidencePriorLengthOfStay() == ClientResidencePriorLengthOfStay.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.9.3 residencePriorLengthOfStay", "residencePriorLengthOfStay is set to an unknown code");

		// Universal Data Standard: Project Entry Date (2014, 3.10)
		// TODO: check if there are any undocumented rules for entry date

		// Universal Data Standard: Household ID (2014, 3.14)
		// TODO: check if there are any undocumented rules for household ID

		// Universal Data Standard: Relationship to Head of Household (2014, 3.15)
		if(inputDTO.getRelationshipToHoH() == ClientRelationshipToHoH.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.15.1 relationshipToHoH", "relationshipToHoH is set to an unknown code");

		// Universal Data Standard: Client Location (2014, 3.16)
		// TODO: check if there are any undocumented rules for client location

		// Universal Data Standard: Length of Time on Street, in an Emergency Shelter, or Safe Haven (2014, 3.17)
		if(inputDTO.getContinuouslyHomelessOneYear() == YesNoReason.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.17.1 continuouslyHomelessOneYear", "continuouslyHomelessOneYear is set to an unknown code");

		if(inputDTO.getTimesHomelessInPastThreeYears() == ClientTimesHomelessPastThreeYears.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.17.2 timesHomelessInPastThreeYears", "timesHomelessInPastThreeYears is set to an unknown code");

		if(inputDTO.getMonthsHomelessPastThreeYears() == ClientMonthsHomelessPastThreeYears.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.17.A monthsHomelessPastThreeYears", "monthsHomelessPastThreeYears is set to an unknown code");

		if(inputDTO.getMonthsHomelessThisTime() > 999)
			throw new InvalidParameterException("HUD 3.17.? monthsHomelessThisTime", "monthsHomelessThisTime must be less than three digits");

		if(inputDTO.getMonthsHomelessThisTime() < 0)
			throw new InvalidParameterException("HUD 3.17.? monthsHomelessThisTime", "monthsHomelessThisTime cannot be negative");

		if(inputDTO.getStatusDocumentedCode() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 1.7 statusDocumented", "statusDocumented is set to an unknown code");

		// TODO: validate 4.* fields
		
		return true;
	}
	
	public static EnrollmentDTO generateEnrollmentDTO(TmpEnrollment tmpEnrollment) {
		EnrollmentDTO enrollmentDTO = new EnrollmentDTO();

		String enrollmentId = tmpEnrollment.getEnrollmentId().toString();
		enrollmentDTO.setEnrollmentId(enrollmentId);

		// The client object associated with this enrollment
		enrollmentDTO.setPersonalId(tmpEnrollment.getPersonalId().toString());

		// Project Exit Object
		enrollmentDTO.setProjectExit(ExitManager.getExitByEnrollmentId(enrollmentId));

		// Universal Data Standard: Disabling Condition (2014, 3.8)
		enrollmentDTO.setDisablingCondition(YesNoReason.valueByCode(tmpEnrollment.getDisablingCondition()));

		// Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)
		enrollmentDTO.setResidencePrior(ClientResidencePrior.valueByCode(tmpEnrollment.getResidencePrior()));
		enrollmentDTO.setOtherResidence(tmpEnrollment.getOtherResidence());
		enrollmentDTO.setResidencePriorLengthOfStay(ClientResidencePriorLengthOfStay.valueByCode(tmpEnrollment.getResidencePriorLengthOfStay()));

		// Universal Data Standard: Project Entry Date (2014, 3.10)
		enrollmentDTO.setEntryDate(tmpEnrollment.getEntryDate());

		// Universal Data Standard: Household ID (2014, 3.14)
		enrollmentDTO.setHouseholdId(tmpEnrollment.getHouseholdId().toString());

		// Universal Data Standard: Relationship to Head of Household (2014, 3.15)
		enrollmentDTO.setRelationshipToHoH(ClientRelationshipToHoH.valueByCode(tmpEnrollment.getRelationshipToHoH()));

		// Universal Data Standard: Client Location (2014, 3.16)
		enrollmentDTO.setClientLocationInformationDate(tmpEnrollment.getClientLocationInformationDate());
		enrollmentDTO.setCocCode(tmpEnrollment.getCocCode());

		// Universal Data Standard: Length of Time on Street, in an Emergency Shelter, or Safe Haven (2014, 3.17)
		enrollmentDTO.setContinuouslyHomelessOneYear(YesNoReason.valueByCode(tmpEnrollment.getContinuouslyHomelessOneYear()));
		enrollmentDTO.setTimesHomelessInPastThreeYears(ClientTimesHomelessPastThreeYears.valueByCode(tmpEnrollment.getTimesHomelessInPastThreeYears()));
		enrollmentDTO.setMonthsHomelessPastThreeYears(ClientMonthsHomelessPastThreeYears.valueByCode(tmpEnrollment.getMonthsHomelessPastThreeYears()));
		enrollmentDTO.setMonthsHomelessThisTime(tmpEnrollment.getMonthsHomelessThisTime());
		enrollmentDTO.setStatusDocumentedCode(YesNo.valueByCode(tmpEnrollment.getStatusDocumentedCode()));

		// Program Specific Data Standards: Housing Status (2014, 4.1)
		// Collection: Project Entry
		enrollmentDTO.setHousingStatus(ClientHousingStatus.valueByCode(tmpEnrollment.getHousingStatus()));

		// Program Specific Data Standards: Income Sources (2014, 4.2)
		enrollmentDTO.setIncomeSources(IncomeSourceManager.getIncomeSourcesByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
		enrollmentDTO.setNonCashBenefits(NonCashBenefitManager.getNonCashBenefitsByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Health Insurance (2014, 4.4)
		enrollmentDTO.setHealthInsurances(HealthInsuranceManager.getHealthInsurancesByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		enrollmentDTO.setPhysicalDisabilities(PhysicalDisabilityManager.getPhysicalDisabilitiesByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Developmental Disability (2014, 4.6)
		enrollmentDTO.setDevelopmentalDisabilities(DevelopmentalDisabilityManager.getDevelopmentalDisabilitiesByEnrollmentId(enrollmentId));
		
		// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
		enrollmentDTO.setChronicHealthConditions(ChronicHealthConditionManager.getChronicHealthConditionsByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
		enrollmentDTO.setHivAidsStatuses(HivAidsStatusManager.getHivAidsStatusesByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Mental Health Problem (2014, 4.9)
		enrollmentDTO.setMentalHealthProblems(MentalHealthProblemManager.getMentalHealthProblemsByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Substance Abuse (2014, 4.10)
		enrollmentDTO.setSubstanceAbuses(SubstanceAbuseManager.getSubstanceAbusesByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Domestic Abuse (2014, 4.11)
		enrollmentDTO.setDomesticAbuses(DomesticAbuseManager.getDomesticAbusesByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Contact (2014, 4.12)
		enrollmentDTO.setContacts(ContactManager.getContactsByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Date of Engagement (2014, 4.13)
		enrollmentDTO.setDateOfEngagement(tmpEnrollment.getDateOfEngagement());

		// Program Specific Data Standards: Services Provided (2014, 4.14)
		enrollmentDTO.setServices(ServiceManager.getServicesByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Financial Assets Provided (2014, 4.15)
		enrollmentDTO.setFinancialAssistances(FinancialAssistanceManager.getFinancialAssistancesByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: References Provided (2014, 4.16)
		enrollmentDTO.setReferrals(ReferralManager.getReferralsByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Residential Move-in Date (2014, 4.17)
		enrollmentDTO.setResidentialMoveInDate(tmpEnrollment.getResidentialMoveInDate());
		enrollmentDTO.setInPermanentHousing(YesNo.valueByCode(tmpEnrollment.getInPermanentHousing()));
		enrollmentDTO.setPermanentHousingMoveDate(tmpEnrollment.getPermanentHousingMoveDate());

		// PATH Specific Data Standards: PATH Status (2014, 4.20)
		enrollmentDTO.setDateOfPathStatus(tmpEnrollment.getDateOfPathStatus());
		enrollmentDTO.setClientEnrolledInPath(YesNo.valueByCode(tmpEnrollment.getClientEnrolledInPath()));
		enrollmentDTO.setReasonNotEnrolled(ClientReasonNotEnrolled.valueByCode(tmpEnrollment.getReasonNotEnrolled()));

		// RHY Specific Data Standards: RHY-BCP Status (2014, 4.22)
		enrollmentDTO.setDateOfBcpStatus(tmpEnrollment.getDateOfBcpStatus());
		enrollmentDTO.setFysbYouth(YesNo.valueByCode(tmpEnrollment.getFysbYouth()));
		enrollmentDTO.setReasonNoServices(ClientReasonNoServices.valueByCode(tmpEnrollment.getReasonNoServices()));

		// RHY Specific Data Standards: Sexual Orientation (2014, 4.23)
		enrollmentDTO.setSexualOrientation(ClientSexualOrientation.valueByCode(tmpEnrollment.getSexualOrientation()));

		// RHY Specific Data Standards: Last Grade Completed (2014, 4.24)
		enrollmentDTO.setLastGradeCompleted(ClientLastGradeCompleted.valueByCode(tmpEnrollment.getLastGradeCompleted()));
		
		// RHY Specific Data Standards: School Status (2014, 4.25)
		enrollmentDTO.setSchoolStatus(ClientSchoolStatus.valueByCode(tmpEnrollment.getSchoolStatus()));

		// RHY Specific Data Standards: Employment Status (2014, 4.26)
		enrollmentDTO.setEmployedInformationDate(tmpEnrollment.getEmployedInformationDate());
		enrollmentDTO.setEmployed(YesNoReason.valueByCode(tmpEnrollment.getEmployed()));
		enrollmentDTO.setEmploymentType(ClientEmploymentType.valueByCode(tmpEnrollment.getEmploymentType()));
		enrollmentDTO.setNotEmployedReason(ClientNotEmployedReason.valueByCode(tmpEnrollment.getNotEmployedReason()));

		// RHY Specific Data Standards: General Health Status (2014, 4.27)
		enrollmentDTO.setGeneralHealthStatus(ClientHealthStatus.valueByCode(tmpEnrollment.getGeneralHealthStatus()));

		// RHY Specific Data Standards: Dental Health Status (2014, 4.28)
		enrollmentDTO.setDentalHealthStatus(ClientHealthStatus.valueByCode(tmpEnrollment.getDentalHealthStatus()));

		// RHY Specific Data Standards: Mental Health Status (2014, 4.29)
		enrollmentDTO.setMentalHealthStatus(ClientHealthStatus.valueByCode(tmpEnrollment.getMentalHealthStatus()));

		// RHY Specific Data Standards: Pregnancy Status (2014, 4.30)
		enrollmentDTO.setPregnancyStatusCode(YesNoReason.valueByCode(tmpEnrollment.getPregnancyStatusCode()));
		enrollmentDTO.setPregnancyDueDate(tmpEnrollment.getPregnancyDueDate());

		// RHY Specific Data Standards: Formerly Child Welfare (2014, 4.31)
		enrollmentDTO.setFormerlyChildWelfare(YesNoReason.valueByCode(tmpEnrollment.getFormerlyChildWelfare()));
		enrollmentDTO.setChildWelfareYears(ClientRhyNumberOfYears.valueByCode(tmpEnrollment.getChildWelfareYears()));
		enrollmentDTO.setChildWelfareMonths(tmpEnrollment.getChildWelfareMonths());

		// RHY Specific Data Standards: Formerly Juvenile Justice (2014, 4.32)
		enrollmentDTO.setFormerWardJuvenileJustice(YesNoReason.valueByCode(tmpEnrollment.getFormerWardJuvenileJustice()));
		enrollmentDTO.setJuvenileJusticeYears(ClientRhyNumberOfYears.valueByCode(tmpEnrollment.getJuvenileJusticeYears()));
		enrollmentDTO.setJuvenileJusticeMonths(tmpEnrollment.getJuvenileJusticeMonths());

		// RHY Specific Data Standards: Young Person's Critical Issues (2014, 4.33)
		enrollmentDTO.setHouseholdDynamics(YesNo.valueByCode(tmpEnrollment.getHouseholdDynamics()));
		enrollmentDTO.setSexualOrientationGenderIdYouth(YesNo.valueByCode(tmpEnrollment.getSexualOrientationGenderIdYouth()));
		enrollmentDTO.setSexualOrientationGenderIdFam(YesNo.valueByCode(tmpEnrollment.getSexualOrientationGenderIdFam()));
		enrollmentDTO.setHousingIssuesYouth(YesNo.valueByCode(tmpEnrollment.getHousingIssuesYouth()));
		enrollmentDTO.setHousingIssuesFam(YesNo.valueByCode(tmpEnrollment.getHousingIssuesFam()));
		enrollmentDTO.setSchoolEducationalIssuesYouth(YesNo.valueByCode(tmpEnrollment.getSchoolEducationalIssuesYouth()));
		enrollmentDTO.setSchoolEducationalIssuesFam(YesNo.valueByCode(tmpEnrollment.getSchoolEducationalIssuesFam()));
		enrollmentDTO.setUnemploymentYouth(YesNo.valueByCode(tmpEnrollment.getUnemploymentYouth()));
		enrollmentDTO.setUnemploymentFam(YesNo.valueByCode(tmpEnrollment.getUnemploymentFam()));
		enrollmentDTO.setMentalHealthIssuesYouth(YesNo.valueByCode(tmpEnrollment.getMentalHealthIssuesYouth()));
		enrollmentDTO.setMentalHealthIssuesFam(YesNo.valueByCode(tmpEnrollment.getMentalHealthIssuesFam()));
		enrollmentDTO.setHealthIssuesYouth(YesNo.valueByCode(tmpEnrollment.getHealthIssuesYouth()));
		enrollmentDTO.setHealthIssuesFam(YesNo.valueByCode(tmpEnrollment.getHealthIssuesFam()));
		enrollmentDTO.setPhysicalDisabilityYouth(YesNo.valueByCode(tmpEnrollment.getPhysicalDisabilityYouth()));
		enrollmentDTO.setPhysicalDisabilityFam(YesNo.valueByCode(tmpEnrollment.getPhysicalDisabilityFam()));
		enrollmentDTO.setMentalDisabilityYouth(YesNo.valueByCode(tmpEnrollment.getMentalDisabilityYouth()));
		enrollmentDTO.setMentalDisabilityFam(YesNo.valueByCode(tmpEnrollment.getMentalDisabilityFam()));
		enrollmentDTO.setAbuseAndNeglectYouth(YesNo.valueByCode(tmpEnrollment.getAbuseAndNeglectYouth()));
		enrollmentDTO.setAbuseAndNeglectFam(YesNo.valueByCode(tmpEnrollment.getAbuseAndNeglectFam()));
		enrollmentDTO.setAlcoholDrugAbuseYouth(YesNo.valueByCode(tmpEnrollment.getAlcoholDrugAbuseYouth()));
		enrollmentDTO.setAlcoholDrugAbuseFam(YesNo.valueByCode(tmpEnrollment.getAlcoholDrugAbuseFam()));
		enrollmentDTO.setInsufficientIncome(YesNo.valueByCode(tmpEnrollment.getInsufficientIncome()));
		enrollmentDTO.setActiveMilitaryParent(YesNo.valueByCode(tmpEnrollment.getActiveMilitaryParent()));
		enrollmentDTO.setIncarceratedParent(YesNo.valueByCode(tmpEnrollment.getIncarceratedParent()));
		enrollmentDTO.setIncarceratedParentStatus(ClientIncarceratedParentStatus.valueByCode(tmpEnrollment.getIncarceratedParentStatus()));

		// RHY Specific Data Standards: Referral Source (2014, 4.34)
		enrollmentDTO.setReferralSource(ClientReferralSource.valueByCode(tmpEnrollment.getReferralSource()));
		enrollmentDTO.setCountOutreachReferralApproaches(tmpEnrollment.getCountOutreachReferralApproaches());

		// RHY Specific Data Standards: Commercial Sexual Exploitation (2014, 4.35)
		enrollmentDTO.setExchangeForSexPastThreeMonths(YesNoReason.valueByCode(tmpEnrollment.getExchangeForSexPastThreeMonths()));
		enrollmentDTO.setCountOfExchangeForSex(ClientCountExchangeForSex.valueByCode(tmpEnrollment.getCountOfExchangeForSex()));
		enrollmentDTO.setAskedOrForcedToExchangeForSex(YesNoReason.valueByCode(tmpEnrollment.getAskedOrForcedToExchangeForSex()));

		// HOPWA Specific Data Standards: Medical Assistance (2014, 4.39)
		enrollmentDTO.setMedicalAssistances(MedicalAssistanceManager.getMedicalAssistancesByEnrollmentId(enrollmentId));

		// RHSP Specific Data Standards: Worst Housing Situation (2014, 4.40)
		enrollmentDTO.setWorstHousingSituation(YesNoReason.valueByCode(tmpEnrollment.getWorstHousingSituation()));

		// VA Specific Data Standards: Percent of AMI (2014, 4.42)
		enrollmentDTO.setPercentAmi(ClientPercentAmi.valueByCode(tmpEnrollment.getPercentAmi()));

		// VA Specific Data Standards: Last Permanent Address (2014, 4.43)
		enrollmentDTO.setLastPermanentStreet(tmpEnrollment.getLastPermanentStreet());
		enrollmentDTO.setLastPermanentCity(tmpEnrollment.getLastPermanentCity());
		enrollmentDTO.setLastPermanentState(tmpEnrollment.getLastPermanentState());
		enrollmentDTO.setLastPermanentZip(tmpEnrollment.getLastPermanentZip());
		enrollmentDTO.setAddressDataQuality(ClientAddressDataQuality.valueByCode(tmpEnrollment.getAddressDataQuality()));

		// Export Standard Fields
		enrollmentDTO.setDateCreated(tmpEnrollment.getDateCreated());
		enrollmentDTO.setDateUpdated(tmpEnrollment.getDateUpdated());
		
		return enrollmentDTO;
	}
	
	public static TmpEnrollment generateTmpEnrollment(EnrollmentDTO enrollmentDTO) {
		TmpEnrollment tmpEnrollment = new TmpEnrollment();
		
		// The client object associated with this enrollment
		tmpEnrollment.setPersonalId(Integer.parseInt(enrollmentDTO.getPersonalId()));

		// Universal Data Standard: Disabling Condition (2014, 3.8)
		tmpEnrollment.setDisablingCondition(enrollmentDTO.getDisablingCondition().getCode());

		// Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)
		tmpEnrollment.setResidencePrior(enrollmentDTO.getResidencePrior().getCode());
		tmpEnrollment.setOtherResidence(enrollmentDTO.getOtherResidence());
		tmpEnrollment.setResidencePriorLengthOfStay(enrollmentDTO.getResidencePriorLengthOfStay().getCode());

		// Universal Data Standard: Project Entry Date (2014, 3.10)
		tmpEnrollment.setEntryDate(enrollmentDTO.getEntryDate());

		// Universal Data Standard: Household ID (2014, 3.14)
		tmpEnrollment.setHouseholdId(Integer.parseInt(enrollmentDTO.getHouseholdId()));

		// Universal Data Standard: Relationship to Head of Household (2014, 3.15)
		tmpEnrollment.setRelationshipToHoH(enrollmentDTO.getRelationshipToHoH().getCode());

		// Universal Data Standard: Client Location (2014, 3.16)
		tmpEnrollment.setClientLocationInformationDate(enrollmentDTO.getClientLocationInformationDate());
		tmpEnrollment.setCocCode(enrollmentDTO.getCocCode());

		// Universal Data Standard: Length of Time on Street, in an Emergency Shelter, or Safe Haven (2014, 3.17)
		tmpEnrollment.setContinuouslyHomelessOneYear(enrollmentDTO.getContinuouslyHomelessOneYear().getCode());
		tmpEnrollment.setTimesHomelessInPastThreeYears(enrollmentDTO.getTimesHomelessInPastThreeYears().getCode());
		tmpEnrollment.setMonthsHomelessPastThreeYears(enrollmentDTO.getMonthsHomelessPastThreeYears().getCode());
		tmpEnrollment.setMonthsHomelessThisTime(enrollmentDTO.getMonthsHomelessThisTime());
		tmpEnrollment.setStatusDocumentedCode(enrollmentDTO.getStatusDocumentedCode().getCode());

		// Program Specific Data Standards: Housing Status (2014, 4.1)
		// Collection: Project Entry
		tmpEnrollment.setHousingStatus(enrollmentDTO.getHousingStatus().getCode());

		// Program Specific Data Standards: Date of Engagement (2014, 4.13)
		tmpEnrollment.setDateOfEngagement(enrollmentDTO.getDateOfEngagement());

		// Program Specific Data Standards: Residential Move-in Date (2014, 4.17)
		tmpEnrollment.setResidentialMoveInDate(enrollmentDTO.getResidentialMoveInDate());
		tmpEnrollment.setInPermanentHousing(enrollmentDTO.getInPermanentHousing().getCode());
		tmpEnrollment.setPermanentHousingMoveDate(enrollmentDTO.getPermanentHousingMoveDate());

		// PATH Specific Data Standards: PATH Status (2014, 4.20)
		tmpEnrollment.setDateOfPathStatus(enrollmentDTO.getDateOfPathStatus());
		tmpEnrollment.setClientEnrolledInPath(enrollmentDTO.getClientEnrolledInPath().getCode());
		tmpEnrollment.setReasonNotEnrolled(enrollmentDTO.getReasonNotEnrolled().getCode());

		// RHY Specific Data Standards: RHY-BCP Status (2014, 4.22)
		tmpEnrollment.setDateOfBcpStatus(enrollmentDTO.getDateOfBcpStatus());
		tmpEnrollment.setFysbYouth(enrollmentDTO.getFysbYouth().getCode());
		tmpEnrollment.setReasonNoServices(enrollmentDTO.getReasonNoServices().getCode());

		// RHY Specific Data Standards: Sexual Orientation (2014, 4.23)
		tmpEnrollment.setSexualOrientation(enrollmentDTO.getSexualOrientation().getCode());

		// RHY Specific Data Standards: Last Grade Completed (2014, 4.24)
		tmpEnrollment.setLastGradeCompleted(enrollmentDTO.getLastGradeCompleted().getCode());
		
		// RHY Specific Data Standards: School Status (2014, 4.25)
		tmpEnrollment.setSchoolStatus(enrollmentDTO.getSchoolStatus().getCode());

		// RHY Specific Data Standards: Employment Status (2014, 4.26)
		tmpEnrollment.setEmployedInformationDate(enrollmentDTO.getEmployedInformationDate());
		tmpEnrollment.setEmployed(enrollmentDTO.getEmployed().getCode());
		tmpEnrollment.setEmploymentType(enrollmentDTO.getEmploymentType().getCode());
		tmpEnrollment.setNotEmployedReason(enrollmentDTO.getNotEmployedReason().getCode());

		// RHY Specific Data Standards: General Health Status (2014, 4.27)
		tmpEnrollment.setGeneralHealthStatus(enrollmentDTO.getGeneralHealthStatus().getCode());

		// RHY Specific Data Standards: Dental Health Status (2014, 4.28)
		tmpEnrollment.setDentalHealthStatus(enrollmentDTO.getDentalHealthStatus().getCode());

		// RHY Specific Data Standards: Mental Health Status (2014, 4.29)
		tmpEnrollment.setMentalHealthStatus(enrollmentDTO.getMentalHealthStatus().getCode());

		// RHY Specific Data Standards: Pregnancy Status (2014, 4.30)
		tmpEnrollment.setPregnancyStatusCode(enrollmentDTO.getPregnancyStatusCode().getCode());
		tmpEnrollment.setPregnancyDueDate(enrollmentDTO.getPregnancyDueDate());

		// RHY Specific Data Standards: Formerly Child Welfare (2014, 4.31)
		tmpEnrollment.setFormerlyChildWelfare(enrollmentDTO.getFormerlyChildWelfare().getCode());
		tmpEnrollment.setChildWelfareYears(enrollmentDTO.getChildWelfareYears().getCode());
		tmpEnrollment.setChildWelfareMonths(enrollmentDTO.getChildWelfareMonths());

		// RHY Specific Data Standards: Formerly Juvenile Justice (2014, 4.32)
		tmpEnrollment.setFormerWardJuvenileJustice(enrollmentDTO.getFormerWardJuvenileJustice().getCode());
		tmpEnrollment.setJuvenileJusticeYears(enrollmentDTO.getJuvenileJusticeYears().getCode());
		tmpEnrollment.setJuvenileJusticeMonths(enrollmentDTO.getJuvenileJusticeMonths());

		// RHY Specific Data Standards: Young Person's Critical Issues (2014, 4.33)
		tmpEnrollment.setHouseholdDynamics(enrollmentDTO.getHouseholdDynamics().getCode());
		tmpEnrollment.setSexualOrientationGenderIdYouth(enrollmentDTO.getSexualOrientationGenderIdYouth().getCode());
		tmpEnrollment.setSexualOrientationGenderIdFam(enrollmentDTO.getSexualOrientationGenderIdFam().getCode());
		tmpEnrollment.setHousingIssuesYouth(enrollmentDTO.getHousingIssuesYouth().getCode());
		tmpEnrollment.setHousingIssuesFam(enrollmentDTO.getHousingIssuesFam().getCode());
		tmpEnrollment.setSchoolEducationalIssuesYouth(enrollmentDTO.getSchoolEducationalIssuesYouth().getCode());
		tmpEnrollment.setSchoolEducationalIssuesFam(enrollmentDTO.getSchoolEducationalIssuesFam().getCode());
		tmpEnrollment.setUnemploymentYouth(enrollmentDTO.getUnemploymentYouth().getCode());
		tmpEnrollment.setUnemploymentFam(enrollmentDTO.getUnemploymentFam().getCode());
		tmpEnrollment.setMentalHealthIssuesYouth(enrollmentDTO.getMentalHealthIssuesYouth().getCode());
		tmpEnrollment.setMentalHealthIssuesFam(enrollmentDTO.getMentalHealthIssuesFam().getCode());
		tmpEnrollment.setHealthIssuesYouth(enrollmentDTO.getHealthIssuesYouth().getCode());
		tmpEnrollment.setHealthIssuesFam(enrollmentDTO.getHealthIssuesFam().getCode());
		tmpEnrollment.setPhysicalDisabilityYouth(enrollmentDTO.getPhysicalDisabilityYouth().getCode());
		tmpEnrollment.setPhysicalDisabilityFam(enrollmentDTO.getPhysicalDisabilityFam().getCode());
		tmpEnrollment.setMentalDisabilityYouth(enrollmentDTO.getMentalDisabilityYouth().getCode());
		tmpEnrollment.setMentalDisabilityFam(enrollmentDTO.getMentalDisabilityFam().getCode());
		tmpEnrollment.setAbuseAndNeglectYouth(enrollmentDTO.getAbuseAndNeglectYouth().getCode());
		tmpEnrollment.setAbuseAndNeglectFam(enrollmentDTO.getAbuseAndNeglectFam().getCode());
		tmpEnrollment.setAlcoholDrugAbuseYouth(enrollmentDTO.getAlcoholDrugAbuseYouth().getCode());
		tmpEnrollment.setAlcoholDrugAbuseFam(enrollmentDTO.getAlcoholDrugAbuseFam().getCode());
		tmpEnrollment.setInsufficientIncome(enrollmentDTO.getInsufficientIncome().getCode());
		tmpEnrollment.setActiveMilitaryParent(enrollmentDTO.getActiveMilitaryParent().getCode());
		tmpEnrollment.setIncarceratedParent(enrollmentDTO.getIncarceratedParent().getCode());
		tmpEnrollment.setIncarceratedParentStatus(enrollmentDTO.getIncarceratedParentStatus().getCode());

		// RHY Specific Data Standards: Referral Source (2014, 4.34)
		tmpEnrollment.setReferralSource(enrollmentDTO.getReferralSource().getCode());
		tmpEnrollment.setCountOutreachReferralApproaches(enrollmentDTO.getCountOutreachReferralApproaches());

		// RHY Specific Data Standards: Commercial Sexual Exploitation (2014, 4.35)
		tmpEnrollment.setExchangeForSexPastThreeMonths(enrollmentDTO.getExchangeForSexPastThreeMonths().getCode());
		tmpEnrollment.setCountOfExchangeForSex(enrollmentDTO.getCountOfExchangeForSex().getCode());
		tmpEnrollment.setAskedOrForcedToExchangeForSex(enrollmentDTO.getAskedOrForcedToExchangeForSex().getCode());

		// RHSP Specific Data Standards: Worst Housing Situation (2014, 4.40)
		tmpEnrollment.setWorstHousingSituation(enrollmentDTO.getWorstHousingSituation().getCode());

		// VA Specific Data Standards: Percent of AMI (2014, 4.42)
		tmpEnrollment.setPercentAmi(enrollmentDTO.getPercentAmi().getCode());

		// VA Specific Data Standards: Last Permanent Address (2014, 4.43)
		tmpEnrollment.setLastPermanentStreet(enrollmentDTO.getLastPermanentStreet());
		tmpEnrollment.setLastPermanentCity(enrollmentDTO.getLastPermanentCity());
		tmpEnrollment.setLastPermanentState(enrollmentDTO.getLastPermanentState());
		tmpEnrollment.setLastPermanentZip(enrollmentDTO.getLastPermanentZip());
		tmpEnrollment.setAddressDataQuality(enrollmentDTO.getAddressDataQuality().getCode());
		
		// Export Standard Fields
		tmpEnrollment.setDateCreated(enrollmentDTO.getDateCreated());
		tmpEnrollment.setDateUpdated(enrollmentDTO.getDateUpdated());
		
		return tmpEnrollment;
	}	
	
}
