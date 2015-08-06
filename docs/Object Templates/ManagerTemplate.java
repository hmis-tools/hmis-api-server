package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.dao.TmpCapObjectDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpCapObject;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.CapObjectDTO;

public class CapObjectManager {
	private static final TmpCapObjectDAO tmpCapObjectDAO = new TmpCapObjectDAO();

	public CapObjectManager() {}

	public static CapObjectDTO getCapObjectById(String camelObjectId) {
		CapObjectDTO camelObjectDTO = CapObjectManager.generateCapObjectDTO(tmpCapObjectDAO.getTmpCapObjectById(Integer.parseInt(camelObjectId)));
		return camelObjectDTO;
	}

	public static List<CapObjectDTO> getCapObjectsByEnrollmentId(String enrollmentId) {
		List<CapObjectDTO> camelObjectDTOs = new ArrayList<CapObjectDTO>();

		// Collect the camelObjects
		List<TmpCapObject> tmpCapObjects = tmpCapObjectDAO.getTmpCapObjectsByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each camelObject, collect and map the data
		for (Iterator<TmpCapObject> iterator = tmpCapObjects.iterator(); iterator.hasNext();) {
			TmpCapObject tmpCapObject = iterator.next();
			CapObjectDTO camelObjectDTO = CapObjectManager.generateCapObjectDTO(tmpCapObject);
			camelObjectDTOs.add(camelObjectDTO);
		}
		return camelObjectDTOs;

	}
	
	public static CapObjectDTO addCapObject(CapObjectDTO inputDTO) {
		// Generate a PathClient from the input
		TmpCapObject tmpCapObject = CapObjectManager.generateTmpCapObject(inputDTO);
		
		// Set Export fields
		tmpCapObject.setDateCreated(new Date());
		tmpCapObject.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpCapObjectDAO.save(tmpCapObject);
		inputDTO.setCapObjectId(tmpCapObject.getCapObjectId().toString());
		
		// Return the resulting VO
		return CapObjectManager.generateCapObjectDTO(tmpCapObject);
	}
	
	public static CapObjectDTO updateCapObject(CapObjectDTO inputDTO) {
		// Generate a CapObject from the input
		TmpCapObject tmpCapObject = CapObjectManager.generateTmpCapObject(inputDTO);
		tmpCapObject.setCapObjectId(Integer.parseInt(inputDTO.getCapObjectId()));
		tmpCapObject.setDateUpdated(new Date());
		
		// Update the object
		tmpCapObjectDAO.update(tmpCapObject);
		
		// Return the resulting VO
		return CapObjectManager.generateCapObjectDTO(tmpCapObject);

	}
	
	public static boolean deleteCapObject(String camelObjectId) {
		TmpCapObject tmpCapObject = tmpCapObjectDAO.getTmpCapObjectById(Integer.parseInt(camelObjectId));
		tmpCapObjectDAO.delete(tmpCapObject);
		return true;
	}
	
	public static CapObjectDTO generateCapObjectDTO(TmpCapObject tmpCapObject) {
		CapObjectDTO camelObjectDTO = new CapObjectDTO();

		camelObjectDTO.setCapObjectId(tmpCapObject.getCapObjectId().toString());
		camelObjectDTO.setEnrollmentId(tmpCapObject.getEnrollmentId().toString());

		camelObjectDTO.set(tmpCapObject.get());

		// Export Standard Fields
		camelObjectDTO.setDateCreated(tmpCapObject.getDateCreated());
		camelObjectDTO.setDateUpdated(tmpCapObject.getDateUpdated());
		
		return camelObjectDTO;
	}
	
	public static TmpCapObject generateTmpCapObject(CapObjectDTO inputDTO) {
		TmpCapObject tmpCapObject = new TmpCapObject();
		
		tmpCapObject.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		tmpCapObject.set(inputDTO.get());

		// Export Standard Fields
		tmpCapObject.setDateCreated(inputDTO.getDateCreated());
		tmpCapObject.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpCapObject;
	}
	
}