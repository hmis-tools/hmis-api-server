package org.openhmis.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoCDTO {
	
	/**
	 * The client object represents a client record
	 * Fields returned with the client object represent fields marked as "At client record creation" in the HUD standards
	 *
	 * References:
	 * - Fields dictated by: https://www.hudexchange.info/resources/documents/HMIS-Data-Dictionary.pdf
	 * - Field names dictated by: http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf
	 */

	// Keys
	private String projectCoCId;
	private String projectId;

	// Universal Data Standard: Project Identifiers (2014, 2.2) 
	private String coCCode;

	// Universal Data Standard: Sites (2014, 2.8)
	private List<SiteDTO> sites;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public CoCDTO() {
	}

	@JsonProperty
	public String getProjectCoCId() {
		return projectCoCId;
	}

	@JsonProperty
	public void setProjectCoCId(String projectCoCId) {
		this.projectCoCId = projectCoCId;
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
	public String getCoCCode() {
		return coCCode;
	}

	@JsonProperty
	public void setCoCCode(String coCCode) {
		this.coCCode = coCCode;
	}

	@JsonProperty
	public List<SiteDTO> getSites() {
		return sites;
	}

	@JsonProperty
	public void setSites(List<SiteDTO> sites) {
		this.sites = sites;
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


