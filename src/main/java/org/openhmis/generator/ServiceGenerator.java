package org.openhmis.generator;

public class ServiceGenerator {

	public ServiceGenerator() {
	}
	
	public ServiceDTO generateServiceDTO(TmpService tmpService) {
		ServiceDTO serviceDTO = new ServiceDTO();

		serviceDTO.setServiceId(tmpService.getServiceId().toString());
		serviceDTO.setEnrollmentId(tmpService.getEnrollmentId().toString());
		
		// PATH (2014, 4.14A)
		serviceDTO.setPathTypeProvided(ClientPathServices.valueByCode(tmpService.getPathTypeProvided()));
		
		// RHY (2014, 4.14B)
		serviceDTO.setRhyTypeProvided(ClientRhyServices.valueByCode(tmpService.getRhyTypeProvided()));
		
		// HOPWA (2014, 4.14C)
		serviceDTO.setHopwaTypeProvided(ClientHopwaServices.valueByCode(tmpService.getHopwaTypeProvided()));
		
		// SSVF (2014, 4.14D)
		serviceDTO.setSsvfTypeProvided(ClientSsvfServices.valueByCode(tmpService.getSsvfTypeProvided()));
		serviceDTO.setSsvfVaSubTypeProvided(ClientSsvfSubType3.valueByCode(tmpService.getSsvfVaSubTypeProvided()));
		serviceDTO.setSsvfCoordinatingSubTypeProvided(ClientSsvfSubType4.valueByCode(tmpService.getSsvfCoordinatingSubTypeProvided()));
		serviceDTO.setSsvfDirectSubTypeProvided(ClientSsvfSubType5.valueByCode(tmpService.getSsvfDirectSubTypeProvided()));
		serviceDTO.setSsvfOtherService(tmpService.getSsvfOtherService());

		// Export Standard Fields
		serviceDTO.setDateCreated(tmpService.getDateCreated());
		serviceDTO.setDateUpdated(tmpService.getDateUpdated());
		
		return serviceDTO;
	}
	
	public TmpService generateTmpService(ServiceDTO inputDTO) {
		TmpService tmpService = new TmpService();
		
		tmpService.setEnrollmentId(Integer.parseInt(inputDTO.getEnrollmentId()));
		
		// PATH (2014, 4.14A)
		tmpService.setPathTypeProvided(inputDTO.getPathTypeProvided().getCode());

		// RHY (2014, 4.14B)
		tmpService.setRhyTypeProvided(inputDTO.getRhyTypeProvided().getCode());

		// HOPWA (2014, 4.14C)
		tmpService.setHopwaTypeProvided(inputDTO.getHopwaTypeProvided().getCode());

		// SSVF (2014, 4.14D)
		tmpService.setSsvfTypeProvided(inputDTO.getSsvfTypeProvided().getCode());
		tmpService.setSsvfVaSubTypeProvided(inputDTO.getSsvfVaSubTypeProvided().getCode());
		tmpService.setSsvfCoordinatingSubTypeProvided(inputDTO.getSsvfCoordinatingSubTypeProvided().getCode());
		tmpService.setSsvfDirectSubTypeProvided(inputDTO.getSsvfDirectSubTypeProvided().getCode());
		tmpService.setSsvfOtherService(inputDTO.getSsvfOtherService());

		// Export Standard Fields
		tmpService.setDateCreated(inputDTO.getDateCreated());
		tmpService.setDateUpdated(inputDTO.getDateUpdated());
		
		return tmpService;
	}
}