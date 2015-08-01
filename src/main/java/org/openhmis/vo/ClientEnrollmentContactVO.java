package org.openhmis.vo;

import java.util.Date;
import java.util.List;

import org.openhmis.code.ClientContactLocation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientEnrollmentContactVO {
	private Long contactId;
	private Long enrollmentId;

	// Program Specific Data Standards: Contact (2014, 4.12)
	private Date dateProvided;
	private ClientContactLocation typeProvided;
	
	public ClientEnrollmentContactVO() {}

	@JsonProperty
	public Long getContactId() {
		return contactId;
	}

	@JsonProperty
	public void setContactId(Long contactId) {
		this.contactId = contactId;
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
	
	
	
}
