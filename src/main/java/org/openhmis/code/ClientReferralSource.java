package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ReferralSource (2014, 4.34.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientReferralSource implements BaseCode {
	SELF (1, "Self-referral"),
	PARENT (2, "Individual: parent/guardian"),
	RELATIVE (3, "Individual: relative or friend"),
	INDIVIDUAL_OTHER (4, "Individual: other adult or youth"),
	PARTNER (5, "Individual: partner/spouse"),
	FOSTER_PARENT (6, "Individual: foster parent"),
	FYSB (7, "Outreach project: FYSB"),
	OUTREACH_OTHER (10, "Outreach project: other"),
	FYSB_CENTER (11, "Temporary shelter: FYSB basic center project"),
	YOUTH_SHELTER (12, "Temporary shelter: other youth only emergency shelter"),
	FAMILY_SHELTER (13, "Temporary shelter: emergency shelter for families"),
	INDIVIDUAL_SHELTER (14, "Temporary shelter: emergency shelter for individuals"),
	DV_SHELTER (15, "Temporary shelter: domestic violence shelter"),
	SAFE_PLACE (16, "Temporary shelter: safe place"),
	SHELTER_OTHER (17, "Temporary shelter: other"),
	FYSB_PROJECT (18, "Residential project: FYSB transitional living project"),
	TRANSITIONAL (19, "Residential project: other transitional living project"),
	GROUP_HOME (20, "Residential project: group home"),
	INDEPENDENT_PROJECT (21, "Residential project: independent living project"),
	JOB_CORPS (22, "Residential project: job corps"),
	DRUG_CENTER (23, "Residential project: drug treatment center"),
	TREATMENT_CENTER (24, "Residential project: treatment center"),
	EDUCATIONAL (25, "Residential project: educational institute"),
	AGENCY_PROJECT_OTHER (26, "Residential project: other agency project"),
	PROJECT_OTHER (27, "Residential project: other project"),
	NATIONAL_RUNAWAY (28, "Hotline: national runaway switchboard"),
	HOTLINE_OTHER (29, "Hotline: other"),
	CHILD_WELFARE (30, "Other agency: child welfare/CPS"),
	INDEPENDENT_LIVING (31, "Other agency: non-residential independent living project"),
	AGENCY_OTHER (32, "Other project operated by your agency"),
	YOUTH_AGENCY_OTHER (33, "Other youth services agency"),
	JUVENILE_JUSTICE (34, "Juvenile justice"),
	POLICE (35, "Law enforcement/ police"),
	RELIGIOUS (36, "Religious organization"),
	MENTAL_HOSPITAL (37, "Mental hospital"),
	SCHOOL (38, "School"),
	ORGANIZATION_OTHER (39, "Other organization"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
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
		return (value == null)?ClientReferralSource.NOT_COLLECTED:value;
	}
}