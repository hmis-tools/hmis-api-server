package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: SubsidyInformation (2014, 4.19.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientSubsidyInformation implements BaseCode {
	NO_SUBSIDY (1, "Without a subsidy"),
	ENTRY_SUBSIDY (2, "With the subsidy they had at project entry"),
	ACQUIRED_SUBSIDY (3, "With an on-going subsidy acquired since project entry"),
	OTHER_ASSISTANCE (4, "But only with other financial assistance"),
	WITH_SUBSIDY (11, "With on-going subsidy"),
	NO_SUBSIDY_2 (12, "Without an on-going subsidy"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientSubsidyInformation(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSubsidyInformation> enhancer = new CodeLookup<ClientSubsidyInformation>(values());	

	@JsonCreator
	public static ClientSubsidyInformation valueByCode(Integer code) {
		ClientSubsidyInformation value = enhancer.valueByCode(code); 
		return (value == null)?ClientSubsidyInformation.NOT_COLLECTED:value;
	}
}