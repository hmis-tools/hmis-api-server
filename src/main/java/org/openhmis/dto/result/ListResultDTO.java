package org.openhmis.dto.result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.dto.error.AbstractErrorDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("data")
@XmlRootElement(name = "data")
public class ListResultDTO {

	// Base error information
	private List<Object> items;

	public ListResultDTO() {
	}

	public ListResultDTO(List<Object> items) {
		this.items = items;
	}

	@JsonProperty
	@XmlElement
	public List<Object> getItems() {
		return items;
	}
}

