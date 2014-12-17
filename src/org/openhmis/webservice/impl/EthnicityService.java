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
import javax.ws.rs.core.Response;
import javax.ws.rs.WebApplicationException;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.openhmis.domain.Ethnicity;
import org.openhmis.service.EthnicityManager;
import org.openhmis.service.impl.EthnicityManagerImpl;
import org.openhmis.util.HibernateSessionFactory;
import org.openhmis.vo.EthnicityVO;

import org.hibernate.Transaction;
import org.hibernate.Session;

//import org.openhmis.vo.GenderVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Path("/ethnicities")
public class EthnicityService 
{
	private static final Logger log = LoggerFactory.getLogger(EthnicityService.class);
	private EthnicityManager ethnicityManager;
	Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
	
	//GG mod
	Session session = null;
	Transaction tx = null;
	
	public EthnicityService()
	{
		ethnicityManager = new EthnicityManagerImpl();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<EthnicityVO> getEthnicities()
	{
							
		log.debug("getEthnicities");
		List<EthnicityVO> ehnicityVOList = null;
		try
		{
			
			ehnicityVOList = new ArrayList<EthnicityVO>();
			List<Ethnicity> ethnicityList = ethnicityManager.getEthnicities();
			for (Ethnicity e: ethnicityList )
			{
				EthnicityVO ethnicityVO = mapper.map(e, EthnicityVO.class);
				ehnicityVOList.add(ethnicityVO);
			}
			
		
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		
			
		}
		return ehnicityVOList;
	}
	
	@POST
	@Path("/addEthnicity")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public EthnicityVO addEthnicity(JAXBElement<EthnicityVO> ethnicity)
	{
		log.debug("addEthnicity");
		EthnicityVO ethnicityVO = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			ethnicityVO = ethnicity.getValue();
			Ethnicity newEthnicity = mapper.map(ethnicityVO, Ethnicity.class);
			ethnicityManager.addEthnicity(newEthnicity);
			
			//String k = newEthnicity.getEthnicityKey();
			
			session.save(newEthnicity);
			session.getTransaction().commit();
			HibernateSessionFactory.closeSession();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			if( tx != null ) tx.rollback();
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		
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
