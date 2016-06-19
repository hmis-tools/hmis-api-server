package org.openhmis.generator;

public class OrganizationGenerator {

	public OrganizationGenerator() {
	}

	public OrganizationDTO generateOrganizationDTO(TmpOrganization tmpOrganization) {
		OrganizationDTO organizationDTO = new OrganizationDTO();
		organizationDTO.setOrganizationId(tmpOrganization.getOrganizationId().toString());
		organizationDTO.setOrganizationName(tmpOrganization.getOrganizationName());

		// Export Standard Fields
		organizationDTO.setDateCreated(tmpOrganization.getDateCreated());
		organizationDTO.setDateUpdated(tmpOrganization.getDateUpdated());
		
		return organizationDTO;
	}
	
	public TmpOrganization generateTmpOrganization(OrganizationDTO inputDTO) {
		TmpOrganization tmpOrganization = new TmpOrganization();
		
		tmpOrganization.setOrganizationId(Integer.parseInt(inputDTO.getOrganizationId()));
		tmpOrganization.setOrganizationName(inputDTO.getOrganizationName());
		
		return tmpOrganization;
	}
}
	