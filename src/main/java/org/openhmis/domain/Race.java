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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Race entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "race", catalog = "openhmis2")
public class Race implements java.io.Serializable {

	// Fields

	private String raceKey;
	private String description;
	private String active;
	private Set<Client> clients = new HashSet<Client>(0);

	// Constructors

	/** default constructor */
	public Race() {
	}

	/** full constructor */
	public Race(String description, String active, Set<Client> clients) {
		this.description = description;
		this.active = active;
		this.clients = clients;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "race_key", unique = true, nullable = false, length = 20)
	public String getRaceKey() {
		return this.raceKey;
	}

	public void setRaceKey(String raceKey) {
		this.raceKey = raceKey;
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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "client_has_race", catalog = "openhmis2", joinColumns = { @JoinColumn(name = "race_key", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "client_key", nullable = false, updatable = false) })
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}