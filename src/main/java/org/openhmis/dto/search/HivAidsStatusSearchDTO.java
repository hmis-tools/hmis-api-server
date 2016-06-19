

package org.openhmis.dto.search;


import java.util.Date;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class HivAidsStatusSearchDTO extends BaseSearchDTO {
        private String enrollmentId;
        
        public HivAidsStatusSearchDTO() {}

	// Getters / Setters
	@JsonProperty
	public String getEnrollmentId() {
		return this.enrollmentId;
	}
	@QueryParam("enrollmentId")
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
}


