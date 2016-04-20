package org.openhmis.dto.errors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public abstract class AbstractErrorDTO {

	// Base error information
	@JsonProperty
	public abstract String getCode();

	@JsonProperty
	public abstract String getMessage();
}

