/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.dao;

import java.util.List;

import org.hibernate.Query;
import org.openhmis.domain.PathClient;

public class ClientDAO extends BaseDAO {

	// default constructor
	public ClientDAO() { }
	
	public Boolean validateClient(PathClient client) {
		return Boolean.TRUE;
	}

	public PathClient findClientByClientKey(Integer clientKey)  {
		try {
			String queryString = "select client " + 
				"from PathClient as client " + 
				"where client.clientKey =:clientKey";

			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter("clientKey", clientKey);
			queryObject.setMaxResults(1);
			return (PathClient)queryObject.list().get(0);
		}
		catch (RuntimeException re) {
			throw re;
		}
	}
}