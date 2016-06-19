
package org.openhmis.generator;

public class DomesticAbuseGenerator {

	public DomesticAbuseGenerator() {
	}

	public DomesticAbuseDTO generateDomesticAbuseDTO(TmpDomesticAbuse tmpDomesticAbuse) {
		DomesticAbuseDTO domesticAbuseDTO = new DomesticAbuseDTO();

		domesticAbuseDTO.setDomesticAbuseId(tmpDomesticAbuse.getDomesticAbuseId().toString());
		domesticAbuseDTO.setEnrollmentId(tmpDomesticAbuse.getEnrollmentId().toString());

		// Program Specific Data Standards: Domestic Abuse (2014, 4.11)
		domesticAbuseDTO.setInformationDate(tmpDomesticAbuse.getInformationDate());
		domesticAbuseDTO.setDomesticViolenceVictim(YesNoReason.valueByCode(tmpDomesticAbuse.getDomesticViolenceVictim()));
		domesticAbuseDTO.setWhenOccurred(ClientWhenDvOccurred.valueByCode(tmpDomesticAbuse.getWhenOccurred()));

		// Export Standard Fields
		domesticAbuseDTO.setDateCreated(tmpDomesticAbuse.getDateCreated());
		domesticAbuseDTO.setDateUpdated(tmpDomesticAbuse.getDateUpdated());
		
		return domesticAbuseDTO;
	}
	
	public TmpDomesticAbuse generateTmpDomesticAbuse(DomesticAbuseDTO inputDTO) {
		TmpDomesticAbuse tmpDomesticAbuse = new TmpDomesticAbuse();
		
		tmpDomesticAbuse.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Domestic Abuse (2014, 4.11)
		tmpDomesticAbuse.setInformationDate(inputDTO.getInformationDate());
		tmpDomesticAbuse.setDomesticViolenceVictim(inputDTO.getDomesticViolenceVictim().getCode());
		tmpDomesticAbuse.setWhenOccurred(inputDTO.getWhenOccurred().getCode());

		// Export Standard Fields
		tmpDomesticAbuse.setDateCreated(inputDTO.getDateCreated());
		tmpDomesticAbuse.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpDomesticAbuse;
	}
}