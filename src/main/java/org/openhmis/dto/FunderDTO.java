package org.openhmis.dto;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.ProjectFundingSource;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class FunderDTO {
	
	/**
	 * The client object represents a client record
	 * Fields returned with the client object represent fields marked as "At client record creation" in the HUD standards
	 *
	 * References:
	 * - Fields dictated by: https://www.hudexchange.info/resources/documents/HMIS-Data-Dictionary.pdf
	 * - Field names dictated by: http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf
	 */

	// Keys
	private String funderId;
	private String projectId;

	// Universal Data Standard: Funder (2014, 2.6) 
	private ProjectFundingSource funder;
	private String grantId;
	private Date startDate;
	private Date endDate;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public FunderDTO() {
	}

	@JsonProperty
	public String getFunderId() {
		return funderId;
	}

	@JsonProperty
	public void setFunderId(String funderId) {
		this.funderId = funderId;
	}

	@JsonProperty
	public String getProjectId() {
		return projectId;
	}

	@JsonProperty
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@JsonProperty
	public ProjectFundingSource getFunder() {
		return funder;
	}

	@JsonProperty
	public void setFunder(ProjectFundingSource funder) {
		this.funder = funder;
	}

	@JsonProperty
	public String getGrantId() {
		return grantId;
	}

	@JsonProperty
	public void setGrantId(String grantId) {
		this.grantId = grantId;
	}

	@JsonProperty
	public Date getStartDate() {
		return startDate;
	}

	@JsonProperty
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@JsonProperty
	public Date getEndDate() {
		return endDate;
	}

	@JsonProperty
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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


