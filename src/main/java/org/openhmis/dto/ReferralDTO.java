package org.openhmis.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.ClientPathReferral;
import org.openhmis.code.ClientPathReferralOutcome;
import org.openhmis.code.ClientRhyReferral;

import com.fasterxml.jackson.annotation.JsonProperty;



@XmlRootElement
public class ReferralDTO {
	private String referralId;
	private String enrollmentId;

	// Program Specific Data Standards: References Provided (2014, 4.16)
	private Date referralDate;

	// PATH (2014, 4.16A)
	private ClientPathReferral pathTypeProvided;
	private ClientPathReferralOutcome referralOutcome;

	// RHY (2014, 4.16B)
	private ClientRhyReferral rhyTypeProvided;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public ReferralDTO() {}
	
	@JsonProperty
	public String getReferralId() {
		return referralId;
	}

	@JsonProperty
	public void setReferralId(String referralId) {
		this.referralId = referralId;
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
	public Date getReferralDate() {
		return referralDate;
	}

	@JsonProperty
	public void setReferralDate(Date referralDate) {
		this.referralDate = referralDate;
	}

	@JsonProperty
	public ClientPathReferral getPathTypeProvided() {
		return pathTypeProvided;
	}

	@JsonProperty
	public void setPathTypeProvided(ClientPathReferral pathTypeProvided) {
		this.pathTypeProvided = pathTypeProvided;
	}

	@JsonProperty
	public ClientPathReferralOutcome getReferralOutcome() {
		return referralOutcome;
	}

	@JsonProperty
	public void setReferralOutcome(ClientPathReferralOutcome referralOutcome) {
		this.referralOutcome = referralOutcome;
	}

	@JsonProperty
	public ClientRhyReferral getRhyTypeProvided() {
		return rhyTypeProvided;
	}

	@JsonProperty
	public void setRhyTypeProvided(ClientRhyReferral rhyTypeProvided) {
		this.rhyTypeProvided = rhyTypeProvided;
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
