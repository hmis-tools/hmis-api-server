package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.openhmis.code.serialization.CodeLookup;

// YesNo are used in several data standard fields:
//  - Race (2014, 3.4)

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum YesNo implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),

	@XmlEnumValue("0")
	NO (0, "No"),
	@XmlEnumValue("1")
	YES (1, "Yes"),
	@XmlEnumValue("99")
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
		return (value == null)?YesNo.ERR_UNKNOWN:value;
	}
}