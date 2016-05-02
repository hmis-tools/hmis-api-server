package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: AddressDataQuality (2014, 4.43.5)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientAddressDataQuality implements BaseCode {
	@XmlEnumValue("1")
	FULL_ADDRESS (1, "Full address"),
	@XmlEnumValue("2")
	INCOMPLETE (2, "Incomplete or estimated address"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientAddressDataQuality(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	@XmlElement
	public Integer getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
	// Enable lookups by code
	private static final CodeLookup<ClientAddressDataQuality> enhancer = new CodeLookup<ClientAddressDataQuality>(values());	

	@JsonCreator
	public static ClientAddressDataQuality valueByCode(Integer code) {
		ClientAddressDataQuality value = enhancer.valueByCode(code); 
		return (value == null)?ClientAddressDataQuality.NOT_COLLECTED:value;
	}
}