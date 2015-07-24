package org.openhmis.code;

// Codes for Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)

public enum ClientResidenceType {
	FULL (1, "Full DOB reported"),
	PARTIAL (2, "Approximate or Partial DOB reported"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused");
	
	private final Integer code;
	private final String description;

	ClientResidenceType(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	/** Enable Reverse Lookup. */
	public static ClientResidenceType get(int code) { 
		for(ClientResidenceType s : values()) {
			if(s.code == code) return s;
		}
		return null;
	}
}