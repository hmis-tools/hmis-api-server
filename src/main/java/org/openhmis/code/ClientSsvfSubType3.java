package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: AddressDataQuality (2014, 4.14.D3)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientSsvfSubType3 implements BaseCode {
	@XmlEnumValue("1")
	VOCATIONAL_COUNSELING (1, "VA vocational and rehabilitation counseling"),
	@XmlEnumValue("2")
	EMPLOYMENT_TRAINING (2, "Employment and training services"),
	@XmlEnumValue("3")
	EDUCATIONAL_ASSISTANCE (3, "Educational assistance"),
	@XmlEnumValue("4")
	HEALTHCARE (4, "Health care services"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientSsvfSubType3(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSsvfSubType3> enhancer = new CodeLookup<ClientSsvfSubType3>(values());	

	@JsonCreator
	public static ClientSsvfSubType3 valueByCode(Integer code) {
		ClientSsvfSubType3 value = enhancer.valueByCode(code); 
		return (value == null)?ClientSsvfSubType3.NOT_COLLECTED:value;
	}
}