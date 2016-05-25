package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ProjectTrackingMethod (2014, 2.5.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ProjectTrackingMethod implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("0")
	ENTRY_EXIT (0, "Entry/Exit Date"),
	@XmlEnumValue("3")
	NIGHT_BY_NIGHT (3, "Night-by-Night"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ProjectTrackingMethod(final Integer code, final String description) {
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
	private static final CodeLookup<ProjectTrackingMethod> enhancer = new CodeLookup<ProjectTrackingMethod>(values());	

	@JsonCreator
	public static ProjectTrackingMethod valueByCode(Integer code) {
		ProjectTrackingMethod value = enhancer.valueByCode(code); 
		return (value == null)?ProjectTrackingMethod.ERR_UNKNOWN:value;
	}
}