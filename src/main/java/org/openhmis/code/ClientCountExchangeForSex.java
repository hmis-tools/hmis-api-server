package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: CountExchangeForSex (2014, 4.35.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientCountExchangeForSex implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	THREE (1, "1-3"),
	@XmlEnumValue("2")
	SEVEN (2, "4-7"),
	@XmlEnumValue("3")
	THIRTY (3, "8-30"),
	@XmlEnumValue("4")
	OVER_THIRTY (4, "More than 30"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientCountExchangeForSex(final Integer code, final String description) {
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
	private static final CodeLookup<ClientCountExchangeForSex> enhancer = new CodeLookup<ClientCountExchangeForSex>(values());	

	@JsonCreator
	public static ClientCountExchangeForSex valueByCode(Integer code) {
		ClientCountExchangeForSex value = enhancer.valueByCode(code); 
		return (value == null)?ClientCountExchangeForSex.ERR_UNKNOWN:value;
	}
}