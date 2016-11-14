package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;


@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ConsentRequestType implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("not-share")
	NOT_SHARE (0, "not-share"),
	@XmlEnumValue("share")
	SHARE (1, "share");
	
	private final Integer code;
	private final String description;

	ConsentRequestType(final Integer code, final String description) {
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
	private static final CodeLookup<ConsentRequestType> enhancer = new CodeLookup<ConsentRequestType>(values());	

	@JsonCreator
	public static ConsentRequestType valueByCode(Integer code) {
		ConsentRequestType value = enhancer.valueByCode(code); 
		return (value == null)?ConsentRequestType.ERR_UNKNOWN:value;
	}
}