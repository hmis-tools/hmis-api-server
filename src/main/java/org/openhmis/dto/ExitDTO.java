package org.openhmis.dto;

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

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExitDTO {
	
	private String exitId;
	private String enrollmentId;
	
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

	public ExitDTO() {}

	@JsonProperty
	public String getExitId() {
		return exitId;
	}

	@JsonProperty
	public void setExitId(String exitId) {
		this.exitId = exitId;
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
	public Date getProjectExitDate() {
		return projectExitDate;
	}

	@JsonProperty
	public void setProjectExitDate(Date projectExitDate) {
		this.projectExitDate = projectExitDate;
	}

	@JsonProperty
	public ClientDestination getDestinationTypeCode() {
		return destinationTypeCode;
	}

	@JsonProperty
	public void setDestinationTypeCode(ClientDestination destinationTypeCode) {
		this.destinationTypeCode = destinationTypeCode;
	}

	@JsonProperty
	public String getOtherDestination() {
		return otherDestination;
	}

	@JsonProperty
	public void setOtherDestination(String otherDestination) {
		this.otherDestination = otherDestination;
	}

	@JsonProperty
	public ClientHousingAssessmentDisposition getAssessmentDisposition() {
		return assessmentDisposition;
	}

	@JsonProperty
	public void setAssessmentDisposition(
			ClientHousingAssessmentDisposition assessmentDisposition) {
		this.assessmentDisposition = assessmentDisposition;
	}

	@JsonProperty
	public String getOtherDisposition() {
		return otherDisposition;
	}

	@JsonProperty
	public void setOtherDisposition(String otherDisposition) {
		this.otherDisposition = otherDisposition;
	}

	@JsonProperty
	public ClientHousingAssessmentAtExit getHousingAssessment() {
		return housingAssessment;
	}

	@JsonProperty
	public void setHousingAssessment(ClientHousingAssessmentAtExit housingAssessment) {
		this.housingAssessment = housingAssessment;
	}

	@JsonProperty
	public ClientSubsidyInformation getSubsidyInformation() {
		return subsidyInformation;
	}

	@JsonProperty
	public void setSubsidyInformation(ClientSubsidyInformation subsidyInformation) {
		this.subsidyInformation = subsidyInformation;
	}

	@JsonProperty
	public YesNoReason getConnectionWithSoar() {
		return connectionWithSoar;
	}

	@JsonProperty
	public void setConnectionWithSoar(YesNoReason connectionWithSoar) {
		this.connectionWithSoar = connectionWithSoar;
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
	public ClientExitAction getWrittenAftercarePlan() {
		return writtenAftercarePlan;
	}

	@JsonProperty
	public void setWrittenAftercarePlan(ClientExitAction writtenAftercarePlan) {
		this.writtenAftercarePlan = writtenAftercarePlan;
	}

	@JsonProperty
	public ClientExitAction getAssistanceMainstreamBenefits() {
		return assistanceMainstreamBenefits;
	}

	@JsonProperty
	public void setAssistanceMainstreamBenefits(
			ClientExitAction assistanceMainstreamBenefits) {
		this.assistanceMainstreamBenefits = assistanceMainstreamBenefits;
	}

	@JsonProperty
	public ClientExitAction getPermanentHousingPlacement() {
		return permanentHousingPlacement;
	}

	@JsonProperty
	public void setPermanentHousingPlacement(
			ClientExitAction permanentHousingPlacement) {
		this.permanentHousingPlacement = permanentHousingPlacement;
	}

	@JsonProperty
	public ClientExitAction getTemporaryShelterPlacement() {
		return temporaryShelterPlacement;
	}

	@JsonProperty
	public void setTemporaryShelterPlacement(
			ClientExitAction temporaryShelterPlacement) {
		this.temporaryShelterPlacement = temporaryShelterPlacement;
	}

	@JsonProperty
	public ClientExitAction getExitCounciling() {
		return exitCounciling;
	}

	@JsonProperty
	public void setExitCounciling(ClientExitAction exitCounciling) {
		this.exitCounciling = exitCounciling;
	}

	@JsonProperty
	public ClientExitAction getFurtherFollowupServices() {
		return furtherFollowupServices;
	}

	@JsonProperty
	public void setFurtherFollowupServices(ClientExitAction furtherFollowupServices) {
		this.furtherFollowupServices = furtherFollowupServices;
	}

	@JsonProperty
	public ClientExitAction getScheduledFollowupContacts() {
		return scheduledFollowupContacts;
	}

	@JsonProperty
	public void setScheduledFollowupContacts(
			ClientExitAction scheduledFollowupContacts) {
		this.scheduledFollowupContacts = scheduledFollowupContacts;
	}

	@JsonProperty
	public ClientExitAction getResourcePackage() {
		return resourcePackage;
	}

	@JsonProperty
	public void setResourcePackage(ClientExitAction resourcePackage) {
		this.resourcePackage = resourcePackage;
	}

	@JsonProperty
	public ClientExitAction getOtherAftercarePlanOrAction() {
		return otherAftercarePlanOrAction;
	}

	@JsonProperty
	public void setOtherAftercarePlanOrAction(
			ClientExitAction otherAftercarePlanOrAction) {
		this.otherAftercarePlanOrAction = otherAftercarePlanOrAction;
	}

	@JsonProperty
	public ClientProjectCompletionStatus getProjectCompletionStatus() {
		return projectCompletionStatus;
	}

	@JsonProperty
	public void setProjectCompletionStatus(
			ClientProjectCompletionStatus projectCompletionStatus) {
		this.projectCompletionStatus = projectCompletionStatus;
	}

	@JsonProperty
	public ClientEarlyExitReason getEarlyExitReason() {
		return earlyExitReason;
	}

	@JsonProperty
	public void setEarlyExitReason(ClientEarlyExitReason earlyExitReason) {
		this.earlyExitReason = earlyExitReason;
	}

	@JsonProperty
	public ClientExpelledReason getEarlyExpulsionReason() {
		return earlyExpulsionReason;
	}

	@JsonProperty
	public void setEarlyExpulsionReason(ClientExpelledReason earlyExpulsionReason) {
		this.earlyExpulsionReason = earlyExpulsionReason;
	}

	@JsonProperty
	public YesNoReason getFamilyReunificationCode() {
		return familyReunificationCode;
	}

	@JsonProperty
	public void setFamilyReunificationCode(YesNoReason familyReunificationCode) {
		this.familyReunificationCode = familyReunificationCode;
	}
}