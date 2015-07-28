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
	private String personalId;

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
	private Integer clientLocationCoCCode;

	// Universal Data Standard: Length of Time on Street, in an Emergency Shelter, or Safe Haven (2014, 3.17)
	// Collection: Project Entry
	private YesNoReason continuouslyHomelessOneYear;
	private ClientTimesHomelessInPastThreeYears timesHomelessInPastThreeYears;
	private ClientTimesHomelessInPastThreeYears monthsHomelessPastThreeYears;
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
	private ReasonNoServices reasonNoServices;

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
	private Date employedInformationDateEntry;
	private YesNoReason employedEntry;
	private ClientEmploymentType employmentTypeEntry;
	private ClientNotEmployedReason notEmployedReasonEntry;

	// Collection: Project Exit
	private Date employedInformationDateExit;
	private YesNoReason employedExit;
	private ClientEmploymentType employmentTypeExit;
	private ClientNotEmployedReason notEmployedReasonExit;

	// RHY Specific Data Standards: General Health Status (2014, 4.27)
	// Collection: Project Entry
	private ClientHealthStatus generalHealthStatusEntry;

	// Collection: Project Exit
	private ClientHealthStatus generalHealthStatusExit;

	// RHY Specific Data Standards: Dental Health Status (2014, 4.28)
	// Collection: Project Entry
	private ClientHealthStatus dentalHealthStatusEntry;

	// Collection: Project Exit
	private ClientHealthStatus dentalHealthStatusExit;

	// RHY Specific Data Standards: Mental Health Status (2014, 4.29)
	// Collection: Project Entry
	private ClientHealthStatus mentalHealthStatusEntry;

	// Collection: Project Exit
	private ClientHealthStatus mentalHealthStatusExit;

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
