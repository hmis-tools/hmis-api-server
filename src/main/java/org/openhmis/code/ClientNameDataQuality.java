package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Universal Data Standard: Name (2014, 3.1.5)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientNameDataQuality implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	FULL (1, "Full name reported"),
	@XmlEnumValue("2")
	PARTIAL (2, "Partial, street name, or code name reported"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientNameDataQuality(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	//@JsonValue
	public Integer getCode() {
		return code;
	}
	//@JsonValue
	public String getDescription() {
		return description;
	}
	
	// Enable lookups by code
	private static final CodeLookup<ClientNameDataQuality> enhancer = new CodeLookup<ClientNameDataQuality>(values());	

	@JsonCreator
	public static ClientNameDataQuality valueByCode(Integer code) {
		ClientNameDataQuality value = enhancer.valueByCode(code); 
		return (value == null)?ClientNameDataQuality.ERR_UNKNOWN:value;
	}
}