package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: AddressDataQuality (2014, 4.43.5)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientSsvfServices implements BaseCode {
	@XmlEnumValue("1")
	OUTREACH (1, "Outreach services"),
	@XmlEnumValue("2")
	CASE_MANAGEMENT (2, "Case management services"),
	@XmlEnumValue("3")
	VA_BENEFITS (3, "Assistance obtaining VA benefits"),
	@XmlEnumValue("4")
	PUBLLIC_BENEFITS (4, "Assistance obtaining/coordinating other public benefits"),
	@XmlEnumValue("5")
	OTHER_BENEFITS (5, "Direct provision of other public benefits"),
	@XmlEnumValue("6")
	OTHER_NON_TFA (6, "Other (non-TFA) supportive service approved by VA"),
	@XmlEnumValue("99")
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