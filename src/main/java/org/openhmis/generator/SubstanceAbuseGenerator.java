package org.openhmis.generator;

public class SubstanceAbuseGenerator {

	public SubstanceAbuseGenerator() {
	}
	
	public SubstanceAbuseDTO generateSubstanceAbuseDTO(TmpSubstanceAbuse tmpSubstanceAbuse) {
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
	
	public TmpSubstanceAbuse generateTmpSubstanceAbuse(SubstanceAbuseDTO inputDTO) {
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