package org.openhmis.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.openhmis.code.serialization.CodeSerializer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import org.openhmis.code.serialization.CodeLookup;

// Codes for Data Standard: ResidencePrior (2014, 3.9.1)
// http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf

@JsonSerialize(using = CodeSerializer.class)
@XmlEnum
public enum ClientResidencePrior implements BaseCode {
	@XmlEnumValue("1")
	EMERGENCY_SHELTER (1, "Emergency shelter, including hotel or motel paid for with emergency shelter voucher"),
	@XmlEnumValue("2")
	TRANSITIONAL_HOUSING (2, "Transitional housing for homeless persons"),
	@XmlEnumValue("3")
	PERMANENT_HOUSING (3, "Permanent housing for formerly homeless persons"),
	@XmlEnumValue("4")
	PSYCHIATRIC_HOSPITAL (4, "Psychiatric hospital or other psychiatric facility"),
	@XmlEnumValue("5")
	SUBSTANCE_ABUSE_TREATMENT (5, "Substance abuse treatment facility or detox center"),
	@XmlEnumValue("6")
	HOSPITAL (6, "Hospital or other residential non-psychiatric medical facility"),
	@XmlEnumValue("7")
	JAIL (7, "Jail, prison or juvenile detention facility"),
	@XmlEnumValue("12")
	FAMILY (12, "Staying or living in a family member’s room, apartment or house"),
	@XmlEnumValue("13")
	FRIEND (13, "Staying or living in a friend’s room, apartment or house"),
	@XmlEnumValue("14")
	HOTEL (14, "Hotel or motel paid for without emergency shelter voucher"),
	@XmlEnumValue("15")
	FOSTER_HOME (15, "Foster care home or foster care group home"),
	@XmlEnumValue("16")
	NONHABITABLE (16, "Place not meant for habitation"),
	@XmlEnumValue("17")
	OTHER (17, "Other"),
	@XmlEnumValue("18")
	SAFE_HAVEN (18, "Safe Haven"),
	@XmlEnumValue("19")
	VASH_RENTAL (19, "Rental by client, with VASH subsidy"),
	@XmlEnumValue("20")
	SUBSIDY_RENTAL (20, "Rental by client, with other ongoing housing subsidy"),
	@XmlEnumValue("21")
	SUBSIDY_OWNED (21, "Owned by client, with ongoing housing subsidy"),
	@XmlEnumValue("22")
	RENTAL (22, "Rental by client, no ongoing housing subsidy"),
	@XmlEnumValue("23")
	OWNED (23, "Owned by client, no ongoing housing subsidy"),
	@XmlEnumValue("24")
	NURSING_HOME (24, "Long-term care facility or nursing home"),
	@XmlEnumValue("25")
	GPD_RENTAL (25, "Rental by client, with GPD TIP subsidy"),
	@XmlEnumValue("26")
	HALFWAY_HOUSE (26, "Residential project or halfway house with no homeless criteria"),
	@XmlEnumValue("8")
	UNKNOWN (8, "Client doesn't know"),
	@XmlEnumValue("9")
	REFUSED (9, "Client refused"),
	@XmlEnumValue("99")
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