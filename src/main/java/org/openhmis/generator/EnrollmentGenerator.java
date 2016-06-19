package org.openhmis.generator;

public class EnrollmentGenerator {

	public EnrollmentGenerator() {
	}

	public EnrollmentDTO generateEnrollmentDTO(TmpEnrollment tmpEnrollment) {
		EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
                ChronicHealthConditionSearchDTO chcSearchDTO = new ChronicHealthConditionSearchDTO();
                ContactSearchDTO contactSearchDTO = new ContactSearchDTO();
                DevelopmentalDisabilitySearchDTO devDisSearchDTO = new DevelopmentalDisabilitySearchDTO();
                DomesticAbuseSearchDTO domesticAbuseSearchDTO = new DomesticAbuseSearchDTO();
                FinancialAssistanceSearchDTO financialAssistanceSearchDTO = new FinancialAssistanceSearchDTO();
                HealthInsuranceSearchDTO healthInsuranceSearchDTO = new HealthInsuranceSearchDTO();
                HivAidsStatusSearchDTO hivAidsStatusSearchDTO = new HivAidsStatusSearchDTO();
                IncomeSourceSearchDTO incomeSourceSearchDTO = new IncomeSourceSearchDTO();
                MedicalAssistanceSearchDTO medicalAssistanceSearchDTO = new MedicalAssistanceSearchDTO();
                NonCashBenefitSearchDTO nonCashBenefitSearchDTO = new NonCashBenefitSearchDTO();
                PhysicalDisabilitySearchDTO physicalDisabilitySearchDTO = new PhysicalDisabilitySearchDTO();
                ReferralSearchDTO referralSearchDTO = new ReferralSearchDTO();
                ServiceSearchDTO serviceSearchDTO = new ServiceSearchDTO();
                SubstanceAbuseSearchDTO substanceAbuseSearchDTO = new SubstanceAbuseSearchDTO();

                
		String enrollmentId = tmpEnrollment.getEnrollmentId().toString();
		enrollmentDTO.setEnrollmentId(enrollmentId);
                chcSearchDTO.setEnrollmentId(enrollmentId);
                contactSearchDTO.setEnrollmentId(enrollmentId);
                devDisSearchDTO.setEnrollmentId(enrollmentId);
                domesticAbuseSearchDTO.setEnrollmentId(enrollmentId);
                financialAssistanceSearchDTO.setEnrollmentId(enrollmentId);
                healthInsuranceSearchDTO.setEnrollmentId(enrollmentId);
                hivAidsStatusSearchDTO.setEnrollmentId(enrollmentId);
                incomeSourceSearchDTO.setEnrollmentId(enrollmentId);
                medicalAssistanceSearchDTO.setEnrollmentId(enrollmentId);
                nonCashBenefitSearchDTO.setEnrollmentId(enrollmentId);
                physicalDisabilitySearchDTO.setEnrollmentId(enrollmentId);
                referralSearchDTO.setEnrollmentId(enrollmentId);
                serviceSearchDTO.setEnrollmentId(enrollmentId);
                substanceAbuseSearchDTO.setEnrollmentId(enrollmentId);

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
		enrollmentDTO.setIncomeSources(IncomeSourceManager.getIncomeSources(incomeSourceSearchDTO));

		// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
		enrollmentDTO.setNonCashBenefits(NonCashBenefitManager.getNonCashBenefits(nonCashBenefitSearchDTO));

		// Program Specific Data Standards: Health Insurance (2014, 4.4)
		enrollmentDTO.setHealthInsurances(HealthInsuranceManager.getHealthInsurances(healthInsuranceSearchDTO));

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		enrollmentDTO.setPhysicalDisabilities(PhysicalDisabilityManager.getPhysicalDisabilities(physicalDisabilitySearchDTO));

		// Program Specific Data Standards: Developmental Disability (2014, 4.6)
		enrollmentDTO.setDevelopmentalDisabilities(DevelopmentalDisabilityManager.getDevelopmentalDisabilities(devDisSearchDTO));
		
		// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
		enrollmentDTO.setChronicHealthConditions(ChronicHealthConditionManager.getChronicHealthConditions(chcSearchDTO));

		// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
		enrollmentDTO.setHivAidsStatuses(HivAidsStatusManager.getHivAidsStatuses(hivAidsStatusSearchDTO));

		// Program Specific Data Standards: Mental Health Problem (2014, 4.9)
		enrollmentDTO.setMentalHealthProblems(MentalHealthProblemManager.getMentalHealthProblemsByEnrollmentId(enrollmentId));

		// Program Specific Data Standards: Substance Abuse (2014, 4.10)
		enrollmentDTO.setSubstanceAbuses(SubstanceAbuseManager.getSubstanceAbuses(substanceAbuseSearchDTO));

		// Program Specific Data Standards: Domestic Abuse (2014, 4.11)
		enrollmentDTO.setDomesticAbuses(DomesticAbuseManager.getDomesticAbuses(domesticAbuseSearchDTO));

		// Program Specific Data Standards: Contact (2014, 4.12)
		enrollmentDTO.setContacts(ContactManager.getContacts(contactSearchDTO));

		// Program Specific Data Standards: Date of Engagement (2014, 4.13)
		enrollmentDTO.setDateOfEngagement(tmpEnrollment.getDateOfEngagement());

		// Program Specific Data Standards: Services Provided (2014, 4.14)
		enrollmentDTO.setServices(ServiceManager.getServices(serviceSearchDTO));

		// Program Specific Data Standards: Financial Assets Provided (2014, 4.15)
		enrollmentDTO.setFinancialAssistances(FinancialAssistanceManager.getFinancialAssistances(financialAssistanceSearchDTO));

		// Program Specific Data Standards: References Provided (2014, 4.16)
		enrollmentDTO.setReferrals(ReferralManager.getReferrals(referralSearchDTO));

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
		enrollmentDTO.setMedicalAssistances(MedicalAssistanceManager.getMedicalAssistances(medicalAssistanceSearchDTO));

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
	
	public TmpEnrollment generateTmpEnrollment(EnrollmentDTO enrollmentDTO) {
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