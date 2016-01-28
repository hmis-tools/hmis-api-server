package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: DisabilityResponse (2014, 4.10.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientDisabilityResponse implements BaseCode {
	NO (0, "No"),
	ALCOHOL (1, "Alcohol abuse"),
	DRUG (2, "Drug abuse"),
	BOTH (3, "Both alcohol and drug abuse"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientDisabilityResponse(final Integer code, final String description) {
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
	private static final CodeLookup<ClientDisabilityResponse> enhancer = new CodeLookup<ClientDisabilityResponse>(values());	

	@JsonCreator
	public static ClientDisabilityResponse valueByCode(Integer code) {
		ClientDisabilityResponse value = enhancer.valueByCode(code); 
		return (value == null)?ClientDisabilityResponse.NOT_COLLECTED:value;
	}
}