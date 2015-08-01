package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: AddressDataQuality (2014, 4.43.5)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientSsvfServices implements BaseCode {
	OUTREACH (1, "Outreach services"),
	CASE_MANAGEMENT (2, "Case management services"),
	VA_BENEFITS (3, "Assistance obtaining VA benefits"),
	PUBLLIC_BENEFITS (4, "Assistance obtaining/coordinating other public benefits"),
	OTHER_BENEFITS (5, "Direct provision of other public benefits"),
	OTHER_NON_TFA (6, "Other (non-TFA) supportive service approved by VA"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientSsvfServices(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSsvfServices> enhancer = new CodeLookup<ClientSsvfServices>(values());	

	@JsonCreator
	public static ClientSsvfServices valueByCode(Integer code) {
		ClientSsvfServices value = enhancer.valueByCode(code); 
		return (value == null)?ClientSsvfServices.NOT_COLLECTED:value;
	}
}