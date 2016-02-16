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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.openhmis.code.ClientNameDataQuality;
import org.openhmis.dto.ChronicHealthConditionDTO;
import org.openhmis.dto.ClientDTO;
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
import org.openhmis.util.DateParser;

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
	public List<EnrollmentDTO> getEnrollments(@HeaderParam("Authorization") String authorization, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<EnrollmentDTO> enrollmentDTOs = enrollmentManager.getEnrollments();
			return enrollmentDTOs;
		} else {
			List<EnrollmentDTO> enrollmentDTOs = enrollmentManager.getEnrollmentsByUpdateDate(DateParser.parseDate(updatedSince));
			return enrollmentDTOs;			
		}
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
	public EnrollmentDTO createEnrollment(@HeaderParam("Authorization") String authorization, EnrollmentDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		EnrollmentDTO outputVO = enrollmentManager.addEnrollment(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public EnrollmentDTO updateEnrollment(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, EnrollmentDTO inputVO) throws JsonParseException, JsonMappingException, IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public ExitDTO createExit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, ExitDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		ExitDTO outputVO = ExitManager.addExit(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/exits/{exitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ExitDTO updateExit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("exitId") String exitId, ExitDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<ChronicHealthConditionDTO> getChronicHealthConditions(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = ChronicHealthConditionManager.getChronicHealthConditionsByEnrollmentId(enrollmentId);
			return chronicHealthConditionDTOs;
		} else {
			List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = ChronicHealthConditionManager.getChronicHealthConditionsByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return chronicHealthConditionDTOs;
		}
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
	public ChronicHealthConditionDTO createChronicHealthCondition(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, ChronicHealthConditionDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
				inputVO.setEnrollmentId(enrollmentId);
		ChronicHealthConditionDTO outputVO = ChronicHealthConditionManager.addChronicHealthCondition(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/chronic-health-conditions/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ChronicHealthConditionDTO updateChronicHealthCondition(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("chronicHealthConditionId") String chronicHealthConditionId, ChronicHealthConditionDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<ContactDTO> getContacts(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<ContactDTO> contactDTOs = ContactManager.getContactsByEnrollmentId(enrollmentId);
			return contactDTOs;
		} else {
			List<ContactDTO> contactDTOs = ContactManager.getContactsByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return contactDTOs;			
		}
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
	public ContactDTO createContact(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, ContactDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		ContactDTO outputVO = ContactManager.addContact(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/contacts/{contactId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ContactDTO updateContact(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("contactId") String contactId, ContactDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<DevelopmentalDisabilityDTO> getDevelopmentalDisabilities(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = DevelopmentalDisabilityManager.getDevelopmentalDisabilitiesByEnrollmentId(enrollmentId);
			return developmentalDisabilityDTOs;
		} else {
			List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = DevelopmentalDisabilityManager.getDevelopmentalDisabilitiesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return developmentalDisabilityDTOs;
		}
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
	public DevelopmentalDisabilityDTO createDevelopmentalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, DevelopmentalDisabilityDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		DevelopmentalDisabilityDTO outputVO = DevelopmentalDisabilityManager.addDevelopmentalDisability(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/developmental-disabilities/{developmentalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DevelopmentalDisabilityDTO updateDevelopmentalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("developmentalDisabilityId") String developmentalDisabilityId, DevelopmentalDisabilityDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<DomesticAbuseDTO> getDomesticAbuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		
		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<DomesticAbuseDTO> domesticAbuseDTOs = DomesticAbuseManager.getDomesticAbusesByEnrollmentId(enrollmentId);
			return domesticAbuseDTOs;
		} else {
			List<DomesticAbuseDTO> domesticAbuseDTOs = DomesticAbuseManager.getDomesticAbusesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return domesticAbuseDTOs;
		}
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
	public DomesticAbuseDTO createDomesticAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, DomesticAbuseDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		DomesticAbuseDTO outputVO = DomesticAbuseManager.addDomesticAbuse(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/domestic-abuses/{domesticAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public DomesticAbuseDTO updateDomesticAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("domesticAbuseId") String domesticAbuseId, DomesticAbuseDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<FinancialAssistanceDTO> getFinancialAssistances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<FinancialAssistanceDTO> financialAssistanceDTOs = FinancialAssistanceManager.getFinancialAssistancesByEnrollmentId(enrollmentId);
			return financialAssistanceDTOs;
		} else {
			List<FinancialAssistanceDTO> financialAssistanceDTOs = FinancialAssistanceManager.getFinancialAssistancesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return financialAssistanceDTOs;
		}
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
	public FinancialAssistanceDTO createFinancialAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, FinancialAssistanceDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		FinancialAssistanceDTO outputVO = FinancialAssistanceManager.addFinancialAssistance(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/financial-assitances/{financialAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FinancialAssistanceDTO updateFinancialAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("financialAssistanceId") String financialAssistanceId, FinancialAssistanceDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<HealthInsuranceDTO> getHealthInsurances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<HealthInsuranceDTO> healthInsuranceDTOs = HealthInsuranceManager.getHealthInsurancesByEnrollmentId(enrollmentId);
			return healthInsuranceDTOs;
		} else {
			List<HealthInsuranceDTO> healthInsuranceDTOs = HealthInsuranceManager.getHealthInsurancesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return healthInsuranceDTOs;
		}
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
	public HealthInsuranceDTO createHealthInsurance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, HealthInsuranceDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		HealthInsuranceDTO outputVO = HealthInsuranceManager.addHealthInsurance(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/health-insurances/{healthInsuranceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HealthInsuranceDTO updateHealthInsurance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("healthInsuranceId") String healthInsuranceId, HealthInsuranceDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<HivAidsStatusDTO> getHivAidsStatuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<HivAidsStatusDTO> hivAidsStatusDTOs = HivAidsStatusManager.getHivAidsStatusesByEnrollmentId(enrollmentId);
			return hivAidsStatusDTOs;
		} else {
			List<HivAidsStatusDTO> hivAidsStatusDTOs = HivAidsStatusManager.getHivAidsStatusesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return hivAidsStatusDTOs;
		}
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
	public HivAidsStatusDTO createHivAidsStatus(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, HivAidsStatusDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		HivAidsStatusDTO outputVO = HivAidsStatusManager.addHivAidsStatus(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/hiv-aids-statuses/{hivAidsStatusId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HivAidsStatusDTO updateHivAidsStatus(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("hivAidsStatusId") String hivAidsStatusId, HivAidsStatusDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<MedicalAssistanceDTO> getMedicalAssistances(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<MedicalAssistanceDTO> medicalAssistanceDTOs = MedicalAssistanceManager.getMedicalAssistancesByEnrollmentId(enrollmentId);
			return medicalAssistanceDTOs;
		} else {
			List<MedicalAssistanceDTO> medicalAssistanceDTOs = MedicalAssistanceManager.getMedicalAssistancesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return medicalAssistanceDTOs;
		}
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
	public MedicalAssistanceDTO createMedicalAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, MedicalAssistanceDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		MedicalAssistanceDTO outputVO = MedicalAssistanceManager.addMedicalAssistance(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/medical-assistances/{medicalAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public MedicalAssistanceDTO updateMedicalAssistance(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("medicalAssistanceId") String medicalAssistanceId, MedicalAssistanceDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<IncomeSourceDTO> getIncomeSources(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<IncomeSourceDTO> incomeSourceDTOs = IncomeSourceManager.getIncomeSourcesByEnrollmentId(enrollmentId);
			return incomeSourceDTOs;
		} else {
			List<IncomeSourceDTO> incomeSourceDTOs = IncomeSourceManager.getIncomeSourcesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return incomeSourceDTOs;
		}
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
	public IncomeSourceDTO createIncomeSource(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, IncomeSourceDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		IncomeSourceDTO outputVO = IncomeSourceManager.addIncomeSource(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/income-sources/{incomeSourceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public IncomeSourceDTO updateIncomeSource(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("incomeSourceId") String incomeSourceId, IncomeSourceDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<NonCashBenefitDTO> getNonCashBenefits(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<NonCashBenefitDTO> nonCashBenefitDTOs = NonCashBenefitManager.getNonCashBenefitsByEnrollmentId(enrollmentId);
			return nonCashBenefitDTOs;
		} else {
			List<NonCashBenefitDTO> nonCashBenefitDTOs = NonCashBenefitManager.getNonCashBenefitsByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return nonCashBenefitDTOs;
		}
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
	public NonCashBenefitDTO createNonCashBenefit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, NonCashBenefitDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		NonCashBenefitDTO outputVO = NonCashBenefitManager.addNonCashBenefit(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/noncash-benefits/{nonCashBenefitId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public NonCashBenefitDTO createNonCashBenefit(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("nonCashBenefitId") String nonCashBenefitId, NonCashBenefitDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<PhysicalDisabilityDTO> getPhysicalDisabilities(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<PhysicalDisabilityDTO> physicalDisabilityDTOs = PhysicalDisabilityManager.getPhysicalDisabilitiesByEnrollmentId(enrollmentId);
			return physicalDisabilityDTOs;
		} else {
			List<PhysicalDisabilityDTO> physicalDisabilityDTOs = PhysicalDisabilityManager.getPhysicalDisabilitiesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return physicalDisabilityDTOs;
		}
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
	public PhysicalDisabilityDTO createPhysicalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, PhysicalDisabilityDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		PhysicalDisabilityDTO outputVO = PhysicalDisabilityManager.addPhysicalDisability(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/physical-disabilities/{physicalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PhysicalDisabilityDTO updatePhysicalDisability(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("physicalDisabilityId") String physicalDisabilityId, PhysicalDisabilityDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<ReferralDTO> getReferrals(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<ReferralDTO> referralDTOs = ReferralManager.getReferralsByEnrollmentId(enrollmentId);
			return referralDTOs;
		} else {
			List<ReferralDTO> referralDTOs = ReferralManager.getReferralsByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return referralDTOs;
		}
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
	public ReferralDTO createReferral(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, ReferralDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		ReferralDTO outputVO = ReferralManager.addReferral(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/referrals/{referralId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ReferralDTO updateReferral(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("referralId") String referralId, ReferralDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<ServiceDTO> getServices(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<ServiceDTO> serviceDTOs = ServiceManager.getServicesByEnrollmentId(enrollmentId);
			return serviceDTOs;
		} else {
			List<ServiceDTO> serviceDTOs = ServiceManager.getServicesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return serviceDTOs;
		}
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
	public ServiceDTO createService(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, ServiceDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		ServiceDTO outputVO = ServiceManager.addService(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/services/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ServiceDTO updateService(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("serviceId") String serviceId, ServiceDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
	public List<SubstanceAbuseDTO> getSubstanceAbuses(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @QueryParam("updatedSince") String updatedSince) throws JsonProcessingException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");

		// If the user specified no updatedSince parameter, return everything
		if(updatedSince == null) {
			List<SubstanceAbuseDTO> substanceAbuseDTOs = SubstanceAbuseManager.getSubstanceAbusesByEnrollmentId(enrollmentId);
			return substanceAbuseDTOs;
		} else {
			List<SubstanceAbuseDTO> substanceAbuseDTOs = SubstanceAbuseManager.getSubstanceAbusesByEnrollmentId(enrollmentId, DateParser.parseDate(updatedSince));
			return substanceAbuseDTOs;
		}
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
	public SubstanceAbuseDTO createSubstanceAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, SubstanceAbuseDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
		inputVO.setEnrollmentId(enrollmentId);
		SubstanceAbuseDTO outputVO = SubstanceAbuseManager.addSubstanceAbuse(inputVO);
		return outputVO;
	}
	
	@PUT
	@Path("/{enrollmentId}/substance-abuses/{substanceAbuseId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public SubstanceAbuseDTO updateSubstanceAbuse(@HeaderParam("Authorization") String authorization, @PathParam("enrollmentId") String enrollmentId, @PathParam("substanceAbuseId") String substanceAbuseId, SubstanceAbuseDTO inputVO) throws IOException {
		if(!Authentication.googleAuthenticate(authorization))
			throw new Error("You are not authorized to access this content");
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
