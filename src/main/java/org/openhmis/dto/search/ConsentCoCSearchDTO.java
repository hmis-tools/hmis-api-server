

package org.openhmis.dto.search;


import java.util.Date;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class ConsentCoCSearchDTO extends BaseSearchDTO {

	private Integer consentId;
	
	public ConsentCoCSearchDTO() {}

	// Getters / Setters
	@JsonProperty
	public Integer getConsentId() {
		return this.consentId;
	}
	@QueryParam("consentId")
	public void setConsentId(Integer consentId) {
		this.consentId = consentId;
	}
	
}
