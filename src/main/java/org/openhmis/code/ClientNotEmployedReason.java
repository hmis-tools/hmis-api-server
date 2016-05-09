package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: NotEmployedReason (2014, 4.26.B)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientNotEmployedReason implements BaseCode {
	@XmlEnumValue("1")
	LOOKING (1, "Looking for work"),
	@XmlEnumValue("2")
	SCHOOL (2, "In school"),
	@XmlEnumValue("3")
	UNABLE (3, "Unable to work"),
	@XmlEnumValue("4")
	NOT_LOOKING (4, "Not looking for work"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientNotEmployedReason(final Integer code, final String description) {
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
	private static final CodeLookup<ClientNotEmployedReason> enhancer = new CodeLookup<ClientNotEmployedReason>(values());	

	@JsonCreator
	public static ClientNotEmployedReason valueByCode(Integer code) {
		ClientNotEmployedReason value = enhancer.valueByCode(code); 
		return (value == null)?ClientNotEmployedReason.NOT_COLLECTED:value;
	}
}