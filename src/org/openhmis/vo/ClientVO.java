/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author Ashaar Riaz
 *
 */
@XmlRootElement
public class ClientVO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long clientKey;
	private String nameMiddle;
	private String nameLast;
	private String nameFirst;
	private String socSecNumber;
	private String dateOfBirth;
	
	private String ethnicityDescription;
	private String genderDescription;
	
	public ClientVO() 
	{
		super();
	}
	public ClientVO(Long clientKey) {
		super();
		this.clientKey = clientKey;
	}
	public ClientVO(Long clientKey, String nameMiddle, String nameLast,
			String nameFirst, String socSecNumber, String dateOfBirth) {
		super();
		this.clientKey = clientKey;
		this.nameMiddle = nameMiddle;
		this.nameLast = nameLast;
		this.nameFirst = nameFirst;
		this.socSecNumber = socSecNumber;
		this.dateOfBirth = dateOfBirth;
	}
	public Long getClientKey() {
		return clientKey;
	}
	public void setClientKey(Long clientKey) {
		this.clientKey = clientKey;
	}
	public String getNameMiddle() {
		return nameMiddle;
	}
	public void setNameMiddle(String nameMiddle) {
		this.nameMiddle = nameMiddle;
	}
	public String getNameLast() {
		return nameLast;
	}
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}
	public String getNameFirst() {
		return nameFirst;
	}
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}
	public String getSocSecNumber() {
		return socSecNumber;
	}
	public void setSocSecNumber(String socSecNumber) {
		this.socSecNumber = socSecNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getEthnicityDescription() {
		return ethnicityDescription;
	}
	public void setEthnicityDescription(String ethnicityDescription) {
		this.ethnicityDescription = ethnicityDescription;
	}
	public String getGenderDescription() {
		return genderDescription;
	}
	public void setGenderDescription(String genderDescription) {
		this.genderDescription = genderDescription;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientKey == null) ? 0 : clientKey.hashCode());
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result
				+ ((nameFirst == null) ? 0 : nameFirst.hashCode());
		result = prime * result
				+ ((nameLast == null) ? 0 : nameLast.hashCode());
		result = prime * result
				+ ((nameMiddle == null) ? 0 : nameMiddle.hashCode());
		result = prime * result
				+ ((socSecNumber == null) ? 0 : socSecNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientVO other = (ClientVO) obj;
		if (clientKey == null) {
			if (other.clientKey != null)
				return false;
		} else if (!clientKey.equals(other.clientKey))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (nameFirst == null) {
			if (other.nameFirst != null)
				return false;
		} else if (!nameFirst.equals(other.nameFirst))
			return false;
		if (nameLast == null) {
			if (other.nameLast != null)
				return false;
		} else if (!nameLast.equals(other.nameLast))
			return false;
		if (nameMiddle == null) {
			if (other.nameMiddle != null)
				return false;
		} else if (!nameMiddle.equals(other.nameMiddle))
			return false;
		if (socSecNumber == null) {
			if (other.socSecNumber != null)
				return false;
		} else if (!socSecNumber.equals(other.socSecNumber))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ClientVO [clientKey=" + clientKey + ", nameMiddle="
				+ nameMiddle + ", nameLast=" + nameLast + ", nameFirst="
				+ nameFirst + ", socSecNumber=" + socSecNumber
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
}
