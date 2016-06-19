package org.openhmis.generator;

public class ExitGenerator {

	public ExitGenerator() {
	}

	public ExitDTO generateExitDTO(TmpExit tmpExit) {
		ExitDTO exitDTO = new ExitDTO();

		exitDTO.setExitId(tmpExit.getExitId().toString());
		exitDTO.setEnrollmentId(tmpExit.getEnrollmentId().toString());

		// Universal Data Standard: Project Entry Date (2014, 3.11)
		// Collection: Project Exit
		exitDTO.setProjectExitDate(tmpExit.getProjectExitDate());
		
		// Universal Data Standard: Destination (2014, 3.12)
		// Collection: Project Exit
		exitDTO.setDestinationTypeCode(ClientDestination.valueByCode(tmpExit.getDestinationTypeCode()));
		exitDTO.setOtherDestination(tmpExit.getOtherDestination());
		
		// Program Specific Data Standards: Housing Assessment Disposition (2014, 4.18)
		// Collection: Project Exit
		exitDTO.setAssessmentDisposition(ClientHousingAssessmentDisposition.valueByCode(tmpExit.getAssessmentDisposition()));
		exitDTO.setOtherDisposition(tmpExit.getOtherDisposition());
		
		// Program Specific Data Standards: Housing Assessment on Exit (2014, 4.19)
		// Collection: Project Exit
		exitDTO.setHousingAssessment(ClientHousingAssessmentAtExit.valueByCode(tmpExit.getHousingAssessment()));
		exitDTO.setSubsidyInformation(ClientSubsidyInformation.valueByCode(tmpExit.getSubsidyInformation()));
		
		// PATH Specific Data Standards: Connection with SOAR (2014, 4.21)
		// Collection: Project Exit
		exitDTO.setConnectionWithSoar(YesNoReason.valueByCode(tmpExit.getConnectionWithSoar()));
		
		// RHY Specific Data Standards: Employment Status (2014, 4.26)
		// Collection: Project Exit
		exitDTO.setEmployedInformationDate(tmpExit.getEmployedInformationDate());
		exitDTO.setEmployed(YesNoReason.valueByCode(tmpExit.getEmployed()));
		exitDTO.setEmploymentType(ClientEmploymentType.valueByCode(tmpExit.getEmploymentType()));
		exitDTO.setNotEmployedReason(ClientNotEmployedReason.valueByCode(tmpExit.getNotEmployedReason()));
		
		// RHY Specific Data Standards: General Health Status (2014, 4.27)
		// Collection: Project Exit
		exitDTO.setGeneralHealthStatus(ClientHealthStatus.valueByCode(tmpExit.getGeneralHealthStatus()));
		
		// RHY Specific Data Standards: Dental Health Status (2014, 4.28)
		// Collection: Project Exit
		exitDTO.setDentalHealthStatus(ClientHealthStatus.valueByCode(tmpExit.getDentalHealthStatus()));
		
		// RHY Specific Data Standards: Mental Health Status (2014, 4.29)
		// Collection: Project Exit
		exitDTO.setMentalHealthStatus(ClientHealthStatus.valueByCode(tmpExit.getMentalHealthStatus()));
		
		// RHY Specific Data Standards: Transitional Exit Care (2014, 4.36)
		// Collection: Project Exit
		exitDTO.setWrittenAftercarePlan(ClientExitAction.valueByCode(tmpExit.getWrittenAftercarePlan()));
		exitDTO.setAssistanceMainstreamBenefits(ClientExitAction.valueByCode(tmpExit.getAssistanceMainstreamBenefits()));
		exitDTO.setPermanentHousingPlacement(ClientExitAction.valueByCode(tmpExit.getPermanentHousingPlacement()));
		exitDTO.setTemporaryShelterPlacement(ClientExitAction.valueByCode(tmpExit.getTemporaryShelterPlacement()));
		exitDTO.setExitCounciling(ClientExitAction.valueByCode(tmpExit.getExitCounciling()));
		exitDTO.setFurtherFollowupServices(ClientExitAction.valueByCode(tmpExit.getFurtherFollowupServices()));
		exitDTO.setScheduledFollowupContacts(ClientExitAction.valueByCode(tmpExit.getScheduledFollowupContacts()));
		exitDTO.setResourcePackage(ClientExitAction.valueByCode(tmpExit.getResourcePackage()));
		exitDTO.setOtherAftercarePlanOrAction(ClientExitAction.valueByCode(tmpExit.getOtherAftercarePlanOrAction()));
		
		// RHY Specific Data Standards: Project Completion Status (2014, 4.37)
		// Collection: Project Exit
		exitDTO.setProjectCompletionStatus(ClientProjectCompletionStatus.valueByCode(tmpExit.getProjectCompletionStatus()));
		exitDTO.setEarlyExitReason(ClientEarlyExitReason.valueByCode(tmpExit.getEarlyExitReason()));
		exitDTO.setEarlyExpulsionReason(ClientExpelledReason.valueByCode(tmpExit.getEarlyExpulsionReason()));
		
		// RHY Specific Data Standards: Family Reunification Achieved (2014, 4.38)
		// Collection: Project Exit
		exitDTO.setFamilyReunificationCode(YesNoReason.valueByCode(tmpExit.getFamilyReunificationCode()));

		// Export Standard Fields
		exitDTO.setDateCreated(tmpExit.getDateCreated());
		exitDTO.setDateUpdated(tmpExit.getDateUpdated());
		
		return exitDTO;
	}
	
	public TmpExit generateTmpExit(ExitDTO inputDTO) {
		TmpExit tmpExit = new TmpExit();
		
		tmpExit.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Universal Data Standard: Project Entry Date (2014, 3.11)
		// Collection: Project Exit
		tmpExit.setProjectExitDate(inputDTO.getProjectExitDate());
		
		// Universal Data Standard: Destination (2014, 3.12)
		// Collection: Project Exit
		tmpExit.setDestinationTypeCode(inputDTO.getDestinationTypeCode().getCode());
		tmpExit.setOtherDestination(inputDTO.getOtherDestination());
		
		// Program Specific Data Standards: Housing Assessment Disposition (2014, 4.18)
		// Collection: Project Exit
		tmpExit.setAssessmentDisposition(inputDTO.getAssessmentDisposition().getCode());
		tmpExit.setOtherDisposition(inputDTO.getOtherDisposition());
		
		// Program Specific Data Standards: Housing Assessment on Exit (2014, 4.19)
		// Collection: Project Exit
		tmpExit.setHousingAssessment(inputDTO.getHousingAssessment().getCode());
		tmpExit.setSubsidyInformation(inputDTO.getSubsidyInformation().getCode());
		
		// PATH Specific Data Standards: Connection with SOAR (2014, 4.21)
		// Collection: Project Exit
		tmpExit.setConnectionWithSoar(inputDTO.getConnectionWithSoar().getCode());
		
		// RHY Specific Data Standards: Employment Status (2014, 4.26)
		// Collection: Project Exit
		tmpExit.setEmployedInformationDate(inputDTO.getEmployedInformationDate());
		tmpExit.setEmployed(inputDTO.getEmployed().getCode());
		tmpExit.setEmploymentType(inputDTO.getEmploymentType().getCode());
		tmpExit.setNotEmployedReason(inputDTO.getNotEmployedReason().getCode());
		
		// RHY Specific Data Standards: General Health Status (2014, 4.27)
		// Collection: Project Exit
		tmpExit.setGeneralHealthStatus(inputDTO.getGeneralHealthStatus().getCode());
		
		// RHY Specific Data Standards: Dental Health Status (2014, 4.28)
		// Collection: Project Exit
		tmpExit.setDentalHealthStatus(inputDTO.getDentalHealthStatus().getCode());
		
		// RHY Specific Data Standards: Mental Health Status (2014, 4.29)
		// Collection: Project Exit
		tmpExit.setMentalHealthStatus(inputDTO.getMentalHealthStatus().getCode());
		
		// RHY Specific Data Standards: Transitional Exit Care (2014, 4.36)
		// Collection: Project Exit
		tmpExit.setWrittenAftercarePlan(inputDTO.getWrittenAftercarePlan().getCode());
		tmpExit.setAssistanceMainstreamBenefits(inputDTO.getAssistanceMainstreamBenefits().getCode());
		tmpExit.setPermanentHousingPlacement(inputDTO.getPermanentHousingPlacement().getCode());
		tmpExit.setTemporaryShelterPlacement(inputDTO.getTemporaryShelterPlacement().getCode());
		tmpExit.setExitCounciling(inputDTO.getExitCounciling().getCode());
		tmpExit.setFurtherFollowupServices(inputDTO.getFurtherFollowupServices().getCode());
		tmpExit.setScheduledFollowupContacts(inputDTO.getScheduledFollowupContacts().getCode());
		tmpExit.setResourcePackage(inputDTO.getResourcePackage().getCode());
		tmpExit.setOtherAftercarePlanOrAction(inputDTO.getOtherAftercarePlanOrAction().getCode());
		
		// RHY Specific Data Standards: Project Completion Status (2014, 4.37)
		// Collection: Project Exit
		tmpExit.setProjectCompletionStatus(inputDTO.getProjectCompletionStatus().getCode());
		tmpExit.setEarlyExitReason(inputDTO.getEarlyExitReason().getCode());
		tmpExit.setEarlyExpulsionReason(inputDTO.getEarlyExpulsionReason().getCode());
		
		// RHY Specific Data Standards: Family Reunification Achieved (2014, 4.38)
		// Collection: Project Exit
		tmpExit.setFamilyReunificationCode(inputDTO.getFamilyReunificationCode().getCode());

		// Export Standard Fields
		tmpExit.setDateCreated(inputDTO.getDateCreated());
		tmpExit.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpExit;
	}

}