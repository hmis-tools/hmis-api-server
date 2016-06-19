package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientHopwaFinancialAssistance;
import org.openhmis.code.ClientSsvfFinancialAssistance;
import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.dao.TmpFinancialAssistanceDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpFinancialAssistance;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.FinancialAssistanceDTO;
import org.openhmis.dto.search.FinancialAssistanceSearchDTO;

public class FinancialAssistanceManager {
	private TmpFinancialAssistanceDAO tmpFinancialAssistanceDAO;

	public FinancialAssistanceManager() {
		this.tmpFinancialAssistanceDAO = new TmpFinancialAssistanceDAO();
	}
	
	public FinancialAssistanceManager(TmpFinancialAssistanceDAO tmpFinancialAssistanceDAO) {
		this.tmpFinancialAssistanceDAO = tmpFinancialAssistanceDAO;
	}

	public FinancialAssistanceDTO getFinancialAssistanceById(String financialAssistanceId) {
		FinancialAssistanceDTO financialAssistanceDTO = FinancialAssistanceManager.generateFinancialAssistanceDTO(tmpFinancialAssistanceDAO.getTmpFinancialAssistanceById(Integer.parseInt(financialAssistanceId)));
		return financialAssistanceDTO;
	}

	public List<FinancialAssistanceDTO> getFinancialAssistances(FinancialAssistanceSearchDTO searchDTO) {
		List<FinancialAssistanceDTO> financialAssistanceDTOs = new ArrayList<FinancialAssistanceDTO>();

		// Collect the financialAssistances
		List<TmpFinancialAssistance> tmpFinancialAssistances = tmpFinancialAssistanceDAO.getTmpFinancialAssistances(searchDTO);

		// For each financialAssistance, collect and map the data
		for (Iterator<TmpFinancialAssistance> iterator = tmpFinancialAssistances.iterator(); iterator.hasNext();) {
			TmpFinancialAssistance tmpFinancialAssistance = iterator.next();
			FinancialAssistanceDTO financialAssistanceDTO = FinancialAssistanceManager.generateFinancialAssistanceDTO(tmpFinancialAssistance);
			financialAssistanceDTOs.add(financialAssistanceDTO);
		}
		return financialAssistanceDTOs;

	}

	public FinancialAssistanceDTO addFinancialAssistance(FinancialAssistanceDTO inputDTO) {
		// Generate a PathClient from the input
		TmpFinancialAssistance tmpFinancialAssistance = FinancialAssistanceManager.generateTmpFinancialAssistance(inputDTO);
		
		// Set Export fields
		tmpFinancialAssistance.setDateCreated(new Date());
		tmpFinancialAssistance.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpFinancialAssistanceDAO.save(tmpFinancialAssistance);
		inputDTO.setFinancialAssistanceId(tmpFinancialAssistance.getFinancialAssistanceId().toString());
		
		// Return the resulting VO
		return FinancialAssistanceManager.generateFinancialAssistanceDTO(tmpFinancialAssistance);
	}
	
	public FinancialAssistanceDTO updateFinancialAssistance(FinancialAssistanceDTO inputDTO) {
		// Generate a FinancialAssistance from the input
		TmpFinancialAssistance tmpFinancialAssistance = FinancialAssistanceManager.generateTmpFinancialAssistance(inputDTO);
		tmpFinancialAssistance.setFinancialAssistanceId(Integer.parseInt(inputDTO.getFinancialAssistanceId()));
		tmpFinancialAssistance.setDateUpdated(new Date());
		
		// Update the object
		tmpFinancialAssistanceDAO.update(tmpFinancialAssistance);
		
		// Return the resulting VO
		return FinancialAssistanceManager.generateFinancialAssistanceDTO(tmpFinancialAssistance);

	}
	
	public boolean deleteFinancialAssistance(String financialAssistanceId) {
		TmpFinancialAssistance tmpFinancialAssistance = tmpFinancialAssistanceDAO.getTmpFinancialAssistanceById(Integer.parseInt(financialAssistanceId));
		tmpFinancialAssistanceDAO.delete(tmpFinancialAssistance);
		return true;
	}
	
	public static boolean validateFinancialAssistance(FinancialAssistanceDTO inputDTO) {
		return true;
	}
	
}
