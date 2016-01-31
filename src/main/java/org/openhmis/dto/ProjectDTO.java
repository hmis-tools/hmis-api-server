

package org.openhmis.dto;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.openhmis.code.ProjectTargetPopulation;
import org.openhmis.code.ProjectTrackingMethod;
import org.openhmis.code.ProjectType;
import org.openhmis.code.YesNo;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class ProjectDTO {
	
	/**
	 * The client object represents a client record
	 * Fields returned with the client object represent fields marked as "At client record creation" in the HUD standards
	 *
	 * References:
	 * - Fields dictated by: https://www.hudexchange.info/resources/documents/HMIS-Data-Dictionary.pdf
	 * - Field names dictated by: http://www.hudhdx.info/Resources/Vendors/4_0/HMISCSVSpecifications4_0FINAL.pdf
	 */

	// Universal Data Standard: Project Identifiers (2014, 2.2) 
	private String projectId;
	private String projectName;

	// Universal Data Standard: Project CoC (2014, 2.3)
	private List<CoCDTO> projectCoCs;

	// Universal Data Standard: Project Type (2014, 2.4)
	private YesNo continuumProject;
	private ProjectType projectType;
	private YesNo residentialAffiliation;
	private String resProjectId;

	// Universal Data Standard: Project Type (2014, 2.5)
	private ProjectTrackingMethod trackingMethod;

	// Universal Data Standard: Funders (2014, 2.6)
	private List<FunderDTO> funders;

	// Universal Data Standard: Target Population (2014 2.9)
	private ProjectTargetPopulation targetPopulation;

	// Export Standard Fields
	private Date dateCreated;
	private Date dateUpdated;

	public ProjectDTO() {
	}

	@JsonProperty
	public String getProjectId() {
		return projectId;
	}

	@JsonProperty
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@JsonProperty
	public String getProjectName() {
		return projectName;
	}

	@JsonProperty
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@JsonProperty
	public List<CoCDTO> getProjectCoCs() {
		return projectCoCs;
	}

	@JsonProperty
	public void setProjectCoCs(List<CoCDTO> projectCoCs) {
		this.projectCoCs = projectCoCs;
	}

	@JsonProperty
	public YesNo getContinuumProject() {
		return continuumProject;
	}

	@JsonProperty
	public void setContinuumProject(YesNo continuumProject) {
		this.continuumProject = continuumProject;
	}

	@JsonProperty
	public ProjectType getProjectType() {
		return projectType;
	}

	@JsonProperty
	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	@JsonProperty
	public YesNo getResidentialAffiliation() {
		return residentialAffiliation;
	}

	@JsonProperty
	public void setResidentialAffiliation(YesNo residentialAffiliation) {
		this.residentialAffiliation = residentialAffiliation;
	}

	@JsonProperty
	public String getResProjectId() {
		return resProjectId;
	}

	@JsonProperty
	public void setResProjectId(String resProjectId) {
		this.resProjectId = resProjectId;
	}

	@JsonProperty
	public ProjectTrackingMethod getTrackingMethod() {
		return trackingMethod;
	}

	@JsonProperty
	public void setTrackingMethod(ProjectTrackingMethod trackingMethod) {
		this.trackingMethod = trackingMethod;
	}

	@JsonProperty
	public List<FunderDTO> getFunders() {
		return funders;
	}

	@JsonProperty
	public void setFunders(List<FunderDTO> funders) {
		this.funders = funders;
	}

	@JsonProperty
	public ProjectTargetPopulation getTargetPopulation() {
		return targetPopulation;
	}

	@JsonProperty
	public void setTargetPopulation(ProjectTargetPopulation targetPopulation) {
		this.targetPopulation = targetPopulation;
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
