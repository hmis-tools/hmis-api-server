/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GenderVO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1816700800645003203L;
	
	private String genderKey;
	private String description;
	private String active;
	public GenderVO() {
		super();
	}
	public GenderVO(String genderKey, String description, String active) {
		super();
		this.genderKey = genderKey;
		this.description = description;
		this.active = active;
	}
	public String getGenderKey() {
		return genderKey;
	}
	public void setGenderKey(String genderKey) {
		this.genderKey = genderKey;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((genderKey == null) ? 0 : genderKey.hashCode());
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
		GenderVO other = (GenderVO) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (genderKey == null) {
			if (other.genderKey != null)
				return false;
		} else if (!genderKey.equals(other.genderKey))
			return false;
		return true;
	}
	
	
}
