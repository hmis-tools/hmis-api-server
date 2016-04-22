package org.openhmis.dto.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class AccessDeniedErrorDTO extends AbstractErrorDTO {

	public AccessDeniedErrorDTO() {
	}

	@JsonProperty
	public String getCode() {
		return "ACCESS_DENIED";
	}

	@JsonProperty
	public String getMessage() {
		return "You are not allowed to access this content.";
	}
}

