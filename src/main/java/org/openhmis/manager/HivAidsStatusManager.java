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
import org.openhmis.dao.TmpHivAidsStatusDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpHivAidsStatus;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.HivAidsStatusDTO;

public class HivAidsStatusManager {
	private static final TmpHivAidsStatusDAO tmpHivAidsStatusDAO = new TmpHivAidsStatusDAO();

	public HivAidsStatusManager() {}

	public static HivAidsStatusDTO getHivAidsStatusById(String hivAidsStatusId) {
		HivAidsStatusDTO hivAidsStatusDTO = HivAidsStatusManager.generateHivAidsStatusDTO(tmpHivAidsStatusDAO.getTmpHivAidsStatusById(Integer.parseInt(hivAidsStatusId)));
		return hivAidsStatusDTO;
	}

	public static List<HivAidsStatusDTO> getHivAidsStatusesByEnrollmentId(String enrollmentId) {
		List<HivAidsStatusDTO> hivAidsStatusDTOs = new ArrayList<HivAidsStatusDTO>();

		// Collect the hivAidsStatuses
		List<TmpHivAidsStatus> tmpHivAidsStatuses = tmpHivAidsStatusDAO.getTmpHivAidsStatusesByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each hivAidsStatus, collect and map the data
		for (Iterator<TmpHivAidsStatus> iterator = tmpHivAidsStatuses.iterator(); iterator.hasNext();) {
			TmpHivAidsStatus tmpHivAidsStatus = iterator.next();
			HivAidsStatusDTO hivAidsStatusDTO = HivAidsStatusManager.generateHivAidsStatusDTO(tmpHivAidsStatus);
			hivAidsStatusDTOs.add(hivAidsStatusDTO);
		}
		return hivAidsStatusDTOs;

	}

	public static List<HivAidsStatusDTO> getHivAidsStatusesByEnrollmentId(String enrollmentId, Date updateDate) {
		List<HivAidsStatusDTO> hivAidsStatusDTOs = new ArrayList<HivAidsStatusDTO>();

		// Collect the hivAidsStatuses
		List<TmpHivAidsStatus> tmpHivAidsStatuses = tmpHivAidsStatusDAO.getTmpHivAidsStatusesByEnrollmentId(Integer.parseInt(enrollmentId), updateDate);

		// For each hivAidsStatus, collect and map the data
		for (Iterator<TmpHivAidsStatus> iterator = tmpHivAidsStatuses.iterator(); iterator.hasNext();) {
			TmpHivAidsStatus tmpHivAidsStatus = iterator.next();
			HivAidsStatusDTO hivAidsStatusDTO = HivAidsStatusManager.generateHivAidsStatusDTO(tmpHivAidsStatus);
			hivAidsStatusDTOs.add(hivAidsStatusDTO);
		}
		return hivAidsStatusDTOs;

	}
	
	public static HivAidsStatusDTO addHivAidsStatus(HivAidsStatusDTO inputDTO) {
		// Generate a PathClient from the input
		TmpHivAidsStatus tmpHivAidsStatus = HivAidsStatusManager.generateTmpHivAidsStatus(inputDTO);
		
		// Set Export fields
		tmpHivAidsStatus.setDateCreated(new Date());
		tmpHivAidsStatus.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpHivAidsStatusDAO.save(tmpHivAidsStatus);
		inputDTO.setHivAidsStatusId(tmpHivAidsStatus.getHivAidsStatusId().toString());
		
		// Return the resulting VO
		return HivAidsStatusManager.generateHivAidsStatusDTO(tmpHivAidsStatus);
	}
	
	public static HivAidsStatusDTO updateHivAidsStatus(HivAidsStatusDTO inputDTO) {
		// Generate a HivAidsStatus from the input
		TmpHivAidsStatus tmpHivAidsStatus = HivAidsStatusManager.generateTmpHivAidsStatus(inputDTO);
		tmpHivAidsStatus.setHivAidsStatusId(Integer.parseInt(inputDTO.getHivAidsStatusId()));
		tmpHivAidsStatus.setDateUpdated(new Date());
		
		// Update the object
		tmpHivAidsStatusDAO.update(tmpHivAidsStatus);
		
		// Return the resulting VO
		return HivAidsStatusManager.generateHivAidsStatusDTO(tmpHivAidsStatus);

	}
	
	public static boolean deleteHivAidsStatus(String hivAidsStatusId) {
		TmpHivAidsStatus tmpHivAidsStatus = tmpHivAidsStatusDAO.getTmpHivAidsStatusById(Integer.parseInt(hivAidsStatusId));
		tmpHivAidsStatusDAO.delete(tmpHivAidsStatus);
		return true;
	}
	
	public static HivAidsStatusDTO generateHivAidsStatusDTO(TmpHivAidsStatus tmpHivAidsStatus) {
		HivAidsStatusDTO hivAidsStatusDTO = new HivAidsStatusDTO();

		hivAidsStatusDTO.setHivAidsStatusId(tmpHivAidsStatus.getHivAidsStatusId().toString());
		hivAidsStatusDTO.setEnrollmentId(tmpHivAidsStatus.getEnrollmentId().toString());

		// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
		hivAidsStatusDTO.setInformationDate(tmpHivAidsStatus.getInformationDate());
		hivAidsStatusDTO.setResponse(YesNoReason.valueByCode(tmpHivAidsStatus.getResponse()));
		hivAidsStatusDTO.setIndefiniteAndImpairs(YesNoReason.valueByCode(tmpHivAidsStatus.getIndefiniteAndImpairs()));
		hivAidsStatusDTO.setDocumentationOnFile(YesNo.valueByCode(tmpHivAidsStatus.getDocumentationOnFile()));
		hivAidsStatusDTO.setReceivingServices(YesNoReason.valueByCode(tmpHivAidsStatus.getReceivingServices()));

		// Export Standard Fields
		hivAidsStatusDTO.setDateCreated(tmpHivAidsStatus.getDateCreated());
		hivAidsStatusDTO.setDateUpdated(tmpHivAidsStatus.getDateUpdated());
		
		return hivAidsStatusDTO;
	}
	
	public static TmpHivAidsStatus generateTmpHivAidsStatus(HivAidsStatusDTO inputDTO) {
		TmpHivAidsStatus tmpHivAidsStatus = new TmpHivAidsStatus();
		
		tmpHivAidsStatus.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
		tmpHivAidsStatus.setInformationDate(inputDTO.getInformationDate());
		tmpHivAidsStatus.setResponse(inputDTO.getResponse().getCode());
		tmpHivAidsStatus.setIndefiniteAndImpairs(inputDTO.getIndefiniteAndImpairs().getCode());
		tmpHivAidsStatus.setDocumentationOnFile(inputDTO.getDocumentationOnFile().getCode());
		tmpHivAidsStatus.setReceivingServices(inputDTO.getReceivingServices().getCode());

		// Export Standard Fields
		tmpHivAidsStatus.setDateCreated(inputDTO.getDateCreated());
		tmpHivAidsStatus.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpHivAidsStatus;
	}
	
}