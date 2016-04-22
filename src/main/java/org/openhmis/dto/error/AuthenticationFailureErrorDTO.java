package org.openhmis.dto.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement
public class AuthenticationFailureErrorDTO extends AbstractErrorDTO {

	public AuthenticationFailureErrorDTO() {
	}

	@JsonProperty
	public String getCode() {
		return "AUTHENTICATION_FAILURE";
	}

	@JsonProperty
	public String getMessage() {
		return "You could not be authenticated in the system.";
	}
}

