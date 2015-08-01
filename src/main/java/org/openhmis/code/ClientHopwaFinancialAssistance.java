package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: HOPWAFinancial Assistance (2014, 4.15.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientHopwaFinancialAssistance implements BaseCode {
	RENTAL_ASSISTANCE (1, "Rental assistance"),
	SECURITY_DEPOSITS (2, "Security deposits"),
	UTILITY_DEPOSITS (3, "Utility deposits"),
	UTILITY_PAYMENTS (4, "Utility payments"),
	MORTGAGE_ASSISTANCE (7, "Mortgage assistance"),
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
		return (value == null)?ClientHopwaFinancialAssistance.NOT_COLLECTED:value;
	}
}