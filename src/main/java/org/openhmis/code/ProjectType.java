package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ProjectType (2014, 2.4.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ProjectType implements BaseCode {
	@XmlEnumValue("1")
	EMERGENCY_SHELTER (1, "Emergency Shelter"),
	@XmlEnumValue("2")
	TRANSITIONAL_HOUSING (2, "Transitional Housing"),
	@XmlEnumValue("3")
	SUPPORTIVE_HOUSING (3, "PH - Permanent Supportive Housing"),
	@XmlEnumValue("4")
	STREET_OUTREACH (4, "Street Outreach"),
	@XmlEnumValue("6")
	SERVICES_ONLY (6, "Services Only"),
	@XmlEnumValue("7")
	OTHER (7, "Other"),
	@XmlEnumValue("8")
	SAFE_HAVEN (8, "Safe Haven"),
	@XmlEnumValue("9")
	HOUSING_ONLY (9, "PH – Housing Only"),
	@XmlEnumValue("10")
	HOUSING_WITH_SERVICES (10, "PH – Housing with Services (no disability required for entry)"),
	@XmlEnumValue("11")
	DAY_SHELTER (11, "Day Shelter"),
	@XmlEnumValue("12")
	HOMELESSNESS_PREVENTION (12, "Homelessness Prevention"),
	@XmlEnumValue("13")
	RAPIT_REHOUSING (13, "PH - Rapid Re-Housing"),
	@XmlEnumValue("14")
	COORDINATED_ASSESSMENT (14, "Coordinated Assessment"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ProjectType(final Integer code, final String description) {
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
	private static final CodeLookup<ProjectType> enhancer = new CodeLookup<ProjectType>(values());	

	@JsonCreator
	public static ProjectType valueByCode(Integer code) {
		ProjectType value = enhancer.valueByCode(code); 
		return (value == null)?ProjectType.NOT_COLLECTED:value;
	}
}