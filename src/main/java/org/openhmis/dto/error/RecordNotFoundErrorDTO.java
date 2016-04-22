package org.openhmis.dto.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class RecordNotFoundErrorDTO extends AbstractErrorDTO {

	public RecordNotFoundErrorDTO() {
	}

	@JsonProperty
	public String getCode() {
		return "RECORD_NOT_FOUND";
	}

	@JsonProperty
	public String getMessage() {
		return "The requested record was not found";
	}
}

