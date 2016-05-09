package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: LastGradeCompleted (2014, 4.24.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientLastGradeCompleted implements BaseCode {
	@XmlEnumValue("1")
	GRADE_5 (1, "Less than grade 5"),
	@XmlEnumValue("2")
	GRADE_6 (2, "Grades 5-6"),
	@XmlEnumValue("3")
	GRADE_8 (3, "Grades 7-8"),
	@XmlEnumValue("4")
	GRADE_11 (4, "Grades 9-11"),
	@XmlEnumValue("5")
	GRADE_12 (5, "Grade 12"),
	@XmlEnumValue("6")
	NO_GRADES (6, "School program does not have grade levels"),
	@XmlEnumValue("7")
	GED (7, "GED"),
	@XmlEnumValue("10")
	COLLEGE (10, "Some college"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
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