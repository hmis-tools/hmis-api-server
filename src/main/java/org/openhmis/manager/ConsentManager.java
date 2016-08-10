package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ConsentField;
import org.openhmis.code.ConsentRequestType;
import org.openhmis.dao.TmpConsentCoCDAO;
import org.openhmis.dao.TmpConsentDAO;
import org.openhmis.dao.TmpConsentFieldDAO;
import org.openhmis.dao.TmpConsentOrganizationDAO;
import org.openhmis.domain.TmpConsent;
import org.openhmis.domain.TmpConsentCoC;
import org.openhmis.domain.TmpConsentField;
import org.openhmis.domain.TmpConsentOrganization;
import org.openhmis.dto.ConsentDTO;
import org.openhmis.dto.ConsentFieldsDTO;
import org.openhmis.dto.search.ConsentCoCSearchDTO;
import org.openhmis.dto.search.ConsentFieldSearchDTO;
import org.openhmis.dto.search.ConsentOrganizationSearchDTO;
import org.openhmis.dto.search.ConsentSearchDTO;


public class ConsentManager {
	private static final TmpConsentDAO tmpConsentDAO = new TmpConsentDAO();
	private static final TmpConsentFieldDAO tmpConsentFieldDAO = new TmpConsentFieldDAO();
	private static final TmpConsentOrganizationDAO tmpConsentOrganizationDAO = new TmpConsentOrganizationDAO();
	private static final TmpConsentCoCDAO tmpConsentCoCDAO = new TmpConsentCoCDAO();

	public ConsentManager() {}

	public static ConsentDTO getConsentById(String consentId) {
		// Get the core consent object
		TmpConsent tmpConsent = tmpConsentDAO.getTmpConsentById(Integer.parseInt(consentId));

		// Get the consent Fields
		ConsentFieldSearchDTO consentFieldSearchDTO = new ConsentFieldSearchDTO();
		consentFieldSearchDTO.setConsentId(Integer.parseInt(consentId));
		List<TmpConsentField> tmpConsentFields = tmpConsentFieldDAO.getTmpConsentFields(consentFieldSearchDTO);
		
		// Get the consent organizations
		ConsentOrganizationSearchDTO consentOrganizationSearchDTO = new ConsentOrganizationSearchDTO();
		consentOrganizationSearchDTO.setConsentId(Integer.parseInt(consentId));
		List<TmpConsentOrganization> tmpConsentOrganizations = tmpConsentOrganizationDAO.getTmpConsentOrganizations(consentOrganizationSearchDTO);

		// Get the consent CoCs
		ConsentCoCSearchDTO consentCoCSearchDTO = new ConsentCoCSearchDTO();
		consentCoCSearchDTO.setConsentId(Integer.parseInt(consentId));
		List<TmpConsentCoC> tmpConsentCoCs = tmpConsentCoCDAO.getTmpConsentCoCs(consentCoCSearchDTO);
		
		ConsentDTO consentDTO = ConsentManager.generateConsentDTO(tmpConsent, tmpConsentFields, tmpConsentOrganizations, tmpConsentCoCs);
		return consentDTO;
	}
	
	public static List<ConsentDTO> getConsents(ConsentSearchDTO searchDTO) {
		List<ConsentDTO> consentDTOs = new ArrayList<ConsentDTO>();

		// Collect the consents
		List<TmpConsent> tmpConsents = tmpConsentDAO.getTmpConsents(searchDTO);

		// For each consent, collect and map the data
		for (Iterator<TmpConsent> iterator = tmpConsents.iterator(); iterator.hasNext();) {
			TmpConsent tmpConsent = iterator.next();
			
			// Get the consent Fields
			ConsentFieldSearchDTO consentFieldSearchDTO = new ConsentFieldSearchDTO();
			consentFieldSearchDTO.setConsentId(tmpConsent.getConsentId());
			List<TmpConsentField> tmpConsentFields = tmpConsentFieldDAO.getTmpConsentFields(consentFieldSearchDTO);
			
			// Get the consent organizations
			ConsentOrganizationSearchDTO consentOrganizationSearchDTO = new ConsentOrganizationSearchDTO();
			consentOrganizationSearchDTO.setConsentId(tmpConsent.getConsentId());
			List<TmpConsentOrganization> tmpConsentOrganizations = tmpConsentOrganizationDAO.getTmpConsentOrganizations(consentOrganizationSearchDTO);

			// Get the consent CoCs
			ConsentCoCSearchDTO consentCoCSearchDTO = new ConsentCoCSearchDTO();
			consentCoCSearchDTO.setConsentId(tmpConsent.getConsentId());
			List<TmpConsentCoC> tmpConsentCoCs = tmpConsentCoCDAO.getTmpConsentCoCs(consentCoCSearchDTO);
			
			ConsentDTO consentDTO = ConsentManager.generateConsentDTO(tmpConsent, tmpConsentFields, tmpConsentOrganizations, tmpConsentCoCs);
			consentDTOs.add(consentDTO);
		}
		return consentDTOs;

	}

	public static ConsentDTO addConsent(ConsentDTO inputDTO) {
		// Generate domain objects from the input
		TmpConsent tmpConsent = ConsentManager.generateTmpConsent(inputDTO);
		List<TmpConsentField> tmpConsentFields = ConsentManager.generateTmpConsentFields(inputDTO);
		List<TmpConsentOrganization> tmpConsentOrganizations = ConsentManager.generateTmpConsentOrganizations(inputDTO);
		List<TmpConsentCoC> tmpConsentCoCs = ConsentManager.generateTmpConsentCoCs(inputDTO);
		
		// Set Export fields
		tmpConsent.setDateCreated(new Date());
		tmpConsent.setDateUpdated(new Date());
		
		// Save the consent object
		tmpConsentDAO.save(tmpConsent);
		inputDTO.setConsentId(tmpConsent.getConsentId().toString());

		// Save the consent fields
		for(Iterator<TmpConsentField> fieldIterator = tmpConsentFields.iterator(); fieldIterator.hasNext();) {
			TmpConsentField tmpConsentField = fieldIterator.next();
			tmpConsentField.setConsentId(tmpConsent.getConsentId());
			tmpConsentField.setDateCreated(new Date());
			tmpConsentField.setDateUpdated(new Date());
			tmpConsentFieldDAO.save(tmpConsentField);
		}

		// Save the consent organizations
		for(Iterator<TmpConsentOrganization> organizationIterator = tmpConsentOrganizations.iterator(); organizationIterator.hasNext();) {
			TmpConsentOrganization tmpConsentOrganization = organizationIterator.next();
			tmpConsentOrganization.setConsentId(tmpConsent.getConsentId());
			tmpConsentOrganization.setDateCreated(new Date());
			tmpConsentOrganization.setDateUpdated(new Date());
			tmpConsentFieldDAO.save(tmpConsentOrganization);
		}

		// Save the consent organizations
		for(Iterator<TmpConsentCoC> coCIterator = tmpConsentCoCs.iterator(); coCIterator.hasNext();) {
			TmpConsentCoC tmpConsentCoC = coCIterator.next();
			tmpConsentCoC.setConsentId(tmpConsent.getConsentId());
			tmpConsentCoC.setDateCreated(new Date());
			tmpConsentCoC.setDateUpdated(new Date());
			tmpConsentFieldDAO.save(tmpConsentCoC);
		}

		// Return the resulting DTO
		ConsentDTO consentDTO = ConsentManager.generateConsentDTO(tmpConsent, tmpConsentFields, tmpConsentOrganizations, tmpConsentCoCs);
		return consentDTO;
	}
	
	public static ConsentDTO updateConsent(ConsentDTO inputDTO) {
		// Generate a Consent from the input
		TmpConsent tmpConsent = ConsentManager.generateTmpConsent(inputDTO);
		tmpConsent.setConsentId(Integer.parseInt(inputDTO.getConsentId()));
		tmpConsent.setDateUpdated(new Date());
		
		// Update the object
		// NOTE: The fields / organizations / CoCs of a consent CANNOT BE CHANGED (a new consent must be made)
		tmpConsentDAO.update(tmpConsent);
		
		// Get the consent Fields
		ConsentFieldSearchDTO consentFieldSearchDTO = new ConsentFieldSearchDTO();
		consentFieldSearchDTO.setConsentId(tmpConsent.getConsentId());
		List<TmpConsentField> tmpConsentFields = tmpConsentFieldDAO.getTmpConsentFields(consentFieldSearchDTO);
		
		// Get the consent organizations
		ConsentOrganizationSearchDTO consentOrganizationSearchDTO = new ConsentOrganizationSearchDTO();
		consentOrganizationSearchDTO.setConsentId(tmpConsent.getConsentId());
		List<TmpConsentOrganization> tmpConsentOrganizations = tmpConsentOrganizationDAO.getTmpConsentOrganizations(consentOrganizationSearchDTO);

		// Get the consent CoCs
		ConsentCoCSearchDTO consentCoCSearchDTO = new ConsentCoCSearchDTO();
		consentCoCSearchDTO.setConsentId(tmpConsent.getConsentId());
		List<TmpConsentCoC> tmpConsentCoCs = tmpConsentCoCDAO.getTmpConsentCoCs(consentCoCSearchDTO);

		// Return the resulting DTO
		ConsentDTO consentDTO = ConsentManager.generateConsentDTO(tmpConsent, tmpConsentFields, tmpConsentOrganizations, tmpConsentCoCs);
		return consentDTO;
	}
	
	public static boolean deleteConsent(String consentId) {
		TmpConsent tmpConsent = tmpConsentDAO.getTmpConsentById(Integer.parseInt(consentId));
		tmpConsentDAO.delete(tmpConsent);
		return true;
	}
	
	public static ConsentDTO generateConsentDTO(TmpConsent tmpConsent, List<TmpConsentField> tmpConsentFields, List<TmpConsentOrganization> tmpConsentOrganizations, List<TmpConsentCoC> tmpConsentCoCs) {
		ConsentDTO consentDTO = new ConsentDTO();
		consentDTO.setConsentId(tmpConsent.getConsentId().toString());
		
		// Base Fields
		consentDTO.setSubmitterId(tmpConsent.getSubmitterId().toString());
		consentDTO.setDateProcessed(tmpConsent.getDateProcessed());
		
		// Organizations
		List<String> organizationIds = new ArrayList<String>();
		for(Iterator<TmpConsentOrganization> organizationIterator = tmpConsentOrganizations.iterator(); organizationIterator.hasNext();) {
			TmpConsentOrganization tmpConsentOrganization = organizationIterator.next();
			organizationIds.add(tmpConsentOrganization.getOrganizationId().toString());
		}
		consentDTO.setOrganizationIds(organizationIds);

		// CoCs
		List<String> cocIds = new ArrayList<String>();
		for(Iterator<TmpConsentCoC> coCIterator = tmpConsentCoCs.iterator(); coCIterator.hasNext();) {
			TmpConsentCoC tmpConsentCoC = coCIterator.next();
			cocIds.add(tmpConsentCoC.getCoCId().toString());
		}
		consentDTO.setCocIds(cocIds);
		
		// Consent Fields
		ConsentFieldsDTO consentFieldsDTO = new ConsentFieldsDTO();
		for(Iterator<TmpConsentField> fieldIterator = tmpConsentFields.iterator(); fieldIterator.hasNext();) {
			TmpConsentField tmpField = fieldIterator.next();
			
			switch(ConsentField.valueByCode(tmpField.getFieldCode())) {
				case DATE_OF_BIRTH:
					consentFieldsDTO.setDob(ConsentRequestType.valueByCode(tmpField.getRequestTypeCode()));
					break;
				case ETHNICITY:
					consentFieldsDTO.setEthnicity(ConsentRequestType.valueByCode(tmpField.getRequestTypeCode()));
					break;
				case FIRST_NAME:
					consentFieldsDTO.setFirstName(ConsentRequestType.valueByCode(tmpField.getRequestTypeCode()));
					break;
				case GENDER:
					consentFieldsDTO.setGender(ConsentRequestType.valueByCode(tmpField.getRequestTypeCode()));
					break; 
				case LAST_NAME:
					consentFieldsDTO.setLastName(ConsentRequestType.valueByCode(tmpField.getRequestTypeCode()));
					break;
				case MIDDLE_NAME:
					consentFieldsDTO.setMiddleName(ConsentRequestType.valueByCode(tmpField.getRequestTypeCode()));
					break;
				case NAME_SUFFIX:
					consentFieldsDTO.setNameSuffix(ConsentRequestType.valueByCode(tmpField.getRequestTypeCode()));
					break;
				case RACE:
					consentFieldsDTO.setRace(ConsentRequestType.valueByCode(tmpField.getRequestTypeCode()));
					break;
				case SSN:
					consentFieldsDTO.setSsn(ConsentRequestType.valueByCode(tmpField.getRequestTypeCode()));
					break;
				case VETERAN_STATUS:
					consentFieldsDTO.setVeteranStatus(ConsentRequestType.valueByCode(tmpField.getRequestTypeCode()));
					break;
				case ERR_UNKNOWN:
					break;
			}
		}
		consentDTO.setFields(consentFieldsDTO);

		// Export Standard Fields
		consentDTO.setDateCreated(tmpConsent.getDateCreated());
		consentDTO.setDateUpdated(tmpConsent.getDateUpdated());
		
		return consentDTO;
	}
	
	public static TmpConsent generateTmpConsent(ConsentDTO inputDTO) {
		TmpConsent tmpConsent = new TmpConsent();
		tmpConsent.setSubmitterId(Integer.parseInt(inputDTO.getSubmitterId()));
		tmpConsent.setDateProcessed(inputDTO.getDateProcessed());

		// Export Standard Fields
		tmpConsent.setDateCreated(inputDTO.getDateCreated());
		tmpConsent.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpConsent;
	}
	
	public static List<TmpConsentField> generateTmpConsentFields(ConsentDTO inputDTO) {
		List<TmpConsentField> tmpConsentFields = new ArrayList<TmpConsentField>();
		
		// TODO: This violates DRY; there is probably a better way
		if(inputDTO.getFields().getDob() != null) {
			TmpConsentField tmpField = new TmpConsentField();
			tmpField.setFieldCode(ConsentField.DATE_OF_BIRTH.getCode());
			tmpField.setRequestTypeCode(inputDTO.getFields().getDob().getCode());
			tmpField.setDateCreated(inputDTO.getDateCreated());
			tmpField.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentFields.add(tmpField);
		}
		if(inputDTO.getFields().getEthnicity() != null) {
			TmpConsentField tmpField = new TmpConsentField();
			tmpField.setFieldCode(ConsentField.ETHNICITY.getCode());
			tmpField.setRequestTypeCode(inputDTO.getFields().getEthnicity().getCode());
			tmpField.setDateCreated(inputDTO.getDateCreated());
			tmpField.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentFields.add(tmpField);
		}
		if(inputDTO.getFields().getFirstName() != null) {
			TmpConsentField tmpField = new TmpConsentField();
			tmpField.setFieldCode(ConsentField.FIRST_NAME.getCode());
			tmpField.setRequestTypeCode(inputDTO.getFields().getFirstName().getCode());
			tmpField.setDateCreated(inputDTO.getDateCreated());
			tmpField.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentFields.add(tmpField);
		}
		if(inputDTO.getFields().getGender() != null) {
			TmpConsentField tmpField = new TmpConsentField();
			tmpField.setFieldCode(ConsentField.GENDER.getCode());
			tmpField.setRequestTypeCode(inputDTO.getFields().getGender().getCode());
			tmpField.setDateCreated(inputDTO.getDateCreated());
			tmpField.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentFields.add(tmpField);
		}
		if(inputDTO.getFields().getLastName() != null) {
			TmpConsentField tmpField = new TmpConsentField();
			tmpField.setFieldCode(ConsentField.LAST_NAME.getCode());
			tmpField.setRequestTypeCode(inputDTO.getFields().getLastName().getCode());
			tmpField.setDateCreated(inputDTO.getDateCreated());
			tmpField.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentFields.add(tmpField);
		}
		if(inputDTO.getFields().getMiddleName() != null) {
			TmpConsentField tmpField = new TmpConsentField();
			tmpField.setFieldCode(ConsentField.MIDDLE_NAME.getCode());
			tmpField.setRequestTypeCode(inputDTO.getFields().getMiddleName().getCode());
			tmpField.setDateCreated(inputDTO.getDateCreated());
			tmpField.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentFields.add(tmpField);
		}
		if(inputDTO.getFields().getNameSuffix() != null) {
			TmpConsentField tmpField = new TmpConsentField();
			tmpField.setFieldCode(ConsentField.NAME_SUFFIX.getCode());
			tmpField.setRequestTypeCode(inputDTO.getFields().getNameSuffix().getCode());
			tmpField.setDateCreated(inputDTO.getDateCreated());
			tmpField.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentFields.add(tmpField);
		}
		if(inputDTO.getFields().getRace() != null) {
			TmpConsentField tmpField = new TmpConsentField();
			tmpField.setFieldCode(ConsentField.RACE.getCode());
			tmpField.setRequestTypeCode(inputDTO.getFields().getRace().getCode());
			tmpField.setDateCreated(inputDTO.getDateCreated());
			tmpField.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentFields.add(tmpField);
		}
		if(inputDTO.getFields().getSsn() != null) {
			TmpConsentField tmpField = new TmpConsentField();
			tmpField.setFieldCode(ConsentField.SSN.getCode());
			tmpField.setRequestTypeCode(inputDTO.getFields().getSsn().getCode());
			tmpField.setDateCreated(inputDTO.getDateCreated());
			tmpField.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentFields.add(tmpField);
		}
		if(inputDTO.getFields().getVeteranStatus() != null) {
			TmpConsentField tmpField = new TmpConsentField();
			tmpField.setFieldCode(ConsentField.VETERAN_STATUS.getCode());
			tmpField.setRequestTypeCode(inputDTO.getFields().getVeteranStatus().getCode());
			tmpField.setDateCreated(inputDTO.getDateCreated());
			tmpField.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentFields.add(tmpField);
		}
		
		return tmpConsentFields;
	}
	
	public static List<TmpConsentCoC> generateTmpConsentCoCs(ConsentDTO inputDTO) {
		List<TmpConsentCoC> tmpConsentCoCs = new ArrayList<TmpConsentCoC>();

		for(Iterator<String> coCIterator = inputDTO.getCocIds().iterator(); coCIterator.hasNext();) {
			String consentCoCId = coCIterator.next();
			TmpConsentCoC tmpConsentCoC = new TmpConsentCoC();
			tmpConsentCoC.setCoCId(Integer.parseInt(consentCoCId));
			tmpConsentCoC.setDateCreated(inputDTO.getDateCreated());
			tmpConsentCoC.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentCoCs.add(tmpConsentCoC);
		}
		
		return tmpConsentCoCs;
	}
	
	public static List<TmpConsentOrganization> generateTmpConsentOrganizations(ConsentDTO inputDTO) {
		List<TmpConsentOrganization> tmpConsentOrganizations = new ArrayList<TmpConsentOrganization>();

		for(Iterator<String> organizationIterator = inputDTO.getOrganizationIds().iterator(); organizationIterator.hasNext();) {
			String consentOrganizationId = organizationIterator.next();
			TmpConsentOrganization tmpConsentOrganization = new TmpConsentOrganization();
			tmpConsentOrganization.setOrganizationId(Integer.parseInt(consentOrganizationId));
			tmpConsentOrganization.setDateCreated(inputDTO.getDateCreated());
			tmpConsentOrganization.setDateUpdated(inputDTO.getDateUpdated());
			tmpConsentOrganizations.add(tmpConsentOrganization);
		}
		
		return tmpConsentOrganizations;
	}
	
}
