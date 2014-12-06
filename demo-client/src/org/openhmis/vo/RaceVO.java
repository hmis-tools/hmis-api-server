package org.openhmis.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RaceVO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1294761108268233921L;
	
	private String raceKey;
	private String description;
	private String active;
	public RaceVO() {
		super();
	}
	public RaceVO(String raceKey, String description, String active) {
		super();
		this.raceKey = raceKey;
		this.description = description;
		this.active = active;
	}
	public String getRaceKey() {
		return raceKey;
	}
	public void setRaceKey(String raceKey) {
		this.raceKey = raceKey;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((raceKey == null) ? 0 : raceKey.hashCode());
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
		RaceVO other = (RaceVO) obj;
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
		if (raceKey == null) {
			if (other.raceKey != null)
				return false;
		} else if (!raceKey.equals(other.raceKey))
			return false;
		return true;
	}
}
