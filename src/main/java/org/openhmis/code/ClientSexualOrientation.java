package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: SexualOrientation (2014, 4.23.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientSexualOrientation implements BaseCode {
	HETEROSEXUAL (1, "Heterosexual"),
	GAY (2, "Gay"),
	LESBIAN (3, "Lesbian"),
	BISEXUAL (4, "Bisexual"),
	UNSURE (5, "Unsure"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientSexualOrientation(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSexualOrientation> enhancer = new CodeLookup<ClientSexualOrientation>(values());	

	@JsonCreator
	public static ClientSexualOrientation valueByCode(Integer code) {
		ClientSexualOrientation value = enhancer.valueByCode(code); 
		return (value == null)?ClientSexualOrientation.NOT_COLLECTED:value;
	}
}