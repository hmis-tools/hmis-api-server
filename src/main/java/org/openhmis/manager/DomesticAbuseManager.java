package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientWhenDvOccurred;
import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.TmpDomesticAbuseDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpDomesticAbuse;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.DomesticAbuseDTO;
import org.openhmis.dto.search.DomesticAbuseSearchDTO;

public class DomesticAbuseManager {
	private TmpDomesticAbuseDAO tmpDomesticAbuseDAO;

	public DomesticAbuseManager() {
		this.tmpDomesticAbuseDAO = new TmpDomesticAbuseDAO();
	}
	public DomesticAbuseManager(TmpDomesticAbuseDAO tmpDomesticAbuseDAO) {
		this.tmpDomesticAbuseDAO = tmpDomesticAbuseDAO;
	}

	public DomesticAbuseDTO getDomesticAbuseById(String domesticAbuseId) {
		DomesticAbuseDTO domesticAbuseDTO = DomesticAbuseManager.generateDomesticAbuseDTO(tmpDomesticAbuseDAO.getTmpDomesticAbuseById(Integer.parseInt(domesticAbuseId)));
		return domesticAbuseDTO;
	}

	public List<DomesticAbuseDTO> getDomesticAbuses(DomesticAbuseSearchDTO searchDTO) {
		List<DomesticAbuseDTO> domesticAbuseDTOs = new ArrayList<DomesticAbuseDTO>();

		// Collect the domesticAbuses
		List<TmpDomesticAbuse> tmpDomesticAbuses = tmpDomesticAbuseDAO.getTmpDomesticAbuses(searchDTO);

		// For each domesticAbuse, collect and map the data
		for (Iterator<TmpDomesticAbuse> iterator = tmpDomesticAbuses.iterator(); iterator.hasNext();) {
			TmpDomesticAbuse tmpDomesticAbuse = iterator.next();
			DomesticAbuseDTO domesticAbuseDTO = DomesticAbuseManager.generateDomesticAbuseDTO(tmpDomesticAbuse);
			domesticAbuseDTOs.add(domesticAbuseDTO);
		}
		return domesticAbuseDTOs;

	}

	public DomesticAbuseDTO addDomesticAbuse(DomesticAbuseDTO inputDTO) {
		// Generate a PathClient from the input
		TmpDomesticAbuse tmpDomesticAbuse = DomesticAbuseManager.generateTmpDomesticAbuse(inputDTO);
		
		// Set Export fields
		tmpDomesticAbuse.setDateCreated(new Date());
		tmpDomesticAbuse.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpDomesticAbuseDAO.save(tmpDomesticAbuse);
		inputDTO.setDomesticAbuseId(tmpDomesticAbuse.getDomesticAbuseId().toString());
		
		// Return the resulting VO
		return DomesticAbuseManager.generateDomesticAbuseDTO(tmpDomesticAbuse);
	}
	
	public DomesticAbuseDTO updateDomesticAbuse(DomesticAbuseDTO inputDTO) {
		// Generate a DomesticAbuse from the input
		TmpDomesticAbuse tmpDomesticAbuse = DomesticAbuseManager.generateTmpDomesticAbuse(inputDTO);
		tmpDomesticAbuse.setDomesticAbuseId(Integer.parseInt(inputDTO.getDomesticAbuseId()));
		tmpDomesticAbuse.setDateUpdated(new Date());
		
		// Update the object
		tmpDomesticAbuseDAO.update(tmpDomesticAbuse);
		
		// Return the resulting VO
		return DomesticAbuseManager.generateDomesticAbuseDTO(tmpDomesticAbuse);

	}
	
	public boolean deleteDomesticAbuse(String domesticAbuseId) {
		TmpDomesticAbuse tmpDomesticAbuse = tmpDomesticAbuseDAO.getTmpDomesticAbuseById(Integer.parseInt(domesticAbuseId));
		tmpDomesticAbuseDAO.delete(tmpDomesticAbuse);
		return true;
	}
	
}
