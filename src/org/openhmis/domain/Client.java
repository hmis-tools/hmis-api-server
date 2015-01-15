/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Client entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "client", catalog = "openhmis2")

public class Client implements java.io.Serializable {

	    private static final long serialVersionUID = 1L;
	    // Fields
	    private Integer clientKey;
        private Ethnicity ethnicity;
        private Gender gender;
        private String fistName;
        private String lastName;
        private String middleInitial;
        private String ssn;
        private String dob;
        private String veteranStatus;
        private String disablingCondition;
        private List<Race> races = new ArrayList<Race>(0);

        // Constructors

        /** default constructor */
        public Client() {
        }

        /** minimal constructor */
        public Client(Ethnicity ethnicity, Gender gender) {
                this.ethnicity = ethnicity;
                this.gender = gender;
        }

        /** full constructor */
        public Client(Ethnicity ethnicity, Gender gender, String fistName,
                        String lastName, String middleInitial, String ssn, String dob,
                        String veteranStatus, String disablingCondition, List<Race> races) {
                this.ethnicity = ethnicity;
                this.gender = gender;
                this.fistName = fistName;
                this.lastName = lastName;
                this.middleInitial = middleInitial;
                this.ssn = ssn;
                this.dob = dob;
                this.veteranStatus = veteranStatus;
                this.disablingCondition = disablingCondition;
                this.races = races;
        }

        // Property accessors
        @GenericGenerator(name = "generator", strategy = "increment")
        @Id
        @GeneratedValue(generator = "generator")
        @Column(name = "client_key", unique = true, nullable = false)
        public Integer getClientKey() {
                return this.clientKey;
        }

        public void setClientKey(Integer clientKey) {
                this.clientKey = clientKey;
        }

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "ethnicity_key", nullable = false)
        public Ethnicity getEthnicity() {
                return this.ethnicity;
        }

        public void setEthnicity(Ethnicity ethnicity) {
                this.ethnicity = ethnicity;
        }

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "gender_key", nullable = false)
        public Gender getGender() {
                return this.gender;
        }

        public void setGender(Gender gender) {
                this.gender = gender;
        }

        @Column(name = "fist_name", length = 45)
        public String getFistName() {
                return this.fistName;
        }

        public void setFistName(String fistName) {
                this.fistName = fistName;
        }

        @Column(name = "last_name", length = 45)
        public String getLastName() {
                return this.lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
    }

    @Column(name = "middle_initial", length = 45)
    public String getMiddleInitial() {
            return this.middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
            this.middleInitial = middleInitial;
    }

    @Column(name = "ssn", length = 9)
    public String getSsn() {
            return this.ssn;
    }

    public void setSsn(String ssn) {
            this.ssn = ssn;
    }

    @Column(name = "dob", length = 20)
    public String getDob() {
            return this.dob;
    }

    public void setDob(String dob) {
            this.dob = dob;
    }

    @Column(name = "veteran_status", length = 45)
    public String getVeteranStatus() {
            return this.veteranStatus;
    }

    public void setVeteranStatus(String veteranStatus) {
            this.veteranStatus = veteranStatus;
    }

    @Column(name = "disabling_condition", length = 45)
    public String getDisablingCondition() {
            return this.disablingCondition;
    }

    public void setDisablingCondition(String disablingCondition) {
    	this.disablingCondition = disablingCondition;
    }

    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clients")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "client_has_race", catalog = "openhmis2",
    joinColumns = { @JoinColumn(name = "client_key", nullable = false, updatable = false) },
    inverseJoinColumns = { @JoinColumn(name = "race_key", nullable = false, updatable = false) })
    
    public List<Race> getRaces() {
    	return this.races;
    }

    public void setRaces(List<Race> races) {
    	this.races = races;
    }

}

