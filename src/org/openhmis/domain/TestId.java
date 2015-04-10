/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TestId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TestId implements java.io.Serializable {

	// Fields

	private Integer projectKey;
	private String projectName;
	private Integer projectTypeCode;
	private Integer agencyKey;

	// Constructors

	/** default constructor */
	public TestId() {
	}

	/** full constructor */
	public TestId(Integer projectKey, String projectName,
			Integer projectTypeCode, Integer agencyKey) {
		this.projectKey = projectKey;
		this.projectName = projectName;
		this.projectTypeCode = projectTypeCode;
		this.agencyKey = agencyKey;
	}

	// Property accessors

	@Column(name = "PROJECT_KEY")
	public Integer getProjectKey() {
		return this.projectKey;
	}

	public void setProjectKey(Integer projectKey) {
		this.projectKey = projectKey;
	}

	@Column(name = "PROJECT_NAME", length = 20)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "PROJECT_TYPE_CODE")
	public Integer getProjectTypeCode() {
		return this.projectTypeCode;
	}

	public void setProjectTypeCode(Integer projectTypeCode) {
		this.projectTypeCode = projectTypeCode;
	}

	@Column(name = "AGENCY_KEY")
	public Integer getAgencyKey() {
		return this.agencyKey;
	}

	public void setAgencyKey(Integer agencyKey) {
		this.agencyKey = agencyKey;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TestId))
			return false;
		TestId castOther = (TestId) other;

		return ((this.getProjectKey() == castOther.getProjectKey()) || (this
				.getProjectKey() != null && castOther.getProjectKey() != null && this
				.getProjectKey().equals(castOther.getProjectKey())))
				&& ((this.getProjectName() == castOther.getProjectName()) || (this
						.getProjectName() != null
						&& castOther.getProjectName() != null && this
						.getProjectName().equals(castOther.getProjectName())))
				&& ((this.getProjectTypeCode() == castOther
						.getProjectTypeCode()) || (this.getProjectTypeCode() != null
						&& castOther.getProjectTypeCode() != null && this
						.getProjectTypeCode().equals(
								castOther.getProjectTypeCode())))
				&& ((this.getAgencyKey() == castOther.getAgencyKey()) || (this
						.getAgencyKey() != null
						&& castOther.getAgencyKey() != null && this
						.getAgencyKey().equals(castOther.getAgencyKey())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getProjectKey() == null ? 0 : this.getProjectKey()
						.hashCode());
		result = 37
				* result
				+ (getProjectName() == null ? 0 : this.getProjectName()
						.hashCode());
		result = 37
				* result
				+ (getProjectTypeCode() == null ? 0 : this.getProjectTypeCode()
						.hashCode());
		result = 37 * result
				+ (getAgencyKey() == null ? 0 : this.getAgencyKey().hashCode());
		return result;
	}

}