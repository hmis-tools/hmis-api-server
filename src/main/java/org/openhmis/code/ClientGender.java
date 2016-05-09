package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Universal Data Standard: Gender (2014, 3.6.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientGender implements BaseCode {
	@XmlEnumValue("0")
	FEMALE (0, "Female"),
	@XmlEnumValue("1")
	MALE (1, "Male"),
	@XmlEnumValue("2")
	TRANSGENDER_MALE_TO_FEMALE (2, "Transgender Male to Female"),
	@XmlEnumValue("3")
	TRANSGENDER_FEMALE_TO_MALE (3, "Transgender Female to Male"),
	@XmlEnumValue("4")
	OTHER (4, "Other"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientGender(final Integer code, final String description) {
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
	private static final CodeLookup<ClientGender> enhancer = new CodeLookup<ClientGender>(values());	

	@JsonCreator
	public static ClientGender valueByCode(Integer code) {
		ClientGender value = enhancer.valueByCode(code); 
		return (value == null)?ClientGender.NOT_COLLECTED:value;
	}
}