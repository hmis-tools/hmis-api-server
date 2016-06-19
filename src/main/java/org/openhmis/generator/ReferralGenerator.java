package org.openhmis.generator;

public class ReferralGenerator {

	public ReferralGenerator() {
	}
	
	public ReferralDTO generateReferralDTO(TmpReferral tmpReferral) {
		ReferralDTO referralDTO = new ReferralDTO();

		referralDTO.setReferralId(tmpReferral.getReferralId().toString());
		referralDTO.setEnrollmentId(tmpReferral.getEnrollmentId().toString());

		// Program Specific Data Standards: References Provided (2014, 4.16)
		referralDTO.setReferralDate(tmpReferral.getReferralDate());
		
		// PATH (2014, 4.16A)
		referralDTO.setPathTypeProvided(ClientPathReferral.valueByCode(tmpReferral.getPathTypeProvided()));
		referralDTO.setReferralOutcome(ClientPathReferralOutcome.valueByCode(tmpReferral.getReferralOutcome()));
		
		// RHY (2014, 4.16B)
		referralDTO.setRhyTypeProvided(ClientRhyReferral.valueByCode(tmpReferral.getRhyTypeProvided()));

		// Export Standard Fields
		referralDTO.setDateCreated(tmpReferral.getDateCreated());
		referralDTO.setDateUpdated(tmpReferral.getDateUpdated());
		
		return referralDTO;
	}
	
	public TmpReferral generateTmpReferral(ReferralDTO inputDTO) {
		TmpReferral tmpReferral = new TmpReferral();
		
		tmpReferral.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: References Provided (2014, 4.16)
		tmpReferral.setReferralDate(inputDTO.getReferralDate());
		
		// PATH (2014, 4.16A)
		tmpReferral.setPathTypeProvided(inputDTO.getPathTypeProvided().getCode());
		tmpReferral.setReferralOutcome(inputDTO.getReferralOutcome().getCode());
		
		// RHY (2014, 4.16B)
		tmpReferral.setRhyTypeProvided(inputDTO.getRhyTypeProvided().getCode());

		// Export Standard Fields
		tmpReferral.setDateCreated(inputDTO.getDateCreated());
		tmpReferral.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpReferral;
	}
}