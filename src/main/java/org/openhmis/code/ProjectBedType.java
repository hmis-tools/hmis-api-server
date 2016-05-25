package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: BedType (2014, 2.7.3)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ProjectBedType implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	NO_CHILDREN (1, "Facility-based"),
	@XmlEnumValue("2")
	ADULTS_AND_CHILDREN (2, "Voucher"),
	@XmlEnumValue("3")
	ONLY_CHILDREN (3, "Other"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ProjectBedType(final Integer code, final String description) {
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
	private static final CodeLookup<ProjectBedType> enhancer = new CodeLookup<ProjectBedType>(values());	

	@JsonCreator
	public static ProjectBedType valueByCode(Integer code) {
		ProjectBedType value = enhancer.valueByCode(code); 
		return (value == null)?ProjectBedType.ERR_UNKNOWN:value;
	}
}