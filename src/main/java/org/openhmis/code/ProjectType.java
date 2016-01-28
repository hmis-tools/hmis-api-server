package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ProjectType (2014, 2.4.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ProjectType implements BaseCode {
	EMERGENCY_SHELTER (1, "Emergency Shelter"),
	TRANSITIONAL_HOUSING (2, "Transitional Housing"),
	SUPPORTIVE_HOUSING (3, "PH - Permanent Supportive Housing"),
	STREET_OUTREACH (4, "Street Outreach"),
	SERVICES_ONLY (6, "Services Only"),
	OTHER (7, "Other"),
	SAFE_HAVEN (8, "Safe Haven"),
	HOUSING_ONLY (9, "PH – Housing Only"),
	HOUSING_WITH_SERVICES (10, "PH – Housing with Services (no disability required for entry)"),
	DAY_SHELTER (11, "Day Shelter"),
	HOMELESSNESS_PREVENTION (12, "Homelessness Prevention"),
	RAPIT_REHOUSING (13, "PH - Rapid Re-Housing"),
	COORDINATED_ASSESSMENT (14, "Coordinated Assessment"),
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