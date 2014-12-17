package org.openhmis.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.openhmis.dao.EthnicityDAO;
import org.openhmis.dao.impl.EthnicityDAOImpl;
import org.openhmis.domain.CodeEthnicity;
import org.openhmis.exception.ethnicity.EthnicityAlreadyExistException;
import org.openhmis.service.EthnicityManager;


/**
 * 
 * @author Ashaar Riaz
 * @since August 23, 2014
 *
 */
public class EthnicityManagerImpl implements EthnicityManager 
{
	private static final Logger log = Logger.getLogger(EthnicityManagerImpl.class);
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
	public List<CodeEthnicity> getEthnicities() 
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
	public Boolean addEthnicity(CodeEthnicity ethnicity)
			throws EthnicityAlreadyExistException 
	{
		log.debug("addEthnicity");
		return ethnicityDAO.save(ethnicity);
	}
}
