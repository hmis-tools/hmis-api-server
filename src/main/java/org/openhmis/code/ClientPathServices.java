package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: AddressDataQuality (2014, 4.43.5)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientPathServices implements BaseCode {
	OUTREACH (1, "Outreach"),
	SCREENING (2, "Screening/assessment"),
	HABILITATION (3, "Habilitation/rehabilitation"),
	MENTAL_HEALTH (4, "Community mental health"),
	SUBSTANCE_USE (5, "Substance use treatment"),
	CASE_MANAGEMENT (6, "Case management"),
	RESIDENTIAL_SUPPORT (7, "Residential supportive services"),
	MINOR_RENOVATION (8, "Housing minor renovation"),
	MOVING_ASSISTANCE (9, "Housing moving assistance"),
	TECHNICAL_ASSISTANCE (10, "Housing technical assistance"),
	SECURITY_DEPOSITS (11, "Security deposits"),
	EVICTION_PREVENTION (12, "One-time rent for eviction prevention"),
	OTHER_PATH (13, "Other PATH funded service"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientPathServices(final Integer code, final String description) {
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
	private static final CodeLookup<ClientPathServices> enhancer = new CodeLookup<ClientPathServices>(values());	

	@JsonCreator
	public static ClientPathServices valueByCode(Integer code) {
		ClientPathServices value = enhancer.valueByCode(code); 
		return (value == null)?ClientPathServices.NOT_COLLECTED:value;
	}
}