package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Universal Data Standard: Discharge Status (2014, 4.41.12)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientDischargeStatus implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	HONORABLE (1, "Honorable"),
	@XmlEnumValue("2")
	GENERAL_HONORABLE (2, "General under honorable conditions"),
	@XmlEnumValue("4")
	BAD_CONDUCT (4, "Bad conduct"),
	@XmlEnumValue("5")
	DISHONORABLE (5, "Dishonorable"),
	@XmlEnumValue("6")
	OTH (6, "Under other than honorable conditions (OTH)"),
	@XmlEnumValue("7")
	UNCHARACTERIZED (7, "Uncharacterized"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientDischargeStatus(final Integer code, final String description) {
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
	private static final CodeLookup<ClientDischargeStatus> enhancer = new CodeLookup<ClientDischargeStatus>(values());	

	@JsonCreator
	public static ClientDischargeStatus valueByCode(Integer code) {
		ClientDischargeStatus value = enhancer.valueByCode(code); 
		return (value == null)?ClientDischargeStatus.ERR_UNKNOWN:value;
	}
}