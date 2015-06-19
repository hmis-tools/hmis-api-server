/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CodeStateT entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "code_state_t", catalog = "OPENHMIS2")
public class CodeStateT implements java.io.Serializable {

	// Fields

	private CodeStateTId id;

	// Constructors

	/** default constructor */
	public CodeStateT() {
	}

	/** full constructor */
	public CodeStateT(CodeStateTId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeKey", column = @Column(name = "CODE_KEY", nullable = false)),
			@AttributeOverride(name = "shortDescription", column = @Column(name = "SHORT_DESCRIPTION", length = 200)) })
	public CodeStateTId getId() {
		return this.id;
	}

	public void setId(CodeStateTId id) {
		this.id = id;
	}

}