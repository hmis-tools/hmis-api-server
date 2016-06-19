package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientPathReferral;
import org.openhmis.code.ClientPathReferralOutcome;
import org.openhmis.code.ClientRhyReferral;
import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.dao.TmpReferralDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpReferral;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.ReferralDTO;
import org.openhmis.dto.search.ReferralSearchDTO;

public class ReferralManager {
	private TmpReferralDAO tmpReferralDAO;

	public ReferralManager() {
		this.tmpReferralDAO = new TmpReferralDAO();
	}

	public ReferralManager(TmpReferralDAO tmpReferralDAO) {
		this.tmpReferralDAO = tmpReferralDAO;
	}

	public ReferralDTO getReferralById(String referralId) {
		ReferralDTO referralDTO = ReferralManager.generateReferralDTO(tmpReferralDAO.getTmpReferralById(Integer.parseInt(referralId)));
		return referralDTO;
	}

	public List<ReferralDTO> getReferrals(ReferralSearchDTO searchDTO) {
		List<ReferralDTO> referralDTOs = new ArrayList<ReferralDTO>();

		// Collect the referrals
		List<TmpReferral> tmpReferrals = tmpReferralDAO.getTmpReferrals(searchDTO);

		// For each referral, collect and map the data
		for (Iterator<TmpReferral> iterator = tmpReferrals.iterator(); iterator.hasNext();) {
			TmpReferral tmpReferral = iterator.next();
			ReferralDTO referralDTO = ReferralManager.generateReferralDTO(tmpReferral);
			referralDTOs.add(referralDTO);
		}
		return referralDTOs;

	}

	public ReferralDTO addReferral(ReferralDTO inputDTO) {
		// Generate a PathClient from the input
		TmpReferral tmpReferral = ReferralManager.generateTmpReferral(inputDTO);
		
		// Set Export fields
		tmpReferral.setDateCreated(new Date());
		tmpReferral.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpReferralDAO.save(tmpReferral);
		inputDTO.setReferralId(tmpReferral.getReferralId().toString());
		
		// Return the resulting VO
		return ReferralManager.generateReferralDTO(tmpReferral);
	}
	
	public ReferralDTO updateReferral(ReferralDTO inputDTO) {
		// Generate a Referral from the input
		TmpReferral tmpReferral = ReferralManager.generateTmpReferral(inputDTO);
		tmpReferral.setReferralId(Integer.parseInt(inputDTO.getReferralId()));
		tmpReferral.setDateUpdated(new Date());
		
		// Update the object
		tmpReferralDAO.update(tmpReferral);
		
		// Return the resulting VO
		return ReferralManager.generateReferralDTO(tmpReferral);

	}
	
	public boolean deleteReferral(String referralId) {
		TmpReferral tmpReferral = tmpReferralDAO.getTmpReferralById(Integer.parseInt(referralId));
		tmpReferralDAO.delete(tmpReferral);
		return true;
	}
	
}
