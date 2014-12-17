package org.openhmis.webservice.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.openhmis.domain.CodeEthnicity;
import org.openhmis.exception.ethnicity.EthnicityNotFoundException;
import org.openhmis.exception.ethnicity.UnableToAddEthnicityException;
import org.openhmis.service.EthnicityManager;
import org.openhmis.service.impl.EthnicityManagerImpl;
import org.openhmis.vo.EthnicityVO;

@Path("/ethnicities")
public class EthnicityService 
{
	private static final Logger log = Logger.getLogger(GenderService.class);
	private EthnicityManager ethnicityManager;
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	
	public EthnicityService()
	{
		ethnicityManager = new EthnicityManagerImpl();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<EthnicityVO> getEthnicities() throws EthnicityNotFoundException
	{
		log.debug("getEthnicities");
		List<EthnicityVO> ehnicityVOList = null;
		try
		{
			ehnicityVOList = new ArrayList<EthnicityVO>();
			List<CodeEthnicity> ethnicityList = ethnicityManager.getEthnicities();
			if ((ethnicityList == null) ||(ethnicityList.isEmpty()))
			{
				throw new EthnicityNotFoundException("No Ethnicity Found");
			}
			for (CodeEthnicity e: ethnicityList )
			{
				EthnicityVO ethnicityVO = mapper.map(e, EthnicityVO.class);
				ehnicityVOList.add(ethnicityVO);
			}
		}
		catch(Exception e)
		{
			log.error("Couldn't get the ethnicity " + e.getMessage());
			throw new EthnicityNotFoundException(e.getMessage());
		}
		return ehnicityVOList;
	}
	
	@POST
	@Path("/addEthnicity")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public EthnicityVO addEthnicity(JAXBElement<EthnicityVO> ethnicity) throws UnableToAddEthnicityException
	{
		log.debug("addEthnicity");
		EthnicityVO ethnicityVO = null;
		try
		{
			CodeEthnicity newEthnicity = mapper.map(ethnicityVO, CodeEthnicity.class);
			ethnicityManager.addEthnicity(newEthnicity);
		}
		catch(Exception e)
		{
			log.error("Couldn't add the ethnicity " + e.getMessage());
			throw new UnableToAddEthnicityException(e.getMessage());
		}
		return ethnicityVO;
	}

	public EthnicityManager getEthnicityManager() {
		return ethnicityManager;
	}

	public void setEthnicityManager(EthnicityManager ethnicityManager) {
		this.ethnicityManager = ethnicityManager;
	}
}
