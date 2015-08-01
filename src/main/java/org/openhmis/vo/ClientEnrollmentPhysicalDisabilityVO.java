package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ClientEnrollmentPhysicalDisabilityVO {
	private Long physicalDisabilityId;
	private Long enrollmentId;

	// Program Specific Data Standards: Physical Disability (2014, 4.5)
	private Date informationDate;
	private YesNoReason response;
	private YesNoReason indefiniteAndImpairs;
	private YesNo documentationOnFile;
	private YesNoReason receivingServices;


	public ClientEnrollmentPhysicalDisabilityVO() {}
	

	@JsonProperty
	public Long getPhysicalDisabilityId() {
		return physicalDisabilityId;
	}


	@JsonProperty
	public void setPhysicalDisabilityId(Long physicalDisabilityId) {
		this.physicalDisabilityId = physicalDisabilityId;
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

