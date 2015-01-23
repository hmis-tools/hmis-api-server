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
 * ClientProgramTempAhar1 entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CLIENT_PROGRAM_TEMP_AHAR1", catalog = "OPENHMIS2")
public class ClientProgramTempAhar1 implements java.io.Serializable {

	// Fields

	private ClientProgramTempAhar1Id id;

	// Constructors

	/** default constructor */
	public ClientProgramTempAhar1() {
	}

	/** full constructor */
	public ClientProgramTempAhar1(ClientProgramTempAhar1Id id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "programKey", column = @Column(name = "PROGRAM_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "clientKey", column = @Column(name = "CLIENT_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "age", column = @Column(name = "AGE", precision = 22, scale = 0)),
			@AttributeOverride(name = "genderKey", column = @Column(name = "GENDER_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "raceKey", column = @Column(name = "RACE_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "ethnicityKey", column = @Column(name = "ETHNICITY_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "veteran", column = @Column(name = "VETERAN", precision = 22, scale = 0)),
			@AttributeOverride(name = "disablingCondition", column = @Column(name = "DISABLING_CONDITION", precision = 22, scale = 0)),
			@AttributeOverride(name = "programNameKey", column = @Column(name = "PROGRAM_NAME_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "programTypeKey", column = @Column(name = "PROGRAM_TYPE_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "agencyKey", column = @Column(name = "AGENCY_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "entryDate1", column = @Column(name = "ENTRY_DATE_1", length = 19)),
			@AttributeOverride(name = "exitDate1", column = @Column(name = "EXIT_DATE_1", length = 19)),
			@AttributeOverride(name = "servedFlag", column = @Column(name = "SERVED_FLAG", length = 2)),
			@AttributeOverride(name = "entryDate", column = @Column(name = "ENTRY_DATE", length = 19)),
			@AttributeOverride(name = "exitDate", column = @Column(name = "EXIT_DATE", length = 19)),
			@AttributeOverride(name = "householdKey", column = @Column(name = "HOUSEHOLD_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "noHousehold", column = @Column(name = "NO_HOUSEHOLD", length = 2)),
			@AttributeOverride(name = "householdSize", column = @Column(name = "HOUSEHOLD_SIZE", precision = 22, scale = 0)),
			@AttributeOverride(name = "familyFlag", column = @Column(name = "FAMILY_FLAG", length = 2)),
			@AttributeOverride(name = "numOfAdult", column = @Column(name = "NUM_OF_ADULT", precision = 22, scale = 0)),
			@AttributeOverride(name = "numOfChild", column = @Column(name = "NUM_OF_CHILD", precision = 22, scale = 0)),
			@AttributeOverride(name = "numOfUnknown", column = @Column(name = "NUM_OF_UNKNOWN", precision = 22, scale = 0)),
			@AttributeOverride(name = "priorNightsResidenceKey", column = @Column(name = "PRIOR_NIGHTS_RESIDENCE_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "zipcodeLastPermAddress", column = @Column(name = "ZIPCODE_LAST_PERM_ADDRESS", length = 50)),
			@AttributeOverride(name = "lengthOfStayKey", column = @Column(name = "LENGTH_OF_STAY_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "zipQualityCode", column = @Column(name = "ZIP_QUALITY_CODE", precision = 22, scale = 0)),
			@AttributeOverride(name = "recordId", column = @Column(name = "RECORD_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "groupKey", column = @Column(name = "GROUP_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "dateEntered", column = @Column(name = "DATE_ENTERED", length = 19)),
			@AttributeOverride(name = "dateLeft", column = @Column(name = "DATE_LEFT", length = 19)),
			@AttributeOverride(name = "firstEntry", column = @Column(name = "FIRST_ENTRY", length = 2)),
			@AttributeOverride(name = "dateOfBirth", column = @Column(name = "DATE_OF_BIRTH", length = 19)),
			@AttributeOverride(name = "housingStatusEntryDate", column = @Column(name = "HOUSING_STATUS_ENTRY_DATE", length = 19)),
			@AttributeOverride(name = "destinationKey", column = @Column(name = "DESTINATION_KEY", precision = 22, scale = 0)),
			@AttributeOverride(name = "lastEntry", column = @Column(name = "LAST_ENTRY", length = 2)),
			@AttributeOverride(name = "lastExit", column = @Column(name = "LAST_EXIT", length = 2)),
			@AttributeOverride(name = "newClientStatus", column = @Column(name = "NEW_CLIENT_STATUS", length = 2)) })
	public ClientProgramTempAhar1Id getId() {
		return this.id;
	}

	public void setId(ClientProgramTempAhar1Id id) {
		this.id = id;
	}

}