package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: EarlyExitReason (2014, 4.37.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientEarlyExitReason implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	INDEPENDENT_LIVING (1, "Left for other opportunities - independent living"),
	@XmlEnumValue("2")
	EDUCATION (2, "Left for other opportunities - education"),
	@XmlEnumValue("3")
	MILITARY (3, "Left for other opportunities - military"),
	@XmlEnumValue("4")
	OTHER (4, "Left for other opportunities - other"),
	@XmlEnumValue("5")
	NEEDS_UNMET (5, "Needs could not be met by project"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientEarlyExitReason(final Integer code, final String description) {
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
	private static final CodeLookup<ClientEarlyExitReason> enhancer = new CodeLookup<ClientEarlyExitReason>(values());	

	@JsonCreator
	public static ClientEarlyExitReason valueByCode(Integer code) {
		ClientEarlyExitReason value = enhancer.valueByCode(code); 
		return (value == null)?ClientEarlyExitReason.ERR_UNKNOWN:value;
	}
}