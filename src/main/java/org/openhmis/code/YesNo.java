package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonValue;

// YesNo are used in several data standard fields:
//  - Race (2014, 3.4)

@JsonSerialize(using = CodeSerializer.class)
public enum YesNo implements BaseCode {
	YES (1, "Full DOB reported"),
	NO (2, "Approximate or Partial DOB reported"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused"),
	NOT_COLLECTED (99, "Data not collected");

	
	private final Integer code;
	private final String description;

	YesNo(final Integer code, final String description) {
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