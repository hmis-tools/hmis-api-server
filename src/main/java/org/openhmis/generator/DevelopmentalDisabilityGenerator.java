
package org.openhmis.generator;

public class DevelopmentalDisabilityGenerator {

	public DevelopmentalDisabilityGenerator() {
	}

	public DevelopmentalDisabilityDTO generateDevelopmentalDisabilityDTO(TmpDevelopmentalDisability tmpDevelopmentalDisability) {
		DevelopmentalDisabilityDTO developmentalDisabilityDTO = new DevelopmentalDisabilityDTO();

		developmentalDisabilityDTO.setDevelopmentalDisabilityId(tmpDevelopmentalDisability.getDevelopmentalDisabilityId().toString());
		developmentalDisabilityDTO.setEnrollmentId(tmpDevelopmentalDisability.getEnrollmentId().toString());

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		developmentalDisabilityDTO.setInformationDate(tmpDevelopmentalDisability.getInformationDate());
		developmentalDisabilityDTO.setResponse(YesNoReason.valueByCode(tmpDevelopmentalDisability.getResponse()));
		developmentalDisabilityDTO.setIndefiniteAndImpairs(YesNoReason.valueByCode(tmpDevelopmentalDisability.getIndefiniteAndImpairs()));
		developmentalDisabilityDTO.setDocumentationOnFile(YesNo.valueByCode(tmpDevelopmentalDisability.getDocumentationOnFile()));
		developmentalDisabilityDTO.setReceivingServices(YesNoReason.valueByCode(tmpDevelopmentalDisability.getReceivingServices()));

		// Export Standard Fields
		developmentalDisabilityDTO.setDateCreated(tmpDevelopmentalDisability.getDateCreated());
		developmentalDisabilityDTO.setDateUpdated(tmpDevelopmentalDisability.getDateUpdated());
		
		return developmentalDisabilityDTO;
	}
	
	public TmpDevelopmentalDisability generateTmpDevelopmentalDisability(DevelopmentalDisabilityDTO inputDTO) {
		TmpDevelopmentalDisability tmpDevelopmentalDisability = new TmpDevelopmentalDisability();
		
		tmpDevelopmentalDisability.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Physical Disability (2014, 4.5)
		tmpDevelopmentalDisability.setInformationDate(inputDTO.getInformationDate());
		tmpDevelopmentalDisability.setResponse(inputDTO.getResponse().getCode());
		tmpDevelopmentalDisability.setIndefiniteAndImpairs(inputDTO.getIndefiniteAndImpairs().getCode());
		tmpDevelopmentalDisability.setDocumentationOnFile(inputDTO.getDocumentationOnFile().getCode());
		tmpDevelopmentalDisability.setReceivingServices(inputDTO.getReceivingServices().getCode());

		// Export Standard Fields
		tmpDevelopmentalDisability.setDateCreated(inputDTO.getDateCreated());
		tmpDevelopmentalDisability.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpDevelopmentalDisability;
	}

}