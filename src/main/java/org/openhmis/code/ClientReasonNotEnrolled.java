package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ReasonNotEnrolled (2014, 4.20.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientReasonNotEnrolled implements BaseCode {
	INELIGIBLE (1, "Client was found ineligible for PATH"),
	OTHER (2, "Client was not enrolled for other reason(s)"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientReasonNotEnrolled(final Integer code, final String description) {
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
	private static final CodeLookup<ClientReasonNotEnrolled> enhancer = new CodeLookup<ClientReasonNotEnrolled>(values());	

	@JsonCreator
	public static ClientReasonNotEnrolled valueByCode(Integer code) {
		ClientReasonNotEnrolled value = enhancer.valueByCode(code); 
		return (value == null)?ClientReasonNotEnrolled.NOT_COLLECTED:value;
	}
}