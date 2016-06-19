
public class EnrollmentValidator {

	public EnrollmentValidator() {
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
}