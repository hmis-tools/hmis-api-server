package org.openhmis.dto;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.ClientDestination;
import org.openhmis.code.ClientEarlyExitReason;
import org.openhmis.code.ClientEmploymentType;
import org.openhmis.code.ClientExitAction;
import org.openhmis.code.ClientExpelledReason;
import org.openhmis.code.ClientHealthStatus;
import org.openhmis.code.ClientHousingAssessmentAtExit;
import org.openhmis.code.ClientHousingAssessmentDisposition;
import org.openhmis.code.ClientNotEmployedReason;
import org.openhmis.code.ClientProjectCompletionStatus;
import org.openhmis.code.ClientSubsidyInformation;
import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class UserDTO extends BaseDTO {
	
	private String userId;
	private String externalId;
	private Integer canRead;
	private Integer canWrite;
	private Integer canAdmin;
        private String organization;
        private String coC;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public UserDTO() {}

	@JsonProperty
	public String getId() {
		return userId;
	}

	@JsonProperty
	public void setId(String userId) {
		this.userId = userId;
	}

	@JsonProperty
	public String getUserId() {
		return userId;
	}

	@JsonProperty
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty
	public String getExternalId() {
		return externalId;
	}

	@JsonProperty
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	@JsonProperty
	public Integer getCanRead() {
		return canRead;
	}

	@JsonProperty
	public void setCanRead(Integer canRead) {
		this.canRead = canRead;
	}

	@JsonProperty
	public Integer getCanWrite() {
		return canWrite;
	}

	@JsonProperty
	public void setCanWrite(Integer canWrite) {
		this.canWrite = canWrite;
	}

	@JsonProperty
	public Integer getCanAdmin() {
		return canAdmin;
	}

	@JsonProperty
	public void setCanAdmin(Integer canAdmin) {
		this.canAdmin = canAdmin;
	}

        @JsonProperty
	public String getOrganization() {
		return this.organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}


        @JsonProperty
	public String getCoC() {
		return this.coC;
	}

	public void setCoC(String coC) {
		this.coC = coC;
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
