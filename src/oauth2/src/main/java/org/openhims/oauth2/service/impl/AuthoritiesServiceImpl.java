package org.openhims.oauth2.service.impl;

import org.openhims.oauth2.domain.Authorities;
import org.openhims.oauth2.service.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthoritiesServiceImpl implements AuthoritiesService 
{
	@Autowired
	private AuthoritiesDAO authoritiesDAO;
	
	public void saveAuthorities(Authorities authorities)
	{
		this.authoritiesDAO.save(authorities);
	}
}
