package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientEnrollmentNonCashBenefitVO {
	private Long nonCashBenefitId;
	private Long enrollmentId;

	// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
	private Date informationDate;
	private YesNoReason benefitsFromAnySource;
	private YesNo snap;
	private YesNo wic;
	private YesNo tanfChildCare;
	private YesNo tanfTransportation;
	private YesNo otherTanf;
	private YesNo rentalAssistanceOngoing;
	private YesNo otherBenefitsSource;
	private YesNo rentalAssistanceTemp;
	private String otherBenefitsSourceIdentify;

	public ClientEnrollmentNonCashBenefitVO() {}

	@JsonProperty
	public Long getNonCashBenefitId() {
		return nonCashBenefitId;
	}

	@JsonProperty
	public void setNonCashBenefitId(Long nonCashBenefitId) {
		this.nonCashBenefitId = nonCashBenefitId;
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
	public YesNoReason getBenefitsFromAnySource() {
		return benefitsFromAnySource;
	}

	@JsonProperty
	public void setBenefitsFromAnySource(YesNoReason benefitsFromAnySource) {
		this.benefitsFromAnySource = benefitsFromAnySource;
	}

	@JsonProperty
	public YesNo getSnap() {
		return snap;
	}

	@JsonProperty
	public void setSnap(YesNo snap) {
		this.snap = snap;
	}

	@JsonProperty
	public YesNo getWic() {
		return wic;
	}

	@JsonProperty
	public void setWic(YesNo wic) {
		this.wic = wic;
	}

	@JsonProperty
	public YesNo getTanfChildCare() {
		return tanfChildCare;
	}

	@JsonProperty
	public void setTanfChildCare(YesNo tanfChildCare) {
		this.tanfChildCare = tanfChildCare;
	}

	@JsonProperty
	public YesNo getTanfTransportation() {
		return tanfTransportation;
	}

	@JsonProperty
	public void setTanfTransportation(YesNo tanfTransportation) {
		this.tanfTransportation = tanfTransportation;
	}

	@JsonProperty
	public YesNo getOtherTanf() {
		return otherTanf;
	}

	@JsonProperty
	public void setOtherTanf(YesNo otherTanf) {
		this.otherTanf = otherTanf;
	}

	@JsonProperty
	public YesNo getRentalAssistanceOngoing() {
		return rentalAssistanceOngoing;
	}

	@JsonProperty
	public void setRentalAssistanceOngoing(YesNo rentalAssistanceOngoing) {
		this.rentalAssistanceOngoing = rentalAssistanceOngoing;
	}

	@JsonProperty
	public YesNo getOtherBenefitsSource() {
		return otherBenefitsSource;
	}

	@JsonProperty
	public void setOtherBenefitsSource(YesNo otherBenefitsSource) {
		this.otherBenefitsSource = otherBenefitsSource;
	}

	@JsonProperty
	public YesNo getRentalAssistanceTemp() {
		return rentalAssistanceTemp;
	}

	@JsonProperty
	public void setRentalAssistanceTemp(YesNo rentalAssistanceTemp) {
		this.rentalAssistanceTemp = rentalAssistanceTemp;
	}

	@JsonProperty
	public String getOtherBenefitsSourceIdentify() {
		return otherBenefitsSourceIdentify;
	}

	@JsonProperty
	public void setOtherBenefitsSourceIdentify(String otherBenefitsSourceIdentify) {
		this.otherBenefitsSourceIdentify = otherBenefitsSourceIdentify;
	}
	
	
}

