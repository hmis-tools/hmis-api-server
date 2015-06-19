/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Gender entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gender", catalog = "openhmis2")
public class Gender implements java.io.Serializable {

	// Fields

	private String genderKey;
	private String description;
	private String active;
	private Set<Client> clients = new HashSet<Client>(0);

	// Constructors

	/** default constructor */
	public Gender() {
	}

	/** full constructor */
	public Gender(String description, String active, Set<Client> clients) {
		this.description = description;
		this.active = active;
		this.clients = clients;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "gender_key", unique = true, nullable = false, length = 20)
	public String getGenderKey() {
		return this.genderKey;
	}

	public void setGenderKey(String genderKey) {
		this.genderKey = genderKey;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "active", length = 20)
	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "gender")
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}