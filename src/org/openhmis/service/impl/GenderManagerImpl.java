package org.openhmis.service.impl;

import java.util.List;

import org.openhmis.dao.GenderDAO;
import org.openhmis.dao.impl.GenderDAOImpl;
import org.openhmis.domain.CodeGender;
import org.openhmis.domain.Gender;
import org.openhmis.exception.gender.GenderAlreadyExistException;
import org.openhmis.service.GenderManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Ashaar Riaz
 * @since  August 23, 2014
 *
 */
public class GenderManagerImpl implements GenderManager 
{
	private static final Logger log = LoggerFactory.getLogger(GenderManagerImpl.class);
	private GenderDAO genderDAO = null;
	
	// default Constructor
	public GenderManagerImpl()
	{
		this.genderDAO = new GenderDAOImpl();
	}
		
	@Override
	public Boolean addGender(CodeGender gender) throws GenderAlreadyExistException
	{
		return genderDAO.save(gender);
	}

	@Override
	public List<Object[]> getGenderCodes() 
	{
		log.debug("getGenderCodes");
		return this.genderDAO.findGenderCodes();
	}
	@Override
	public List<CodeGender> getGenders() 
	{
		log.debug("getGenders");
		return this.genderDAO.findGenders();
	}
	public GenderDAO getGenderDAO() {
		return genderDAO;
	}
	public void setGenderDAO(GenderDAO genderDAO) {
		this.genderDAO = genderDAO;
	}
}
