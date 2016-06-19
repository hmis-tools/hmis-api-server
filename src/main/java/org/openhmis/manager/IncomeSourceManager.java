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
import org.openhmis.dao.TmpIncomeSourceDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpIncomeSource;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.IncomeSourceDTO;

public class IncomeSourceManager {
	private TmpIncomeSourceDAO tmpIncomeSourceDAO;

	public IncomeSourceManager() {
		this.tmpIncomeSourceDAO = new TmpIncomeSourceDAO();
	}
	
	public IncomeSourceManager(TmpIncomeSourceDAO tmpIncomeSourceDAO) {
		this.tmpIncomeSourceDAO = new TmpIncomeSourceDAO();
	}

	public IncomeSourceDTO getIncomeSourceById(String incomeSourceId) {
		IncomeSourceDTO incomeSourceDTO = IncomeSourceManager.generateIncomeSourceDTO(tmpIncomeSourceDAO.getTmpIncomeSourceById(Integer.parseInt(incomeSourceId)));
		return incomeSourceDTO;
	}

	public List<IncomeSourceDTO> getIncomeSources() {
		List<IncomeSourceDTO> incomeSourceDTOs = new ArrayList<IncomeSourceDTO>();

		// Collect the incomeSources
		List<TmpIncomeSource> tmpIncomeSources = tmpIncomeSourceDAO.getTmpIncomeSources();

		// For each incomeSource, collect and map the data
		for (Iterator<TmpIncomeSource> iterator = tmpIncomeSources.iterator(); iterator.hasNext();) {
			TmpIncomeSource tmpIncomeSource = iterator.next();
			IncomeSourceDTO incomeSourceDTO = IncomeSourceManager.generateIncomeSourceDTO(tmpIncomeSource);
			incomeSourceDTOs.add(incomeSourceDTO);
		}
		return incomeSourceDTOs;

	}

	public List<IncomeSourceDTO> getIncomeSources(Date updateDate) {
		List<IncomeSourceDTO> incomeSourceDTOs = new ArrayList<IncomeSourceDTO>();

		// Collect the incomeSources
		List<TmpIncomeSource> tmpIncomeSources = tmpIncomeSourceDAO.getTmpIncomeSources(updateDate);

		// For each incomeSource, collect and map the data
		for (Iterator<TmpIncomeSource> iterator = tmpIncomeSources.iterator(); iterator.hasNext();) {
			TmpIncomeSource tmpIncomeSource = iterator.next();
			IncomeSourceDTO incomeSourceDTO = IncomeSourceManager.generateIncomeSourceDTO(tmpIncomeSource);
			incomeSourceDTOs.add(incomeSourceDTO);
		}
		return incomeSourceDTOs;

	}

	public List<IncomeSourceDTO> getIncomeSourcesByEnrollmentId(String enrollmentId) {
		List<IncomeSourceDTO> incomeSourceDTOs = new ArrayList<IncomeSourceDTO>();

		// Collect the incomeSources
		List<TmpIncomeSource> tmpIncomeSources = tmpIncomeSourceDAO.getTmpIncomeSourcesByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each incomeSource, collect and map the data
		for (Iterator<TmpIncomeSource> iterator = tmpIncomeSources.iterator(); iterator.hasNext();) {
			TmpIncomeSource tmpIncomeSource = iterator.next();
			IncomeSourceDTO incomeSourceDTO = IncomeSourceManager.generateIncomeSourceDTO(tmpIncomeSource);
			incomeSourceDTOs.add(incomeSourceDTO);
		}
		return incomeSourceDTOs;

	}

	public List<IncomeSourceDTO> getIncomeSourcesByEnrollmentId(String enrollmentId, Date updateDate) {
		List<IncomeSourceDTO> incomeSourceDTOs = new ArrayList<IncomeSourceDTO>();

		// Collect the incomeSources
		List<TmpIncomeSource> tmpIncomeSources = tmpIncomeSourceDAO.getTmpIncomeSourcesByEnrollmentId(Integer.parseInt(enrollmentId), updateDate);

		// For each incomeSource, collect and map the data
		for (Iterator<TmpIncomeSource> iterator = tmpIncomeSources.iterator(); iterator.hasNext();) {
			TmpIncomeSource tmpIncomeSource = iterator.next();
			IncomeSourceDTO incomeSourceDTO = IncomeSourceManager.generateIncomeSourceDTO(tmpIncomeSource);
			incomeSourceDTOs.add(incomeSourceDTO);
		}
		return incomeSourceDTOs;

	}
	
	public IncomeSourceDTO addIncomeSource(IncomeSourceDTO inputDTO) {
		// Generate a PathClient from the input
		TmpIncomeSource tmpIncomeSource = IncomeSourceManager.generateTmpIncomeSource(inputDTO);
		
		// Set Export fields
		tmpIncomeSource.setDateCreated(new Date());
		tmpIncomeSource.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpIncomeSourceDAO.save(tmpIncomeSource);
		inputDTO.setIncomeSourceId(tmpIncomeSource.getIncomeSourceId().toString());
		
		// Return the resulting VO
		return IncomeSourceManager.generateIncomeSourceDTO(tmpIncomeSource);
	}
	
	public IncomeSourceDTO updateIncomeSource(IncomeSourceDTO inputDTO) {
		// Generate a IncomeSource from the input
		TmpIncomeSource tmpIncomeSource = IncomeSourceManager.generateTmpIncomeSource(inputDTO);
		tmpIncomeSource.setIncomeSourceId(Integer.parseInt(inputDTO.getIncomeSourceId()));
		tmpIncomeSource.setDateUpdated(new Date());
		
		// Update the object
		tmpIncomeSourceDAO.update(tmpIncomeSource);
		
		// Return the resulting VO
		return IncomeSourceManager.generateIncomeSourceDTO(tmpIncomeSource);

	}
	
	public boolean deleteIncomeSource(String incomeSourceId) {
		TmpIncomeSource tmpIncomeSource = tmpIncomeSourceDAO.getTmpIncomeSourceById(Integer.parseInt(incomeSourceId));
		tmpIncomeSourceDAO.delete(tmpIncomeSource);
		return true;
	}
	
	public static IncomeSourceDTO generateIncomeSourceDTO(TmpIncomeSource tmpIncomeSource) {
		IncomeSourceDTO incomeSourceDTO = new IncomeSourceDTO();

		incomeSourceDTO.setIncomeSourceId(tmpIncomeSource.getIncomeSourceId().toString());
		incomeSourceDTO.setEnrollmentId(tmpIncomeSource.getEnrollmentId().toString());

		// Program Specific Data Standards: Income Sources (2014, 4.2)
		incomeSourceDTO.setInformationDate(tmpIncomeSource.getInformationDate());
		incomeSourceDTO.setIncomeFromAnySourceCode(YesNoReason.valueByCode(tmpIncomeSource.getIncomeFromAnySourceCode()));
		incomeSourceDTO.setTotalMonthlyIncome(tmpIncomeSource.getTotalMonthlyIncome().doubleValue());
		incomeSourceDTO.setEarned(YesNo.valueByCode(tmpIncomeSource.getEarned()));
		incomeSourceDTO.setEarnedAmount(tmpIncomeSource.getEarnedAmount().doubleValue());
		incomeSourceDTO.setUnemployment(YesNo.valueByCode(tmpIncomeSource.getUnemployment()));
		incomeSourceDTO.setUnemploymentAmount(tmpIncomeSource.getUnemploymentAmount().doubleValue());
		incomeSourceDTO.setSsi(YesNo.valueByCode(tmpIncomeSource.getSsi()));
		incomeSourceDTO.setSsiAmount(tmpIncomeSource.getSsiAmount().doubleValue());
		incomeSourceDTO.setSsdi(YesNo.valueByCode(tmpIncomeSource.getSsdi()));
		incomeSourceDTO.setSsdiAmount(tmpIncomeSource.getSsdiAmount().doubleValue());
		incomeSourceDTO.setVaDisabilityService(YesNo.valueByCode(tmpIncomeSource.getVaDisabilityService()));
		incomeSourceDTO.setVaDisabilityServiceAmount(tmpIncomeSource.getVaDisabilityServiceAmount().doubleValue());
		incomeSourceDTO.setVaDisabilityNonService(YesNo.valueByCode(tmpIncomeSource.getVaDisabilityNonService()));
		incomeSourceDTO.setVaDisabilityNonServiceAmount(tmpIncomeSource.getVaDisabilityNonServiceAmount().doubleValue());
		incomeSourceDTO.setPrivateDisability(YesNo.valueByCode(tmpIncomeSource.getDisability()));
		incomeSourceDTO.setPrivateDisabilityAmount(tmpIncomeSource.getDisabilityAmount().doubleValue());
		incomeSourceDTO.setWorkerscomp(YesNo.valueByCode(tmpIncomeSource.getWorkerscomp()));
		incomeSourceDTO.setWorkersCompAmount(tmpIncomeSource.getWorkersCompAmount().doubleValue());
		incomeSourceDTO.setTanf(YesNo.valueByCode(tmpIncomeSource.getTanf()));
		incomeSourceDTO.setTanfAmount(tmpIncomeSource.getTanfAmount().doubleValue());
		incomeSourceDTO.setGa(YesNo.valueByCode(tmpIncomeSource.getGa()));
		incomeSourceDTO.setGaAmount(tmpIncomeSource.getGaAmount().doubleValue());
		incomeSourceDTO.setSocSecRetirement(YesNo.valueByCode(tmpIncomeSource.getSocSecRetirement()));
		incomeSourceDTO.setSocSecRetirementAmount(tmpIncomeSource.getSocSecRetirementAmount().doubleValue());
		incomeSourceDTO.setPension(YesNo.valueByCode(tmpIncomeSource.getPension()));
		incomeSourceDTO.setPensionAmount(tmpIncomeSource.getPensionAmount().doubleValue());
		incomeSourceDTO.setChildSupport(YesNo.valueByCode(tmpIncomeSource.getChildSupport()));
		incomeSourceDTO.setChildSupportAmount(tmpIncomeSource.getChildSupportAmount().doubleValue());
		incomeSourceDTO.setAlimony(YesNo.valueByCode(tmpIncomeSource.getAlimony()));
		incomeSourceDTO.setAlimonyAmount(tmpIncomeSource.getAlimonyAmount().doubleValue());
		incomeSourceDTO.setOtherIncomeSource(YesNo.valueByCode(tmpIncomeSource.getOtherIncomeSource()));
		incomeSourceDTO.setOtherIncomeAmount(tmpIncomeSource.getOtherIncomeAmount().doubleValue());

		// Export Standard Fields
		incomeSourceDTO.setDateCreated(tmpIncomeSource.getDateCreated());
		incomeSourceDTO.setDateUpdated(tmpIncomeSource.getDateUpdated());
		
		return incomeSourceDTO;
	}
	
	public static TmpIncomeSource generateTmpIncomeSource(IncomeSourceDTO inputDTO) {
		TmpIncomeSource tmpIncomeSource = new TmpIncomeSource();
		
		tmpIncomeSource.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));
		// Program Specific Data Standards: Income Sources (2014, 4.2)
		tmpIncomeSource.setInformationDate(inputDTO.getInformationDate());
		tmpIncomeSource.setIncomeFromAnySourceCode(inputDTO.getIncomeFromAnySourceCode().getCode());
		tmpIncomeSource.setTotalMonthlyIncome(inputDTO.getTotalMonthlyIncome().intValue());
		tmpIncomeSource.setEarned(inputDTO.getEarned().getCode());
		tmpIncomeSource.setEarnedAmount(inputDTO.getEarnedAmount().intValue());
		tmpIncomeSource.setUnemployment(inputDTO.getUnemployment().getCode());
		tmpIncomeSource.setUnemploymentAmount(inputDTO.getUnemploymentAmount().intValue());
		tmpIncomeSource.setSsi(inputDTO.getSsi().getCode());
		tmpIncomeSource.setSsiAmount(inputDTO.getSsiAmount().intValue());
		tmpIncomeSource.setSsdi(inputDTO.getSsdi().getCode());
		tmpIncomeSource.setSsdiAmount(inputDTO.getSsdiAmount().intValue());
		tmpIncomeSource.setVaDisabilityService(inputDTO.getVaDisabilityService().getCode());
		tmpIncomeSource.setVaDisabilityServiceAmount(inputDTO.getVaDisabilityServiceAmount().intValue());
		tmpIncomeSource.setVaDisabilityNonService(inputDTO.getVaDisabilityNonService().getCode());
		tmpIncomeSource.setVaDisabilityNonServiceAmount(inputDTO.getVaDisabilityNonServiceAmount().intValue());
		tmpIncomeSource.setDisability(inputDTO.getPrivateDisability().getCode());
		tmpIncomeSource.setDisabilityAmount(inputDTO.getPrivateDisabilityAmount().intValue());
		tmpIncomeSource.setWorkerscomp(inputDTO.getWorkerscomp().getCode());
		tmpIncomeSource.setWorkersCompAmount(inputDTO.getWorkersCompAmount().intValue());
		tmpIncomeSource.setTanf(inputDTO.getTanf().getCode());
		tmpIncomeSource.setTanfAmount(inputDTO.getTanfAmount().intValue());
		tmpIncomeSource.setGa(inputDTO.getGa().getCode());
		tmpIncomeSource.setGaAmount(inputDTO.getGaAmount().intValue());
		tmpIncomeSource.setSocSecRetirement(inputDTO.getSocSecRetirement().getCode());
		tmpIncomeSource.setSocSecRetirementAmount(inputDTO.getSocSecRetirementAmount().intValue());
		tmpIncomeSource.setPension(inputDTO.getPension().getCode());
		tmpIncomeSource.setPensionAmount(inputDTO.getPensionAmount().intValue());
		tmpIncomeSource.setChildSupport(inputDTO.getChildSupport().getCode());
		tmpIncomeSource.setChildSupportAmount(inputDTO.getChildSupportAmount().intValue());
		tmpIncomeSource.setAlimony(inputDTO.getAlimony().getCode());
		tmpIncomeSource.setAlimonyAmount(inputDTO.getAlimonyAmount().intValue());
		tmpIncomeSource.setOtherIncomeSource(inputDTO.getOtherIncomeSource().getCode());
		tmpIncomeSource.setOtherIncomeAmount(inputDTO.getOtherIncomeAmount().intValue());

		// Export Standard Fields
		tmpIncomeSource.setDateCreated(inputDTO.getDateCreated());
		tmpIncomeSource.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpIncomeSource;
	}
	
}