/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.openhmis.dao.GenderDAO;
import org.openhmis.dao.impl.GenderDAOImpl;
import org.openhmis.domain.CodeGender;
import org.openhmis.exception.gender.GenderAlreadyExistException;
import org.openhmis.exception.gender.UnableToUpdateGenderException;
import org.openhmis.service.GenderManager;


/**
 * 
 * @author Ashaar Riaz
 * @since  August 23, 2014
 *
 */
public class GenderManagerImpl implements GenderManager 
{
	private static final Logger log = Logger.getLogger(GenderManagerImpl.class);
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
	public Boolean updateGender(CodeGender gender)
			throws UnableToUpdateGenderException 
	{
		log.debug("updateGender");
		return this.genderDAO.update(gender);
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
