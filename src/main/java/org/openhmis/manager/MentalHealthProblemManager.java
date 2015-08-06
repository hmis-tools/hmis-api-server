package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientPathHowConfirmed;
import org.openhmis.code.ClientPathSmiInformation;
import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.TmpMentalHealthProblemDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpMentalHealthProblem;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.MentalHealthProblemDTO;

public class MentalHealthProblemManager {
	private static final TmpMentalHealthProblemDAO tmpMentalHealthProblemDAO = new TmpMentalHealthProblemDAO();

	public MentalHealthProblemManager() {}

	public static MentalHealthProblemDTO getMentalHealthProblemById(String mentalHealthProblemId) {
		MentalHealthProblemDTO mentalHealthProblemDTO = MentalHealthProblemManager.generateMentalHealthProblemDTO(tmpMentalHealthProblemDAO.getTmpMentalHealthProblemById(Integer.parseInt(mentalHealthProblemId)));
		return mentalHealthProblemDTO;
	}

	public static List<MentalHealthProblemDTO> getMentalHealthProblemsByEnrollmentId(String enrollmentId) {
		List<MentalHealthProblemDTO> mentalHealthProblemDTOs = new ArrayList<MentalHealthProblemDTO>();

		// Collect the mentalHealthProblems
		List<TmpMentalHealthProblem> tmpMentalHealthProblems = tmpMentalHealthProblemDAO.getTmpMentalHealthProblemsByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each mentalHealthProblem, collect and map the data
		for (Iterator<TmpMentalHealthProblem> iterator = tmpMentalHealthProblems.iterator(); iterator.hasNext();) {
			TmpMentalHealthProblem tmpMentalHealthProblem = iterator.next();
			MentalHealthProblemDTO mentalHealthProblemDTO = MentalHealthProblemManager.generateMentalHealthProblemDTO(tmpMentalHealthProblem);
			mentalHealthProblemDTOs.add(mentalHealthProblemDTO);
		}
		return mentalHealthProblemDTOs;

	}
	
	public static MentalHealthProblemDTO addMentalHealthProblem(MentalHealthProblemDTO inputDTO) {
		// Generate a PathClient from the input
		TmpMentalHealthProblem tmpMentalHealthProblem = MentalHealthProblemManager.generateTmpMentalHealthProblem(inputDTO);
		
		// Set Export fields
		tmpMentalHealthProblem.setDateCreated(new Date());
		tmpMentalHealthProblem.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpMentalHealthProblemDAO.save(tmpMentalHealthProblem);
		inputDTO.setMentalHealthProblemId(tmpMentalHealthProblem.getMentalHealthProblemId().toString());
		
		// Return the resulting VO
		return MentalHealthProblemManager.generateMentalHealthProblemDTO(tmpMentalHealthProblem);
	}
	
	public static MentalHealthProblemDTO updateMentalHealthProblem(MentalHealthProblemDTO inputDTO) {
		// Generate a MentalHealthProblem from the input
		TmpMentalHealthProblem tmpMentalHealthProblem = MentalHealthProblemManager.generateTmpMentalHealthProblem(inputDTO);
		tmpMentalHealthProblem.setMentalHealthProblemId(Integer.parseInt(inputDTO.getMentalHealthProblemId()));
		tmpMentalHealthProblem.setDateUpdated(new Date());
		
		// Update the object
		tmpMentalHealthProblemDAO.update(tmpMentalHealthProblem);
		
		// Return the resulting VO
		return MentalHealthProblemManager.generateMentalHealthProblemDTO(tmpMentalHealthProblem);

	}
	
	public static boolean deleteMentalHealthProblem(String mentalHealthProblemId) {
		TmpMentalHealthProblem tmpMentalHealthProblem = tmpMentalHealthProblemDAO.getTmpMentalHealthProblemById(Integer.parseInt(mentalHealthProblemId));
		tmpMentalHealthProblemDAO.delete(tmpMentalHealthProblem);
		return true;
	}
	
	public static MentalHealthProblemDTO generateMentalHealthProblemDTO(TmpMentalHealthProblem tmpMentalHealthProblem) {
		MentalHealthProblemDTO mentalHealthProblemDTO = new MentalHealthProblemDTO();

		mentalHealthProblemDTO.setMentalHealthProblemId(tmpMentalHealthProblem.getMentalHealthProblemId().toString());
		mentalHealthProblemDTO.setEnrollmentId(tmpMentalHealthProblem.getEnrollmentId().toString());

		// Program Specific Data Standards: Mental Health Problem (2014, 4.9)
		mentalHealthProblemDTO.setInformationDate(tmpMentalHealthProblem.getInformationDate());
		mentalHealthProblemDTO.setResponse(YesNoReason.valueByCode(tmpMentalHealthProblem.getResponse()));
		mentalHealthProblemDTO.setIndefiniteAndImpairs(YesNoReason.valueByCode(tmpMentalHealthProblem.getIndefiniteAndImpairs()));
		mentalHealthProblemDTO.setDocumentationOnFile(YesNo.valueByCode(tmpMentalHealthProblem.getDocumentationOnFile()));
		mentalHealthProblemDTO.setReceivingServices(YesNoReason.valueByCode(tmpMentalHealthProblem.getReceivingServices()));
		mentalHealthProblemDTO.setPathHowConfirmed(ClientPathHowConfirmed.valueByCode(tmpMentalHealthProblem.getPathHowConfirmed()));
		mentalHealthProblemDTO.setPathSmiInformation(ClientPathSmiInformation.valueByCode(tmpMentalHealthProblem.getPathSmiInformation()));

		// Export Standard Fields
		mentalHealthProblemDTO.setDateCreated(tmpMentalHealthProblem.getDateCreated());
		mentalHealthProblemDTO.setDateUpdated(tmpMentalHealthProblem.getDateUpdated());
		
		return mentalHealthProblemDTO;
	}
	
	public static TmpMentalHealthProblem generateTmpMentalHealthProblem(MentalHealthProblemDTO inputDTO) {
		TmpMentalHealthProblem tmpMentalHealthProblem = new TmpMentalHealthProblem();
		
		tmpMentalHealthProblem.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Mental Health Problem (2014, 4.9)
		tmpMentalHealthProblem.setInformationDate(inputDTO.getInformationDate());
		tmpMentalHealthProblem.setResponse(inputDTO.getResponse().getCode());
		tmpMentalHealthProblem.setIndefiniteAndImpairs(inputDTO.getIndefiniteAndImpairs().getCode());
		tmpMentalHealthProblem.setDocumentationOnFile(inputDTO.getDocumentationOnFile().getCode());
		tmpMentalHealthProblem.setReceivingServices(inputDTO.getReceivingServices().getCode());
		tmpMentalHealthProblem.setPathHowConfirmed(inputDTO.getPathHowConfirmed().getCode());
		tmpMentalHealthProblem.setPathSmiInformation(inputDTO.getPathSmiInformation().getCode());

		// Export Standard Fields
		tmpMentalHealthProblem.setDateCreated(inputDTO.getDateCreated());
		tmpMentalHealthProblem.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpMentalHealthProblem;
	}
	
}