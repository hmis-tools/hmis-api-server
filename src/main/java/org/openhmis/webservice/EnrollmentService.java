package org.openhmis.webservice;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Path("/enrollments")
public class EnrollmentService {
	private static final ObjectMapper om = new ObjectMapper();
	private static final EnrollmentManager enrollmentManager = new EnrollmentManager();

	private static final ChronicHealthConditionManager chronicHealthConditionManager = new ChronicHealthConditionManager();
	private static final ContactManager contactManager = new ContactManager();
	private static final DevelopmentalDisabilityManager developmentalDisabilityManager = new DevelopmentalDisabilityManager();
	private static final DomesticAbuseManager domesticAbuseManager = new DomesticAbuseManager();
	private static final ExitManager exitManager = new ExitManager();
	private static final FinancialAssistanceManager financialAssistanceManager = new FinancialAssistanceManager();
	private static final HealthInsuranceManager healthInsuranceManager = new HealthInsuranceManager();
	private static final HivAidsStatusManager hivAidsStatusManager = new HivAidsStatusManager();
	private static final IncomeSourceManager incomeSourceManager = new IncomeSourceManager();
	private static final MedicalAssistanceManager medicalAssistanceManager = new MedicalAssistanceManager();
	private static final MentalHealthProblemManager mentalHealthProblemManager = new MentalHealthProblemManager();
	private static final NonCashBenefitManager nonCashBenefitManager = new NonCashBenefitManager();
	private static final PhysicalDisabilityManager physicalDisabilityManager = new PhysicalDisabilityManager();
	private static final ReferralManager referralManager = new ReferralManager();
	private static final ServiceManager serviceManager = new ServiceManager();
	private static final SubstanceAbuseManager substanceAbuseManager = new SubstanceAbuseManager();
	
	public EnrollmentService() {}


	/* Enrollment Entity Endpoints */
	
	@GET
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public String getEnrollments() throws JsonProcessingException {
		List<EnrollmentDTO> enrollmentDTOs = enrollmentManager.getEnrollments();
		return om.writeValueAsString(enrollmentDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getClient(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		EnrollmentDTO enrollmentDTO = enrollmentManager.getEnrollmentById(enrollmentId);
		return om.writeValueAsString(enrollmentDTO);
	}

	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public String createEnrollment(String data) throws JsonParseException, JsonMappingException, IOException {
		// This endpoint takes in a raw json STRING as input.
		// TODO: support the serialization of individual POST parameters
		EnrollmentDTO inputVO = om.readValue(data, EnrollmentDTO.class);
		EnrollmentDTO outputVO = enrollmentManager.addEnrollment(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateEnrollment(@PathParam("enrollmentId") String enrollmentId, String data) throws JsonParseException, JsonMappingException, IOException {
		EnrollmentDTO inputVO = om.readValue(data, EnrollmentDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		
		EnrollmentDTO outputVO = enrollmentManager.updateEnrollment(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteEnrollment(@PathParam("enrollmentId") String enrollmentId) throws JsonParseException, JsonMappingException, IOException {
		enrollmentManager.deleteEnrollment(enrollmentId);
		return "true";
	}
	
	
	/* Exit Endpoints */
	@GET
	@Path("/{enrollmentId}/exits")
	@Produces({MediaType.APPLICATION_JSON})
	public String getExits(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<ExitDTO> exitDTOs = exitManager.getExitsByEnrollmentId(enrollmentId);
		return om.writeValueAsString(exitDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/exits/{exitId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getExit(@PathParam("enrollmentId") String enrollmentId, @PathParam("exitId") String exitId) throws JsonProcessingException {
		ExitDTO exitDTO = exitManager.getExitById(exitId);
		return om.writeValueAsString(exitDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/exits")
	@Produces({MediaType.APPLICATION_JSON})
	public String createExit(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		ExitDTO inputVO = om.readValue(data, ExitDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ExitDTO outputVO = exitManager.addExit(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/exits/{exitId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateExit(@PathParam("enrollmentId") String enrollmentId, @PathParam("exitId") String exitId, String data) throws IOException {
		ExitDTO inputVO = om.readValue(data, ExitDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setExitId(exitId);

		ExitDTO outputVO = exitManager.updateExit(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/exits/{exitId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteExit(@PathParam("enrollmentId") String enrollmentId,  @PathParam("exitId") String exitId) throws JsonParseException, JsonMappingException, IOException {
		exitManager.deleteExit(exitId);
		return "true";
	}


	/* Chronic Health Condition Endpoints */
	@GET
	@Path("/{enrollmentId}/chronic-health-conditions")
	@Produces({MediaType.APPLICATION_JSON})
	public String getChronicHealthConditions(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<ChronicHealthConditionDTO> chronicHealthConditionDTOs = chronicHealthConditionManager.getChronicHealthConditionsByEnrollmentId(enrollmentId);
		return om.writeValueAsString(chronicHealthConditionDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/chronic-health-conditions/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getChronicHealthCondition(@PathParam("enrollmentId") String enrollmentId, @PathParam("chronicHealthConditionId") String chronicHealthConditionId) throws JsonProcessingException {
		ChronicHealthConditionDTO chronicHealthConditionDTO = chronicHealthConditionManager.getChronicHealthConditionById(chronicHealthConditionId);
		return om.writeValueAsString(chronicHealthConditionDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/chronic-health-conditions")
	@Produces({MediaType.APPLICATION_JSON})
	public String createChronicHealthCondition(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		ChronicHealthConditionDTO inputVO = om.readValue(data, ChronicHealthConditionDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ChronicHealthConditionDTO outputVO = chronicHealthConditionManager.addChronicHealthCondition(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/chronic-health-conditions/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateChronicHealthCondition(@PathParam("enrollmentId") String enrollmentId, @PathParam("chronicHealthConditionId") String chronicHealthConditionId, String data) throws IOException {
		ChronicHealthConditionDTO inputVO = om.readValue(data, ChronicHealthConditionDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setChronicHealthConditionId(chronicHealthConditionId);

		ChronicHealthConditionDTO outputVO = chronicHealthConditionManager.updateChronicHealthCondition(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/chronic-health-conditions/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteChronicHealthCondition(@PathParam("enrollmentId") String enrollmentId,  @PathParam("chronicHealthConditionId") String chronicHealthConditionId) throws JsonParseException, JsonMappingException, IOException {
		chronicHealthConditionManager.deleteChronicHealthCondition(chronicHealthConditionId);
		return "true";
	}


	/* Contact Endpoints */
	@GET
	@Path("/{enrollmentId}/contacts")
	@Produces({MediaType.APPLICATION_JSON})
	public String getContacts(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<ContactDTO> contactDTOs = contactManager.getContactsByEnrollmentId(enrollmentId);
		return om.writeValueAsString(contactDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/contacts/{contactId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getContact(@PathParam("enrollmentId") String enrollmentId, @PathParam("contactId") String contactId) throws JsonProcessingException {
		ContactDTO contactDTO = contactManager.getContactById(contactId);
		return om.writeValueAsString(contactDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/contacts")
	@Produces({MediaType.APPLICATION_JSON})
	public String createContact(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		ContactDTO inputVO = om.readValue(data, ContactDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ContactDTO outputVO = contactManager.addContact(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/contacts/{contactId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateContact(@PathParam("enrollmentId") String enrollmentId, @PathParam("contactId") String contactId, String data) throws IOException {
		ContactDTO inputVO = om.readValue(data, ContactDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setContactId(contactId);

		ContactDTO outputVO = contactManager.updateContact(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/contacts/{contactId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteContact(@PathParam("enrollmentId") String enrollmentId,  @PathParam("contactId") String contactId) throws JsonParseException, JsonMappingException, IOException {
		contactManager.deleteContact(contactId);
		return "true";
	}


	/* Developmental Disability Endpoints */
	@GET
	@Path("/{enrollmentId}/developmental-disabilitys")
	@Produces({MediaType.APPLICATION_JSON})
	public String getDevelopmentalDisabilitys(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<DevelopmentalDisabilityDTO> developmentalDisabilityDTOs = developmentalDisabilityManager.getDevelopmentalDisabilitysByEnrollmentId(enrollmentId);
		return om.writeValueAsString(developmentalDisabilityDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/developmental-disabilitys/{developmentalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getDevelopmentalDisability(@PathParam("enrollmentId") String enrollmentId, @PathParam("developmentalDisabilityId") String developmentalDisabilityId) throws JsonProcessingException {
		DevelopmentalDisabilityDTO developmentalDisabilityDTO = developmentalDisabilityManager.getDevelopmentalDisabilityById(developmentalDisabilityId);
		return om.writeValueAsString(developmentalDisabilityDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/developmental-disabilitys")
	@Produces({MediaType.APPLICATION_JSON})
	public String createDevelopmentalDisability(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		DevelopmentalDisabilityDTO inputVO = om.readValue(data, DevelopmentalDisabilityDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		DevelopmentalDisabilityDTO outputVO = developmentalDisabilityManager.addDevelopmentalDisability(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/developmental-disabilitys/{developmentalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateDevelopmentalDisability(@PathParam("enrollmentId") String enrollmentId, @PathParam("developmentalDisabilityId") String developmentalDisabilityId, String data) throws IOException {
		DevelopmentalDisabilityDTO inputVO = om.readValue(data, DevelopmentalDisabilityDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setDevelopmentalDisabilityId(developmentalDisabilityId);

		DevelopmentalDisabilityDTO outputVO = developmentalDisabilityManager.updateDevelopmentalDisability(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/developmental-disabilitys/{developmentalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteDevelopmentalDisability(@PathParam("enrollmentId") String enrollmentId,  @PathParam("developmentalDisabilityId") String developmentalDisabilityId) throws JsonParseException, JsonMappingException, IOException {
		developmentalDisabilityManager.deleteDevelopmentalDisability(developmentalDisabilityId);
		return "true";
	}


	/* Domestic Abuse Endpoints */
	@GET
	@Path("/{enrollmentId}/domestic-abuses")
	@Produces({MediaType.APPLICATION_JSON})
	public String getDomesticAbuses(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<DomesticAbuseDTO> domesticAbuseDTOs = domesticAbuseManager.getDomesticAbusesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(domesticAbuseDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/domestic-abuses/{domesticAbuseId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getDomesticAbuse(@PathParam("enrollmentId") String enrollmentId, @PathParam("domesticAbuseId") String domesticAbuseId) throws JsonProcessingException {
		DomesticAbuseDTO domesticAbuseDTO = domesticAbuseManager.getDomesticAbuseById(domesticAbuseId);
		return om.writeValueAsString(domesticAbuseDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/domestic-abuses")
	@Produces({MediaType.APPLICATION_JSON})
	public String createDomesticAbuse(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		DomesticAbuseDTO inputVO = om.readValue(data, DomesticAbuseDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		DomesticAbuseDTO outputVO = domesticAbuseManager.addDomesticAbuse(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/domestic-abuses/{domesticAbuseId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateDomesticAbuse(@PathParam("enrollmentId") String enrollmentId, @PathParam("domesticAbuseId") String domesticAbuseId, String data) throws IOException {
		DomesticAbuseDTO inputVO = om.readValue(data, DomesticAbuseDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setDomesticAbuseId(domesticAbuseId);

		DomesticAbuseDTO outputVO = domesticAbuseManager.updateDomesticAbuse(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/domestic-abuses/{domesticAbuseId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteDomesticAbuse(@PathParam("enrollmentId") String enrollmentId,  @PathParam("domesticAbuseId") String domesticAbuseId) throws JsonParseException, JsonMappingException, IOException {
		domesticAbuseManager.deleteDomesticAbuse(domesticAbuseId);
		return "true";
	}


	/* Financial Assistance Endpoints */
	@GET
	@Path("/{enrollmentId}/financial-assitances")
	@Produces({MediaType.APPLICATION_JSON})
	public String getFinancialAssistances(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<FinancialAssistanceDTO> financialAssistanceDTOs = financialAssistanceManager.getFinancialAssistancesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(financialAssistanceDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/financial-assitances/{financialAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getFinancialAssistance(@PathParam("enrollmentId") String enrollmentId, @PathParam("financialAssistanceId") String financialAssistanceId) throws JsonProcessingException {
		FinancialAssistanceDTO financialAssistanceDTO = financialAssistanceManager.getFinancialAssistanceById(financialAssistanceId);
		return om.writeValueAsString(financialAssistanceDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/financial-assitances")
	@Produces({MediaType.APPLICATION_JSON})
	public String createFinancialAssistance(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		FinancialAssistanceDTO inputVO = om.readValue(data, FinancialAssistanceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		FinancialAssistanceDTO outputVO = financialAssistanceManager.addFinancialAssistance(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/financial-assitances/{financialAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateFinancialAssistance(@PathParam("enrollmentId") String enrollmentId, @PathParam("financialAssistanceId") String financialAssistanceId, String data) throws IOException {
		FinancialAssistanceDTO inputVO = om.readValue(data, FinancialAssistanceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setFinancialAssistanceId(financialAssistanceId);

		FinancialAssistanceDTO outputVO = financialAssistanceManager.updateFinancialAssistance(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/financial-assitances/{financialAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteFinancialAssistance(@PathParam("enrollmentId") String enrollmentId,  @PathParam("financialAssistanceId") String financialAssistanceId) throws JsonParseException, JsonMappingException, IOException {
		financialAssistanceManager.deleteFinancialAssistance(financialAssistanceId);
		return "true";
	}

	/* Health Insurance Endpoints */
	@GET
	@Path("/{enrollmentId}/health-insurances")
	@Produces({MediaType.APPLICATION_JSON})
	public String getHealthInsurances(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<HealthInsuranceDTO> healthInsuranceDTOs = healthInsuranceManager.getHealthInsurancesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(healthInsuranceDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/health-insurances/{healthInsuranceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getHealthInsurance(@PathParam("enrollmentId") String enrollmentId, @PathParam("healthInsuranceId") String healthInsuranceId) throws JsonProcessingException {
		HealthInsuranceDTO healthInsuranceDTO = healthInsuranceManager.getHealthInsuranceById(healthInsuranceId);
		return om.writeValueAsString(healthInsuranceDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/health-insurances")
	@Produces({MediaType.APPLICATION_JSON})
	public String createHealthInsurance(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		HealthInsuranceDTO inputVO = om.readValue(data, HealthInsuranceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		HealthInsuranceDTO outputVO = healthInsuranceManager.addHealthInsurance(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/health-insurances/{healthInsuranceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateHealthInsurance(@PathParam("enrollmentId") String enrollmentId, @PathParam("healthInsuranceId") String healthInsuranceId, String data) throws IOException {
		HealthInsuranceDTO inputVO = om.readValue(data, HealthInsuranceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setHealthInsuranceId(healthInsuranceId);

		HealthInsuranceDTO outputVO = healthInsuranceManager.updateHealthInsurance(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/health-insurances/{healthInsuranceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteHealthInsurance(@PathParam("enrollmentId") String enrollmentId,  @PathParam("healthInsuranceId") String healthInsuranceId) throws JsonParseException, JsonMappingException, IOException {
		healthInsuranceManager.deleteHealthInsurance(healthInsuranceId);
		return "true";
	}

	/* HIV Aids Endpoints */
	@GET
	@Path("/{enrollmentId}/hiv-aids-statuses")
	@Produces({MediaType.APPLICATION_JSON})
	public String getHivAidsStatuses(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<HivAidsStatusDTO> hivAidsStatusDTOs = hivAidsStatusManager.getHivAidsStatusesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(hivAidsStatusDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/hiv-aids-statuses/{hivAidsStatusId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getHivAidsStatus(@PathParam("enrollmentId") String enrollmentId, @PathParam("hivAidsStatusId") String hivAidsStatusId) throws JsonProcessingException {
		HivAidsStatusDTO hivAidsStatusDTO = hivAidsStatusManager.getHivAidsStatusById(hivAidsStatusId);
		return om.writeValueAsString(hivAidsStatusDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/hiv-aids-statuses")
	@Produces({MediaType.APPLICATION_JSON})
	public String createHivAidsStatus(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		HivAidsStatusDTO inputVO = om.readValue(data, HivAidsStatusDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		HivAidsStatusDTO outputVO = hivAidsStatusManager.addHivAidsStatus(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/hiv-aids-statuses/{hivAidsStatusId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateHivAidsStatus(@PathParam("enrollmentId") String enrollmentId, @PathParam("hivAidsStatusId") String hivAidsStatusId, String data) throws IOException {
		HivAidsStatusDTO inputVO = om.readValue(data, HivAidsStatusDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setHivAidsStatusId(hivAidsStatusId);

		HivAidsStatusDTO outputVO = hivAidsStatusManager.updateHivAidsStatus(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/hiv-aids-statuses/{hivAidsStatusId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteHivAidsStatus(@PathParam("enrollmentId") String enrollmentId,  @PathParam("hivAidsStatusId") String hivAidsStatusId) throws JsonParseException, JsonMappingException, IOException {
		hivAidsStatusManager.deleteHivAidsStatus(hivAidsStatusId);
		return "true";
	}

	/* Medical Assistance Endpoints */
	@GET
	@Path("/{enrollmentId}/medical-assistances")
	@Produces({MediaType.APPLICATION_JSON})
	public String getMedicalAssistances(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<MedicalAssistanceDTO> medicalAssistanceDTOs = medicalAssistanceManager.getMedicalAssistancesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(medicalAssistanceDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/medical-assistances/{medicalAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getMedicalAssistance(@PathParam("enrollmentId") String enrollmentId, @PathParam("medicalAssistanceId") String medicalAssistanceId) throws JsonProcessingException {
		MedicalAssistanceDTO medicalAssistanceDTO = medicalAssistanceManager.getMedicalAssistanceById(medicalAssistanceId);
		return om.writeValueAsString(medicalAssistanceDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/medical-assistances")
	@Produces({MediaType.APPLICATION_JSON})
	public String createMedicalAssistance(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		MedicalAssistanceDTO inputVO = om.readValue(data, MedicalAssistanceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		MedicalAssistanceDTO outputVO = medicalAssistanceManager.addMedicalAssistance(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/medical-assistances/{medicalAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateMedicalAssistance(@PathParam("enrollmentId") String enrollmentId, @PathParam("medicalAssistanceId") String medicalAssistanceId, String data) throws IOException {
		MedicalAssistanceDTO inputVO = om.readValue(data, MedicalAssistanceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setMedicalAssistanceId(medicalAssistanceId);

		MedicalAssistanceDTO outputVO = medicalAssistanceManager.updateMedicalAssistance(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/medical-assistances/{medicalAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteMedicalAssistance(@PathParam("enrollmentId") String enrollmentId,  @PathParam("medicalAssistanceId") String medicalAssistanceId) throws JsonParseException, JsonMappingException, IOException {
		medicalAssistanceManager.deleteMedicalAssistance(medicalAssistanceId);
		return "true";
	}

	/* Income Source Endpoints */
	@GET
	@Path("/{enrollmentId}/income-sources")
	@Produces({MediaType.APPLICATION_JSON})
	public String getIncomeSources(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<IncomeSourceDTO> incomeSourceDTOs = incomeSourceManager.getIncomeSourcesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(incomeSourceDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/income-sources/{incomeSourceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getIncomeSource(@PathParam("enrollmentId") String enrollmentId, @PathParam("incomeSourceId") String incomeSourceId) throws JsonProcessingException {
		IncomeSourceDTO incomeSourceDTO = incomeSourceManager.getIncomeSourceById(incomeSourceId);
		return om.writeValueAsString(incomeSourceDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/income-sources")
	@Produces({MediaType.APPLICATION_JSON})
	public String createIncomeSource(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		IncomeSourceDTO inputVO = om.readValue(data, IncomeSourceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		IncomeSourceDTO outputVO = incomeSourceManager.addIncomeSource(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/income-sources/{incomeSourceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateIncomeSource(@PathParam("enrollmentId") String enrollmentId, @PathParam("incomeSourceId") String incomeSourceId, String data) throws IOException {
		IncomeSourceDTO inputVO = om.readValue(data, IncomeSourceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setIncomeSourceId(incomeSourceId);

		IncomeSourceDTO outputVO = incomeSourceManager.updateIncomeSource(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/income-sources/{incomeSourceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteIncomeSource(@PathParam("enrollmentId") String enrollmentId,  @PathParam("incomeSourceId") String incomeSourceId) throws JsonParseException, JsonMappingException, IOException {
		incomeSourceManager.deleteIncomeSource(incomeSourceId);
		return "true";
	}

	/* NonCash Benefit Endpoints */
	@GET
	@Path("/{enrollmentId}/noncash-benefits")
	@Produces({MediaType.APPLICATION_JSON})
	public String getNonCashBenefits(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<NonCashBenefitDTO> nonCashBenefitDTOs = nonCashBenefitManager.getNonCashBenefitsByEnrollmentId(enrollmentId);
		return om.writeValueAsString(nonCashBenefitDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/noncash-benefits/{nonCashBenefitId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getNonCashBenefit(@PathParam("enrollmentId") String enrollmentId, @PathParam("nonCashBenefitId") String nonCashBenefitId) throws JsonProcessingException {
		NonCashBenefitDTO nonCashBenefitDTO = nonCashBenefitManager.getNonCashBenefitById(nonCashBenefitId);
		return om.writeValueAsString(nonCashBenefitDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/noncash-benefits")
	@Produces({MediaType.APPLICATION_JSON})
	public String createNonCashBenefit(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		NonCashBenefitDTO inputVO = om.readValue(data, NonCashBenefitDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		NonCashBenefitDTO outputVO = nonCashBenefitManager.addNonCashBenefit(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/noncash-benefits/{nonCashBenefitId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String createNonCashBenefit(@PathParam("enrollmentId") String enrollmentId, @PathParam("nonCashBenefitId") String nonCashBenefitId, String data) throws IOException {
		NonCashBenefitDTO inputVO = om.readValue(data, NonCashBenefitDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setNonCashBenefitId(nonCashBenefitId);

		NonCashBenefitDTO outputVO = nonCashBenefitManager.updateNonCashBenefit(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/noncash-benefits/{nonCashBenefitId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteNonCashBenefit(@PathParam("enrollmentId") String enrollmentId,  @PathParam("nonCashBenefitId") String nonCashBenefitId) throws JsonParseException, JsonMappingException, IOException {
		nonCashBenefitManager.deleteNonCashBenefit(nonCashBenefitId);
		return "true";
	}

	/* Physical Disability Endpoints */
	@GET
	@Path("/{enrollmentId}/physical-disabilities")
	@Produces({MediaType.APPLICATION_JSON})
	public String getPhysicalDisabilities(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<PhysicalDisabilityDTO> physicalDisabilityDTOs = physicalDisabilityManager.getPhysicalDisabilitiesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(physicalDisabilityDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/physical-disabilities/{physicalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getPhysicalDisability(@PathParam("enrollmentId") String enrollmentId, @PathParam("physicalDisabilityId") String physicalDisabilityId) throws JsonProcessingException {
		PhysicalDisabilityDTO physicalDisabilityDTO = physicalDisabilityManager.getPhysicalDisabilityById(physicalDisabilityId);
		return om.writeValueAsString(physicalDisabilityDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/physical-disabilities")
	@Produces({MediaType.APPLICATION_JSON})
	public String createPhysicalDisability(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		PhysicalDisabilityDTO inputVO = om.readValue(data, PhysicalDisabilityDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		PhysicalDisabilityDTO outputVO = physicalDisabilityManager.addPhysicalDisability(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/physical-disabilities/{physicalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updatePhysicalDisability(@PathParam("enrollmentId") String enrollmentId, @PathParam("physicalDisabilityId") String physicalDisabilityId, String data) throws IOException {
		PhysicalDisabilityDTO inputVO = om.readValue(data, PhysicalDisabilityDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setPhysicalDisabilityId(physicalDisabilityId);

		PhysicalDisabilityDTO outputVO = physicalDisabilityManager.updatePhysicalDisability(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/physical-disabilities/{physicalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deletePhysicalDisability(@PathParam("enrollmentId") String enrollmentId,  @PathParam("physicalDisabilityId") String physicalDisabilityId) throws JsonParseException, JsonMappingException, IOException {
		physicalDisabilityManager.deletePhysicalDisability(physicalDisabilityId);
		return "true";
	}

	/* Referral Endpoints */
	@GET
	@Path("/{enrollmentId}/referrals")
	@Produces({MediaType.APPLICATION_JSON})
	public String getReferrals(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<ReferralDTO> referralDTOs = referralManager.getReferralsByEnrollmentId(enrollmentId);
		return om.writeValueAsString(referralDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/referrals/{referralId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getReferral(@PathParam("enrollmentId") String enrollmentId, @PathParam("referralId") String referralId) throws JsonProcessingException {
		ReferralDTO referralDTO = referralManager.getReferralById(referralId);
		return om.writeValueAsString(referralDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/referrals")
	@Produces({MediaType.APPLICATION_JSON})
	public String createReferral(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		ReferralDTO inputVO = om.readValue(data, ReferralDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ReferralDTO outputVO = referralManager.addReferral(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/referrals/{referralId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateReferral(@PathParam("enrollmentId") String enrollmentId, @PathParam("referralId") String referralId, String data) throws IOException {
		ReferralDTO inputVO = om.readValue(data, ReferralDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setReferralId(referralId);

		ReferralDTO outputVO = referralManager.updateReferral(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/referrals/{referralId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteReferral(@PathParam("enrollmentId") String enrollmentId,  @PathParam("referralId") String referralId) throws JsonParseException, JsonMappingException, IOException {
		referralManager.deleteReferral(referralId);
		return "true";
	}

	/* Service Endpoints */
	@GET
	@Path("/{enrollmentId}/services")
	@Produces({MediaType.APPLICATION_JSON})
	public String getServices(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<ServiceDTO> serviceDTOs = serviceManager.getServicesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(serviceDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/services/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getService(@PathParam("enrollmentId") String enrollmentId, @PathParam("serviceId") String serviceId) throws JsonProcessingException {
		ServiceDTO serviceDTO = serviceManager.getServiceById(serviceId);
		return om.writeValueAsString(serviceDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/services")
	@Produces({MediaType.APPLICATION_JSON})
	public String createService(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		ServiceDTO inputVO = om.readValue(data, ServiceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ServiceDTO outputVO = serviceManager.addService(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/services/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateService(@PathParam("enrollmentId") String enrollmentId, @PathParam("serviceId") String serviceId, String data) throws IOException {
		ServiceDTO inputVO = om.readValue(data, ServiceDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setServiceId(serviceId);

		ServiceDTO outputVO = serviceManager.updateService(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/services/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteService(@PathParam("enrollmentId") String enrollmentId,  @PathParam("serviceId") String serviceId) throws JsonParseException, JsonMappingException, IOException {
		serviceManager.deleteService(serviceId);
		return "true";
	}

	/* Substance Abuse Endpoints */
	@GET
	@Path("/{enrollmentId}/substance-abuses")
	@Produces({MediaType.APPLICATION_JSON})
	public String getSubstanceAbuses(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		List<SubstanceAbuseDTO> substanceAbuseDTOs = substanceAbuseManager.getSubstanceAbusesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(substanceAbuseDTOs);
	}
	
	@GET
	@Path("/{enrollmentId}/substance-abuses/{substanceAbuseId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getSubstanceAbuse(@PathParam("enrollmentId") String enrollmentId, @PathParam("substanceAbuseId") String substanceAbuseId) throws JsonProcessingException {
		SubstanceAbuseDTO substanceAbuseDTO = substanceAbuseManager.getSubstanceAbuseById(substanceAbuseId);
		return om.writeValueAsString(substanceAbuseDTO);
	}
	
	@POST
	@Path("/{enrollmentId}/substance-abuses")
	@Produces({MediaType.APPLICATION_JSON})
	public String createSubstanceAbuse(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		SubstanceAbuseDTO inputVO = om.readValue(data, SubstanceAbuseDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		SubstanceAbuseDTO outputVO = substanceAbuseManager.addSubstanceAbuse(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/substance-abuses/{substanceAbuseId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateSubstanceAbuse(@PathParam("enrollmentId") String enrollmentId, @PathParam("substanceAbuseId") String substanceAbuseId, String data) throws IOException {
		SubstanceAbuseDTO inputVO = om.readValue(data, SubstanceAbuseDTO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setSubstanceAbuseId(substanceAbuseId);

		SubstanceAbuseDTO outputVO = substanceAbuseManager.updateSubstanceAbuse(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@DELETE
	@Path("/{enrollmentId}/substance-abuses/{substanceAbuseId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String deleteSubstanceAbuse(@PathParam("enrollmentId") String enrollmentId,  @PathParam("substanceAbuseId") String substanceAbuseId) throws JsonParseException, JsonMappingException, IOException {
		substanceAbuseManager.deleteSubstanceAbuse(substanceAbuseId);
		return "true";
	}


}
