package org.openhmis.generator;

public class HivAidsStatusGenerator {

	public HivAidsStatusGenerator() {
	}
	
	public HivAidsStatusDTO generateHivAidsStatusDTO(TmpHivAidsStatus tmpHivAidsStatus) {
		HivAidsStatusDTO hivAidsStatusDTO = new HivAidsStatusDTO();

		hivAidsStatusDTO.setHivAidsStatusId(tmpHivAidsStatus.getHivAidsStatusId().toString());
		hivAidsStatusDTO.setEnrollmentId(tmpHivAidsStatus.getEnrollmentId().toString());

		// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
		hivAidsStatusDTO.setInformationDate(tmpHivAidsStatus.getInformationDate());
		hivAidsStatusDTO.setResponse(YesNoReason.valueByCode(tmpHivAidsStatus.getResponse()));
		hivAidsStatusDTO.setIndefiniteAndImpairs(YesNoReason.valueByCode(tmpHivAidsStatus.getIndefiniteAndImpairs()));
		hivAidsStatusDTO.setDocumentationOnFile(YesNo.valueByCode(tmpHivAidsStatus.getDocumentationOnFile()));
		hivAidsStatusDTO.setReceivingServices(YesNoReason.valueByCode(tmpHivAidsStatus.getReceivingServices()));

		// Export Standard Fields
		hivAidsStatusDTO.setDateCreated(tmpHivAidsStatus.getDateCreated());
		hivAidsStatusDTO.setDateUpdated(tmpHivAidsStatus.getDateUpdated());
		
		return hivAidsStatusDTO;
	}
	
	public TmpHivAidsStatus generateTmpHivAidsStatus(HivAidsStatusDTO inputDTO) {
		TmpHivAidsStatus tmpHivAidsStatus = new TmpHivAidsStatus();
		
		tmpHivAidsStatus.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: HIV/AIDS (2014, 4.8)
		tmpHivAidsStatus.setInformationDate(inputDTO.getInformationDate());
		tmpHivAidsStatus.setResponse(inputDTO.getResponse().getCode());
		tmpHivAidsStatus.setIndefiniteAndImpairs(inputDTO.getIndefiniteAndImpairs().getCode());
		tmpHivAidsStatus.setDocumentationOnFile(inputDTO.getDocumentationOnFile().getCode());
		tmpHivAidsStatus.setReceivingServices(inputDTO.getReceivingServices().getCode());

		// Export Standard Fields
		tmpHivAidsStatus.setDateCreated(inputDTO.getDateCreated());
		tmpHivAidsStatus.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpHivAidsStatus;
	}

}