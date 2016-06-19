package org.openhmis.generator;

public class NonCashBenefitGenerator {

	public NonCashBenefitGenerator() {
	}
	
	public NonCashBenefitDTO generateNonCashBenefitDTO(TmpNonCashBenefit tmpNonCashBenefit) {
		NonCashBenefitDTO nonCashBenefitDTO = new NonCashBenefitDTO();

		nonCashBenefitDTO.setNonCashBenefitId(tmpNonCashBenefit.getNonCashBenefitId().toString());
		nonCashBenefitDTO.setEnrollmentId(tmpNonCashBenefit.getEnrollmentId().toString());

		// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
		nonCashBenefitDTO.setInformationDate(tmpNonCashBenefit.getInformationDate());
		nonCashBenefitDTO.setBenefitsFromAnySource(YesNoReason.valueByCode(tmpNonCashBenefit.getBenefitsFromAnySource()));
		nonCashBenefitDTO.setSnap(YesNo.valueByCode(tmpNonCashBenefit.getSnap()));
		nonCashBenefitDTO.setWic(YesNo.valueByCode(tmpNonCashBenefit.getWic()));
		nonCashBenefitDTO.setTanfChildCare(YesNo.valueByCode(tmpNonCashBenefit.getTanfChildCare()));
		nonCashBenefitDTO.setTanfTransportation(YesNo.valueByCode(tmpNonCashBenefit.getTanfTransportation()));
		nonCashBenefitDTO.setOtherTanf(YesNo.valueByCode(tmpNonCashBenefit.getOtherTanf()));
		nonCashBenefitDTO.setRentalAssistanceOngoing(YesNo.valueByCode(tmpNonCashBenefit.getRentalAssistanceOngoing()));
		nonCashBenefitDTO.setOtherBenefitsSource(YesNo.valueByCode(tmpNonCashBenefit.getOtherBenefitsSource()));
		nonCashBenefitDTO.setRentalAssistanceTemp(YesNo.valueByCode(tmpNonCashBenefit.getRentalAssistanceTemp()));
		nonCashBenefitDTO.setOtherBenefitsSourceIdentify(tmpNonCashBenefit.getOtherBenefitsSourceIdentify());

		// Export Standard Fields
		nonCashBenefitDTO.setDateCreated(tmpNonCashBenefit.getDateCreated());
		nonCashBenefitDTO.setDateUpdated(tmpNonCashBenefit.getDateUpdated());
		
		return nonCashBenefitDTO;
	}
	
	public TmpNonCashBenefit generateTmpNonCashBenefit(NonCashBenefitDTO inputDTO) {
		TmpNonCashBenefit tmpNonCashBenefit = new TmpNonCashBenefit();
		
		tmpNonCashBenefit.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Non-cash Benefits (2014, 4.3)
		tmpNonCashBenefit.setInformationDate(inputDTO.getInformationDate());
		tmpNonCashBenefit.setBenefitsFromAnySource(inputDTO.getBenefitsFromAnySource().getCode());
		tmpNonCashBenefit.setSnap(inputDTO.getSnap().getCode());
		tmpNonCashBenefit.setWic(inputDTO.getWic().getCode());
		tmpNonCashBenefit.setTanfChildCare(inputDTO.getTanfChildCare().getCode());
		tmpNonCashBenefit.setTanfTransportation(inputDTO.getTanfTransportation().getCode());
		tmpNonCashBenefit.setOtherTanf(inputDTO.getOtherTanf().getCode());
		tmpNonCashBenefit.setRentalAssistanceOngoing(inputDTO.getRentalAssistanceOngoing().getCode());
		tmpNonCashBenefit.setOtherBenefitsSource(inputDTO.getOtherBenefitsSource().getCode());
		tmpNonCashBenefit.setRentalAssistanceTemp(inputDTO.getRentalAssistanceTemp().getCode());
		tmpNonCashBenefit.setOtherBenefitsSourceIdentify(inputDTO.getOtherBenefitsSourceIdentify());

		// Export Standard Fields
		tmpNonCashBenefit.setDateCreated(inputDTO.getDateCreated());
		tmpNonCashBenefit.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpNonCashBenefit;
	}
}