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
 * Test entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TEST", catalog = "OPENHMIS2")
public class Test implements java.io.Serializable {

	// Fields

	private TestId id;

	// Constructors

	/** default constructor */
	public Test() {
	}

	/** full constructor */
	public Test(TestId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "projectKey", column = @Column(name = "PROJECT_KEY")),
			@AttributeOverride(name = "projectName", column = @Column(name = "PROJECT_NAME", length = 20)),
			@AttributeOverride(name = "projectTypeCode", column = @Column(name = "PROJECT_TYPE_CODE")),
			@AttributeOverride(name = "agencyKey", column = @Column(name = "AGENCY_KEY")) })
	public TestId getId() {
		return this.id;
	}

	public void setId(TestId id) {
		this.id = id;
	}

}