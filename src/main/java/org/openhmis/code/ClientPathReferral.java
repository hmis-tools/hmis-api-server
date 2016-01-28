package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: PATHReferral (2014, 4.16.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientPathReferral implements BaseCode {
	MENTAL_HEALTH (1, "Community mental health"),
	SUBSTANCE_USE (2, "Substance use treatment"),
	PRIMARY_HEALTH (3, "Primary health services"),
	JOB_TRAINING (4, "Job training"),
	EDUCATIONAL (5, "Educational services"),
	HOUSING_SERVICES (6, "Relevant housing services"),
	HOUSING_PLACEMENT (7, "Housing placement assistance"),
	INCOME_ASSISTANCE (8, "Income assistance"),
	EMPLOYMENT_ASSISTANCE (9, "Employment assistance"),
	MEDICAL_ASSISTANCE (10, "Medical assistance"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientPathReferral(final Integer code, final String description) {
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
	private static final CodeLookup<ClientPathReferral> enhancer = new CodeLookup<ClientPathReferral>(values());	

	@JsonCreator
	public static ClientPathReferral valueByCode(Integer code) {
		ClientPathReferral value = enhancer.valueByCode(code); 
		return (value == null)?ClientPathReferral.NOT_COLLECTED:value;
	}
}