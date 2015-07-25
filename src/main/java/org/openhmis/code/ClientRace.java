package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonValue;

// Codes for Universal Data Standard: Race (2014, 3.4)

public enum ClientRace implements BaseCode {
	ASIAN (5, "Asian"),
	BLACK (6, "Black or African American"),
	INDIAN (7, "American Indian or Alaska Native"),
	WHITE (8, "White"),
	HAWAIIAN (9, "Native Hawaiian or Other Pacific Islander"),
	OTHER (14, "Other"),
	UNKNOWN (15, "Client doesn't know"),
	REFUSED (16, "Client Refused");

	private final Integer code;
	private final String description;

	ClientRace(final Integer code, final String description) {
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