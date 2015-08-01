package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: TimesHomelessPastThreeYears (2014, 3.17.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientTimesHomelessPastThreeYears implements BaseCode {
	ZERO (0, "0 (not homeless - Prevention only)"),
	ONE (1, "1 (homeless only this time)"),
	TWO (2, "2"),
	THREE (3, "3"),
	MORE (4, "4 or more"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientTimesHomelessPastThreeYears(final Integer code, final String description) {
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
	private static final CodeLookup<ClientTimesHomelessPastThreeYears> enhancer = new CodeLookup<ClientTimesHomelessPastThreeYears>(values());	

	@JsonCreator
	public static ClientTimesHomelessPastThreeYears valueByCode(Integer code) {
		ClientTimesHomelessPastThreeYears value = enhancer.valueByCode(code); 
		return (value == null)?ClientTimesHomelessPastThreeYears.NOT_COLLECTED:value;
	}
}