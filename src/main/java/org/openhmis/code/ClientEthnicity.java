package org.openhmis.code;

import org.openhmis.code.serialization.CodeLookup;

import com.fasterxml.jackson.annotation.JsonValue;

// Codes for Universal Data Standard: Ethnicity (2014, 3.5.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientEthnicity implements BaseCode {
	NON_HISPANIC (104, "Non-Hispanic/Non-Latino"),
	HISPANIC (105, "Hispanic/Latino"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientEthnicity(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	//@JsonValue
    public Integer getCode() {
        return code;
    }
	//@JsonValue
    public String getDescription() {
        return description;
    }
	
	// Enable lookups by code
	private static final CodeLookup<ClientEthnicity> enhancer = new CodeLookup<ClientEthnicity>(values());	
	public static ClientEthnicity valueByCode(Integer code) {
		return enhancer.valueByCode(code);
	}
}