package org.openhmis.dto.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class InvalidParameterErrorDTO extends AbstractErrorDTO {

	String parameter = "";
	String problem = "";

	public InvalidParameterErrorDTO() {
	}

	public InvalidParameterErrorDTO(String parameter, String problem) {
		this.parameter = parameter;
		this.problem = problem;
	}

	@JsonProperty
	public String getCode() {
		return "INVALID_PARAMETER";
	}

	@JsonProperty
	public String getMessage() {
		return "A parameter value was invalid.";
	}

	@JsonProperty
	public String getParameter() {
		return parameter;
	}


	@JsonProperty
	public String getProblem() {
		return problem;
	}
}

