package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: HousingAssessmentDisposition (4.18.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientHousingAssessmentDisposition implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	EMERGENCY_SHELTER (1, "Referred to emergency shelter/safe haven"),
	@XmlEnumValue("2")
	TRANSITIONAL (2, "Referred to transitional housing"),
	@XmlEnumValue("3")
	REHOUSING (3, "Referred to rapid re-housing"),
	@XmlEnumValue("4")
	SUPPORTIVE (4, "Referred to permanent supportive housing"),
	@XmlEnumValue("5")
	PREVENTION (5, "Referred to homelessness prevention"),
	@XmlEnumValue("6")
	OUTREACH (6, "Referred to street outreach"),
	@XmlEnumValue("7")
	OTHER_CONTINUUM (7, "Referred to other continuum project type"),
	@XmlEnumValue("8")
	DIVERSION (8, "Referred to a homelessness diversion program"),
	@XmlEnumValue("9")
	INELIGIBLE (9, "Unable to refer/accept within continuum; ineligible for continuum projects"),
	@XmlEnumValue("10")
	UNAVAILABLE (10, "Unable to refer/accept within continuum; continuum services unavailable"),
	@XmlEnumValue("11")
	OTHER_NONCONTINUUM (11, "Referred to other community project (non-continuum)"),
	@XmlEnumValue("12")
	DECLINED (12, "Applicant declined referral/acceptance"),
	@XmlEnumValue("13")
	TERMINATED (13, "Applicant terminated assessment prior to completion"),
	@XmlEnumValue("14")
	OTHER (14, "Other/specify"),
	@XmlEnumValue("99")
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
		return (value == null)?ClientHousingAssessmentDisposition.ERR_UNKNOWN:value;
	}
}