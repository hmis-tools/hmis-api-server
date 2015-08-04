package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.dto.ServiceDTO;

public class ServiceManager {

	public ServiceManager() {}

	public ServiceDTO getServiceById(String enrollmentId) {
		ServiceDTO serviceDTO = new ServiceDTO();
		return serviceDTO;
	}

	public List<ServiceDTO> getServicesByEnrollmentId(String enrollmentId) {
		List<ServiceDTO> serviceDTOs = new ArrayList<ServiceDTO>();
		return serviceDTOs;
	}
	
	public ServiceDTO addService(ServiceDTO inputVO) {
		return inputVO;
	}
	
	public ServiceDTO updateService(ServiceDTO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteService(String serviceId) {
		return false;
	}
	
	public static ServiceDTO generateServiceDTO() {
		ServiceDTO serviceDTO = new ServiceDTO();
		
		return serviceDTO;
	}
	
}