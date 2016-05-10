package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ProjectCompletionStatus (2014, 4.37.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientProjectCompletionStatus implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	COMPLETED (1, "Completed project"),
	@XmlEnumValue("2")
	LEFT (2, "Youth voluntarily left early"),
	@XmlEnumValue("3")
	EXPELLED (3, "Youth was expelled or otherwise involuntarily discharged from project"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientProjectCompletionStatus(final Integer code, final String description) {
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
	private static final CodeLookup<ClientProjectCompletionStatus> enhancer = new CodeLookup<ClientProjectCompletionStatus>(values());	

	@JsonCreator
	public static ClientProjectCompletionStatus valueByCode(Integer code) {
		ClientProjectCompletionStatus value = enhancer.valueByCode(code); 
		return (value == null)?ClientProjectCompletionStatus.ERR_UNKNOWN:value;
	}
}