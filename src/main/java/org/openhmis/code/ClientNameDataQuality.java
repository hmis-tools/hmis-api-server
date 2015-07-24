package org.openhmis.code;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.openhmis.code.serialization.CodeSerializer;

// Codes for Universal Data Standard: Name (2014, 3.1)

@JsonSerialize(using = CodeSerializer.class)
public enum ClientNameDataQuality {
	FULL (1, "Full name reported"),
	PARTIAL (2, "Partial, street name, or code name reported"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused");
	
	public final Integer code;
	public final String description;

	ClientNameDataQuality(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

    public Integer getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }

	/** Enable Reverse Lookup. */
	public static ClientNameDataQuality get(int code) { 
		for(ClientNameDataQuality s : values()) {
			if(s.code == code) return s;
		}
		return null;
	}
}