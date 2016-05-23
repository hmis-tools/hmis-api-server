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
	private static final TmpHealthInsuranceDAO tmpHealthInsuranceDAO = new TmpHealthInsuranceDAO();

	public HealthInsuranceManager() {}

	public static HealthInsuranceDTO getHealthInsuranceById(String healthInsuranceId) {
		HealthInsuranceDTO healthInsuranceDTO = HealthInsuranceManager.generateHealthInsuranceDTO(tmpHealthInsuranceDAO.getTmpHealthInsuranceById(Integer.parseInt(healthInsuranceId)));
		return healthInsuranceDTO;
	}

	public static List<HealthInsuranceDTO> getHealthInsurances(HealthInsuranceSearchDTO searchDTO) {
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

	public static List<HealthInsuranceDTO> getHealthInsurances(Date updateDate) {
		List<HealthInsuranceDTO> healthInsuranceDTOs = new ArrayList<HealthInsuranceDTO>();

		// Collect the healthInsurances
		List<TmpHealthInsurance> tmpHealthInsurances = tmpHealthInsuranceDAO.getTmpHealthInsurances(updateDate);

		// For each healthInsurance, collect and map the data
		for (Iterator<TmpHealthInsurance> iterator = tmpHealthInsurances.iterator(); iterator.hasNext();) {
			TmpHealthInsurance tmpHealthInsurance = iterator.next();
			HealthInsuranceDTO healthInsuranceDTO = HealthInsuranceManager.generateHealthInsuranceDTO(tmpHealthInsurance);
			healthInsuranceDTOs.add(healthInsuranceDTO);
		}
		return healthInsuranceDTOs;

	}

	public static List<HealthInsuranceDTO> getHealthInsurancesByEnrollmentId(String enrollmentId) {
		List<HealthInsuranceDTO> healthInsuranceDTOs = new ArrayList<HealthInsuranceDTO>();

		// Collect the healthInsurances
		List<TmpHealthInsurance> tmpHealthInsurances = tmpHealthInsuranceDAO.getTmpHealthInsurancesByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each healthInsurance, collect and map the data
		for (Iterator<TmpHealthInsurance> iterator = tmpHealthInsurances.iterator(); iterator.hasNext();) {
			TmpHealthInsurance tmpHealthInsurance = iterator.next();
			HealthInsuranceDTO healthInsuranceDTO = HealthInsuranceManager.generateHealthInsuranceDTO(tmpHealthInsurance);
			healthInsuranceDTOs.add(healthInsuranceDTO);
		}
		return healthInsuranceDTOs;

	}

	public static List<HealthInsuranceDTO> getHealthInsurancesByEnrollmentId(String enrollmentId, Date updateDate) {
		List<HealthInsuranceDTO> healthInsuranceDTOs = new ArrayList<HealthInsuranceDTO>();

		// Collect the healthInsurances
		List<TmpHealthInsurance> tmpHealthInsurances = tmpHealthInsuranceDAO.getTmpHealthInsurancesByEnrollmentId(Integer.parseInt(enrollmentId), updateDate);

		// For each healthInsurance, collect and map the data
		for (Iterator<TmpHealthInsurance> iterator = tmpHealthInsurances.iterator(); iterator.hasNext();) {
			TmpHealthInsurance tmpHealthInsurance = iterator.next();
			HealthInsuranceDTO healthInsuranceDTO = HealthInsuranceManager.generateHealthInsuranceDTO(tmpHealthInsurance);
			healthInsuranceDTOs.add(healthInsuranceDTO);
		}
		return healthInsuranceDTOs;

	}
	
	public static HealthInsuranceDTO addHealthInsurance(HealthInsuranceDTO inputDTO) {
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
	
	public static HealthInsuranceDTO updateHealthInsurance(HealthInsuranceDTO inputDTO) {
		// Generate a HealthInsurance from the input
		TmpHealthInsurance tmpHealthInsurance = HealthInsuranceManager.generateTmpHealthInsurance(inputDTO);
		tmpHealthInsurance.setHealthInsuranceId(Integer.parseInt(inputDTO.getHealthInsuranceId()));
		tmpHealthInsurance.setDateUpdated(new Date());
		
		// Update the object
		tmpHealthInsuranceDAO.update(tmpHealthInsurance);
		
		// Return the resulting VO
		return HealthInsuranceManager.generateHealthInsuranceDTO(tmpHealthInsurance);

	}
	
	public static boolean deleteHealthInsurance(String healthInsuranceId) {
		TmpHealthInsurance tmpHealthInsurance = tmpHealthInsuranceDAO.getTmpHealthInsuranceById(Integer.parseInt(healthInsuranceId));
		tmpHealthInsuranceDAO.delete(tmpHealthInsurance);
		return true;
	}
	
	public static HealthInsuranceDTO generateHealthInsuranceDTO(TmpHealthInsurance tmpHealthInsurance) {
		HealthInsuranceDTO healthInsuranceDTO = new HealthInsuranceDTO();

		healthInsuranceDTO.setHealthInsuranceId(tmpHealthInsurance.getHealthInsuranceId().toString());
		healthInsuranceDTO.setEnrollmentId(tmpHealthInsurance.getEnrollmentId().toString());

		// Program Specific Data Standards: Health Insurance (2014, 4.4)
		healthInsuranceDTO.setInformationDate(tmpHealthInsurance.getInformationDate());
		healthInsuranceDTO.setInsuranceFromAnySource(YesNoReason.valueByCode(tmpHealthInsurance.getInsuranceFromAnySource()));
		healthInsuranceDTO.setMedicaid(YesNo.valueByCode(tmpHealthInsurance.getMedicaid()));
		healthInsuranceDTO.setNoMedicaidReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoMedicaidReason()));
		healthInsuranceDTO.setMedicare(YesNo.valueByCode(tmpHealthInsurance.getMedicare()));
		healthInsuranceDTO.setNoMedicareReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoMedicareReason()));
		healthInsuranceDTO.setSchip(YesNo.valueByCode(tmpHealthInsurance.getSchip()));
		healthInsuranceDTO.setNoSchipReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoSchipReason()));
		healthInsuranceDTO.setVaMedicalServices(YesNo.valueByCode(tmpHealthInsurance.getVaMedicalServices()));
		healthInsuranceDTO.setNoVaMedReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoVaMedReason()));
		healthInsuranceDTO.setEmployerProvided(YesNo.valueByCode(tmpHealthInsurance.getEmployerProvided()));
		healthInsuranceDTO.setNoEmployerProvidedReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoEmployerProvidedReason()));
		healthInsuranceDTO.setCobra(YesNo.valueByCode(tmpHealthInsurance.getCobra()));
		healthInsuranceDTO.setNoCobraReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoCobraReason()));
		healthInsuranceDTO.setPrivatePay(YesNo.valueByCode(tmpHealthInsurance.getPay()));
		healthInsuranceDTO.setNoPrivatePayReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoPayReason()));
		healthInsuranceDTO.setStateHealthIns(YesNo.valueByCode(tmpHealthInsurance.getStateHealthIns()));
		healthInsuranceDTO.setNoStateHealthInsReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoStateHealthInsReason()));

		// Export Standard Fields
		healthInsuranceDTO.setDateCreated(tmpHealthInsurance.getDateCreated());
		healthInsuranceDTO.setDateUpdated(tmpHealthInsurance.getDateUpdated());
		
		return healthInsuranceDTO;
	}
	
	public static TmpHealthInsurance generateTmpHealthInsurance(HealthInsuranceDTO inputDTO) {
		TmpHealthInsurance tmpHealthInsurance = new TmpHealthInsurance();
		
		tmpHealthInsurance.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));
		
		// Program Specific Data Standards: Health Insurance (2014, 4.4)
		tmpHealthInsurance.setInformationDate(inputDTO.getInformationDate());
		tmpHealthInsurance.setInsuranceFromAnySource(inputDTO.getInsuranceFromAnySource().getCode());
		tmpHealthInsurance.setMedicaid(inputDTO.getMedicaid().getCode());
		tmpHealthInsurance.setNoMedicaidReason(inputDTO.getNoMedicaidReason().getCode());
		tmpHealthInsurance.setMedicare(inputDTO.getMedicare().getCode());
		tmpHealthInsurance.setNoMedicareReason(inputDTO.getNoMedicareReason().getCode());
		tmpHealthInsurance.setSchip(inputDTO.getSchip().getCode());
		tmpHealthInsurance.setNoSchipReason(inputDTO.getNoSchipReason().getCode());
		tmpHealthInsurance.setVaMedicalServices(inputDTO.getVaMedicalServices().getCode());
		tmpHealthInsurance.setNoVaMedReason(inputDTO.getNoVaMedReason().getCode());
		tmpHealthInsurance.setEmployerProvided(inputDTO.getEmployerProvided().getCode());
		tmpHealthInsurance.setNoEmployerProvidedReason(inputDTO.getNoEmployerProvidedReason().getCode());
		tmpHealthInsurance.setNoCobraReason(inputDTO.getNoCobraReason().getCode());
		tmpHealthInsurance.setCobra(inputDTO.getCobra().getCode());
		tmpHealthInsurance.setPay(inputDTO.getPrivatePay().getCode());
		tmpHealthInsurance.setNoPayReason(inputDTO.getNoPrivatePayReason().getCode());
		tmpHealthInsurance.setStateHealthIns(inputDTO.getStateHealthIns().getCode());
		tmpHealthInsurance.setNoStateHealthInsReason(inputDTO.getNoStateHealthInsReason().getCode());

		// Export Standard Fields
		tmpHealthInsurance.setDateCreated(inputDTO.getDateCreated());
		tmpHealthInsurance.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpHealthInsurance;
	}
	
}
