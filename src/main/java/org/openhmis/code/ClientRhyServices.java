package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: RHYServices (2014, 4.14.B)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientRhyServices implements BaseCode {
	BASIC_SUPPORT (1, "Basic support services"),
	CSL (2, "Community service/service learning (CSL)"),
	COUNCELING (3, "Counseling/therapy"),
	DENTAL_CARE (4, "Dental care"),
	EDUCATION (5, "Education"),
	EMPLOYMENT_TRAINING (6, "Employment and training services"),
	CRIMINAL_JUSTICE (7, "Criminal justice /legal services"),
	LIFE_SKILLS (8, "Life skills training"),
	PARENTING_EDUCATION (9, "Parenting education for parent of youth"),
	PARENTING_YOUTH_EDUCATION (10, "Parenting education for youth with children"),
	PEER_COUNCILING (11, "Peer (youth) counseling"),
	POST_NATAL_CARE (12, "Post-natal care"),
	PRE_NATAL_CARE (13, "Pre-natal care"),
	HEALTH_CARE (14, "Health/medical care"),
	PSYCHOLOGICAL_CARE (15, "Psychological or psychiatric care"),
	RECREATIONAL (16, "Recreational activities"),
	SUBSTANCE_ABUSE_TREATMENT (17, "Substance abuse assessment and/or treatment"),
	SUBSTANCE_ABUSE_PREVENTION (18, "Substance abuse prevention"),
	SUPPORT_GROUP (19, "Support group"),
	PREVENTATIVE_OVERNIGHT (20, "Preventative – overnight interim, respite"),
	PREVENTATIVE_PLACEMENT (21, "Preventative – formal placement in an alternative setting outside of BCP"),
	PREVENTATIVE_BCP (22, "Preventative – entry into BCP after preventative services"),
	OUTREACH_HEALTH (23, "Street outreach – health and hygiene products distributed"),
	OUTREACH_FOOD (24, "Street outreach – food and drink items"),
	OUTREACH_SERVICES (25, "Street outreach – services information/brochures"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientRhyServices(final Integer code, final String description) {
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
	private static final CodeLookup<ClientRhyServices> enhancer = new CodeLookup<ClientRhyServices>(values());	

	@JsonCreator
	public static ClientRhyServices valueByCode(Integer code) {
		ClientRhyServices value = enhancer.valueByCode(code); 
		return (value == null)?ClientRhyServices.NOT_COLLECTED:value;
	}
}