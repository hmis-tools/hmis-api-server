package org.openhmis.dto.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class InvalidParameterErrorDTO extends AbstractErrorDTO {

	public InvalidParameterErrorDTO() {
	}

	@JsonProperty
	public String getCode() {
		return "INVALID_PARAMETER";
	}

	@JsonProperty
	public String getMessage() {
		return "A parameter value was invalid.";
	}
}

