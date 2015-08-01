package org.openhmis.dto;

import java.util.Date;
import java.util.List;

import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChronicHealthConditionDTO {
	private String chronicHealthConditionId;
	private String enrollmentId;

	// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
	private Date informationDate;
	private YesNoReason response;
	private YesNoReason indefiniteAndImpairs;
	private YesNo documentationOnFile;
	private YesNoReason receivingServices;

	public ChronicHealthConditionDTO() {}

	@JsonProperty
	public String getChronicHealthConditionId() {
		return chronicHealthConditionId;
	}

	@JsonProperty
	public void setChronicHealthConditionId(String chronicHealthConditionId) {
		this.chronicHealthConditionId = chronicHealthConditionId;
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
	public YesNoReason getResponse() {
		return response;
	}

	@JsonProperty
	public void setResponse(YesNoReason response) {
		this.response = response;
	}

	@JsonProperty
	public YesNoReason getIndefiniteAndImpairs() {
		return indefiniteAndImpairs;
	}

	@JsonProperty
	public void setIndefiniteAndImpairs(YesNoReason indefiniteAndImpairs) {
		this.indefiniteAndImpairs = indefiniteAndImpairs;
	}

	@JsonProperty
	public YesNo getDocumentationOnFile() {
		return documentationOnFile;
	}

	@JsonProperty
	public void setDocumentationOnFile(YesNo documentationOnFile) {
		this.documentationOnFile = documentationOnFile;
	}

	@JsonProperty
	public YesNoReason getReceivingServices() {
		return receivingServices;
	}

	@JsonProperty
	public void setReceivingServices(YesNoReason receivingServices) {
		this.receivingServices = receivingServices;
	}

	
}

