package org.openhmis.code;

// Codes for Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)

public enum ClientResidenceLengthOfStay {
	ONE_DAY (10, "One day or less"),
	ONE_WEEK (11, "Two days to one week"),
	ONE_MONTH (2, "More than one week, but less than one month"),
	THREE_MONTHS (3, "One to three months"),
	ONE_YEAR (4, "More than three months, but less than one year"),
	MULTI_YEAR (5, "One year or longer"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused");
	
	private final Integer code;
	private final String description;

	ClientResidenceLengthOfStay(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	/** Enable Reverse Lookup. */
	public static ClientResidenceLengthOfStay get(int code) { 
		for(ClientResidenceLengthOfStay s : values()) {
			if(s.code == code) return s;
		}
		return null;
	}
}
