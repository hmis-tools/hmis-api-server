package org.openhmis.generator;

public class FinanialAssistanceGenerator {

	public FinanialAssistanceGenerator() {
	}
	
	public FinancialAssistanceDTO generateFinancialAssistanceDTO(TmpFinancialAssistance tmpFinancialAssistance) {
		FinancialAssistanceDTO financialAssistanceDTO = new FinancialAssistanceDTO();

		financialAssistanceDTO.setFinancialAssistanceId(tmpFinancialAssistance.getFinancialAssistanceId().toString());
		financialAssistanceDTO.setEnrollmentId(tmpFinancialAssistance.getEnrollmentId().toString());

		// HOPWA (2014, 4.15A)
		financialAssistanceDTO.setHopwaTypeProvided(ClientHopwaFinancialAssistance.valueByCode(tmpFinancialAssistance.getHopwaTypeProvided()));
		financialAssistanceDTO.setHopwaFaaAmount(tmpFinancialAssistance.getHopwaFaaAmount().longValue());

		// SSVF (2014, 4.15B)
		financialAssistanceDTO.setSsvfTypeProvided(ClientSsvfFinancialAssistance.valueByCode(tmpFinancialAssistance.getSsvfTypeProvided()));
		financialAssistanceDTO.setSsvfFaaAmount(tmpFinancialAssistance.getSsvfFaaAmount().longValue());

		// Export Standard Fields
		financialAssistanceDTO.setDateCreated(tmpFinancialAssistance.getDateCreated());
		financialAssistanceDTO.setDateUpdated(tmpFinancialAssistance.getDateUpdated());
		
		return financialAssistanceDTO;
	}
	
	public TmpFinancialAssistance generateTmpFinancialAssistance(FinancialAssistanceDTO inputDTO) {
		TmpFinancialAssistance tmpFinancialAssistance = new TmpFinancialAssistance();
		
		tmpFinancialAssistance.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));
		// HOPWA (2014, 4.15A)
		tmpFinancialAssistance.setHopwaTypeProvided(inputDTO.getHopwaTypeProvided().getCode());
		tmpFinancialAssistance.setHopwaFaaAmount(inputDTO.getHopwaFaaAmount().intValue());

		// SSVF (2014, 4.15B)
		tmpFinancialAssistance.setSsvfTypeProvided(inputDTO.getSsvfTypeProvided().getCode());
		tmpFinancialAssistance.setSsvfFaaAmount(inputDTO.getSsvfFaaAmount().intValue());

		// Export Standard Fields
		tmpFinancialAssistance.setDateCreated(inputDTO.getDateCreated());
		tmpFinancialAssistance.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpFinancialAssistance;
	}

}