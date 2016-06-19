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
import org.openhmis.dao.TmpIncomeSourceDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpIncomeSource;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.IncomeSourceDTO;
import org.openhmis.dto.search.IncomeSourceSearchDTO;

public class IncomeSourceManager {
	private TmpIncomeSourceDAO tmpIncomeSourceDAO;

	public IncomeSourceManager() {
		this.tmpIncomeSourceDAO = new TmpIncomeSourceDAO();
	}
	
	public IncomeSourceManager(TmpIncomeSourceDAO tmpIncomeSourceDAO) {
		this.tmpIncomeSourceDAO = new TmpIncomeSourceDAO();
	}

	public IncomeSourceDTO getIncomeSourceById(String incomeSourceId) {
		IncomeSourceDTO incomeSourceDTO = IncomeSourceManager.generateIncomeSourceDTO(tmpIncomeSourceDAO.getTmpIncomeSourceById(Integer.parseInt(incomeSourceId)));
		return incomeSourceDTO;
	}

	public List<IncomeSourceDTO> getIncomeSources(IncomeSourceSearchDTO searchDTO) {
		List<IncomeSourceDTO> incomeSourceDTOs = new ArrayList<IncomeSourceDTO>();

		// Collect the incomeSources
		List<TmpIncomeSource> tmpIncomeSources = tmpIncomeSourceDAO.getTmpIncomeSources(searchDTO);

		// For each incomeSource, collect and map the data
		for (Iterator<TmpIncomeSource> iterator = tmpIncomeSources.iterator(); iterator.hasNext();) {
			TmpIncomeSource tmpIncomeSource = iterator.next();
			IncomeSourceDTO incomeSourceDTO = IncomeSourceManager.generateIncomeSourceDTO(tmpIncomeSource);
			incomeSourceDTOs.add(incomeSourceDTO);
		}
		return incomeSourceDTOs;

	}

	public IncomeSourceDTO addIncomeSource(IncomeSourceDTO inputDTO) {
		// Generate a PathClient from the input
		TmpIncomeSource tmpIncomeSource = IncomeSourceManager.generateTmpIncomeSource(inputDTO);
		
		// Set Export fields
		tmpIncomeSource.setDateCreated(new Date());
		tmpIncomeSource.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpIncomeSourceDAO.save(tmpIncomeSource);
		inputDTO.setIncomeSourceId(tmpIncomeSource.getIncomeSourceId().toString());
		
		// Return the resulting VO
		return IncomeSourceManager.generateIncomeSourceDTO(tmpIncomeSource);
	}
	
	public IncomeSourceDTO updateIncomeSource(IncomeSourceDTO inputDTO) {
		// Generate a IncomeSource from the input
		TmpIncomeSource tmpIncomeSource = IncomeSourceManager.generateTmpIncomeSource(inputDTO);
		tmpIncomeSource.setIncomeSourceId(Integer.parseInt(inputDTO.getIncomeSourceId()));
		tmpIncomeSource.setDateUpdated(new Date());
		
		// Update the object
		tmpIncomeSourceDAO.update(tmpIncomeSource);
		
		// Return the resulting VO
		return IncomeSourceManager.generateIncomeSourceDTO(tmpIncomeSource);

	}
	
	public boolean deleteIncomeSource(String incomeSourceId) {
		TmpIncomeSource tmpIncomeSource = tmpIncomeSourceDAO.getTmpIncomeSourceById(Integer.parseInt(incomeSourceId));
		tmpIncomeSourceDAO.delete(tmpIncomeSource);
		return true;
	}
	
}
