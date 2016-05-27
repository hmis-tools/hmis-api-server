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
	private static final TmpFinancialAssistanceDAO tmpFinancialAssistanceDAO = new TmpFinancialAssistanceDAO();

	public FinancialAssistanceManager() {}

	public static FinancialAssistanceDTO getFinancialAssistanceById(String financialAssistanceId) {
		FinancialAssistanceDTO financialAssistanceDTO = FinancialAssistanceManager.generateFinancialAssistanceDTO(tmpFinancialAssistanceDAO.getTmpFinancialAssistanceById(Integer.parseInt(financialAssistanceId)));
		return financialAssistanceDTO;
	}

	public static List<FinancialAssistanceDTO> getFinancialAssistances(FinancialAssistanceSearchDTO searchDTO) {
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

	
	public static FinancialAssistanceDTO addFinancialAssistance(FinancialAssistanceDTO inputDTO) {
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
	
	public static FinancialAssistanceDTO updateFinancialAssistance(FinancialAssistanceDTO inputDTO) {
		// Generate a FinancialAssistance from the input
		TmpFinancialAssistance tmpFinancialAssistance = FinancialAssistanceManager.generateTmpFinancialAssistance(inputDTO);
		tmpFinancialAssistance.setFinancialAssistanceId(Integer.parseInt(inputDTO.getFinancialAssistanceId()));
		tmpFinancialAssistance.setDateUpdated(new Date());
		
		// Update the object
		tmpFinancialAssistanceDAO.update(tmpFinancialAssistance);
		
		// Return the resulting VO
		return FinancialAssistanceManager.generateFinancialAssistanceDTO(tmpFinancialAssistance);

	}
	
	public static boolean deleteFinancialAssistance(String financialAssistanceId) {
		TmpFinancialAssistance tmpFinancialAssistance = tmpFinancialAssistanceDAO.getTmpFinancialAssistanceById(Integer.parseInt(financialAssistanceId));
		tmpFinancialAssistanceDAO.delete(tmpFinancialAssistance);
		return true;
	}
	
	public static boolean validateFinancialAssistance(FinancialAssistanceDTO inputDTO) {
		return true;
	}
	
	public static FinancialAssistanceDTO generateFinancialAssistanceDTO(TmpFinancialAssistance tmpFinancialAssistance) {
		FinancialAssistanceDTO financialAssistanceDTO = new FinancialAssistanceDTO();

		financialAssistanceDTO.setFinancialAssistanceId(tmpFinancialAssistance.getFinancialAssistanceId().toString());
		financialAssistanceDTO.setEnrollmentId(tmpFinancialAssistance.getEnrollmentId().toString());

		// HOPWA (2014, 4.15A)
		financialAssistanceDTO.setHopwaTypeProvided(ClientHopwaFinancialAssistance.valueByCode(tmpFinancialAssistance.getHopwaTypeProvided()));
		financialAssistanceDTO.setHopwaFaaAmount(tmpFinancialAssistance.getHopwaFaaAmount().longValue());

		// SSVF (2014, 4.15B)
		financialAssistanceDTO.setSsvfTypeProvided(ClientSsvfFinancialAssistance.valueByCode(tmpFinancialAssistance.getSsvfTypeProvided()));
		financialAssistanceDTO.setSsvfFaaAmount(tmpFinancialAssistance.getSsvfFaaAmount().longValue());

		// Export Standard Fields
		financialAssistanceDTO.setDateCreated(tmpFinancialAssistance.getDateCreated());
		financialAssistanceDTO.setDateUpdated(tmpFinancialAssistance.getDateUpdated());
		
		return financialAssistanceDTO;
	}
	
	public static TmpFinancialAssistance generateTmpFinancialAssistance(FinancialAssistanceDTO inputDTO) {
		TmpFinancialAssistance tmpFinancialAssistance = new TmpFinancialAssistance();
		
		tmpFinancialAssistance.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));
		// HOPWA (2014, 4.15A)
		tmpFinancialAssistance.setHopwaTypeProvided(inputDTO.getHopwaTypeProvided().getCode());
		tmpFinancialAssistance.setHopwaFaaAmount(inputDTO.getHopwaFaaAmount().intValue());

		// SSVF (2014, 4.15B)
		tmpFinancialAssistance.setSsvfTypeProvided(inputDTO.getSsvfTypeProvided().getCode());
		tmpFinancialAssistance.setSsvfFaaAmount(inputDTO.getSsvfFaaAmount().intValue());

		// Export Standard Fields
		tmpFinancialAssistance.setDateCreated(inputDTO.getDateCreated());
		tmpFinancialAssistance.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpFinancialAssistance;
	}
	
}
