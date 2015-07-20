/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.domain;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * ClientRace entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_RACE")
public class ClientRace implements java.io.Serializable {

	// Universal Fields
	private Integer clientKey;
	private Integer raceKey;

	// Compass Fields
	private Integer primaryKey;
	private Timestamp updateTimestamp;
	private String migrationFlag;


	// Constructors

	/** default constructor */
	public ClientRace() {
	}

	// Property accessors
	@Column(name = "CLIENT_KEY") // BIGINT(20)
	public Integer getClientKey() {
		return this.clientKey;
	}
	public void setClientKey(Integer clientKey) {
		this.clientKey = clientKey;
	}
	
	@Column(name = "RACE_KEY") // BIGINT(20)
	public Integer getRaceKey() {
		return this.raceKey;
	}
	public void setRaceKey(Integer raceKey) {
		this.raceKey = raceKey;
	}
	
	@Column(name = "PRIMARY_KEY") // BIGINT(20)
	public Integer getPrimaryKey() {
		return this.primaryKey;
	}
	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	@Column(name = "UPDATE_TIMESTAMP") // TIMESTAMP
	public Timestamp getUpdateTimestamp() {
		return this.updateTimestamp;
	}
	public void setUpdateTimestamp(Timestamp updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	@Column(name = "MIGRATION_FLAG") // CHAR(2)
	public String getMigrationFlag() {
		return this.migrationFlag;
	}
	public void setMigrationFlag(String migrationFlag) {
		this.migrationFlag = migrationFlag;
	}

}