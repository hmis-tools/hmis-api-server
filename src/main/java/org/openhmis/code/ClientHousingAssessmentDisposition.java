package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: HousingAssessmentDisposition (4.18.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientHousingAssessmentDisposition implements BaseCode {
	EMERGENCY_SHELTER (1, "Referred to emergency shelter/safe haven"),
	TRANSITIONAL (2, "Referred to transitional housing"),
	REHOUSING (3, "Referred to rapid re-housing"),
	SUPPORTIVE (4, "Referred to permanent supportive housing"),
	PREVENTION (5, "Referred to homelessness prevention"),
	OUTREACH (6, "Referred to street outreach"),
	OTHER_CONTINUUM (7, "Referred to other continuum project type"),
	DIVERSION (8, "Referred to a homelessness diversion program"),
	INELIGIBLE (9, "Unable to refer/accept within continuum; ineligible for continuum projects"),
	UNAVAILABLE (10, "Unable to refer/accept within continuum; continuum services unavailable"),
	OTHER_NONCONTINUUM (11, "Referred to other community project (non-continuum)"),
	DECLINED (12, "Applicant declined referral/acceptance"),
	TERMINATED (13, "Applicant terminated assessment prior to completion"),
	OTHER (14, "Other/specify"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientHousingAssessmentDisposition(final Integer code, final String description) {
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
	private static final CodeLookup<ClientHousingAssessmentDisposition> enhancer = new CodeLookup<ClientHousingAssessmentDisposition>(values());	

	@JsonCreator
	public static ClientHousingAssessmentDisposition valueByCode(Integer code) {
		ClientHousingAssessmentDisposition value = enhancer.valueByCode(code); 
		return (value == null)?ClientHousingAssessmentDisposition.NOT_COLLECTED:value;
	}
}