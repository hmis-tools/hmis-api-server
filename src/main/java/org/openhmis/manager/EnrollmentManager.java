package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openhmis.code.ClientAddressDataQuality;
import org.openhmis.code.ClientCountExchangeForSex;
import org.openhmis.code.ClientDobDataQuality;
import org.openhmis.code.ClientEmploymentType;
import org.openhmis.code.ClientEthnicity;
import org.openhmis.code.ClientGender;
import org.openhmis.code.ClientHealthStatus;
import org.openhmis.code.ClientHousingStatus;
import org.openhmis.code.ClientIncarceratedParentStatus;
import org.openhmis.code.ClientLastGradeCompleted;
import org.openhmis.code.ClientMonthsHomelessPastThreeYears;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.code.ClientNotEmployedReason;
import org.openhmis.code.ClientPercentAmi;
import org.openhmis.code.ClientReasonNoServices;
import org.openhmis.code.ClientReasonNotEnrolled;
import org.openhmis.code.ClientReferralSource;
import org.openhmis.code.ClientRelationshipToHoH;
import org.openhmis.code.ClientResidencePrior;
import org.openhmis.code.ClientResidencePriorLengthOfStay;
import org.openhmis.code.ClientRhyNumberOfYears;
import org.openhmis.code.ClientSchoolStatus;
import org.openhmis.code.ClientSexualOrientation;
import org.openhmis.code.ClientSsnDataQuality;
import org.openhmis.code.ClientTimesHomelessPastThreeYears;
import org.openhmis.code.None;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.PathClientProgramDAO;
import org.openhmis.dao.TmpEnrollmentDAO;
import org.openhmis.domain.PathClientProgram;
import org.openhmis.domain.TmpEnrollment;
import org.openhmis.domain.TmpProjectInventory;
import org.openhmis.dto.ChronicHealthConditionDTO;
import org.openhmis.dto.search.ChronicHealthConditionSearchDTO;
import org.openhmis.dto.ClientDTO;
import org.openhmis.dto.ContactDTO;
import org.openhmis.dto.search.ContactSearchDTO;
import org.openhmis.dto.DevelopmentalDisabilityDTO;
import org.openhmis.dto.search.DevelopmentalDisabilitySearchDTO;
import org.openhmis.dto.DomesticAbuseDTO;
import org.openhmis.dto.search.DomesticAbuseSearchDTO;
import org.openhmis.dto.EnrollmentDTO;
import org.openhmis.dto.ExitDTO;
import org.openhmis.dto.FinancialAssistanceDTO;
import org.openhmis.dto.search.FinancialAssistanceSearchDTO;
import org.openhmis.dto.HealthInsuranceDTO;
import org.openhmis.dto.search.HealthInsuranceSearchDTO;
import org.openhmis.dto.HivAidsStatusDTO;
import org.openhmis.dto.search.HivAidsStatusSearchDTO;
import org.openhmis.dto.IncomeSourceDTO;
import org.openhmis.dto.search.IncomeSourceSearchDTO;
import org.openhmis.dto.InventoryDTO;
import org.openhmis.dto.MedicalAssistanceDTO;
import org.openhmis.dto.search.MedicalAssistanceSearchDTO;
import org.openhmis.dto.MentalHealthProblemDTO;
import org.openhmis.dto.NonCashBenefitDTO;
import org.openhmis.dto.search.NonCashBenefitSearchDTO;
import org.openhmis.dto.PhysicalDisabilityDTO;
import org.openhmis.dto.ReferralDTO;
import org.openhmis.dto.ServiceDTO;
import org.openhmis.dto.SubstanceAbuseDTO;
import org.openhmis.dto.search.EnrollmentSearchDTO;
import org.openhmis.dto.search.PhysicalDisabilitySearchDTO;
import org.openhmis.dto.search.ReferralSearchDTO;
import org.openhmis.dto.search.ServiceSearchDTO;
import org.openhmis.dto.search.SubstanceAbuseSearchDTO;

import org.openhmis.exception.InvalidParameterException;

public class EnrollmentManager {

	private TmpEnrollmentDAO tmpEnrollmentDAO;
	
	public EnrollmentManager() {
		this.tmpEnrollmentDAO = new TmpEnrollmentDAO();
	}

	public EnrollmentManager(TmpEnrollmentDAO tmpEnrollmentDAO) {
		this.tmpEnrollmentDAO = tmpEnrollmentDAO;
	}

	public EnrollmentDTO getEnrollmentById(String enrollmentId) {
		EnrollmentDTO enrollmentDTO = EnrollmentManager.generateEnrollmentDTO(tmpEnrollmentDAO.getTmpEnrollmentById(Integer.parseInt(enrollmentId)));
		return enrollmentDTO;
	}

	public List<EnrollmentDTO> getEnrollments(EnrollmentSearchDTO searchDTO) {
		List<EnrollmentDTO> enrollmentDTOs = new ArrayList<EnrollmentDTO>();

		// Collect the inventories
		List<TmpEnrollment> tempEnrollments = tmpEnrollmentDAO.getTmpEnrollments(searchDTO);

		// For each inventory, collect and map the data
		for (Iterator<TmpEnrollment> iterator = tempEnrollments.iterator(); iterator.hasNext();) {
			TmpEnrollment tempEnrollment = iterator.next();
			EnrollmentDTO enrollmentDTO = EnrollmentManager.generateEnrollmentDTO(tempEnrollment);
                        enrollmentDTOs.add(enrollmentDTO);
		}
		return enrollmentDTOs;
	}


	public List<EnrollmentDTO> getEnrollmentsByUpdateDate(Date updateDate) {
		List<EnrollmentDTO> enrollmentDTOs = new ArrayList<EnrollmentDTO>();

		// Collect the inventories
		List<TmpEnrollment> tempEnrollments = tmpEnrollmentDAO.getTmpEnrollmentsByUpdateDate(updateDate);

		// For each inventory, collect and map the data
		for (Iterator<TmpEnrollment> iterator = tempEnrollments.iterator(); iterator.hasNext();) {
			TmpEnrollment tempEnrollment = iterator.next();
			EnrollmentDTO enrollmentDTO = EnrollmentManager.generateEnrollmentDTO(tempEnrollment);
			enrollmentDTOs.add(enrollmentDTO);
		}
		return enrollmentDTOs;
	}
	
	public EnrollmentDTO addEnrollment(EnrollmentDTO inputDTO) {
		// Validate the enrollment
		// TODO: this should return a list of errors that get wrapped appropriately
		if(!validateEnrollment(inputDTO))
			return null;
		
		// Generate a PathClient from the input
		TmpEnrollment tmpEnrollment = EnrollmentManager.generateTmpEnrollment(inputDTO);
		
		// Set Export fields
		tmpEnrollment.setDateCreated(new Date());
		tmpEnrollment.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpEnrollmentDAO.save(tmpEnrollment);
		inputDTO.setEnrollmentId(tmpEnrollment.getEnrollmentId().toString());
		
		// Return the resulting VO
		return EnrollmentManager.generateEnrollmentDTO(tmpEnrollment);

	}
	
	public EnrollmentDTO updateEnrollment(EnrollmentDTO inputDTO) {
		// Generate a TmpProject from the input
		TmpEnrollment tmpEnrollment = EnrollmentManager.generateTmpEnrollment(inputDTO);
		
		// Validate the enrollment
		// TODO: this should return a list of errors that get wrapped appropriately
		if(!validateEnrollment(inputDTO))
			return null;
		
		tmpEnrollment.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));
		tmpEnrollment.setDateUpdated(new Date());
		
		// Update the client
		tmpEnrollmentDAO.update(tmpEnrollment);
		
		// Return the resulting VO
		return EnrollmentManager.generateEnrollmentDTO(tmpEnrollment);
		
	}
	
	public boolean deleteEnrollment(String enrollmentId) {
		TmpEnrollment tmpEnrollment = tmpEnrollmentDAO.getTmpEnrollmentById(Integer.parseInt(enrollmentId));
		tmpEnrollmentDAO.delete(tmpEnrollment);
		return true;
	}
	
	public boolean validateEnrollment(EnrollmentDTO inputDTO) {
		// Universal Data Standard: Name (2014, 3.1)

		// Universal Data Standard: Disabling Condition (2014, 3.8)
		if(inputDTO.getDisablingCondition() == YesNoReason.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.8.1 disablingCondition", "disablingCondition is set to an unknown code");

		// Universal Data Standard: Residence Prior to Project Entry (2014, 3.9)
		if(inputDTO.getResidencePrior() == ClientResidencePrior.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.9.1 residencePrior", "residencePrior is set to an unknown code");

		if(inputDTO.getResidencePriorLengthOfStay() == ClientResidencePriorLengthOfStay.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.9.3 residencePriorLengthOfStay", "residencePriorLengthOfStay is set to an unknown code");

		// Universal Data Standard: Project Entry Date (2014, 3.10)
		// TODO: check if there are any undocumented rules for entry date

		// Universal Data Standard: Household ID (2014, 3.14)
		// TODO: check if there are any undocumented rules for household ID

		// Universal Data Standard: Relationship to Head of Household (2014, 3.15)
		if(inputDTO.getRelationshipToHoH() == ClientRelationshipToHoH.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.15.1 relationshipToHoH", "relationshipToHoH is set to an unknown code");

		// Universal Data Standard: Client Location (2014, 3.16)
		// TODO: check if there are any undocumented rules for client location

		// Universal Data Standard: Length of Time on Street, in an Emergency Shelter, or Safe Haven (2014, 3.17)
		if(inputDTO.getContinuouslyHomelessOneYear() == YesNoReason.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.17.1 continuouslyHomelessOneYear", "continuouslyHomelessOneYear is set to an unknown code");

		if(inputDTO.getTimesHomelessInPastThreeYears() == ClientTimesHomelessPastThreeYears.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.17.2 timesHomelessInPastThreeYears", "timesHomelessInPastThreeYears is set to an unknown code");

		if(inputDTO.getMonthsHomelessPastThreeYears() == ClientMonthsHomelessPastThreeYears.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 3.17.A monthsHomelessPastThreeYears", "monthsHomelessPastThreeYears is set to an unknown code");

		if(inputDTO.getMonthsHomelessThisTime() > 999)
			throw new InvalidParameterException("HUD 3.17.? monthsHomelessThisTime", "monthsHomelessThisTime must be less than three digits");

		if(inputDTO.getMonthsHomelessThisTime() < 0)
			throw new InvalidParameterException("HUD 3.17.? monthsHomelessThisTime", "monthsHomelessThisTime cannot be negative");

		if(inputDTO.getStatusDocumentedCode() == YesNo.ERR_UNKNOWN)
			throw new InvalidParameterException("HUD 1.7 statusDocumented", "statusDocumented is set to an unknown code");

		// TODO: validate 4.* fields
		
		return true;
	}	
}
