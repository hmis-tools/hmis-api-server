package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: HealthStatus (2014, 4.27.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientHealthStatus implements BaseCode {
	@XmlEnumValue("1")
	EXCELLENT (1, "Excellent"),
	@XmlEnumValue("2")
	VERY_GOOD (2, "Very good"),
	@XmlEnumValue("3")
	GOOD (3, "Good"),
	@XmlEnumValue("4")
	FAIR (4, "Fair"),
	@XmlEnumValue("5")
	POOR (5, "Poor"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientHealthStatus(final Integer code, final String description) {
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
	private static final CodeLookup<ClientHealthStatus> enhancer = new CodeLookup<ClientHealthStatus>(values());	

	@JsonCreator
	public static ClientHealthStatus valueByCode(Integer code) {
		ClientHealthStatus value = enhancer.valueByCode(code); 
		return (value == null)?ClientHealthStatus.NOT_COLLECTED:value;
	}
}