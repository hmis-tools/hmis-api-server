package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: RHYServices (2014, 4.14.B)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientRhyServices implements BaseCode {
	@XmlEnumValue("1")
	BASIC_SUPPORT (1, "Basic support services"),
	@XmlEnumValue("2")
	CSL (2, "Community service/service learning (CSL)"),
	@XmlEnumValue("3")
	COUNCELING (3, "Counseling/therapy"),
	@XmlEnumValue("4")
	DENTAL_CARE (4, "Dental care"),
	@XmlEnumValue("5")
	EDUCATION (5, "Education"),
	@XmlEnumValue("6")
	EMPLOYMENT_TRAINING (6, "Employment and training services"),
	@XmlEnumValue("7")
	CRIMINAL_JUSTICE (7, "Criminal justice /legal services"),
	@XmlEnumValue("8")
	LIFE_SKILLS (8, "Life skills training"),
	@XmlEnumValue("9")
	PARENTING_EDUCATION (9, "Parenting education for parent of youth"),
	@XmlEnumValue("10")
	PARENTING_YOUTH_EDUCATION (10, "Parenting education for youth with children"),
	@XmlEnumValue("11")
	PEER_COUNCILING (11, "Peer (youth) counseling"),
	@XmlEnumValue("12")
	POST_NATAL_CARE (12, "Post-natal care"),
	@XmlEnumValue("13")
	PRE_NATAL_CARE (13, "Pre-natal care"),
	@XmlEnumValue("14")
	HEALTH_CARE (14, "Health/medical care"),
	@XmlEnumValue("15")
	PSYCHOLOGICAL_CARE (15, "Psychological or psychiatric care"),
	@XmlEnumValue("16")
	RECREATIONAL (16, "Recreational activities"),
	@XmlEnumValue("17")
	SUBSTANCE_ABUSE_TREATMENT (17, "Substance abuse assessment and/or treatment"),
	@XmlEnumValue("18")
	SUBSTANCE_ABUSE_PREVENTION (18, "Substance abuse prevention"),
	@XmlEnumValue("19")
	SUPPORT_GROUP (19, "Support group"),
	@XmlEnumValue("20")
	PREVENTATIVE_OVERNIGHT (20, "Preventative – overnight interim, respite"),
	@XmlEnumValue("21")
	PREVENTATIVE_PLACEMENT (21, "Preventative – formal placement in an alternative setting outside of BCP"),
	@XmlEnumValue("22")
	PREVENTATIVE_BCP (22, "Preventative – entry into BCP after preventative services"),
	@XmlEnumValue("23")
	OUTREACH_HEALTH (23, "Street outreach – health and hygiene products distributed"),
	@XmlEnumValue("24")
	OUTREACH_FOOD (24, "Street outreach – food and drink items"),
	@XmlEnumValue("25")
	OUTREACH_SERVICES (25, "Street outreach – services information/brochures"),
	@XmlEnumValue("99")
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