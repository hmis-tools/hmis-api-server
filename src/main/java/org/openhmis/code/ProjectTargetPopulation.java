package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: Target Population (2014, 2.9.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ProjectTargetPopulation implements BaseCode {
	@XmlEnumValue("1")
	DOMESTIC_VIOLENCE (1, "Domestic violence victims"),
	@XmlEnumValue("3")
	HIV_AIDS (3, "Persons with HIV/AIDS"),
	@XmlEnumValue("4")
	NOT_APPLICABLE (4, "Not applicable"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ProjectTargetPopulation(final Integer code, final String description) {
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
	private static final CodeLookup<ProjectTargetPopulation> enhancer = new CodeLookup<ProjectTargetPopulation>(values());	

	@JsonCreator
	public static ProjectTargetPopulation valueByCode(Integer code) {
		ProjectTargetPopulation value = enhancer.valueByCode(code); 
		return (value == null)?ProjectTargetPopulation.NOT_COLLECTED:value;
	}
}
