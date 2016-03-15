package org.openhmis.dto;


import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class PhysicalDisabilityDTO {
	private String physicalDisabilityId;
	private String enrollmentId;

	// Program Specific Data Standards: Physical Disability (2014, 4.5)
	private Date informationDate;
	private YesNoReason response;
	private YesNoReason indefiniteAndImpairs;
	private YesNo documentationOnFile;
	private YesNoReason receivingServices;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public PhysicalDisabilityDTO() {}
	

	@JsonProperty
	public String getPhysicalDisabilityId() {
		return physicalDisabilityId;
	}


	@JsonProperty
	public void setPhysicalDisabilityId(String physicalDisabilityId) {
		this.physicalDisabilityId = physicalDisabilityId;
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

