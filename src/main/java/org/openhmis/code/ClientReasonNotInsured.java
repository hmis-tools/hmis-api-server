package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ReasonNotInsured (2014, 4.4.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientReasonNotInsured implements BaseCode {
	@XmlEnumValue("1")
	APPLIED_PENDING (1, "Applied; decision pending"),
	@XmlEnumValue("2")
	APPLIED_INELIGIBLE (2, "Applied; client not eligible"),
	@XmlEnumValue("3")
	NOT_APPLIED (3, "Client did not apply"),
	@XmlEnumValue("4")
	NA (4, "Insurance type n/a for this client"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientReasonNotInsured(final Integer code, final String description) {
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
	private static final CodeLookup<ClientReasonNotInsured> enhancer = new CodeLookup<ClientReasonNotInsured>(values());	

	@JsonCreator
	public static ClientReasonNotInsured valueByCode(Integer code) {
		ClientReasonNotInsured value = enhancer.valueByCode(code); 
		return (value == null)?ClientReasonNotInsured.NOT_COLLECTED:value;
	}
}