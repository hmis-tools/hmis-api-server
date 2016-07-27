package org.openhmis.dto;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.YesNoReason;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class TokenCacheDTO extends BaseDTO {

        private Integer tokenCacheId;
    	private Integer userId;
        private String idToken;
    
	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

    public TokenCacheDTO() {}

    	@JsonProperty
	public Integer getId() {
		return tokenCacheId;
	}

	@JsonProperty
	public void setId(Integer tokenCacheId) {
		this.tokenCacheId = tokenCacheId;
	}

        @JsonProperty
	public Integer getTokenCacheId() {
		return tokenCacheId;
	}

	@JsonProperty
	public void setTokenCacheId(Integer tokenCacheId) {
		this.tokenCacheId = tokenCacheId;
	}

	@JsonProperty
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@JsonProperty
	public String getIdToken() {
		return idToken;
	}

	@JsonProperty
	public void setIdToken(String idToken) {
		this.idToken = idToken;
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
