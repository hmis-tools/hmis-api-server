package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientDisabilityResponse;
import org.openhmis.code.ClientPathHowConfirmed;
import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.TmpSubstanceAbuseDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpSubstanceAbuse;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.SubstanceAbuseDTO;
import org.openhmis.dto.search.SubstanceAbuseSearchDTO;

public class SubstanceAbuseManager {
	private TmpSubstanceAbuseDAO tmpSubstanceAbuseDAO = new TmpSubstanceAbuseDAO();

	public SubstanceAbuseManager() {
		this.tmpSubstanceAbuseDAO = new TmpSubstanceAbuseDAO();
	}

	public SubstanceAbuseManager(TmpSubstanceAbuseDAO tmpSubstanceAbuseDAO) {
		this.tmpSubstanceAbuseDAO = tmpSubstanceAbuseDAO;
	}

	public SubstanceAbuseDTO getSubstanceAbuseById(String substanceAbuseId) {
		SubstanceAbuseDTO substanceAbuseDTO = SubstanceAbuseManager.generateSubstanceAbuseDTO(tmpSubstanceAbuseDAO.getTmpSubstanceAbuseById(Integer.parseInt(substanceAbuseId)));
		return substanceAbuseDTO;
	}

	public List<SubstanceAbuseDTO> getSubstanceAbuses(SubstanceAbuseSearchDTO searchDTO) {
		List<SubstanceAbuseDTO> substanceAbuseDTOs = new ArrayList<SubstanceAbuseDTO>();

		// Collect the substanceAbuses
		List<TmpSubstanceAbuse> tmpSubstanceAbuses = tmpSubstanceAbuseDAO.getTmpSubstanceAbuses(searchDTO);

		// For each substanceAbuse, collect and map the data
		for (Iterator<TmpSubstanceAbuse> iterator = tmpSubstanceAbuses.iterator(); iterator.hasNext();) {
			TmpSubstanceAbuse tmpSubstanceAbuse = iterator.next();
			SubstanceAbuseDTO substanceAbuseDTO = SubstanceAbuseManager.generateSubstanceAbuseDTO(tmpSubstanceAbuse);
			substanceAbuseDTOs.add(substanceAbuseDTO);
		}
		return substanceAbuseDTOs;

	}

	public SubstanceAbuseDTO addSubstanceAbuse(SubstanceAbuseDTO inputDTO) {
		// Generate a PathClient from the input
		TmpSubstanceAbuse tmpSubstanceAbuse = SubstanceAbuseManager.generateTmpSubstanceAbuse(inputDTO);
		
		// Set Export fields
		tmpSubstanceAbuse.setDateCreated(new Date());
		tmpSubstanceAbuse.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpSubstanceAbuseDAO.save(tmpSubstanceAbuse);
		inputDTO.setSubstanceAbuseId(tmpSubstanceAbuse.getSubstanceAbuseId().toString());
		
		// Return the resulting VO
		return SubstanceAbuseManager.generateSubstanceAbuseDTO(tmpSubstanceAbuse);
	}
	
	public SubstanceAbuseDTO updateSubstanceAbuse(SubstanceAbuseDTO inputDTO) {
		// Generate a SubstanceAbuse from the input
		TmpSubstanceAbuse tmpSubstanceAbuse = SubstanceAbuseManager.generateTmpSubstanceAbuse(inputDTO);
		tmpSubstanceAbuse.setSubstanceAbuseId(Integer.parseInt(inputDTO.getSubstanceAbuseId()));
		tmpSubstanceAbuse.setDateUpdated(new Date());
		
		// Update the object
		tmpSubstanceAbuseDAO.update(tmpSubstanceAbuse);
		
		// Return the resulting VO
		return SubstanceAbuseManager.generateSubstanceAbuseDTO(tmpSubstanceAbuse);

	}
	
	public boolean deleteSubstanceAbuse(String substanceAbuseId) {
		TmpSubstanceAbuse tmpSubstanceAbuse = tmpSubstanceAbuseDAO.getTmpSubstanceAbuseById(Integer.parseInt(substanceAbuseId));
		tmpSubstanceAbuseDAO.delete(tmpSubstanceAbuse);
		return true;
	}
	
}
