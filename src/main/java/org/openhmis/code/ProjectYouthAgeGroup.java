package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: YouthAgeGroup (2014, 2.7.B)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ProjectYouthAgeGroup implements BaseCode {
	UNDER_EIGHTEEN (1, "Only under age 18"),
	EIGHTEEN_TO_TWENTYFOUR (2, "Only ages 18 to 24"),
	BOTH (3, "Only youth under age 24 (both of the above)"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ProjectYouthAgeGroup(final Integer code, final String description) {
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
	private static final CodeLookup<ProjectYouthAgeGroup> enhancer = new CodeLookup<ProjectYouthAgeGroup>(values());	

	@JsonCreator
	public static ProjectYouthAgeGroup valueByCode(Integer code) {
		ProjectYouthAgeGroup value = enhancer.valueByCode(code); 
		return (value == null)?ProjectYouthAgeGroup.NOT_COLLECTED:value;
	}
}