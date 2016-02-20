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
import org.openhmis.dao.TmpChronicHealthConditionDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpChronicHealthCondition;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.ChronicHealthConditionDTO;

public class ChronicHealthConditionManager {
	private static final TmpChronicHealthConditionDAO tmpChronicHealthConditionDAO = new TmpChronicHealthConditionDAO();

	public ChronicHealthConditionManager() {}

	public static ChronicHealthConditionDTO getChronicHealthConditionById(String chronicHealthConditionId) {
		ChronicHealthConditionDTO chronicHealthConditionDTO = ChronicHealthConditionManager.generateChronicHealthConditionDTO(tmpChronicHealthConditionDAO.getTmpChronicHealthConditionById(Integer.parseInt(chronicHealthConditionId)));
		return chronicHealthConditionDTO;
	}

	public static List<ChronicHealthConditionDTO> getChronicHealthConditions() {
		List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = new ArrayList<ChronicHealthConditionDTO>();

		// Collect the chronicHealthConditions
		List<TmpChronicHealthCondition> tmpChronicHealthConditions = tmpChronicHealthConditionDAO.getTmpChronicHealthConditions();

		// For each chronicHealthCondition, collect and map the data
		for (Iterator<TmpChronicHealthCondition> iterator = tmpChronicHealthConditions.iterator(); iterator.hasNext();) {
			TmpChronicHealthCondition tmpChronicHealthCondition = iterator.next();
			ChronicHealthConditionDTO chronicHealthConditionDTO = ChronicHealthConditionManager.generateChronicHealthConditionDTO(tmpChronicHealthCondition);
			chronicHealthConditionDTOs.add(chronicHealthConditionDTO);
		}
		return chronicHealthConditionDTOs;

	}

	public static List<ChronicHealthConditionDTO> getChronicHealthConditions(Date updateDate) {
		List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = new ArrayList<ChronicHealthConditionDTO>();

		// Collect the chronicHealthConditions
		List<TmpChronicHealthCondition> tmpChronicHealthConditions = tmpChronicHealthConditionDAO.getTmpChronicHealthConditions(updateDate);

		// For each chronicHealthCondition, collect and map the data
		for (Iterator<TmpChronicHealthCondition> iterator = tmpChronicHealthConditions.iterator(); iterator.hasNext();) {
			TmpChronicHealthCondition tmpChronicHealthCondition = iterator.next();
			ChronicHealthConditionDTO chronicHealthConditionDTO = ChronicHealthConditionManager.generateChronicHealthConditionDTO(tmpChronicHealthCondition);
			chronicHealthConditionDTOs.add(chronicHealthConditionDTO);
		}
		return chronicHealthConditionDTOs;

	}

	public static List<ChronicHealthConditionDTO> getChronicHealthConditionsByEnrollmentId(String enrollmentId) {
		List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = new ArrayList<ChronicHealthConditionDTO>();

		// Collect the chronicHealthConditions
		List<TmpChronicHealthCondition> tmpChronicHealthConditions = tmpChronicHealthConditionDAO.getTmpChronicHealthConditionsByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each chronicHealthCondition, collect and map the data
		for (Iterator<TmpChronicHealthCondition> iterator = tmpChronicHealthConditions.iterator(); iterator.hasNext();) {
			TmpChronicHealthCondition tmpChronicHealthCondition = iterator.next();
			ChronicHealthConditionDTO chronicHealthConditionDTO = ChronicHealthConditionManager.generateChronicHealthConditionDTO(tmpChronicHealthCondition);
			chronicHealthConditionDTOs.add(chronicHealthConditionDTO);
		}
		return chronicHealthConditionDTOs;

	}

	public static List<ChronicHealthConditionDTO> getChronicHealthConditionsByEnrollmentId(String enrollmentId, Date updateDate) {
		List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = new ArrayList<ChronicHealthConditionDTO>();

		// Collect the chronicHealthConditions
		List<TmpChronicHealthCondition> tmpChronicHealthConditions = tmpChronicHealthConditionDAO.getTmpChronicHealthConditionsByEnrollmentId(Integer.parseInt(enrollmentId), updateDate);

		// For each chronicHealthCondition, collect and map the data
		for (Iterator<TmpChronicHealthCondition> iterator = tmpChronicHealthConditions.iterator(); iterator.hasNext();) {
			TmpChronicHealthCondition tmpChronicHealthCondition = iterator.next();
			ChronicHealthConditionDTO chronicHealthConditionDTO = ChronicHealthConditionManager.generateChronicHealthConditionDTO(tmpChronicHealthCondition);
			chronicHealthConditionDTOs.add(chronicHealthConditionDTO);
		}
		return chronicHealthConditionDTOs;

	}

	
	public static ChronicHealthConditionDTO addChronicHealthCondition(ChronicHealthConditionDTO inputDTO) {
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
	
	public static ChronicHealthConditionDTO updateChronicHealthCondition(ChronicHealthConditionDTO inputDTO) {
		// Generate a ChronicHealthCondition from the input
		TmpChronicHealthCondition tmpChronicHealthCondition = ChronicHealthConditionManager.generateTmpChronicHealthCondition(inputDTO);
		tmpChronicHealthCondition.setChronicHealthConditionId(Integer.parseInt(inputDTO.getChronicHealthConditionId()));
		tmpChronicHealthCondition.setDateUpdated(new Date());
		
		// Update the object
		tmpChronicHealthConditionDAO.update(tmpChronicHealthCondition);
		
		// Return the resulting VO
		return ChronicHealthConditionManager.generateChronicHealthConditionDTO(tmpChronicHealthCondition);

	}
	
	public static boolean deleteChronicHealthCondition(String chronicHealthConditionId) {
		TmpChronicHealthCondition tmpChronicHealthCondition = tmpChronicHealthConditionDAO.getTmpChronicHealthConditionById(Integer.parseInt(chronicHealthConditionId));
		tmpChronicHealthConditionDAO.delete(tmpChronicHealthCondition);
		return true;
	}
	
	public static ChronicHealthConditionDTO generateChronicHealthConditionDTO(TmpChronicHealthCondition tmpChronicHealthCondition) {
		ChronicHealthConditionDTO chronicHealthConditionDTO = new ChronicHealthConditionDTO();

		chronicHealthConditionDTO.setChronicHealthConditionId(tmpChronicHealthCondition.getChronicHealthConditionId().toString());
		chronicHealthConditionDTO.setEnrollmentId(tmpChronicHealthCondition.getEnrollmentId().toString());

		// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
		chronicHealthConditionDTO.setInformationDate(tmpChronicHealthCondition.getInformationDate());
		chronicHealthConditionDTO.setResponse(YesNoReason.valueByCode(tmpChronicHealthCondition.getResponse()));
		chronicHealthConditionDTO.setIndefiniteAndImpairs(YesNoReason.valueByCode(tmpChronicHealthCondition.getIndefiniteAndImpairs()));
		chronicHealthConditionDTO.setDocumentationOnFile(YesNo.valueByCode(tmpChronicHealthCondition.getDocumentationOnFile()));
		chronicHealthConditionDTO.setReceivingServices(YesNoReason.valueByCode(tmpChronicHealthCondition.getReceivingServices()));

		// Export Standard Fields
		chronicHealthConditionDTO.setDateCreated(tmpChronicHealthCondition.getDateCreated());
		chronicHealthConditionDTO.setDateUpdated(tmpChronicHealthCondition.getDateUpdated());
		
		return chronicHealthConditionDTO;
	}
	
	public static TmpChronicHealthCondition generateTmpChronicHealthCondition(ChronicHealthConditionDTO inputDTO) {
		TmpChronicHealthCondition tmpChronicHealthCondition = new TmpChronicHealthCondition();
		
		tmpChronicHealthCondition.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
		tmpChronicHealthCondition.setInformationDate(inputDTO.getInformationDate());
		tmpChronicHealthCondition.setResponse(inputDTO.getResponse().getCode());
		tmpChronicHealthCondition.setIndefiniteAndImpairs(inputDTO.getIndefiniteAndImpairs().getCode());
		tmpChronicHealthCondition.setDocumentationOnFile(inputDTO.getDocumentationOnFile().getCode());
		tmpChronicHealthCondition.setReceivingServices(inputDTO.getReceivingServices().getCode());

		// Export Standard Fields
		tmpChronicHealthCondition.setDateCreated(inputDTO.getDateCreated());
		tmpChronicHealthCondition.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpChronicHealthCondition;
	}
	
}