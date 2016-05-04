package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: EmploymentType (2014, 4.26.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientEmploymentType implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	FULL_TIME (1, "Full-time"),
	@XmlEnumValue("2")
	PART_TIME (2, "Part-time"),
	@XmlEnumValue("3")
	SEASONAL (3, "Seasonal / sporadic (including day labor)"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientEmploymentType(final Integer code, final String description) {
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
	private static final CodeLookup<ClientEmploymentType> enhancer = new CodeLookup<ClientEmploymentType>(values());	

	@JsonCreator
	public static ClientEmploymentType valueByCode(Integer code) {
		ClientEmploymentType value = enhancer.valueByCode(code); 
		return (value == null)?ClientEmploymentType.ERR_UNKNOWN:value;
	}
}