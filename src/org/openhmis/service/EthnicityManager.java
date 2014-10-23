package org.openhmis.service;

import java.util.List;

import org.openhmis.domain.CodeEthnicity;
import org.openhmis.exception.ethnicity.EthnicityAlreadyExistException;
import org.openhmis.exception.ethnicity.EthnicityNotFoundException;


public interface EthnicityManager 
{
	public Boolean addEthnicity(CodeEthnicity ethnicity)throws EthnicityAlreadyExistException;
	public List<Object[]> getEthnicityCodes() throws EthnicityNotFoundException;
	public List<CodeEthnicity> getEthnicities()throws EthnicityNotFoundException;

}
