package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// YesNo are used in several data standard fields:
//  - Race (2014, 3.4)

@JsonSerialize(using = CodeSerializer.class)
public enum YesNo implements BaseCode {
	NO (0, "No"),
	YES (1, "Yes"),
	NOT_COLLECTED (99, "Data not collected");

	private final Integer code;
	private final String description;

	YesNo(final Integer code, final String description) {
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
	private static final CodeLookup<YesNo> enhancer = new CodeLookup<YesNo>(values());	

	@JsonCreator
	public static YesNo valueByCode(Integer code) {
		YesNo value = enhancer.valueByCode(code); 
		return (value == null)?YesNo.NOT_COLLECTED:value;
	}
}