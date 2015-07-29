package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: HousingAssessmentAtExit (2014, 4.19.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientHousingAssessmentAtExit implements BaseCode {
	MAINTAIN (1, "Able to maintain the housing they had at project entry"),
	MOVED (2, "Moved to new housing unit"),
	FAMILY_TEMPORARY (3, "Moved in with family/friends on a temporary basis"),
	FAMILY_PERMANENT (4, "Moved in with family/friends on a permanent basis"),
	TRANSITIONAL (5, "Moved to a transitional or temporary housing facility or program"),
	HOMELESS (6, "Client became homeless – moving to a shelter or other place unfit for human habitation"),
	JAIL (7, "Client went to jail/prison"),
	DIED (10, "Client died"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
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
		return (value == null)?ClientHousingAssessmentAtExit.NOT_COLLECTED:value;
	}
}