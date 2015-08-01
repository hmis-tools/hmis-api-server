package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: RelationshipToHoH (2014, 3.15.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientRelationshipToHoH implements BaseCode {
	SELF (1, "Self (head of household)"),
	CHILD (2, "Child"),
	SPOUSE (3, "Spouse or partner"),
	RELATIVE (4, "Other relative"),
	UNRELATED (5, "Unrelated household member"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientRelationshipToHoH(final Integer code, final String description) {
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
	private static final CodeLookup<ClientRelationshipToHoH> enhancer = new CodeLookup<ClientRelationshipToHoH>(values());	

	@JsonCreator
	public static ClientRelationshipToHoH valueByCode(Integer code) {
		ClientRelationshipToHoH value = enhancer.valueByCode(code); 
		return (value == null)?ClientRelationshipToHoH.NOT_COLLECTED:value;
	}
}