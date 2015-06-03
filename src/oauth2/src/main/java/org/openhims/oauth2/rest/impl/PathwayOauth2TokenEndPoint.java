package org.openhims.oauth2.rest.impl;

import java.security.Principal;
import java.util.Collection;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PathwayOauth2TokenEndPoint 
{
	@RequestMapping("/oauth/clients/{client}/tokens")
	public Collection listTokensForUser(@PathVariable String client) throws Exception
	{
		return null;
	}
	
	@RequestMapping("/oauth/")
	public Collection revokeTokenForUser(@PathVariable String user, @PathVariable String client, Principal principal)
	{
		return null;
	}
	
	@RequestMapping("/oauth/token")
	public Response createAccessToken()
	{
		
	}
	
}
