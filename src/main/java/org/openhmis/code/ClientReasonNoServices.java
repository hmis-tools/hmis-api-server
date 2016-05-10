package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ReasonNoServices (2014, 4.22.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientReasonNoServices implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	OUT_OF_RANGE (1, "Out of age range"),
	@XmlEnumValue("2")
	WARD_OF_STATE (2, "Ward of the state"),
	@XmlEnumValue("3")
	WARD_OF_JUSTICE (3, "Ward of the criminal justice system"),
	@XmlEnumValue("4")
	OTHER (4, "Other"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientReasonNoServices(final Integer code, final String description) {
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
	private static final CodeLookup<ClientReasonNoServices> enhancer = new CodeLookup<ClientReasonNoServices>(values());	

	@JsonCreator
	public static ClientReasonNoServices valueByCode(Integer code) {
		ClientReasonNoServices value = enhancer.valueByCode(code); 
		return (value == null)?ClientReasonNoServices.ERR_UNKNOWN:value;
	}
}