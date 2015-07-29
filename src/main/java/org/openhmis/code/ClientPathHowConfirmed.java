package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: PATHHowConfirmed (2014, 4.9.D)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientPathHowConfirmed implements BaseCode {
	UNCONFIRMED (1, "Unconfirmed; presumptive or self-report"),
	EVALUATION (2, "Confirmed through assessment and clinical evaluation"),
	PRIOR_EVALUATION (3, "Confirmed by prior evaluation or clinical records"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientPathHowConfirmed(final Integer code, final String description) {
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
	private static final CodeLookup<ClientPathHowConfirmed> enhancer = new CodeLookup<ClientPathHowConfirmed>(values());	

	@JsonCreator
	public static ClientPathHowConfirmed valueByCode(Integer code) {
		ClientPathHowConfirmed value = enhancer.valueByCode(code); 
		return (value == null)?ClientPathHowConfirmed.NOT_COLLECTED:value;
	}
}