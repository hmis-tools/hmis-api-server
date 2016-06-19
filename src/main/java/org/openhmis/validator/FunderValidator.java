

public class FunderValidator {

	public FunderValidator() {
	}
	
	public boolean validateFunder(FunderDTO inputDTO) {

		// Universal Data Standard: Funder (2014, 2.6) 
		if(inputDTO.getFunder() == ProjectFundingSource.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.1.5 funder", "funder is set to an unknown code");
		
		return true;
	}
}