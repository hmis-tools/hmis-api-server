package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: AddressDataQuality (2014, 4.43.5)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientAddressDataQuality implements BaseCode {
	FULL_ADDRESS (1, "Full address"),
	INCOMPLETE (2, "Incomplete or estimated address"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientAddressDataQuality(final Integer code, final String description) {
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
	private static final CodeLookup<ClientAddressDataQuality> enhancer = new CodeLookup<ClientAddressDataQuality>(values());	

	@JsonCreator
	public static ClientAddressDataQuality valueByCode(Integer code) {
		ClientAddressDataQuality value = enhancer.valueByCode(code); 
		return (value == null)?ClientAddressDataQuality.NOT_COLLECTED:value;
	}
}