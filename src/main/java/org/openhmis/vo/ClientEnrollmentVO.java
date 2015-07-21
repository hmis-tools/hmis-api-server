/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class ClientEnrollmentVO implements Serializable
{
	/**
	 * The client object represents a client enrollment record
	 * Fields returned with the client object represent fields marked as "At project entry" in the HUD standards
	 */
	private String clientId;

	// Universal Data Standard: Disabling Condition (2014, 3.8)
	private Integer disablingConditionCode;

	// Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)
	private Integer typeOfResidenceCode;
	private String otherResidence;
	private Integer lengthOfStayInPreviousPlaceCode;

	// Universal Data Standard: Project Entry Date (2014, 3.10)
	private Date projectEntryDate;

	// Universal Data Standard: Project Entry Date (2014, 3.11)
	private Date projectExitDate;

	// Universal Data Standard: Destination (2014, 3.12)
	private Integer destinationTypeCode;
	private String otherDestination;

	// Universal Data Standard: Household ID (2014, 3.14)
	private String householdId;

	// Universal Data Standard: Relationship to Head of Household (2014, 3.15)
	private Integer relationshipToHeadOfHouseholdCode;
	
	// Universal Data Standard: Client Location (2014, 3.16)
	private Date clientLocationInformationDate;
	private Integer clientLocationCoCCode;

	// Universal Data Standard: Length of Time on Street, in an Emergency Shelter, or Safe Haven (2014, 3.17)
	private Integer continuouslyHomelessForOneYearCode;
	private Integer numberOfTimesHomelessInPastThreeYearsCode;
	private Integer numberOfMonthsHomelessInPastThreeYearsCode;
	private Integer numberOfMonthsContinuouslyHomelessImmediatelyPriorToEntry;
	private Integer statusDocumentedCode;

	// Program Specific Data Standards: Housing Status (2014, 4.1)
	private Integer homelessnessStatusCode;

	// Program Specific Data Standards: Income Sources (2014, 4.2)
	private Date incomeInformationDate;
	private Integer incomeFromAnySourceCode;
	private Integer incomeEarnedCode;
	private Double incomeEarnedMonthlyAmount;
	private Integer incomeUnemploymentInsuranceCode;
	private Double incomeUnemploymentInsuranceMonthlyAmount;
	private Integer incomeSupplementalSecurityCode;
	private Double incomeSupplementalSecurityMonthlyAmount;
	private Integer incomeSocialSecurityDisabilityCode;
	private Double incomeSocialSecurityDisabilityMonthlyAmount;
	private Integer incomeVaServiceDisabilityCode;
	private Double incomeVaServiceDisabilityMonthlyAmount;
	private Integer incomeVaNonServiceDisabilityCode;
	private Double incomeVaNonServiceDisabilityMonthlyAmount;
	private Integer incomePrivateDisabilityInsuranceCode;
	private Double incomePrivateDisabilityInsuranceMonthlyAmount;
	private Integer incomeWorkersCompensationCode;
	private Double incomeWorkersCompensationMonthlyAmount;
	private Integer incomeTemporaryAssistanceForNeedyFamiliesCode;
	private Double incomeTemporaryAssistanceForNeedyFamiliesMonthlyAmount;
	private Integer incomeGeneralAssistanceCode;
	private Double incomeGeneralAssistanceMonthlyAmount;
	private Integer incomeChildSupportCode;
	private Double incomeChildSupportMonthlyAmount;
	private Integer incomeAlimonyCode;
	private Double incomeAlimonyMonthlyAmount;

	// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
	private Date nonCashBenefitsInformationDate;
	private Integer nonCashBenefitsFromAnySourceCode;
	private Integer nonCashBenefitsSnapCode;
	private Integer nonCashBenefitsWicCode;
	private Integer nonCashBenefitsTanfChildCareCode;
	private Integer nonCashBenefitsTanfTransportationCode;
	private Integer nonCashBenefitsTanfOtherCode;
	private Integer nonCashBenefitsSection8Code;
	private Integer nonCashBenefitsOtherSourceCode;
	private Integer nonCashBenefitsTemporaryRentalCode;
	private String nonCashBenefitsOtherSource;

	// Program Specific Data Standards: Health Insurance (2014, 4.4)
	private Date healthInsuranceInformationDate;
	private Integer coveredByHealthInsuranceCode;
	private Integer healthInsuranceMedicaidCode;
	private Integer healthInsuranceNoMedicaidReasonCode;
	private Integer healthInsuranceMedicareCode;
	private Integer healthInsuranceNoMedicareReasonCode;
	private Integer healthInsuranceStateChildrensHealthInsuranceCode;
	private Integer healthInsuranceNoStateChildrenReasonCode;
	private Integer healthInsuranceVaMedicalServicesCode;
	private Integer healthInsuranceNoVaMedicalServicesReasonCode;
	private Integer healthInsuranceEmployerProvidedCode;
	private Integer healthInsuranceNoEmployerProvidedReasonCode;
	private Integer healthInsuranceCobraCode;
	private Integer healthInsuranceNoCobraReasonCode;
	private Integer healthInsurancePrivatePayCode;
	private Integer healthInsuranceNoPrivatePayReasonCode;
	private Integer healthInsuranceStateAdultsCode;
	private Integer healthInsuranceNoStateAdultsReasonCode;

	// Program Specific Data Standards: Physical Disability (2014, 4.5)
	private Date physicalDisabilityInformationDate;
	private Integer physicalDisabilityCode;
	private Integer physicalDisabilityIndependenceCode;
	private Integer physicalDisabilityDocumentedCode;
	private Integer physicalDisabilityTreatmentCode;

	// Program Specific Data Standards: Developmental Disability (2014, 4.6)
	private Date developmentalDisabilityInformationDate;
	private Integer developmentalDisabilityCode;
	private Integer developmentalDisabilityIndependenceCode;
	private Integer developmentalDisabilityDocumentedCode;
	private Integer developmentalDisabilityTreatmentCode;

	// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
	private Date chronicHealthInformationDate;
	private Integer chronicHealthCode;
	private Integer chronicHealthIndependenceCode;
	private Integer chronicHealthDocumentedCode;
	private Integer chronicHealthTreatmentCode;

	// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
	private Date hivInformationDate;
	private Integer hivCode;
	private Integer hivIndependenceCode;
	private Integer hivDocumentedCode;
	private Integer hivTreatmentCode;

	// Program Specific Data Standards: Mental Health Problem (2014, 4.9)
	private Date mentalHealthInformationDate;
	private Integer mentalHealthCode;
	private Integer mentalHealthIndependenceCode;
	private Integer mentalHealthDocumentedCode;
	private Integer mentalHealthTreatmentCode;
	private Integer mentalHealthConfirmedCode;
	private Integer mentalHealthSmiCode;

	// Program Specific Data Standards: Substance Abuse (2014, 4.10)
	private Date substanceAbuseInformationDate;
	private Integer substanceAbuseCode;
	private Integer substanceAbuseIndependenceCode;
	private Integer substanceAbuseDocumentedCode;
	private Integer substanceAbuseTreatmentCode;
	private Integer substanceAbuseConfirmedCode;

	// Program Specific Data Standards: Domestic Abuse (2014, 4.11)
	private Date domesticAbuseInformationDate;
	private Integer domesticAbuseCode;
	private Integer domesticAbuseTimeframeCode;

	// Program Specific Data Standards: Contact (2014, 4.12)
	// SEPARATE OBJECT (ClientEnrollmentContactVO.java)

	// Program Specific Data Standards: Date of Engagement (2014, 4.13)
	private Date engagementDate;

	// Program Specific Data Standards: Services Provided (2014, 4.14)
	// SEPARATE OBJECT (ClientEnrollmentServiceVO.java)

	// Program Specific Data Standards: Financial Assets Provided (2014, 4.15)
	// SEPARATE OBJECT (ClientEnrollmentFinancialAssistanceVO.java)

	// Program Specific Data Standards: References Provided (2014, 4.16)
	// SEPARATE OBJECT (ClientEnrollmentReferralVO.java)

	// Program Specific Data Standards: Residential Move-in Date (2014, 4.17)
	private Date residentialMoveInDate;
	private Integer permanentHousingCode;
	private Date permanentHousingMoveDate;

	// Program Specific Data Standards: Housing Assessment Disposition (2014, 4.18)
	private Integer housingAssessmentDispositionCode;
	private String housingAssessmentDispositionOther;

	// Program Specific Data Standards: Housing Assessment on Exit (2014, 4.19)
	private Integer housingAssessmentAtExitCode;
	private Integer housingAssessmentAtExitMaintainedSubsidyCode;
	private Integer housingAssessmentAtExitMovedSubsidyCode;
	
	// PATH Specific Data Standards: PATH Status (2014, 4.20)
	private Date pathStatusDate;
	private Integer pathEnrollmentCode;
	private Integer pathNoEnrollmentReasonCode;

	// PATH Specific Data Standards: Connection with SOAR (2014, 4.21)
	private Integer connectionWithSoarCode;

	// RHY Specific Data Standards: RHY-BCP Status (2014, 4.22)
	private Date rhyBcpStatusDate;
	private Integer fysbYouthEnrollmentCode;
	private Integer fysbYouthNoEnrollmentReasonCode;

	// RHY Specific Data Standards: Sexual Orientation (2014, 4.23)
	private Integer sexualOrientationCode;

	// RHY Specific Data Standards: Last Grade Completed (2014, 4.24)
	private Integer lastGradeCompletedCode;

	// RHY Specific Data Standards: School Status (2014, 4.25)
	private Integer schoolStatusCode;

	// RHY Specific Data Standards: Employment Status (2014, 4.26)
	private Date employmentEntryInformationDate;
	private Integer employmentEntryStatusCode;
	private Integer employmentEntryTypeCode;
	private Integer employmentEntryUnemployedReasonCode;

	private Date employmentExitInformationDate;
	private Integer employmentExitStatusCode;
	private Integer employmentExitTypeCode;
	private Integer employmentExitUnemployedReasonCode;

	// RHY Specific Data Standards: General Health Status (2014, 4.27)
	private Integer generalHealthEntryStatusCode;
	private Integer generalHealthExitStatusCode;

	// RHY Specific Data Standards: Dental Health Status (2014, 4.28)
	private Integer dentalHealthEntryStatusCode;
	private Integer dentalHealthExitStatusCode;

	// RHY Specific Data Standards: Mental Health Status (2014, 4.29)
	private Integer mentalHealthEntryStatusCode;
	private Integer mentalHealthExitStatusCode;

	// RHY Specific Data Standards: Pregnancy Status (2014, 4.30)
	private Integer pregnancyStatusCode;
	private Date pregnancyDueDate;

	// RHY Specific Data Standards: Formerly Child Welfare (2014, 4.31)
	private Integer formerlyChildWelfareCode;
	private Integer formerlyChildWelfareYearDurationCode;
	private Integer formerlyChildWelfareMonthDurationCode;

	// RHY Specific Data Standards: Formerly Juvenile Justice (2014, 4.32)
	private Integer formerlyJuvenileJusticeCode;
	private Integer formerlyJuvenileJusticeYearDurationCode;
	private Integer formerlyJuvenileJusticeMonthDurationCode;

	// RHY Specific Data Standards: Young Person's Critical Issues (2014, 4.33)
	private Integer householdDynamicsCode;
	private Integer sexualOrientationYouthCode;
	private Integer sexualOrientationFamilyCode;
	private Integer housingIssuesYouthCode;
	private Integer housingIssuesFamilyCode;
	private Integer schoolIssuesYouthCode;
	private Integer schoolIssuesFamilyCode;
	private Integer unemploymentYouthCode;
	private Integer unemploymentFamilyCode;
	private Integer mentalHealthYouthCode;
	private Integer mentalHealthFamilyCode;
	private Integer healthYouthCode;
	private Integer healthFamilyCode;
	private Integer physicalDisabilityYouthCode;
	private Integer physicalDisabilityFamilycode;
	private Integer mentalDisabilityYouthCode;
	private Integer mentalDisabilityFamilyCode;
	private Integer abuseNeglectYouthCode;
	private Integer abuseNeglectFamilyCode;
	private Integer alcoholAbuseYouthCode;
	private Integer alcoholAbuseFamilyCode;
	private Integer insufficientIncomeFamilyCode;
	private Integer activeMilitaryFamilyCode;
	private Integer incarceratedParentOfYouthCode;
	private Integer incarceratedParentOfYouthDetailCode;

	// RHY Specific Data Standards: Referral Source (2014, 4.34)
	private Integer referralSourceCode;
	private Integer referralOutreachCount;

	// RHY Specific Data Standards: Commercial Sexual Exploitation (2014, 4.35)
	private Integer sexualExploitationInPastThreeMonthsCode;
	private Integer sexualExploitationInPastThreeMonthsAmountCode;
	private Integer sexualExplotationRequestCode;

	// RHY Specific Data Standards: Transitional Exit Care (2014, 4.36)
	private Integer afterCarePlanAgreementCode;
	private Integer afterCareAdviceCode;
	private Integer afterCarePlacementCode;
	private Integer afterCareShelterCode;
	private Integer afterCareFollowupServicesCode;
	private Integer afterCareFollowupMeetingCode;
	private Integer afterCareInformationPackageCode;
	private Integer afterCareOtherCode;

	// RHY Specific Data Standards: Project Completion Status (2014, 4.37)
	private Integer rhyCompletionStatusCode;
	private Integer rhyEarlyExitReasonCode;
	private Integer rhyExpulsionReasonCode;

	// RHY Specific Data Standards: Family Reunification Achieved (2014, 4.38)
	private Integer familyReunificationCode;

	// HOPWA Specific Data Standards: Medical Assistance (2014, 4.39)
	private Date hopwaMedicalAssistanceInformationDate
	private Integer hopwaReceivingMedicalAssistanceCode;
	private Integer hopwaNotReceivingMedicalAssistanceReasonCode;
	private Integer hopwaReceivingAdapCode;
	private Integer hopwaNotReceivingAdapCode;

	// RHSP Specific Data Standards: Worst Housing Situation (2014, 4.40)
	private Integer worstHousingSituationCode;

	// VA Specific Data Standards: Percent of AMI (2014, 4.41)
	private Integer householdIncomeAsPercentageOfAmiCode;

	// VA Specific Data Standards: Last Permanent Address (2014, 4.41)
	private String lastStreetAddress;
	private String lastCity;
	private String lastState;
	private String lastZip;
	private Integer lastAddressQualityCode;

	public ClientEnrollmentVO() {
		super();
	}
	public ClientEnrollmentVO(Long clientKey) {
		super();
		this.clientKey = clientKey;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	@Override
	public String toString() {
		return "";
	}
}
