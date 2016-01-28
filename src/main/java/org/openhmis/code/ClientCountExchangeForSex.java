package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: CountExchangeForSex (2014, 4.35.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientCountExchangeForSex implements BaseCode {
	THREE (1, "1-3"),
	SEVEN (2, "4-7"),
	THIRTY (3, "8-30"),
	OVER_THIRTY (4, "More than 30"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientCountExchangeForSex(final Integer code, final String description) {
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
	private static final CodeLookup<ClientCountExchangeForSex> enhancer = new CodeLookup<ClientCountExchangeForSex>(values());	

	@JsonCreator
	public static ClientCountExchangeForSex valueByCode(Integer code) {
		ClientCountExchangeForSex value = enhancer.valueByCode(code); 
		return (value == null)?ClientCountExchangeForSex.NOT_COLLECTED:value;
	}
}