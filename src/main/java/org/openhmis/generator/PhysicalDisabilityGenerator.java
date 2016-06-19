package org.openhmis.generator;

public class PhysicalDisabilityGenerator {

	public PhysicalDisabilityGenerator() {
	}

	public PhysicalDisabilityDTO generatePhysicalDisabilityDTO(TmpPhysicalDisability tmpPhysicalDisability) {
		PhysicalDisabilityDTO physicalDisabilityDTO = new PhysicalDisabilityDTO();

		physicalDisabilityDTO.setPhysicalDisabilityId(tmpPhysicalDisability.getPhysicalDisabilityId().toString());
		physicalDisabilityDTO.setEnrollmentId(tmpPhysicalDisability.getEnrollmentId().toString());

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		physicalDisabilityDTO.setInformationDate(tmpPhysicalDisability.getInformationDate());
		physicalDisabilityDTO.setResponse(YesNoReason.valueByCode(tmpPhysicalDisability.getResponse()));
		physicalDisabilityDTO.setIndefiniteAndImpairs(YesNoReason.valueByCode(tmpPhysicalDisability.getIndefiniteAndImpairs()));
		physicalDisabilityDTO.setDocumentationOnFile(YesNo.valueByCode(tmpPhysicalDisability.getDocumentationOnFile()));
		physicalDisabilityDTO.setReceivingServices(YesNoReason.valueByCode(tmpPhysicalDisability.getReceivingServices()));

		// Export Standard Fields
		physicalDisabilityDTO.setDateCreated(tmpPhysicalDisability.getDateCreated());
		physicalDisabilityDTO.setDateUpdated(tmpPhysicalDisability.getDateUpdated());
		
		return physicalDisabilityDTO;
	}
	
	public TmpPhysicalDisability generateTmpPhysicalDisability(PhysicalDisabilityDTO inputDTO) {
		TmpPhysicalDisability tmpPhysicalDisability = new TmpPhysicalDisability();
		
		tmpPhysicalDisability.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		tmpPhysicalDisability.setInformationDate(inputDTO.getInformationDate());
		tmpPhysicalDisability.setResponse(inputDTO.getResponse().getCode());
		tmpPhysicalDisability.setIndefiniteAndImpairs(inputDTO.getIndefiniteAndImpairs().getCode());
		tmpPhysicalDisability.setDocumentationOnFile(inputDTO.getDocumentationOnFile().getCode());
		tmpPhysicalDisability.setReceivingServices(inputDTO.getReceivingServices().getCode());

		// Export Standard Fields
		tmpPhysicalDisability.setDateCreated(inputDTO.getDateCreated());
		tmpPhysicalDisability.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpPhysicalDisability;
	}
}