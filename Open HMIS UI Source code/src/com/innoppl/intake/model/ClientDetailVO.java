package com.innoppl.intake.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
/*
 * @author  Haridharan Durairaj
 * 
 */
@XmlRootElement
public class ClientDetailVO implements Serializable 
{
	
	private static final long serialVersionUID = 1L;
	
	private Long clientKey;
	private String nameMiddle;
	private String nameLast;
	private String nameFirst;
	private String nameSuffix;
	private Integer socSecTypeCode;
	private String socSecNumber;
	private Integer dobTypeCode;
	private String dateOfBirth;
	private Integer veteranStatusGct;
	private Integer recActiveGct;
	private String entryDateTime;
	private Long entryUserKey;
	private String logDateTime;
	private Long logUserKey;
	
	
	private EthnicityVO ethnicityVO;
	private GenderVO genderVO;
	
	public ClientDetailVO()
	{
		super();
		ethnicityVO = new EthnicityVO();
		genderVO = new GenderVO();
	}

	public ClientDetailVO(Long clientKey, String nameMiddle, String nameLast,
			String nameFirst, String nameSuffix, Integer socSecTypeCode,
			String socSecNumber, Integer dobTypeCode, String dateOfBirth,
			Integer veteranStatusGct, Integer recActiveGct,
			String entryDateTime, Long entryUserKey, String logDateTime,
			Long logUserKey) {
		super();
		this.clientKey = clientKey;
		this.nameMiddle = nameMiddle;
		this.nameLast = nameLast;
		this.nameFirst = nameFirst;
		this.nameSuffix = nameSuffix;
		this.socSecTypeCode = socSecTypeCode;
		this.socSecNumber = socSecNumber;
		this.dobTypeCode = dobTypeCode;
		this.dateOfBirth = dateOfBirth;
		this.veteranStatusGct = veteranStatusGct;
		this.recActiveGct = recActiveGct;
		this.entryDateTime = entryDateTime;
		this.entryUserKey = entryUserKey;
		this.logDateTime = logDateTime;
		this.logUserKey = logUserKey;
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

	public String getNameSuffix() {
		return nameSuffix;
	}

	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	public Integer getSocSecTypeCode() {
		return socSecTypeCode;
	}

	public void setSocSecTypeCode(Integer socSecTypeCode) {
		this.socSecTypeCode = socSecTypeCode;
	}

	public String getSocSecNumber() {
		return socSecNumber;
	}

	public void setSocSecNumber(String socSecNumber) {
		this.socSecNumber = socSecNumber;
	}

	public Integer getDobTypeCode() {
		return dobTypeCode;
	}

	public void setDobTypeCode(Integer dobTypeCode) {
		this.dobTypeCode = dobTypeCode;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getVeteranStatusGct() {
		return veteranStatusGct;
	}

	public void setVeteranStatusGct(Integer veteranStatusGct) {
		this.veteranStatusGct = veteranStatusGct;
	}

	public Integer getRecActiveGct() {
		return recActiveGct;
	}

	public void setRecActiveGct(Integer recActiveGct) {
		this.recActiveGct = recActiveGct;
	}

	public String getEntryDateTime() {
		return entryDateTime;
	}

	public void setEntryDateTime(String entryDateTime) {
		this.entryDateTime = entryDateTime;
	}

	public Long getEntryUserKey() {
		return entryUserKey;
	}

	public void setEntryUserKey(Long entryUserKey) {
		this.entryUserKey = entryUserKey;
	}

	public String getLogDateTime() {
		return logDateTime;
	}

	public void setLogDateTime(String logDateTime) {
		this.logDateTime = logDateTime;
	}

	public Long getLogUserKey() {
		return logUserKey;
	}

	public void setLogUserKey(Long logUserKey) {
		this.logUserKey = logUserKey;
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
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result
				+ ((dobTypeCode == null) ? 0 : dobTypeCode.hashCode());
		result = prime * result
				+ ((entryDateTime == null) ? 0 : entryDateTime.hashCode());
		result = prime * result
				+ ((entryUserKey == null) ? 0 : entryUserKey.hashCode());
		result = prime * result
				+ ((ethnicityVO == null) ? 0 : ethnicityVO.hashCode());
		result = prime * result
				+ ((genderVO == null) ? 0 : genderVO.hashCode());
		result = prime * result
				+ ((logDateTime == null) ? 0 : logDateTime.hashCode());
		result = prime * result
				+ ((logUserKey == null) ? 0 : logUserKey.hashCode());
		result = prime * result
				+ ((nameFirst == null) ? 0 : nameFirst.hashCode());
		result = prime * result
				+ ((nameLast == null) ? 0 : nameLast.hashCode());
		result = prime * result
				+ ((nameMiddle == null) ? 0 : nameMiddle.hashCode());
		result = prime * result
				+ ((nameSuffix == null) ? 0 : nameSuffix.hashCode());
		result = prime * result
				+ ((recActiveGct == null) ? 0 : recActiveGct.hashCode());
		result = prime * result
				+ ((socSecNumber == null) ? 0 : socSecNumber.hashCode());
		result = prime * result
				+ ((socSecTypeCode == null) ? 0 : socSecTypeCode.hashCode());
		result = prime
				* result
				+ ((veteranStatusGct == null) ? 0 : veteranStatusGct.hashCode());
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
		ClientDetailVO other = (ClientDetailVO) obj;
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
		if (dobTypeCode == null) {
			if (other.dobTypeCode != null)
				return false;
		} else if (!dobTypeCode.equals(other.dobTypeCode))
			return false;
		if (entryDateTime == null) {
			if (other.entryDateTime != null)
				return false;
		} else if (!entryDateTime.equals(other.entryDateTime))
			return false;
		if (entryUserKey == null) {
			if (other.entryUserKey != null)
				return false;
		} else if (!entryUserKey.equals(other.entryUserKey))
			return false;
		if (ethnicityVO == null) {
			if (other.ethnicityVO != null)
				return false;
		} else if (!ethnicityVO.equals(other.ethnicityVO))
			return false;
		if (genderVO == null) {
			if (other.genderVO != null)
				return false;
		} else if (!genderVO.equals(other.genderVO))
			return false;
		if (logDateTime == null) {
			if (other.logDateTime != null)
				return false;
		} else if (!logDateTime.equals(other.logDateTime))
			return false;
		if (logUserKey == null) {
			if (other.logUserKey != null)
				return false;
		} else if (!logUserKey.equals(other.logUserKey))
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
		if (nameSuffix == null) {
			if (other.nameSuffix != null)
				return false;
		} else if (!nameSuffix.equals(other.nameSuffix))
			return false;
		if (recActiveGct == null) {
			if (other.recActiveGct != null)
				return false;
		} else if (!recActiveGct.equals(other.recActiveGct))
			return false;
		if (socSecNumber == null) {
			if (other.socSecNumber != null)
				return false;
		} else if (!socSecNumber.equals(other.socSecNumber))
			return false;
		if (socSecTypeCode == null) {
			if (other.socSecTypeCode != null)
				return false;
		} else if (!socSecTypeCode.equals(other.socSecTypeCode))
			return false;
		if (veteranStatusGct == null) {
			if (other.veteranStatusGct != null)
				return false;
		} else if (!veteranStatusGct.equals(other.veteranStatusGct))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientDetailVO [clientKey=" + clientKey + ", nameMiddle="
				+ nameMiddle + ", nameLast=" + nameLast + ", nameFirst="
				+ nameFirst + ", nameSuffix=" + nameSuffix
				+ ", socSecTypeCode=" + socSecTypeCode + ", socSecNumber="
				+ socSecNumber + ", dobTypeCode=" + dobTypeCode
				+ ", dateOfBirth=" + dateOfBirth + ", veteranStatusGct="
				+ veteranStatusGct + ", recActiveGct=" + recActiveGct
				+ ", entryDateTime=" + entryDateTime + ", entryUserKey="
				+ entryUserKey + ", logDateTime=" + logDateTime
				+ ", logUserKey=" + logUserKey + ", ethnicityVO=" + ethnicityVO
				+ ", genderVO=" + genderVO + "]";
	}
	
}
