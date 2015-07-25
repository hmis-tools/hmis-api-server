package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonValue;

// Codes for Universal Data Standard: Discharge Status (2014, 4.41.12)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

public enum ClientDischargeStatus implements BaseCode {
	HONORABLE (1, "Honorable"),
	GENERAL_HONORABLE (2, "General under honorable conditions"),
	BAD_CONDUCT (4, "Bad conduct"),
	DISHONORABLE (5, "Dishonorable"),
	OTH (6, "Under other than honorable conditions (OTH)"),
	UNCHARACTERIZED (7, "Uncharacterized"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientDischargeStatus(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	@JsonValue
    public Integer getCode() {
        return code;
    }
	@JsonValue
    public String getDescription() {
        return description;
    }
}