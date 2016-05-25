package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: SSVFSubType4 (2014, 4.14.D4)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientSsvfSubType4 implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	HEALTH_CARE (1, "Health care services"),
	@XmlEnumValue("2")
	DAILY_LIVING (2, "Daily living services"),
	@XmlEnumValue("3")
	FINANCIAL_PLANNING (3, "Personal financial planning services"),
	@XmlEnumValue("4")
	TRANSPORTATION (4, "Transportation services"),
	@XmlEnumValue("5")
	INCOME_SUPPORT (5, "Income support services"),
	@XmlEnumValue("6")
	FIDUCIARY (6, "Fiduciary and representative payee services"),
	@XmlEnumValue("7")
	CHILD_SUPPORT (7, "Legal services - child support"),
	@XmlEnumValue("8")
	EVICTION_PREVENTION (8, "Legal services - eviction prevention"),
	@XmlEnumValue("9")
	OUTSTANDING_FINES (9, "Legal services - outstanding fines and penalties"),
	@XmlEnumValue("10")
	DRIVERS_LICENSE (10, "Legal services - restore / acquire driver’s license"),
	@XmlEnumValue("11")
	LEGAL_OTHER (11, "Legal services - other"),
	@XmlEnumValue("12")
	CHILD_CARE (12, "Child care"),
	@XmlEnumValue("13")
	HOUSING_COUNSELING (13, "Housing counseling"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientSsvfSubType4(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSsvfSubType4> enhancer = new CodeLookup<ClientSsvfSubType4>(values());	

	@JsonCreator
	public static ClientSsvfSubType4 valueByCode(Integer code) {
		ClientSsvfSubType4 value = enhancer.valueByCode(code); 
		return (value == null)?ClientSsvfSubType4.ERR_UNKNOWN:value;
	}
}