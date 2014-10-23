package org.openhmis.webservice.resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.openhmis.dao.ClientDAO;
import org.openhmis.dao.impl.ClientDAOImpl;
import org.openhmis.domain.Client;
import org.openhmis.service.ClientManager;
import org.openhmis.service.impl.ClientManagerImpl;
import org.openhmis.webservice.impl.ClientService;

@ApplicationPath("/app/*")
public class MyApplication extends Application 
{
	@Override
	public Set<Class<?>> getClasses() 
	{
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(ClientService.class);
		classes.add(ClientManager.class);
		classes.add(ClientManagerImpl.class);
		classes.add(ClientDAOImpl.class);
		classes.add(ClientDAO.class);
		classes.add(Client.class);
		return classes;
	}	
}
