package org.openhmis.generator;

public class SiteGenerator {

	public SiteGenerator() {
	}
	
	public SiteDTO generateSiteDTO(TmpProjectSite tmpProjectSite) {
		SiteDTO siteDTO = new SiteDTO();
		siteDTO.setSiteId(tmpProjectSite.getSiteId().toString());
		siteDTO.setProjectCoCId(tmpProjectSite.getProjectCoCid().toString());

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
	
	public TmpProjectSite generateTmpProjectSite(SiteDTO inputDTO) {
		TmpProjectSite tmpProjectSite = new TmpProjectSite();
		
		tmpProjectSite.setProjectCoCid(Integer.parseInt(inputDTO.getProjectCoCId()));
		
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