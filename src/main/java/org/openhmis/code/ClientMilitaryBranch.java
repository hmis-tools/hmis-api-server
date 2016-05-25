package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Universal Data Standard: Military Branch (2014, 4.41.11)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientMilitaryBranch implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	ARMY (1, "Army"),
	@XmlEnumValue("2")
	AIR_FORCE (2, "Air Force"),
	@XmlEnumValue("3")
	NAVY (3, "Navy"),
	@XmlEnumValue("4")
	MARINES (4, "Marines"),
	@XmlEnumValue("6")
	COAST_GUARD (6, "Coast Guard"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn’t know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientMilitaryBranch(final Integer code, final String description) {
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
	private static final CodeLookup<ClientMilitaryBranch> enhancer = new CodeLookup<ClientMilitaryBranch>(values());	

	@JsonCreator
	public static ClientMilitaryBranch valueByCode(Integer code) {
		ClientMilitaryBranch value = enhancer.valueByCode(code);
		return (value == null)?ClientMilitaryBranch.ERR_UNKNOWN:value;
	}
}