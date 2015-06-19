/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.service;

import java.util.List;

import org.openhmis.domain.CodeEthnicity;
import org.openhmis.exception.ethnicity.EthnicityAlreadyExistException;
import org.openhmis.exception.ethnicity.EthnicityNotFoundException;
import org.openhmis.exception.ethnicity.UnableToUpdateEthnicityException;


public interface EthnicityManager 
{
	public Boolean addEthnicity(CodeEthnicity ethnicity)throws EthnicityAlreadyExistException;
	public List<Object[]> getEthnicityCodes() throws EthnicityNotFoundException;
	public List<CodeEthnicity> getEthnicities()throws EthnicityNotFoundException;
	public Boolean updateEthnicity(CodeEthnicity ethnicity)throws UnableToUpdateEthnicityException;
}
