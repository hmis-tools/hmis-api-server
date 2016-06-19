package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientReasonNotInsured;
import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.TmpHealthInsuranceDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpHealthInsurance;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.HealthInsuranceDTO;
import org.openhmis.dto.search.HealthInsuranceSearchDTO;

public class HealthInsuranceManager {
	private TmpHealthInsuranceDAO tmpHealthInsuranceDAO;

	public HealthInsuranceManager() {
		this.tmpHealthInsuranceDAO = new TmpHealthInsuranceDAO();
	}

	public HealthInsuranceManager(TmpHealthInsuranceDAO tmpHealthInsuranceDAO) {
		this.tmpHealthInsuranceDAO = new TmpHealthInsuranceDAO();
	}

	public HealthInsuranceDTO getHealthInsuranceById(String healthInsuranceId) {
		HealthInsuranceDTO healthInsuranceDTO = HealthInsuranceManager.generateHealthInsuranceDTO(tmpHealthInsuranceDAO.getTmpHealthInsuranceById(Integer.parseInt(healthInsuranceId)));
		return healthInsuranceDTO;
	}

	public List<HealthInsuranceDTO> getHealthInsurances(HealthInsuranceSearchDTO searchDTO) {
		List<HealthInsuranceDTO> healthInsuranceDTOs = new ArrayList<HealthInsuranceDTO>();

		// Collect the healthInsurances
		List<TmpHealthInsurance> tmpHealthInsurances = tmpHealthInsuranceDAO.getTmpHealthInsurances(searchDTO);

		// For each healthInsurance, collect and map the data
		for (Iterator<TmpHealthInsurance> iterator = tmpHealthInsurances.iterator(); iterator.hasNext();) {
			TmpHealthInsurance tmpHealthInsurance = iterator.next();
			HealthInsuranceDTO healthInsuranceDTO = HealthInsuranceManager.generateHealthInsuranceDTO(tmpHealthInsurance);
			healthInsuranceDTOs.add(healthInsuranceDTO);
		}
		return healthInsuranceDTOs;

	}

	public HealthInsuranceDTO addHealthInsurance(HealthInsuranceDTO inputDTO) {
		// Generate a PathClient from the input
		TmpHealthInsurance tmpHealthInsurance = HealthInsuranceManager.generateTmpHealthInsurance(inputDTO);
		
		// Set Export fields
		tmpHealthInsurance.setDateCreated(new Date());
		tmpHealthInsurance.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpHealthInsuranceDAO.save(tmpHealthInsurance);
		inputDTO.setHealthInsuranceId(tmpHealthInsurance.getHealthInsuranceId().toString());
		
		// Return the resulting VO
		return HealthInsuranceManager.generateHealthInsuranceDTO(tmpHealthInsurance);
	}
	
	public HealthInsuranceDTO updateHealthInsurance(HealthInsuranceDTO inputDTO) {
		// Generate a HealthInsurance from the input
		TmpHealthInsurance tmpHealthInsurance = HealthInsuranceManager.generateTmpHealthInsurance(inputDTO);
		tmpHealthInsurance.setHealthInsuranceId(Integer.parseInt(inputDTO.getHealthInsuranceId()));
		tmpHealthInsurance.setDateUpdated(new Date());
		
		// Update the object
		tmpHealthInsuranceDAO.update(tmpHealthInsurance);
		
		// Return the resulting VO
		return HealthInsuranceManager.generateHealthInsuranceDTO(tmpHealthInsurance);

	}
	
	public boolean deleteHealthInsurance(String healthInsuranceId) {
		TmpHealthInsurance tmpHealthInsurance = tmpHealthInsuranceDAO.getTmpHealthInsuranceById(Integer.parseInt(healthInsuranceId));
		tmpHealthInsuranceDAO.delete(tmpHealthInsurance);
		return true;
	}
	
}
