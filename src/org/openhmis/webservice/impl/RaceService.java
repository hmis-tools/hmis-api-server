/* Copyright (c) 2014 Pathways Community Network Institute
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package org.openhmis.webservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.openhmis.domain.CodeRace;
import org.openhmis.exception.race.RaceNotFoundException;
import org.openhmis.service.RaceManager;
import org.openhmis.service.impl.RaceManagerImpl;
import org.openhmis.vo.RaceVO;

@Path("/races")
public class RaceService 
{
	private static final Logger log = Logger.getLogger(RaceService.class);
	private RaceManager raceManager;
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	public RaceService() 
	{
		raceManager = new RaceManagerImpl();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<RaceVO> getAllRaces() throws RaceNotFoundException
	{
		log.debug("getAllRaces");
		List<RaceVO> raceVOList = null;
		try
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
		catch(Exception e)
		{
			log.error("Couldn't found the Race " + e.getMessage());
			throw new RaceNotFoundException(e.getMessage());
		}
		return raceVOList;
	}
	
// will update it later as Client Relationship with Race is stored in separate table	
	
//	@Path("/clientRace/{clientKey}")
//	@GET
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//	public List<RaceVO> getRacesByClientKey(@PathParam("clientKey") Long clientKey) throws RaceNotFoundException
//	{
//		log.debug("getRacesByClientKey");
//		List<RaceVO> raceVOList = null;
//		try
//		{
//			raceVOList = new ArrayList<RaceVO>();
//			List<CodeRace> raceList = raceManager.getRacesByClientKey(clientKey);
//			if ((raceList == null) || (raceList.isEmpty()))
//			{
//				throw new RaceNotFoundException("No Race Found.");
//			}
//			for(CodeRace r: raceList)
//			{
//				RaceVO raceVO = mapper.map(r, RaceVO.class);
//				raceVOList.add(raceVO);
//			}
//		}
//		catch(Exception e)
//		{
//			log.error("");
//			throw new RaceNotFoundException(e.getMessage());
//		}
//		return raceVOList;
//	}
	
	
	
	public RaceManager getRaceManager() {
		return raceManager;
	}
	public void setRaceManager(RaceManager raceManager) {
		this.raceManager = raceManager;
	}
}
