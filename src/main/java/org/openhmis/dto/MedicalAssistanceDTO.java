package org.openhmis.dto;

import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientNoAssistanceReason;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;


public class MedicalAssistanceDTO {
	private String medicalAssistanceId;
	private String enrollmentId;

	// HOPWA Specific Data Standards: Medical Assistance (2014, 4.39)
	private Date informationDate;
	private YesNoReason hivAidsAssistance;
	private ClientNoAssistanceReason noHivAidsAssistanceReason;
	private YesNoReason adap;
	private ClientNoAssistanceReason noAdapReason;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public MedicalAssistanceDTO() {}

	@JsonProperty
	public String getMedicalAssistanceId() {
		return medicalAssistanceId;
	}

	@JsonProperty
	public void setMedicalAssistanceId(String medicalAssistanceId) {
		this.medicalAssistanceId = medicalAssistanceId;
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
	public Date getInformationDate() {
		return informationDate;
	}

	@JsonProperty
	public void setInformationDate(Date informationDate) {
		this.informationDate = informationDate;
	}

	@JsonProperty
	public YesNoReason getHivAidsAssistance() {
		return hivAidsAssistance;
	}

	@JsonProperty
	public void setHivAidsAssistance(YesNoReason hivAidsAssistance) {
		this.hivAidsAssistance = hivAidsAssistance;
	}

	@JsonProperty
	public ClientNoAssistanceReason getNoHivAidsAssistanceReason() {
		return noHivAidsAssistanceReason;
	}

	@JsonProperty
	public void setNoHivAidsAssistanceReason(
			ClientNoAssistanceReason noHivAidsAssistanceReason) {
		this.noHivAidsAssistanceReason = noHivAidsAssistanceReason;
	}

	@JsonProperty
	public YesNoReason getAdap() {
		return adap;
	}

	@JsonProperty
	public void setAdap(YesNoReason adap) {
		this.adap = adap;
	}

	@JsonProperty
	public ClientNoAssistanceReason getNoAdapReason() {
		return noAdapReason;
	}

	@JsonProperty
	public void setNoAdapReason(ClientNoAssistanceReason noAdapReason) {
		this.noAdapReason = noAdapReason;
	}

	@JsonProperty
	public Date getDateCreated() {
		return dateCreated;
	}

	@JsonProperty
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@JsonProperty
	public Date getDateUpdated() {
		return dateUpdated;
	}

	@JsonProperty
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	
}

