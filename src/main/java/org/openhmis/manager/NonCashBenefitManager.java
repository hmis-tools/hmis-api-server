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
import org.openhmis.dao.TmpNonCashBenefitDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpNonCashBenefit;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.NonCashBenefitDTO;
import org.openhmis.dto.search.NonCashBenefitSearchDTO;

public class NonCashBenefitManager {
	private TmpNonCashBenefitDAO tmpNonCashBenefitDAO;

	public NonCashBenefitManager() {
		this.tmpNonCashBenefitDAO = new TmpNonCashBenefitDAO();
	}

	public NonCashBenefitManager(TmpNonCashBenefitDAO tmpNonCashBenefitDAO) {
		this.tmpNonCashBenefitDAO = tmpNonCashBenefitDAO;
	}

	public NonCashBenefitDTO getNonCashBenefitById(String nonCashBenefitId) {
		NonCashBenefitDTO nonCashBenefitDTO = NonCashBenefitManager.generateNonCashBenefitDTO(tmpNonCashBenefitDAO.getTmpNonCashBenefitById(Integer.parseInt(nonCashBenefitId)));
		return nonCashBenefitDTO;
	}
	public List<NonCashBenefitDTO> getNonCashBenefits(NonCashBenefitSearchDTO searchDTO) {
		List<NonCashBenefitDTO> nonCashBenefitDTOs = new ArrayList<NonCashBenefitDTO>();

		// Collect the nonCashBenefits
		List<TmpNonCashBenefit> tmpNonCashBenefits = tmpNonCashBenefitDAO.getTmpNonCashBenefits(searchDTO);

		// For each nonCashBenefit, collect and map the data
		for (Iterator<TmpNonCashBenefit> iterator = tmpNonCashBenefits.iterator(); iterator.hasNext();) {
			TmpNonCashBenefit tmpNonCashBenefit = iterator.next();
			NonCashBenefitDTO nonCashBenefitDTO = NonCashBenefitManager.generateNonCashBenefitDTO(tmpNonCashBenefit);
			nonCashBenefitDTOs.add(nonCashBenefitDTO);
		}
		return nonCashBenefitDTOs;

	}

	public NonCashBenefitDTO addNonCashBenefit(NonCashBenefitDTO inputDTO) {
		// Generate a PathClient from the input
		TmpNonCashBenefit tmpNonCashBenefit = NonCashBenefitManager.generateTmpNonCashBenefit(inputDTO);
		
		// Set Export fields
		tmpNonCashBenefit.setDateCreated(new Date());
		tmpNonCashBenefit.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpNonCashBenefitDAO.save(tmpNonCashBenefit);
		inputDTO.setNonCashBenefitId(tmpNonCashBenefit.getNonCashBenefitId().toString());
		
		// Return the resulting VO
		return NonCashBenefitManager.generateNonCashBenefitDTO(tmpNonCashBenefit);
	}
	
	public NonCashBenefitDTO updateNonCashBenefit(NonCashBenefitDTO inputDTO) {
		// Generate a NonCashBenefit from the input
		TmpNonCashBenefit tmpNonCashBenefit = NonCashBenefitManager.generateTmpNonCashBenefit(inputDTO);
		tmpNonCashBenefit.setNonCashBenefitId(Integer.parseInt(inputDTO.getNonCashBenefitId()));
		tmpNonCashBenefit.setDateUpdated(new Date());
		
		// Update the object
		tmpNonCashBenefitDAO.update(tmpNonCashBenefit);
		
		// Return the resulting VO
		return NonCashBenefitManager.generateNonCashBenefitDTO(tmpNonCashBenefit);

	}
	
	public boolean deleteNonCashBenefit(String nonCashBenefitId) {
		TmpNonCashBenefit tmpNonCashBenefit = tmpNonCashBenefitDAO.getTmpNonCashBenefitById(Integer.parseInt(nonCashBenefitId));
		tmpNonCashBenefitDAO.delete(tmpNonCashBenefit);
		return true;
	}
	
}
