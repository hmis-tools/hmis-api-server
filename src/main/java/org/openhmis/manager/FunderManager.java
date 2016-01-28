package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ProjectFundingSource;
import org.openhmis.dao.TmpProjectFunderDAO;
import org.openhmis.domain.TmpProjectFunder;
import org.openhmis.dto.FunderDTO;

public class FunderManager {
	private static final TmpProjectFunderDAO tmpProjectFunderDAO = new TmpProjectFunderDAO();

	public FunderManager() {}

	public static FunderDTO getFunderByProjectFunderId(String projectFunderId) {
		Integer projectFunderIdInt = Integer.parseInt(projectFunderId);
		TmpProjectFunder tmpProjectFunder= tmpProjectFunderDAO.getTmpProjectFunderById(projectFunderIdInt);		
		FunderDTO FunderDTO = FunderManager.generateFunderDTO(tmpProjectFunder);
		return FunderDTO;
	}

	public static List<FunderDTO> getFundersByProjectId(String projectId) {
		List<FunderDTO> funderDTOs = new ArrayList<FunderDTO>();

		// Collect the projects
		List<TmpProjectFunder> tmpProjectFunders = tmpProjectFunderDAO.getTmpProjectFundersByProjectId(Integer.parseInt(projectId));

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProjectFunder> iterator = tmpProjectFunders.iterator(); iterator.hasNext();) {
			TmpProjectFunder tmpProjectFunder = iterator.next();

			FunderDTO funderDTO = FunderManager.generateFunderDTO(tmpProjectFunder);
			funderDTOs.add(funderDTO);
		}
		return funderDTOs;

	}
	
	public static FunderDTO addFunder(FunderDTO inputDTO) {

		// Generate a PathClient from the input
		TmpProjectFunder tmpProjectFunder = FunderManager.generateTmpProjectFunder(inputDTO);
		
		// Set Export fields
		tmpProjectFunder.setDateCreated(new Date());
		tmpProjectFunder.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpProjectFunderDAO.save(tmpProjectFunder);
		inputDTO.setFunderId(tmpProjectFunder.getFunderId().toString());
		
		// Return the resulting VO
		return FunderManager.generateFunderDTO(tmpProjectFunder);
	}
	
	public static FunderDTO updateFunder(FunderDTO inputDTO) {
		// Generate a TmpProject from the input
		TmpProjectFunder tmpProjectFunder = FunderManager.generateTmpProjectFunder(inputDTO);
		tmpProjectFunder.setFunderId(Integer.parseInt(inputDTO.getFunderId()));
		tmpProjectFunder.setDateUpdated(new Date());
		
		// Update the client
		tmpProjectFunderDAO.update(tmpProjectFunder);
		
		// Return the resulting VO
		return FunderManager.generateFunderDTO(tmpProjectFunder);
		
	}
	
	public static boolean deleteFunder(String projectFunderId) {
		TmpProjectFunder tmpProjectFunder = tmpProjectFunderDAO.getTmpProjectFunderById(Integer.parseInt(projectFunderId));
		tmpProjectFunderDAO.delete(tmpProjectFunder);
		
		return true;
	}
	
	public static FunderDTO generateFunderDTO(TmpProjectFunder tmpProjectFunder) {
		FunderDTO funderDTO = new FunderDTO();
		funderDTO.setFunderId(tmpProjectFunder.getFunderId().toString());
		funderDTO.setProjectId(tmpProjectFunder.getProjectId().toString());
		
		// Universal Data Standard: Funder (2014, 2.6) 
		funderDTO.setFunder(ProjectFundingSource.valueByCode(tmpProjectFunder.getFunder()));
		funderDTO.setGrantId(tmpProjectFunder.getGrantId());
		funderDTO.setStartDate(tmpProjectFunder.getStartDate());
		funderDTO.setEndDate(tmpProjectFunder.getEndDate());
		
		// Export Standard Fields
		funderDTO.setDateCreated(tmpProjectFunder.getDateCreated());
		funderDTO.setDateUpdated(tmpProjectFunder.getDateUpdated());
		
		return funderDTO;
	}

	public static TmpProjectFunder generateTmpProjectFunder(FunderDTO inputDTO) {
		TmpProjectFunder tmpProjectFunder = new TmpProjectFunder();
		
		tmpProjectFunder.setFunderId(Integer.parseInt(inputDTO.getFunderId()));
		tmpProjectFunder.setProjectId(Integer.parseInt(inputDTO.getProjectId()));
		
		// Universal Data Standard: Funder (2014, 2.6) 
		tmpProjectFunder.setFunder(inputDTO.getFunder().getCode());
		tmpProjectFunder.setGrantId(inputDTO.getGrantId());
		tmpProjectFunder.setStartDate(inputDTO.getStartDate());
		tmpProjectFunder.setEndDate(inputDTO.getEndDate());

		// Export Standard Fields
		tmpProjectFunder.setDateCreated(inputDTO.getDateCreated());
		tmpProjectFunder.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpProjectFunder;

	}
	
}