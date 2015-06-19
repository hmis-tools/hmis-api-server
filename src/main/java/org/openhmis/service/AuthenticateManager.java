/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.service;

import org.openhmis.exception.oauth2.UnableToAuthorizeException;

public interface AuthenticateManager 
{
	public boolean authenticateUser(String username, String password) throws UnableToAuthorizeException;
}
