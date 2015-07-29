package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: SchoolStatus (2014, 4.25.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientSchoolStatus implements BaseCode {
	ATTENDING_REGULARLY (1, "Attending school regularly"),
	ATTENDING_IRREGULARLY (2, "Attending school irregularly"),
	GRADUATED (3, "Graduated from high school"),
	GED (4, "Obtained GED"),
	DROPPED_OUT (5, "Dropped out"),
	SUSPENDED (6, "Suspended"),
	EXPELLED (7, "Expelled"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientSchoolStatus(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSchoolStatus> enhancer = new CodeLookup<ClientSchoolStatus>(values());	

	@JsonCreator
	public static ClientSchoolStatus valueByCode(Integer code) {
		ClientSchoolStatus value = enhancer.valueByCode(code); 
		return (value == null)?ClientSchoolStatus.NOT_COLLECTED:value;
	}
}