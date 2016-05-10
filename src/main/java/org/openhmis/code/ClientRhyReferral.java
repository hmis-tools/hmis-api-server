package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: RHYReferral (2014, 4.16.B)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientRhyReferral implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	CHILD_CARE (1, "Child care non-TANF"),
	@XmlEnumValue("2")
	SUPPLEMENTAL_NUTRITION (2, "Supplemental nutritional assistance program (food stamps)"),
	@XmlEnumValue("3")
	EDUCATION (3, "Education - McKinney/Vento liaison assistance to remain in school"),
	@XmlEnumValue("4")
	PERMANENT_HOUSING (4, "HUD section 8 or other permanent housing assistance"),
	@XmlEnumValue("5")
	INDIVIDUAL_DEVELOPMENT (5, "Individual development account"),
	@XmlEnumValue("6")
	MEDICAID (6, "Medicaid"),
	@XmlEnumValue("7")
	MENTORING (7, "Mentoring program other than RHY agency"),
	@XmlEnumValue("8")
	NATIONAL_SERVICE (8, "National service (Americorps, VISTA, Learn and Serve)"),
	@XmlEnumValue("9")
	SUBSTANCE_ABUSE (9, "Non-residential substance abuse or mental health program"),
	@XmlEnumValue("10")
	OTHER_PROGRAM (10, "Other public - federal, state, or local program"),
	@XmlEnumValue("11")
	PRIVATE_CHARITY (11, "Private non-profit charity or foundation support"),
	@XmlEnumValue("12")
	SCHIP (12, "SCHIP"),
	@XmlEnumValue("13")
	DISABILITY_INSURANCE (13, "SSI, SSDI, or other disability insurance"),
	@XmlEnumValue("14")
	TANF (14, "TANF or other welfare/non-disability income maintenance (all TANF services)"),
	@XmlEnumValue("15")
	UNEMPLOYMENT_INSURANCE (15, "Unemployment insurance"),
	@XmlEnumValue("16")
	WIC (16, "WIC"),
	@XmlEnumValue("17")
	WIA (17, "Workforce development (WIA)"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientRhyReferral(final Integer code, final String description) {
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
	private static final CodeLookup<ClientRhyReferral> enhancer = new CodeLookup<ClientRhyReferral>(values());	

	@JsonCreator
	public static ClientRhyReferral valueByCode(Integer code) {
		ClientRhyReferral value = enhancer.valueByCode(code); 
		return (value == null)?ClientRhyReferral.ERR_UNKNOWN:value;
	}
}