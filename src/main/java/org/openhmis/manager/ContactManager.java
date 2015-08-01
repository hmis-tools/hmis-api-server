package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.ContactVO;

public class ContactManager {

	public ContactManager() {}

	public ContactVO getContactById(String enrollmentId) {
		ContactVO contactVO = new ContactVO();
		return contactVO;
	}

	public List<ContactVO> getContactsByEnrollmentId(String enrollmentId) {
		List<ContactVO> contactVOs = new ArrayList<ContactVO>();
		return contactVOs;
	}
	
	public ContactVO addContact(ContactVO inputVO) {
		return inputVO;
	}
	
	public ContactVO updateContact(ContactVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteContact(String contactId) {
		return false;
	}
	
	public static ContactVO generateContactVO() {
		ContactVO contactVO = new ContactVO();
		
		return contactVO;
	}
	
}