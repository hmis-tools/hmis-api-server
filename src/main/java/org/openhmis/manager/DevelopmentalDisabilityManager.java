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
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.TmpDevelopmentalDisabilityDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpDevelopmentalDisability;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.DevelopmentalDisabilityDTO;
import org.openhmis.dto.search.DevelopmentalDisabilitySearchDTO;

public class DevelopmentalDisabilityManager {
	private TmpDevelopmentalDisabilityDAO tmpDevelopmentalDisabilityDAO;

	public DevelopmentalDisabilityManager() {
		this.tmpDevelopmentalDisabilityDAO = new TmpDevelopmentalDisabilityDAO();
	}
	
	public DevelopmentalDisabilityManager(TmpDevelopmentalDisabilityDAO tmpDevelopmentalDisabilityDAO) {
		this.tmpDevelopmentalDisabilityDAO = tmpDevelopmentalDisabilityDAO;
	}

	public DevelopmentalDisabilityDTO getDevelopmentalDisabilityById(String developmentalDisabilityId) {
		DevelopmentalDisabilityDTO developmentalDisabilityDTO = DevelopmentalDisabilityManager.generateDevelopmentalDisabilityDTO(tmpDevelopmentalDisabilityDAO.getTmpDevelopmentalDisabilityById(Integer.parseInt(developmentalDisabilityId)));
		return developmentalDisabilityDTO;
	}

	public List<DevelopmentalDisabilityDTO> getDevelopmentalDisabilities(DevelopmentalDisabilitySearchDTO searchDTO) {
		List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = new ArrayList<DevelopmentalDisabilityDTO>();

		// Collect the developmentalDisabilities
		List<TmpDevelopmentalDisability> tmpDevelopmentalDisabilities = tmpDevelopmentalDisabilityDAO.getTmpDevelopmentalDisabilities(searchDTO);

		// For each developmentalDisability, collect and map the data
		for (Iterator<TmpDevelopmentalDisability> iterator = tmpDevelopmentalDisabilities.iterator(); iterator.hasNext();) {
			TmpDevelopmentalDisability tmpDevelopmentalDisability = iterator.next();
			DevelopmentalDisabilityDTO developmentalDisabilityDTO = DevelopmentalDisabilityManager.generateDevelopmentalDisabilityDTO(tmpDevelopmentalDisability);
			developmentalDisabilityDTOs.add(developmentalDisabilityDTO);
		}
		return developmentalDisabilityDTOs;

	}

	public DevelopmentalDisabilityDTO addDevelopmentalDisability(DevelopmentalDisabilityDTO inputDTO) {
		// Generate a PathClient from the input
		TmpDevelopmentalDisability tmpDevelopmentalDisability = DevelopmentalDisabilityManager.generateTmpDevelopmentalDisability(inputDTO);
		
		// Set Export fields
		tmpDevelopmentalDisability.setDateCreated(new Date());
		tmpDevelopmentalDisability.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpDevelopmentalDisabilityDAO.save(tmpDevelopmentalDisability);
		inputDTO.setDevelopmentalDisabilityId(tmpDevelopmentalDisability.getDevelopmentalDisabilityId().toString());
		
		// Return the resulting VO
		return DevelopmentalDisabilityManager.generateDevelopmentalDisabilityDTO(tmpDevelopmentalDisability);
	}
	
	public DevelopmentalDisabilityDTO updateDevelopmentalDisability(DevelopmentalDisabilityDTO inputDTO) {
		// Generate a DevelopmentalDisability from the input
		TmpDevelopmentalDisability tmpDevelopmentalDisability = DevelopmentalDisabilityManager.generateTmpDevelopmentalDisability(inputDTO);
		tmpDevelopmentalDisability.setDevelopmentalDisabilityId(Integer.parseInt(inputDTO.getDevelopmentalDisabilityId()));
		tmpDevelopmentalDisability.setDateUpdated(new Date());
		
		// Update the object
		tmpDevelopmentalDisabilityDAO.update(tmpDevelopmentalDisability);
		
		// Return the resulting VO
		return DevelopmentalDisabilityManager.generateDevelopmentalDisabilityDTO(tmpDevelopmentalDisability);

	}
	
	public boolean deleteDevelopmentalDisability(String developmentalDisabilityId) {
		TmpDevelopmentalDisability tmpDevelopmentalDisability = tmpDevelopmentalDisabilityDAO.getTmpDevelopmentalDisabilityById(Integer.parseInt(developmentalDisabilityId));
		tmpDevelopmentalDisabilityDAO.delete(tmpDevelopmentalDisability);
		return true;
	}
	
}
