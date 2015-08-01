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
import org.openhmis.vo.ChronicHealthConditionVO;
import org.openhmis.vo.ContactVO;
import org.openhmis.vo.DevelopmentalDisabilityVO;
import org.openhmis.vo.DomesticAbuseVO;
import org.openhmis.vo.EnrollmentVO;
import org.openhmis.vo.ExitVO;
import org.openhmis.vo.FinancialAssistanceVO;
import org.openhmis.vo.HealthInsuranceVO;
import org.openhmis.vo.HivAidsStatusVO;
import org.openhmis.vo.IncomeSourceVO;
import org.openhmis.vo.MedicalAssistanceVO;
import org.openhmis.vo.NonCashBenefitVO;
import org.openhmis.vo.PhysicalDisabilityVO;
import org.openhmis.vo.ReferralVO;
import org.openhmis.vo.ServiceVO;
import org.openhmis.vo.SubstanceAbuseVO;

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
		List<EnrollmentVO> enrollmentVOs = enrollmentManager.getEnrollments();
		return om.writeValueAsString(enrollmentVOs);
	}
	
	@GET
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getClient(@PathParam("enrollmentId") String enrollmentId) throws JsonProcessingException {
		EnrollmentVO enrollmentVO = enrollmentManager.getEnrollmentById(enrollmentId);
		return om.writeValueAsString(enrollmentVO);
	}

	@POST
	@Path("/")
	@Produces({MediaType.APPLICATION_JSON})
	public String createEnrollment(String data) throws JsonParseException, JsonMappingException, IOException {
		// This endpoint takes in a raw json STRING as input.
		// TODO: support the serialization of individual POST parameters
		EnrollmentVO inputVO = om.readValue(data, EnrollmentVO.class);
		EnrollmentVO outputVO = enrollmentManager.addEnrollment(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateEnrollment(@PathParam("enrollmentId") String enrollmentId, String data) throws JsonParseException, JsonMappingException, IOException {
		EnrollmentVO inputVO = om.readValue(data, EnrollmentVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		
		EnrollmentVO outputVO = enrollmentManager.updateEnrollment(inputVO);
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
		List<ExitVO> exitVOs = exitManager.getExitsByEnrollmentId(enrollmentId);
		return om.writeValueAsString(exitVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/exits/{exitId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getExit(@PathParam("enrollmentId") String enrollmentId, @PathParam("exitId") String exitId) throws JsonProcessingException {
		ExitVO exitVO = exitManager.getExitById(exitId);
		return om.writeValueAsString(exitVO);
	}
	
	@POST
	@Path("/{enrollmentId}/exits")
	@Produces({MediaType.APPLICATION_JSON})
	public String createExit(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		ExitVO inputVO = om.readValue(data, ExitVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ExitVO outputVO = exitManager.addExit(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/exits/{exitId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateExit(@PathParam("enrollmentId") String enrollmentId, @PathParam("exitId") String exitId, String data) throws IOException {
		ExitVO inputVO = om.readValue(data, ExitVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setExitId(exitId);

		ExitVO outputVO = exitManager.updateExit(inputVO);
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
		List<ChronicHealthConditionVO> chronicHealthConditionVOs = chronicHealthConditionManager.getChronicHealthConditionsByEnrollmentId(enrollmentId);
		return om.writeValueAsString(chronicHealthConditionVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/chronic-health-conditions/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getChronicHealthCondition(@PathParam("enrollmentId") String enrollmentId, @PathParam("chronicHealthConditionId") String chronicHealthConditionId) throws JsonProcessingException {
		ChronicHealthConditionVO chronicHealthConditionVO = chronicHealthConditionManager.getChronicHealthConditionById(chronicHealthConditionId);
		return om.writeValueAsString(chronicHealthConditionVO);
	}
	
	@POST
	@Path("/{enrollmentId}/chronic-health-conditions")
	@Produces({MediaType.APPLICATION_JSON})
	public String createChronicHealthCondition(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		ChronicHealthConditionVO inputVO = om.readValue(data, ChronicHealthConditionVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ChronicHealthConditionVO outputVO = chronicHealthConditionManager.addChronicHealthCondition(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/chronic-health-conditions/{chronicHealthConditionId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateChronicHealthCondition(@PathParam("enrollmentId") String enrollmentId, @PathParam("chronicHealthConditionId") String chronicHealthConditionId, String data) throws IOException {
		ChronicHealthConditionVO inputVO = om.readValue(data, ChronicHealthConditionVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setChronicHealthConditionId(chronicHealthConditionId);

		ChronicHealthConditionVO outputVO = chronicHealthConditionManager.updateChronicHealthCondition(inputVO);
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
		List<ContactVO> contactVOs = contactManager.getContactsByEnrollmentId(enrollmentId);
		return om.writeValueAsString(contactVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/contacts/{contactId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getContact(@PathParam("enrollmentId") String enrollmentId, @PathParam("contactId") String contactId) throws JsonProcessingException {
		ContactVO contactVO = contactManager.getContactById(contactId);
		return om.writeValueAsString(contactVO);
	}
	
	@POST
	@Path("/{enrollmentId}/contacts")
	@Produces({MediaType.APPLICATION_JSON})
	public String createContact(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		ContactVO inputVO = om.readValue(data, ContactVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ContactVO outputVO = contactManager.addContact(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/contacts/{contactId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateContact(@PathParam("enrollmentId") String enrollmentId, @PathParam("contactId") String contactId, String data) throws IOException {
		ContactVO inputVO = om.readValue(data, ContactVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setContactId(contactId);

		ContactVO outputVO = contactManager.updateContact(inputVO);
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
		List<DevelopmentalDisabilityVO> developmentalDisabilityVOs = developmentalDisabilityManager.getDevelopmentalDisabilitysByEnrollmentId(enrollmentId);
		return om.writeValueAsString(developmentalDisabilityVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/developmental-disabilitys/{developmentalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getDevelopmentalDisability(@PathParam("enrollmentId") String enrollmentId, @PathParam("developmentalDisabilityId") String developmentalDisabilityId) throws JsonProcessingException {
		DevelopmentalDisabilityVO developmentalDisabilityVO = developmentalDisabilityManager.getDevelopmentalDisabilityById(developmentalDisabilityId);
		return om.writeValueAsString(developmentalDisabilityVO);
	}
	
	@POST
	@Path("/{enrollmentId}/developmental-disabilitys")
	@Produces({MediaType.APPLICATION_JSON})
	public String createDevelopmentalDisability(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		DevelopmentalDisabilityVO inputVO = om.readValue(data, DevelopmentalDisabilityVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		DevelopmentalDisabilityVO outputVO = developmentalDisabilityManager.addDevelopmentalDisability(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/developmental-disabilitys/{developmentalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateDevelopmentalDisability(@PathParam("enrollmentId") String enrollmentId, @PathParam("developmentalDisabilityId") String developmentalDisabilityId, String data) throws IOException {
		DevelopmentalDisabilityVO inputVO = om.readValue(data, DevelopmentalDisabilityVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setDevelopmentalDisabilityId(developmentalDisabilityId);

		DevelopmentalDisabilityVO outputVO = developmentalDisabilityManager.updateDevelopmentalDisability(inputVO);
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
		List<DomesticAbuseVO> domesticAbuseVOs = domesticAbuseManager.getDomesticAbusesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(domesticAbuseVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/domestic-abuses/{domesticAbuseId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getDomesticAbuse(@PathParam("enrollmentId") String enrollmentId, @PathParam("domesticAbuseId") String domesticAbuseId) throws JsonProcessingException {
		DomesticAbuseVO domesticAbuseVO = domesticAbuseManager.getDomesticAbuseById(domesticAbuseId);
		return om.writeValueAsString(domesticAbuseVO);
	}
	
	@POST
	@Path("/{enrollmentId}/domestic-abuses")
	@Produces({MediaType.APPLICATION_JSON})
	public String createDomesticAbuse(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		DomesticAbuseVO inputVO = om.readValue(data, DomesticAbuseVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		DomesticAbuseVO outputVO = domesticAbuseManager.addDomesticAbuse(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/domestic-abuses/{domesticAbuseId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateDomesticAbuse(@PathParam("enrollmentId") String enrollmentId, @PathParam("domesticAbuseId") String domesticAbuseId, String data) throws IOException {
		DomesticAbuseVO inputVO = om.readValue(data, DomesticAbuseVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setDomesticAbuseId(domesticAbuseId);

		DomesticAbuseVO outputVO = domesticAbuseManager.updateDomesticAbuse(inputVO);
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
		List<FinancialAssistanceVO> financialAssistanceVOs = financialAssistanceManager.getFinancialAssistancesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(financialAssistanceVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/financial-assitances/{financialAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getFinancialAssistance(@PathParam("enrollmentId") String enrollmentId, @PathParam("financialAssistanceId") String financialAssistanceId) throws JsonProcessingException {
		FinancialAssistanceVO financialAssistanceVO = financialAssistanceManager.getFinancialAssistanceById(financialAssistanceId);
		return om.writeValueAsString(financialAssistanceVO);
	}
	
	@POST
	@Path("/{enrollmentId}/financial-assitances")
	@Produces({MediaType.APPLICATION_JSON})
	public String createFinancialAssistance(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		FinancialAssistanceVO inputVO = om.readValue(data, FinancialAssistanceVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		FinancialAssistanceVO outputVO = financialAssistanceManager.addFinancialAssistance(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/financial-assitances/{financialAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateFinancialAssistance(@PathParam("enrollmentId") String enrollmentId, @PathParam("financialAssistanceId") String financialAssistanceId, String data) throws IOException {
		FinancialAssistanceVO inputVO = om.readValue(data, FinancialAssistanceVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setFinancialAssistanceId(financialAssistanceId);

		FinancialAssistanceVO outputVO = financialAssistanceManager.updateFinancialAssistance(inputVO);
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
		List<HealthInsuranceVO> healthInsuranceVOs = healthInsuranceManager.getHealthInsurancesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(healthInsuranceVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/health-insurances/{healthInsuranceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getHealthInsurance(@PathParam("enrollmentId") String enrollmentId, @PathParam("healthInsuranceId") String healthInsuranceId) throws JsonProcessingException {
		HealthInsuranceVO healthInsuranceVO = healthInsuranceManager.getHealthInsuranceById(healthInsuranceId);
		return om.writeValueAsString(healthInsuranceVO);
	}
	
	@POST
	@Path("/{enrollmentId}/health-insurances")
	@Produces({MediaType.APPLICATION_JSON})
	public String createHealthInsurance(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		HealthInsuranceVO inputVO = om.readValue(data, HealthInsuranceVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		HealthInsuranceVO outputVO = healthInsuranceManager.addHealthInsurance(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/health-insurances/{healthInsuranceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateHealthInsurance(@PathParam("enrollmentId") String enrollmentId, @PathParam("healthInsuranceId") String healthInsuranceId, String data) throws IOException {
		HealthInsuranceVO inputVO = om.readValue(data, HealthInsuranceVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setHealthInsuranceId(healthInsuranceId);

		HealthInsuranceVO outputVO = healthInsuranceManager.updateHealthInsurance(inputVO);
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
		List<HivAidsStatusVO> hivAidsStatusVOs = hivAidsStatusManager.getHivAidsStatusesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(hivAidsStatusVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/hiv-aids-statuses/{hivAidsStatusId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getHivAidsStatus(@PathParam("enrollmentId") String enrollmentId, @PathParam("hivAidsStatusId") String hivAidsStatusId) throws JsonProcessingException {
		HivAidsStatusVO hivAidsStatusVO = hivAidsStatusManager.getHivAidsStatusById(hivAidsStatusId);
		return om.writeValueAsString(hivAidsStatusVO);
	}
	
	@POST
	@Path("/{enrollmentId}/hiv-aids-statuses")
	@Produces({MediaType.APPLICATION_JSON})
	public String createHivAidsStatus(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		HivAidsStatusVO inputVO = om.readValue(data, HivAidsStatusVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		HivAidsStatusVO outputVO = hivAidsStatusManager.addHivAidsStatus(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/hiv-aids-statuses/{hivAidsStatusId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateHivAidsStatus(@PathParam("enrollmentId") String enrollmentId, @PathParam("hivAidsStatusId") String hivAidsStatusId, String data) throws IOException {
		HivAidsStatusVO inputVO = om.readValue(data, HivAidsStatusVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setHivAidsStatusId(hivAidsStatusId);

		HivAidsStatusVO outputVO = hivAidsStatusManager.updateHivAidsStatus(inputVO);
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
		List<MedicalAssistanceVO> medicalAssistanceVOs = medicalAssistanceManager.getMedicalAssistancesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(medicalAssistanceVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/medical-assistances/{medicalAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getMedicalAssistance(@PathParam("enrollmentId") String enrollmentId, @PathParam("medicalAssistanceId") String medicalAssistanceId) throws JsonProcessingException {
		MedicalAssistanceVO medicalAssistanceVO = medicalAssistanceManager.getMedicalAssistanceById(medicalAssistanceId);
		return om.writeValueAsString(medicalAssistanceVO);
	}
	
	@POST
	@Path("/{enrollmentId}/medical-assistances")
	@Produces({MediaType.APPLICATION_JSON})
	public String createMedicalAssistance(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		MedicalAssistanceVO inputVO = om.readValue(data, MedicalAssistanceVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		MedicalAssistanceVO outputVO = medicalAssistanceManager.addMedicalAssistance(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/medical-assistances/{medicalAssistanceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateMedicalAssistance(@PathParam("enrollmentId") String enrollmentId, @PathParam("medicalAssistanceId") String medicalAssistanceId, String data) throws IOException {
		MedicalAssistanceVO inputVO = om.readValue(data, MedicalAssistanceVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setMedicalAssistanceId(medicalAssistanceId);

		MedicalAssistanceVO outputVO = medicalAssistanceManager.updateMedicalAssistance(inputVO);
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
		List<IncomeSourceVO> incomeSourceVOs = incomeSourceManager.getIncomeSourcesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(incomeSourceVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/income-sources/{incomeSourceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getIncomeSource(@PathParam("enrollmentId") String enrollmentId, @PathParam("incomeSourceId") String incomeSourceId) throws JsonProcessingException {
		IncomeSourceVO incomeSourceVO = incomeSourceManager.getIncomeSourceById(incomeSourceId);
		return om.writeValueAsString(incomeSourceVO);
	}
	
	@POST
	@Path("/{enrollmentId}/income-sources")
	@Produces({MediaType.APPLICATION_JSON})
	public String createIncomeSource(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		IncomeSourceVO inputVO = om.readValue(data, IncomeSourceVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		IncomeSourceVO outputVO = incomeSourceManager.addIncomeSource(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/income-sources/{incomeSourceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateIncomeSource(@PathParam("enrollmentId") String enrollmentId, @PathParam("incomeSourceId") String incomeSourceId, String data) throws IOException {
		IncomeSourceVO inputVO = om.readValue(data, IncomeSourceVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setIncomeSourceId(incomeSourceId);

		IncomeSourceVO outputVO = incomeSourceManager.updateIncomeSource(inputVO);
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
		List<NonCashBenefitVO> nonCashBenefitVOs = nonCashBenefitManager.getNonCashBenefitsByEnrollmentId(enrollmentId);
		return om.writeValueAsString(nonCashBenefitVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/noncash-benefits/{nonCashBenefitId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getNonCashBenefit(@PathParam("enrollmentId") String enrollmentId, @PathParam("nonCashBenefitId") String nonCashBenefitId) throws JsonProcessingException {
		NonCashBenefitVO nonCashBenefitVO = nonCashBenefitManager.getNonCashBenefitById(nonCashBenefitId);
		return om.writeValueAsString(nonCashBenefitVO);
	}
	
	@POST
	@Path("/{enrollmentId}/noncash-benefits")
	@Produces({MediaType.APPLICATION_JSON})
	public String createNonCashBenefit(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		NonCashBenefitVO inputVO = om.readValue(data, NonCashBenefitVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		NonCashBenefitVO outputVO = nonCashBenefitManager.addNonCashBenefit(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/noncash-benefits/{nonCashBenefitId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String createNonCashBenefit(@PathParam("enrollmentId") String enrollmentId, @PathParam("nonCashBenefitId") String nonCashBenefitId, String data) throws IOException {
		NonCashBenefitVO inputVO = om.readValue(data, NonCashBenefitVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setNonCashBenefitId(nonCashBenefitId);

		NonCashBenefitVO outputVO = nonCashBenefitManager.updateNonCashBenefit(inputVO);
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
		List<PhysicalDisabilityVO> physicalDisabilityVOs = physicalDisabilityManager.getPhysicalDisabilitiesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(physicalDisabilityVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/physical-disabilities/{physicalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getPhysicalDisability(@PathParam("enrollmentId") String enrollmentId, @PathParam("physicalDisabilityId") String physicalDisabilityId) throws JsonProcessingException {
		PhysicalDisabilityVO physicalDisabilityVO = physicalDisabilityManager.getPhysicalDisabilityById(physicalDisabilityId);
		return om.writeValueAsString(physicalDisabilityVO);
	}
	
	@POST
	@Path("/{enrollmentId}/physical-disabilities")
	@Produces({MediaType.APPLICATION_JSON})
	public String createPhysicalDisability(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		PhysicalDisabilityVO inputVO = om.readValue(data, PhysicalDisabilityVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		PhysicalDisabilityVO outputVO = physicalDisabilityManager.addPhysicalDisability(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/physical-disabilities/{physicalDisabilityId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updatePhysicalDisability(@PathParam("enrollmentId") String enrollmentId, @PathParam("physicalDisabilityId") String physicalDisabilityId, String data) throws IOException {
		PhysicalDisabilityVO inputVO = om.readValue(data, PhysicalDisabilityVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setPhysicalDisabilityId(physicalDisabilityId);

		PhysicalDisabilityVO outputVO = physicalDisabilityManager.updatePhysicalDisability(inputVO);
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
		List<ReferralVO> referralVOs = referralManager.getReferralsByEnrollmentId(enrollmentId);
		return om.writeValueAsString(referralVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/referrals/{referralId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getReferral(@PathParam("enrollmentId") String enrollmentId, @PathParam("referralId") String referralId) throws JsonProcessingException {
		ReferralVO referralVO = referralManager.getReferralById(referralId);
		return om.writeValueAsString(referralVO);
	}
	
	@POST
	@Path("/{enrollmentId}/referrals")
	@Produces({MediaType.APPLICATION_JSON})
	public String createReferral(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		ReferralVO inputVO = om.readValue(data, ReferralVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ReferralVO outputVO = referralManager.addReferral(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/referrals/{referralId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateReferral(@PathParam("enrollmentId") String enrollmentId, @PathParam("referralId") String referralId, String data) throws IOException {
		ReferralVO inputVO = om.readValue(data, ReferralVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setReferralId(referralId);

		ReferralVO outputVO = referralManager.updateReferral(inputVO);
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
		List<ServiceVO> serviceVOs = serviceManager.getServicesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(serviceVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/services/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getService(@PathParam("enrollmentId") String enrollmentId, @PathParam("serviceId") String serviceId) throws JsonProcessingException {
		ServiceVO serviceVO = serviceManager.getServiceById(serviceId);
		return om.writeValueAsString(serviceVO);
	}
	
	@POST
	@Path("/{enrollmentId}/services")
	@Produces({MediaType.APPLICATION_JSON})
	public String createService(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		ServiceVO inputVO = om.readValue(data, ServiceVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		ServiceVO outputVO = serviceManager.addService(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/services/{serviceId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateService(@PathParam("enrollmentId") String enrollmentId, @PathParam("serviceId") String serviceId, String data) throws IOException {
		ServiceVO inputVO = om.readValue(data, ServiceVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setServiceId(serviceId);

		ServiceVO outputVO = serviceManager.updateService(inputVO);
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
		List<SubstanceAbuseVO> substanceAbuseVOs = substanceAbuseManager.getSubstanceAbusesByEnrollmentId(enrollmentId);
		return om.writeValueAsString(substanceAbuseVOs);
	}
	
	@GET
	@Path("/{enrollmentId}/substance-abuses/{substanceAbuseId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String getSubstanceAbuse(@PathParam("enrollmentId") String enrollmentId, @PathParam("substanceAbuseId") String substanceAbuseId) throws JsonProcessingException {
		SubstanceAbuseVO substanceAbuseVO = substanceAbuseManager.getSubstanceAbuseById(substanceAbuseId);
		return om.writeValueAsString(substanceAbuseVO);
	}
	
	@POST
	@Path("/{enrollmentId}/substance-abuses")
	@Produces({MediaType.APPLICATION_JSON})
	public String createSubstanceAbuse(@PathParam("enrollmentId") String enrollmentId, String data) throws IOException {
		SubstanceAbuseVO inputVO = om.readValue(data, SubstanceAbuseVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		SubstanceAbuseVO outputVO = substanceAbuseManager.addSubstanceAbuse(inputVO);
		return om.writeValueAsString(outputVO);
	}
	
	@PUT
	@Path("/{enrollmentId}/substance-abuses/{substanceAbuseId}")
	@Produces({MediaType.APPLICATION_JSON})
	public String updateSubstanceAbuse(@PathParam("enrollmentId") String enrollmentId, @PathParam("substanceAbuseId") String substanceAbuseId, String data) throws IOException {
		SubstanceAbuseVO inputVO = om.readValue(data, SubstanceAbuseVO.class);
		inputVO.setEnrollmentId(enrollmentId);
		inputVO.setSubstanceAbuseId(substanceAbuseId);

		SubstanceAbuseVO outputVO = substanceAbuseManager.updateSubstanceAbuse(inputVO);
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
