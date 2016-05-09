package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: DisabilityResponse (2014, 4.10.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientDisabilityResponse implements BaseCode {
	@XmlEnumValue("0")
	NO (0, "No"),
	@XmlEnumValue("1")
	ALCOHOL (1, "Alcohol abuse"),
	@XmlEnumValue("2")
	DRUG (2, "Drug abuse"),
	@XmlEnumValue("3")
	BOTH (3, "Both alcohol and drug abuse"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
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