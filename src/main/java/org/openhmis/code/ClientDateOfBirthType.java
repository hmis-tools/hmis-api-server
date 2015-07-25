package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonValue;

// Codes for Universal Data Standard: Date of Birth (2014, 3.3.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

public enum ClientDateOfBirthType implements BaseCode {
	FULL (1, "Full DOB reported"),
	PARTIAL (2, "Approximate or Partial DOB reported"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	protected final Integer code;
	protected final String description;

	ClientDateOfBirthType(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	@JsonValue
    public Integer getCode() {
        return code;
    }
	@JsonValue
    public String getDescription() {
        return description;
    }
}