package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: HOPWAServices (2014, 4.14.C)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientHopwaServices implements BaseCode {
	PERSONAL_ASSISTANCE (1, "Adult day care and personal assistance"),
	CASE_MANAGEMENT (2, "Case management"),
	CHILD_CARE (3, "Child care"),
	CRIMINAL_JUSTICE (4, "Criminal justice/legal services"),
	EDUCATION (5, "Education"),
	EMPLOYMENT (6, "Employment and training services"),
	FOOD (7, "Food/meals/nutritional services"),
	MEDICAL_CARE (8, "Health/medical care"),
	LIFE_SKILLS (9, "Life skills training"),
	MENTAL_HEALTH (10, "Mental health care/counseling"),
	OUTREACH (11, "Outreach and/or engagement"),
	SUBSTANCE_ABUSE (12, "Substance abuse services/treatment"),
	TRANSPORTATION (13, "Transportation"),
	HOPWA_OTHER (14, "Other HOPWA funded service"),
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
		return (value == null)?ClientHopwaServices.NOT_COLLECTED:value;
	}
}