package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;


@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ConsentField implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("dob")
	DATE_OF_BIRTH (0, "dob"),
	@XmlEnumValue("1")
	ETHNICITY (1, "ethnicity"),
	@XmlEnumValue("2")
	FIRST_NAME (2, "firstName"),
	@XmlEnumValue("3")
	GENDER (3, "gender"),
	@XmlEnumValue("4")
	LAST_NAME (4, "lastNanme"),
	@XmlEnumValue("5")
	MIDDLE_NAME (5, "middleNanme"),
	@XmlEnumValue("6")
	NAME_SUFFIX (6, "nameSuffix"),
	@XmlEnumValue("7")
	RACE (7, "race"),
	@XmlEnumValue("8")
	SSN (8, "ssn"),
	@XmlEnumValue("9")
	VETERAN_STATUS (9, "veteranStatus");
	
	private final Integer code;
	private final String description;

	ConsentField(final Integer code, final String description) {
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
	private static final CodeLookup<ConsentField> enhancer = new CodeLookup<ConsentField>(values());	

	@JsonCreator
	public static ConsentField valueByCode(Integer code) {
		ConsentField value = enhancer.valueByCode(code); 
		return (value == null)?ConsentField.ERR_UNKNOWN:value;
	}
}