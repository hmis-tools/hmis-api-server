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
import org.openhmis.domain.CodeGender;
import org.openhmis.exception.gender.GenderNotFoundException;
import org.openhmis.exception.gender.UnableToAddGenderException;
import org.openhmis.exception.gender.UnableToUpdateGenderException;
import org.openhmis.service.AuthenticateManager;
import org.openhmis.service.GenderManager;
import org.openhmis.service.impl.AuthenticateManagerImpl;
import org.openhmis.service.impl.GenderManagerImpl;
import org.openhmis.vo.GenderVO;


@Path("/genders")
public class GenderService 
{
	private static final Logger log = Logger.getLogger(GenderService.class);
	private GenderManager genderManager;
	private AuthenticateManager authenticateManager;
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	public GenderService()
	{
		genderManager = new GenderManagerImpl();
		authenticateManager = new AuthenticateManagerImpl();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/gender/{username}/{password}")
	public List<GenderVO> getAllGenders(@PathParam("username") String username, @PathParam("password") String password) throws GenderNotFoundException
	{
		log.debug("getAllGenders");
		List<GenderVO> genderVOList = null;
		try
		{
			boolean isAutenticate = authenticateManager.authenticateUser(username, password);
			if(isAutenticate)
			{
				genderVOList = new ArrayList<GenderVO>();
				List<CodeGender> genderList = genderManager.getGenders();
				if ((genderList == null) || (genderList.isEmpty()))
				{
					throw new GenderNotFoundException("No Gender Found");
				}
				log.debug("retrieve gender list" + genderList.toString());
				for (CodeGender g: genderList)
				{
					GenderVO genderVO = mapper.map(g, GenderVO.class);
					genderVOList.add(genderVO);
				}
			}
			else
			{
				throw new WebApplicationException(Response.Status.FORBIDDEN);
			}
		}
		catch(Exception e)
		{
			log.error("exception in get All Genders");
			throw new GenderNotFoundException(e.getMessage());
		}
		return genderVOList;
	}
	
	@Path("/addGender/{username}/{password}")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public GenderVO addGender(JAXBElement<GenderVO> gender, @PathParam("username") String username, @PathParam("password") String password)
	{
		log.debug("addGender");
		GenderVO genderVO = null;
		try
		{
			boolean isAuthenticate = authenticateManager.authenticateUser(username, password);
			if (isAuthenticate)
			{
				genderVO = gender.getValue();
				CodeGender newGender = mapper.map(genderVO, CodeGender.class);
				genderManager.addGender(newGender);
			}
			else
			{
				throw new WebApplicationException(Response.Status.FORBIDDEN);
			}
		}
		catch(Exception e)
		{
			log.error("Couldn't add the gender " + e.getMessage());
			throw new UnableToAddGenderException(e.getMessage());
		}
		return genderVO;
	}
	@Path("/updateGender/{username}/{password}")
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public GenderVO updateGender(JAXBElement<GenderVO> gender,@PathParam("username") String username , @PathParam("password") String password)
	{
		log.debug("updateGender");
		GenderVO genderVO = null;
		try
		{
			boolean isAuthenticate = authenticateManager.authenticateUser(username, password);
			if(isAuthenticate)
			{
				genderVO = gender.getValue();
				CodeGender updateGender = mapper.map(genderVO, CodeGender.class);
				genderManager.updateGender(updateGender);
			}
			else
			{
				throw new WebApplicationException(Response.Status.FORBIDDEN);
			}
		}
		catch(Exception e)
		{
			log.error("Couldn't update the ethnicity " + e.getMessage());
			throw new UnableToUpdateGenderException(e.getMessage());
		}
		return genderVO;
		
	}
	public GenderManager getGenderManager() {
		return genderManager;
	}
	public void setGenderManager(GenderManager genderManager) {
		this.genderManager = genderManager;
	}
}
