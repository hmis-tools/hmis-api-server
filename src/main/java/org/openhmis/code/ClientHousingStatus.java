package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: HousingStatus (2014, 4.1.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientHousingStatus implements BaseCode {
	@XmlEnumValue("1")
	CATEGORY_1 (1, "Category 1 - Homeless"),
	@XmlEnumValue("2")
	CATEGORY_2 (2, "Category 2 - At imminent risk of losing housing"),
	@XmlEnumValue("3")
	AT_RISK (3, "At-risk of homelessness - prevention programs only"),
	@XmlEnumValue("4")
	STABLY_HOUSED (4, "Stably housed"),
	@XmlEnumValue("5")
	CATEGORY_3 (5, "Category 3 - Homeless only under other federal statutes"),
	@XmlEnumValue("6")
	CATEGORY_4 (6, "Category 4 - Fleeing domestic violence"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientHousingStatus(final Integer code, final String description) {
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
	private static final CodeLookup<ClientHousingStatus> enhancer = new CodeLookup<ClientHousingStatus>(values());	

	@JsonCreator
	public static ClientHousingStatus valueByCode(Integer code) {
		ClientHousingStatus value = enhancer.valueByCode(code); 
		return (value == null)?ClientHousingStatus.NOT_COLLECTED:value;
	}
}