package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: PercentAMI (2014, 4.42.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientPercentAmi implements BaseCode {
	THIRTY_PCT (1, "Less than 30%"),
	FIFTY_PCT (2, "30% to 50%"),
	MORE (3, "Greater than 50%"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientPercentAmi(final Integer code, final String description) {
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
	private static final CodeLookup<ClientPercentAmi> enhancer = new CodeLookup<ClientPercentAmi>(values());	

	@JsonCreator
	public static ClientPercentAmi valueByCode(Integer code) {
		ClientPercentAmi value = enhancer.valueByCode(code); 
		return (value == null)?ClientPercentAmi.NOT_COLLECTED:value;
	}
}