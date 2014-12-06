package org.openhmis.service.impl;

import java.util.List;

import org.openhmis.dao.EthnicityDAO;
import org.openhmis.dao.impl.EthnicityDAOImpl;
import org.openhmis.domain.Ethnicity;
import org.openhmis.exception.ethnicity.EthnicityAlreadyExistException;
import org.openhmis.service.EthnicityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Ashaar Riaz
 * @since August 23, 2014
 *
 */
public class EthnicityManagerImpl implements EthnicityManager 
{
	private static final Logger log = LoggerFactory.getLogger(EthnicityManagerImpl.class);
	private EthnicityDAO ethnicityDAO = null;
	
	public EthnicityManagerImpl()
	{
		ethnicityDAO = new EthnicityDAOImpl();
	}
	
	@Override
	public List<Object[]> getEthnicityCodes() 
	{
		log.debug("getEthnicityCodes");
		return this.ethnicityDAO.findEthnicityCodes();
	}
	@Override
	public List<Ethnicity> getEthnicities() 
	{
		log.debug("getEthnicities");
		return this.ethnicityDAO.findEthnicities();
	}

	public EthnicityDAO getEthnicityDAO() {
		return ethnicityDAO;
	}

	public void setEthnicityDAO(EthnicityDAO ethnicityDAO) {
		this.ethnicityDAO = ethnicityDAO;
	}

	@Override
	public Boolean addEthnicity(Ethnicity ethnicity)
			throws EthnicityAlreadyExistException 
	{
		log.debug("addEthnicity");
		return ethnicityDAO.save(ethnicity);
	}
}
