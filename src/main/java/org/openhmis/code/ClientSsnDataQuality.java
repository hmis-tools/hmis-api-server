package org.openhmis.code;

import org.openhmis.code.serialization.CodeLookup;

import com.fasterxml.jackson.annotation.JsonValue;

// Codes for Universal Data Standard: Social Security Number (2014, 3.2.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientSsnDataQuality implements BaseCode {
	FULL (1, "Full SSN reported"),
	PARTIAL (2, "Approximate or partial SSN reported"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");

	
	private final Integer code;
	private final String description;

	ClientSsnDataQuality(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSsnDataQuality> enhancer = new CodeLookup<ClientSsnDataQuality>(values());	
	public static ClientSsnDataQuality valueByCode(Integer code) {
		return enhancer.valueByCode(code);
	}
}