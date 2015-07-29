package org.openhmis.vo;

import java.util.Date;

import org.openhmis.code.ClientDestination;
import org.openhmis.code.ClientEarlyExitReason;
import org.openhmis.code.ClientEmploymentType;
import org.openhmis.code.ClientExitAction;
import org.openhmis.code.ClientExpelledReason;
import org.openhmis.code.ClientHealthStatus;
import org.openhmis.code.ClientHousingAssessmentAtExit;
import org.openhmis.code.ClientHousingAssessmentDisposition;
import org.openhmis.code.ClientNotEmployedReason;
import org.openhmis.code.ClientProjectCompletionStatus;
import org.openhmis.code.ClientSubsidyInformation;
import org.openhmis.code.YesNoReason;

public class ClientExitVO {
	
	// Universal Data Standard: Project Entry Date (2014, 3.11)
	// Collection: Project Exit
	private Date projectExitDate;

	// Universal Data Standard: Destination (2014, 3.12)
	// Collection: Project Exit
	private ClientDestination destinationTypeCode;
	private String otherDestination;

	// Program Specific Data Standards: Housing Assessment Disposition (2014, 4.18)
	// Collection: Project Exit
	private ClientHousingAssessmentDisposition assessmentDisposition;
	private String otherDisposition;

	// Program Specific Data Standards: Housing Assessment on Exit (2014, 4.19)
	// Collection: Project Exit
	private ClientHousingAssessmentAtExit housingAssessment;
	private ClientSubsidyInformation subsidyInformation;
	
	// PATH Specific Data Standards: Connection with SOAR (2014, 4.21)
	// Collection: Project Exit
	private YesNoReason connectionWithSoar;
	
	// RHY Specific Data Standards: Employment Status (2014, 4.26)
	// Collection: Project Exit
	private Date employedInformationDate;
	private YesNoReason employed;
	private ClientEmploymentType employmentType;
	private ClientNotEmployedReason notEmployedReason;
	
	// RHY Specific Data Standards: General Health Status (2014, 4.27)
	// Collection: Project Exit
	private ClientHealthStatus generalHealthStatus;

	
	// RHY Specific Data Standards: Dental Health Status (2014, 4.28)
	// Collection: Project Exit
	private ClientHealthStatus dentalHealthStatus;

	// RHY Specific Data Standards: Mental Health Status (2014, 4.29)
	// Collection: Project Exit
	private ClientHealthStatus mentalHealthStatus;
	
	// RHY Specific Data Standards: Transitional Exit Care (2014, 4.36)
	// Collection: Project Exit
	private ClientExitAction writtenAftercarePlan;
	private ClientExitAction assistanceMainstreamBenefits;
	private ClientExitAction permanentHousingPlacement;
	private ClientExitAction temporaryShelterPlacement;
	private ClientExitAction exitCounciling;
	private ClientExitAction furtherFollowupServices;
	private ClientExitAction scheduledFollowupContacts;
	private ClientExitAction resourcePackage;
	private ClientExitAction otherAftercarePlanOrAction;

	// RHY Specific Data Standards: Project Completion Status (2014, 4.37)
	// Collection: Project Exit
	private ClientProjectCompletionStatus projectCompletionStatus;
	private ClientEarlyExitReason earlyExitReason;
	private ClientExpelledReason earlyExpulsionReason;

	// RHY Specific Data Standards: Family Reunification Achieved (2014, 4.38)
	// Collection: Project Exit
	private YesNoReason familyReunificationCode;

	public ClientExitVO() {}
}