package org.openhmis.webservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.openhmis.domain.Race;
import org.openhmis.service.RaceManager;
import org.openhmis.service.impl.RaceManagerImpl;
import org.openhmis.vo.RaceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/races")
public class RaceService 
{
	private static final Logger log = LoggerFactory.getLogger(RaceService.class);
	private RaceManager raceManager;
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	public RaceService() 
	{
		raceManager = new RaceManagerImpl();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<RaceVO> getAllRaces()
	{
		log.debug("getAllRaces");
		List<RaceVO> raceVOList = null;
		try
		{
			raceVOList = new ArrayList<RaceVO>();
			List<Race> raceList = raceManager.getRaces();
			for(Race r: raceList)
			{
				RaceVO raceVO = mapper.map(r, RaceVO.class);
				raceVOList.add(raceVO);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return raceVOList;
	}
	
	
	public RaceManager getRaceManager() {
		return raceManager;
	}
	public void setRaceManager(RaceManager raceManager) {
		this.raceManager = raceManager;
	}
}
