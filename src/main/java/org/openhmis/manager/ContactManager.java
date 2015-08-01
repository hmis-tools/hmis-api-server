package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.ContactDTO;

public class ContactManager {

	public ContactManager() {}

	public ContactDTO getContactById(String enrollmentId) {
		ContactDTO contactDTO = new ContactDTO();
		return contactDTO;
	}

	public List<ContactDTO> getContactsByEnrollmentId(String enrollmentId) {
		List<ContactDTO> contactDTOs = new ArrayList<ContactDTO>();
		return contactDTOs;
	}
	
	public ContactDTO addContact(ContactDTO inputVO) {
		return inputVO;
	}
	
	public ContactDTO updateContact(ContactDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteContact(String contactId) {
		return false;
	}
	
	public static ContactDTO generateContactVO() {
		ContactDTO contactDTO = new ContactDTO();
		
		return contactDTO;
	}
	
}