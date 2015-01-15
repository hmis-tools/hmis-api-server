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
 * CodeStateTId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class CodeStateTId implements java.io.Serializable {

	// Fields

	private Integer codeKey;
	private String shortDescription;

	// Constructors

	/** default constructor */
	public CodeStateTId() {
	}

	/** minimal constructor */
	public CodeStateTId(Integer codeKey) {
		this.codeKey = codeKey;
	}

	/** full constructor */
	public CodeStateTId(Integer codeKey, String shortDescription) {
		this.codeKey = codeKey;
		this.shortDescription = shortDescription;
	}

	// Property accessors

	@Column(name = "CODE_KEY", nullable = false)
	public Integer getCodeKey() {
		return this.codeKey;
	}

	public void setCodeKey(Integer codeKey) {
		this.codeKey = codeKey;
	}

	@Column(name = "SHORT_DESCRIPTION", length = 200)
	public String getShortDescription() {
		return this.shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CodeStateTId))
			return false;
		CodeStateTId castOther = (CodeStateTId) other;

		return ((this.getCodeKey() == castOther.getCodeKey()) || (this
				.getCodeKey() != null && castOther.getCodeKey() != null && this
				.getCodeKey().equals(castOther.getCodeKey())))
				&& ((this.getShortDescription() == castOther
						.getShortDescription()) || (this.getShortDescription() != null
						&& castOther.getShortDescription() != null && this
						.getShortDescription().equals(
								castOther.getShortDescription())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCodeKey() == null ? 0 : this.getCodeKey().hashCode());
		result = 37
				* result
				+ (getShortDescription() == null ? 0 : this
						.getShortDescription().hashCode());
		return result;
	}

}