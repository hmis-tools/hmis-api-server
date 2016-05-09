package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: AddressDataQuality (2014, 4.43.5)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientPathServices implements BaseCode {
	@XmlEnumValue("1")
	OUTREACH (1, "Outreach"),
	@XmlEnumValue("2")
	SCREENING (2, "Screening/assessment"),
	@XmlEnumValue("3")
	HABILITATION (3, "Habilitation/rehabilitation"),
	@XmlEnumValue("4")
	MENTAL_HEALTH (4, "Community mental health"),
	@XmlEnumValue("5")
	SUBSTANCE_USE (5, "Substance use treatment"),
	@XmlEnumValue("6")
	CASE_MANAGEMENT (6, "Case management"),
	@XmlEnumValue("7")
	RESIDENTIAL_SUPPORT (7, "Residential supportive services"),
	@XmlEnumValue("8")
	MINOR_RENOVATION (8, "Housing minor renovation"),
	@XmlEnumValue("9")
	MOVING_ASSISTANCE (9, "Housing moving assistance"),
	@XmlEnumValue("10")
	TECHNICAL_ASSISTANCE (10, "Housing technical assistance"),
	@XmlEnumValue("11")
	SECURITY_DEPOSITS (11, "Security deposits"),
	@XmlEnumValue("12")
	EVICTION_PREVENTION (12, "One-time rent for eviction prevention"),
	@XmlEnumValue("13")
	OTHER_PATH (13, "Other PATH funded service"),
	@XmlEnumValue("99")
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