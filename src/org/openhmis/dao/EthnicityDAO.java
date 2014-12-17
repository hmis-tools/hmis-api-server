package org.openhmis.dao;

import java.util.List;

import org.openhmis.domain.Ethnicity;

public interface EthnicityDAO extends BaseDAO
{
        public List<Object[]> findEthnicityCodes();
        public List<Ethnicity> findEthnicities();
}