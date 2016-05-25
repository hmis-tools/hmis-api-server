package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: Availability (2014, 2.7.4)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ProjectAvailability implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	YEAR_ROUND (1, "Year-round"),
	@XmlEnumValue("2")
	SEASONAL (2, "Seasonal"),
	@XmlEnumValue("3")
	OVERFLOW (3, "Overflow"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ProjectAvailability(final Integer code, final String description) {
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
	private static final CodeLookup<ProjectAvailability> enhancer = new CodeLookup<ProjectAvailability>(values());	

	@JsonCreator
	public static ProjectAvailability valueByCode(Integer code) {
		ProjectAvailability value = enhancer.valueByCode(code); 
		return (value == null)?ProjectAvailability.ERR_UNKNOWN:value;
	}
}