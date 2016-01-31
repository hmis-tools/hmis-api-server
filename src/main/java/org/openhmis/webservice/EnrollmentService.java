package org.openhmis.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.dto.ChronicHealthConditionDTO;
import org.openhmis.dto.ContactDTO;
import org.openhmis.dto.DevelopmentalDisabilityDTO;
import org.openhmis.dto.DomesticAbuseDTO;
import org.openhmis.dto.EnrollmentDTO;
import org.openhmis.dto.ExitDTO;
import org.openhmis.dto.FinancialAssistanceDTO;
import org.openhmis.dto.HealthInsuranceDTO;
import org.openhmis.dto.HivAidsStatusDTO;
import org.openhmis.dto.IncomeSourceDTO;
import org.openhmis.dto.MedicalAssistanceDTO;
import org.openhmis.dto.NonCashBenefitDTO;
import org.openhmis.dto.PhysicalDisabilityDTO;
import org.openhmis.dto.ReferralDTO;
import org.openhmis.dto.ServiceDTO;
import org.openhmis.dto.SubstanceAbuseDTO;
import org.openhmis.manager.ChronicHealthConditionManager;
import org.openhmis.manager.ClientManager;
import org.openhmis.manager.ContactManager;
import org.openhmis.manager.DevelopmentalDisabilityManager;
import org.openhmis.manager.DomesticAbuseManager;
import org.openhmis.manager.EnrollmentManager;
import org.openhmis.manager.ExitManager;
import org.openhmis.manager.FinancialAssistanceManager;
import org.openhmis.manager.HealthInsuranceManager;
import org.openhmis.manager.HivAidsStatusManager;
import org.openhmis.manager.IncomeSourceManager;
import org.openhmis.manager.MedicalAssistanceManager;
import org.openhmis.manager.MentalHealthProblemManager;
import org.openhmis.manager.NonCashBenefitManager;
import org.openhmis.manager.PhysicalDisabilityManager;
import org.openhmis.manager.ReferralManager;
import org.openhmis.manager.ServiceManager;
import org.openhmis.manager.SubstanceAbuseManager;
import org.openhmis.util.Authentication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/enrollments")
public class EnrollmentService {
	private static final ObjectMapper om = new ObjectMapper();
	private static final EnrollmentManager enrollmentManager = new EnrollmentManager();

	public EnrollmentService() {}


	/* Enrollment Entity Endpoints */
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<EnrollmentDTO> getEnrollments(@HeaderParam("Authorization") String authorization) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<EnrollmentDTO> enrollmentDTOs = enrollmentManager.getEnrollments();
		return enrollmentDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public EnrollmentDTO getClient(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		EnrollmentDTO enrollmentDTO = enrollmentManager.getEnrollmentById(enrollmentId);
		return enrollmentDTO;
	}

	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public EnrollmentDTO createEnrollment(@HeaderParam("Authorization") String authorization, String data) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		// This endpoint takes in a raw json STRING as input.
		// TODO: support the serialization of individual POST parameters
		EnrollmentDTO inputVO = om.readValue(data, EnrollmentDTO.class);
		EnrollmentDTO outputVO = enrollmentManager.addEnrollment(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public EnrollmentDTO updateEnrollment(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		EnrollmentDTO inputVO = om.readValue(data, EnrollmentDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		
		EnrollmentDTO outputVO = enrollmentManager.updateEnrollment(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteEnrollment(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		enrollmentManager.deleteEnrollment(enrollmentId);
		return "true";
	}
	
	
	/* Exit Endpoints */
	@GET
	@Path("/{enrollmentId}/exits")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ExitDTO> getExits(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		// Exits are weird because right now only one can exist but they are still separate...
		// TODO: figure out whether or not we want exists to have history
		List<ExitDTO> exitDTOs = new ArrayList<ExitDTO>();
		exitDTOs.add(ExitManager.getExitByEnrollmentId(enrollmentId));
		return exitDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/exits/{exitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ExitDTO getExit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("exitId") String exitId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ExitDTO exitDTO = ExitManager.getExitById(exitId);
		return exitDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/exits")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ExitDTO createExit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ExitDTO inputVO = om.readValue(data, ExitDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ExitDTO outputVO = ExitManager.addExit(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/exits/{exitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ExitDTO updateExit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("exitId") String exitId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ExitDTO inputVO = om.readValue(data, ExitDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setExitId(exitId);

		ExitDTO outputVO = ExitManager.updateExit(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/exits/{exitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteExit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("exitId") String exitId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ExitManager.deleteExit(exitId);
		return "true";
	}


	/* Chronic Health Condition Endpoints */
	@GET
	@Path("/{enrollmentId}/chronic-health-conditions")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ChronicHealthConditionDTO> getChronicHealthConditions(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = ChronicHealthConditionManager.getChronicHealthConditionsByEnrollmentId(enrollmentId);
		return chronicHealthConditionDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/chronic-health-conditions/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ChronicHealthConditionDTO getChronicHealthCondition(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("chronicHealthConditionId") String chronicHealthConditionId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ChronicHealthConditionDTO chronicHealthConditionDTO = ChronicHealthConditionManager.getChronicHealthConditionById(chronicHealthConditionId);
		return chronicHealthConditionDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/chronic-health-conditions")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ChronicHealthConditionDTO createChronicHealthCondition(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ChronicHealthConditionDTO inputVO = om.readValue(data, ChronicHealthConditionDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ChronicHealthConditionDTO outputVO = ChronicHealthConditionManager.addChronicHealthCondition(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/chronic-health-conditions/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ChronicHealthConditionDTO updateChronicHealthCondition(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("chronicHealthConditionId") String chronicHealthConditionId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ChronicHealthConditionDTO inputVO = om.readValue(data, ChronicHealthConditionDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setChronicHealthConditionId(chronicHealthConditionId);

		ChronicHealthConditionDTO outputVO = ChronicHealthConditionManager.updateChronicHealthCondition(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/chronic-health-conditions/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteChronicHealthCondition(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("chronicHealthConditionId") String chronicHealthConditionId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ChronicHealthConditionManager.deleteChronicHealthCondition(chronicHealthConditionId);
		return "true";
	}


	/* Contact Endpoints */
	@GET
	@Path("/{enrollmentId}/contacts")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ContactDTO> getContacts(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<ContactDTO> contactDTOs = ContactManager.getContactsByEnrollmentId(enrollmentId);
		return contactDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/contacts/{contactId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ContactDTO getContact(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("contactId") String contactId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ContactDTO contactDTO = ContactManager.getContactById(contactId);
		return contactDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/contacts")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ContactDTO createContact(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ContactDTO inputVO = om.readValue(data, ContactDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ContactDTO outputVO = ContactManager.addContact(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/contacts/{contactId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ContactDTO updateContact(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("contactId") String contactId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ContactDTO inputVO = om.readValue(data, ContactDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setContactId(contactId);

		ContactDTO outputVO = ContactManager.updateContact(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/contacts/{contactId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteContact(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("contactId") String contactId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ContactManager.deleteContact(contactId);
		return "true";
	}


	/* Developmental Disability Endpoints */
	@GET
	@Path("/{enrollmentId}/developmental-disabilities")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<DevelopmentalDisabilityDTO> getDevelopmentalDisabilities(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = DevelopmentalDisabilityManager.getDevelopmentalDisabilitiesByEnrollmentId(enrollmentId);
		return developmentalDisabilityDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/developmental-disabilities/{developmentalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DevelopmentalDisabilityDTO getDevelopmentalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("developmentalDisabilityId") String developmentalDisabilityId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		DevelopmentalDisabilityDTO developmentalDisabilityDTO = DevelopmentalDisabilityManager.getDevelopmentalDisabilityById(developmentalDisabilityId);
		return developmentalDisabilityDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/developmental-disabilities")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DevelopmentalDisabilityDTO createDevelopmentalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		DevelopmentalDisabilityDTO inputVO = om.readValue(data, DevelopmentalDisabilityDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		DevelopmentalDisabilityDTO outputVO = DevelopmentalDisabilityManager.addDevelopmentalDisability(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/developmental-disabilities/{developmentalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DevelopmentalDisabilityDTO updateDevelopmentalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("developmentalDisabilityId") String developmentalDisabilityId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		DevelopmentalDisabilityDTO inputVO = om.readValue(data, DevelopmentalDisabilityDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setDevelopmentalDisabilityId(developmentalDisabilityId);

		DevelopmentalDisabilityDTO outputVO = DevelopmentalDisabilityManager.updateDevelopmentalDisability(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/developmental-disabilities/{developmentalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteDevelopmentalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("developmentalDisabilityId") String developmentalDisabilityId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		DevelopmentalDisabilityManager.deleteDevelopmentalDisability(developmentalDisabilityId);
		return "true";
	}


	/* Domestic Abuse Endpoints */
	@GET
	@Path("/{enrollmentId}/domestic-abuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<DomesticAbuseDTO> getDomesticAbuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<DomesticAbuseDTO> domesticAbuseDTOs = DomesticAbuseManager.getDomesticAbusesByEnrollmentId(enrollmentId);
		return domesticAbuseDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/domestic-abuses/{domesticAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DomesticAbuseDTO getDomesticAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("domesticAbuseId") String domesticAbuseId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		DomesticAbuseDTO domesticAbuseDTO = DomesticAbuseManager.getDomesticAbuseById(domesticAbuseId);
		return domesticAbuseDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/domestic-abuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DomesticAbuseDTO createDomesticAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		DomesticAbuseDTO inputVO = om.readValue(data, DomesticAbuseDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		DomesticAbuseDTO outputVO = DomesticAbuseManager.addDomesticAbuse(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/domestic-abuses/{domesticAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DomesticAbuseDTO updateDomesticAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("domesticAbuseId") String domesticAbuseId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		DomesticAbuseDTO inputVO = om.readValue(data, DomesticAbuseDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setDomesticAbuseId(domesticAbuseId);

		DomesticAbuseDTO outputVO = DomesticAbuseManager.updateDomesticAbuse(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/domestic-abuses/{domesticAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteDomesticAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("domesticAbuseId") String domesticAbuseId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		DomesticAbuseManager.deleteDomesticAbuse(domesticAbuseId);
		return "true";
	}


	/* Financial Assistance Endpoints */
	@GET
	@Path("/{enrollmentId}/financial-assitances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<FinancialAssistanceDTO> getFinancialAssistances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<FinancialAssistanceDTO> financialAssistanceDTOs = FinancialAssistanceManager.getFinancialAssistancesByEnrollmentId(enrollmentId);
		return financialAssistanceDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/financial-assitances/{financialAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FinancialAssistanceDTO getFinancialAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("financialAssistanceId") String financialAssistanceId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		FinancialAssistanceDTO financialAssistanceDTO = FinancialAssistanceManager.getFinancialAssistanceById(financialAssistanceId);
		return financialAssistanceDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/financial-assitances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FinancialAssistanceDTO createFinancialAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		FinancialAssistanceDTO inputVO = om.readValue(data, FinancialAssistanceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		FinancialAssistanceDTO outputVO = FinancialAssistanceManager.addFinancialAssistance(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/financial-assitances/{financialAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FinancialAssistanceDTO updateFinancialAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("financialAssistanceId") String financialAssistanceId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		FinancialAssistanceDTO inputVO = om.readValue(data, FinancialAssistanceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setFinancialAssistanceId(financialAssistanceId);

		FinancialAssistanceDTO outputVO = FinancialAssistanceManager.updateFinancialAssistance(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/financial-assitances/{financialAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteFinancialAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("financialAssistanceId") String financialAssistanceId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		FinancialAssistanceManager.deleteFinancialAssistance(financialAssistanceId);
		return "true";
	}

	/* Health Insurance Endpoints */
	@GET
	@Path("/{enrollmentId}/health-insurances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<HealthInsuranceDTO> getHealthInsurances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<HealthInsuranceDTO> healthInsuranceDTOs = HealthInsuranceManager.getHealthInsurancesByEnrollmentId(enrollmentId);
		return healthInsuranceDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/health-insurances/{healthInsuranceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HealthInsuranceDTO getHealthInsurance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("healthInsuranceId") String healthInsuranceId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		HealthInsuranceDTO healthInsuranceDTO = HealthInsuranceManager.getHealthInsuranceById(healthInsuranceId);
		return healthInsuranceDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/health-insurances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HealthInsuranceDTO createHealthInsurance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		HealthInsuranceDTO inputVO = om.readValue(data, HealthInsuranceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		HealthInsuranceDTO outputVO = HealthInsuranceManager.addHealthInsurance(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/health-insurances/{healthInsuranceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HealthInsuranceDTO updateHealthInsurance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("healthInsuranceId") String healthInsuranceId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		HealthInsuranceDTO inputVO = om.readValue(data, HealthInsuranceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setHealthInsuranceId(healthInsuranceId);

		HealthInsuranceDTO outputVO = HealthInsuranceManager.updateHealthInsurance(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/health-insurances/{healthInsuranceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteHealthInsurance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("healthInsuranceId") String healthInsuranceId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		HealthInsuranceManager.deleteHealthInsurance(healthInsuranceId);
		return "true";
	}

	/* HIV Aids Endpoints */
	@GET
	@Path("/{enrollmentId}/hiv-aids-statuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<HivAidsStatusDTO> getHivAidsStatuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<HivAidsStatusDTO> hivAidsStatusDTOs = HivAidsStatusManager.getHivAidsStatusesByEnrollmentId(enrollmentId);
		return hivAidsStatusDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/hiv-aids-statuses/{hivAidsStatusId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HivAidsStatusDTO getHivAidsStatus(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("hivAidsStatusId") String hivAidsStatusId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		HivAidsStatusDTO hivAidsStatusDTO = HivAidsStatusManager.getHivAidsStatusById(hivAidsStatusId);
		return hivAidsStatusDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/hiv-aids-statuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HivAidsStatusDTO createHivAidsStatus(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		HivAidsStatusDTO inputVO = om.readValue(data, HivAidsStatusDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		HivAidsStatusDTO outputVO = HivAidsStatusManager.addHivAidsStatus(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/hiv-aids-statuses/{hivAidsStatusId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HivAidsStatusDTO updateHivAidsStatus(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("hivAidsStatusId") String hivAidsStatusId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		HivAidsStatusDTO inputVO = om.readValue(data, HivAidsStatusDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setHivAidsStatusId(hivAidsStatusId);

		HivAidsStatusDTO outputVO = HivAidsStatusManager.updateHivAidsStatus(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/hiv-aids-statuses/{hivAidsStatusId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteHivAidsStatus(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("hivAidsStatusId") String hivAidsStatusId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		HivAidsStatusManager.deleteHivAidsStatus(hivAidsStatusId);
		return "true";
	}

	/* Medical Assistance Endpoints */
	@GET
	@Path("/{enrollmentId}/medical-assistances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<MedicalAssistanceDTO> getMedicalAssistances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<MedicalAssistanceDTO> medicalAssistanceDTOs = MedicalAssistanceManager.getMedicalAssistancesByEnrollmentId(enrollmentId);
		return medicalAssistanceDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/medical-assistances/{medicalAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public MedicalAssistanceDTO getMedicalAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("medicalAssistanceId") String medicalAssistanceId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		MedicalAssistanceDTO medicalAssistanceDTO = MedicalAssistanceManager.getMedicalAssistanceById(medicalAssistanceId);
		return medicalAssistanceDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/medical-assistances")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public MedicalAssistanceDTO createMedicalAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		MedicalAssistanceDTO inputVO = om.readValue(data, MedicalAssistanceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		MedicalAssistanceDTO outputVO = MedicalAssistanceManager.addMedicalAssistance(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/medical-assistances/{medicalAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public MedicalAssistanceDTO updateMedicalAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("medicalAssistanceId") String medicalAssistanceId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		MedicalAssistanceDTO inputVO = om.readValue(data, MedicalAssistanceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setMedicalAssistanceId(medicalAssistanceId);

		MedicalAssistanceDTO outputVO = MedicalAssistanceManager.updateMedicalAssistance(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/medical-assistances/{medicalAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteMedicalAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("medicalAssistanceId") String medicalAssistanceId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		MedicalAssistanceManager.deleteMedicalAssistance(medicalAssistanceId);
		return "true";
	}

	/* Income Source Endpoints */
	@GET
	@Path("/{enrollmentId}/income-sources")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<IncomeSourceDTO> getIncomeSources(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<IncomeSourceDTO> incomeSourceDTOs = IncomeSourceManager.getIncomeSourcesByEnrollmentId(enrollmentId);
		return incomeSourceDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/income-sources/{incomeSourceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public IncomeSourceDTO getIncomeSource(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("incomeSourceId") String incomeSourceId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		IncomeSourceDTO incomeSourceDTO = IncomeSourceManager.getIncomeSourceById(incomeSourceId);
		return incomeSourceDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/income-sources")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public IncomeSourceDTO createIncomeSource(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		IncomeSourceDTO inputVO = om.readValue(data, IncomeSourceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		IncomeSourceDTO outputVO = IncomeSourceManager.addIncomeSource(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/income-sources/{incomeSourceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public IncomeSourceDTO updateIncomeSource(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("incomeSourceId") String incomeSourceId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		IncomeSourceDTO inputVO = om.readValue(data, IncomeSourceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setIncomeSourceId(incomeSourceId);

		IncomeSourceDTO outputVO = IncomeSourceManager.updateIncomeSource(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/income-sources/{incomeSourceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteIncomeSource(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("incomeSourceId") String incomeSourceId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		IncomeSourceManager.deleteIncomeSource(incomeSourceId);
		return "true";
	}

	/* NonCash Benefit Endpoints */
	@GET
	@Path("/{enrollmentId}/noncash-benefits")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<NonCashBenefitDTO> getNonCashBenefits(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<NonCashBenefitDTO> nonCashBenefitDTOs = NonCashBenefitManager.getNonCashBenefitsByEnrollmentId(enrollmentId);
		return nonCashBenefitDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/noncash-benefits/{nonCashBenefitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public NonCashBenefitDTO getNonCashBenefit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("nonCashBenefitId") String nonCashBenefitId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		NonCashBenefitDTO nonCashBenefitDTO = NonCashBenefitManager.getNonCashBenefitById(nonCashBenefitId);
		return nonCashBenefitDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/noncash-benefits")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public NonCashBenefitDTO createNonCashBenefit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		NonCashBenefitDTO inputVO = om.readValue(data, NonCashBenefitDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		NonCashBenefitDTO outputVO = NonCashBenefitManager.addNonCashBenefit(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/noncash-benefits/{nonCashBenefitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public NonCashBenefitDTO createNonCashBenefit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("nonCashBenefitId") String nonCashBenefitId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		NonCashBenefitDTO inputVO = om.readValue(data, NonCashBenefitDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setNonCashBenefitId(nonCashBenefitId);

		NonCashBenefitDTO outputVO = NonCashBenefitManager.updateNonCashBenefit(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/noncash-benefits/{nonCashBenefitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteNonCashBenefit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("nonCashBenefitId") String nonCashBenefitId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		NonCashBenefitManager.deleteNonCashBenefit(nonCashBenefitId);
		return "true";
	}

	/* Physical Disability Endpoints */
	@GET
	@Path("/{enrollmentId}/physical-disabilities")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<PhysicalDisabilityDTO> getPhysicalDisabilities(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<PhysicalDisabilityDTO> physicalDisabilityDTOs = PhysicalDisabilityManager.getPhysicalDisabilitiesByEnrollmentId(enrollmentId);
		return physicalDisabilityDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/physical-disabilities/{physicalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PhysicalDisabilityDTO getPhysicalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("physicalDisabilityId") String physicalDisabilityId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		PhysicalDisabilityDTO physicalDisabilityDTO = PhysicalDisabilityManager.getPhysicalDisabilityById(physicalDisabilityId);
		return physicalDisabilityDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/physical-disabilities")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PhysicalDisabilityDTO createPhysicalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		PhysicalDisabilityDTO inputVO = om.readValue(data, PhysicalDisabilityDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		PhysicalDisabilityDTO outputVO = PhysicalDisabilityManager.addPhysicalDisability(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/physical-disabilities/{physicalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PhysicalDisabilityDTO updatePhysicalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("physicalDisabilityId") String physicalDisabilityId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		PhysicalDisabilityDTO inputVO = om.readValue(data, PhysicalDisabilityDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setPhysicalDisabilityId(physicalDisabilityId);

		PhysicalDisabilityDTO outputVO = PhysicalDisabilityManager.updatePhysicalDisability(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/physical-disabilities/{physicalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deletePhysicalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("physicalDisabilityId") String physicalDisabilityId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		PhysicalDisabilityManager.deletePhysicalDisability(physicalDisabilityId);
		return "true";
	}

	/* Referral Endpoints */
	@GET
	@Path("/{enrollmentId}/referrals")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ReferralDTO> getReferrals(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<ReferralDTO> referralDTOs = ReferralManager.getReferralsByEnrollmentId(enrollmentId);
		return referralDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/referrals/{referralId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ReferralDTO getReferral(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("referralId") String referralId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ReferralDTO referralDTO = ReferralManager.getReferralById(referralId);
		return referralDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/referrals")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ReferralDTO createReferral(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ReferralDTO inputVO = om.readValue(data, ReferralDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ReferralDTO outputVO = ReferralManager.addReferral(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/referrals/{referralId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ReferralDTO updateReferral(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("referralId") String referralId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ReferralDTO inputVO = om.readValue(data, ReferralDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setReferralId(referralId);

		ReferralDTO outputVO = ReferralManager.updateReferral(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/referrals/{referralId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteReferral(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("referralId") String referralId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ReferralManager.deleteReferral(referralId);
		return "true";
	}

	/* Service Endpoints */
	@GET
	@Path("/{enrollmentId}/services")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ServiceDTO> getServices(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<ServiceDTO> serviceDTOs = ServiceManager.getServicesByEnrollmentId(enrollmentId);
		return serviceDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/services/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ServiceDTO getService(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("serviceId") String serviceId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ServiceDTO serviceDTO = ServiceManager.getServiceById(serviceId);
		return serviceDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/services")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ServiceDTO createService(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ServiceDTO inputVO = om.readValue(data, ServiceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ServiceDTO outputVO = ServiceManager.addService(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/services/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ServiceDTO updateService(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("serviceId") String serviceId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ServiceDTO inputVO = om.readValue(data, ServiceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setServiceId(serviceId);

		ServiceDTO outputVO = ServiceManager.updateService(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/services/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteService(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("serviceId") String serviceId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		ServiceManager.deleteService(serviceId);
		return "true";
	}

	/* Substance Abuse Endpoints */
	@GET
	@Path("/{enrollmentId}/substance-abuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<SubstanceAbuseDTO> getSubstanceAbuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		List<SubstanceAbuseDTO> substanceAbuseDTOs = SubstanceAbuseManager.getSubstanceAbusesByEnrollmentId(enrollmentId);
		return substanceAbuseDTOs;
	}
	
	@GET
	@Path("/{enrollmentId}/substance-abuses/{substanceAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SubstanceAbuseDTO getSubstanceAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("substanceAbuseId") String substanceAbuseId) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		SubstanceAbuseDTO substanceAbuseDTO = SubstanceAbuseManager.getSubstanceAbuseById(substanceAbuseId);
		return substanceAbuseDTO;
	}
	
	@POST
	@Path("/{enrollmentId}/substance-abuses")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SubstanceAbuseDTO createSubstanceAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		SubstanceAbuseDTO inputVO = om.readValue(data, SubstanceAbuseDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		SubstanceAbuseDTO outputVO = SubstanceAbuseManager.addSubstanceAbuse(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/substance-abuses/{substanceAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SubstanceAbuseDTO updateSubstanceAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("substanceAbuseId") String substanceAbuseId, String data) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		SubstanceAbuseDTO inputVO = om.readValue(data, SubstanceAbuseDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setSubstanceAbuseId(substanceAbuseId);

		SubstanceAbuseDTO outputVO = SubstanceAbuseManager.updateSubstanceAbuse(inputVO);
		return outputVO;
	}
	
	@DELETE
	@Path("/{enrollmentId}/substance-abuses/{substanceAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String deleteSubstanceAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId,  @PathParam("substanceAbuseId") String substanceAbuseId) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		SubstanceAbuseManager.deleteSubstanceAbuse(substanceAbuseId);
		return "true";
	}


}
