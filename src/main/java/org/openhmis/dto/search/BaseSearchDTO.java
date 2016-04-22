

package org.openhmis.dto.search;


import java.util.Date;
import javax.ws.rs.QueryParam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseSearchDTO {
	
	/**
	 * The base search object provides fields that any resource can be searched or filtered by
	 */
	
	// TODO: figure out a way to make it possible to take in a date directly
	private String updatedSince;
	
	public BaseSearchDTO() {}

	// Getters / Setters
	@JsonProperty
	public String getUpdatedSince() {
		return this.updatedSince;
	}

	@QueryParam("updatedSince")
	public void setUpdatedSince(String updatedSince) {
		
		// TODO: make sure the string is a valid date, or throw an exception 
		this.updatedSince = updatedSince;
	}
}
