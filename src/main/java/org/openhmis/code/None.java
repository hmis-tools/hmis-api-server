package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// YesNo are used in several data standard fields:
//  - Veteran Status (2014, 3.7)
//  - Disabling Condition (2014, 3.8)

@JsonSerialize(using = CodeSerializer.class)
public enum None implements BaseCode {
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client Refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	
	private final Integer code;
	private final String description;

	None(final Integer code, final String description) {
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
	private static final CodeLookup<None> enhancer = new CodeLookup<None>(values());

	@JsonCreator
	public static None valueByCode(Integer code) {
		None value = enhancer.valueByCode(code); 
		return (value == null)?None.NOT_COLLECTED:value;
	}
}