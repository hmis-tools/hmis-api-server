package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: SSVFFinancial Assistance (2014, 4.15.B )
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientSsvfFinancialAssistance implements BaseCode {
	RENTAL_ASSISTANCE (1, "Rental assistance"),
	SECURITY_DEPOSIT (2, "Security deposit"),
	UTILITY_DEPOSIT (3, "Utility deposit"),
	UTILITY_FEES (4, "Utility fee payment assistance"),
	MOVING_COSTS (5, "Moving costs"),
	TRANSPORTATION_TOKENS (8, "Transportation services: tokens/vouchers"),
	TRANSPORTATION_REPAIR (9, "Transportation services: vehicle repair/maintenance"),
	CHILD_CARE (10, "Child care"),
	EMERGENCY_SUPPLIES (11, "General housing stability assistance - emergency supplies"),
	OTHER (12, "General housing stability assistance - other"),
	EMERGENCY_ASSISTANCE (14, "Emergency housing assistance"),
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
		return (value == null)?ClientSsvfFinancialAssistance.NOT_COLLECTED:value;
	}
}

