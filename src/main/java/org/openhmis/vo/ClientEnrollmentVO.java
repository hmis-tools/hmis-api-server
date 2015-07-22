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
	// Collection: Project Entry
	private Integer disablingConditionCode;

	// Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)
	// Collection: Project Entry
	private Integer typeOfResidenceCode;
	private String otherResidence;
	private Integer lengthOfStayInPreviousPlaceCode;

	// Universal Data Standard: Project Entry Date (2014, 3.10)
	// Collection: Project Entry
	private Date projectEntryDate;

	// Universal Data Standard: Project Entry Date (2014, 3.11)
	// Collection: Project Exit
	private Date projectExitDate;

	// Universal Data Standard: Destination (2014, 3.12)
	// Collection: Project Exit
	private Integer destinationTypeCode;
	private String otherDestination;

	// Universal Data Standard: Household ID (2014, 3.14)
	// Collection: Project Entry
	private String householdId;

	// Universal Data Standard: Relationship to Head of Household (2014, 3.15)
	// Collection: Project Entry
	private Integer relationshipToHeadOfHouseholdCode;
	
	// Universal Data Standard: Client Location (2014, 3.16)
	// Collection: Project Entry
	private Date clientLocationInformationDate;
	private Integer clientLocationCoCCode;

	// Universal Data Standard: Length of Time on Street, in an Emergency Shelter, or Safe Haven (2014, 3.17)
	// Collection: Project Entry
	private Integer continuouslyHomelessForOneYearCode;
	private Integer numberOfTimesHomelessInPastThreeYearsCode;
	private Integer numberOfMonthsHomelessInPastThreeYearsCode;
	private Integer numberOfMonthsContinuouslyHomelessImmediatelyPriorToEntry;
	private Integer statusDocumentedCode;

	// Program Specific Data Standards: Housing Status (2014, 4.1)
	// Collection: Project Entry
	private Integer homelessnessStatusCode;

	// Program Specific Data Standards: Income Sources (2014, 4.2)
	// Collection: Project Entry, Project Exit, Annual Assessment, Updates
	// IN ANOTHER OBJECT (ClientEnrollmentIncomeSourceVO.java)

	// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
	// Collection: Project Entry, Project Exit, Annual Assessment, Updates
	// IN ANOTHER OBJECT (ClientEnrollmentNonCashBenefitVO.java)

	// Program Specific Data Standards: Health Insurance (2014, 4.4)
	// Collection: Project Entry, Project Exit, Annual Assessment, Updates
	// IN ANOTHER OBJECT (ClientEnrollmentHealthInsuranceVO.java)

	// Program Specific Data Standards: Physical Disability (2014, 4.5)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentPhysicalDisabilityVO.java)

	// Program Specific Data Standards: Developmental Disability (2014, 4.6)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentDevelopmentalDisabilityVO.java)

	// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentChronicHealthConditionVO.java)

	// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentHivAidsVO.java)

	// Program Specific Data Standards: Mental Health Problem (2014, 4.9)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentMentalHealthProblemVO.java)

	// Program Specific Data Standards: Substance Abuse (2014, 4.10)
	// Collection: Project Entry, Project Exit, Update
	// IN ANOTHER OBJECT (ClientEnrollmentSubstanceAbuseVO.java)

	// Program Specific Data Standards: Domestic Abuse (2014, 4.11)
	// Collection: Project Entry, Update
	// IN ANOTHER OBJECT (ClientEnrollmentDomesticAbuseVO.java)

	// Program Specific Data Standards: Contact (2014, 4.12)
	// Collection: Project Entry, Exit, and Every Contact Point
	// SEPARATE OBJECT (ClientEnrollmentContactVO.java)

	// Program Specific Data Standards: Date of Engagement (2014, 4.13)
	// Collection: Once, whenever the client becomes engaged
	private Date engagementDate;

	// Program Specific Data Standards: Services Provided (2014, 4.14)
	// SEPARATE OBJECT (ClientEnrollmentServiceVO.java)

	// Program Specific Data Standards: Financial Assets Provided (2014, 4.15)
	// SEPARATE OBJECT (ClientEnrollmentFinancialAssistanceVO.java)

	// Program Specific Data Standards: References Provided (2014, 4.16)
	// SEPARATE OBJECT (ClientEnrollmentReferralVO.java)

	// Program Specific Data Standards: Residential Move-in Date (2014, 4.17)
	// Collection: On Entry, keep up to date
	private Date residentialMoveInDate;
	private Integer permanentHousingCode;
	private Date permanentHousingMoveDate;

	// Program Specific Data Standards: Housing Assessment Disposition (2014, 4.18)
	// Collection: On Exit
	private Integer housingAssessmentDispositionCode;
	private String housingAssessmentDispositionOther;

	// Program Specific Data Standards: Housing Assessment on Exit (2014, 4.19)
	// Collection: On Exit
	private Integer housingAssessmentAtExitCode;
	private Integer housingAssessmentAtExitMaintainedSubsidyCode;
	private Integer housingAssessmentAtExitMovedSubsidyCode;
	
	// PATH Specific Data Standards: PATH Status (2014, 4.20)
	// Collection: Once, before exit.
	private Date pathStatusDate;
	private Integer pathEnrollmentCode;
	private Integer pathNoEnrollmentReasonCode;

	// PATH Specific Data Standards: Connection with SOAR (2014, 4.21)
	// Collection: On Exit
	private Integer connectionWithSoarCode;

	// RHY Specific Data Standards: RHY-BCP Status (2014, 4.22)
	// Collection: Once, when determining eligibility
	private Date rhyBcpStatusDate;
	private Integer fysbYouthEnrollmentCode;
	private Integer fysbYouthNoEnrollmentReasonCode;

	// RHY Specific Data Standards: Sexual Orientation (2014, 4.23)
	// Collection: Project Entry
	private Integer sexualOrientationCode;

	// RHY Specific Data Standards: Last Grade Completed (2014, 4.24)
	// Collection: Project Entry
	private Integer lastGradeCompletedCode;

	// RHY Specific Data Standards: School Status (2014, 4.25)
	// Collection: Project Entry
	private Integer schoolStatusCode;

	// RHY Specific Data Standards: Employment Status (2014, 4.26)
	// Collection: Project Entry
	private Date employmentEntryInformationDate;
	private Integer employmentEntryStatusCode;
	private Integer employmentEntryTypeCode;
	private Integer employmentEntryUnemployedReasonCode;

	// Collection: Project Exit
	private Date employmentExitInformationDate;
	private Integer employmentExitStatusCode;
	private Integer employmentExitTypeCode;
	private Integer employmentExitUnemployedReasonCode;

	// RHY Specific Data Standards: General Health Status (2014, 4.27)
	// Collection: Project Entry
	private Integer generalHealthEntryStatusCode;

	// Collection: Project Exit
	private Integer generalHealthExitStatusCode;

	// RHY Specific Data Standards: Dental Health Status (2014, 4.28)
	// Collection: Project Entry
	private Integer dentalHealthEntryStatusCode;

	// Collection: Project Exit
	private Integer dentalHealthExitStatusCode;

	// RHY Specific Data Standards: Mental Health Status (2014, 4.29)
	// Collection: Project Entry
	private Integer mentalHealthEntryStatusCode;

	// Collection: Project Exit
	private Integer mentalHealthExitStatusCode;

	// RHY Specific Data Standards: Pregnancy Status (2014, 4.30)
	// Collection: Project Entry (keep updated)
	private Integer pregnancyStatusCode;
	private Date pregnancyDueDate;

	// RHY Specific Data Standards: Formerly Child Welfare (2014, 4.31)
	// Collection: Project Entry
	private Integer formerlyChildWelfareCode;
	private Integer formerlyChildWelfareYearDurationCode;
	private Integer formerlyChildWelfareMonthDurationCode;

	// RHY Specific Data Standards: Formerly Juvenile Justice (2014, 4.32)
	// Collection: Project Entry
	private Integer formerlyJuvenileJusticeCode;
	private Integer formerlyJuvenileJusticeYearDurationCode;
	private Integer formerlyJuvenileJusticeMonthDurationCode;

	// RHY Specific Data Standards: Young Person's Critical Issues (2014, 4.33)
	// Collection: Project Entry
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
	// Collection: Project Entry
	private Integer referralSourceCode;
	private Integer referralOutreachCount;

	// RHY Specific Data Standards: Commercial Sexual Exploitation (2014, 4.35)
	private Integer sexualExploitationInPastThreeMonthsCode;
	// Collection: Project Entry
	private Integer sexualExploitationInPastThreeMonthsAmountCode;
	private Integer sexualExplotationRequestCode;

	// RHY Specific Data Standards: Transitional Exit Care (2014, 4.36)
	// Collection: Project Exit
	private Integer afterCarePlanAgreementCode;
	private Integer afterCareAdviceCode;
	private Integer afterCarePlacementCode;
	private Integer afterCareShelterCode;
	private Integer afterCareFollowupServicesCode;
	private Integer afterCareFollowupMeetingCode;
	private Integer afterCareInformationPackageCode;
	private Integer afterCareOtherCode;

	// RHY Specific Data Standards: Project Completion Status (2014, 4.37)
	// Collection: Project Exit
	private Integer rhyCompletionStatusCode;
	private Integer rhyEarlyExitReasonCode;
	private Integer rhyExpulsionReasonCode;

	// RHY Specific Data Standards: Family Reunification Achieved (2014, 4.38)
	// Collection: Project Exit
	private Integer familyReunificationCode;

	// HOPWA Specific Data Standards: Medical Assistance (2014, 4.39)
	// Collection: Project Entry, exit, update.
	// OTHER OBJECT: ClientEnrollmentHopwaMedicalAssistanceVO.java

	// RHSP Specific Data Standards: Worst Housing Situation (2014, 4.40)
	// Collection: Project Entry
	private Integer worstHousingSituationCode;

	// VA Specific Data Standards: Percent of AMI (2014, 4.42)
	// Collection: Project Entry
	private Integer householdIncomeAsPercentageOfAmiCode;

	// VA Specific Data Standards: Last Permanent Address (2014, 4.43)
	// Collection: Project Entry
	private String lastStreetAddress;
	private String lastCity;
	private String lastState;
	private String lastZip;
	private Integer lastAddressQualityCode;

	public ClientEnrollmentVO() {
		super();
	}
	public ClientEnrollmentVO(String clientId) {
		super();
		this.clientId = clientId;
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
