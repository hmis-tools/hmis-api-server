package org.openhmis.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;



/**
 * @author adeel.butt
 *
 */
@XmlRootElement
public class ClientVO 
{
	private Integer clientKey;
	private String fistName;
	private String lastName;
	private String middleInitial;
	private String ssn;
	private String dob;
	private String veteranStatus;
	private String disablingCondition;
	
	private List<RaceVO> racesVO = null;
	
	private EthnicityVO ethnicityVO = null;
	private GenderVO genderVO = null;
	public ClientVO() 
	{
		super();
		racesVO = new ArrayList<RaceVO>();
		ethnicityVO = new EthnicityVO();
		genderVO = new GenderVO();
	}
	public ClientVO(Integer clientKey, String fistName, String lastName,
			String middleInitial, String ssn, String dob, String veteranStatus,
			String disablingCondition) {
		super();
		this.clientKey = clientKey;
		this.fistName = fistName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.ssn = ssn;
		this.dob = dob;
		this.veteranStatus = veteranStatus;
		this.disablingCondition = disablingCondition;
	}
	public Integer getClientKey() {
		return clientKey;
	}
	public void setClientKey(Integer clientKey) {
		this.clientKey = clientKey;
	}
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getVeteranStatus() {
		return veteranStatus;
	}
	public void setVeteranStatus(String veteranStatus) {
		this.veteranStatus = veteranStatus;
	}
	public String getDisablingCondition() {
		return disablingCondition;
	}
	public void setDisablingCondition(String disablingCondition) {
		this.disablingCondition = disablingCondition;
	}
	
	public List<RaceVO> getRacesVO() {
		return racesVO;
	}
	public void setRacesVO(List<RaceVO> racesVO) {
		this.racesVO = racesVO;
	}
	public EthnicityVO getEthnicityVO() {
		return ethnicityVO;
	}
	public void setEthnicityVO(EthnicityVO ethnicityVO) {
		this.ethnicityVO = ethnicityVO;
	}
	public GenderVO getGenderVO() {
		return genderVO;
	}
	public void setGenderVO(GenderVO genderVO) {
		this.genderVO = genderVO;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clientKey == null) ? 0 : clientKey.hashCode());
		result = prime
				* result
				+ ((disablingCondition == null) ? 0 : disablingCondition
						.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result
				+ ((fistName == null) ? 0 : fistName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleInitial == null) ? 0 : middleInitial.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		result = prime * result
				+ ((veteranStatus == null) ? 0 : veteranStatus.hashCode());
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
		if (disablingCondition == null) {
			if (other.disablingCondition != null)
				return false;
		} else if (!disablingCondition.equals(other.disablingCondition))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (fistName == null) {
			if (other.fistName != null)
				return false;
		} else if (!fistName.equals(other.fistName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleInitial == null) {
			if (other.middleInitial != null)
				return false;
		} else if (!middleInitial.equals(other.middleInitial))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		if (veteranStatus == null) {
			if (other.veteranStatus != null)
				return false;
		} else if (!veteranStatus.equals(other.veteranStatus))
			return false;
		return true;
	}
}
