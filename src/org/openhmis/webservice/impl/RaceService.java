/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.webservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.openhmis.domain.CodeRace;
import org.openhmis.exception.race.RaceNotFoundException;
import org.openhmis.exception.race.UnableToAddRaceException;
import org.openhmis.exception.race.UnableToUpdateRaceException;
import org.openhmis.service.AuthenticateManager;
import org.openhmis.service.RaceManager;
import org.openhmis.service.impl.AuthenticateManagerImpl;
import org.openhmis.service.impl.RaceManagerImpl;
import org.openhmis.vo.RaceVO;

@Path("/races")
public class RaceService 
{
	private static final Logger log = Logger.getLogger(RaceService.class);
	private RaceManager raceManager;
	private AuthenticateManager authenticateManager;
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	public RaceService() 
	{
		raceManager = new RaceManagerImpl();
		authenticateManager = new AuthenticateManagerImpl();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/race/{username}/{password}")
	public List<RaceVO> getAllRaces(@PathParam("username") String username, @PathParam("password") String password) throws RaceNotFoundException
	{
		log.debug("getAllRaces");
		List<RaceVO> raceVOList = null;
		try
		{
			boolean isAuthenticate = authenticateManager.authenticateUser(username, password);
			if (isAuthenticate)
			{
				raceVOList = new ArrayList<RaceVO>();
				List<CodeRace> raceList = raceManager.getRaces();
				if ((raceList == null) || (raceList.isEmpty()))
				{
					throw new RaceNotFoundException("No Race Found.");
				}
				for(CodeRace r: raceList)
				{
					RaceVO raceVO = mapper.map(r, RaceVO.class);
					raceVOList.add(raceVO);
				}
			}
			else
			{
				throw new WebApplicationException(Response.Status.FORBIDDEN);
			}
		}
		catch(Exception e)
		{
			log.error("Couldn't found the Race " + e.getMessage());
			throw new RaceNotFoundException(e.getMessage());
		}
		return raceVOList;
	}
	
	@Path("/updateRace/{username}/{password}")
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public RaceVO updateRace(JAXBElement<RaceVO> race,@PathParam("username") String username , @PathParam("password") String password)
	{
		log.debug("update Race");
		RaceVO raceVO = null;
		try
		{
			boolean isAuthenticate = authenticateManager.authenticateUser(username, password);
			if (isAuthenticate)
			{
				raceVO = race.getValue();
				CodeRace updateRace = mapper.map(raceVO, CodeRace.class);
				raceManager.updateRace(updateRace);
			}
			else
			{
				throw new WebApplicationException(Response.Status.FORBIDDEN);
			}
		}
		catch(Exception e)
		{
			log.error("Couldn't update the ethnicity " + e.getMessage());
			throw new UnableToUpdateRaceException(e.getMessage());
		}
		return raceVO;
	}
	
	@Path("/addRace/{username}/{password}")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public RaceVO addRace(JAXBElement<RaceVO> race, @PathParam("username") String username, @PathParam("password") String password)
	{
		log.debug("add Race");
		RaceVO raceVO = null;
		try
		{
			boolean isAuthenticate = authenticateManager.authenticateUser(username, password);
			if (isAuthenticate)
			{
				raceVO = race.getValue();
				CodeRace newRace = mapper.map(raceVO, CodeRace.class);
				raceManager.addRace(newRace);
			}
			else
			{
				throw new WebApplicationException(Response.Status.FORBIDDEN);
			}
		}
		catch(Exception e)
		{
			log.error("Couldn't add the race " + e.getMessage());
			throw new UnableToAddRaceException(e.getMessage());
		}
		return raceVO;
	}	
	public RaceManager getRaceManager() {
		return raceManager;
	}
	public void setRaceManager(RaceManager raceManager) {
		this.raceManager = raceManager;
	}
}
