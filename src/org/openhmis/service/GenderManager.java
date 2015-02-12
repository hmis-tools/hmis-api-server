/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.service;

import java.util.List;

import org.openhmis.domain.CodeGender;
import org.openhmis.exception.gender.GenderAlreadyExistException;
import org.openhmis.exception.gender.GenderNotFoundException;
import org.openhmis.exception.gender.UnableToUpdateGenderException;

public interface GenderManager 
{
	public Boolean addGender(CodeGender gender) throws GenderAlreadyExistException;
	public List<Object[]> getGenderCodes()throws GenderNotFoundException;															// array of all the gender codes
	public List<CodeGender> getGenders() throws GenderNotFoundException;															// list of all the gender objects
	public Boolean updateGender(CodeGender gender) throws UnableToUpdateGenderException;
}
