package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientDestination;
import org.openhmis.code.ClientEarlyExitReason;
import org.openhmis.code.ClientEmploymentType;
import org.openhmis.code.ClientExitAction;
import org.openhmis.code.ClientExpelledReason;
import org.openhmis.code.ClientHealthStatus;
import org.openhmis.code.ClientHousingAssessmentAtExit;
import org.openhmis.code.ClientHousingAssessmentDisposition;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.code.ClientNotEmployedReason;
import org.openhmis.code.ClientProjectCompletionStatus;
import org.openhmis.code.ClientSubsidyInformation;
import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.TmpExitDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpExit;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.exception.InvalidParameterException;
import org.openhmis.dto.ExitDTO;
import org.openhmis.dto.search.ExitSearchDTO;

public class ExitManager {
	private TmpExitDAO tmpExitDAO;

	public ExitManager() {
		this.tmpExitDAO = new TmpExitDAO();
	}
	
	public ExitManager(TmpExitDAO tmpExitDAO) {
		this.tmpExitDAO = tmpExitDAO;
	}

	public ExitDTO getExitById(String exitId) {
		ExitDTO exitDTO = ExitManager.generateExitDTO(tmpExitDAO.getTmpExitById(Integer.parseInt(exitId)));
		return exitDTO;
	}

	public List<ExitDTO> getExits(ExitSearchDTO searchDTO) {
		List<ExitDTO> exitDTOs = new ArrayList<ExitDTO>();

		// Collect the exits
		List<TmpExit> tmpExits = tmpExitDAO.getTmpExits(searchDTO);

		// For each exit, collect and map the data
		for (Iterator<TmpExit> iterator = tmpExits.iterator(); iterator.hasNext();) {
			TmpExit tmpExit = iterator.next();
			ExitDTO exitDTO = ExitManager.generateExitDTO(tmpExit);
			exitDTOs.add(exitDTO);
		}
		return exitDTOs;

	}

	public List<ExitDTO> getExits(Date updateDate) {
		List<ExitDTO> exitDTOs = new ArrayList<ExitDTO>();

		// Collect the exits
		List<TmpExit> tmpExits = tmpExitDAO.getTmpExits(updateDate);

		// For each exit, collect and map the data
		for (Iterator<TmpExit> iterator = tmpExits.iterator(); iterator.hasNext();) {
			TmpExit tmpExit = iterator.next();
			ExitDTO exitDTO = ExitManager.generateExitDTO(tmpExit);
			exitDTOs.add(exitDTO);
		}
		return exitDTOs;

	}

	public ExitDTO getExitByEnrollmentId(String enrollmentId) {
		List<ExitDTO> exitDTOs = new ArrayList<ExitDTO>();

		// Collect the exits
		TmpExit tmpExit = tmpExitDAO.getTmpExitByEnrollmentId(Integer.parseInt(enrollmentId));

		ExitDTO exitDTO = ExitManager.generateExitDTO(tmpExit);
		return exitDTO;

	}
	
	public ExitDTO addExit(ExitDTO inputDTO) {
		// Validate the exit
		// TODO: this should return a list of errors that get wrapped appropriately
		if(!validateExit(inputDTO))
			return null;
		
		// Generate a PathClient from the input
		TmpExit tmpExit = ExitManager.generateTmpExit(inputDTO);
		
		// Set Export fields
		tmpExit.setDateCreated(new Date());
		tmpExit.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpExitDAO.save(tmpExit);
		inputDTO.setExitId(tmpExit.getExitId().toString());
		
		// Return the resulting VO
		return ExitManager.generateExitDTO(tmpExit);
	}
	
	public ExitDTO updateExit(ExitDTO inputDTO) {
		// Generate a Exit from the input
		TmpExit tmpExit = ExitManager.generateTmpExit(inputDTO);

		// Validate the exit
		// TODO: this should return a list of errors that get wrapped appropriately
		if(!validateExit(inputDTO))
			return null;
		
		tmpExit.setExitId(Integer.parseInt(inputDTO.getExitId()));
		tmpExit.setDateUpdated(new Date());
		
		// Update the object
		tmpExitDAO.update(tmpExit);
		
		// Return the resulting VO
		return ExitManager.generateExitDTO(tmpExit);

	}
	
	public boolean deleteExit(String exitId) {
		TmpExit tmpExit = tmpExitDAO.getTmpExitById(Integer.parseInt(exitId));
		tmpExitDAO.delete(tmpExit);
		return true;
	}
	
}
