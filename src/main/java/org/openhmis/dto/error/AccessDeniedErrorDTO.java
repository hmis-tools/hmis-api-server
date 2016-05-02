package org.openhmis.dto.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement(name = "error")
public class AccessDeniedErrorDTO extends AbstractErrorDTO {

	public AccessDeniedErrorDTO() {
	}

	@JsonProperty
	@XmlElement
	public String getCode() {
		return "ACCESS_DENIED";
	}

	@JsonProperty
	@XmlElement
	public String getMessage() {
		return "You are not allowed to access this content.";
	}
}

