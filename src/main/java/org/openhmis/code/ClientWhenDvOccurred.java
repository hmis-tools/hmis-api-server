package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: WhenDVOccurred (2014, 4.11.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientWhenDvOccurred implements BaseCode {
	THREE_MONTHS (1, "Within the past three months"),
	SIX_MONTHS (2, "Three to six months ago (excluding six months exactly)"),
	ONE_YEAR (3, "Six months to one year ago (excluding one year exactly)"),
	MORE (4, "One year or more"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientWhenDvOccurred(final Integer code, final String description) {
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
	private static final CodeLookup<ClientWhenDvOccurred> enhancer = new CodeLookup<ClientWhenDvOccurred>(values());	

	@JsonCreator
	public static ClientWhenDvOccurred valueByCode(Integer code) {
		ClientWhenDvOccurred value = enhancer.valueByCode(code); 
		return (value == null)?ClientWhenDvOccurred.NOT_COLLECTED:value;
	}
}