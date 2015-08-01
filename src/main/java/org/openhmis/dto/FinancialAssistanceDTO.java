package org.openhmis.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientHopwaFinancialAssistance;
import org.openhmis.code.ClientSsvfFinancialAssistance;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FinancialAssistanceDTO {
	private String financialAssistanceId;
	private String enrollmentId;

	// Program Specific Data Standards: Financial Assets Provided (2014, 4.15)
	private Date dateProvided;

	// HOPWA (2014, 4.15A)
	private ClientHopwaFinancialAssistance hopwaTypeProvided;
	private Long hopwaFaaAmount;

	// SSVF (2014, 4.15B)
	private ClientSsvfFinancialAssistance ssvfTypeProvided;
	private Long ssvfFaaAmount;

	public FinancialAssistanceDTO() {}

	@JsonProperty
	public String getFinancialAssistanceId() {
		return financialAssistanceId;
	}

	@JsonProperty
	public void setFinancialAssistanceId(String financialAssistanceId) {
		this.financialAssistanceId = financialAssistanceId;
	}

	@JsonProperty
	public String getEnrollmentId() {
		return enrollmentId;
	}

	@JsonProperty
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	@JsonProperty
	public Date getDateProvided() {
		return dateProvided;
	}

	@JsonProperty
	public void setDateProvided(Date dateProvided) {
		this.dateProvided = dateProvided;
	}

	@JsonProperty
	public ClientHopwaFinancialAssistance getHopwaTypeProvided() {
		return hopwaTypeProvided;
	}

	@JsonProperty
	public void setHopwaTypeProvided(
			ClientHopwaFinancialAssistance hopwaTypeProvided) {
		this.hopwaTypeProvided = hopwaTypeProvided;
	}

	@JsonProperty
	public Long getHopwaFaaAmount() {
		return hopwaFaaAmount;
	}

	@JsonProperty
	public void setHopwaFaaAmount(Long hopwaFaaAmount) {
		this.hopwaFaaAmount = hopwaFaaAmount;
	}

	@JsonProperty
	public ClientSsvfFinancialAssistance getSsvfTypeProvided() {
		return ssvfTypeProvided;
	}

	@JsonProperty
	public void setSsvfTypeProvided(ClientSsvfFinancialAssistance ssvfTypeProvided) {
		this.ssvfTypeProvided = ssvfTypeProvided;
	}

	@JsonProperty
	public Long getSsvfFaaAmount() {
		return ssvfFaaAmount;
	}

	@JsonProperty
	public void setSsvfFaaAmount(Long ssvfFaaAmount) {
		this.ssvfFaaAmount = ssvfFaaAmount;
	}
	
	
}
