package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ExitAction (2014, 4.36.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientExitAction implements BaseCode {
	@XmlEnumValue("0")
	NO (0, "No"),
	@XmlEnumValue("1")
	YES (1, "Yes"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientExitAction(final Integer code, final String description) {
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
	private static final CodeLookup<ClientExitAction> enhancer = new CodeLookup<ClientExitAction>(values());	

	@JsonCreator
	public static ClientExitAction valueByCode(Integer code) {
		ClientExitAction value = enhancer.valueByCode(code); 
		return (value == null)?ClientExitAction.NOT_COLLECTED:value;
	}
}