package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: MonthsHomelessPastThreeYears (2014, 3.17.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientMonthsHomelessPastThreeYears implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("0")
	ZERO (100, "0"),
	@XmlEnumValue("1")
	ONE (101, "1"),
	@XmlEnumValue("2")
	TWO (102, "2"),
	@XmlEnumValue("3")
	THREE (103, "3"),
	@XmlEnumValue("4")
	FOUR (104, "4"),
	@XmlEnumValue("5")
	FIVE (105, "5"),
	@XmlEnumValue("6")
	SIX (106, "6"),
	@XmlEnumValue("7")
	SEVEN (107, "7"),
	@XmlEnumValue("8")
	EIGHT (108, "8"),
	@XmlEnumValue("9")
	NINE (109, "9"),
	@XmlEnumValue("10")
	TEN (110, "10"),
	@XmlEnumValue("11")
	ELEVEN (111, "11"),
	@XmlEnumValue("12")
	TWELVE (112, "12"),
	@XmlEnumValue("7")
	MORE (7, "More than 12 months"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
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
		return (value == null)?ClientMonthsHomelessPastThreeYears.ERR_UNKNOWN:value;
	}
}