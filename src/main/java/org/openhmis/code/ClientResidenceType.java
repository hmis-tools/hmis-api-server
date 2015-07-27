package org.openhmis.code;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)

@JsonSerialize(using = CodeSerializer.class)
public enum ClientResidenceType implements BaseCode {
	FULL (1, "Full DOB reported"),
	PARTIAL (2, "Approximate or Partial DOB reported"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused");
	
	private final Integer code;
	private final String description;

	ClientResidenceType(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	//@JsonValue
    public Integer getCode() {
        return code;
    }
	//@JsonValue
    public String getDescription() {
        return description;
    }
}