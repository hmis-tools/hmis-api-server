package org.openhmis.code;

// Codes for Universal Data Standard: Date of Birth (2014, 3.3)

public enum ClientDateOfBirthType {
	FULL (1, "Full DOB reported"),
	PARTIAL (2, "Approximate or Partial DOB reported"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused");
	
	protected final Integer code;
	protected final String description;

	ClientDateOfBirthType(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	/** Enable Reverse Lookup. */
	public static ClientDateOfBirthType get(int code) { 
		for(ClientDateOfBirthType s : values()) {
			if(s.code == code) return s;
		}
		return null;
	}
}