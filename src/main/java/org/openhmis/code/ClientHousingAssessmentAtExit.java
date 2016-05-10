package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: HousingAssessmentAtExit (2014, 4.19.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientHousingAssessmentAtExit implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	MAINTAIN (1, "Able to maintain the housing they had at project entry"),
	@XmlEnumValue("2")
	MOVED (2, "Moved to new housing unit"),
	@XmlEnumValue("3")
	FAMILY_TEMPORARY (3, "Moved in with family/friends on a temporary basis"),
	@XmlEnumValue("4")
	FAMILY_PERMANENT (4, "Moved in with family/friends on a permanent basis"),
	@XmlEnumValue("5")
	TRANSITIONAL (5, "Moved to a transitional or temporary housing facility or program"),
	@XmlEnumValue("6")
	HOMELESS (6, "Client became homeless – moving to a shelter or other place unfit for human habitation"),
	@XmlEnumValue("7")
	JAIL (7, "Client went to jail/prison"),
	@XmlEnumValue("10")
	DIED (10, "Client died"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientHousingAssessmentAtExit(final Integer code, final String description) {
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
	private static final CodeLookup<ClientHousingAssessmentAtExit> enhancer = new CodeLookup<ClientHousingAssessmentAtExit>(values());	

	@JsonCreator
	public static ClientHousingAssessmentAtExit valueByCode(Integer code) {
		ClientHousingAssessmentAtExit value = enhancer.valueByCode(code); 
		return (value == null)?ClientHousingAssessmentAtExit.ERR_UNKNOWN:value;
	}
}