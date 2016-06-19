package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openhmis.code.ClientSsnDataQuality;
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
import org.openhmis.dto.search.SiteSearchDTO;
import org.openhmis.exception.InvalidParameterException;

public class SiteManager {
	private TmpProjectSiteDAO tmpProjectSiteDAO;

	public SiteManager() {
		this.tmpProjectSiteDAO = new TmpProjectSiteDAO();
	}
	
	public SiteManager(TmpProjectSiteDAO tmpProjectSiteDAO) {
		this.tmpProjectSiteDAO = tmpProjectSiteDAO;
	}

	public SiteDTO getSiteById(String siteId) {
		SiteDTO siteDTO = SiteManager.generateSiteDTO(tmpProjectSiteDAO.getTmpProjectSiteById(Integer.parseInt(siteId)));
		return siteDTO;
	}

	public List<SiteDTO> getSites(SiteSearchDTO searchDTO) {
		List<SiteDTO> siteDTOs = new ArrayList<SiteDTO>();

		// Collect the sites
		List<TmpProjectSite> tmpProjectSites = tmpProjectSiteDAO.getTmpProjectSites(searchDTO);

		// For each site, collect and map the data
		for (Iterator<TmpProjectSite> iterator = tmpProjectSites.iterator(); iterator.hasNext();) {
			TmpProjectSite tmpProjectSite = iterator.next();
			SiteDTO siteDTO = SiteManager.generateSiteDTO(tmpProjectSite);
			siteDTOs.add(siteDTO);
		}
		return siteDTOs;

	}

	public SiteDTO addSite(SiteDTO inputDTO) {
		
		validateSite(inputDTO);
		
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
	
	public SiteDTO updateSite(SiteDTO inputDTO) {
		
		validateSite(inputDTO);
		
		// Generate a TmpProject from the input
		TmpProjectSite tmpProjectSite = SiteManager.generateTmpProjectSite(inputDTO);
		tmpProjectSite.setSiteId(Integer.parseInt(inputDTO.getSiteId()));
		tmpProjectSite.setDateUpdated(new Date());
		
		// Update the client
		tmpProjectSiteDAO.update(tmpProjectSite);
		
		// Return the resulting VO
		return SiteManager.generateSiteDTO(tmpProjectSite);

	}
	
	public boolean deleteSite(String siteId) {
		TmpProjectSite tmpProjectSite = tmpProjectSiteDAO.getTmpProjectSiteById(Integer.parseInt(siteId));
		tmpProjectSiteDAO.delete(tmpProjectSite);
		
		return true;
	}
	
}
