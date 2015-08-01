package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientWhenDvOccurred;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DomesticAbuseVO {
	private String domesticAbuseId;
	private String enrollmentId;

	// Program Specific Data Standards: Domestic Abuse (2014, 4.11)
	private Date informationDate;
	private YesNoReason domesticViolenceVictim;
	private ClientWhenDvOccurred whenOccurred;

	public DomesticAbuseVO() {}

	@JsonProperty
	public String getDomesticAbuseId() {
		return domesticAbuseId;
	}

	@JsonProperty
	public void setDomesticAbuseId(String domesticAbuseId) {
		this.domesticAbuseId = domesticAbuseId;
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
	public YesNoReason getDomesticViolenceVictim() {
		return domesticViolenceVictim;
	}

	@JsonProperty
	public void setDomesticViolenceVictim(YesNoReason domesticViolenceVictim) {
		this.domesticViolenceVictim = domesticViolenceVictim;
	}

	@JsonProperty
	public ClientWhenDvOccurred getWhenOccurred() {
		return whenOccurred;
	}

	@JsonProperty
	public void setWhenOccurred(ClientWhenDvOccurred whenOccurred) {
		this.whenOccurred = whenOccurred;
	}
	
	
}