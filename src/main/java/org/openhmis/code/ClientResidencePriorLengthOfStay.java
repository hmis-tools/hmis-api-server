package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ResidencePriorLengthOfStay (2014, 3.9.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientResidencePriorLengthOfStay implements BaseCode {
	ONE_MONTH (2, "More than one week, but less than one month"),
	THREE_MONTHS (3, "One to three months"),
	ONE_YEAR (4, "More than three months, but less than one year"),
	MORE_YEAR (5, "One year or longer"),
	LESS_DAYS (10, "Less than 2 days"),
	ONE_WEEK (11, "Two days to one week"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientResidencePriorLengthOfStay(final Integer code, final String description) {
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
	private static final CodeLookup<ClientResidencePriorLengthOfStay> enhancer = new CodeLookup<ClientResidencePriorLengthOfStay>(values());	

	@JsonCreator
	public static ClientResidencePriorLengthOfStay valueByCode(Integer code) {
		ClientResidencePriorLengthOfStay value = enhancer.valueByCode(code); 
		return (value == null)?ClientResidencePriorLengthOfStay.NOT_COLLECTED:value;
	}
}