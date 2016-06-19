package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientDisabilityResponse;
import org.openhmis.code.ClientPathHowConfirmed;
import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.code.YesNo;
import org.openhmis.code.YesNoReason;
import org.openhmis.dao.TmpSubstanceAbuseDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpSubstanceAbuse;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.SubstanceAbuseDTO;

public class SubstanceAbuseManager {
	private TmpSubstanceAbuseDAO tmpSubstanceAbuseDAO = new TmpSubstanceAbuseDAO();

	public SubstanceAbuseManager() {
		this.tmpSubstanceAbuseDAO = new TmpSubstanceAbuseDAO();
	}

	public SubstanceAbuseManager(TmpSubstanceAbuseDAO tmpSubstanceAbuseDAO) {
		this.tmpSubstanceAbuseDAO = tmpSubstanceAbuseDAO;
	}

	public SubstanceAbuseDTO getSubstanceAbuseById(String substanceAbuseId) {
		SubstanceAbuseDTO substanceAbuseDTO = SubstanceAbuseManager.generateSubstanceAbuseDTO(tmpSubstanceAbuseDAO.getTmpSubstanceAbuseById(Integer.parseInt(substanceAbuseId)));
		return substanceAbuseDTO;
	}

	public List<SubstanceAbuseDTO> getSubstanceAbuses() {
		List<SubstanceAbuseDTO> substanceAbuseDTOs = new ArrayList<SubstanceAbuseDTO>();

		// Collect the substanceAbuses
		List<TmpSubstanceAbuse> tmpSubstanceAbuses = tmpSubstanceAbuseDAO.getTmpSubstanceAbuses();

		// For each substanceAbuse, collect and map the data
		for (Iterator<TmpSubstanceAbuse> iterator = tmpSubstanceAbuses.iterator(); iterator.hasNext();) {
			TmpSubstanceAbuse tmpSubstanceAbuse = iterator.next();
			SubstanceAbuseDTO substanceAbuseDTO = SubstanceAbuseManager.generateSubstanceAbuseDTO(tmpSubstanceAbuse);
			substanceAbuseDTOs.add(substanceAbuseDTO);
		}
		return substanceAbuseDTOs;

	}

	public List<SubstanceAbuseDTO> getSubstanceAbuses(Date updateDate) {
		List<SubstanceAbuseDTO> substanceAbuseDTOs = new ArrayList<SubstanceAbuseDTO>();

		// Collect the substanceAbuses
		List<TmpSubstanceAbuse> tmpSubstanceAbuses = tmpSubstanceAbuseDAO.getTmpSubstanceAbuses(updateDate);

		// For each substanceAbuse, collect and map the data
		for (Iterator<TmpSubstanceAbuse> iterator = tmpSubstanceAbuses.iterator(); iterator.hasNext();) {
			TmpSubstanceAbuse tmpSubstanceAbuse = iterator.next();
			SubstanceAbuseDTO substanceAbuseDTO = SubstanceAbuseManager.generateSubstanceAbuseDTO(tmpSubstanceAbuse);
			substanceAbuseDTOs.add(substanceAbuseDTO);
		}
		return substanceAbuseDTOs;

	}

	public List<SubstanceAbuseDTO> getSubstanceAbusesByEnrollmentId(String enrollmentId) {
		List<SubstanceAbuseDTO> substanceAbuseDTOs = new ArrayList<SubstanceAbuseDTO>();

		// Collect the substanceAbuses
		List<TmpSubstanceAbuse> tmpSubstanceAbuses = tmpSubstanceAbuseDAO.getTmpSubstanceAbusesByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each substanceAbuse, collect and map the data
		for (Iterator<TmpSubstanceAbuse> iterator = tmpSubstanceAbuses.iterator(); iterator.hasNext();) {
			TmpSubstanceAbuse tmpSubstanceAbuse = iterator.next();
			SubstanceAbuseDTO substanceAbuseDTO = SubstanceAbuseManager.generateSubstanceAbuseDTO(tmpSubstanceAbuse);
			substanceAbuseDTOs.add(substanceAbuseDTO);
		}
		return substanceAbuseDTOs;

	}

	public List<SubstanceAbuseDTO> getSubstanceAbusesByEnrollmentId(String enrollmentId, Date updateDate) {
		List<SubstanceAbuseDTO> substanceAbuseDTOs = new ArrayList<SubstanceAbuseDTO>();

		// Collect the substanceAbuses
		List<TmpSubstanceAbuse> tmpSubstanceAbuses = tmpSubstanceAbuseDAO.getTmpSubstanceAbusesByEnrollmentId(Integer.parseInt(enrollmentId), updateDate);

		// For each substanceAbuse, collect and map the data
		for (Iterator<TmpSubstanceAbuse> iterator = tmpSubstanceAbuses.iterator(); iterator.hasNext();) {
			TmpSubstanceAbuse tmpSubstanceAbuse = iterator.next();
			SubstanceAbuseDTO substanceAbuseDTO = SubstanceAbuseManager.generateSubstanceAbuseDTO(tmpSubstanceAbuse);
			substanceAbuseDTOs.add(substanceAbuseDTO);
		}
		return substanceAbuseDTOs;

	}
	
	public SubstanceAbuseDTO addSubstanceAbuse(SubstanceAbuseDTO inputDTO) {
		// Generate a PathClient from the input
		TmpSubstanceAbuse tmpSubstanceAbuse = SubstanceAbuseManager.generateTmpSubstanceAbuse(inputDTO);
		
		// Set Export fields
		tmpSubstanceAbuse.setDateCreated(new Date());
		tmpSubstanceAbuse.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpSubstanceAbuseDAO.save(tmpSubstanceAbuse);
		inputDTO.setSubstanceAbuseId(tmpSubstanceAbuse.getSubstanceAbuseId().toString());
		
		// Return the resulting VO
		return SubstanceAbuseManager.generateSubstanceAbuseDTO(tmpSubstanceAbuse);
	}
	
	public SubstanceAbuseDTO updateSubstanceAbuse(SubstanceAbuseDTO inputDTO) {
		// Generate a SubstanceAbuse from the input
		TmpSubstanceAbuse tmpSubstanceAbuse = SubstanceAbuseManager.generateTmpSubstanceAbuse(inputDTO);
		tmpSubstanceAbuse.setSubstanceAbuseId(Integer.parseInt(inputDTO.getSubstanceAbuseId()));
		tmpSubstanceAbuse.setDateUpdated(new Date());
		
		// Update the object
		tmpSubstanceAbuseDAO.update(tmpSubstanceAbuse);
		
		// Return the resulting VO
		return SubstanceAbuseManager.generateSubstanceAbuseDTO(tmpSubstanceAbuse);

	}
	
	public boolean deleteSubstanceAbuse(String substanceAbuseId) {
		TmpSubstanceAbuse tmpSubstanceAbuse = tmpSubstanceAbuseDAO.getTmpSubstanceAbuseById(Integer.parseInt(substanceAbuseId));
		tmpSubstanceAbuseDAO.delete(tmpSubstanceAbuse);
		return true;
	}
	
	public static SubstanceAbuseDTO generateSubstanceAbuseDTO(TmpSubstanceAbuse tmpSubstanceAbuse) {
		SubstanceAbuseDTO substanceAbuseDTO = new SubstanceAbuseDTO();

		substanceAbuseDTO.setSubstanceAbuseId(tmpSubstanceAbuse.getSubstanceAbuseId().toString());
		substanceAbuseDTO.setEnrollmentId(tmpSubstanceAbuse.getEnrollmentId().toString());

		// Program Specific Data Standards: Substance Abuse (2014, 4.10)
		substanceAbuseDTO.setInformationDate(tmpSubstanceAbuse.getInformationDate());
		substanceAbuseDTO.setResponse(ClientDisabilityResponse.valueByCode(tmpSubstanceAbuse.getResponse()));
		substanceAbuseDTO.setIndefiniteAndImpairs(YesNoReason.valueByCode(tmpSubstanceAbuse.getIndefiniteAndImpairs()));
		substanceAbuseDTO.setDocumentationOnFile(YesNo.valueByCode(tmpSubstanceAbuse.getDocumentationOnFile()));
		substanceAbuseDTO.setReceivingServices(YesNoReason.valueByCode(tmpSubstanceAbuse.getReceivingServices()));
		substanceAbuseDTO.setPathHowConfirmed(ClientPathHowConfirmed.valueByCode(tmpSubstanceAbuse.getPathHowConfirmed()));

		// Export Standard Fields
		substanceAbuseDTO.setDateCreated(tmpSubstanceAbuse.getDateCreated());
		substanceAbuseDTO.setDateUpdated(tmpSubstanceAbuse.getDateUpdated());
		
		return substanceAbuseDTO;
	}
	
	public static TmpSubstanceAbuse generateTmpSubstanceAbuse(SubstanceAbuseDTO inputDTO) {
		TmpSubstanceAbuse tmpSubstanceAbuse = new TmpSubstanceAbuse();
		
		tmpSubstanceAbuse.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Substance Abuse (2014, 4.10)
		tmpSubstanceAbuse.setInformationDate(inputDTO.getInformationDate());
		tmpSubstanceAbuse.setResponse(inputDTO.getResponse().getCode());
		tmpSubstanceAbuse.setIndefiniteAndImpairs(inputDTO.getIndefiniteAndImpairs().getCode());
		tmpSubstanceAbuse.setDocumentationOnFile(inputDTO.getDocumentationOnFile().getCode());
		tmpSubstanceAbuse.setReceivingServices(inputDTO.getReceivingServices().getCode());
		tmpSubstanceAbuse.setPathHowConfirmed(inputDTO.getPathHowConfirmed().getCode());

		// Export Standard Fields
		tmpSubstanceAbuse.setDateCreated(inputDTO.getDateCreated());
		tmpSubstanceAbuse.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpSubstanceAbuse;
	}
	
}