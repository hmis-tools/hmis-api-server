
	// Universal Data Standard: Project Entry Date (2014, 3.11)
	// Collection: Project Exit
	private Date projectExitDate;

	// Universal Data Standard: Destination (2014, 3.12)
	// Collection: Project Exit
	private Integer destinationTypeCode;
	private String otherDestination;

	// Program Specific Data Standards: Housing Assessment Disposition (2014, 4.18)
	// Collection: On Exit
	private Integer assessmentDisposition;
	private String otherDisposition;

	// Program Specific Data Standards: Housing Assessment on Exit (2014, 4.19)
	// Collection: On Exit
	private ClientHousingAssessmentAtExit housingAssessmentAtExitCode;
	private ClientSubsidyInformation subsidyInformation;
	
	// PATH Specific Data Standards: Connection with SOAR (2014, 4.21)
	// Collection: On Exit
	private YesNoReason connectionWithSoarCode;

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

