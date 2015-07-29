package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: MonthsHomelessPastThreeYears (2014, 3.17.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientMonthsHomelessPastThreeYears implements BaseCode {
	ZERO (100, "0"),
	ONE (101, "1"),
	TWO (102, "2"),
	THREE (103, "3"),
	FOUR (104, "4"),
	FIVE (105, "5"),
	SIX (106, "6"),
	SEVEN (107, "7"),
	EIGHT (108, "8"),
	NINE (109, "9"),
	TEN (110, "10"),
	ELEVEN (111, "11"),
	TWELVE (112, "12"),
	MORE (7, "More than 12 months"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientMonthsHomelessPastThreeYears(final Integer code, final String description) {
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
	private static final CodeLookup<ClientMonthsHomelessPastThreeYears> enhancer = new CodeLookup<ClientMonthsHomelessPastThreeYears>(values());	

	@JsonCreator
	public static ClientMonthsHomelessPastThreeYears valueByCode(Integer code) {
		ClientMonthsHomelessPastThreeYears value = enhancer.valueByCode(code); 
		return (value == null)?ClientMonthsHomelessPastThreeYears.NOT_COLLECTED:value;
	}
}