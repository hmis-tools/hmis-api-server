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

public class NonCashBenefitManager {
	private static final TmpNonCashBenefitDAO tmpNonCashBenefitDAO = new TmpNonCashBenefitDAO();

	public NonCashBenefitManager() {}

	public static NonCashBenefitDTO getNonCashBenefitById(String nonCashBenefitId) {
		NonCashBenefitDTO nonCashBenefitDTO = NonCashBenefitManager.generateNonCashBenefitDTO(tmpNonCashBenefitDAO.getTmpNonCashBenefitById(Integer.parseInt(nonCashBenefitId)));
		return nonCashBenefitDTO;
	}

	public static List<NonCashBenefitDTO> getNonCashBenefits() {
		List<NonCashBenefitDTO> nonCashBenefitDTOs = new ArrayList<NonCashBenefitDTO>();

		// Collect the nonCashBenefits
		List<TmpNonCashBenefit> tmpNonCashBenefits = tmpNonCashBenefitDAO.getTmpNonCashBenefits();

		// For each nonCashBenefit, collect and map the data
		for (Iterator<TmpNonCashBenefit> iterator = tmpNonCashBenefits.iterator(); iterator.hasNext();) {
			TmpNonCashBenefit tmpNonCashBenefit = iterator.next();
			NonCashBenefitDTO nonCashBenefitDTO = NonCashBenefitManager.generateNonCashBenefitDTO(tmpNonCashBenefit);
			nonCashBenefitDTOs.add(nonCashBenefitDTO);
		}
		return nonCashBenefitDTOs;

	}

	public static List<NonCashBenefitDTO> getNonCashBenefits(Date updateDate) {
		List<NonCashBenefitDTO> nonCashBenefitDTOs = new ArrayList<NonCashBenefitDTO>();

		// Collect the nonCashBenefits
		List<TmpNonCashBenefit> tmpNonCashBenefits = tmpNonCashBenefitDAO.getTmpNonCashBenefits(updateDate);

		// For each nonCashBenefit, collect and map the data
		for (Iterator<TmpNonCashBenefit> iterator = tmpNonCashBenefits.iterator(); iterator.hasNext();) {
			TmpNonCashBenefit tmpNonCashBenefit = iterator.next();
			NonCashBenefitDTO nonCashBenefitDTO = NonCashBenefitManager.generateNonCashBenefitDTO(tmpNonCashBenefit);
			nonCashBenefitDTOs.add(nonCashBenefitDTO);
		}
		return nonCashBenefitDTOs;

	}

	public static List<NonCashBenefitDTO> getNonCashBenefitsByEnrollmentId(String enrollmentId) {
		List<NonCashBenefitDTO> nonCashBenefitDTOs = new ArrayList<NonCashBenefitDTO>();

		// Collect the nonCashBenefits
		List<TmpNonCashBenefit> tmpNonCashBenefits = tmpNonCashBenefitDAO.getTmpNonCashBenefitsByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each nonCashBenefit, collect and map the data
		for (Iterator<TmpNonCashBenefit> iterator = tmpNonCashBenefits.iterator(); iterator.hasNext();) {
			TmpNonCashBenefit tmpNonCashBenefit = iterator.next();
			NonCashBenefitDTO nonCashBenefitDTO = NonCashBenefitManager.generateNonCashBenefitDTO(tmpNonCashBenefit);
			nonCashBenefitDTOs.add(nonCashBenefitDTO);
		}
		return nonCashBenefitDTOs;

	}

	public static List<NonCashBenefitDTO> getNonCashBenefitsByEnrollmentId(String enrollmentId, Date updateDate) {
		List<NonCashBenefitDTO> nonCashBenefitDTOs = new ArrayList<NonCashBenefitDTO>();

		// Collect the nonCashBenefits
		List<TmpNonCashBenefit> tmpNonCashBenefits = tmpNonCashBenefitDAO.getTmpNonCashBenefitsByEnrollmentId(Integer.parseInt(enrollmentId), updateDate);

		// For each nonCashBenefit, collect and map the data
		for (Iterator<TmpNonCashBenefit> iterator = tmpNonCashBenefits.iterator(); iterator.hasNext();) {
			TmpNonCashBenefit tmpNonCashBenefit = iterator.next();
			NonCashBenefitDTO nonCashBenefitDTO = NonCashBenefitManager.generateNonCashBenefitDTO(tmpNonCashBenefit);
			nonCashBenefitDTOs.add(nonCashBenefitDTO);
		}
		return nonCashBenefitDTOs;

	}
	
	public static NonCashBenefitDTO addNonCashBenefit(NonCashBenefitDTO inputDTO) {
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
	
	public static NonCashBenefitDTO updateNonCashBenefit(NonCashBenefitDTO inputDTO) {
		// Generate a NonCashBenefit from the input
		TmpNonCashBenefit tmpNonCashBenefit = NonCashBenefitManager.generateTmpNonCashBenefit(inputDTO);
		tmpNonCashBenefit.setNonCashBenefitId(Integer.parseInt(inputDTO.getNonCashBenefitId()));
		tmpNonCashBenefit.setDateUpdated(new Date());
		
		// Update the object
		tmpNonCashBenefitDAO.update(tmpNonCashBenefit);
		
		// Return the resulting VO
		return NonCashBenefitManager.generateNonCashBenefitDTO(tmpNonCashBenefit);

	}
	
	public static boolean deleteNonCashBenefit(String nonCashBenefitId) {
		TmpNonCashBenefit tmpNonCashBenefit = tmpNonCashBenefitDAO.getTmpNonCashBenefitById(Integer.parseInt(nonCashBenefitId));
		tmpNonCashBenefitDAO.delete(tmpNonCashBenefit);
		return true;
	}
	
	public static NonCashBenefitDTO generateNonCashBenefitDTO(TmpNonCashBenefit tmpNonCashBenefit) {
		NonCashBenefitDTO nonCashBenefitDTO = new NonCashBenefitDTO();

		nonCashBenefitDTO.setNonCashBenefitId(tmpNonCashBenefit.getNonCashBenefitId().toString());
		nonCashBenefitDTO.setEnrollmentId(tmpNonCashBenefit.getEnrollmentId().toString());

		// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
		nonCashBenefitDTO.setInformationDate(tmpNonCashBenefit.getInformationDate());
		nonCashBenefitDTO.setBenefitsFromAnySource(YesNoReason.valueByCode(tmpNonCashBenefit.getBenefitsFromAnySource()));
		nonCashBenefitDTO.setSnap(YesNo.valueByCode(tmpNonCashBenefit.getSnap()));
		nonCashBenefitDTO.setWic(YesNo.valueByCode(tmpNonCashBenefit.getWic()));
		nonCashBenefitDTO.setTanfChildCare(YesNo.valueByCode(tmpNonCashBenefit.getTanfChildCare()));
		nonCashBenefitDTO.setTanfTransportation(YesNo.valueByCode(tmpNonCashBenefit.getTanfTransportation()));
		nonCashBenefitDTO.setOtherTanf(YesNo.valueByCode(tmpNonCashBenefit.getOtherTanf()));
		nonCashBenefitDTO.setRentalAssistanceOngoing(YesNo.valueByCode(tmpNonCashBenefit.getRentalAssistanceOngoing()));
		nonCashBenefitDTO.setOtherBenefitsSource(YesNo.valueByCode(tmpNonCashBenefit.getOtherBenefitsSource()));
		nonCashBenefitDTO.setRentalAssistanceTemp(YesNo.valueByCode(tmpNonCashBenefit.getRentalAssistanceTemp()));
		nonCashBenefitDTO.setOtherBenefitsSourceIdentify(tmpNonCashBenefit.getOtherBenefitsSourceIdentify());

		// Export Standard Fields
		nonCashBenefitDTO.setDateCreated(tmpNonCashBenefit.getDateCreated());
		nonCashBenefitDTO.setDateUpdated(tmpNonCashBenefit.getDateUpdated());
		
		return nonCashBenefitDTO;
	}
	
	public static TmpNonCashBenefit generateTmpNonCashBenefit(NonCashBenefitDTO inputDTO) {
		TmpNonCashBenefit tmpNonCashBenefit = new TmpNonCashBenefit();
		
		tmpNonCashBenefit.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
		tmpNonCashBenefit.setInformationDate(inputDTO.getInformationDate());
		tmpNonCashBenefit.setBenefitsFromAnySource(inputDTO.getBenefitsFromAnySource().getCode());
		tmpNonCashBenefit.setSnap(inputDTO.getSnap().getCode());
		tmpNonCashBenefit.setWic(inputDTO.getWic().getCode());
		tmpNonCashBenefit.setTanfChildCare(inputDTO.getTanfChildCare().getCode());
		tmpNonCashBenefit.setTanfTransportation(inputDTO.getTanfTransportation().getCode());
		tmpNonCashBenefit.setOtherTanf(inputDTO.getOtherTanf().getCode());
		tmpNonCashBenefit.setRentalAssistanceOngoing(inputDTO.getRentalAssistanceOngoing().getCode());
		tmpNonCashBenefit.setOtherBenefitsSource(inputDTO.getOtherBenefitsSource().getCode());
		tmpNonCashBenefit.setRentalAssistanceTemp(inputDTO.getRentalAssistanceTemp().getCode());
		tmpNonCashBenefit.setOtherBenefitsSourceIdentify(inputDTO.getOtherBenefitsSourceIdentify());

		// Export Standard Fields
		tmpNonCashBenefit.setDateCreated(inputDTO.getDateCreated());
		tmpNonCashBenefit.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpNonCashBenefit;
	}
	
}