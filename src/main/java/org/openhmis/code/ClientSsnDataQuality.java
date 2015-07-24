package org.openhmis.code;

// Codes for Universal Data Standard: Social Security Number (2014, 3.2)

public enum ClientSsnDataQuality {
	FULL (1, "Full SSN reported"),
	PARTIAL (2, "Approximate or partial SSN reported"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused");
	
	private final Integer code;
	private final String description;

	ClientSsnDataQuality(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	/** Enable Reverse Lookup. */
	public static ClientSsnDataQuality get(int code) { 
		for(ClientSsnDataQuality s : values()) {
			if(s.code == code) return s;
		}
		return null;
	}
}