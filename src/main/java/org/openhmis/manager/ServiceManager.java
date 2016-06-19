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
	private TmpServiceDAO tmpServiceDAO = new TmpServiceDAO();

	public ServiceManager() {
		this.tmpServiceDAO = new TmpServiceDAO();
	}

	public ServiceManager(TmpServiceDAO tmpServiceDAO) {
		this.tmpServiceDAO = tmpServiceDAO;
	}

	public ServiceDTO getServiceById(String serviceId) {
		ServiceDTO serviceDTO = ServiceManager.generateServiceDTO(tmpServiceDAO.getTmpServiceById(Integer.parseInt(serviceId)));
		return serviceDTO;
	}

	public List<ServiceDTO> getServices(ServiceSearchDTO searchDTO) {
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

	public ServiceDTO addService(ServiceDTO inputDTO) {
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
	
	public ServiceDTO updateService(ServiceDTO inputDTO) {
		// Generate a Service from the input
		TmpService tmpService = ServiceManager.generateTmpService(inputDTO);
		tmpService.setServiceId(Integer.parseInt(inputDTO.getServiceId()));
		tmpService.setDateUpdated(new Date());
		
		// Update the object
		tmpServiceDAO.update(tmpService);
		
		// Return the resulting VO
		return ServiceManager.generateServiceDTO(tmpService);

	}
	
	public boolean deleteService(String serviceId) {
		TmpService tmpService = tmpServiceDAO.getTmpServiceById(Integer.parseInt(serviceId));
		tmpServiceDAO.delete(tmpService);
		return true;
	}
	
}
