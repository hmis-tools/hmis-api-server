package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: PATHReferralOutcome (2014, 4.16.A1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientPathReferralOutcome implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	ATTAINED (1, "Attained"),
	@XmlEnumValue("2")
	NOT_ATTAINED (2, "Not attained"),
	@XmlEnumValue("3")
	UNKNOWN (3, "Unknown"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientPathReferralOutcome(final Integer code, final String description) {
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
	private static final CodeLookup<ClientPathReferralOutcome> enhancer = new CodeLookup<ClientPathReferralOutcome>(values());	

	@JsonCreator
	public static ClientPathReferralOutcome valueByCode(Integer code) {
		ClientPathReferralOutcome value = enhancer.valueByCode(code); 
		return (value == null)?ClientPathReferralOutcome.ERR_UNKNOWN:value;
	}
}