package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: PATHReferral (2014, 4.16.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientPathReferral implements BaseCode {
	@XmlEnumValue("1")
	MENTAL_HEALTH (1, "Community mental health"),
	@XmlEnumValue("2")
	SUBSTANCE_USE (2, "Substance use treatment"),
	@XmlEnumValue("3")
	PRIMARY_HEALTH (3, "Primary health services"),
	@XmlEnumValue("4")
	JOB_TRAINING (4, "Job training"),
	@XmlEnumValue("5")
	EDUCATIONAL (5, "Educational services"),
	@XmlEnumValue("6")
	HOUSING_SERVICES (6, "Relevant housing services"),
	@XmlEnumValue("7")
	HOUSING_PLACEMENT (7, "Housing placement assistance"),
	@XmlEnumValue("8")
	INCOME_ASSISTANCE (8, "Income assistance"),
	@XmlEnumValue("9")
	EMPLOYMENT_ASSISTANCE (9, "Employment assistance"),
	@XmlEnumValue("10")
	MEDICAL_ASSISTANCE (10, "Medical assistance"),
	@XmlEnumValue("99")
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