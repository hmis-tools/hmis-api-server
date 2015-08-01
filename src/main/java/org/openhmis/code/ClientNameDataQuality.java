package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Universal Data Standard: Name (2014, 3.1.5)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientNameDataQuality implements BaseCode {
	FULL (1, "Full name reported"),
	PARTIAL (2, "Partial, street name, or code name reported"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	public final Integer code;
	public final String description;

	ClientNameDataQuality(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	//@JsonValue
	public Integer getCode() {
		return code;
	}
	//@JsonValue
	public String getDescription() {
		return description;
	}
	
	// Enable lookups by code
	private static final CodeLookup<ClientNameDataQuality> enhancer = new CodeLookup<ClientNameDataQuality>(values());	

	@JsonCreator
	public static ClientNameDataQuality valueByCode(Integer code) {
		ClientNameDataQuality value = enhancer.valueByCode(code); 
		return (value == null)?ClientNameDataQuality.NOT_COLLECTED:value;
	}
}