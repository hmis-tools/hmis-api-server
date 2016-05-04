package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ResidencePriorLengthOfStay (2014, 3.9.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientResidencePriorLengthOfStay implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("2")
	ONE_MONTH (2, "More than one week, but less than one month"),
	@XmlEnumValue("3")
	THREE_MONTHS (3, "One to three months"),
	@XmlEnumValue("4")
	ONE_YEAR (4, "More than three months, but less than one year"),
	@XmlEnumValue("5")
	MORE_YEAR (5, "One year or longer"),
	@XmlEnumValue("10")
	LESS_DAYS (10, "Less than 2 days"),
	@XmlEnumValue("11")
	ONE_WEEK (11, "Two days to one week"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
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
		return (value == null)?ClientResidencePriorLengthOfStay.ERR_UNKNOWN:value;
	}
}