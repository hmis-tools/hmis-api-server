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
import org.openhmis.dao.TmpPhysicalDisabilityDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpPhysicalDisability;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.PhysicalDisabilityDTO;

public class PhysicalDisabilityManager {
	private static final TmpPhysicalDisabilityDAO tmpPhysicalDisabilityDAO = new TmpPhysicalDisabilityDAO();

	public PhysicalDisabilityManager() {}

	public static PhysicalDisabilityDTO getPhysicalDisabilityById(String physicalDisabilityId) {
		PhysicalDisabilityDTO physicalDisabilityDTO = PhysicalDisabilityManager.generatePhysicalDisabilityDTO(tmpPhysicalDisabilityDAO.getTmpPhysicalDisabilityById(Integer.parseInt(physicalDisabilityId)));
		return physicalDisabilityDTO;
	}

	public static List<PhysicalDisabilityDTO> getPhysicalDisabilitiesByEnrollmentId(String enrollmentId) {
		List<PhysicalDisabilityDTO> physicalDisabilityDTOs = new ArrayList<PhysicalDisabilityDTO>();

		// Collect the physicalDisabilities
		List<TmpPhysicalDisability> tmpPhysicalDisabilities = tmpPhysicalDisabilityDAO.getTmpPhysicalDisabilitiesByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each physicalDisability, collect and map the data
		for (Iterator<TmpPhysicalDisability> iterator = tmpPhysicalDisabilities.iterator(); iterator.hasNext();) {
			TmpPhysicalDisability tmpPhysicalDisability = iterator.next();
			PhysicalDisabilityDTO physicalDisabilityDTO = PhysicalDisabilityManager.generatePhysicalDisabilityDTO(tmpPhysicalDisability);
			physicalDisabilityDTOs.add(physicalDisabilityDTO);
		}
		return physicalDisabilityDTOs;

	}

	public static List<PhysicalDisabilityDTO> getPhysicalDisabilitiesByEnrollmentId(String enrollmentId, Date updateDate) {
		List<PhysicalDisabilityDTO> physicalDisabilityDTOs = new ArrayList<PhysicalDisabilityDTO>();

		// Collect the physicalDisabilities
		List<TmpPhysicalDisability> tmpPhysicalDisabilities = tmpPhysicalDisabilityDAO.getTmpPhysicalDisabilitiesByEnrollmentId(Integer.parseInt(enrollmentId), updateDate);

		// For each physicalDisability, collect and map the data
		for (Iterator<TmpPhysicalDisability> iterator = tmpPhysicalDisabilities.iterator(); iterator.hasNext();) {
			TmpPhysicalDisability tmpPhysicalDisability = iterator.next();
			PhysicalDisabilityDTO physicalDisabilityDTO = PhysicalDisabilityManager.generatePhysicalDisabilityDTO(tmpPhysicalDisability);
			physicalDisabilityDTOs.add(physicalDisabilityDTO);
		}
		return physicalDisabilityDTOs;

	}
	
	public static PhysicalDisabilityDTO addPhysicalDisability(PhysicalDisabilityDTO inputDTO) {
		// Generate a PathClient from the input
		TmpPhysicalDisability tmpPhysicalDisability = PhysicalDisabilityManager.generateTmpPhysicalDisability(inputDTO);
		
		// Set Export fields
		tmpPhysicalDisability.setDateCreated(new Date());
		tmpPhysicalDisability.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpPhysicalDisabilityDAO.save(tmpPhysicalDisability);
		inputDTO.setPhysicalDisabilityId(tmpPhysicalDisability.getPhysicalDisabilityId().toString());
		
		// Return the resulting VO
		return PhysicalDisabilityManager.generatePhysicalDisabilityDTO(tmpPhysicalDisability);
	}
	
	public static PhysicalDisabilityDTO updatePhysicalDisability(PhysicalDisabilityDTO inputDTO) {
		// Generate a PhysicalDisability from the input
		TmpPhysicalDisability tmpPhysicalDisability = PhysicalDisabilityManager.generateTmpPhysicalDisability(inputDTO);
		tmpPhysicalDisability.setPhysicalDisabilityId(Integer.parseInt(inputDTO.getPhysicalDisabilityId()));
		tmpPhysicalDisability.setDateUpdated(new Date());
		
		// Update the object
		tmpPhysicalDisabilityDAO.update(tmpPhysicalDisability);
		
		// Return the resulting VO
		return PhysicalDisabilityManager.generatePhysicalDisabilityDTO(tmpPhysicalDisability);

	}
	
	public static boolean deletePhysicalDisability(String physicalDisabilityId) {
		TmpPhysicalDisability tmpPhysicalDisability = tmpPhysicalDisabilityDAO.getTmpPhysicalDisabilityById(Integer.parseInt(physicalDisabilityId));
		tmpPhysicalDisabilityDAO.delete(tmpPhysicalDisability);
		return true;
	}
	
	public static PhysicalDisabilityDTO generatePhysicalDisabilityDTO(TmpPhysicalDisability tmpPhysicalDisability) {
		PhysicalDisabilityDTO physicalDisabilityDTO = new PhysicalDisabilityDTO();

		physicalDisabilityDTO.setPhysicalDisabilityId(tmpPhysicalDisability.getPhysicalDisabilityId().toString());
		physicalDisabilityDTO.setEnrollmentId(tmpPhysicalDisability.getEnrollmentId().toString());

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		physicalDisabilityDTO.setInformationDate(tmpPhysicalDisability.getInformationDate());
		physicalDisabilityDTO.setResponse(YesNoReason.valueByCode(tmpPhysicalDisability.getResponse()));
		physicalDisabilityDTO.setIndefiniteAndImpairs(YesNoReason.valueByCode(tmpPhysicalDisability.getIndefiniteAndImpairs()));
		physicalDisabilityDTO.setDocumentationOnFile(YesNo.valueByCode(tmpPhysicalDisability.getDocumentationOnFile()));
		physicalDisabilityDTO.setReceivingServices(YesNoReason.valueByCode(tmpPhysicalDisability.getReceivingServices()));

		// Export Standard Fields
		physicalDisabilityDTO.setDateCreated(tmpPhysicalDisability.getDateCreated());
		physicalDisabilityDTO.setDateUpdated(tmpPhysicalDisability.getDateUpdated());
		
		return physicalDisabilityDTO;
	}
	
	public static TmpPhysicalDisability generateTmpPhysicalDisability(PhysicalDisabilityDTO inputDTO) {
		TmpPhysicalDisability tmpPhysicalDisability = new TmpPhysicalDisability();
		
		tmpPhysicalDisability.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		tmpPhysicalDisability.setInformationDate(inputDTO.getInformationDate());
		tmpPhysicalDisability.setResponse(inputDTO.getResponse().getCode());
		tmpPhysicalDisability.setIndefiniteAndImpairs(inputDTO.getIndefiniteAndImpairs().getCode());
		tmpPhysicalDisability.setDocumentationOnFile(inputDTO.getDocumentationOnFile().getCode());
		tmpPhysicalDisability.setReceivingServices(inputDTO.getReceivingServices().getCode());

		// Export Standard Fields
		tmpPhysicalDisability.setDateCreated(inputDTO.getDateCreated());
		tmpPhysicalDisability.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpPhysicalDisability;
	}
	
}