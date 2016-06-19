package org.openhmis.generator;

public class MedicalAssistanceGenerator {

	public MedicalAssistanceGenerator() {
	}
	
	public MedicalAssistanceDTO generateMedicalAssistanceDTO(TmpMedicalAssistance tmpMedicalAssistance) {
		MedicalAssistanceDTO medicalAssistanceDTO = new MedicalAssistanceDTO();

		medicalAssistanceDTO.setMedicalAssistanceId(tmpMedicalAssistance.getMedicalAssistanceId().toString());
		medicalAssistanceDTO.setEnrollmentId(tmpMedicalAssistance.getEnrollmentId().toString());

		// HOPWA Specific Data Standards: Medical Assistance (2014, 4.39)
		medicalAssistanceDTO.setInformationDate(tmpMedicalAssistance.getInformationDate());
		medicalAssistanceDTO.setHivAidsAssistance(YesNoReason.valueByCode(tmpMedicalAssistance.getHivAidsAssistance()));
		medicalAssistanceDTO.setNoHivAidsAssistanceReason(ClientNoAssistanceReason.valueByCode(tmpMedicalAssistance.getNoHivAidsAssistanceReason()));
		medicalAssistanceDTO.setAdap(YesNoReason.valueByCode(tmpMedicalAssistance.getAdap()));
		medicalAssistanceDTO.setNoAdapReason(ClientNoAssistanceReason.valueByCode(tmpMedicalAssistance.getNoAdapReason()));

		// Export Standard Fields
		medicalAssistanceDTO.setDateCreated(tmpMedicalAssistance.getDateCreated());
		medicalAssistanceDTO.setDateUpdated(tmpMedicalAssistance.getDateUpdated());
		
		return medicalAssistanceDTO;
	}
	
	public TmpMedicalAssistance generateTmpMedicalAssistance(MedicalAssistanceDTO inputDTO) {
		TmpMedicalAssistance tmpMedicalAssistance = new TmpMedicalAssistance();
		
		tmpMedicalAssistance.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));

		// HOPWA Specific Data Standards: Medical Assistance (2014, 4.39)
		tmpMedicalAssistance.setInformationDate(inputDTO.getInformationDate());
		tmpMedicalAssistance.setHivAidsAssistance(inputDTO.getHivAidsAssistance().getCode());
		tmpMedicalAssistance.setNoHivAidsAssistanceReason(inputDTO.getNoHivAidsAssistanceReason().getCode());
		tmpMedicalAssistance.setAdap(inputDTO.getAdap().getCode());
		tmpMedicalAssistance.setNoAdapReason(inputDTO.getNoAdapReason().getCode());

		// Export Standard Fields
		tmpMedicalAssistance.setDateCreated(inputDTO.getDateCreated());
		tmpMedicalAssistance.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpMedicalAssistance;
	}
}