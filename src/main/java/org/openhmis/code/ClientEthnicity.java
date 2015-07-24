package org.openhmis.code;

// Codes for Universal Data Standard: Ethnicity (2014, 3.5)

public enum ClientEthnicity {
	NON_HISPANIC (104, "Non-Hispanic/Non-Latino"),
	HISPANIC (105, "Hispanic/Latino"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused");
	
	private final Integer code;
	private final String description;

	ClientEthnicity(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	/** Enable Reverse Lookup. */
	public static ClientEthnicity get(int code) { 
		for(ClientEthnicity s : values()) {
			if(s.code == code) return s;
		}
		return null;
	}
}