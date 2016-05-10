package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ReferralSource (2014, 4.34.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientReferralSource implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	SELF (1, "Self-referral"),
	@XmlEnumValue("2")
	PARENT (2, "Individual: parent/guardian"),
	@XmlEnumValue("3")
	RELATIVE (3, "Individual: relative or friend"),
	@XmlEnumValue("3")
	INDIVIDUAL_OTHER (4, "Individual: other adult or youth"),
	@XmlEnumValue("5")
	PARTNER (5, "Individual: partner/spouse"),
	@XmlEnumValue("6")
	FOSTER_PARENT (6, "Individual: foster parent"),
	@XmlEnumValue("7")
	FYSB (7, "Outreach project: FYSB"),
	@XmlEnumValue("10")
	OUTREACH_OTHER (10, "Outreach project: other"),
	@XmlEnumValue("11")
	FYSB_CENTER (11, "Temporary shelter: FYSB basic center project"),
	@XmlEnumValue("12")
	YOUTH_SHELTER (12, "Temporary shelter: other youth only emergency shelter"),
	@XmlEnumValue("13")
	FAMILY_SHELTER (13, "Temporary shelter: emergency shelter for families"),
	@XmlEnumValue("14")
	INDIVIDUAL_SHELTER (14, "Temporary shelter: emergency shelter for individuals"),
	@XmlEnumValue("15")
	DV_SHELTER (15, "Temporary shelter: domestic violence shelter"),
	@XmlEnumValue("16")
	SAFE_PLACE (16, "Temporary shelter: safe place"),
	@XmlEnumValue("17")
	SHELTER_OTHER (17, "Temporary shelter: other"),
	@XmlEnumValue("18")
	FYSB_PROJECT (18, "Residential project: FYSB transitional living project"),
	@XmlEnumValue("19")
	TRANSITIONAL (19, "Residential project: other transitional living project"),
	@XmlEnumValue("20")
	GROUP_HOME (20, "Residential project: group home"),
	@XmlEnumValue("21")
	INDEPENDENT_PROJECT (21, "Residential project: independent living project"),
	@XmlEnumValue("22")
	JOB_CORPS (22, "Residential project: job corps"),
	@XmlEnumValue("23")
	DRUG_CENTER (23, "Residential project: drug treatment center"),
	@XmlEnumValue("24")
	TREATMENT_CENTER (24, "Residential project: treatment center"),
	@XmlEnumValue("25")
	EDUCATIONAL (25, "Residential project: educational institute"),
	@XmlEnumValue("26")
	AGENCY_PROJECT_OTHER (26, "Residential project: other agency project"),
	@XmlEnumValue("27")
	PROJECT_OTHER (27, "Residential project: other project"),
	@XmlEnumValue("28")
	NATIONAL_RUNAWAY (28, "Hotline: national runaway switchboard"),
	@XmlEnumValue("29")
	HOTLINE_OTHER (29, "Hotline: other"),
	@XmlEnumValue("30")
	CHILD_WELFARE (30, "Other agency: child welfare/CPS"),
	@XmlEnumValue("31")
	INDEPENDENT_LIVING (31, "Other agency: non-residential independent living project"),
	@XmlEnumValue("32")
	AGENCY_OTHER (32, "Other project operated by your agency"),
	@XmlEnumValue("33")
	YOUTH_AGENCY_OTHER (33, "Other youth services agency"),
	@XmlEnumValue("34")
	JUVENILE_JUSTICE (34, "Juvenile justice"),
	@XmlEnumValue("35")
	POLICE (35, "Law enforcement/ police"),
	@XmlEnumValue("36")
	RELIGIOUS (36, "Religious organization"),
	@XmlEnumValue("37")
	MENTAL_HOSPITAL (37, "Mental hospital"),
	@XmlEnumValue("38")
	SCHOOL (38, "School"),
	@XmlEnumValue("39")
	ORGANIZATION_OTHER (39, "Other organization"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientReferralSource(final Integer code, final String description) {
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
	private static final CodeLookup<ClientReferralSource> enhancer = new CodeLookup<ClientReferralSource>(values());	

	@JsonCreator
	public static ClientReferralSource valueByCode(Integer code) {
		ClientReferralSource value = enhancer.valueByCode(code); 
		return (value == null)?ClientReferralSource.ERR_UNKNOWN:value;
	}
}