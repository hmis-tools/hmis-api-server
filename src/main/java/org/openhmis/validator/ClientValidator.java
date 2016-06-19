package org.openhmis.generator;


public class ClientValidator {

	public ClientValidator() {
	}

	public boolean validateClient(ClientDTO inputDTO) {
		// Universal Data Standard: Name (2014, 3.1)
		// 3.1.5 Name Data Quality
		if(inputDTO.getNameDataQuality() == ClientNameDataQuality.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.1.5 nameDataQuality", "nameDataQuality is set to an unknown code");

		// Universal Data Standard: SSN (2014, 3.2)
		// 3.2.1 SSN
		// The letter x is the only permissible nonnumeric character and should be used to indicate the position of omitted digits
		// ^[0-9xX]{9}$
		Pattern validSsn = Pattern.compile("^[0-9xX]{9}$");
                // need to check whether SSN is in input first
                String ssn = inputDTO.getSsn();
                if (ssn != null) {
                    Matcher ssnMatcher = validSsn.matcher(ssn);
                    if(ssn != null
                       && !ssnMatcher.find())
			throw new InvalidParameterException("HUD 3.2.1 (SSN)", "SSN must match the pattern ^[0-9xX]{9}$");
                }
		// 3.2.2 SSN Data Quality
		if(inputDTO.getSsnDataQuality() == ClientSsnDataQuality.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.2.2 ssnDataQuality", "ssnDataQuality is set to an unknown code");
		
		// Universal Data Standard: Date of Birth  (2014, 3.3)
		
		// 3.3.1 DOB
		// Must be before today
		Date now = new Date();
		if(inputDTO.getDob() != null
		&& now.compareTo(inputDTO.getDob()) < 0)
			throw new InvalidParameterException("HUD 3.3.1 (DOB)", "Date of birth must be in the past");

		// 3.3.2 DOB Data Quality
		if(inputDTO.getDobDataQuality() == ClientDobDataQuality.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.3.2 dobDataQuality", "dobDataQuality is set to an unknown code");

		// Universal Data Standard: Race (2014, 3.4)
		// 3.4.1 Asian
		if(inputDTO.getAsian() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 Asian", "Asian is set to an unknown code");

		// 3.4.1 BlackAfAmerican
		if(inputDTO.getBlackAfAmerican() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 BlackAfAmerican", "BlackAfAmerican is set to an unknown code");

		// 3.4.1 NativeHIOtherPacific
		if(inputDTO.getNativeHIOtherPacific() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 NativeHIOtherPacific", "NativeHIOtherPacific is set to an unknown code");

		// 3.4.1 AmIndAKNative
		if(inputDTO.getAmIndAKNative() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 AmIndAKNative", "AmIndAKNative is set to an unknown code");

		// 3.4.1 AmIndAKNative
		if(inputDTO.getWhite() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 White", "White is set to an unknown code");

		// 3.4.1 RaceNone
		// Non-null only if all other Race fields = 0 or 99
		if((inputDTO.getAsian() == YesNo.YES
		 || inputDTO.getBlackAfAmerican() == YesNo.YES
		 || inputDTO.getNativeHIOtherPacific() == YesNo.YES
		 || inputDTO.getAmIndAKNative() == YesNo.YES
		 || inputDTO.getWhite() == YesNo.YES)
		&& inputDTO.getRaceNone() != null)
			throw new InvalidParameterException("HUD 3.4.1 RaceNone", "RaceNone can be non-null only if all other Race fields = 0 or 99");

		if(inputDTO.getRaceNone() == None.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.4.1 RaceNone", "RaceNone is set to an unknown code");
		
		// Universal Data Standard: Ethnicity (2014, 3.5)
		if(inputDTO.getEthnicity() == ClientEthnicity.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.5 Ethnicity", "Ethnicity is set to an unknown code");
		
		// Universal Data Standard: Gender (2014, 3.6)
		if(inputDTO.getGender() == ClientGender.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.6 Ethnicity", "Gender is set to an unknown code");

		// Universal Data Standard: Veteran Status (2014, 3.7)
		if(inputDTO.getVeteranStatus() == YesNoReason.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.7 Veteran Status", "Veteran Status is set to an unknown code");
		
		// VA Specific Data Standards: Veteran's Information (2014, 4.41)
		// TODO: validate 4.41 fields
		
		return true;
	}
}