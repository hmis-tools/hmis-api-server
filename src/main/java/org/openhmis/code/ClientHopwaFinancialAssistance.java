package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: HOPWAFinancial Assistance (2014, 4.15.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientHopwaFinancialAssistance implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	RENTAL_ASSISTANCE (1, "Rental assistance"),
	@XmlEnumValue("2")
	SECURITY_DEPOSITS (2, "Security deposits"),
	@XmlEnumValue("3")
	UTILITY_DEPOSITS (3, "Utility deposits"),
	@XmlEnumValue("4")
	UTILITY_PAYMENTS (4, "Utility payments"),
	@XmlEnumValue("7")
	MORTGAGE_ASSISTANCE (7, "Mortgage assistance"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientHopwaFinancialAssistance(final Integer code, final String description) {
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
	private static final CodeLookup<ClientHopwaFinancialAssistance> enhancer = new CodeLookup<ClientHopwaFinancialAssistance>(values());	

	@JsonCreator
	public static ClientHopwaFinancialAssistance valueByCode(Integer code) {
		ClientHopwaFinancialAssistance value = enhancer.valueByCode(code); 
		return (value == null)?ClientHopwaFinancialAssistance.ERR_UNKNOWN:value;
	}
}