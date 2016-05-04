package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: SSVFSubType5 (2014, 4.14.D5)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientSsvfSubType5 implements BaseCode {
	@XmlEnumValue("1")
	FINANCIAL_PLANNING (1, "Personal financial planning services"),
	@XmlEnumValue("2")
	TRANSPORTATION (2, "Transportation services"),
	@XmlEnumValue("3")
	INCOME_SUPPORT (3, "Income support services"),
	@XmlEnumValue("4")
	FIDUCIARY (4, "Fiduciary and representative payee services"),
	@XmlEnumValue("5")
	CHILD_SUPPORT (5, "Legal services - child support"),
	@XmlEnumValue("6")
	EVICTION_PREVENTION (6, "Legal services - eviction prevention"),
	@XmlEnumValue("7")
	OUTSTANDING_FINES (7, "Legal services - outstanding fines and penalties"),
	@XmlEnumValue("9")
	LEGAL_OTHER (9, "Legal services - other"),
	@XmlEnumValue("10")
	CHILD_CARE (10, "Child care"),
	@XmlEnumValue("11")
	HOUSING_COUNSELING (11, "Housing counseling"),
	@XmlEnumValue("99")
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