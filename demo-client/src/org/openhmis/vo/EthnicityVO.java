package org.openhmis.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EthnicityVO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6834343043981583144L;
	
	private String ethnicityKey;
	private String description;
	private String active;
	public EthnicityVO() {
		super();
	}
	public EthnicityVO(String ethnicityKey, String description, String active) {
		super();
		this.ethnicityKey = ethnicityKey;
		this.description = description;
		this.active = active;
	}
	public String getEthnicityKey() {
		return ethnicityKey;
	}
	public void setEthnicityKey(String ethnicityKey) {
		this.ethnicityKey = ethnicityKey;
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
				+ ((ethnicityKey == null) ? 0 : ethnicityKey.hashCode());
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
		EthnicityVO other = (EthnicityVO) obj;
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
		if (ethnicityKey == null) {
			if (other.ethnicityKey != null)
				return false;
		} else if (!ethnicityKey.equals(other.ethnicityKey))
			return false;
		return true;
	}
	
	

}
