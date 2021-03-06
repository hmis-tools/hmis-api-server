package org.openhmis.dto;


import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.ConsentApprovalStatus;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.domain.ConsentProfile;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class ConsentDTO extends BaseDTO {
	private String consentId;
	private String clientId;
	private String submitterId;
	private ConsentApprovalStatus approvalStatus;
	private List<String> organizationIds;
	private List<String> cocIds;

	private ConsentFieldsDTO fields;

	private Date dateProcessed;
	
	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public ConsentDTO() {}
	
	@JsonProperty
	public String getId() {
		return consentId;
	}

	@JsonProperty
	public void setId(String consentId) {
		this.consentId = consentId;
	}

	@JsonProperty
	public String getConsentId() {
		return consentId;
	}

	@JsonProperty
	public void setConsentId(String consentId) {
		this.consentId = consentId;
	}
	
	@JsonProperty
	public String getClientId() {
		return clientId;
	}

	@JsonProperty
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@JsonProperty
	public String getSubmitterId() {
		return submitterId;
	}

	@JsonProperty
	public void setSubmitterId(String submitterId) {
		this.submitterId = submitterId;
	}

	@JsonProperty
	public ConsentApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}

	@JsonProperty
	public void setApprovalStatus(ConsentApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	@JsonProperty
	public List<String> getOrganizationIds() {
		return organizationIds;
	}

	@JsonProperty
	public void setOrganizationIds(List<String> organizationIds) {
		this.organizationIds = organizationIds;
	}

	@JsonProperty
	public List<String> getCocIds() {
		return cocIds;
	}

	@JsonProperty
	public void setCocIds(List<String> cocIds) {
		this.cocIds = cocIds;
	}

	@JsonProperty
	public ConsentFieldsDTO getFields() {
		return this.fields;
	}

	@JsonProperty
	public void setFields(ConsentFieldsDTO fields) {
		this.fields = fields;
	}

	@JsonProperty
	public Date getDateProcessed() {
		return dateProcessed;
	}

	@JsonProperty
	public void setDateProcessed(Date dateProcessed) {
		this.dateProcessed = dateProcessed;
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

