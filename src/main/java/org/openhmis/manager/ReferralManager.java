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
	private static final TmpReferralDAO tmpReferralDAO = new TmpReferralDAO();

	public ReferralManager() {}

	public static ReferralDTO getReferralById(String referralId) {
		ReferralDTO referralDTO = ReferralManager.generateReferralDTO(tmpReferralDAO.getTmpReferralById(Integer.parseInt(referralId)));
		return referralDTO;
	}

	public static List<ReferralDTO> getReferrals(ReferralSearchDTO searchDTO) {
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

	public static List<ReferralDTO> getReferrals(Date updateDate) {
		List<ReferralDTO> referralDTOs = new ArrayList<ReferralDTO>();

		// Collect the referrals
		List<TmpReferral> tmpReferrals = tmpReferralDAO.getTmpReferrals(updateDate);

		// For each referral, collect and map the data
		for (Iterator<TmpReferral> iterator = tmpReferrals.iterator(); iterator.hasNext();) {
			TmpReferral tmpReferral = iterator.next();
			ReferralDTO referralDTO = ReferralManager.generateReferralDTO(tmpReferral);
			referralDTOs.add(referralDTO);
		}
		return referralDTOs;

	}

	public static List<ReferralDTO> getReferralsByEnrollmentId(String enrollmentId) {
		List<ReferralDTO> referralDTOs = new ArrayList<ReferralDTO>();

		// Collect the referrals
		List<TmpReferral> tmpReferrals = tmpReferralDAO.getTmpReferralsByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each referral, collect and map the data
		for (Iterator<TmpReferral> iterator = tmpReferrals.iterator(); iterator.hasNext();) {
			TmpReferral tmpReferral = iterator.next();
			ReferralDTO referralDTO = ReferralManager.generateReferralDTO(tmpReferral);
			referralDTOs.add(referralDTO);
		}
		return referralDTOs;

	}

	public static List<ReferralDTO> getReferralsByEnrollmentId(String enrollmentId, Date updateDate) {
		List<ReferralDTO> referralDTOs = new ArrayList<ReferralDTO>();

		// Collect the referrals
		List<TmpReferral> tmpReferrals = tmpReferralDAO.getTmpReferralsByEnrollmentId(Integer.parseInt(enrollmentId), updateDate);

		// For each referral, collect and map the data
		for (Iterator<TmpReferral> iterator = tmpReferrals.iterator(); iterator.hasNext();) {
			TmpReferral tmpReferral = iterator.next();
			ReferralDTO referralDTO = ReferralManager.generateReferralDTO(tmpReferral);
			referralDTOs.add(referralDTO);
		}
		return referralDTOs;

	}
	
	public static ReferralDTO addReferral(ReferralDTO inputDTO) {
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
	
	public static ReferralDTO updateReferral(ReferralDTO inputDTO) {
		// Generate a Referral from the input
		TmpReferral tmpReferral = ReferralManager.generateTmpReferral(inputDTO);
		tmpReferral.setReferralId(Integer.parseInt(inputDTO.getReferralId()));
		tmpReferral.setDateUpdated(new Date());
		
		// Update the object
		tmpReferralDAO.update(tmpReferral);
		
		// Return the resulting VO
		return ReferralManager.generateReferralDTO(tmpReferral);

	}
	
	public static boolean deleteReferral(String referralId) {
		TmpReferral tmpReferral = tmpReferralDAO.getTmpReferralById(Integer.parseInt(referralId));
		tmpReferralDAO.delete(tmpReferral);
		return true;
	}
	
	public static ReferralDTO generateReferralDTO(TmpReferral tmpReferral) {
		ReferralDTO referralDTO = new ReferralDTO();

		referralDTO.setReferralId(tmpReferral.getReferralId().toString());
		referralDTO.setEnrollmentId(tmpReferral.getEnrollmentId().toString());

		// Program Specific Data Standards: References Provided (2014, 4.16)
		referralDTO.setReferralDate(tmpReferral.getReferralDate());
		
		// PATH (2014, 4.16A)
		referralDTO.setPathTypeProvided(ClientPathReferral.valueByCode(tmpReferral.getPathTypeProvided()));
		referralDTO.setReferralOutcome(ClientPathReferralOutcome.valueByCode(tmpReferral.getReferralOutcome()));
		
		// RHY (2014, 4.16B)
		referralDTO.setRhyTypeProvided(ClientRhyReferral.valueByCode(tmpReferral.getRhyTypeProvided()));

		// Export Standard Fields
		referralDTO.setDateCreated(tmpReferral.getDateCreated());
		referralDTO.setDateUpdated(tmpReferral.getDateUpdated());
		
		return referralDTO;
	}
	
	public static TmpReferral generateTmpReferral(ReferralDTO inputDTO) {
		TmpReferral tmpReferral = new TmpReferral();
		
		tmpReferral.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: References Provided (2014, 4.16)
		tmpReferral.setReferralDate(inputDTO.getReferralDate());
		
		// PATH (2014, 4.16A)
		tmpReferral.setPathTypeProvided(inputDTO.getPathTypeProvided().getCode());
		tmpReferral.setReferralOutcome(inputDTO.getReferralOutcome().getCode());
		
		// RHY (2014, 4.16B)
		tmpReferral.setRhyTypeProvided(inputDTO.getRhyTypeProvided().getCode());

		// Export Standard Fields
		tmpReferral.setDateCreated(inputDTO.getDateCreated());
		tmpReferral.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpReferral;
	}
	
}
