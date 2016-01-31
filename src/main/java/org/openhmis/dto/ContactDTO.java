package org.openhmis.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.ClientContactLocation;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class ContactDTO {
	private String contactId;
	private String enrollmentId;

	// Program Specific Data Standards: Contact (2014, 4.12)
	private Date dateProvided;
	private ClientContactLocation typeProvided;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;
	
	public ContactDTO() {}

	@JsonProperty
	public String getContactId() {
		return contactId;
	}

	@JsonProperty
	public void setContactId(String contactId) {
		this.contactId = contactId;
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
	public ClientContactLocation getTypeProvided() {
		return typeProvided;
	}

	@JsonProperty
	public void setTypeProvided(ClientContactLocation typeProvided) {
		this.typeProvided = typeProvided;
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
