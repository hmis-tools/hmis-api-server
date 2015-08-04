package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.code.YesNo;
import org.openhmis.dao.TmpProjectSiteDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpProjectSite;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.SiteDTO;

public class SiteManager {
	private static final TmpProjectSiteDAO tmpProjectSiteDAO = new TmpProjectSiteDAO();

	public SiteManager() {}

	public static SiteDTO getSiteBySiteId(String siteId) {
		SiteDTO siteDTO = SiteManager.generateSiteDTO(tmpProjectSiteDAO.getTmpProjectSiteBySiteId(Integer.parseInt(siteId)));
		return siteDTO;
	}

	public static List<SiteDTO> getSitesByProjectCoCId(String projectCoCId) {
		List<SiteDTO> siteDTOs = new ArrayList<SiteDTO>();

		// Collect the sites
		List<TmpProjectSite> tmpProjectSites = tmpProjectSiteDAO.getTmpProjectSitesByProjectCoCId(Integer.parseInt(projectCoCId));

		// For each site, collect and map the data
		for (Iterator<TmpProjectSite> iterator = tmpProjectSites.iterator(); iterator.hasNext();) {
			TmpProjectSite tmpProjectSite = iterator.next();
			SiteDTO siteDTO = SiteManager.generateSiteDTO(tmpProjectSite);
			siteDTOs.add(siteDTO);
		}
		return siteDTOs;

	}
	
	public static SiteDTO addSite(SiteDTO inputDTO) {
		// Generate a PathClient from the input
		TmpProjectSite tmpProjectSite = SiteManager.generateTmpProjectSite(inputDTO);
		
		// Set Export fields
		tmpProjectSite.setDateCreated(new Date());
		tmpProjectSite.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpProjectSiteDAO.save(tmpProjectSite);
		inputDTO.setSiteId(tmpProjectSite.getSiteId().toString());
		
		// Return the resulting VO
		return SiteManager.generateSiteDTO(tmpProjectSite);
	}
	
	public static SiteDTO updateSite(SiteDTO inputDTO) {
		// Generate a TmpProject from the input
		TmpProjectSite tmpProjectSite = SiteManager.generateTmpProjectSite(inputDTO);
		tmpProjectSite.setSiteId(Integer.parseInt(inputDTO.getSiteId()));
		tmpProjectSite.setDateUpdated(new Date());
		
		// Update the client
		tmpProjectSiteDAO.update(tmpProjectSite);
		
		// Return the resulting VO
		return SiteManager.generateSiteDTO(tmpProjectSite);

	}
	
	public static boolean deleteSite(String siteId) {
		TmpProjectSite tmpProjectSite = tmpProjectSiteDAO.getTmpProjectSiteBySiteId(Integer.parseInt(siteId));
		tmpProjectSiteDAO.delete(tmpProjectSite);
		
		return true;
	}
	
	public static SiteDTO generateSiteDTO(TmpProjectSite tmpProjectSite) {
		SiteDTO siteDTO = new SiteDTO();
		siteDTO.setProjectCoCId(tmpProjectSite.getProjectCoCId().toString());

		// Universal Data Standard: Site (2014, 2.8) 
		siteDTO.setPrincipalSite(YesNo.valueByCode(tmpProjectSite.getPrincipalSite()));
		siteDTO.setGeocode(tmpProjectSite.getGeocode());
		siteDTO.setAddress(tmpProjectSite.getAddress());
		siteDTO.setCity(tmpProjectSite.getCity());
		siteDTO.setState(tmpProjectSite.getState());
		siteDTO.setZip(tmpProjectSite.getZip());

		// Export Standard Fields
		siteDTO.setDateCreated(tmpProjectSite.getDateCreated());
		siteDTO.setDateUpdated(tmpProjectSite.getDateUpdated());
		
		return siteDTO;
	}
	
	public static TmpProjectSite generateTmpProjectSite(SiteDTO inputDTO) {
		TmpProjectSite tmpProjectSite = new TmpProjectSite();
		
		tmpProjectSite.setProjectCoCId(Integer.parseInt(inputDTO.getProjectCoCId()));
		
		// Universal Data Standard: Site (2014, 2.8) 
		tmpProjectSite.setPrincipalSite(inputDTO.getPrincipalSite().getCode());
		tmpProjectSite.setGeocode(inputDTO.getGeocode());
		tmpProjectSite.setAddress(inputDTO.getAddress());
		tmpProjectSite.setCity(inputDTO.getCity());
		tmpProjectSite.setState(inputDTO.getState());
		tmpProjectSite.setZip(inputDTO.getZip());
	
		return tmpProjectSite;
	}
	
}