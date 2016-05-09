package org.openhmis.dto.result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.openhmis.dto.error.AbstractErrorDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("data")
@XmlRootElement(name = "data")
// TODO: This is nasty, but I need to do it for now pending further research
// When translating to XML things break if we don't explicitly reference these
// This started when adding the WriterInterceptor.
@XmlSeeAlso({
	org.openhmis.dto.ChronicHealthConditionDTO.class,
	org.openhmis.dto.ClientDTO.class,
	org.openhmis.dto.CoCDTO.class,
	org.openhmis.dto.ContactDTO.class,
	org.openhmis.dto.DevelopmentalDisabilityDTO.class,
	org.openhmis.dto.DomesticAbuseDTO.class,
	org.openhmis.dto.EnrollmentDTO.class,
	org.openhmis.dto.ExitDTO.class,
	org.openhmis.dto.FinancialAssistanceDTO.class,
	org.openhmis.dto.FunderDTO.class,
	org.openhmis.dto.HealthInsuranceDTO.class,
	org.openhmis.dto.HivAidsStatusDTO.class,
	org.openhmis.dto.IncomeSourceDTO.class,
	org.openhmis.dto.InventoryDTO.class,
	org.openhmis.dto.MedicalAssistanceDTO.class,
	org.openhmis.dto.MentalHealthProblemDTO.class,
	org.openhmis.dto.NonCashBenefitDTO.class,
	org.openhmis.dto.PhysicalDisabilityDTO.class,
	org.openhmis.dto.ProjectDTO.class,
	org.openhmis.dto.ReferralDTO.class,
	org.openhmis.dto.ServiceDTO.class,
	org.openhmis.dto.SiteDTO.class,
	org.openhmis.dto.SubstanceAbuseDTO.class,
	org.openhmis.dto.UserDTO.class
})
public class DataResultDTO {

	// Base error information
	private Object item;

	public DataResultDTO() {
	}

	public DataResultDTO(Object item) {
		this.item = item;
	}

	@JsonProperty
	@XmlElement
	public Object getItem() {
		return item;
	}
}

