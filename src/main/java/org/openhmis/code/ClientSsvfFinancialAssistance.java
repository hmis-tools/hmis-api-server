package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: SSVFFinancial Assistance (2014, 4.15.B )
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientSsvfFinancialAssistance implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	RENTAL_ASSISTANCE (1, "Rental assistance"),
	@XmlEnumValue("2")
	SECURITY_DEPOSIT (2, "Security deposit"),
	@XmlEnumValue("3")
	UTILITY_DEPOSIT (3, "Utility deposit"),
	@XmlEnumValue("4")
	UTILITY_FEES (4, "Utility fee payment assistance"),
	@XmlEnumValue("5")
	MOVING_COSTS (5, "Moving costs"),
	@XmlEnumValue("8")
	TRANSPORTATION_TOKENS (8, "Transportation services: tokens/vouchers"),
	@XmlEnumValue("9")
	TRANSPORTATION_REPAIR (9, "Transportation services: vehicle repair/maintenance"),
	@XmlEnumValue("10")
	CHILD_CARE (10, "Child care"),
	@XmlEnumValue("11")
	EMERGENCY_SUPPLIES (11, "General housing stability assistance - emergency supplies"),
	@XmlEnumValue("12")
	OTHER (12, "General housing stability assistance - other"),
	@XmlEnumValue("14")
	EMERGENCY_ASSISTANCE (14, "Emergency housing assistance"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientSsvfFinancialAssistance(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSsvfFinancialAssistance> enhancer = new CodeLookup<ClientSsvfFinancialAssistance>(values());	

	@JsonCreator
	public static ClientSsvfFinancialAssistance valueByCode(Integer code) {
		ClientSsvfFinancialAssistance value = enhancer.valueByCode(code); 
		return (value == null)?ClientSsvfFinancialAssistance.ERR_UNKNOWN:value;
	}
}

