package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Universal Data Standard: Discharge Status (2014, 4.41.12)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientDischargeStatus implements BaseCode {
	HONORABLE (1, "Honorable"),
	GENERAL_HONORABLE (2, "General under honorable conditions"),
	BAD_CONDUCT (4, "Bad conduct"),
	DISHONORABLE (5, "Dishonorable"),
	OTH (6, "Under other than honorable conditions (OTH)"),
	UNCHARACTERIZED (7, "Uncharacterized"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
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
		return (value == null)?ClientDischargeStatus.NOT_COLLECTED:value;
	}
}