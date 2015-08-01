package org.openhmis.vo;
import java.util.Date;

import org.openhmis.code.ClientHopwaServices;
import org.openhmis.code.ClientPathServices;
import org.openhmis.code.ClientRhyServices;
import org.openhmis.code.ClientSsvfServices;
import org.openhmis.code.ClientSsvfSubType3;
import org.openhmis.code.ClientSsvfSubType4;
import org.openhmis.code.ClientSsvfSubType5;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ClientEnrollmentServiceVO {
	private Long serviceId;
	private Long enrollmentId;

	// Program Specific Data Standards: Services Provided (2014, 4.14)
	private Date dateProvided;

	// PATH (2014, 4.14A)
	private ClientPathServices pathTypeProvided;

	// RHY (2014, 4.14B)
	private ClientRhyServices rhyTypeProvided;
	
	// HOPWA (2014, 4.14C)
	private ClientHopwaServices hopwaTypeProvided;

	// SSVF (2014, 4.14D)
	private ClientSsvfServices ssvfTypeProvided;
	private ClientSsvfSubType3 ssvfVaSubTypeProvided;
	private ClientSsvfSubType4 ssvfCoordinatingSubTypeProvided;
	private ClientSsvfSubType5 ssvfDirectSubTypeProvided;
	private String ssvfOtherService;

	public ClientEnrollmentServiceVO() {}
	
	@JsonProperty
	public Long getServiceId() {
		return serviceId;
	}

	@JsonProperty
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	@JsonProperty
	public Long getEnrollmentId() {
		return enrollmentId;
	}

	@JsonProperty
	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	@JsonProperty
	public Date getDateProvided() {
		return dateProvided;
	}

	@JsonProperty
	public void setDateProvided(Date dateProvided) {
		this.dateProvided = dateProvided;
	}

	@JsonProperty
	public ClientPathServices getPathTypeProvided() {
		return pathTypeProvided;
	}

	@JsonProperty
	public void setPathTypeProvided(ClientPathServices pathTypeProvided) {
		this.pathTypeProvided = pathTypeProvided;
	}

	@JsonProperty
	public ClientRhyServices getRhyTypeProvided() {
		return rhyTypeProvided;
	}

	@JsonProperty
	public void setRhyTypeProvided(ClientRhyServices rhyTypeProvided) {
		this.rhyTypeProvided = rhyTypeProvided;
	}

	@JsonProperty
	public ClientHopwaServices getHopwaTypeProvided() {
		return hopwaTypeProvided;
	}

	@JsonProperty
	public void setHopwaTypeProvided(ClientHopwaServices hopwaTypeProvided) {
		this.hopwaTypeProvided = hopwaTypeProvided;
	}

	@JsonProperty
	public ClientSsvfServices getSsvfTypeProvided() {
		return ssvfTypeProvided;
	}

	@JsonProperty
	public void setSsvfTypeProvided(ClientSsvfServices ssvfTypeProvided) {
		this.ssvfTypeProvided = ssvfTypeProvided;
	}

	@JsonProperty
	public ClientSsvfSubType3 getSsvfVaSubTypeProvided() {
		return ssvfVaSubTypeProvided;
	}

	@JsonProperty
	public void setSsvfVaSubTypeProvided(ClientSsvfSubType3 ssvfVaSubTypeProvided) {
		this.ssvfVaSubTypeProvided = ssvfVaSubTypeProvided;
	}

	@JsonProperty
	public ClientSsvfSubType4 getSsvfCoordinatingSubTypeProvided() {
		return ssvfCoordinatingSubTypeProvided;
	}

	@JsonProperty
	public void setSsvfCoordinatingSubTypeProvided(
			ClientSsvfSubType4 ssvfCoordinatingSubTypeProvided) {
		this.ssvfCoordinatingSubTypeProvided = ssvfCoordinatingSubTypeProvided;
	}

	@JsonProperty
	public ClientSsvfSubType5 getSsvfDirectSubTypeProvided() {
		return ssvfDirectSubTypeProvided;
	}

	@JsonProperty
	public void setSsvfDirectSubTypeProvided(
			ClientSsvfSubType5 ssvfDirectSubTypeProvided) {
		this.ssvfDirectSubTypeProvided = ssvfDirectSubTypeProvided;
	}

	@JsonProperty
	public String getSsvfOtherService() {
		return ssvfOtherService;
	}

	@JsonProperty
	public void setSsvfOtherService(String ssvfOtherService) {
		this.ssvfOtherService = ssvfOtherService;
	}
}
