package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: HouseholdType (2014, 2.7.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ProjectHouseholdType implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("0")
	NO_CHILDREN (0, "Households without children"),
	@XmlEnumValue("3")
	ADULTS_AND_CHILDREN (3, "Households with at least one adult and one child"),
	@XmlEnumValue("4")
	ONLY_CHILDREN (4, "Households with only children"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ProjectHouseholdType(final Integer code, final String description) {
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
	private static final CodeLookup<ProjectHouseholdType> enhancer = new CodeLookup<ProjectHouseholdType>(values());	

	@JsonCreator
	public static ProjectHouseholdType valueByCode(Integer code) {
		ProjectHouseholdType value = enhancer.valueByCode(code); 
		return (value == null)?ProjectHouseholdType.ERR_UNKNOWN:value;
	}
}