

public class ExitValidator {

	public ExitValidator() {
	}

	public boolean validateExit(ExitDTO inputDTO) {
		
		// Universal Data Standard: Project Entry Date (2014, 3.11)
		// TODO: Check for undocumented requirements
		
		// Universal Data Standard: Destination (2014, 3.12)
		// Collection: Project Exit
		if(inputDTO.getDestinationTypeCode() == ClientDestination.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.12.1 destinationType", "destinationType is set to an unknown code");

		return true;
	}
}