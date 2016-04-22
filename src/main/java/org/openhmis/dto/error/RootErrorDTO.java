package org.openhmis.dto.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("error")
public class RootErrorDTO {

	// Base error information
	private ArrayList<AbstractErrorDTO> errors;

	public RootErrorDTO() {
		this.errors = new ArrayList<AbstractErrorDTO>();
	}
	public RootErrorDTO(AbstractErrorDTO error) {
		this.errors = new ArrayList<AbstractErrorDTO>();
		this.errors.add(error);
	}

	@JsonProperty
	public String getCode() {
		if(this.errors.size() > 0)
			return this.errors.get(0).getCode();
		return "";
	}

	@JsonProperty
	public String getMessage() {
		if(this.errors.size() > 0)
			return this.errors.get(0).getMessage();
		return "";
	}

	@JsonProperty
	public ArrayList<AbstractErrorDTO> getErrors() {
		return this.errors;
	}
	
	public void setErrors(ArrayList<AbstractErrorDTO> errors) {
		this.errors = errors; 
	}
	
	public void addError(AbstractErrorDTO error) {
		this.errors.add(error); 
	}
}

