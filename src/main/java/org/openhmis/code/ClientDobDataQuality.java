package org.openhmis.code;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Universal Data Standard: Date of Birth (2014, 3.3.2)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientDobDataQuality implements BaseCode {
	FULL (1, "Full DOB reported"),
	PARTIAL (2, "Approximate or Partial DOB reported"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	protected final Integer code;
	protected final String description;

	ClientDobDataQuality(final Integer code, final String description) {
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
	private static final CodeLookup<ClientDobDataQuality> enhancer = new CodeLookup<ClientDobDataQuality>(values());	
	public static ClientDobDataQuality valueByCode(Integer code) {
		return enhancer.valueByCode(code);
	}
}