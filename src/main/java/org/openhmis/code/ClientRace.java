package org.openhmis.code;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Universal Data Standard: Race (2014, 3.4)

@JsonSerialize(using = CodeSerializer.class)
public enum ClientRace implements BaseCode {
	ASIAN (5, "Asian"),
	BLACK (6, "Black or African American"),
	INDIAN (7, "American Indian or Alaska Native"),
	WHITE (8, "White"),
	HAWAIIAN (9, "Native Hawaiian or Other Pacific Islander"),
	UNKNOWN_RACE (999, "ERR");

	private final Integer code;
	private final String description;

	ClientRace(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
	
	// Enable lookups by code
	private static final CodeLookup<ClientRace> enhancer = new CodeLookup<ClientRace>(values());	

	@JsonCreator
	public static ClientRace valueByCode(Integer code) {
		ClientRace value = enhancer.valueByCode(code); 
		return (value == null)?ClientRace.UNKNOWN_RACE:value;
	}
}