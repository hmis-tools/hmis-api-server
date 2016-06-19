package org.openhmis.generator;

public class HealthInsuranceGenerator {

	public HealthInsuranceGenerator() {
	}
	
	public HealthInsuranceDTO generateHealthInsuranceDTO(TmpHealthInsurance tmpHealthInsurance) {
		HealthInsuranceDTO healthInsuranceDTO = new HealthInsuranceDTO();

		healthInsuranceDTO.setHealthInsuranceId(tmpHealthInsurance.getHealthInsuranceId().toString());
		healthInsuranceDTO.setEnrollmentId(tmpHealthInsurance.getEnrollmentId().toString());

		// Program Specific Data Standards: Health Insurance (2014, 4.4)
		healthInsuranceDTO.setInformationDate(tmpHealthInsurance.getInformationDate());
		healthInsuranceDTO.setInsuranceFromAnySource(YesNoReason.valueByCode(tmpHealthInsurance.getInsuranceFromAnySource()));
		healthInsuranceDTO.setMedicaid(YesNo.valueByCode(tmpHealthInsurance.getMedicaid()));
		healthInsuranceDTO.setNoMedicaidReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoMedicaidReason()));
		healthInsuranceDTO.setMedicare(YesNo.valueByCode(tmpHealthInsurance.getMedicare()));
		healthInsuranceDTO.setNoMedicareReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoMedicareReason()));
		healthInsuranceDTO.setSchip(YesNo.valueByCode(tmpHealthInsurance.getSchip()));
		healthInsuranceDTO.setNoSchipReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoSchipReason()));
		healthInsuranceDTO.setVaMedicalServices(YesNo.valueByCode(tmpHealthInsurance.getVaMedicalServices()));
		healthInsuranceDTO.setNoVaMedReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoVaMedReason()));
		healthInsuranceDTO.setEmployerProvided(YesNo.valueByCode(tmpHealthInsurance.getEmployerProvided()));
		healthInsuranceDTO.setNoEmployerProvidedReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoEmployerProvidedReason()));
		healthInsuranceDTO.setCobra(YesNo.valueByCode(tmpHealthInsurance.getCobra()));
		healthInsuranceDTO.setNoCobraReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoCobraReason()));
		healthInsuranceDTO.setPrivatePay(YesNo.valueByCode(tmpHealthInsurance.getPay()));
		healthInsuranceDTO.setNoPrivatePayReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoPayReason()));
		healthInsuranceDTO.setStateHealthIns(YesNo.valueByCode(tmpHealthInsurance.getStateHealthIns()));
		healthInsuranceDTO.setNoStateHealthInsReason(ClientReasonNotInsured.valueByCode(tmpHealthInsurance.getNoStateHealthInsReason()));

		// Export Standard Fields
		healthInsuranceDTO.setDateCreated(tmpHealthInsurance.getDateCreated());
		healthInsuranceDTO.setDateUpdated(tmpHealthInsurance.getDateUpdated());
		
		return healthInsuranceDTO;
	}
	
	public TmpHealthInsurance generateTmpHealthInsurance(HealthInsuranceDTO inputDTO) {
		TmpHealthInsurance tmpHealthInsurance = new TmpHealthInsurance();
		
		tmpHealthInsurance.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));
		
		// Program Specific Data Standards: Health Insurance (2014, 4.4)
		tmpHealthInsurance.setInformationDate(inputDTO.getInformationDate());
		tmpHealthInsurance.setInsuranceFromAnySource(inputDTO.getInsuranceFromAnySource().getCode());
		tmpHealthInsurance.setMedicaid(inputDTO.getMedicaid().getCode());
		tmpHealthInsurance.setNoMedicaidReason(inputDTO.getNoMedicaidReason().getCode());
		tmpHealthInsurance.setMedicare(inputDTO.getMedicare().getCode());
		tmpHealthInsurance.setNoMedicareReason(inputDTO.getNoMedicareReason().getCode());
		tmpHealthInsurance.setSchip(inputDTO.getSchip().getCode());
		tmpHealthInsurance.setNoSchipReason(inputDTO.getNoSchipReason().getCode());
		tmpHealthInsurance.setVaMedicalServices(inputDTO.getVaMedicalServices().getCode());
		tmpHealthInsurance.setNoVaMedReason(inputDTO.getNoVaMedReason().getCode());
		tmpHealthInsurance.setEmployerProvided(inputDTO.getEmployerProvided().getCode());
		tmpHealthInsurance.setNoEmployerProvidedReason(inputDTO.getNoEmployerProvidedReason().getCode());
		tmpHealthInsurance.setNoCobraReason(inputDTO.getNoCobraReason().getCode());
		tmpHealthInsurance.setCobra(inputDTO.getCobra().getCode());
		tmpHealthInsurance.setPay(inputDTO.getPrivatePay().getCode());
		tmpHealthInsurance.setNoPayReason(inputDTO.getNoPrivatePayReason().getCode());
		tmpHealthInsurance.setStateHealthIns(inputDTO.getStateHealthIns().getCode());
		tmpHealthInsurance.setNoStateHealthInsReason(inputDTO.getNoStateHealthInsReason().getCode());

		// Export Standard Fields
		tmpHealthInsurance.setDateCreated(inputDTO.getDateCreated());
		tmpHealthInsurance.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpHealthInsurance;
	}
}