package org.openhmis.dto.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class MissingParameterErrorDTO extends AbstractErrorDTO {

	public MissingParameterErrorDTO() {
	}

	@JsonProperty
	public String getCode() {
		return "MISSING_PARAMETER";
	}

	@JsonProperty
	public String getMessage() {
		return "A required parameter was not provided.";
	}
}

