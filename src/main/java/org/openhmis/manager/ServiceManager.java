package org.openhmis.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openhmis.code.ClientHopwaServices;
import org.openhmis.code.ClientPathServices;
import org.openhmis.code.ClientRhyServices;
import org.openhmis.code.ClientSsvfServices;
import org.openhmis.code.ClientSsvfSubType3;
import org.openhmis.code.ClientSsvfSubType4;
import org.openhmis.code.ClientSsvfSubType5;
import org.openhmis.code.ProjectAvailability;
import org.openhmis.code.ProjectBedType;
import org.openhmis.code.ProjectHouseholdType;
import org.openhmis.code.ProjectYouthAgeGroup;
import org.openhmis.dao.TmpServiceDAO;
import org.openhmis.domain.TmpProject;
import org.openhmis.domain.TmpService;
import org.openhmis.dto.CoCDTO;
import org.openhmis.dto.FunderDTO;
import org.openhmis.dto.ServiceDTO;
import org.openhmis.dto.search.ServiceSearchDTO;

public class ServiceManager {
	private static final TmpServiceDAO tmpServiceDAO = new TmpServiceDAO();

	public ServiceManager() {}

	public static ServiceDTO getServiceById(String serviceId) {
		ServiceDTO serviceDTO = ServiceManager.generateServiceDTO(tmpServiceDAO.getTmpServiceById(Integer.parseInt(serviceId)));
		return serviceDTO;
	}

	public static List<ServiceDTO> getServices(ServiceSearchDTO searchDTO) {
		List<ServiceDTO> serviceDTOs = new ArrayList<ServiceDTO>();

		// Collect the services
		List<TmpService> tmpServices = tmpServiceDAO.getTmpServices(searchDTO);

		// For each service, collect and map the data
		for (Iterator<TmpService> iterator = tmpServices.iterator(); iterator.hasNext();) {
			TmpService tmpService = iterator.next();
			ServiceDTO serviceDTO = ServiceManager.generateServiceDTO(tmpService);
			serviceDTOs.add(serviceDTO);
		}
		return serviceDTOs;

	}

	public static List<ServiceDTO> getServices(Date updateDate) {
		List<ServiceDTO> serviceDTOs = new ArrayList<ServiceDTO>();

		// Collect the services
		List<TmpService> tmpServices = tmpServiceDAO.getTmpServices(updateDate);

		// For each service, collect and map the data
		for (Iterator<TmpService> iterator = tmpServices.iterator(); iterator.hasNext();) {
			TmpService tmpService = iterator.next();
			ServiceDTO serviceDTO = ServiceManager.generateServiceDTO(tmpService);
			serviceDTOs.add(serviceDTO);
		}
		return serviceDTOs;

	}

	public static List<ServiceDTO> getServicesByEnrollmentId(String enrollmentId) {
		List<ServiceDTO> serviceDTOs = new ArrayList<ServiceDTO>();

		// Collect the services
		List<TmpService> tmpServices = tmpServiceDAO.getTmpServicesByEnrollmentId(Integer.parseInt(enrollmentId));

		// For each service, collect and map the data
		for (Iterator<TmpService> iterator = tmpServices.iterator(); iterator.hasNext();) {
			TmpService tmpService = iterator.next();
			ServiceDTO serviceDTO = ServiceManager.generateServiceDTO(tmpService);
			serviceDTOs.add(serviceDTO);
		}
		return serviceDTOs;

	}

	public static List<ServiceDTO> getServicesByEnrollmentId(String enrollmentId, Date updateDate) {
		List<ServiceDTO> serviceDTOs = new ArrayList<ServiceDTO>();

		// Collect the services
		List<TmpService> tmpServices = tmpServiceDAO.getTmpServicesByEnrollmentId(Integer.parseInt(enrollmentId), updateDate);

		// For each service, collect and map the data
		for (Iterator<TmpService> iterator = tmpServices.iterator(); iterator.hasNext();) {
			TmpService tmpService = iterator.next();
			ServiceDTO serviceDTO = ServiceManager.generateServiceDTO(tmpService);
			serviceDTOs.add(serviceDTO);
		}
		return serviceDTOs;

	}
	
	public static ServiceDTO addService(ServiceDTO inputDTO) {
		// Generate a PathClient from the input
		TmpService tmpService = ServiceManager.generateTmpService(inputDTO);
		
		// Set Export fields
		tmpService.setDateCreated(new Date());
		tmpService.setDateUpdated(new Date());
		
		// Save the client to allow secondary object generation
		tmpServiceDAO.save(tmpService);
		inputDTO.setServiceId(tmpService.getServiceId().toString());
		
		// Return the resulting VO
		return ServiceManager.generateServiceDTO(tmpService);
	}
	
	public static ServiceDTO updateService(ServiceDTO inputDTO) {
		// Generate a Service from the input
		TmpService tmpService = ServiceManager.generateTmpService(inputDTO);
		tmpService.setServiceId(Integer.parseInt(inputDTO.getServiceId()));
		tmpService.setDateUpdated(new Date());
		
		// Update the object
		tmpServiceDAO.update(tmpService);
		
		// Return the resulting VO
		return ServiceManager.generateServiceDTO(tmpService);

	}
	
	public static boolean deleteService(String serviceId) {
		TmpService tmpService = tmpServiceDAO.getTmpServiceById(Integer.parseInt(serviceId));
		tmpServiceDAO.delete(tmpService);
		return true;
	}
	
	public static ServiceDTO generateServiceDTO(TmpService tmpService) {
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
	
	public static TmpService generateTmpService(ServiceDTO inputDTO) {
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
