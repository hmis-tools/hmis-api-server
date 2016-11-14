package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;


@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ConsentApprovalStatus implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("pending")
	PENDING (0, "pending"),
	@XmlEnumValue("approved")
	APPROVED (1, "approved"),
	@XmlEnumValue("rejected")
	REJECTED (2, "rejected");
	
	private final Integer code;
	private final String description;

	ConsentApprovalStatus(final Integer code, final String description) {
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
	private static final CodeLookup<ConsentApprovalStatus> enhancer = new CodeLookup<ConsentApprovalStatus>(values());	

	@JsonCreator
	public static ConsentApprovalStatus valueByCode(Integer code) {
		ConsentApprovalStatus value = enhancer.valueByCode(code); 
		return (value == null)?ConsentApprovalStatus.ERR_UNKNOWN:value;
	}
}