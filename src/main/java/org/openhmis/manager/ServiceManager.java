package org.openhmis.manager;

import java.util.ArrayList;
import java.util.List;

import org.openhmis.vo.ServiceVO;

public class ServiceManager {

	public ServiceManager() {}

	public ServiceVO getServiceById(String enrollmentId) {
		ServiceVO serviceVO = new ServiceVO();
		return serviceVO;
	}

	public List<ServiceVO> getServicesByEnrollmentId(String enrollmentId) {
		List<ServiceVO> serviceVOs = new ArrayList<ServiceVO>();
		return serviceVOs;
	}
	
	public ServiceVO addService(ServiceVO inputVO) {
		return inputVO;
	}
	
	public ServiceVO updateService(ServiceVO inputVO) {
		// Return the resulting VO
		return inputVO;
		
	}
	
	public boolean deleteService(String serviceId) {
		return false;
	}
	
	public static ServiceVO generateServiceVO() {
		ServiceVO serviceVO = new ServiceVO();
		
		return serviceVO;
	}
	
}