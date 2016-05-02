package org.openhmis.dto.result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.openhmis.dto.error.AbstractErrorDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("data")
@XmlRootElement(name = "data")
@XmlSeeAlso({
	org.openhmis.dto.ClientDTO.class,
})
public class DataResultDTO {

	// Base error information
	private Object item;

	public DataResultDTO() {
	}

	public DataResultDTO(Object item) {
		this.item = item;
	}

	@JsonProperty
	@XmlElement
	public Object getItem() {
		return item;
	}
}

