package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;
import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: Destination (2014, 3.12.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
public enum ClientDestination implements BaseCode {
	EMERGENCY_SHELTER (1, "Emergency shelter, including hotel or motel paid for with emergency shelter voucher"),
	TRANSITIONAL_HOUSING (2, "Transitional housing for homeless persons (including homeless youth)"),
	PERMANENT_HOUSING (3, "Permanent housing for formerly homeless persons (such as: CoC project; or HUD legacy programs; or HOPWA PH)"),
	PSYCHIATRIC_HOSPITAL (4, "Psychiatric hospital or other psychiatric facility"),
	SUBSTANCE_ABUSE_TREATMENT (5, "Substance abuse treatment facility or detox center"),
	HOSPITAL (6, "Hospital or other residential non-psychiatric medical facility"),
	JAIL (7, "Jail, prison or juvenile detention facility"),
	RENTAL (10, "Rental by client, no ongoing housing subsidy"),
	OWNED (11, "Owned by client, no ongoing housing subsidy"),
	FAMILY_TEMPORARY (12, "Staying or living with family, temporary tenure (e.g., room, apartment or house)"),
	FRIENDS_TEMPORARY (13, "Staying or living with friends, temporary tenure (.e.g., room apartment or house)"),
	HOTEL (14, "Hotel or motel paid for without emergency shelter voucher"),
	FOSTER_CARE (15, "Foster care home or foster care group home"),
	NONHABITABLE (16, "Place not meant for habitation (e.g., a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)"),
	OTHER (17, "Other"),
	SAFE_HAVEN (18, "Safe Haven"),
	VASH_RENTAL (19, "Rental by client, with VASH housing subsidy"),
	SUBSIDY_RENTAL (20, "Rental by client, with other ongoing housing subsidy"),
	SUBSIDY_OWNED(21, "Owned by client, with ongoing housing subsidy"),
	FAMILY_PERMANENT (22, "Staying or living with family, permanent tenure"),
	FRIENDS_PERMANENT (23, "Staying or living with friends, permanent tenure"),
	DECEASED (24, "Deceased"),
	NURSING_HOME (25, "Long-term care facility or nursing home"),
	HOPWA_PH (26, "Moved from one HOPWA funded project to HOPWA PH"),
	HOPWA_TH (27, "Moved from one HOPWA funded project to HOPWA TH"),
	GPD_RENTAL (28, "Rental by client, with GPD TIP housing subsidy"),
	HALFWAY_HOUSE (29, "Residential project or halfway house with no homeless criteria"),
	NO_INTERVIEW (30, "No exit interview completed"),
	UNKNOWN (8, "Client doesn't know"),
	REFUSED (9, "Client refused"),
	NOT_COLLECTED (99, "Data not collected");
	
	private final Integer code;
	private final String description;

	ClientDestination(final Integer code, final String description) {
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
	private static final CodeLookup<ClientDestination> enhancer = new CodeLookup<ClientDestination>(values());	

	@JsonCreator
	public static ClientDestination valueByCode(Integer code) {
		ClientDestination value = enhancer.valueByCode(code); 
		return (value == null)?ClientDestination.NOT_COLLECTED:value;
	}
}