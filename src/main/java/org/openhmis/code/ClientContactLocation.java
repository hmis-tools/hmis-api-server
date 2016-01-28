package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ContactLocation (2014, 4.12.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientContactLocation implements BaseCode {
	NONHABITABLE (1, "Place not meant for habitation"),
	NON_RESIDENTIAL (2, "Service setting, non-residential"),
	RESIDENTIAL (3, "Service setting, residential"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientContactLocation(final Integer code, final String description) {
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
	private static final CodeLookup<ClientContactLocation> enhancer = new CodeLookup<ClientContactLocation>(values());	

	@JsonCreator
	public static ClientContactLocation valueByCode(Integer code) {
		ClientContactLocation value = enhancer.valueByCode(code); 
		return (value == null)?ClientContactLocation.NOT_COLLECTED:value;
	}
}