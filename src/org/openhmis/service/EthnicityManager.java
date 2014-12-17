package org.openhmis.service;

import java.util.List;

import org.openhmis.domain.Ethnicity;
import org.openhmis.exception.ethnicity.EthnicityAlreadyExistException;
import org.openhmis.exception.ethnicity.EthnicityNotFoundException;


public interface EthnicityManager 
{
	public Boolean addEthnicity(Ethnicity ethnicity)throws EthnicityAlreadyExistException;
	public List<Object[]> getEthnicityCodes() throws EthnicityNotFoundException;
	public List<Ethnicity> getEthnicities()throws EthnicityNotFoundException;

}
