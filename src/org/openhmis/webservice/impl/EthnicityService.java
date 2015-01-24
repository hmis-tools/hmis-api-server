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
import org.openhmis.domain.CodeEthnicity;
import org.openhmis.exception.ethnicity.EthnicityNotFoundException;
import org.openhmis.exception.ethnicity.UnableToAddEthnicityException;
import org.openhmis.exception.ethnicity.UnableToUpdateEthnicityException;
import org.openhmis.service.AuthenticateManager;
import org.openhmis.service.EthnicityManager;
import org.openhmis.service.impl.AuthenticateManagerImpl;
import org.openhmis.service.impl.EthnicityManagerImpl;
import org.openhmis.vo.EthnicityVO;


@Path("/ethnicities")
public class EthnicityService 
{
	private static final Logger log = Logger.getLogger(GenderService.class);
	private EthnicityManager ethnicityManager;
	private AuthenticateManager authenticateManager;
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	
	public EthnicityService()
	{
		ethnicityManager = new EthnicityManagerImpl();
		authenticateManager = new AuthenticateManagerImpl();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/ethnicity/{username}/{password}")
	public List<EthnicityVO> getEthnicities(@PathParam("username") String username,@PathParam("password") String password) throws EthnicityNotFoundException
	{
		log.debug("getEthnicities");
		List<EthnicityVO> ehnicityVOList = null;
		try
		{
			boolean isAuthenticate = authenticateManager.authenticateUser(username, password);
			if (isAuthenticate)
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
			else
			{
				throw new WebApplicationException(Response.Status.FORBIDDEN);
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
	@Path("/addEthnicity/{username}/{password}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public EthnicityVO addEthnicity(JAXBElement<EthnicityVO> ethnicity, @PathParam("username") String username, @PathParam("password") String password) throws UnableToAddEthnicityException
	{
		log.debug("addEthnicity");
		EthnicityVO ethnicityVO = null;
		try
		{
			boolean isAuthenticate = authenticateManager.authenticateUser(username, password);
			if(isAuthenticate)
			{
				ethnicityVO = ethnicity.getValue();
				CodeEthnicity newEthnicity = mapper.map(ethnicityVO, CodeEthnicity.class);
				ethnicityManager.addEthnicity(newEthnicity);
			}
			else
			{
				throw new WebApplicationException(Response.Status.FORBIDDEN);
			}
		}
		catch(Exception e)
		{
			log.error("Couldn't add the ethnicity " + e.getMessage());
			throw new UnableToAddEthnicityException(e.getMessage());
		}
		return ethnicityVO;
	}
	
	@PUT
	@Path("/updateEthnicity/{username}/{password}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public EthnicityVO updateEthnicity(JAXBElement<EthnicityVO> ethnicity,@PathParam("username") String username, @PathParam("password") String password)
	{
		log.debug("updateEthnicity");
		EthnicityVO enthnicityVO = null;
		try
		{
			boolean isAuthenticate = authenticateManager.authenticateUser(username, password);
			if(isAuthenticate)
			{
				enthnicityVO = ethnicity.getValue();
				CodeEthnicity updateEthnicity = mapper.map(enthnicityVO, CodeEthnicity.class);
				ethnicityManager.updateEthnicity(updateEthnicity);
			}
			else
			{
				throw new WebApplicationException(Response.Status.FORBIDDEN);
			}
		}
		catch(Exception e)
		{
			log.error("Couldn't update the ethnicity " + e.getMessage());
			throw new UnableToUpdateEthnicityException(e.getMessage());
		}
		return enthnicityVO;
	}

	public EthnicityManager getEthnicityManager() {
		return ethnicityManager;
	}

	public void setEthnicityManager(EthnicityManager ethnicityManager) {
		this.ethnicityManager = ethnicityManager;
	}
}
