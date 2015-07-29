package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ExpelledReason (2014, 4.37.B)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientExpelledReason implements BaseCode {
	CRIME (1, "Criminal activity/destruction of property/violence"),
	NON_COMPLIANCE (2, "Non-compliance with project rules"),
	NON_PAYMENT (3, "Non-payment of rent/occupancy charge"),
	MAXIMUM_TIME (4, "Reached maximum time allowed by project"),
	TERMINATED (5, "Project terminated"),
	UNKNOWN (6, "Unknown/disappeared"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientExpelledReason(final Integer code, final String description) {
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
	private static final CodeLookup<ClientExpelledReason> enhancer = new CodeLookup<ClientExpelledReason>(values());	

	@JsonCreator
	public static ClientExpelledReason valueByCode(Integer code) {
		ClientExpelledReason value = enhancer.valueByCode(code); 
		return (value == null)?ClientExpelledReason.NOT_COLLECTED:value;
	}
}