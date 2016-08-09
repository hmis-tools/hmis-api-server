package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientContactLocation;
import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.dao.TmpConsentCoCDAO;
import org.openhmis.dao.TmpConsentDAO;
import org.openhmis.dao.TmpConsentFieldDAO;
import org.openhmis.dao.TmpConsentOrganizationDAO;
import org.openhmis.dao.TmpContactDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpConsent;
import org.openhmis.domain.TmpContact;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.ConsentDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.ContactDTO;
import org.openhmis.dto.search.ConsentSearchDTO;
import org.openhmis.dto.search.ContactSearchDTO;


public class ConsentManager {
	private static final TmpConsentDAO tmpConsentDAO = new TmpConsentDAO();
	private static final TmpConsentFieldDAO tmpConsentFieldDAO = new TmpConsentFieldDAO();
	private static final TmpConsentOrganizationDAO tmpConsentOrganizationDAO = new TmpConsentOrganizationDAO();
	private static final TmpConsentCoCDAO tmpConsentCoCDAO = new TmpConsentCoCDAO();

	public ConsentManager() {}

	public static ConsentDTO getConsentById(String consentId) {
		ConsentDTO consentDTO = ConsentManager.generateConsentDTO(tmpConsentDAO.getTmpConsentById(Integer.parseInt(consentId)));
		return consentDTO;
	}
	public static List<ConsentDTO> getConsents(ConsentSearchDTO searchDTO) {
		List<ConsentDTO> consentDTOs = new ArrayList<ConsentDTO>();

		// Collect the consents
		List<TmpConsent> tmpConsents = tmpConsentDAO.getTmpConsents(searchDTO);

		// For each consent, collect and map the data
		for (Iterator<TmpConsent> iterator = tmpConsents.iterator(); iterator.hasNext();) {
			TmpConsent tmpConsent = iterator.next();
			ConsentDTO consentDTO = ConsentManager.generateConsentDTO(tmpConsent);
			consentDTOs.add(consentDTO);
		}
		return consentDTOs;

	}

	public static ConsentDTO addConsent(ConsentDTO inputDTO) {
		// Generate a PathClient from the input
		TmpConsent tmpConsent = ConsentManager.generateTmpConsent(inputDTO);
		
		// Set Export fields
		tmpConsent.setDateCreated(new Date());
		tmpConsent.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpConsentDAO.save(tmpConsent);
		inputDTO.setConsentId(tmpConsent.getConsentId().toString());
		
		// Return the resulting VO
		return ConsentManager.generateConsentDTO(tmpConsent);
	}
	
	public static ConsentDTO updateConsent(ConsentDTO inputDTO) {
		// Generate a Consent from the input
		TmpConsent tmpConsent = ConsentManager.generateTmpConsent(inputDTO);
		tmpConsent.setConsentId(Integer.parseInt(inputDTO.getConsentId()));
		tmpConsent.setDateUpdated(new Date());
		
		// Update the object
		tmpConsentDAO.update(tmpConsent);
		
		// Return the resulting VO
		return ConsentManager.generateConsentDTO(tmpConsent);

	}
	
	public static boolean deleteConsent(String consentId) {
		TmpConsent tmpConsent = tmpConsentDAO.getTmpConsentById(Integer.parseInt(consentId));
		tmpConsentDAO.delete(tmpConsent);
		return true;
	}
	
	public static ConsentDTO generateConsentDTO(TmpConsent tmpConsent) {
		ConsentDTO consentDTO = new ConsentDTO();
		consentDTO.setConsentId(tmpConsent.getConsentId().toString());

		// Export Standard Fields
		consentDTO.setDateCreated(tmpConsent.getDateCreated());
		consentDTO.setDateUpdated(tmpConsent.getDateUpdated());
		
		return consentDTO;
	}
	
	public static TmpConsent generateTmpConsent(ConsentDTO inputDTO) {
		TmpConsent tmpConsent = new TmpConsent();

		// Export Standard Fields
		tmpConsent.setDateCreated(inputDTO.getDateCreated());
		tmpConsent.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpConsent;
	}
	
}
