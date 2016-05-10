package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: HOPWAServices (2014, 4.14.C)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientHopwaServices implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	PERSONAL_ASSISTANCE (1, "Adult day care and personal assistance"),
	@XmlEnumValue("2")
	CASE_MANAGEMENT (2, "Case management"),
	@XmlEnumValue("3")
	CHILD_CARE (3, "Child care"),
	@XmlEnumValue("4")
	CRIMINAL_JUSTICE (4, "Criminal justice/legal services"),
	@XmlEnumValue("5")
	EDUCATION (5, "Education"),
	@XmlEnumValue("6")
	EMPLOYMENT (6, "Employment and training services"),
	@XmlEnumValue("7")
	FOOD (7, "Food/meals/nutritional services"),
	@XmlEnumValue("8")
	MEDICAL_CARE (8, "Health/medical care"),
	@XmlEnumValue("9")
	LIFE_SKILLS (9, "Life skills training"),
	@XmlEnumValue("10")
	MENTAL_HEALTH (10, "Mental health care/counseling"),
	@XmlEnumValue("11")
	OUTREACH (11, "Outreach and/or engagement"),
	@XmlEnumValue("12")
	SUBSTANCE_ABUSE (12, "Substance abuse services/treatment"),
	@XmlEnumValue("13")
	TRANSPORTATION (13, "Transportation"),
	@XmlEnumValue("14")
	HOPWA_OTHER (14, "Other HOPWA funded service"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientHopwaServices(final Integer code, final String description) {
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
	private static final CodeLookup<ClientHopwaServices> enhancer = new CodeLookup<ClientHopwaServices>(values());	

	@JsonCreator
	public static ClientHopwaServices valueByCode(Integer code) {
		ClientHopwaServices value = enhancer.valueByCode(code); 
		return (value == null)?ClientHopwaServices.ERR_UNKNOWN:value;
	}
}