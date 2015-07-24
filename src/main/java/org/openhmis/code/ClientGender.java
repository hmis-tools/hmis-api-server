package org.openhmis.code;

// Codes for Universal Data Standard: Gender (2014, 3.6)

public enum ClientGender {
	MALE (1, "Male"),
	FEMALE (2, "Female"),
	TRANSGENDER_MALE_TO_FEMALE (3, "Transgender Male to Female"),
	TRANSGENDER_FEMALE_TO_MALE (4, "Transgender Female to Male"),
	OTHER (5, "Other"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused");
	
	private final Integer code;
	private final String description;

	ClientGender(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	/** Enable Reverse Lookup. */
	public static ClientGender get(int code) { 
		for(ClientGender s : values()) {
			if(s.code == code) return s;
		}
		return null;
	}
}