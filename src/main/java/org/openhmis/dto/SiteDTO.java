package org.openhmis.dto;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.YesNo;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class SiteDTO extends BaseDTO {
	
	/**
	 * The client object represents a client record
	 * Fields returned with the client object represent fields marked as "At client record creation" in the HUD standards
	 *
	 * References:
	 * - Fields dictated by: https://www.hudexchange.info/resources/documents/HMIS-Data-Dictionary.pdf
	 * - Field names dictated by: http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf
	 */

	// Keys
	private String siteId;
	private String projectCoCId;

	// Universal Data Standard: Site (2014, 2.8) 
	private YesNo principalSite;
	private String geocode;
	private String address;
	private String city;
	private String state;
	private String zip;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public SiteDTO() {
	}

	@JsonProperty
	public String getId() {
		return siteId;
	}

	@JsonProperty
	public void setId(String siteId) {
		this.siteId = siteId;
	}
	
	@JsonProperty
	public String getSiteId() {
		return siteId;
	}

	@JsonProperty
	public void setSiteId(String siteId) {
		this.siteId = siteId;
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
	public YesNo getPrincipalSite() {
		return principalSite;
	}

	@JsonProperty
	public void setPrincipalSite(YesNo principalSite) {
		this.principalSite = principalSite;
	}

	@JsonProperty
	public String getGeocode() {
		return geocode;
	}

	@JsonProperty
	public void setGeocode(String geocode) {
		this.geocode = geocode;
	}

	@JsonProperty
	public String getAddress() {
		return address;
	}

	@JsonProperty
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty
	public String getCity() {
		return city;
	}

	@JsonProperty
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty
	public String getState() {
		return state;
	}

	@JsonProperty
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty
	public String getZip() {
		return zip;
	}

	@JsonProperty
	public void setZip(String zip) {
		this.zip = zip;
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


