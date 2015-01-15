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
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.openhmis.domain.Gender;
import org.openhmis.service.GenderManager;
import org.openhmis.service.impl.GenderManagerImpl;
//import org.openhmis.vo.ClientVO;
import org.openhmis.vo.GenderVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.openhmis.util.*;

@Path("/genders")
public class GenderService 
{
	private static final Logger log = LoggerFactory.getLogger(GenderService.class);
	private GenderManager genderManager;
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	Session session = null;
	Transaction tx = null;
	public GenderService()
	
	{
		genderManager = new GenderManagerImpl();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<GenderVO> getAllGenders()
	{
		log.debug("getAllGenders");
		List<GenderVO> genderVOList = null;
		try
		{
			genderVOList = new ArrayList<GenderVO>();
			List<Gender> genderList = genderManager.getGenders();
			log.debug("retrieve gender list" + genderList.toString());
			for (Gender g: genderList)
			{
				GenderVO genderVO = mapper.map(g, GenderVO.class);
				genderVOList.add(genderVO);
			}
		}
		catch(Exception e)
		{
			log.error("exception in get All Genders");
			e.printStackTrace();
		}
		return genderVOList;
	}
	
	@Path("/addGender")
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public GenderVO addGender(JAXBElement<GenderVO> gender)
	{
		log.debug("addGender");
		GenderVO genderVO = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			
			genderVO = gender.getValue();
			Gender newGender = mapper.map(genderVO, Gender.class);
			genderManager.addGender(newGender);
		
			session.save(newGender);
			session.getTransaction().commit();
			HibernateSessionFactory.closeSession();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			if( tx != null ) tx.rollback();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
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
