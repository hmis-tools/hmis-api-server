package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: RHYReferral (2014, 4.16.B)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientRhyReferral implements BaseCode {
	CHILD_CARE (1, "Child care non-TANF"),
	SUPPLEMENTAL_NUTRITION (2, "Supplemental nutritional assistance program (food stamps)"),
	EDUCATION (3, "Education - McKinney/Vento liaison assistance to remain in school"),
	PERMANENT_HOUSING (4, "HUD section 8 or other permanent housing assistance"),
	INDIVIDUAL_DEVELOPMENT (5, "Individual development account"),
	MEDICAID (6, "Medicaid"),
	MENTORING (7, "Mentoring program other than RHY agency"),
	NATIONAL_SERVICE (8, "National service (Americorps, VISTA, Learn and Serve)"),
	SUBSTANCE_ABUSE (9, "Non-residential substance abuse or mental health program"),
	OTHER_PROGRAM (10, "Other public - federal, state, or local program"),
	PRIVATE_CHARITY (11, "Private non-profit charity or foundation support"),
	SCHIP (12, "SCHIP"),
	DISABILITY_INSURANCE (13, "SSI, SSDI, or other disability insurance"),
	TANF (14, "TANF or other welfare/non-disability income maintenance (all TANF services)"),
	UNEMPLOYMENT_INSURANCE (15, "Unemployment insurance"),
	WIC (16, "WIC"),
	WIA (17, "Workforce development (WIA)"),
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
		return (value == null)?ClientRhyReferral.NOT_COLLECTED:value;
	}
}