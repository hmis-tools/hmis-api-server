package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ReasonNotInsured (2014, 4.4.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientReasonNotInsured implements BaseCode {
	APPLIED_PENDING (1, "Applied; decision pending"),
	APPLIED_INELIGIBLE (2, "Applied; client not eligible"),
	NOT_APPLIED (3, "Client did not apply"),
	NA (4, "Insurance type n/a for this client"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientReasonNotInsured(final Integer code, final String description) {
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
	private static final CodeLookup<ClientReasonNotInsured> enhancer = new CodeLookup<ClientReasonNotInsured>(values());	

	@JsonCreator
	public static ClientReasonNotInsured valueByCode(Integer code) {
		ClientReasonNotInsured value = enhancer.valueByCode(code); 
		return (value == null)?ClientReasonNotInsured.NOT_COLLECTED:value;
	}
}