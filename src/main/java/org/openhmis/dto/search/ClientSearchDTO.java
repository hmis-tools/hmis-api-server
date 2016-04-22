

package org.openhmis.dto.search;


import java.util.Date;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class ClientSearchDTO extends BaseSearchDTO {

	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	private String dobStart;
	private String dobEnd;
	
	public ClientSearchDTO() {}

	// Getters / Setters
	@JsonProperty
	public String getFirstName() {
		return this.firstName;
	}
	@QueryParam("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@JsonProperty
	public String getMiddleName() {
		return this.middleName;
	}
	@QueryParam("middleName")
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@JsonProperty
	public String getLastName() {
		return this.lastName;
	}
	@QueryParam("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@JsonProperty
	public String getSsn() {
		return this.ssn;
	}
	@QueryParam("ssn")
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	@JsonProperty
	public String getDobStart() {
		return this.dobStart;
	}
	@QueryParam("dobStart")
	public void setDobStart(String dobStart) {
		this.dobStart = dobStart;
	}
	
	@JsonProperty
	public String getDobEnd() {
		return this.dobEnd;
	}
	@QueryParam("dobEnd")
	public void setDobEnd(String dobEnd) {
		this.dobEnd = dobEnd;
	}
}
