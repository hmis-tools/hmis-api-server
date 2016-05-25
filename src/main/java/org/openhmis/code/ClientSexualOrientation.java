package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: SexualOrientation (2014, 4.23.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientSexualOrientation implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	HETEROSEXUAL (1, "Heterosexual"),
	@XmlEnumValue("2")
	GAY (2, "Gay"),
	@XmlEnumValue("3")
	LESBIAN (3, "Lesbian"),
	@XmlEnumValue("4")
	BISEXUAL (4, "Bisexual"),
	@XmlEnumValue("5")
	UNSURE (5, "Unsure"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientSexualOrientation(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSexualOrientation> enhancer = new CodeLookup<ClientSexualOrientation>(values());	

	@JsonCreator
	public static ClientSexualOrientation valueByCode(Integer code) {
		ClientSexualOrientation value = enhancer.valueByCode(code); 
		return (value == null)?ClientSexualOrientation.ERR_UNKNOWN:value;
	}
}