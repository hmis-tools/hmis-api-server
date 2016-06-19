
package org.openhmis.generator;

public class ContactGenerator {

	public ContactGenerator() {
	}

	public ContactDTO generateContactDTO(TmpContact tmpContact) {
		ContactDTO contactDTO = new ContactDTO();

		contactDTO.setContactId(tmpContact.getContactId().toString());
		contactDTO.setEnrollmentId(tmpContact.getEnrollmentId().toString());

		// Program Specific Data Standards: Contact (2014, 4.12)
		contactDTO.setDateProvided(tmpContact.getDateProvided());
		contactDTO.setTypeProvided(ClientContactLocation.valueByCode(tmpContact.getTypeProvided()));

		// Export Standard Fields
		contactDTO.setDateCreated(tmpContact.getDateCreated());
		contactDTO.setDateUpdated(tmpContact.getDateUpdated());
		
		return contactDTO;
	}
	
	public TmpContact generateTmpContact(ContactDTO inputDTO) {
		TmpContact tmpContact = new TmpContact();
		
		tmpContact.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Contact (2014, 4.12)
		tmpContact.setDateProvided(inputDTO.getDateProvided());
		tmpContact.setTypeProvided(inputDTO.getTypeProvided().getCode());

		// Export Standard Fields
		tmpContact.setDateCreated(inputDTO.getDateCreated());
		tmpContact.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpContact;
	}
}