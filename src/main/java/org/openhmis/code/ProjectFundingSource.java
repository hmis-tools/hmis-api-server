package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: Funding Source (2014, 2.6.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ProjectFundingSource implements BaseCode {
	@XmlEnumValue("-1")
	ERR_UNKNOWN (-1, "Unknown"),
	@XmlEnumValue("1")
	HOMELESSNESS_PREVENTION_COC (1, "HUD CoC - Homelessness Prevention (High Performing Comm. Only)"),
	@XmlEnumValue("2")
	TRANSITIONAL_HOUSING_COC (2, "HUD CoC - Transitional Housing"),
	@XmlEnumValue("3")
	PERMANENT_SUPPORTIVE_HOUSING (3, "HUD CoC - Permanent Supportive Housing"),
	@XmlEnumValue("4")
	RAPID_REHOUSING_COC (4, "HUD CoC - Rapid Re-Housing"),
	@XmlEnumValue("5")
	SUPPORTIVE_SERVICES (5, "HUD CoC - Supportive Services Only"),
	@XmlEnumValue("6")
	COORDINATED_ASSESSMENT (6, "HUD CoC - Coordinated Assessment"),
	@XmlEnumValue("7")
	LEGACY_PROGRAM (7, "HUD CoC - Legacy Program"),
	@XmlEnumValue("8")
	EMERGENCY_SHELTER (8, "HUD ESG - Emergency Shelter (operating and/or essential services)"),
	@XmlEnumValue("9")
	HOMELESSNESS_PREVENTION_ESG (9, "HUD ESG - Homelessness Prevention"),
	@XmlEnumValue("10")
	RAPID_REHOUSING_ESG (10, "HUD ESG - Rapid Rehousing"),
	@XmlEnumValue("11")
	STREET_OUTREACH_ESG (11, "HUD ESG - Street Outreach"),
	@XmlEnumValue("12")
	RURAL_HOUSING_STABILITY (12, "HUD Rural Housing Stability Assistance Program"),
	@XmlEnumValue("13")
	HOTEL_VOUCHERS (13, "HUD HOPWA - Hotel/Motel Vouchers"),
	@XmlEnumValue("14")
	HOUSING_INFORMATION (14, "HUD HOPWA - Housing Information"),
	@XmlEnumValue("15")
	PERMANENT_HOUSING_TBRA (15, "HUD:HOPWA – Permanent Housing (facility based or TBRA)"),
	@XmlEnumValue("16")
	PERMANENT_HOUSING_PLACEMENT (16, "HUD:HOPWA – Permanent Housing Placement"),
	@XmlEnumValue("17")
	RENT_ASSISTANCE (17, "HUD HOPWA - Short-Term Rent, Mortgage, Utility assistance"),
	@XmlEnumValue("18")
	SHORT_TERM_SUPPORTIVE (18, "HUD HOPWA - Short-Term Supportive Facility"),
	@XmlEnumValue("19")
	TRANSITIONAL_HOUSING_HOPWA (19, "HUD HOPWA - Transitional Housing (facility based or TBRA)"),
	@XmlEnumValue("20")
	HUD_VASH (20, "HUD HUD/VASH"),
	@XmlEnumValue("21")
	STREET_OUTREACH_PATH (21, "HHS PATH - Street Outreach"),
	@XmlEnumValue("22")
	BASIC_CENTER_PROGRAM (22, "HHS RHY - Basic Center Program (prevention and shelter)"),
	@XmlEnumValue("23")
	MATERNAL_GROUP_HOME (23, "HHS RHY - Maternal Group Home"),
	@XmlEnumValue("24")
	TRANSITIONAL_LIVING (24, "HHS RHY - Transitional Living Program"),
	@XmlEnumValue("25")
	STREET_OUTREACH_RHY (25, "HHS RHY - Street Outreach Project"),
	@XmlEnumValue("26")
	DEMONSTRATION_PROJECT (26, "HHS RHY - Demonstration Project"),
	@XmlEnumValue("27")
	CCHV (27, "VA CCHV Community Contract Emergency Housing"),
	@XmlEnumValue("28")
	VA_GRANT (28, "VA Grant and Per Diem Program"),
	@XmlEnumValue("29")
	SUPPORTIVE_SERVICES_VA (29, "VA Supportive Services for Veteran Families"),
	@XmlEnumValue("30")
	NOT_APPLICABLE (30, "N/A"),
	@XmlEnumValue("99")
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
		return (value == null)?ProjectFundingSource.ERR_UNKNOWN:value;
	}
}