package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: SSVFSubType5 (2014, 4.14.D5)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientSsvfSubType5 implements BaseCode {
	FINANCIAL_PLANNING (1, "Personal financial planning services"),
	TRANSPORTATION (2, "Transportation services"),
	INCOME_SUPPORT (3, "Income support services"),
	FIDUCIARY (4, "Fiduciary and representative payee services"),
	CHILD_SUPPORT (5, "Legal services - child support"),
	EVICTION_PREVENTION (6, "Legal services - eviction prevention"),
	OUTSTANDING_FINES (7, "Legal services - outstanding fines and penalties"),
	LEGAL_OTHER (9, "Legal services - other"),
	CHILD_CARE (10, "Child care"),
	HOUSING_COUNSELING (11, "Housing counseling"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientSsvfSubType5(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSsvfSubType5> enhancer = new CodeLookup<ClientSsvfSubType5>(values());	

	@JsonCreator
	public static ClientSsvfSubType5 valueByCode(Integer code) {
		ClientSsvfSubType5 value = enhancer.valueByCode(code); 
		return (value == null)?ClientSsvfSubType5.NOT_COLLECTED:value;
	}
}