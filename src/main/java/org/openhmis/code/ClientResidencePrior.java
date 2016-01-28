package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ResidencePrior (2014, 3.9.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientResidencePrior implements BaseCode {
	EMERGENCY_SHELTER (1, "Emergency shelter, including hotel or motel paid for with emergency shelter voucher"),
	TRANSITIONAL_HOUSING (2, "Transitional housing for homeless persons"),
	PERMANENT_HOUSING (3, "Permanent housing for formerly homeless persons"),
	PSYCHIATRIC_HOSPITAL (4, "Psychiatric hospital or other psychiatric facility"),
	SUBSTANCE_ABUSE_TREATMENT (5, "Substance abuse treatment facility or detox center"),
	HOSPITAL (6, "Hospital or other residential non-psychiatric medical facility"),
	JAIL (7, "Jail, prison or juvenile detention facility"),
	FAMILY (12, "Staying or living in a family member’s room, apartment or house"),
	FRIEND (13, "Staying or living in a friend’s room, apartment or house"),
	HOTEL (14, "Hotel or motel paid for without emergency shelter voucher"),
	FOSTER_HOME (15, "Foster care home or foster care group home"),
	NONHABITABLE (16, "Place not meant for habitation"),
	OTHER (17, "Other"),
	SAFE_HAVEN (18, "Safe Haven"),
	VASH_RENTAL (19, "Rental by client, with VASH subsidy"),
	SUBSIDY_RENTAL (20, "Rental by client, with other ongoing housing subsidy"),
	SUBSIDY_OWNED (21, "Owned by client, with ongoing housing subsidy"),
	RENTAL (22, "Rental by client, no ongoing housing subsidy"),
	OWNED (23, "Owned by client, no ongoing housing subsidy"),
	NURSING_HOME (24, "Long-term care facility or nursing home"),
	GPD_RENTAL (25, "Rental by client, with GPD TIP subsidy"),
	HALFWAY_HOUSE (26, "Residential project or halfway house with no homeless criteria"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientResidencePrior(final Integer code, final String description) {
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
	private static final CodeLookup<ClientResidencePrior> enhancer = new CodeLookup<ClientResidencePrior>(values());	

	@JsonCreator
	public static ClientResidencePrior valueByCode(Integer code) {
		ClientResidencePrior value = enhancer.valueByCode(code); 
		return (value == null)?ClientResidencePrior.NOT_COLLECTED:value;
	}
}