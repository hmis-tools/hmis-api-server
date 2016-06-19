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
import org.openhmis.dao.TmpOrganizationDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpOrganization;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.OrganizationDTO;

public class OrganizationManager {
	private TmpOrganizationDAO tmpOrganizationDAO;

	public OrganizationManager() {
		this.tmpOrganizationDAO = new TmpOrganizationDAO();
	}

	public OrganizationManager(TmpOrganizationDAO tmpOrganizationDAO) {
		this.tmpOrganizationDAO = tmpOrganizationDAO;
	}

	public OrganizationDTO getOrganizationByOrganizationId(String organizationId) {
		OrganizationDTO organizationDTO = OrganizationManager.generateOrganizationDTO(tmpOrganizationDAO.getTmpOrganizationById(Integer.parseInt(organizationId)));
		return organizationDTO;
	}

	public List<OrganizationDTO> getOrganizations() {
		List<OrganizationDTO> organizationDTOs = new ArrayList<OrganizationDTO>();

		// Collect the organizations
		List<TmpOrganization> tmpOrganizations = tmpOrganizationDAO.getTmpOrganizations();

		// For each organization, collect and map the data
		for (Iterator<TmpOrganization> iterator = tmpOrganizations.iterator(); iterator.hasNext();) {
			TmpOrganization tmpOrganization = iterator.next();
			OrganizationDTO organizationDTO = OrganizationManager.generateOrganizationDTO(tmpOrganization);
			organizationDTOs.add(organizationDTO);
		}
		return organizationDTOs;

	}

	public List<OrganizationDTO> getOrganizationsByUpdateDate(Date updateDate) {
		List<OrganizationDTO> organizationDTOs = new ArrayList<OrganizationDTO>();

		// Collect the organizations
		List<TmpOrganization> tmpOrganizations = tmpOrganizationDAO.getTmpOrganizationsByUpdateDate(updateDate);

		// For each organization, collect and map the data
		for (Iterator<TmpOrganization> iterator = tmpOrganizations.iterator(); iterator.hasNext();) {
			TmpOrganization tmpOrganization = iterator.next();
			OrganizationDTO organizationDTO = OrganizationManager.generateOrganizationDTO(tmpOrganization);
			organizationDTOs.add(organizationDTO);
		}
		return organizationDTOs;

	}
	
	public OrganizationDTO addOrganization(OrganizationDTO inputDTO) {
		// Generate a PathClient from the input
		TmpOrganization tmpOrganization = OrganizationManager.generateTmpOrganization(inputDTO);
		
		// Set Export fields
		tmpOrganization.setDateCreated(new Date());
		tmpOrganization.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpOrganizationDAO.save(tmpOrganization);
		inputDTO.setOrganizationId(tmpOrganization.getOrganizationId().toString());
		
		// Return the resulting VO
		return OrganizationManager.generateOrganizationDTO(tmpOrganization);
	}
	
	public OrganizationDTO updateOrganization(OrganizationDTO inputDTO) {
		// Generate a TmpProject from the input
		TmpOrganization tmpOrganization = OrganizationManager.generateTmpOrganization(inputDTO);
		tmpOrganization.setOrganizationId(Integer.parseInt(inputDTO.getOrganizationId()));
		tmpOrganization.setDateUpdated(new Date());
		
		// Update the client
		tmpOrganizationDAO.update(tmpOrganization);
		
		// Return the resulting VO
		return OrganizationManager.generateOrganizationDTO(tmpOrganization);

	}
	
	public boolean deleteOrganization(String organizationId) {
		TmpOrganization tmpOrganization = tmpOrganizationDAO.getTmpOrganizationById(Integer.parseInt(organizationId));
		tmpOrganizationDAO.delete(tmpOrganization);
		
		return true;
	}
	
	public static OrganizationDTO generateOrganizationDTO(TmpOrganization tmpOrganization) {
		OrganizationDTO organizationDTO = new OrganizationDTO();
		organizationDTO.setOrganizationId(tmpOrganization.getOrganizationId().toString());
		organizationDTO.setOrganizationName(tmpOrganization.getOrganizationName());

		// Export Standard Fields
		organizationDTO.setDateCreated(tmpOrganization.getDateCreated());
		organizationDTO.setDateUpdated(tmpOrganization.getDateUpdated());
		
		return organizationDTO;
	}
	
	public static TmpOrganization generateTmpOrganization(OrganizationDTO inputDTO) {
		TmpOrganization tmpOrganization = new TmpOrganization();
		
		tmpOrganization.setOrganizationId(Integer.parseInt(inputDTO.getOrganizationId()));
		tmpOrganization.setOrganizationName(inputDTO.getOrganizationName());
		
		return tmpOrganization;
	}
	
}