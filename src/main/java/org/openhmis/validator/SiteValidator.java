
	
public class SiteValidator {

	public SiteValidator() {
	}

	public boolean validateSite(SiteDTO inputDTO) {
		// Universal Data Standard: Site (2014, 2.8)

		if(inputDTO.getPrincipalSite() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.8.1 (PrincipalSite)", "principalSite is set to an unknown code");

		Pattern validGeocode = Pattern.compile("^[0-9]{6}$");
		Matcher geocodeMatcher = validGeocode.matcher(inputDTO.getGeocode());
		if(inputDTO.getGeocode() != null
		&& !geocodeMatcher.find())
			throw new InvalidParameterException("HUD 2.8.A (Geocode)", "geocode is limited to six digits ^[0-9]{6}$");

		if(inputDTO.getAddress().length() > 100)
			throw new InvalidParameterException("HUD 2.8.2 (Address)", "address is limited to 100 characters");
		
		if(inputDTO.getCity().length() > 50)
			throw new InvalidParameterException("HUD 2.8.3 (City)", "city is limited to 50 characters");

		Pattern validState = Pattern.compile("^[a-zA-Z]{2}$");
		Matcher stateMatcher = validState.matcher(inputDTO.getState());
		if(inputDTO.getState() != null
		&& !stateMatcher.find())
			throw new InvalidParameterException("HUD 2.8.4 (State)", "state is limited to 2 letters ^[a-zA-Z]{2}$");

		Pattern validZip = Pattern.compile("^[0-9]{5}$");
		Matcher zipMatcher = validZip.matcher(inputDTO.getZip());
		if(inputDTO.getZip() != null
		&& !zipMatcher.find())
			throw new InvalidParameterException("HUD 2.8.5 (Zip)", "zip is limited to 5 digits ^[0-9]{5}$");

		return true;
	}
}