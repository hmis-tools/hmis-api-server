package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: Funding Source (2014, 2.6.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ProjectFundingSource implements BaseCode {
	HOMELESSNESS_PREVENTION_COC (1, "HUD CoC - Homelessness Prevention (High Performing Comm. Only)"),
	TRANSITIONAL_HOUSING_COC (2, "HUD CoC - Transitional Housing"),
	PERMANENT_SUPPORTIVE_HOUSING (3, "HUD CoC - Permanent Supportive Housing"),
	RAPID_REHOUSING_COC (4, "HUD CoC - Rapid Re-Housing"),
	SUPPORTIVE_SERVICES (5, "HUD CoC - Supportive Services Only"),
	COORDINATED_ASSESSMENT (6, "HUD CoC - Coordinated Assessment"),
	LEGACY_PROGRAM (7, "HUD CoC - Legacy Program"),
	EMERGENCY_SHELTER (8, "HUD ESG - Emergency Shelter (operating and/or essential services)"),
	HOMELESSNESS_PREVENTION_ESG (9, "HUD ESG - Homelessness Prevention"),
	RAPID_REHOUSING_ESG (10, "HUD ESG - Rapid Rehousing"),
	STREET_OUTREACH_ESG (11, "HUD ESG - Street Outreach"),
	RURAL_HOUSING_STABILITY (12, "HUD Rural Housing Stability Assistance Program"),
	HOTEL_VOUCHERS (13, "HUD HOPWA - Hotel/Motel Vouchers"),
	HOUSING_INFORMATION (14, "HUD HOPWA - Housing Information"),
	PERMANENT_HOUSING_TBRA (15, "HUD:HOPWA – Permanent Housing (facility based or TBRA)"),
	PERMANENT_HOUSING_PLACEMENT (16, "HUD:HOPWA – Permanent Housing Placement"),
	RENT_ASSISTANCE (17, "HUD HOPWA - Short-Term Rent, Mortgage, Utility assistance"),
	SHORT_TERM_SUPPORTIVE (18, "HUD HOPWA - Short-Term Supportive Facility"),
	TRANSITIONAL_HOUSING_HOPWA (19, "HUD HOPWA - Transitional Housing (facility based or TBRA)"),
	HUD_VASH (20, "HUD HUD/VASH"),
	STREET_OUTREACH_PATH (21, "HHS PATH - Street Outreach"),
	BASIC_CENTER_PROGRAM (22, "HHS RHY - Basic Center Program (prevention and shelter)"),
	MATERNAL_GROUP_HOME (23, "HHS RHY - Maternal Group Home"),
	TRANSITIONAL_LIVING (24, "HHS RHY - Transitional Living Program"),
	STREET_OUTREACH_RHY (25, "HHS RHY - Street Outreach Project"),
	DEMONSTRATION_PROJECT (26, "HHS RHY - Demonstration Project"),
	CCHV (27, "VA CCHV Community Contract Emergency Housing"),
	VA_GRANT (28, "VA Grant and Per Diem Program"),
	SUPPORTIVE_SERVICES_VA (29, "VA Supportive Services for Veteran Families"),
	NOT_APPLICABLE (30, "N/A"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ProjectFundingSource(final Integer code, final String description) {
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
	private static final CodeLookup<ProjectFundingSource> enhancer = new CodeLookup<ProjectFundingSource>(values());	

	@JsonCreator
	public static ProjectFundingSource valueByCode(Integer code) {
		ProjectFundingSource value = enhancer.valueByCode(code); 
		return (value == null)?ProjectFundingSource.NOT_COLLECTED:value;
	}
}