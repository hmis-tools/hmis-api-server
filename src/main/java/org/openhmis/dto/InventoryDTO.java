

package org.openhmis.dto;


import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class InventoryDTO {
	
	/**
	 * The client object represents a client record
	 * Fields returned with the client object represent fields marked as "At client record creation" in the HUD standards
	 *
	 * References:
	 * - Fields dictated by: https://www.hudexchange.info/resources/documents/HMIS-Data-Dictionary.pdf
	 * - Field names dictated by: http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf
	 */

	// Keys
	private String inventoryId;
	private String projectCoCId;

	// Universal Data Standard: Bed and Unit Inventory Information (2014, 2.7) 
	private Date informationDate;
	private ProjectHouseholdType householdType;
	private ProjectBedType bedType;
	private ProjectAvailability availability;
	private Integer unitInventory;
	private Integer bedInventory;
	private Integer chBedInventory;
	private Integer vetBedInventory;
	private Integer youthBedInventory;
	private ProjectYouthAgeGroup youthAgeGroup;
	private Date inventoryStartDate;
	private Date inventoryEndDate;
	private Integer hmisParticipatingBeds;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public InventoryDTO() {
	}

	@JsonProperty
	public String getInventoryId() {
		return inventoryId;
	}

	@JsonProperty
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	@JsonProperty
	public String getProjectCoCId() {
		return projectCoCId;
	}

	@JsonProperty
	public void setProjectCoCId(String projectCoCId) {
		this.projectCoCId = projectCoCId;
	}

	@JsonProperty
	public Date getInformationDate() {
		return informationDate;
	}

	@JsonProperty
	public void setInformationDate(Date informationDate) {
		this.informationDate = informationDate;
	}

	@JsonProperty
	public ProjectHouseholdType getHouseholdType() {
		return householdType;
	}

	@JsonProperty
	public void setHouseholdType(ProjectHouseholdType householdType) {
		this.householdType = householdType;
	}

	@JsonProperty
	public ProjectBedType getBedType() {
		return bedType;
	}

	@JsonProperty
	public void setBedType(ProjectBedType bedType) {
		this.bedType = bedType;
	}

	@JsonProperty
	public ProjectAvailability getAvailability() {
		return availability;
	}

	@JsonProperty
	public void setAvailability(ProjectAvailability availability) {
		this.availability = availability;
	}

	@JsonProperty
	public Integer getUnitInventory() {
		return unitInventory;
	}

	@JsonProperty
	public void setUnitInventory(Integer unitInventory) {
		this.unitInventory = unitInventory;
	}

	@JsonProperty
	public Integer getBedInventory() {
		return bedInventory;
	}

	@JsonProperty
	public void setBedInventory(Integer bedInventory) {
		this.bedInventory = bedInventory;
	}

	@JsonProperty
	public Integer getChBedInventory() {
		return chBedInventory;
	}

	@JsonProperty
	public void setChBedInventory(Integer chBedInventory) {
		this.chBedInventory = chBedInventory;
	}

	@JsonProperty
	public Integer getVetBedInventory() {
		return vetBedInventory;
	}

	@JsonProperty
	public void setVetBedInventory(Integer vetBedInventory) {
		this.vetBedInventory = vetBedInventory;
	}

	@JsonProperty
	public Integer getYouthBedInventory() {
		return youthBedInventory;
	}

	@JsonProperty
	public void setYouthBedInventory(Integer youthBedInventory) {
		this.youthBedInventory = youthBedInventory;
	}

	@JsonProperty
	public ProjectYouthAgeGroup getYouthAgeGroup() {
		return youthAgeGroup;
	}

	@JsonProperty
	public void setYouthAgeGroup(ProjectYouthAgeGroup youthAgeGroup) {
		this.youthAgeGroup = youthAgeGroup;
	}

	@JsonProperty
	public Date getInventoryStartDate() {
		return inventoryStartDate;
	}

	@JsonProperty
	public void setInventoryStartDate(Date inventoryStartDate) {
		this.inventoryStartDate = inventoryStartDate;
	}

	@JsonProperty
	public Date getInventoryEndDate() {
		return inventoryEndDate;
	}

	@JsonProperty
	public void setInventoryEndDate(Date inventoryEndDate) {
		this.inventoryEndDate = inventoryEndDate;
	}

	@JsonProperty
	public Integer getHmisParticipatingBeds() {
		return hmisParticipatingBeds;
	}

	@JsonProperty
	public void setHmisParticipatingBeds(Integer hmisParticipatingBeds) {
		this.hmisParticipatingBeds = hmisParticipatingBeds;
	}

	@JsonProperty
	public Date getDateCreated() {
		return dateCreated;
	}

	@JsonProperty
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@JsonProperty
	public Date getDateUpdated() {
		return dateUpdated;
	}

	@JsonProperty
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}
