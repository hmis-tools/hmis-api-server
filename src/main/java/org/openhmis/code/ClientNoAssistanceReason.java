package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: NoAssistanceReason (2014, 4.39)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientNoAssistanceReason implements BaseCode {
	APPLIED_PENDING (1, "Applied; decision pending"),
	APPLIED_INELIGIBLE (2, "Applied; client not eligible"),
	NOT_APPLIED (3, "Client did not apply"),
	NA (4, "Insurance type not applicable for this client"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientNoAssistanceReason(final Integer code, final String description) {
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
	private static final CodeLookup<ClientNoAssistanceReason> enhancer = new CodeLookup<ClientNoAssistanceReason>(values());	

	@JsonCreator
	public static ClientNoAssistanceReason valueByCode(Integer code) {
		ClientNoAssistanceReason value = enhancer.valueByCode(code); 
		return (value == null)?ClientNoAssistanceReason.NOT_COLLECTED:value;
	}
}