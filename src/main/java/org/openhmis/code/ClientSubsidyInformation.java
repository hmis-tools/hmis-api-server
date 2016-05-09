package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: SubsidyInformation (2014, 4.19.A)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientSubsidyInformation implements BaseCode {
	@XmlEnumValue("1")
	NO_SUBSIDY (1, "Without a subsidy"),
	@XmlEnumValue("2")
	ENTRY_SUBSIDY (2, "With the subsidy they had at project entry"),
	@XmlEnumValue("3")
	ACQUIRED_SUBSIDY (3, "With an on-going subsidy acquired since project entry"),
	@XmlEnumValue("4")
	OTHER_ASSISTANCE (4, "But only with other financial assistance"),
	@XmlEnumValue("11")
	WITH_SUBSIDY (11, "With on-going subsidy"),
	@XmlEnumValue("12")
	NO_SUBSIDY_2 (12, "Without an on-going subsidy"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientSubsidyInformation(final Integer code, final String description) {
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
	private static final CodeLookup<ClientSubsidyInformation> enhancer = new CodeLookup<ClientSubsidyInformation>(values());	

	@JsonCreator
	public static ClientSubsidyInformation valueByCode(Integer code) {
		ClientSubsidyInformation value = enhancer.valueByCode(code); 
		return (value == null)?ClientSubsidyInformation.NOT_COLLECTED:value;
	}
}