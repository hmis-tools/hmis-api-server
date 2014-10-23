package org.openhmis.dao;

import java.util.List;

import org.openhmis.domain.CodeEthnicity;

public interface EthnicityDAO extends BaseDAO 
{
	public List<Object[]> findEthnicityCodes();
	public List<CodeEthnicity> findEthnicities();
}
