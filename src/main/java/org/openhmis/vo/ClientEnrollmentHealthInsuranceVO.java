package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientReasonNotInsured;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientEnrollmentHealthInsuranceVO {
	private Long healthInsuranceId;
	private Long enrollmentId;

	// Program Specific Data Standards: Health Insurance (2014, 4.4)
	private Date informationDate;
	private YesNoReason insuranceFromAnySource;
	private YesNo medicaid;
	private ClientReasonNotInsured noMedicaidReason;
	private YesNo medicare;
	private ClientReasonNotInsured noMedicareReason;
	private YesNo schip;
	private ClientReasonNotInsured noSchipReason;
	private YesNo vaMedicalServices;
	private ClientReasonNotInsured noVaMedReason;
	private YesNo employerProvided;
	private ClientReasonNotInsured noEmployerProvidedReason;
	private YesNo cobra;
	private ClientReasonNotInsured noCobraReason;
	private YesNo privatePay;
	private ClientReasonNotInsured noPrivatePayReason;
	private YesNo stateHealthIns;
	private ClientReasonNotInsured noStateHealthInsReason;

	public ClientEnrollmentHealthInsuranceVO() {}

	@JsonProperty
	public Long getHealthInsuranceId() {
		return healthInsuranceId;
	}

	@JsonProperty
	public void setHealthInsuranceId(Long healthInsuranceId) {
		this.healthInsuranceId = healthInsuranceId;
	}

	@JsonProperty
	public Long getEnrollmentId() {
		return enrollmentId;
	}

	@JsonProperty
	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	@JsonProperty
	public Date getInformationDate() {
		return informationDate;
	}

	@JsonProperty
	public void setInformationDate(Date informationDate) {
		this.informationDate = informationDate;
	}

	@JsonProperty
	public YesNoReason getInsuranceFromAnySource() {
		return insuranceFromAnySource;
	}

	@JsonProperty
	public void setInsuranceFromAnySource(YesNoReason insuranceFromAnySource) {
		this.insuranceFromAnySource = insuranceFromAnySource;
	}

	@JsonProperty
	public YesNo getMedicaid() {
		return medicaid;
	}

	@JsonProperty
	public void setMedicaid(YesNo medicaid) {
		this.medicaid = medicaid;
	}

	@JsonProperty
	public ClientReasonNotInsured getNoMedicaidReason() {
		return noMedicaidReason;
	}

	@JsonProperty
	public void setNoMedicaidReason(ClientReasonNotInsured noMedicaidReason) {
		this.noMedicaidReason = noMedicaidReason;
	}

	@JsonProperty
	public YesNo getMedicare() {
		return medicare;
	}

	@JsonProperty
	public void setMedicare(YesNo medicare) {
		this.medicare = medicare;
	}

	@JsonProperty
	public ClientReasonNotInsured getNoMedicareReason() {
		return noMedicareReason;
	}

	@JsonProperty
	public void setNoMedicareReason(ClientReasonNotInsured noMedicareReason) {
		this.noMedicareReason = noMedicareReason;
	}

	@JsonProperty
	public YesNo getSchip() {
		return schip;
	}

	@JsonProperty
	public void setSchip(YesNo schip) {
		this.schip = schip;
	}

	@JsonProperty
	public ClientReasonNotInsured getNoSchipReason() {
		return noSchipReason;
	}

	@JsonProperty
	public void setNoSchipReason(ClientReasonNotInsured noSchipReason) {
		this.noSchipReason = noSchipReason;
	}

	@JsonProperty
	public YesNo getVaMedicalServices() {
		return vaMedicalServices;
	}

	@JsonProperty
	public void setVaMedicalServices(YesNo vaMedicalServices) {
		this.vaMedicalServices = vaMedicalServices;
	}

	@JsonProperty
	public ClientReasonNotInsured getNoVaMedReason() {
		return noVaMedReason;
	}

	@JsonProperty
	public void setNoVaMedReason(ClientReasonNotInsured noVaMedReason) {
		this.noVaMedReason = noVaMedReason;
	}

	@JsonProperty
	public YesNo getEmployerProvided() {
		return employerProvided;
	}

	@JsonProperty
	public void setEmployerProvided(YesNo employerProvided) {
		this.employerProvided = employerProvided;
	}

	@JsonProperty
	public ClientReasonNotInsured getNoEmployerProvidedReason() {
		return noEmployerProvidedReason;
	}

	@JsonProperty
	public void setNoEmployerProvidedReason(
			ClientReasonNotInsured noEmployerProvidedReason) {
		this.noEmployerProvidedReason = noEmployerProvidedReason;
	}

	@JsonProperty
	public YesNo getCobra() {
		return cobra;
	}

	@JsonProperty
	public void setCobra(YesNo cobra) {
		this.cobra = cobra;
	}

	@JsonProperty
	public ClientReasonNotInsured getNoCobraReason() {
		return noCobraReason;
	}

	@JsonProperty
	public void setNoCobraReason(ClientReasonNotInsured noCobraReason) {
		this.noCobraReason = noCobraReason;
	}

	@JsonProperty
	public YesNo getPrivatePay() {
		return privatePay;
	}

	@JsonProperty
	public void setPrivatePay(YesNo privatePay) {
		this.privatePay = privatePay;
	}

	@JsonProperty
	public ClientReasonNotInsured getNoPrivatePayReason() {
		return noPrivatePayReason;
	}

	@JsonProperty
	public void setNoPrivatePayReason(ClientReasonNotInsured noPrivatePayReason) {
		this.noPrivatePayReason = noPrivatePayReason;
	}

	@JsonProperty
	public YesNo getStateHealthIns() {
		return stateHealthIns;
	}

	@JsonProperty
	public void setStateHealthIns(YesNo stateHealthIns) {
		this.stateHealthIns = stateHealthIns;
	}

	@JsonProperty
	public ClientReasonNotInsured getNoStateHealthInsReason() {
		return noStateHealthInsReason;
	}

	@JsonProperty
	public void setNoStateHealthInsReason(
			ClientReasonNotInsured noStateHealthInsReason) {
		this.noStateHealthInsReason = noStateHealthInsReason;
	}
	
	
}

