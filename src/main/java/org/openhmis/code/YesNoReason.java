package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// YesNo are used in several data standard fields:
//  - Veteran Status (2014, 3.7)
//  - Disabling Condition (2014, 3.8)

@JsonSerialize(using = CodeSerializer.class)
public enum YesNoReason implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("0")
	NO (0, "No"),
	@XmlEnumValue("1")
	YES (1, "Yes"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	YesNoReason(final Integer code, final String description) {
		this.code = code;
		this.description = description;
	}

	@XmlElement
    public Integer getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
	
	// Enable lookups by code
	private static final CodeLookup<YesNoReason> enhancer = new CodeLookup<YesNoReason>(values());	

	@JsonCreator
	public static YesNoReason valueByCode(Integer code) {
		YesNoReason value = enhancer.valueByCode(code); 
		return (value == null)?YesNoReason.ERR_UNKNOWN:value;
	}
}