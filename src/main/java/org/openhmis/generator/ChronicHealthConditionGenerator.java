package org.openhmis.generator;
	
public class ChronicHealthConditionGenerator {

	public ChronicHealthConditionGenerator() {
	}

	public ChronicHealthConditionDTO generateChronicHealthConditionDTO(TmpChronicHealthCondition tmpChronicHealthCondition) {
		ChronicHealthConditionDTO chronicHealthConditionDTO = new ChronicHealthConditionDTO();

		chronicHealthConditionDTO.setChronicHealthConditionId(tmpChronicHealthCondition.getChronicHealthConditionId().toString());
		chronicHealthConditionDTO.setEnrollmentId(tmpChronicHealthCondition.getEnrollmentId().toString());

		// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
		chronicHealthConditionDTO.setInformationDate(tmpChronicHealthCondition.getInformationDate());
		chronicHealthConditionDTO.setResponse(YesNoReason.valueByCode(tmpChronicHealthCondition.getResponse()));
		chronicHealthConditionDTO.setIndefiniteAndImpairs(YesNoReason.valueByCode(tmpChronicHealthCondition.getIndefiniteAndImpairs()));
		chronicHealthConditionDTO.setDocumentationOnFile(YesNo.valueByCode(tmpChronicHealthCondition.getDocumentationOnFile()));
		chronicHealthConditionDTO.setReceivingServices(YesNoReason.valueByCode(tmpChronicHealthCondition.getReceivingServices()));

		// Export Standard Fields
		chronicHealthConditionDTO.setDateCreated(tmpChronicHealthCondition.getDateCreated());
		chronicHealthConditionDTO.setDateUpdated(tmpChronicHealthCondition.getDateUpdated());
		
		return chronicHealthConditionDTO;
	}
	
	public TmpChronicHealthCondition generateTmpChronicHealthCondition(ChronicHealthConditionDTO inputDTO) {
		TmpChronicHealthCondition tmpChronicHealthCondition = new TmpChronicHealthCondition();
		
		tmpChronicHealthCondition.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// Program Specific Data Standards: Chronic Health Condition (2014, 4.7)
		tmpChronicHealthCondition.setInformationDate(inputDTO.getInformationDate());
		tmpChronicHealthCondition.setResponse(inputDTO.getResponse().getCode());
		tmpChronicHealthCondition.setIndefiniteAndImpairs(inputDTO.getIndefiniteAndImpairs().getCode());
		tmpChronicHealthCondition.setDocumentationOnFile(inputDTO.getDocumentationOnFile().getCode());
		tmpChronicHealthCondition.setReceivingServices(inputDTO.getReceivingServices().getCode());

		// Export Standard Fields
		tmpChronicHealthCondition.setDateCreated(inputDTO.getDateCreated());
		tmpChronicHealthCondition.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpChronicHealthCondition;
	}
}