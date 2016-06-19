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
import org.openhmis.dao.TmpContactDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpContact;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.ContactDTO;
import org.openhmis.dto.search.ContactSearchDTO;


public class ContactManager {
	private TmpContactDAO tmpContactDAO;

	public ContactManager() {
		this.tmpContactDAO = new TmpContactDAO();
	}
	
	public ContactManager(TmpContactDAO tmpContactDAO) {
		this.tmpContactDAO = tmpContactDAO;
	}

	public ContactDTO getContactById(String contactId) {
		ContactDTO contactDTO = ContactManager.generateContactDTO(tmpContactDAO.getTmpContactById(Integer.parseInt(contactId)));
		return contactDTO;
	}

	public List<ContactDTO> getContacts(ContactSearchDTO searchDTO) {
		List<ContactDTO> contactDTOs = new ArrayList<ContactDTO>();

		// Collect the contacts
		List<TmpContact> tmpContacts = tmpContactDAO.getTmpContacts(searchDTO);

		// For each contact, collect and map the data
		for (Iterator<TmpContact> iterator = tmpContacts.iterator(); iterator.hasNext();) {
			TmpContact tmpContact = iterator.next();
			ContactDTO contactDTO = ContactManager.generateContactDTO(tmpContact);
			contactDTOs.add(contactDTO);
		}
		return contactDTOs;

	}

	public ContactDTO addContact(ContactDTO inputDTO) {
		// Generate a PathClient from the input
		TmpContact tmpContact = ContactManager.generateTmpContact(inputDTO);
		
		// Set Export fields
		tmpContact.setDateCreated(new Date());
		tmpContact.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpContactDAO.save(tmpContact);
		inputDTO.setContactId(tmpContact.getContactId().toString());
		
		// Return the resulting VO
		return ContactManager.generateContactDTO(tmpContact);
	}
	
	public ContactDTO updateContact(ContactDTO inputDTO) {
		// Generate a Contact from the input
		TmpContact tmpContact = ContactManager.generateTmpContact(inputDTO);
		tmpContact.setContactId(Integer.parseInt(inputDTO.getContactId()));
		tmpContact.setDateUpdated(new Date());
		
		// Update the object
		tmpContactDAO.update(tmpContact);
		
		// Return the resulting VO
		return ContactManager.generateContactDTO(tmpContact);

	}
	
	public boolean deleteContact(String contactId) {
		TmpContact tmpContact = tmpContactDAO.getTmpContactById(Integer.parseInt(contactId));
		tmpContactDAO.delete(tmpContact);
		return true;
	}
	
}
