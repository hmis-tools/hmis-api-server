

package org.openhmis.dto.search;


import java.util.Date;

import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class InventorySearchDTO extends BaseSearchDTO {
        private String projectCocId;
        
        public InventorySearchDTO() {}

	// Getters / Setters
	@JsonProperty
	public String getProjectCocId() {
		return this.projectCocId;
	}
	@QueryParam("projectCocId")
	public void setProjectCocId(String projectCocId) {
		this.projectCocId = projectCocId;
	}

}


