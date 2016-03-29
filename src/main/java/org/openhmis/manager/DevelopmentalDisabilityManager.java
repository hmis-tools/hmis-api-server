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

public class DevelopmentalDisabilityManager {
	private static final TmpDevelopmentalDisabilityDAO tmpDevelopmentalDisabilityDAO = new TmpDevelopmentalDisabilityDAO();

	public DevelopmentalDisabilityManager() {}

	public static DevelopmentalDisabilityDTO getDevelopmentalDisabilityById(String developmentalDisabilityId) {
		DevelopmentalDisabilityDTO developmentalDisabilityDTO = DevelopmentalDisabilityManager.generateDevelopmentalDisabilityDTO(tmpDevelopmentalDisabilityDAO.getTmpDevelopmentalDisabilityById(Integer.parseInt(developmentalDisabilityId)));
		return developmentalDisabilityDTO;
	}

	public static List<DevelopmentalDisabilityDTO> getDevelopmentalDisabilities() {
		List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = new ArrayList<DevelopmentalDisabilityDTO>();

		// Collect the developmentalDisabilities
		List<TmpDevelopmentalDisability> tmpDevelopmentalDisabilities = tmpDevelopmentalDisabilityDAO.getTmpDevelopmentalDisabilities();

		// For each developmentalDisability, collect and map the data
		for (Iterator<TmpDevelopmentalDisability> iterator = tmpDevelopmentalDisabilities.iterator(); iterator.hasNext();) {
			TmpDevelopmentalDisability tmpDevelopmentalDisability = iterator.next();
			DevelopmentalDisabilityDTO developmentalDisabilityDTO = DevelopmentalDisabilityManager.generateDevelopmentalDisabilityDTO(tmpDevelopmentalDisability);
			developmentalDisabilityDTOs.add(developmentalDisabilityDTO);
		}
		return developmentalDisabilityDTOs;

	}

	public static List<DevelopmentalDisabilityDTO> getDevelopmentalDisabilities(Date updateDate) {
		List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = new ArrayList<DevelopmentalDisabilityDTO>();

		// Collect the developmentalDisabilities
		List<TmpDevelopmentalDisability> tmpDevelopmentalDisabilities = tmpDevelopmentalDisabilityDAO.getTmpDevelopmentalDisabilities(updateDate);

		// For each developmentalDisability, collect and map the data
		for (Iterator<TmpDevelopmentalDisability> iterator = tmpDevelopmentalDisabilities.iterator(); iterator.hasNext();) {
			TmpDevelopmentalDisability tmpDevelopmentalDisability = iterator.next();
			DevelopmentalDisabilityDTO developmentalDisabilityDTO = DevelopmentalDisabilityManager.generateDevelopmentalDisabilityDTO(tmpDevelopmentalDisability);
			developmentalDisabilityDTOs.add(developmentalDisabilityDTO);
		}
		return developmentalDisabilityDTOs;

	}

	public static List<DevelopmentalDisabilityDTO> getDevelopmentalDisabilitiesByEnrollmentId(String enrollmentId) {
		List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = new ArrayList<DevelopmentalDisabilityDTO>();

		// Collect the developmentalDisabilities
		List<TmpDevelopmentalDisability> tmpDevelopmentalDisabilities = tmpDevelopmentalDisabilityDAO.getTmpDevelopmentalDisabilitiesByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each developmentalDisability, collect and map the data
		for (Iterator<TmpDevelopmentalDisability> iterator = tmpDevelopmentalDisabilities.iterator(); iterator.hasNext();) {
			TmpDevelopmentalDisability tmpDevelopmentalDisability = iterator.next();
			DevelopmentalDisabilityDTO developmentalDisabilityDTO = DevelopmentalDisabilityManager.generateDevelopmentalDisabilityDTO(tmpDevelopmentalDisability);
			developmentalDisabilityDTOs.add(developmentalDisabilityDTO);
		}
		return developmentalDisabilityDTOs;

	}

	public static List<DevelopmentalDisabilityDTO> getDevelopmentalDisabilitiesByEnrollmentId(String enrollmentId, Date updateDate) {
		List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = new ArrayList<DevelopmentalDisabilityDTO>();

		// Collect the developmentalDisabilities
		List<TmpDevelopmentalDisability> tmpDevelopmentalDisabilities = tmpDevelopmentalDisabilityDAO.getTmpDevelopmentalDisabilitiesByEnrollmentId(Integer.parseInt(enrollmentId), updateDate);

		// For each developmentalDisability, collect and map the data
		for (Iterator<TmpDevelopmentalDisability> iterator = tmpDevelopmentalDisabilities.iterator(); iterator.hasNext();) {
			TmpDevelopmentalDisability tmpDevelopmentalDisability = iterator.next();
			DevelopmentalDisabilityDTO developmentalDisabilityDTO = DevelopmentalDisabilityManager.generateDevelopmentalDisabilityDTO(tmpDevelopmentalDisability);
			developmentalDisabilityDTOs.add(developmentalDisabilityDTO);
		}
		return developmentalDisabilityDTOs;

	}
	
	public static DevelopmentalDisabilityDTO addDevelopmentalDisability(DevelopmentalDisabilityDTO inputDTO) {
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
	
	public static DevelopmentalDisabilityDTO updateDevelopmentalDisability(DevelopmentalDisabilityDTO inputDTO) {
		// Generate a DevelopmentalDisability from the input
		TmpDevelopmentalDisability tmpDevelopmentalDisability = DevelopmentalDisabilityManager.generateTmpDevelopmentalDisability(inputDTO);
		tmpDevelopmentalDisability.setDevelopmentalDisabilityId(Integer.parseInt(inputDTO.getDevelopmentalDisabilityId()));
		tmpDevelopmentalDisability.setDateUpdated(new Date());
		
		// Update the object
		tmpDevelopmentalDisabilityDAO.update(tmpDevelopmentalDisability);
		
		// Return the resulting VO
		return DevelopmentalDisabilityManager.generateDevelopmentalDisabilityDTO(tmpDevelopmentalDisability);

	}
	
	public static boolean deleteDevelopmentalDisability(String developmentalDisabilityId) {
		TmpDevelopmentalDisability tmpDevelopmentalDisability = tmpDevelopmentalDisabilityDAO.getTmpDevelopmentalDisabilityById(Integer.parseInt(developmentalDisabilityId));
		tmpDevelopmentalDisabilityDAO.delete(tmpDevelopmentalDisability);
		return true;
	}
	
	public static DevelopmentalDisabilityDTO generateDevelopmentalDisabilityDTO(TmpDevelopmentalDisability tmpDevelopmentalDisability) {
		DevelopmentalDisabilityDTO developmentalDisabilityDTO = new DevelopmentalDisabilityDTO();

		developmentalDisabilityDTO.setDevelopmentalDisabilityId(tmpDevelopmentalDisability.getDevelopmentalDisabilityId().toString());
		developmentalDisabilityDTO.setEnrollmentId(tmpDevelopmentalDisability.getEnrollmentId().toString());

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		developmentalDisabilityDTO.setInformationDate(tmpDevelopmentalDisability.getInformationDate());
		developmentalDisabilityDTO.setResponse(YesNoReason.valueByCode(tmpDevelopmentalDisability.getResponse()));
		developmentalDisabilityDTO.setIndefiniteAndImpairs(YesNoReason.valueByCode(tmpDevelopmentalDisability.getIndefiniteAndImpairs()));
		developmentalDisabilityDTO.setDocumentationOnFile(YesNo.valueByCode(tmpDevelopmentalDisability.getDocumentationOnFile()));
		developmentalDisabilityDTO.setReceivingServices(YesNoReason.valueByCode(tmpDevelopmentalDisability.getReceivingServices()));

		// Export Standard Fields
		developmentalDisabilityDTO.setDateCreated(tmpDevelopmentalDisability.getDateCreated());
		developmentalDisabilityDTO.setDateUpdated(tmpDevelopmentalDisability.getDateUpdated());
		
		return developmentalDisabilityDTO;
	}
	
	public static TmpDevelopmentalDisability generateTmpDevelopmentalDisability(DevelopmentalDisabilityDTO inputDTO) {
		TmpDevelopmentalDisability tmpDevelopmentalDisability = new TmpDevelopmentalDisability();
		
		tmpDevelopmentalDisability.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		tmpDevelopmentalDisability.setInformationDate(inputDTO.getInformationDate());
		tmpDevelopmentalDisability.setResponse(inputDTO.getResponse().getCode());
		tmpDevelopmentalDisability.setIndefiniteAndImpairs(inputDTO.getIndefiniteAndImpairs().getCode());
		tmpDevelopmentalDisability.setDocumentationOnFile(inputDTO.getDocumentationOnFile().getCode());
		tmpDevelopmentalDisability.setReceivingServices(inputDTO.getReceivingServices().getCode());

		// Export Standard Fields
		tmpDevelopmentalDisability.setDateCreated(inputDTO.getDateCreated());
		tmpDevelopmentalDisability.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpDevelopmentalDisability;
	}
	
}