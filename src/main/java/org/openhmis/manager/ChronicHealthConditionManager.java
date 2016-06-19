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
import org.openhmis.dao.PathClientDAO;
import org.openhmis.dao.TmpChronicHealthConditionDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpChronicHealthCondition;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.ChronicHealthConditionDTO;
import org.openhmis.dto.search.ChronicHealthConditionSearchDTO;

public class ChronicHealthConditionManager {
	private TmpChronicHealthConditionDAO tmpChronicHealthConditionDAO;

	private PathClientDAO pathClientDAO;

	
	public ChronicHealthConditionManager() {
		this.tmpChronicHealthConditionDAO = new TmpChronicHealthConditionDAO();
	}
	
	public ChronicHealthConditionManager (TmpChronicHealthConditionDAO tmpChronicHealthConditionDAO) {
		this.tmpChronicHealthConditionDAO = tmpChronicHealthConditionDAO;
	}

	public ChronicHealthConditionDTO getChronicHealthConditionById(String chronicHealthConditionId) {
		ChronicHealthConditionDTO chronicHealthConditionDTO = ChronicHealthConditionManager.generateChronicHealthConditionDTO(tmpChronicHealthConditionDAO.getTmpChronicHealthConditionById(Integer.parseInt(chronicHealthConditionId)));
		return chronicHealthConditionDTO;
	}

	public List<ChronicHealthConditionDTO> getChronicHealthConditions(ChronicHealthConditionSearchDTO searchDTO) {
		List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = new ArrayList<ChronicHealthConditionDTO>();

		// Collect the chronicHealthConditions
		List<TmpChronicHealthCondition> tmpChronicHealthConditions = tmpChronicHealthConditionDAO.getTmpChronicHealthConditions(searchDTO);

		// For each chronicHealthCondition, collect and map the data
		for (Iterator<TmpChronicHealthCondition> iterator = tmpChronicHealthConditions.iterator(); iterator.hasNext();) {
			TmpChronicHealthCondition tmpChronicHealthCondition = iterator.next();
			ChronicHealthConditionDTO chronicHealthConditionDTO = ChronicHealthConditionManager.generateChronicHealthConditionDTO(tmpChronicHealthCondition);
			chronicHealthConditionDTOs.add(chronicHealthConditionDTO);
		}
		return chronicHealthConditionDTOs;

	}
	
	public ChronicHealthConditionDTO addChronicHealthCondition(ChronicHealthConditionDTO inputDTO) {
		// Generate a PathClient from the input
		TmpChronicHealthCondition tmpChronicHealthCondition = ChronicHealthConditionManager.generateTmpChronicHealthCondition(inputDTO);
		
		// Set Export fields
		tmpChronicHealthCondition.setDateCreated(new Date());
		tmpChronicHealthCondition.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpChronicHealthConditionDAO.save(tmpChronicHealthCondition);
		inputDTO.setChronicHealthConditionId(tmpChronicHealthCondition.getChronicHealthConditionId().toString());
		
		// Return the resulting VO
		return ChronicHealthConditionManager.generateChronicHealthConditionDTO(tmpChronicHealthCondition);
	}
	
	public ChronicHealthConditionDTO updateChronicHealthCondition(ChronicHealthConditionDTO inputDTO) {
		// Generate a ChronicHealthCondition from the input
		TmpChronicHealthCondition tmpChronicHealthCondition = ChronicHealthConditionManager.generateTmpChronicHealthCondition(inputDTO);
		tmpChronicHealthCondition.setChronicHealthConditionId(Integer.parseInt(inputDTO.getChronicHealthConditionId()));
		tmpChronicHealthCondition.setDateUpdated(new Date());
		
		// Update the object
		tmpChronicHealthConditionDAO.update(tmpChronicHealthCondition);
		
		// Return the resulting VO
		return ChronicHealthConditionManager.generateChronicHealthConditionDTO(tmpChronicHealthCondition);

	}
	
	public boolean deleteChronicHealthCondition(String chronicHealthConditionId) {
		TmpChronicHealthCondition tmpChronicHealthCondition = tmpChronicHealthConditionDAO.getTmpChronicHealthConditionById(Integer.parseInt(chronicHealthConditionId));
		tmpChronicHealthConditionDAO.delete(tmpChronicHealthCondition);
		return true;
	}
}
