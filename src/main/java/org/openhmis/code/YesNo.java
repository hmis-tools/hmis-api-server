package org.openhmis.code;

// YesNo are used in several data standard fields:
//  - Veteran Status (2014, 3.7)
//  - Disabling Condition (2014, 3.8)

public enum YesNo {
	YES (1, "Full DOB reported"),
	NO (2, "Approximate or Partial DOB reported"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused");
	
	private final Integer code;
	private final String description;

	YesNo(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	/** Enable Reverse Lookup. */
	public static YesNo get(int code) { 
		for(YesNo s : values()) {
			if(s.code == code) return s;
		}
		return null;
	}
}