package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: SchoolStatus (2014, 4.25.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientSchoolStatus implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	ATTENDING_REGULARLY (1, "Attending school regularly"),
	@XmlEnumValue("2")
	ATTENDING_IRREGULARLY (2, "Attending school irregularly"),
	@XmlEnumValue("3")
	GRADUATED (3, "Graduated from high school"),
	@XmlEnumValue("4")
	GED (4, "Obtained GED"),
	@XmlEnumValue("5")
	DROPPED_OUT (5, "Dropped out"),
	@XmlEnumValue("6")
	SUSPENDED (6, "Suspended"),
	@XmlEnumValue("7")
	EXPELLED (7, "Expelled"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientSchoolStatus(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSchoolStatus> enhancer = new CodeLookup<ClientSchoolStatus>(values());	

	@JsonCreator
	public static ClientSchoolStatus valueByCode(Integer code) {
		ClientSchoolStatus value = enhancer.valueByCode(code); 
		return (value == null)?ClientSchoolStatus.ERR_UNKNOWN:value;
	}
}