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
	
	public static boolean validateSite(SiteDTO inputDTO) {
		// Universal Data Standard: Site (2014, 2.8)

		if(inputDTO.getPrincipalSite() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 2.8.1 (PrincipalSite)", "principalSite is set to an unknown code");

		Pattern validGeocode = Pattern.compile("^[0-9]{6}$");
		Matcher geocodeMatcher = validGeocode.matcher(inputDTO.getGeocode());
		if(inputDTO.getGeocode() != null
		&& !geocodeMatcher.find())
			throw new InvalidParameterException("HUD 2.8.A (Geocode)", "geocode is limited to six digits ^[0-9]{6}$");

		if(inputDTO.getAddress().length() > 100)
			throw new InvalidParameterException("HUD 2.8.2 (Address)", "address is limited to 100 characters");
		
		if(inputDTO.getCity().length() > 50)
			throw new InvalidParameterException("HUD 2.8.3 (City)", "city is limited to 50 characters");

		Pattern validState = Pattern.compile("^[a-zA-Z]{2}$");
		Matcher stateMatcher = validState.matcher(inputDTO.getState());
		if(inputDTO.getState() != null
		&& !stateMatcher.find())
			throw new InvalidParameterException("HUD 2.8.4 (State)", "state is limited to 2 letters ^[a-zA-Z]{2}$");

		Pattern validZip = Pattern.compile("^[0-9]{5}$");
		Matcher zipMatcher = validZip.matcher(inputDTO.getZip());
		if(inputDTO.getZip() != null
		&& !zipMatcher.find())
			throw new InvalidParameterException("HUD 2.8.5 (Zip)", "zip is limited to 5 digits ^[0-9]{5}$");

		return true;
	}
	
}
