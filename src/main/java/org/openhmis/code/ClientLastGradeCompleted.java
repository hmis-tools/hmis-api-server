package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: LastGradeCompleted (2014, 4.24.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientLastGradeCompleted implements BaseCode {
	GRADE_5 (1, "Less than grade 5"),
	GRADE_6 (2, "Grades 5-6"),
	GRADE_8 (3, "Grades 7-8"),
	GRADE_11 (4, "Grades 9-11"),
	GRADE_12 (5, "Grade 12"),
	NO_GRADES (6, "School program does not have grade levels"),
	GED (7, "GED"),
	COLLEGE (10, "Some college"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientLastGradeCompleted(final Integer code, final String description) {
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
	private static final CodeLookup<ClientLastGradeCompleted> enhancer = new CodeLookup<ClientLastGradeCompleted>(values());	

	@JsonCreator
	public static ClientLastGradeCompleted valueByCode(Integer code) {
		ClientLastGradeCompleted value = enhancer.valueByCode(code); 
		return (value == null)?ClientLastGradeCompleted.NOT_COLLECTED:value;
	}
}