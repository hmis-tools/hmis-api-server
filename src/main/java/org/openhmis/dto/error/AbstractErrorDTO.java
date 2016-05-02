package org.openhmis.dto.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public abstract class AbstractErrorDTO {

	// Base error information
	@JsonProperty
	@XmlElement
	public abstract String getCode();

	@JsonProperty
	@XmlElement
	public abstract String getMessage();
}

