package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: TimesHomelessPastThreeYears (2014, 3.17.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientTimesHomelessPastThreeYears implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("0")
	ZERO (0, "0 (not homeless - Prevention only)"),
	@XmlEnumValue("1")
	ONE (1, "1 (homeless only this time)"),
	@XmlEnumValue("2")
	TWO (2, "2"),
	@XmlEnumValue("3")
	THREE (3, "3"),
	@XmlEnumValue("4")
	MORE (4, "4 or more"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientTimesHomelessPastThreeYears(final Integer code, final String description) {
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
	private static final CodeLookup<ClientTimesHomelessPastThreeYears> enhancer = new CodeLookup<ClientTimesHomelessPastThreeYears>(values());	

	@JsonCreator
	public static ClientTimesHomelessPastThreeYears valueByCode(Integer code) {
		ClientTimesHomelessPastThreeYears value = enhancer.valueByCode(code); 
		return (value == null)?ClientTimesHomelessPastThreeYears.ERR_UNKNOWN:value;
	}
}