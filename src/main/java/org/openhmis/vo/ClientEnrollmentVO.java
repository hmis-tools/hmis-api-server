package org.openhmis.vo;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientEnrollmentVO {
	/**
	 * The client object represents a client enrollment record
	 * Fields returned with the client object represent fields marked as "At project entry" in the HUD standards
	 */
	private String personalId;
	private String enrollmentId;

	// Project Exit Object
	private ClientExitVO projectExit;

	// Universal Data Standard: Disabling Condition (2014, 3.8)
	// Collection: Project Entry
	private YesNoReason disablingCondition;

	// Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)
	// Collection: Project Entry
	private ClientResidencePrior residencePrior;
	private String otherResidence;
	private ClientResidencePriorLengthOfStay residencePriorLengthOfStay;

	// Universal Data Standard: Project Entry Date (2014, 3.10)
	// Collection: Project Entry
	private Date entryDate;

	// Universal Data Standard: Household ID (2014, 3.14)
	// Collection: Project Entry
	private String householdId;

	// Universal Data Standard: Relationship to Head of Household (2014, 3.15)
	// Collection: Project Entry
	private ClientRelationshipToHoH relationshipToHoH;
	
	// Universal Data Standard: Client Location (2014, 3.16)
	// Collection: Project Entry
	// TODO: Export standards have this as separate, independently updated values.
	// HUD standards say it is a single value that is kept up to date.
	private Date clientLocationInformationDate;
	private String cocCode;

	// Universal Data Standard: Length of Time on Street, in an Emergency Shelter, or Safe Haven (2014, 3.17)
	// Collection: Project Entry
	private YesNoReason continuouslyHomelessOneYear;
	private ClientTimesHomelessPastThreeYears timesHomelessInPastThreeYears;
	private ClientMonthsHomelessPastThreeYears monthsHomelessPastThreeYears;
	private Integer monthsHomelessThisTime;
	private YesNo statusDocumentedCode;

	// Program Specific Data Standards: Housing Status (2014, 4.1)
	// Collection: Project Entry
	private ClientHousingStatus housingStatus;

	// Program Specific Data Standards: Income Sources (2014, 4.2)
	// Collection: Project Entry, Project Exit, Annual Assessment, Updates
	// IN ANOTHER OBJECT (ClientEnrollmentIncomeSourceVO.java)
	List<ClientEnrollmentIncomeSourceVO> incomeSources;

	// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
	// Collection: Project Entry, Project Exit, Annual Assessment, Updates
	// IN ANOTHER OBJECT (ClientEnrollmentNonCashBenefitVO.java)
	List<ClientEnrollmentNonCashBenefitVO> nonCashBenefits;

	// Program Specific Data Standards: Health Insurance (2014, 4.4)
	// Collection: Project Entry, Project Exit, Annual Assessment, Updates
	// IN ANOTHER OBJECT (ClientEnrollmentHealthInsuranceVO.java)
	List<ClientEnrollmentHealthInsuranceVO> healthInsurances;

	// Program Specific Data Standards: Physical Disability (2014, 4.5)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentPhysicalDisabilityVO.java)
	List<ClientEnrollmentPhysicalDisabilityVO> physicalDisabilities;

	// Program Specific Data Standards: Developmental Disability (2014, 4.6)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentDevelopmentalDisabilityVO.java)
	List<ClientEnrollmentDevelopmentalDisabilityVO> developmentalDisabilities;

	// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentChronicHealthConditionVO.java)
	List<ClientEnrollmentChronicHealthConditionVO> chronicHealthConditions;

	// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentHivAidsVO.java)
	List<ClientEnrollmentHivAidsVO> hivAidsStatuses;

	// Program Specific Data Standards: Mental Health Problem (2014, 4.9)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentMentalHealthProblemVO.java)
	List<ClientEnrollmentMentalHealthProblemVO> mentalHealthProblems;

	// Program Specific Data Standards: Substance Abuse (2014, 4.10)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentSubstanceAbuseVO.java)
	List<ClientEnrollmentSubstanceAbuseVO> substanceAbuses;

	// Program Specific Data Standards: Domestic Abuse (2014, 4.11)
	// Collection: Project Entry, Update
	// IN ANOTHER OBJECT (ClientEnrollmentDomesticAbuseVO.java)
	List<ClientEnrollmentDomesticAbuseVO> domesticAbuses;

	// Program Specific Data Standards: Contact (2014, 4.12)
	// Collection: Project Entry, Exit, and Every Contact Point
	// SEPARATE OBJECT (ClientEnrollmentContactVO.java)
	List<ClientEnrollmentContactVO> contacts;

	// Program Specific Data Standards: Date of Engagement (2014, 4.13)
	// Collection: Once, whenever the client becomes engaged
	private Date dateOfEngagement;

	// Program Specific Data Standards: Services Provided (2014, 4.14)
	// SEPARATE OBJECT (ClientEnrollmentServiceVO.java)
	List<ClientEnrollmentServiceVO> services;

	// Program Specific Data Standards: Financial Assets Provided (2014, 4.15)
	// SEPARATE OBJECT (ClientEnrollmentFinancialAssistanceVO.java)
	List<ClientEnrollmentFinancialAssistanceVO> financialAssistances;

	// Program Specific Data Standards: References Provided (2014, 4.16)
	// SEPARATE OBJECT (ClientEnrollmentReferralVO.java)
	List<ClientEnrollmentReferralVO> referrals;

	// Program Specific Data Standards: Residential Move-in Date (2014, 4.17)
	// Collection: On Entry, keep up to date
	// TODO: this should probably be a separate object
	private Date residentialMoveInDate;
	private YesNo inPermanentHousing;
	private Date permanentHousingMoveDate;

	// PATH Specific Data Standards: PATH Status (2014, 4.20)
	// Collection: Once, before exit.
	private Date dateOfPathStatus;
	private YesNo clentEnrolledInPath;
	private ClientReasonNotEnrolled reasonNotEnrolled;

	// RHY Specific Data Standards: RHY-BCP Status (2014, 4.22)
	// Collection: Once, when determining eligibility
	private Date dateOfBcpStatus;
	private YesNo fysbYouth;
	private ClientReasonNoServices reasonNoServices;

	// RHY Specific Data Standards: Sexual Orientation (2014, 4.23)
	// Collection: Project Entry
	private ClientSexualOrientation sexualOrientation;

	// RHY Specific Data Standards: Last Grade Completed (2014, 4.24)
	// Collection: Project Entry
	private ClientLastGradeCompleted lastGradeCompleted;

	// RHY Specific Data Standards: School Status (2014, 4.25)
	// Collection: Project Entry
	private ClientSchoolStatus schoolStatus;

	// RHY Specific Data Standards: Employment Status (2014, 4.26)
	// Collection: Project Entry
	private Date employedInformationDate;
	private YesNoReason employed;
	private ClientEmploymentType employmentType;
	private ClientNotEmployedReason notEmployedReason;

	// RHY Specific Data Standards: General Health Status (2014, 4.27)
	// Collection: Project Entry
	private ClientHealthStatus generalHealthStatus;

	// RHY Specific Data Standards: Dental Health Status (2014, 4.28)
	// Collection: Project Entry
	private ClientHealthStatus dentalHealthStatus;

	// RHY Specific Data Standards: Mental Health Status (2014, 4.29)
	// Collection: Project Entry
	private ClientHealthStatus mentalHealthStatus;

	// RHY Specific Data Standards: Pregnancy Status (2014, 4.30)
	// Collection: Project Entry (keep updated)
	private YesNoReason pregnancyStatusCode;
	private Date pregnancyDueDate;

	// RHY Specific Data Standards: Formerly Child Welfare (2014, 4.31)
	// Collection: Project Entry
	private YesNoReason formerlyChildWelfare;
	private ClientRhyNumberOfYears childWelfareYears;
	private Integer childWelfareMonths;

	// RHY Specific Data Standards: Formerly Juvenile Justice (2014, 4.32)
	// Collection: Project Entry
	private YesNoReason formerWardJuvenileJustice;
	private ClientRhyNumberOfYears juvenileJusticeYears;
	private Integer juvenileJusticeMonths;

	// RHY Specific Data Standards: Young Person's Critical Issues (2014, 4.33)
	// Collection: Project Entry
	private YesNo householdDynamics;
	private YesNo sexualOrientationGenderIdYouth;
	private YesNo sexualOrientationGenderIdFam;
	private YesNo housingIssuesYouth;
	private YesNo housingIssuesFam;
	private YesNo schoolEducationalIssuesYouth;
	private YesNo schoolEducationalIssuesFam;
	private YesNo unemploymentYouth;
	private YesNo unemploymentFam;
	private YesNo mentalHealthIssuesYouth;
	private YesNo mentalHealthIssuesFam;
	private YesNo healthIssuesYouth;
	private YesNo healthIssuesFam;
	private YesNo physicalDisabilityYouth;
	private YesNo physicalDisabilityFam;
	private YesNo mentalDisabilityYouth;
	private YesNo mentalDisabilityFam;
	private YesNo abuseAndNeglectYouth;
	private YesNo abuseAndNeglectFam;
	private YesNo alcoholDrugAbuseYouth;
	private YesNo alcoholDrugAbuseFam;
	private YesNo insufficientIncome;
	private YesNo activeMilitaryParent;
	private YesNo incarceratedParent;
	private ClientIncarceratedParentStatus incarceratedParentStatus;

	// RHY Specific Data Standards: Referral Source (2014, 4.34)
	// Collection: Project Entry
	private ClientReferralSource referralSource;
	private Integer countOUtreachReferralApproaches;

	// RHY Specific Data Standards: Commercial Sexual Exploitation (2014, 4.35)
	private YesNoReason exchangeForSexPastThreeMonths;
	// Collection: Project Entry
	private ClientCountExchangeForSex countOfExchangeForSex;
	private YesNoReason askedOrForcedToExchangeForSex;

	// HOPWA Specific Data Standards: Medical Assistance (2014, 4.39)
	// Collection: Project Entry, exit, update.
	// OTHER OBJECT: ClientEnrollmentHopwaMedicalAssistanceVO.java
	private List<ClientEnrollmentHopwaMedicalAssistanceVO> medicalAssistances;

	// RHSP Specific Data Standards: Worst Housing Situation (2014, 4.40)
	// Collection: Project Entry
	private YesNoReason worstHousingSituation;

	// VA Specific Data Standards: Percent of AMI (2014, 4.42)
	// Collection: Project Entry
	private ClientPercentAmi percentAmi;

	// VA Specific Data Standards: Last Permanent Address (2014, 4.43)
	// Collection: Project Entry
	private String lastPermanentStreet;
	private String lastPermanentCity;
	private String lastPermanentState;
	private String lastPermanentZip;
	private ClientAddressDataQuality addressDataQuality;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public ClientEnrollmentVO() {
		super();
	}

	@JsonProperty
	public String getEnrollmentId() {
		return enrollmentId;
	}

	@JsonProperty
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	@JsonProperty
	public String getPersonalId() {
		return personalId;
	}

	@JsonProperty
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	@JsonProperty
	public ClientExitVO getProjectExit() {
		return projectExit;
	}

	@JsonProperty
	public void setProjectExit(ClientExitVO projectExit) {
		this.projectExit = projectExit;
	}

	@JsonProperty
	public YesNoReason getDisablingCondition() {
		return disablingCondition;
	}

	@JsonProperty
	public void setDisablingCondition(YesNoReason disablingCondition) {
		this.disablingCondition = disablingCondition;
	}

	@JsonProperty
	public ClientResidencePrior getResidencePrior() {
		return residencePrior;
	}

	@JsonProperty
	public void setResidencePrior(ClientResidencePrior residencePrior) {
		this.residencePrior = residencePrior;
	}

	@JsonProperty
	public String getOtherResidence() {
		return otherResidence;
	}

	@JsonProperty
	public void setOtherResidence(String otherResidence) {
		this.otherResidence = otherResidence;
	}

	@JsonProperty
	public ClientResidencePriorLengthOfStay getResidencePriorLengthOfStay() {
		return residencePriorLengthOfStay;
	}

	@JsonProperty
	public void setResidencePriorLengthOfStay(
			ClientResidencePriorLengthOfStay residencePriorLengthOfStay) {
		this.residencePriorLengthOfStay = residencePriorLengthOfStay;
	}

	@JsonProperty
	public Date getEntryDate() {
		return entryDate;
	}

	@JsonProperty
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	@JsonProperty
	public String getHouseholdId() {
		return householdId;
	}

	@JsonProperty
	public void setHouseholdId(String householdId) {
		this.householdId = householdId;
	}

	@JsonProperty
	public ClientRelationshipToHoH getRelationshipToHoH() {
		return relationshipToHoH;
	}

	@JsonProperty
	public void setRelationshipToHoH(ClientRelationshipToHoH relationshipToHoH) {
		this.relationshipToHoH = relationshipToHoH;
	}

	@JsonProperty
	public Date getClientLocationInformationDate() {
		return clientLocationInformationDate;
	}

	@JsonProperty
	public void setClientLocationInformationDate(Date clientLocationInformationDate) {
		this.clientLocationInformationDate = clientLocationInformationDate;
	}

	@JsonProperty
	public String getCocCode() {
		return cocCode;
	}

	@JsonProperty
	public void setCocCode(String cocCode) {
		this.cocCode = cocCode;
	}

	@JsonProperty
	public YesNoReason getContinuouslyHomelessOneYear() {
		return continuouslyHomelessOneYear;
	}

	@JsonProperty
	public void setContinuouslyHomelessOneYear(
			YesNoReason continuouslyHomelessOneYear) {
		this.continuouslyHomelessOneYear = continuouslyHomelessOneYear;
	}

	@JsonProperty
	public ClientTimesHomelessPastThreeYears getTimesHomelessInPastThreeYears() {
		return timesHomelessInPastThreeYears;
	}

	@JsonProperty
	public void setTimesHomelessInPastThreeYears(
			ClientTimesHomelessPastThreeYears timesHomelessInPastThreeYears) {
		this.timesHomelessInPastThreeYears = timesHomelessInPastThreeYears;
	}

	@JsonProperty
	public ClientMonthsHomelessPastThreeYears getMonthsHomelessPastThreeYears() {
		return monthsHomelessPastThreeYears;
	}

	@JsonProperty
	public void setMonthsHomelessPastThreeYears(
			ClientMonthsHomelessPastThreeYears monthsHomelessPastThreeYears) {
		this.monthsHomelessPastThreeYears = monthsHomelessPastThreeYears;
	}

	@JsonProperty
	public Integer getMonthsHomelessThisTime() {
		return monthsHomelessThisTime;
	}

	@JsonProperty
	public void setMonthsHomelessThisTime(Integer monthsHomelessThisTime) {
		this.monthsHomelessThisTime = monthsHomelessThisTime;
	}

	@JsonProperty
	public YesNo getStatusDocumentedCode() {
		return statusDocumentedCode;
	}

	@JsonProperty
	public void setStatusDocumentedCode(YesNo statusDocumentedCode) {
		this.statusDocumentedCode = statusDocumentedCode;
	}

	@JsonProperty
	public ClientHousingStatus getHousingStatus() {
		return housingStatus;
	}

	@JsonProperty
	public void setHousingStatus(ClientHousingStatus housingStatus) {
		this.housingStatus = housingStatus;
	}

	@JsonProperty
	public List<ClientEnrollmentIncomeSourceVO> getIncomeSources() {
		return incomeSources;
	}

	@JsonProperty
	public void setIncomeSources(List<ClientEnrollmentIncomeSourceVO> incomeSources) {
		this.incomeSources = incomeSources;
	}

	@JsonProperty
	public List<ClientEnrollmentNonCashBenefitVO> getNonCashBenefits() {
		return nonCashBenefits;
	}

	@JsonProperty
	public void setNonCashBenefits(
			List<ClientEnrollmentNonCashBenefitVO> nonCashBenefits) {
		this.nonCashBenefits = nonCashBenefits;
	}

	@JsonProperty
	public List<ClientEnrollmentHealthInsuranceVO> getHealthInsurances() {
		return healthInsurances;
	}

	@JsonProperty
	public void setHealthInsurances(
			List<ClientEnrollmentHealthInsuranceVO> healthInsurances) {
		this.healthInsurances = healthInsurances;
	}

	@JsonProperty
	public List<ClientEnrollmentPhysicalDisabilityVO> getPhysicalDisabilities() {
		return physicalDisabilities;
	}

	@JsonProperty
	public void setPhysicalDisabilities(
			List<ClientEnrollmentPhysicalDisabilityVO> physicalDisabilities) {
		this.physicalDisabilities = physicalDisabilities;
	}

	@JsonProperty
	public List<ClientEnrollmentDevelopmentalDisabilityVO> getDevelopmentalDisabilities() {
		return developmentalDisabilities;
	}

	@JsonProperty
	public void setDevelopmentalDisabilities(
			List<ClientEnrollmentDevelopmentalDisabilityVO> developmentalDisabilities) {
		this.developmentalDisabilities = developmentalDisabilities;
	}

	@JsonProperty
	public List<ClientEnrollmentChronicHealthConditionVO> getChronicHealthConditions() {
		return chronicHealthConditions;
	}

	@JsonProperty
	public void setChronicHealthConditions(
			List<ClientEnrollmentChronicHealthConditionVO> chronicHealthConditions) {
		this.chronicHealthConditions = chronicHealthConditions;
	}

	@JsonProperty
	public List<ClientEnrollmentHivAidsVO> getHivAidsStatuses() {
		return hivAidsStatuses;
	}

	@JsonProperty
	public void setHivAidsStatuses(List<ClientEnrollmentHivAidsVO> hivAidsStatuses) {
		this.hivAidsStatuses = hivAidsStatuses;
	}

	@JsonProperty
	public List<ClientEnrollmentMentalHealthProblemVO> getMentalHealthProblems() {
		return mentalHealthProblems;
	}

	@JsonProperty
	public void setMentalHealthProblems(
			List<ClientEnrollmentMentalHealthProblemVO> mentalHealthProblems) {
		this.mentalHealthProblems = mentalHealthProblems;
	}

	@JsonProperty
	public List<ClientEnrollmentSubstanceAbuseVO> getSubstanceAbuses() {
		return substanceAbuses;
	}

	@JsonProperty
	public void setSubstanceAbuses(
			List<ClientEnrollmentSubstanceAbuseVO> substanceAbuses) {
		this.substanceAbuses = substanceAbuses;
	}

	@JsonProperty
	public List<ClientEnrollmentDomesticAbuseVO> getDomesticAbuses() {
		return domesticAbuses;
	}

	@JsonProperty
	public void setDomesticAbuses(
			List<ClientEnrollmentDomesticAbuseVO> domesticAbuses) {
		this.domesticAbuses = domesticAbuses;
	}

	@JsonProperty
	public List<ClientEnrollmentContactVO> getContacts() {
		return contacts;
	}

	@JsonProperty
	public void setContacts(List<ClientEnrollmentContactVO> contacts) {
		this.contacts = contacts;
	}

	@JsonProperty
	public Date getDateOfEngagement() {
		return dateOfEngagement;
	}

	@JsonProperty
	public void setDateOfEngagement(Date dateOfEngagement) {
		this.dateOfEngagement = dateOfEngagement;
	}

	@JsonProperty
	public List<ClientEnrollmentServiceVO> getServices() {
		return services;
	}

	@JsonProperty
	public void setServices(List<ClientEnrollmentServiceVO> services) {
		this.services = services;
	}

	@JsonProperty
	public List<ClientEnrollmentFinancialAssistanceVO> getFinancialAssistances() {
		return financialAssistances;
	}

	@JsonProperty
	public void setFinancialAssistances(
			List<ClientEnrollmentFinancialAssistanceVO> financialAssistances) {
		this.financialAssistances = financialAssistances;
	}

	@JsonProperty
	public List<ClientEnrollmentReferralVO> getReferrals() {
		return referrals;
	}

	@JsonProperty
	public void setReferrals(List<ClientEnrollmentReferralVO> referrals) {
		this.referrals = referrals;
	}

	@JsonProperty
	public Date getResidentialMoveInDate() {
		return residentialMoveInDate;
	}

	@JsonProperty
	public void setResidentialMoveInDate(Date residentialMoveInDate) {
		this.residentialMoveInDate = residentialMoveInDate;
	}

	@JsonProperty
	public YesNo getInPermanentHousing() {
		return inPermanentHousing;
	}

	@JsonProperty
	public void setInPermanentHousing(YesNo inPermanentHousing) {
		this.inPermanentHousing = inPermanentHousing;
	}

	@JsonProperty
	public Date getPermanentHousingMoveDate() {
		return permanentHousingMoveDate;
	}

	@JsonProperty
	public void setPermanentHousingMoveDate(Date permanentHousingMoveDate) {
		this.permanentHousingMoveDate = permanentHousingMoveDate;
	}

	@JsonProperty
	public Date getDateOfPathStatus() {
		return dateOfPathStatus;
	}

	@JsonProperty
	public void setDateOfPathStatus(Date dateOfPathStatus) {
		this.dateOfPathStatus = dateOfPathStatus;
	}

	@JsonProperty
	public YesNo getClentEnrolledInPath() {
		return clentEnrolledInPath;
	}

	@JsonProperty
	public void setClentEnrolledInPath(YesNo clentEnrolledInPath) {
		this.clentEnrolledInPath = clentEnrolledInPath;
	}

	@JsonProperty
	public ClientReasonNotEnrolled getReasonNotEnrolled() {
		return reasonNotEnrolled;
	}

	@JsonProperty
	public void setReasonNotEnrolled(ClientReasonNotEnrolled reasonNotEnrolled) {
		this.reasonNotEnrolled = reasonNotEnrolled;
	}

	@JsonProperty
	public Date getDateOfBcpStatus() {
		return dateOfBcpStatus;
	}

	@JsonProperty
	public void setDateOfBcpStatus(Date dateOfBcpStatus) {
		this.dateOfBcpStatus = dateOfBcpStatus;
	}

	@JsonProperty
	public YesNo getFysbYouth() {
		return fysbYouth;
	}

	@JsonProperty
	public void setFysbYouth(YesNo fysbYouth) {
		this.fysbYouth = fysbYouth;
	}

	@JsonProperty
	public ClientReasonNoServices getReasonNoServices() {
		return reasonNoServices;
	}

	@JsonProperty
	public void setReasonNoServices(ClientReasonNoServices reasonNoServices) {
		this.reasonNoServices = reasonNoServices;
	}

	@JsonProperty
	public ClientSexualOrientation getSexualOrientation() {
		return sexualOrientation;
	}

	@JsonProperty
	public void setSexualOrientation(ClientSexualOrientation sexualOrientation) {
		this.sexualOrientation = sexualOrientation;
	}

	@JsonProperty
	public ClientLastGradeCompleted getLastGradeCompleted() {
		return lastGradeCompleted;
	}

	@JsonProperty
	public void setLastGradeCompleted(ClientLastGradeCompleted lastGradeCompleted) {
		this.lastGradeCompleted = lastGradeCompleted;
	}

	@JsonProperty
	public ClientSchoolStatus getSchoolStatus() {
		return schoolStatus;
	}

	@JsonProperty
	public void setSchoolStatus(ClientSchoolStatus schoolStatus) {
		this.schoolStatus = schoolStatus;
	}

	@JsonProperty
	public Date getEmployedInformationDate() {
		return employedInformationDate;
	}

	@JsonProperty
	public void setEmployedInformationDate(Date employedInformationDate) {
		this.employedInformationDate = employedInformationDate;
	}

	@JsonProperty
	public YesNoReason getEmployed() {
		return employed;
	}

	@JsonProperty
	public void setEmployed(YesNoReason employed) {
		this.employed = employed;
	}

	@JsonProperty
	public ClientEmploymentType getEmploymentType() {
		return employmentType;
	}

	@JsonProperty
	public void setEmploymentType(ClientEmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	@JsonProperty
	public ClientNotEmployedReason getNotEmployedReason() {
		return notEmployedReason;
	}

	@JsonProperty
	public void setNotEmployedReason(ClientNotEmployedReason notEmployedReason) {
		this.notEmployedReason = notEmployedReason;
	}

	@JsonProperty
	public ClientHealthStatus getGeneralHealthStatus() {
		return generalHealthStatus;
	}

	@JsonProperty
	public void setGeneralHealthStatus(ClientHealthStatus generalHealthStatus) {
		this.generalHealthStatus = generalHealthStatus;
	}

	@JsonProperty
	public ClientHealthStatus getDentalHealthStatus() {
		return dentalHealthStatus;
	}

	@JsonProperty
	public void setDentalHealthStatus(ClientHealthStatus dentalHealthStatus) {
		this.dentalHealthStatus = dentalHealthStatus;
	}

	@JsonProperty
	public ClientHealthStatus getMentalHealthStatus() {
		return mentalHealthStatus;
	}

	@JsonProperty
	public void setMentalHealthStatus(ClientHealthStatus mentalHealthStatus) {
		this.mentalHealthStatus = mentalHealthStatus;
	}

	@JsonProperty
	public YesNoReason getPregnancyStatusCode() {
		return pregnancyStatusCode;
	}

	@JsonProperty
	public void setPregnancyStatusCode(YesNoReason pregnancyStatusCode) {
		this.pregnancyStatusCode = pregnancyStatusCode;
	}

	@JsonProperty
	public Date getPregnancyDueDate() {
		return pregnancyDueDate;
	}

	@JsonProperty
	public void setPregnancyDueDate(Date pregnancyDueDate) {
		this.pregnancyDueDate = pregnancyDueDate;
	}

	@JsonProperty
	public YesNoReason getFormerlyChildWelfare() {
		return formerlyChildWelfare;
	}

	@JsonProperty
	public void setFormerlyChildWelfare(YesNoReason formerlyChildWelfare) {
		this.formerlyChildWelfare = formerlyChildWelfare;
	}

	@JsonProperty
	public ClientRhyNumberOfYears getChildWelfareYears() {
		return childWelfareYears;
	}

	@JsonProperty
	public void setChildWelfareYears(ClientRhyNumberOfYears childWelfareYears) {
		this.childWelfareYears = childWelfareYears;
	}

	@JsonProperty
	public Integer getChildWelfareMonths() {
		return childWelfareMonths;
	}

	@JsonProperty
	public void setChildWelfareMonths(Integer childWelfareMonths) {
		this.childWelfareMonths = childWelfareMonths;
	}

	@JsonProperty
	public YesNoReason getFormerWardJuvenileJustice() {
		return formerWardJuvenileJustice;
	}

	@JsonProperty
	public void setFormerWardJuvenileJustice(YesNoReason formerWardJuvenileJustice) {
		this.formerWardJuvenileJustice = formerWardJuvenileJustice;
	}

	@JsonProperty
	public ClientRhyNumberOfYears getJuvenileJusticeYears() {
		return juvenileJusticeYears;
	}

	@JsonProperty
	public void setJuvenileJusticeYears(ClientRhyNumberOfYears juvenileJusticeYears) {
		this.juvenileJusticeYears = juvenileJusticeYears;
	}

	@JsonProperty
	public Integer getJuvenileJusticeMonths() {
		return juvenileJusticeMonths;
	}

	@JsonProperty
	public void setJuvenileJusticeMonths(Integer juvenileJusticeMonths) {
		this.juvenileJusticeMonths = juvenileJusticeMonths;
	}

	@JsonProperty
	public YesNo getHouseholdDynamics() {
		return householdDynamics;
	}

	@JsonProperty
	public void setHouseholdDynamics(YesNo householdDynamics) {
		this.householdDynamics = householdDynamics;
	}

	@JsonProperty
	public YesNo getSexualOrientationGenderIdYouth() {
		return sexualOrientationGenderIdYouth;
	}

	@JsonProperty
	public void setSexualOrientationGenderIdYouth(
			YesNo sexualOrientationGenderIdYouth) {
		this.sexualOrientationGenderIdYouth = sexualOrientationGenderIdYouth;
	}

	@JsonProperty
	public YesNo getSexualOrientationGenderIdFam() {
		return sexualOrientationGenderIdFam;
	}

	@JsonProperty
	public void setSexualOrientationGenderIdFam(YesNo sexualOrientationGenderIdFam) {
		this.sexualOrientationGenderIdFam = sexualOrientationGenderIdFam;
	}

	@JsonProperty
	public YesNo getHousingIssuesYouth() {
		return housingIssuesYouth;
	}

	@JsonProperty
	public void setHousingIssuesYouth(YesNo housingIssuesYouth) {
		this.housingIssuesYouth = housingIssuesYouth;
	}

	@JsonProperty
	public YesNo getHousingIssuesFam() {
		return housingIssuesFam;
	}

	@JsonProperty
	public void setHousingIssuesFam(YesNo housingIssuesFam) {
		this.housingIssuesFam = housingIssuesFam;
	}

	@JsonProperty
	public YesNo getSchoolEducationalIssuesYouth() {
		return schoolEducationalIssuesYouth;
	}

	@JsonProperty
	public void setSchoolEducationalIssuesYouth(YesNo schoolEducationalIssuesYouth) {
		this.schoolEducationalIssuesYouth = schoolEducationalIssuesYouth;
	}

	@JsonProperty
	public YesNo getSchoolEducationalIssuesFam() {
		return schoolEducationalIssuesFam;
	}

	@JsonProperty
	public void setSchoolEducationalIssuesFam(YesNo schoolEducationalIssuesFam) {
		this.schoolEducationalIssuesFam = schoolEducationalIssuesFam;
	}

	@JsonProperty
	public YesNo getUnemploymentYouth() {
		return unemploymentYouth;
	}

	@JsonProperty
	public void setUnemploymentYouth(YesNo unemploymentYouth) {
		this.unemploymentYouth = unemploymentYouth;
	}

	@JsonProperty
	public YesNo getUnemploymentFam() {
		return unemploymentFam;
	}

	@JsonProperty
	public void setUnemploymentFam(YesNo unemploymentFam) {
		this.unemploymentFam = unemploymentFam;
	}

	@JsonProperty
	public YesNo getMentalHealthIssuesYouth() {
		return mentalHealthIssuesYouth;
	}

	@JsonProperty
	public void setMentalHealthIssuesYouth(YesNo mentalHealthIssuesYouth) {
		this.mentalHealthIssuesYouth = mentalHealthIssuesYouth;
	}

	@JsonProperty
	public YesNo getMentalHealthIssuesFam() {
		return mentalHealthIssuesFam;
	}

	@JsonProperty
	public void setMentalHealthIssuesFam(YesNo mentalHealthIssuesFam) {
		this.mentalHealthIssuesFam = mentalHealthIssuesFam;
	}

	@JsonProperty
	public YesNo getHealthIssuesYouth() {
		return healthIssuesYouth;
	}

	@JsonProperty
	public void setHealthIssuesYouth(YesNo healthIssuesYouth) {
		this.healthIssuesYouth = healthIssuesYouth;
	}

	@JsonProperty
	public YesNo getHealthIssuesFam() {
		return healthIssuesFam;
	}

	@JsonProperty
	public void setHealthIssuesFam(YesNo healthIssuesFam) {
		this.healthIssuesFam = healthIssuesFam;
	}

	@JsonProperty
	public YesNo getPhysicalDisabilityYouth() {
		return physicalDisabilityYouth;
	}

	@JsonProperty
	public void setPhysicalDisabilityYouth(YesNo physicalDisabilityYouth) {
		this.physicalDisabilityYouth = physicalDisabilityYouth;
	}

	@JsonProperty
	public YesNo getPhysicalDisabilityFam() {
		return physicalDisabilityFam;
	}

	@JsonProperty
	public void setPhysicalDisabilityFam(YesNo physicalDisabilityFam) {
		this.physicalDisabilityFam = physicalDisabilityFam;
	}

	@JsonProperty
	public YesNo getMentalDisabilityYouth() {
		return mentalDisabilityYouth;
	}

	@JsonProperty
	public void setMentalDisabilityYouth(YesNo mentalDisabilityYouth) {
		this.mentalDisabilityYouth = mentalDisabilityYouth;
	}

	@JsonProperty
	public YesNo getMentalDisabilityFam() {
		return mentalDisabilityFam;
	}

	@JsonProperty
	public void setMentalDisabilityFam(YesNo mentalDisabilityFam) {
		this.mentalDisabilityFam = mentalDisabilityFam;
	}

	@JsonProperty
	public YesNo getAbuseAndNeglectYouth() {
		return abuseAndNeglectYouth;
	}

	@JsonProperty
	public void setAbuseAndNeglectYouth(YesNo abuseAndNeglectYouth) {
		this.abuseAndNeglectYouth = abuseAndNeglectYouth;
	}

	@JsonProperty
	public YesNo getAbuseAndNeglectFam() {
		return abuseAndNeglectFam;
	}

	@JsonProperty
	public void setAbuseAndNeglectFam(YesNo abuseAndNeglectFam) {
		this.abuseAndNeglectFam = abuseAndNeglectFam;
	}

	@JsonProperty
	public YesNo getAlcoholDrugAbuseYouth() {
		return alcoholDrugAbuseYouth;
	}

	@JsonProperty
	public void setAlcoholDrugAbuseYouth(YesNo alcoholDrugAbuseYouth) {
		this.alcoholDrugAbuseYouth = alcoholDrugAbuseYouth;
	}

	@JsonProperty
	public YesNo getAlcoholDrugAbuseFam() {
		return alcoholDrugAbuseFam;
	}

	@JsonProperty
	public void setAlcoholDrugAbuseFam(YesNo alcoholDrugAbuseFam) {
		this.alcoholDrugAbuseFam = alcoholDrugAbuseFam;
	}

	@JsonProperty
	public YesNo getInsufficientIncome() {
		return insufficientIncome;
	}

	@JsonProperty
	public void setInsufficientIncome(YesNo insufficientIncome) {
		this.insufficientIncome = insufficientIncome;
	}

	@JsonProperty
	public YesNo getActiveMilitaryParent() {
		return activeMilitaryParent;
	}

	@JsonProperty
	public void setActiveMilitaryParent(YesNo activeMilitaryParent) {
		this.activeMilitaryParent = activeMilitaryParent;
	}

	@JsonProperty
	public YesNo getIncarceratedParent() {
		return incarceratedParent;
	}

	@JsonProperty
	public void setIncarceratedParent(YesNo incarceratedParent) {
		this.incarceratedParent = incarceratedParent;
	}

	@JsonProperty
	public ClientIncarceratedParentStatus getIncarceratedParentStatus() {
		return incarceratedParentStatus;
	}

	@JsonProperty
	public void setIncarceratedParentStatus(
			ClientIncarceratedParentStatus incarceratedParentStatus) {
		this.incarceratedParentStatus = incarceratedParentStatus;
	}

	@JsonProperty
	public ClientReferralSource getReferralSource() {
		return referralSource;
	}

	@JsonProperty
	public void setReferralSource(ClientReferralSource referralSource) {
		this.referralSource = referralSource;
	}

	@JsonProperty
	public Integer getCountOUtreachReferralApproaches() {
		return countOUtreachReferralApproaches;
	}

	@JsonProperty
	public void setCountOUtreachReferralApproaches(
			Integer countOUtreachReferralApproaches) {
		this.countOUtreachReferralApproaches = countOUtreachReferralApproaches;
	}

	@JsonProperty
	public YesNoReason getExchangeForSexPastThreeMonths() {
		return exchangeForSexPastThreeMonths;
	}

	@JsonProperty
	public void setExchangeForSexPastThreeMonths(
			YesNoReason exchangeForSexPastThreeMonths) {
		this.exchangeForSexPastThreeMonths = exchangeForSexPastThreeMonths;
	}

	@JsonProperty
	public ClientCountExchangeForSex getCountOfExchangeForSex() {
		return countOfExchangeForSex;
	}

	@JsonProperty
	public void setCountOfExchangeForSex(
			ClientCountExchangeForSex countOfExchangeForSex) {
		this.countOfExchangeForSex = countOfExchangeForSex;
	}

	@JsonProperty
	public YesNoReason getAskedOrForcedToExchangeForSex() {
		return askedOrForcedToExchangeForSex;
	}

	@JsonProperty
	public void setAskedOrForcedToExchangeForSex(
			YesNoReason askedOrForcedToExchangeForSex) {
		this.askedOrForcedToExchangeForSex = askedOrForcedToExchangeForSex;
	}

	@JsonProperty
	public List<ClientEnrollmentHopwaMedicalAssistanceVO> getMedicalAssistances() {
		return medicalAssistances;
	}

	@JsonProperty
	public void setMedicalAssistances(
			List<ClientEnrollmentHopwaMedicalAssistanceVO> medicalAssistances) {
		this.medicalAssistances = medicalAssistances;
	}

	@JsonProperty
	public YesNoReason getWorstHousingSituation() {
		return worstHousingSituation;
	}

	@JsonProperty
	public void setWorstHousingSituation(YesNoReason worstHousingSituation) {
		this.worstHousingSituation = worstHousingSituation;
	}

	@JsonProperty
	public ClientPercentAmi getPercentAmi() {
		return percentAmi;
	}

	@JsonProperty
	public void setPercentAmi(ClientPercentAmi percentAmi) {
		this.percentAmi = percentAmi;
	}

	@JsonProperty
	public String getLastPermanentStreet() {
		return lastPermanentStreet;
	}

	@JsonProperty
	public void setLastPermanentStreet(String lastPermanentStreet) {
		this.lastPermanentStreet = lastPermanentStreet;
	}

	@JsonProperty
	public String getLastPermanentCity() {
		return lastPermanentCity;
	}

	@JsonProperty
	public void setLastPermanentCity(String lastPermanentCity) {
		this.lastPermanentCity = lastPermanentCity;
	}

	@JsonProperty
	public String getLastPermanentState() {
		return lastPermanentState;
	}

	@JsonProperty
	public void setLastPermanentState(String lastPermanentState) {
		this.lastPermanentState = lastPermanentState;
	}

	@JsonProperty
	public String getLastPermanentZip() {
		return lastPermanentZip;
	}

	@JsonProperty
	public void setLastPermanentZip(String lastPermanentZip) {
		this.lastPermanentZip = lastPermanentZip;
	}

	@JsonProperty
	public ClientAddressDataQuality getAddressDataQuality() {
		return addressDataQuality;
	}

	@JsonProperty
	public void setAddressDataQuality(ClientAddressDataQuality addressDataQuality) {
		this.addressDataQuality = addressDataQuality;
	}

	@JsonProperty
	public Date getDateCreated() {
		return dateCreated;
	}

	@JsonProperty
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@JsonProperty
	public Date getDateUpdated() {
		return dateUpdated;
	}

	@JsonProperty
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
}
