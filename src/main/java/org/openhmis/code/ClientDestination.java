package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: Destination (2014, 3.12.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientDestination implements BaseCode {
	@XmlEnumValue("1")
	EMERGENCY_SHELTER (1, "Emergency shelter, including hotel or motel paid for with emergency shelter voucher"),
	@XmlEnumValue("2")
	TRANSITIONAL_HOUSING (2, "Transitional housing for homeless persons (including homeless youth)"),
	@XmlEnumValue("3")
	PERMANENT_HOUSING (3, "Permanent housing for formerly homeless persons (such as: CoC project; or HUD legacy programs; or HOPWA PH)"),
	@XmlEnumValue("4")
	PSYCHIATRIC_HOSPITAL (4, "Psychiatric hospital or other psychiatric facility"),
	@XmlEnumValue("5")
	SUBSTANCE_ABUSE_TREATMENT (5, "Substance abuse treatment facility or detox center"),
	@XmlEnumValue("6")
	HOSPITAL (6, "Hospital or other residential non-psychiatric medical facility"),
	@XmlEnumValue("7")
	JAIL (7, "Jail, prison or juvenile detention facility"),
	@XmlEnumValue("10")
	RENTAL (10, "Rental by client, no ongoing housing subsidy"),
	@XmlEnumValue("11")
	OWNED (11, "Owned by client, no ongoing housing subsidy"),
	@XmlEnumValue("12")
	FAMILY_TEMPORARY (12, "Staying or living with family, temporary tenure (e.g., room, apartment or house)"),
	@XmlEnumValue("13")
	FRIENDS_TEMPORARY (13, "Staying or living with friends, temporary tenure (.e.g., room apartment or house)"),
	@XmlEnumValue("14")
	HOTEL (14, "Hotel or motel paid for without emergency shelter voucher"),
	@XmlEnumValue("15")
	FOSTER_CARE (15, "Foster care home or foster care group home"),
	@XmlEnumValue("16")
	NONHABITABLE (16, "Place not meant for habitation (e.g., a vehicle, an abandoned building, bus/train/subway station/airport or anywhere outside)"),
	@XmlEnumValue("17")
	OTHER (17, "Other"),
	@XmlEnumValue("18")
	SAFE_HAVEN (18, "Safe Haven"),
	@XmlEnumValue("19")
	VASH_RENTAL (19, "Rental by client, with VASH housing subsidy"),
	@XmlEnumValue("20")
	SUBSIDY_RENTAL (20, "Rental by client, with other ongoing housing subsidy"),
	@XmlEnumValue("21")
	SUBSIDY_OWNED(21, "Owned by client, with ongoing housing subsidy"),
	@XmlEnumValue("22")
	FAMILY_PERMANENT (22, "Staying or living with family, permanent tenure"),
	@XmlEnumValue("23")
	FRIENDS_PERMANENT (23, "Staying or living with friends, permanent tenure"),
	@XmlEnumValue("24")
	DECEASED (24, "Deceased"),
	@XmlEnumValue("25")
	NURSING_HOME (25, "Long-term care facility or nursing home"),
	@XmlEnumValue("26")
	HOPWA_PH (26, "Moved from one HOPWA funded project to HOPWA PH"),
	@XmlEnumValue("27")
	HOPWA_TH (27, "Moved from one HOPWA funded project to HOPWA TH"),
	@XmlEnumValue("28")
	GPD_RENTAL (28, "Rental by client, with GPD TIP housing subsidy"),
	@XmlEnumValue("29")
	HALFWAY_HOUSE (29, "Residential project or halfway house with no homeless criteria"),
	@XmlEnumValue("30")
	NO_INTERVIEW (30, "No exit interview completed"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
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