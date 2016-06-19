package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.code.ProjectFundingSource;
import org.openhmis.dao.TmpProjectFunderDAO;
import org.openhmis.domain.TmpProjectFunder;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.search.FunderSearchDTO;
import org.openhmis.exception.InvalidParameterException;

public class FunderManager {
	private TmpProjectFunderDAO tmpProjectFunderDAO;

	public FunderManager() {
		this.tmpProjectFunderDAO = new TmpProjectFunderDAO();
	}
	public FunderManager(TmpProjectFunderDAO tmpProjectFunderDAO) {
		this.tmpProjectFunderDAO = tmpProjectFunderDAO;
	}

	public FunderDTO getFunderById(String projectFunderId) {
		Integer projectFunderIdInt = Integer.parseInt(projectFunderId);
		TmpProjectFunder tmpProjectFunder= tmpProjectFunderDAO.getTmpProjectFunderById(projectFunderIdInt);		
		FunderDTO FunderDTO = FunderManager.generateFunderDTO(tmpProjectFunder);
		return FunderDTO;
	}

	public List<FunderDTO> getFunders(FunderSearchDTO searchDTO) {
		List<FunderDTO> funderDTOs = new ArrayList<FunderDTO>();

		// Collect the projects
		List<TmpProjectFunder> tmpProjectFunders = tmpProjectFunderDAO.getTmpProjectFunders(searchDTO);

		// For each project, collect and map the data
		// TODO: this should be done in a single query
		for (Iterator<TmpProjectFunder> iterator = tmpProjectFunders.iterator(); iterator.hasNext();) {
			TmpProjectFunder tmpProjectFunder = iterator.next();

			FunderDTO funderDTO = FunderManager.generateFunderDTO(tmpProjectFunder);
			funderDTOs.add(funderDTO);
		}
		return funderDTOs;

	}


	public FunderDTO addFunder(FunderDTO inputDTO) {
		// Make sure the fields are valid
		validateFunder(inputDTO);

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
	
	public FunderDTO updateFunder(FunderDTO inputDTO) {
		// Generate a TmpProject from the input
		TmpProjectFunder tmpProjectFunder = FunderManager.generateTmpProjectFunder(inputDTO);
		
		// Make sure the fields are valid
		validateFunder(inputDTO);
		
		tmpProjectFunder.setFunderId(Integer.parseInt(inputDTO.getFunderId()));
		tmpProjectFunder.setDateUpdated(new Date());
		
		// Update the client
		tmpProjectFunderDAO.update(tmpProjectFunder);
		
		// Return the resulting VO
		return FunderManager.generateFunderDTO(tmpProjectFunder);
		
	}
	
	public boolean deleteFunder(String projectFunderId) {
		TmpProjectFunder tmpProjectFunder = tmpProjectFunderDAO.getTmpProjectFunderById(Integer.parseInt(projectFunderId));
		tmpProjectFunderDAO.delete(tmpProjectFunder);
		
		return true;
	}
	
}
