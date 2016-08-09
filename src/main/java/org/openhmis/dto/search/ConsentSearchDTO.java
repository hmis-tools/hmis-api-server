package org.openhmis.dto.search;


import java.util.Date;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class ConsentSearchDTO extends BaseSearchDTO {

	private Integer submitterId;
	
	public ConsentSearchDTO() {}

	// Getters / Setters
	@JsonProperty
	public Integer getSubmitterId() {
		return this.submitterId;
	}
	@QueryParam("submitterId")
	public void setSubmitterId(Integer submitterId) {
		this.submitterId = submitterId;
	}
	
}
