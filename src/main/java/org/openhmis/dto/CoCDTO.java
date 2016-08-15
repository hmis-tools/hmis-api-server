

package org.openhmis.dto;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class CoCDTO extends BaseDTO {
	
	private String coCId;
	private String coCnName;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public CoCDTO() {
	}

	// Getters / Setters
	@JsonProperty
	public String getId() {
		return coCId;
	}
	@JsonProperty
	public void setId(String coCId) {
		this.coCId = coCId;
	}
	
	@JsonProperty
	public String getCoCId() {
		return coCId;
	}
	@JsonProperty
	public void setCoCId(String coCId) {
		this.coCId = coCId;
	}
	
	@JsonProperty
	public String getCoCName() {
		return coCnName;
	}

	@JsonProperty
	public void setCoCName(String coCnName) {
		this.coCnName = coCnName;
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
